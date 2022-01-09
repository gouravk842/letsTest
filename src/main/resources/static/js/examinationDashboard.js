$(document).ready(function (e) {
    $("#start").click(function () {
        // document.documentElement.requestFullscreen().catch((e)=>{
        //     console.log(e)
        // });
        $('#instruction').hide();

        startExam(1)

    });
})
// document.addEventListener("fullscreenchange", function (event) {
//     if (document.fullscreenElement) {
//         $("#title").text('exam started')
//         console.log('active')
//     } else {
//         // fullscreen is cancelled
//         $("#title").text('exam ended')
//         console.log('close')
//     }
// });
var total_question = 0
var data;

function startExam(examid) {
    $.ajax({
        type: "GET",
        enctype: 'multipart/form-data',
        contentType: 'application/json',
        url: "/exam/start/" + examid,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        cache: false,
        timeout: 600000,
        dataType: 'json',
        success: function (datas, textStatus, xhr) {
            total_question = datas["question"].length
            data = datas
            populateQuestions(data)

        },
        error: function (e) {
            // alert('error')
        }
    });
}

var question_no = 0

function populateQuestions(data) {
    $('#question').text(data["question"][question_no]["question"])
    $('#question').val(data["question"][question_no]["questionId"])
    $('#label1').text(data["question"][question_no]["answers"][0]['questionOption'])
    $('#radio1').val(data["question"][question_no]["answers"][0]['answerId'])
    $('#label2').text(data["question"][question_no]["answers"][1]['questionOption'])
    $('#radio2').val(data["question"][question_no]["answers"][0]['answerId'])
    $('#label3').text(data["question"][question_no]["answers"][2]['questionOption'])
    $('#radio3').val(data["question"][question_no]["answers"][0]['answerId'])
    $('#label4').text(data["question"][question_no]["answers"][3]['questionOption'])
    $('#radio4').val(data["question"][question_no]["answers"][0]['answerId'])
}

$("#next").click(function () {

    if ($("input[type='radio'][name='option']:checked").val() === undefined) {
        // w2alert("You haven't selected any option")
        alert("You haven't selected any option")
    } else {
       let answerId=$("input[type='radio'][name='option']:checked").val()
        let questionId=$('#question').val()
        saveAnswer(answerId,questionId)
        question_no += 1
        if(question_no<=total_question){
            populateQuestions(data)
        }
        else{
            alert("Examination Completed")
        }


    }

})
function saveAnswer(answerid,questionid){
    let ans={}
    ans['studentId']=1
    ans['answerId']=answerid
    ans['questionId']=questionid
    let studentAnswerString = JSON.stringify(ans)
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        contentType: 'application/json',
        url: "/exam/saveAnswer",
        data:studentAnswerString,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        cache: false,
        timeout: 600000,
        dataType: 'json',
        success: function (data) {
            return data

        },
        error: function (e) {
            // alert('error')
        }
    });
}