$(document).ready(function (event) {
    $('#quizHistory').css('display', 'block');
    loadallQuiz();
})


function loadallQuiz() {
    let customerId=1;//$('#customerId').val()
    $.ajax({
        url: "/quiz/get/"+ customerId,
        dataType: "json",
        success: function (data) {
            if (data.length > 0) {
                for(let i=0;i<data.length;i++){
                    let divnode = document.createElement("div",);
                    divnode.id = data[i].quizId.toString();
                    let node = document.createElement("button",);
                   // node.id = data[i].quizId;
                    node.innerHTML = data[i].nameOfTopic + "<br>" + data[i].description ;
                    node.className = "quizButton";
                    node.onclick = function () {
                      //  location.reload();
                        $("#questionAnswer").load();
                        loadAllQuestionsandAnswer(i+1);
                    }
                    let ids=data[i].quizId.toString();
                    divnode.appendChild(node);
                    document.getElementById('quizHistory').appendChild(divnode);
                }

            } else {
                console.log('No results found.');
            }

        },
        fail: function () {
        }
    });
}

function loadAllQuestionsandAnswer(quizId) {
    let divid='div'+quizId;
    //$("#questionAnswer").load();
    //location.reload();
    $.ajax({
        url: "/quiz/get/quizDetail/"+ quizId,
        dataType: "json",
        success: function (data) {
            if (data.length > 0) {
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

                    document.getElementById("questionAnswer").appendChild(divQuestionNode);

                    for(let k=0; k<data[i].correctAnswer.length; k++){
                        let correctAnswerButtonId='answer'+data[i].correctAnswer[k].correctAnswerId;
                        document.getElementById(correctAnswerButtonId).style.background='Red';
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