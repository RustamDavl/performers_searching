window.addEventListener('scroll', e => {
    let navbar = document.getElementById("fixed-nav").classList;
    let active_class = "navbar";
    if(pageYOffset > 400) {
        
    navbar.add(active_class);
    }
    else {
        navbar.remove(active_class)
    }
})