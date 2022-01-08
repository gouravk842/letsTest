$(document).ready(function (e) {
    $("#start").click(function () {
        document.documentElement.requestFullscreen().catch((e)=>{
            console.log(e)
        });
        $('#instruction').hide();
        startExam(1)

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

function startExam(examid){
    $.ajax({
        type: "GET",
        enctype: 'multipart/form-data',
        contentType: 'application/json',
        url: "/exam/start/"+examid,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        cache: false,
        timeout: 600000,
        dataType: 'json',
        success: function (data, textStatus, xhr) {
            alert('success')

        },
        error: function (e) {
            alert('error')
        }
    });
}