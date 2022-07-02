
// Button SubNavbar Templates
const allButton = document.getElementById("all-subnav-templates");
const navbarButton = document.getElementById("navbar-subnav-templates");
const bannerButton = document.getElementById("banner-subnav-templates");
const footerButton = document.getElementById("footer-subnav-templates");

// Templates group by category
const navbarTemplates = document.querySelectorAll(".navbar-template");
const bannerTemplates = document.querySelectorAll(".banner-template");
const footerTemplates = document.querySelectorAll(".footer-template");

// event listener onclick for each button
allButton.addEventListener("click", () => querySubnav("all"));
navbarButton.addEventListener("click", () => querySubnav("navbar"));
bannerButton.addEventListener("click", () => querySubnav("banner"));
footerButton.addEventListener("click", () => querySubnav("footer"));


// function to filter the data templates
function querySubnav(query) {
    activeSubNav(query);
    switch (query) {
        case "navbar":
            display(navbarTemplates, true);
            display(bannerTemplates, false);
            display(footerTemplates, false);
            break;
        case "banner":
            display(navbarTemplates, false);
            display(bannerTemplates, true);
            display(footerTemplates, false);
            break;
        case "footer":
            display(navbarTemplates, false);
            display(bannerTemplates, false);
            display(footerTemplates, true);
            break;
        default:
            display(navbarTemplates, true);
            display(bannerTemplates, true);
            display(footerTemplates, true);
            break;
    }

}


// function switch display
function display(listDom, willDisplay) {
    if (willDisplay === true) {
        for (var i = 0; i < listDom.length; i++) {
            listDom[i].classList.remove("d-none");
        }
        return;
    }
    for (var i = 0; i < listDom.length; i++) {
        listDom[i].classList.add("d-none");
    }
}

// function subnav button active
function activeSubNav(subnav) {
    switch (subnav) {
        case "all":
            allButton.classList.add("text-info");
            navbarButton.classList.remove("text-info");
            bannerButton.classList.remove("text-info");
            footerButton.classList.remove("text-info");
            break;
        case "navbar":
            allButton.classList.remove("text-info");
            navbarButton.classList.add("text-info");
            bannerButton.classList.remove("text-info");
            footerButton.classList.remove("text-info");
            break;
        case "banner":
            allButton.classList.remove("text-info");
            navbarButton.classList.remove("text-info");
            bannerButton.classList.add("text-info");
            footerButton.classList.remove("text-info");
            break;
        case "footer":
            allButton.classList.remove("text-info");
            navbarButton.classList.remove("text-info");
            bannerButton.classList.remove("text-info");
            footerButton.classList.add("text-info");
            break;
    }
}


const finalButton = document.getElementById("final-button");
starterFecth();

function selectNavbar(id) {
    localStorage.setItem("navbar", id);
    document.getElementById(id).classList.remove("d-none");
    document.querySelector(".".concat(id)).classList.add("d-none");
    finalButton.classList.remove("d-none");
    fecthSelectedCount();
}

function selectBanner(id) {
    localStorage.setItem("banner", id);
    document.getElementById(id).classList.remove("d-none");
    document.querySelector(".".concat(id)).classList.add("d-none");
    finalButton.classList.remove("d-none");
    fecthSelectedCount();
}

function selectFooter(id) {
    localStorage.setItem("footer", id);
    document.getElementById(id).classList.remove("d-none");
    document.querySelector(".".concat(id)).classList.add("d-none");
    finalButton.classList.remove("d-none");
    fecthSelectedCount();
}

function deleteNavbar() {
    document.getElementById(localStorage.getItem("navbar")).classList.add("d-none");
    document.querySelector(".".concat(localStorage.getItem("navbar"))).classList.remove("d-none");
    localStorage.removeItem("navbar");
    fecthSelectedCount();
}

function deleteBanner() {
    document.getElementById(localStorage.getItem("banner")).classList.add("d-none");
    document.querySelector(".".concat(localStorage.getItem("banner"))).classList.remove("d-none");
    localStorage.removeItem("banner");
    fecthSelectedCount();
}

function deleteFooter() {
    document.getElementById(localStorage.getItem("footer")).classList.add("d-none");
    document.querySelector(".".concat(localStorage.getItem("footer"))).classList.remove("d-none");
    localStorage.removeItem("footer");
    fecthSelectedCount();
}

function starterFecth() {
    fecthSelectedCount();
    if (localStorage.getItem("navbar") !== null) {
        document.querySelector("." + localStorage.getItem("navbar")).classList.add("d-none");
        document.getElementById(localStorage.getItem("navbar")).classList.remove("d-none");
    }
    if (localStorage.getItem("banner") !== null) {
        document.querySelector("." + localStorage.getItem("banner")).classList.add("d-none");
        document.getElementById(localStorage.getItem("banner")).classList.remove("d-none");
    }
    if (localStorage.getItem("footer") !== null) {
        document.querySelector("." + localStorage.getItem("footer")).classList.add("d-none");
        document.getElementById(localStorage.getItem("footer")).classList.remove("d-none");
    }
}

function fecthSelectedCount() {
    let data = 0;
    if (localStorage.getItem("navbar") !== null) {
        data++;
    }
    if (localStorage.getItem("banner") !== null) {
        data++;
    }
    if (localStorage.getItem("footer") !== null) {
        data++;
    }

    if (data === 0) {
        finalButton.classList.add("d-none");
    }

    document.getElementById("selected-count").textContent = data;
}

function download() {
    let locationString = "/api/template/build?";
    if (localStorage.getItem("navbar") !== null) {
        if (locationString.charAt(localStorage.length - 1) !== "?") {
            locationString = locationString.concat("&");
        }
        locationString = locationString.concat("navbarId=" + localStorage.getItem("navbar"));
    }

    if (localStorage.getItem("banner") !== null) {
        if (locationString.charAt(localStorage.length - 1) !== "?") {
            locationString = locationString.concat("&");
        }
        locationString = locationString.concat("bannerId=" + localStorage.getItem("banner"));
    }

    if (localStorage.getItem("footer") !== null) {
        if (locationString.charAt(localStorage.length - 1) !== "?") {
            locationString.concat("&");
        }
        locationString = locationString.concat("footerId=" + localStorage.getItem("footer"));
    }

    location.href = locationString;


}

let ls = {};
window.addEventListener("scroll", function () {
    ls = {
        "navbar": localStorage.getItem("navbar"),
        "banner": localStorage.getItem("banner"),
        "footer": localStorage.getItem("footer")
    };

    if (ls.navbar !== null || ls.banner !== null || ls.footer !== null) {
        finalButton.classList.remove("d-none");
    } else {
        finalButton.classList.add("d-none");

    }


})