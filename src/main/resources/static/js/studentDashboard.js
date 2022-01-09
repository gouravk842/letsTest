$(document).ready(function (e) {
    loadQuiz()
})

function loadQuiz() {
    $.ajax({
        url: "/quiz/activeQuiz",
        dataType: "json",
        success: function (data) {
            if (data.length > 0) {
                for (let i = 0; i < data.length; i++) {
                    let divnode = document.createElement("div");
                    divnode.id = data[i].quizId.toString();
                    let node = document.createElement("button",);
                    node.innerHTML = data[i].nameOfTopic + "<br>" + data[i].description;
                    node.className = "quizButton";
                    node.onclick = function () {
                        console.log(divnode.id)
                       window.location= "/exam/dashboard/" + divnode.id
                    }
                    divnode.appendChild(node);
                    document.getElementById('activeQuiz').appendChild(divnode);
                }

            } else {
                console.log('No results found.');
            }

        },
        fail: function () {
        }
    });

}