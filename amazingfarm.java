/* ==========================================
   AMAZING FARMS
   JavaScript Part 1
========================================== */


/* ==========================================
   MOBILE NAVIGATION
========================================== */

const menuBtn = document.querySelector(".menu-btn");
const navLinks = document.querySelector(".nav-links");

if (menuBtn && navLinks) {

    menuBtn.addEventListener("click", () => {

        navLinks.classList.toggle("active");

        if (navLinks.classList.contains("active")) {

            menuBtn.innerHTML = "✕";

        } else {

            menuBtn.innerHTML = "☰";

        }

    });

    // Close menu when a link is clicked

    document.querySelectorAll(".nav-links a").forEach(link => {

        link.addEventListener("click", () => {

            navLinks.classList.remove("active");

            menuBtn.innerHTML = "☰";

        });

    });

    // Close menu when clicking outside

    document.addEventListener("click", (e) => {

        if (

            !navLinks.contains(e.target) &&

            !menuBtn.contains(e.target)

        ) {

            navLinks.classList.remove("active");

            menuBtn.innerHTML = "☰";

        }

    });

}

/* ==========================================
   BACK TO TOP BUTTON
========================================== */

const backToTop = document.getElementById("backToTop");

if (backToTop) {

    window.addEventListener("scroll", () => {

        if (window.scrollY > 400) {

            backToTop.classList.add("show");

        } else {

            backToTop.classList.remove("show");

        }

    });

    backToTop.addEventListener("click", () => {

        window.scrollTo({

            top: 0,

            behavior: "smooth"

        });

    });

}

/* ==========================================
   COUNTER ANIMATION
========================================== */

const counters = document.querySelectorAll(".counter");

if (counters.length > 0) {

    const startCounter = (counter) => {

        const target = parseInt(counter.dataset.target);

        const speed = 200;

        let count = 0;

        const update = () => {

            const increment = Math.ceil(target / speed);

            count += increment;

            if (count >= target) {

                counter.innerText = target.toLocaleString();

            } else {

                counter.innerText = count.toLocaleString();

                requestAnimationFrame(update);

            }

        };

        update();

    };

    const observer = new IntersectionObserver((entries, observer) => {

        entries.forEach(entry => {

            if (entry.isIntersecting) {

                startCounter(entry.target);

                observer.unobserve(entry.target);

            }

        });

    }, {

        threshold: 0.5

    });

    counters.forEach(counter => {

        counter.innerText = "0";

        observer.observe(counter);

    });

}

/* ==========================================
   SCROLL REVEAL ANIMATION
========================================== */

const revealItems = document.querySelectorAll(

".feature-box, .product-card, .service-card, .testimonial-card, .portfolio-card, .category-card, .gallery-grid img, .farm-content, .farm-image, .about-content, .about-image, .contact-info, .contact-form, .stat-box"

);

function revealOnScroll() {

    const triggerPoint = window.innerHeight * 0.85;

    revealItems.forEach(item => {

        const itemTop = item.getBoundingClientRect().top;

        if (itemTop < triggerPoint) {

            item.classList.add("fade-up", "show");

        }

    });

}

window.addEventListener("scroll", revealOnScroll);

window.addEventListener("load", revealOnScroll);

/* ==========================================
   STICKY NAVBAR
========================================== */

const navbar = document.querySelector(".navbar");

if (navbar) {

    window.addEventListener("scroll", () => {

        navbar.classList.toggle("sticky", window.scrollY > 60);

    });

}

/* ==========================================
   ACTIVE NAVIGATION LINK
========================================== */

const sections = document.querySelectorAll("section");
const navItems = document.querySelectorAll(".nav-links a");

if (sections.length && navItems.length) {

    window.addEventListener("scroll", () => {

        let current = "";

        sections.forEach(section => {

            const sectionTop = section.offsetTop - 150;

            if (window.scrollY >= sectionTop) {

                current = section.id;

            }

        });

        navItems.forEach(link => {

            link.classList.remove("active");

            if (link.getAttribute("href") === "#" + current) {

                link.classList.add("active");

            }

        });

    });

}

/* ==========================================
   PROFESSIONAL GALLERY LIGHTBOX
========================================== */

const galleryImages = document.querySelectorAll(".portfolio-card img");

const lightbox = document.querySelector(".lightbox");

const lightboxImage = document.querySelector(".lightbox-image");

const closeLightbox = document.querySelector(".close-lightbox");

const downloadButton = document.querySelector(".download-image");

const nextButton = document.querySelector(".next-image");

const prevButton = document.querySelector(".prev-image");

const lightboxTitle = document.querySelector(".lightbox-title");

const lightboxDescription = document.querySelector(".lightbox-description");

let currentIndex = 0;

if (galleryImages.length > 0 && lightbox) {

    function showImage(index){

        currentIndex = index;

        const image = galleryImages[index];

        lightboxImage.src = image.src;

        lightboxImage.alt = image.alt;

        downloadButton.href = image.src;

        const card = image.closest(".portfolio-card");

        if(card){

            const title = card.querySelector("h3");

            const description = card.querySelector("p");

            lightboxTitle.textContent = title ? title.textContent : "";

            lightboxDescription.textContent = description ? description.textContent : "";

        }

        lightbox.style.display = "flex";

        document.body.style.overflow = "hidden";

    }

    galleryImages.forEach((image,index)=>{

        image.addEventListener("click",()=>{

            showImage(index);

        });

    });

    function closeGallery(){

        lightbox.style.display="none";

        document.body.style.overflow="auto";

    }

    closeLightbox.addEventListener("click",closeGallery);

    lightbox.addEventListener("click",(e)=>{

        if(e.target===lightbox){

            closeGallery();

        }

    });

    nextButton.addEventListener("click",()=>{

        currentIndex++;

        if(currentIndex>=galleryImages.length){

            currentIndex=0;

        }

        showImage(currentIndex);

    });

    prevButton.addEventListener("click",()=>{

        currentIndex--;

        if(currentIndex<0){

            currentIndex=galleryImages.length-1;

        }

        showImage(currentIndex);

    });

    document.addEventListener("keydown",(e)=>{

        if(lightbox.style.display==="flex"){

            if(e.key==="ArrowRight"){

                nextButton.click();

            }

            if(e.key==="ArrowLeft"){

                prevButton.click();

            }

            if(e.key==="Escape"){

                closeGallery();

            }

        }

    });

}

/* ==========================================
   LOADER
========================================== */

window.addEventListener("load", () => {

    const loader = document.getElementById("loader");

    if (loader) {

        setTimeout(() => {

            loader.classList.add("loader-hide");

        }, 700);

    }

});

/* ==========================================
   HERO IMAGE SLIDER
========================================== */

const heroSlider = document.querySelector(".hero-slider");

if (heroSlider) {

    const heroImages = [

        "images/hero44.jpg",

        "images/hero444.jpg",

        "images/herooo.jpg",

        "images/hero33.jpg",

        "images/ricefarm.jpg"

    ];

    let currentImage = 0;

    heroSlider.style.backgroundImage = `url('${heroImages[currentImage]}')`;

    setInterval(() => {

        currentImage++;

        if (currentImage >= heroImages.length) {

            currentImage = 0;

        }

        heroSlider.style.backgroundImage =
            `url('${heroImages[currentImage]}')`;

    }, 5000);

}

/* ==========================================
   SMOOTH SCROLL
========================================== */

document.querySelectorAll('a[href^="#"]').forEach(link => {

    link.addEventListener("click", function(e){

        const target = document.querySelector(this.getAttribute("href"));

        if(target){

            e.preventDefault();

            target.scrollIntoView({

                behavior:"smooth"

            });

        }

    });

});

/* ==========================================
   FOOTER YEAR
========================================== */

const year = document.getElementById("year");

if(year){

    year.textContent = new Date().getFullYear();

}

/* ==========================================
   EXPLORE FARM SEARCH & FILTER
========================================== */

const searchInput = document.getElementById("searchInput");
const filterButtons = document.querySelectorAll(".filter-btn");
const productCards = document.querySelectorAll(".product-card");

if (searchInput && filterButtons.length > 0 && productCards.length > 0) {

    let currentFilter = "all";

    // Search + Filter Function

    function filterProducts() {

        const searchText = searchInput.value.toLowerCase();

        productCards.forEach(card => {

            const productName =
                card.querySelector("h3").textContent.toLowerCase();

            const category =
                card.dataset.category;

            const matchesSearch =
                productName.includes(searchText);

            const matchesCategory =
                currentFilter === "all" ||
                category === currentFilter;

            if (matchesSearch && matchesCategory) {

                card.style.display = "block";

                setTimeout(() => {

                    card.style.opacity = "1";
                    card.style.transform = "scale(1)";

                }, 50);

            } else {

                card.style.opacity = "0";
                card.style.transform = "scale(.9)";

                setTimeout(() => {

                    card.style.display = "none";

                }, 250);

            }

        });

    }

    // Search

    searchInput.addEventListener("keyup", filterProducts);

    // Filter Buttons

    filterButtons.forEach(button => {

        button.addEventListener("click", () => {

            filterButtons.forEach(btn => {

                btn.classList.remove("active");

            });

            button.classList.add("active");

            currentFilter = button.dataset.filter;

            filterProducts();

        });

    });

}

/* ==========================================
   PRODUCT SORTING
========================================== */

const sortProducts = document.getElementById("sortProducts");
const productGrid = document.querySelector(".product-grid");

if (sortProducts && productGrid) {

    sortProducts.addEventListener("change", function () {

        const cards = [...productGrid.querySelectorAll(".product-card")];

        switch (this.value) {

            case "az":

                cards.sort((a, b) =>

                    a.querySelector("h3").textContent.localeCompare(

                        b.querySelector("h3").textContent

                    )

                );

                break;

            case "za":

                cards.sort((a, b) =>

                    b.querySelector("h3").textContent.localeCompare(

                        a.querySelector("h3").textContent

                    )

                );

                break;

            case "low":

                cards.sort((a, b) =>

                    Number(a.dataset.price) -

                    Number(b.dataset.price)

                );

                break;

            case "high":

                cards.sort((a, b) =>

                    Number(b.dataset.price) -

                    Number(a.dataset.price)

                );

                break;

            default:

                return;

        }

        cards.forEach(card => productGrid.appendChild(card));

    });

}

/* ==========================================
   QUICK VIEW
========================================== */

const quickButtons = document.querySelectorAll(".quick-view");

const quickModal = document.getElementById("quickModal");

if (quickButtons.length && quickModal) {

    const modalImage = document.getElementById("modalImage");
    const modalTitle = document.getElementById("modalTitle");
    const modalStatus = document.getElementById("modalStatus");
    const modalPrice = document.getElementById("modalPrice");
    const modalDescription = document.getElementById("modalDescription");
    const modalLink = document.getElementById("modalLink");
    const closeModal = document.querySelector(".close-modal");

    quickButtons.forEach(button => {

        button.addEventListener("click", () => {

            modalImage.src = button.dataset.image;
            modalTitle.textContent = button.dataset.name;
            modalStatus.textContent = button.dataset.status;
            modalPrice.textContent = button.dataset.price;
            modalDescription.textContent = button.dataset.description;
            modalLink.href = button.dataset.link;

            quickModal.style.display = "flex";

            document.body.style.overflow = "hidden";

        });

    });

    function closeQuickModal(){

        quickModal.style.display = "none";

        document.body.style.overflow = "auto";

    }

    closeModal.addEventListener("click", closeQuickModal);

    quickModal.addEventListener("click", function(e){

        if(e.target === quickModal){

            closeQuickModal();

        }

    });

}

/* ==========================================
   AUTO PRODUCT
========================================== */

const productField = document.getElementById("product");

if(productField){

const params = new URLSearchParams(window.location.search);

const product = params.get("product");

if(product){

productField.value = product;

}

}

/* ==========================================
   GALLERY FILTER
========================================== */

const galleryButtons = document.querySelectorAll(".gallery-filter-btn");

const galleryCards = document.querySelectorAll(".portfolio-card");

if(galleryButtons.length){

galleryButtons.forEach(button=>{

button.addEventListener("click",()=>{

galleryButtons.forEach(btn=>btn.classList.remove("active"));

button.classList.add("active");

const filter=button.dataset.filter;

galleryCards.forEach(card=>{

if(filter==="all" ||

card.dataset.category===filter){

card.style.display="block";

}else{

card.style.display="none";

}

});

});

});

}

/* ==========================================
   LOAD MORE GALLERY
========================================== */

const loadButton=document.getElementById("loadMoreGallery");

const portfolioCards=document.querySelectorAll(".portfolio-card");

if(loadButton){

let visible=6;

portfolioCards.forEach((card,index)=>{

if(index>=visible){

card.style.display="none";

}

});

loadButton.addEventListener("click",()=>{

visible+=6;

portfolioCards.forEach((card,index)=>{

if(index<visible){

card.style.display="block";

}

});

if(visible>=portfolioCards.length){

loadButton.style.display="none";

}

});

}