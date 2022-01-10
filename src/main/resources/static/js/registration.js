$(document).ready(function () {

    $("#signup").click(function () {
        let name = $('#name').val()
        let mobile = $('#mobile').val()
        let email = $('#email').val()
        let password = $('#pass').val()
        let address = $('#address').val()
        let college_name = $('#college').val()
        let regNo = $('#regNo').val()
        let department = $('#department').val()

        let details = {}
        details['name'] = name
        details['mobileNo'] = mobile
        details['address'] = address
        details['password'] = password
        details['collegeName'] = college_name
        details['collegeRegNo'] = regNo
        details['department'] = department
        if ($("input[type='radio'][name='age']:checked").val() === undefined) {
            details['role'] = 'Student'}
        else{
            details['role'] =$("input[type='radio'][name='age']:checked").val()
        }
        details['status'] = 'true'
        details['email'] = email
        saveData(details)

    });
});

function saveData(data) {
    let registrationDetailsString = JSON.stringify(data)


    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        contentType: 'application/json',
        url: "/user/registration",
        data: registrationDetailsString,
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

$("#signin").click(function () {
    window.location = "http://localhost:8080/"
})