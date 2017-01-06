const Fsp = require("fs-promise");
const Git = require("nodegit");
const Dict = require("collections/dict");
const _ = require("underscore");

Fsp.remove("out").then(() => {

    // Is there already a cloned repo? If yes, pull. If not, clone.
    return Fsp.stat("build/emojione").then(() => {
        console.log("Updating repo...");

        let repository;

        return Git.Repository.open("build/emojione").then((repo) => {
            repository = repo;

            return repository.fetchAll(buildGitFetchOptions());
        }).then(() => {
            return repository.mergeBranches("master", "origin/master");
        }).catch(error => {
            console.error(error);

            process.exit(1);
        })
    }).catch((error) => {
        console.log("Cloning repo...");

        return Git.Clone("https://github.com/Ranks/emojione", "build/emojione", buildGitCloneOptions())
    })
}).then(() => {
    clearProgress();
    console.log("Copying drawables...");

    return Fsp.mkdirp("out/res/drawable");
}).then(() => {
    return Fsp.readdir("build/emojione/assets/svg");
}).then((items) => {
    const size = items.length;
    let counter = 0;

    return items.reduce((promise, item) => promise.then(() => {
        counter++;

        printProgress(counter, size);

        return Fsp.copy("build/emojione/assets/svg/" + item, "out/res/drawable/emoji_" + item)
    }), Promise.resolve());
// }).then(() => {
//     return Fsp.readdir("build/emojione/assets/other/category_icons")
// }).then((items) => {
//     return items.reduce((promise, item) => promise.then(() => {
//         return Fsp.copy("build/emojione/assets/other/category_icons/" + item, "out/res/drawable/emoji_category_" + item)
//     }), Promise.resolve());
}).then(() => {
    clearProgress();

}).then(() => {
    return Fsp.mkdirp("out/java");
}).then(() => {
    console.log("Generating java code...");

    return Fsp.readFile("build/emojione/emoji.json", "utf-8")
}).then((content) => {
    const emojis = JSON.parse(content);
    const dict = new Dict();

    Object.entries(emojis).forEach(([key, emoji]) => {
        if (emoji.category !== "modifier") {
            if (dict.has(emoji.category)) {
                dict.get(emoji.category).push(emoji.unicode);
            } else {
                dict.add(new Array(emoji.unicode), emoji.category);
            }
        }
    });

    return dict.reduce((promise, values, key) => promise.then(() => {
        return Fsp.readFile("Category.java", "utf-8").then((content) => {
            const name = firstToUpperCase(key) + "Category";
            const data = values.sort((first, second) => {
                return second.emoji_order - first.emoji_order
            }).map((it) => {
                return "Emoji.fromCodePoints(" + it.split("-").map(unicode => "0x" + unicode).join(", ") + ")";
            }).join(",\n            ");

            return Fsp.writeFile("out/java/" + name + ".java", _(content).template()({
                name: name,
                data: data,
                icon: key
            }));
        })
    }), Promise.resolve()).then(() => {
        return Fsp.readFile("EmojiCategories.java", "utf-8").then((content) => {
            const data = dict.keys().map((it) => {
                return "categories.put(\"" + it + "\", new " + firstToUpperCase(it) + "Category());"
            }).join("\n        ");

            return Fsp.writeFile("out/java/EmojiCategories.java", _(content).template()({data: data}));
        })
    });
}).then(() => {
    process.exit(0);
}).catch(error => {
    console.error(error);

    process.exit(1);
});

function buildGitFetchOptions() {
    const fetchOptions = new Git.FetchOptions();
    const callbacks = new Git.RemoteCallbacks();

    fetchOptions.callbacks = callbacks;
    callbacks.transferProgress = progressInfo => {
        clearProgress();
        printProgress(progressInfo.receivedObjects(), progressInfo.totalObjects());
    };

    return fetchOptions;
}

function buildGitCloneOptions() {
    const options = new Git.CloneOptions();

    options.fetchOpts = buildGitFetchOptions();

    return options;
}

function printProgress(current, total) {
    clearProgress();
    process.stdout.write(current + "/" + total);
}

function clearProgress() {
    process.stdout.clearLine();
    process.stdout.cursorTo(0);
}

function firstToUpperCase(str) {
    return str.substr(0, 1).toUpperCase() + str.substr(1);
}