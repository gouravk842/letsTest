$(document).ready(function (event) {
    $('#quizAnalysis').css('display', 'block');
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
                        document.location.href="quizDetails.html";
                    }
                    let ids=data[i].quizId.toString();
                    divnode.appendChild(node);
                    document.getElementById('quizAnalysis').appendChild(divnode);
                }

            } else {
                console.log('No results found.');
            }

        },
        fail: function () {
        }
    });
}
