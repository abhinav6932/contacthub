console.log("script.js loaded");

let currentTheme = getTheme();
changePageTheme(currentTheme);
changeTheme();



//TODO:
function changeTheme() {

    const themeChangeButton = document.querySelector("#theme-change");

    themeChangeButton.querySelector("span").textContent =
        currentTheme == "light" ? "Dark" : "Light";

    themeChangeButton.addEventListener("click", () => {

        const oldTheme = currentTheme;

        if (currentTheme === "dark") {
            currentTheme = "light";
        } else {
            currentTheme = "dark";
        }

        // localstorage me update krenge
        setTheme(currentTheme);

        // remove current theme
        document.querySelector("html").classList.remove(oldTheme);

        // set the current theme
        document.querySelector("html").classList.add(currentTheme);

        // change the text of the button
        themeChangeButton.querySelector("span").textContent =
            currentTheme == "light" ? "Dark" : "Light";
    });

}

// set theme to local storage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

// get theme from local storage
function getTheme() {
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}

// change current page theme
function changePageTheme(theme) {

    // set to web page
    document.querySelector("html").classList.remove("light", "dark");
    document.querySelector("html").classList.add(theme);

}