const MultiMap = require("collections/multi-map");

const fs = require("fs-promise");
const git = require("simple-git");
const path = require('path');
const svgConverter = require("./svg2vectordrawable");
const _ = require("underscore");

String.prototype.capitalizeFirstLetter = function () {
    return this.charAt(0).toUpperCase() + this.slice(1);
};

String.prototype.replaceAll = function (search, replacement) {
    return this.replace(new RegExp(search, 'g'), replacement);
};

async function run() {
    try {
        await fs.stat("build/emojione");

        console.log("Existing repo found. Pulling changes...");
        await git("build/emojione").pull();
    } catch (ignored) {
        console.log("Cloning repo...");
        await git().clone("https://github.com/Ranks/emojione", "build/emojione");
    }

    console.log("Converting and copying resources...");
    await fs.emptyDir("../library/src/main/res/drawable");

    for (const file of await fs.readdir("build/emojione/assets/svg")) {
        const svg = await fs.readFile("build/emojione/assets/svg/" + file, "utf-8");
        const vector = await svgConverter.svg2vectorDrawableContent(svg);

        await fs.writeFile("../library/src/main/res/drawable/" + "emoji_" +
            path.parse(file).name.replaceAll("-", "_") + ".xml", vector);
    }

    console.log("Generating java code...");
    await fs.emptyDir("../library/src/main/java/com/vanniktech/emoji/emoji/category/");
    const emojiMapping = JSON.parse(await fs.readFile("build/emojione/emoji.json", "utf-8"));
    const map = new MultiMap();

    Object.values(emojiMapping).sort((first, second) => {
        return first.emoji_order - second.emoji_order;
    }).forEach(emoji => {
        if (emoji.category !== "modifier") {
            if (map.has(emoji.category)) {
                map.get(emoji.category).push(emoji.unicode);
            } else {
                map.set(emoji.category, new Array(emoji.unicode));
            }
        }
    });

    const categoryTemplate = await fs.readFile("Category.java", "utf-8");
    const emojiCategoriesTemplate = await fs.readFile("EmojiCategories.java", "utf-8");

    for (const [category, unicodes] of Array.from(map.entries())) {
        const name = category.capitalizeFirstLetter() + "Category";
        const data = unicodes.map((it) => {
            return "Emoji.fromCodePoints(" + it.split("-").map(unicode => "0x" + unicode).join(", ") + ")";
        }).join(",\n            ");

        await fs.writeFile("../library/src/main/java/com/vanniktech/emoji/emoji/category/" + name + ".java",
            _(categoryTemplate).template()({
                name: name,
                data: data,
                icon: category
            }));
    }

    const importData = map.keys().map((category) => {
        return "import com.vanniktech.emoji.emoji.category." + category.capitalizeFirstLetter() + "Category;"
    }).join("\n");

    const categoryData = map.keys().map((category) => {
        return "categories.put(\"" + category + "\", new " + category.capitalizeFirstLetter() + "Category());"
    }).join("\n        ");

    await fs.writeFile("../library/src/main/java/com/vanniktech/emoji/emoji/EmojiCategories.java",
        _(emojiCategoriesTemplate).template()({
            imports: importData,
            mapping: categoryData
        }))
}

run().then()
    .catch(err => {
        console.log(err);
    });