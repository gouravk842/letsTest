$(document).ready(function (event) {
    $('#quizHistory').css('display', 'block');
    loadallQuiz();
})


function loadallQuiz() {
    let createdBy=1;//$('#customerId').val()
    $.ajax({
        url: "/quiz/get/"+ createdBy,
        dataType: "json",
        success: function (data) {
            if (data.length > 0) {
                let noOfClick=0;
                for(let i=0;i<data.length;i++){
                    let divnode = document.createElement("div",);
                    divnode.id = data[i].quizId.toString();
                    let node = document.createElement("button",);
                    node.innerHTML = data[i].nameOfTopic + "<br>" + data[i].description ;
                    node.className = "quizButton";
                    node.onclick = function () {
                        if(noOfClick%2==0) {
                            document.getElementById("questionAnswer").style.display="block";
                            let quizId=data[i]["quizId"]
                            console.log(quizId)
                            loadAllQuestionsandAnswer(quizId);
                        }
                        else {
                            document.getElementById("questionOuterNode").remove();
                            document.getElementById("TotalQuestionsDiv").remove();
                            document.getElementById("questionAnswer").style.overflow="none";
                            document.getElementById("questionAnswer").style.display="none";
                        }
                        noOfClick=noOfClick+1;
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
            if (data.question.length > 0) {
                console.log(data.question.length);
                totalNumberOfQuestions(data.question.length);
                let divResultOuterNode = document.createElement("div");
                divResultOuterNode.id="questionOuterNode";
                for(let i=0;i<data.question.length;i++){
                    let divQuestionNode = document.createElement("div",);
                    divQuestionNode.id='div'+data.question[i].questionId;
                    let node = document.createElement("h3",);
                    node.id = 'question'+data.question[i].questionId;
                    node.innerHTML = data.question[i].question + "<br>" + data.question[i].hint ;
                    node.className = "questionText";
                    divQuestionNode.appendChild(node)

                    for(let j=0; j<data.question[i].answers.length; j++){
                        let node2 = document.createElement("button",);
                        node2.id = 'answer'+data.question[i].answers[j].answerOrder+i;
                        node2.innerHTML=data.question[i].answers[j].questionOption;
                        node2.className='answerBtn'
                        divQuestionNode.appendChild(node2);
                    }
                    divResultOuterNode.appendChild(divQuestionNode);
                    document.getElementById("questionAnswer").appendChild(divResultOuterNode);

                    for(let k=0; k<data.question[i].correctAnswer.length; k++){
                        let correctAnswerButtonId='answer'+data.question[i].correctAnswer[k].correctAnswerOptionId+i;
                        document.getElementById(correctAnswerButtonId).style.background='LightSkyBlue';
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

    document.getElementById("questionAnswer").appendChild(divTotalAppearedStudentsNode);

}