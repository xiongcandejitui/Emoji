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

async function convertAndCopyResources(map) {
    console.log("Converting and copying resources...");
    await fs.emptyDir("../library/src/main/res/drawable");

    for (const category of Array.from(map.keys())) {
        const copyFrom = "build/emojione/assets/other/category_icons/" + (category === "food" ?
                "foods.svg" : category + ".svg");

        await convertAndSave(copyFrom, "../library/src/main/res/drawable/" + "emoji_category_" + category + ".xml");
    }

    await convertAndSave("build/emojione/assets/other/category_icons/recent.svg",
        "../library/src/main/res/drawable/emoji_recent.xml");
    await fs.copy("emoji_backspace.xml", "../library/src/main/res/drawable/emoji_backspace.xml");

    for (const file of await fs.readdir("build/emojione/assets/svg")) {
        await convertAndSave("build/emojione/assets/svg/" + file, "../library/src/main/res/drawable/" + "emoji_" +
            path.parse(file).name.replaceAll("-", "_") + ".xml");
    }
}

async function cloneOrUpdateRepo() {
    try {
        await fs.stat("build/emojione");

        console.log("Existing repo found. Pulling changes...");
        await git("build/emojione").pull();
    } catch (ignored) {
        console.log("Cloning repo...");
        await git().clone("https://github.com/Ranks/emojione", "build/emojione");
    }
}

async function buildMapping() {
    console.log("Building mapping...");
    const emojiMapping = JSON.parse(await fs.readFile("build/emojione/emoji.json", "utf-8"));
    const map = new Map();

    Object.values(emojiMapping).sort((first, second) => {
        return first.emoji_order - second.emoji_order;
    }).forEach(emoji => {
        if (emoji.category !== "modifier") {
            if (map.has(emoji.category)) {
                map.get(emoji.category).push(emoji.unicode);
            } else if (emoji.category !== "regional") {
                map.set(emoji.category, new Array(emoji.unicode));
            }
        }
    });

    return map;
}

async function generateCode(map) {
    console.log("Generating java code...");
    await fs.emptyDir("../library/src/main/java/com/vanniktech/emoji/emoji/category/");

    const categoryTemplate = await fs.readFile("Category.java", "utf-8");
    const emojiProviderTemplate = await fs.readFile("EmojiProvider.java", "utf-8");

    for (const [category, unicodes] of map.entries()) {
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

    const imports = [...map.keys()].map((category) => {
        return "import com.vanniktech.emoji.emoji.category." + category.capitalizeFirstLetter() + "Category;"
    }).join("\n");

    const categoryMapping = [...map.keys()].map((category) => {
        return "categories.put(\"" + category + "\", new " + category.capitalizeFirstLetter() + "Category());"
    }).join("\n        ");

    const codePointMapping = [...map.values()].map((it) => {
        return it.map((unicodes) => {
            const unicodesSplit = unicodes.split("-");

            return "emojis.add(new String(new int[]{" + unicodesSplit.map((unicode) => "0x" + unicode).join(", ") +
                "}, 0, " + unicodesSplit.length + "), R.drawable.emoji_"
                + unicodesSplit.join("_") + ");"
        }).join("\n        ");
    }).join("\n        ");

    await fs.writeFile("../library/src/main/java/com/vanniktech/emoji/emoji/EmojiProvider.java",
        _(emojiProviderTemplate).template()({
            imports: imports,
            categoryMapping: categoryMapping,
            codePointMapping: codePointMapping
        }))
}

async function run() {
    await cloneOrUpdateRepo();

    const map = await buildMapping();
    await convertAndCopyResources(map);
    await generateCode(map);
}

async function convertAndSave(from, to) {
    const svg = await fs.readFile(from, "utf-8");
    const vector = await svgConverter.svg2vectorDrawableContent(svg);

    await fs.writeFile(to, vector);
}

run().then()
    .catch(err => {
        console.log(err);
    });