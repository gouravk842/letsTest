$(document).ready(function (event) {
    $('#createQuiz').css('display', 'block');
    $('#createQuizSection').css('display', 'block');
    $('#reviewQuestionSection').css('display', 'none');
    $('#correctAns').val("");
    $('#title').val("");
    $('#duration').val("");
    $('#examinationDate').val("");
    quiz = {};
    question = [];

})

function createQuizQuestion() {
    let title = $('#title').val();
    let description = $('#description').val();
    let duration= $('#duration').val();
    let exDate=$('#examinationDate').val();

    if (title == "") {
        alert("Please give title of quiz");
    } else {
        quiz["nameOfTopic"] = title;
        quiz["description"] = description;
        quiz["createdById"] = 1;
        quiz["duration"] = duration;
        quiz["expireDate"] = exDate;
        alert('Quiz created successfully')
        $('#addQuestion').css('display', 'block');
        $('#createQuiz').css('display', 'none');

    }
}

$(document).on('click','#createQuiz', function(e){
 createQuizQuestion();

})

$(document).on('click','#submitQuestions', function(e){
    saveQuizQuestionAnswers();
    alert('Quiz and all questions has been submitted');

})
$(document).on('click','#gobackButton', function(e){
    $('#createQuizSection').css('display', 'block');
    $('#reviewQuestionSection').css('display', 'none');
    $('#createQuiz').css('display', 'none');

})
let noOfClick=0
$(document).on('click','#reviewQuestions', function(e){
    if(noOfClick!=0) {
        document.getElementById("questionOuterNode").remove();
        document.getElementById("TotalQuestionsDiv").remove();
    }
    $('#createQuizSection').css('display', 'none');
    $('#reviewQuestionSection').css('display', 'block');
     reviewAllQuestions();
    noOfClick=noOfClick+1;
})

$(document).on('click','#saveQuestionAnswers', function(e){
    nextQuestion();
    $('#question').val("");
    $('#option1').val("");
    $('#option2').val("");
    $('#option3').val("");
    $('#option4').val("");
    $('#correctAns').val("");
    let ids= $("input[type='radio'][name='option']:checked").val();
    document.getElementById(ids).checked= false;
})

function nextQuestion() {
    let correctAnswer=$("#correctAns").val();
    if (correctAnswer == "") {
        alert("Please select one of the correct answer");
    } else {
        let questionVal = $('#question').val();
        questions = {};
        questions["question"] = questionVal;
        questions["hint"] = "";
        answers = [];
        for (let i = 1; i < 5; i++) {
            answer = {}
            let option = "option" + i;
            let options = document.getElementById(option).value;
            answer["questionOption"] = options
            answer["answerOrder"]=i;
            answers.push(answer)
        }
        correctAnswer=[]
        correctAnswers={}
        let ids= $("input[type='radio'][name='option']:checked").val();
        correctAnswers["correctAnswerOptionId"]=parseFloat(ids);
        correctAnswers["answer"]=document.getElementById("correctAns").value;
        correctAnswer.push(correctAnswers);
        questions["answers"] = answers;
        questions["correctAnswer"]=correctAnswer;
        question.push(questions)
        quiz["question"]=question;
        console.log(quiz);

    }
}
function saveQuizQuestionAnswers() {

    $.ajax({
        url: "/quiz/save/questionAnswerDetail",
        dataType: 'json',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(quiz),
        success: function () {
            alert('Quiz and all questions has been submitted');
        },

    });

}
function fetchRadioButtonValue() {
   let ids= $("input[type='radio'][name='option']:checked").val();
   let optionId="option"+ids;
   let optionValue= document.getElementById(optionId).value;
    $('#correctAns').val(optionValue);
}

function totalNumberOfQuestions(numberOfQuestions) {
    let divTotalAppearedStudentsNode = document.createElement("div");
    divTotalAppearedStudentsNode.className="TotalQuestionsDiv";
    divTotalAppearedStudentsNode.id="TotalQuestionsDiv";

    let node = document.createElement("h1",);
    node.innerHTML = "Total Questions";
    node.style.color="blue";
    divTotalAppearedStudentsNode.appendChild(node);

    let divtotalStudentsNode = document.createElement("div");
    divtotalStudentsNode.className="numberDiv";
    let node2 = document.createElement("h3",);
    node2.style.color="brown"
    node2.innerHTML=numberOfQuestions;
    divtotalStudentsNode.appendChild(node2);
    divTotalAppearedStudentsNode.appendChild(divtotalStudentsNode);

    document.getElementById("allquestionAnswer").appendChild(divTotalAppearedStudentsNode);

}

function reviewAllQuestions() {
    if (quiz.question.length > 0) {
        console.log(quiz.question.length);
        totalNumberOfQuestions(quiz.question.length);
        let divResultOuterNode = document.createElement("div");
        divResultOuterNode.id="questionOuterNode";
        for(let i=0;i<quiz.question.length;i++){
            let divQuestionNode = document.createElement("div",);
            divQuestionNode.id='div'+quiz.question[i].questionId;
            let node = document.createElement("h3",);
            node.id = 'question'+quiz.question[i].questionId;
            node.innerHTML = quiz.question[i].question + "<br>" + quiz.question[i].hint ;
            node.className = "questionText";
            divQuestionNode.appendChild(node)

            for(let j=0; j<quiz.question[i].answers.length; j++){
                let node2 = document.createElement("button",);
                node2.id = 'answer'+quiz.question[i].answers[j].answerOrder+i;
                node2.innerHTML=quiz.question[i].answers[j].questionOption;
                node2.className='answerBtn'
                divQuestionNode.appendChild(node2);
            }
            divResultOuterNode.appendChild(divQuestionNode);
            document.getElementById("allquestionAnswer").appendChild(divResultOuterNode);

            for(let k=0; k<quiz.question[i].correctAnswer.length; k++){
                let correctAnswerButtonId='answer'+quiz.question[i].correctAnswer[k].correctAnswerOptionId+i;
                document.getElementById(correctAnswerButtonId).style.background='LightSkyBlue';
            }
        }


    } else {
        console.log('No results found.');
    }
}