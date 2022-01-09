$(document).ready(function (event) {
    $('#profile').css('display', 'block');
    userDetail();
})

function userDetail(){
    $.ajax({
        url: "/user/getProfile/1",
        dataType: "json",
        success: function (data) {
                $('#showName').text(data["name"]);
                $('#showEmail').text(data["email"]);
                $('#showDepartment').text(data["department"]);
                $('#showCollegeName').text(data["collegeName"]);
                $('#showAddress').text(data["address"]);
                $('#mb').text(data["mobileNo"]);
        },
        fail: function () {
        }
    });
}