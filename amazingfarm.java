/* ==========================================
   AMAZING FARMS
   JavaScript Part 1
========================================== */

// ==============================
// MOBILE MENU
// ==============================

const menuBtn = document.querySelector(".menu-btn");
const navLinks = document.querySelector(".nav-links");

menuBtn.addEventListener("click", () => {

    navLinks.classList.toggle("show-menu");

});

// ==============================
// BACK TO TOP BUTTON
// ==============================

const backToTop = document.getElementById("backToTop");

window.addEventListener("scroll", () => {

    if (window.scrollY > 300) {

        backToTop.style.display = "flex";

    } else {

        backToTop.style.display = "none";

    }

});

backToTop.addEventListener("click", () => {

    window.scrollTo({

        top:0,

        behavior:"smooth"

    });

});

// ==============================
// COUNTER ANIMATION
// ==============================

const counters = document.querySelectorAll(".counter");

counters.forEach(counter => {

    counter.innerText = "0";

    const updateCounter = () => {

        const target = +counter.getAttribute("data-target");

        const count = +counter.innerText;

        const increment = target / 150;

        if(count < target){

            counter.innerText = `${Math.ceil(count + increment)}`;

            setTimeout(updateCounter,15);

        }else{

            counter.innerText = target.toLocaleString();

        }

    };

    updateCounter();

});

/* ==========================================
   SCROLL REVEAL ANIMATION
========================================== */

const revealElements = document.querySelectorAll(

    ".feature-box, .product-card, .service-card, .testimonial-card, .gallery-grid img, .farm-content, .farm-image"

);

const revealOnScroll = () => {

    revealElements.forEach((element) => {

        const windowHeight = window.innerHeight;

        const revealTop = element.getBoundingClientRect().top;

        const revealPoint = 120;

        if (revealTop < windowHeight - revealPoint) {

            element.classList.add("fade-up", "show");

        }

    });

};

window.addEventListener("scroll", revealOnScroll);

revealOnScroll();

/* ==========================================
   STICKY NAVBAR EFFECT
========================================== */

const navbar = document.querySelector(".navbar");

window.addEventListener("scroll", () => {

    if (window.scrollY > 60) {

        navbar.style.padding = "12px 8%";

        navbar.style.boxShadow = "0 10px 25px rgba(0,0,0,.15)";

    } else {

        navbar.style.padding = "18px 8%";

        navbar.style.boxShadow = "0 2px 12px rgba(0,0,0,.08)";

    }

});

/* ==========================================
   ACTIVE NAVIGATION LINK
========================================== */

const sections = document.querySelectorAll("section");

const navItems = document.querySelectorAll(".nav-links a");

window.addEventListener("scroll", () => {

    let current = "";

    sections.forEach(section => {

        const sectionTop = section.offsetTop - 150;

        const sectionHeight = section.offsetHeight;

        if (pageYOffset >= sectionTop) {

            current = section.getAttribute("id");

        }

    });

    navItems.forEach(link => {

        link.classList.remove("active");

        if (link.getAttribute("href") === "#" + current) {

            link.classList.add("active");

        }

    });

});

/* ==========================================
   GALLERY LIGHTBOX
========================================== */

const galleryImages = document.querySelectorAll(".gallery-grid img");

const lightbox = document.querySelector(".lightbox");

const lightboxImage = document.querySelector(".lightbox-image");

const closeLightbox = document.querySelector(".close-lightbox");

galleryImages.forEach(image=>{

image.addEventListener("click",()=>{

lightbox.style.display="flex";

lightboxImage.src=image.src;

});

});

closeLightbox.addEventListener("click",()=>{

lightbox.style.display="none";

});

lightbox.addEventListener("click",(e)=>{

if(e.target===lightbox){

lightbox.style.display="none";

}

});

/* ==========================================
   LOADER
========================================== */

window.addEventListener("load",()=>{

const loader=document.getElementById("loader");

loader.classList.add("loader-hide");

});

/*=====================================
 HERO SLIDER
======================================*/

const heroSlider = document.querySelector(".hero-slider");

const heroImages=[

"images/hero1.jpg",

"images/hero2.jpg",

"images/hero3.jpg",

"images/hero4.jpg",

"images/hero5.jpg"

];

let currentHero=0;

heroSlider.style.backgroundImage=`url(${heroImages[0]})`;

setInterval(()=>{

currentHero++;

if(currentHero>=heroImages.length){

currentHero=0;

}

heroSlider.style.backgroundImage=`url(${heroImages[currentHero]})`;

},5000);