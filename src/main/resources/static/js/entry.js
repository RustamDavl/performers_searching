import router from "./router.js";


(async () => {

    try{
    router.init();

    } catch(e) {
        alert("error: " + e)
    }
})();