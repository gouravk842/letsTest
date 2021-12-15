$(document).ready(function () {

    $("#login").click(function () {
        let email=$('#email').val()
        let password=$('#pass').val()
        login(email,password)
    })
})

function login(email,password){
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/login?username="+email+"&password="+password,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        cache: false,
        timeout: 600000,

        success: function (data, textStatus, xhr) {
            alert('success')

        },
        error: function (e) {
            alert('error')
        }
    });
}