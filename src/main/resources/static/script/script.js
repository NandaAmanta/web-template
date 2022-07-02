/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
AOS.init();

$(window).scroll(function () {

    if ($(window).scrollTop() > 0) {
        document.getElementById("navbar").classList.add("bg-dark-nfz")
        document.getElementById("navbar").classList.add("shadow")
    } else {
        if ($(window).width() > 991) {
            document.getElementById("navbar").classList.remove("bg-dark-nfz")
            document.getElementById("navbar").classList.remove("shadow")
        }


    }
})
$(document).ready(function () {

    const navbarItems = document.querySelectorAll(".main-navbar-item")
    const currentSubPathName = location.pathname.split("/")[1];
    switch (currentSubPathName) {
        case "":
            navbarItems[0].classList.add("active");
            break;
        case "about":
            navbarItems[1].classList.add("active");
            break;
        case "services":
            navbarItems[2].classList.add("active");
            break;
        case "donation":
            navbarItems[3].classList.add("active");
            break;

    }

    if ($(window).width() <= 991) {
        document.getElementById("navbar").classList.add("bg-dark-nfz")
        document.getElementById("navbar").classList.add("shadow")
    }

    const scrollProgress = document.getElementById('scroll-progress');

    window.addEventListener('scroll', () => {
        let height = document.documentElement.scrollHeight - document.documentElement.clientHeight
        const scrollTop =
                document.body.scrollTop || document.documentElement.scrollTop;
        scrollProgress.style.width = `${(scrollTop / height) * 100}%`;
    });
    $('.bg-dark-gradient').css({height: $(window).innerHeight()});
    $(window).resize(function () {
        $('.bg-dark-gradient').css({height: $(window).innerHeight()});
    });
    if ($(window).width() > 991) {
        $(".navbar-light .d-menu").hover(
                function () {
                    $(this).find(".sm-menu").first().stop(true, true).slideDown(150);
                },
                function () {
                    $(this)
                            .find(".sm-menu")
                            .first()
                            .stop(true, true)
                            .delay(120)
                            .slideUp(100);
                }
        );
    }
});

