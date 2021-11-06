$(document).ready(function (e) {
    $("#start").click(function () {
        document.documentElement.requestFullscreen().catch((e)=>{
            console.log(e)
        });

    });
})
document.addEventListener("fullscreenchange", function (event) {
    if (document.fullscreenElement) {
        $("#title").text('exam started')
        console.log('active')
    } else {
        // fullscreen is cancelled
        $("#title").text('exam ended')
        console.log('close')
    }
});