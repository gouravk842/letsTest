$(document).ready(function (event) {
let quizId=$("#quizId").val()
console.log(quizId);
loadAllQuestionsandAnswer(2);
})


function loadAllQuestionsandAnswer(quizId) {
    let divid='div'+quizId;
    //$("#questionAnswer").load();
    //location.reload();
    $.ajax({
        url: "/quiz/get/quizDetail/"+ quizId,
        dataType: "json",
        success: function (data) {
            if (data.length > 0) {

                let divResultOuterNode = document.createElement("div");
                divResultOuterNode.id="questionOuterNode";
                for(let i=0;i<data.length;i++){
                    let divQuestionNode = document.createElement("div",);
                    divQuestionNode.id='div'+data[i].question.questionId;
                    let node = document.createElement("h3",);
                    node.id = 'question'+data[i].question.questionId;
                    node.innerHTML = data[i].question.question + "<br>" + data[i].question.hint ;
                    node.className = "questionText";
                    divQuestionNode.appendChild(node)

                    for(let j=0; j<data[i].answers.length; j++){
                        let node2 = document.createElement("button",);
                        node2.id = 'answer'+data[i].answers[j].answerId;
                        node2.innerHTML=data[i].answers[j].questionOption;
                        node2.className='answerBtn'
                        divQuestionNode.appendChild(node2);
                    }
                    divResultOuterNode.appendChild(divQuestionNode);
                    document.getElementById("questionAnswer").appendChild(divResultOuterNode);

                    for(let k=0; k<data[i].correctAnswer.length; k++){
                        let correctAnswerButtonId='answer'+data[i].correctAnswer[k].correctAnswerId;
                        document.getElementById(correctAnswerButtonId).style.background='blue';
                    }
                }


            } else {
                console.log('No results found.');
            }

        },
        fail: function () {
        }
    });
}