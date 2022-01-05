$(document).ready(function (event) {
    $('#createQuiz').css('display', 'block');
})

 function createQuizQuestion(){
 let title=$('#title').val();
 let description=$('#description').val();
 quiz={}
 quiz["nameOfTopic"]=title
 quiz["description"]=description
 quiz["createdById"]=1
      $.ajax({
         url: "/quiz/save",
         dataType: 'json',
         type: 'POST',
         contentType:'application/json',
         data: JSON.stringify(quiz),
         success: function (data) {
         $("#quizId").val(data);
             alert('success')
              $('#addQuestion').css('display', 'block');
         },

     });
 }

$(document).on('click','#createQuiz', function(e){
 createQuizQuestion();

})


$(document).on('click','#reviewQuestions', function(e){
 window.location.href="/reviewQuestions";

})
$(document).on('click','#saveQuestionAnswers', function(e){
  saveQuestionAnswers();
  $('#question').val("");
                $('#option1').val("");
               $('#option2').val("");
               $('#option3').val("");
               $('#option4').val("");
})

 function saveQuestionAnswers(){
 let quizId=$("#quizId").val()
 questionAnswers={}
  let question =$('#question').val()
 questions={}
 questions["quizId"]=quizId;
 questions["question"]=question
 questions["hint"]=""
 questionAnswers["question"]=questions
 answerList=[]
 for(let i=1; i<5; i++){
   answers={}
   let option="option"+i;
   let options=document.getElementById(option).value;
   console.log(options)
   answers["questionOption"]=options
   answers["quizId"]=quizId
   answers["questionId"]=1
   answerList.push(answers)
 }
 questionAnswers["answers"]=answerList
 correctAnswer={}
 correctAnswerList=[]
 correctAnswer["quizId"]=quizId
 correctAnswer["questionId"]=1
 correctAnswer["correctAnswerId"]=2
 correctAnswerList.push(correctAnswer)
 questionAnswers["correctAnswer"]=correctAnswerList

      $.ajax({
         url: "/quiz/save/questionAnswerDetail",
         dataType: 'json',
         type: 'POST',
         contentType:'application/json',
         data: JSON.stringify(questionAnswers),
         success: function () {
         console.log()
             alert('success')
              $('#question').val("");
              $('#option1').val("");
             $('#option2').val("");
             $('#option3').val("");
             $('#option4').val("");
         },

     });
 }

