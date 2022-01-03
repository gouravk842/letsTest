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
                    let node = document.createElement("button",);
                    node.innerHTML = data[i].nameOfTopic + "<br>" + data[i].description ;
                    node.className = "quizButton";
                    node.onclick = function () {
                        resultDetails(1,1);
                    }
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
function resultDetails(quizId,createdById) {
    $.ajax({
        url: "/results/get?quizId=1&createdById=1",
        dataType: "json",
        success: function (data) {
            if (data.length > 0) {
                totalAppearedStudents(data.length);
                for(let i=0;i<data.length;i++){
                    let divResultNode = document.createElement("div");
                    divResultNode.id=data[i].createdById;
                    divResultNode.className="resultDiv";
                    let divEmailNode = document.createElement("div");
                    divEmailNode.className="emailDiv";
                    let node = document.createElement("h3",);
                    node.innerHTML = data[i].email;
                    node.className = "resultText";
                    divEmailNode.appendChild(node);
                    divResultNode.appendChild(divEmailNode);

                    let divMarksNode = document.createElement("div");
                    divMarksNode.className="marksDiv";
                    let node2 = document.createElement("h4",);
                    node2.innerHTML=data[i].totalMarks;
                    node2.className='marks'
                    divMarksNode.appendChild(node2);
                    divResultNode.appendChild(divMarksNode);

                    document.getElementById("resultDetails").appendChild(divResultNode);

                }


            } else {
                console.log('No results found.');
            }

        },
        fail: function () {
        }
    });

}

function totalAppearedStudents(totalAppearedStudents) {
    let divTotalAppearedStudentsNode = document.createElement("div");
    divTotalAppearedStudentsNode.className="TotalStudentsDiv";

    let node = document.createElement("h1",);
    node.innerHTML = "Total Appeared Students";
    node.style.color="blue";
    divTotalAppearedStudentsNode.appendChild(node);

    let divtotalStudentsNode = document.createElement("div");
    divtotalStudentsNode.className="numberDiv";
    let node2 = document.createElement("h3",);
    node2.style.color="brown"
    node2.innerHTML=totalAppearedStudents;
    divtotalStudentsNode.appendChild(node2);
    divTotalAppearedStudentsNode.appendChild(divtotalStudentsNode);

    document.getElementById("resultDetails").appendChild(divTotalAppearedStudentsNode);

}