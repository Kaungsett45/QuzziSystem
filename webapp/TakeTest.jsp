<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<style>

.questionform{
  margin-top: 50px;
  margin-left: 300px;
  display: block;
  padding: 20px 50px 20px 50px;
  width: 800px;
  border-radius: 8px;
  
  background-color: white;
}
 .question {
     width:700px;
     font-weight: 500;
     font-size: 16px;
    padding: 30px 40px 30px 40px;
    border-radius:4px ;
 
}

.option p{
	padding-left:20px;
}
.option {
   width: 100%;
   margin-top: 20px;
   margin-right: 100px;
   display:flex;
   padding: 10px 10px 10px 10px;
   border-radius: 4px;
}
.optionflex{
  display: block;
}

.btnok{
	
	font-size:16px;
	color:black;
	font-weight:600;
	margin-right:20px;
	padding:10px 30px 10px 30px;
	cursor:pointer;
}
.btncon{
	display:flex;
}
.optioncontiain{
	display:block;
	
}

</style>
<link rel="stylesheet" href="CSS/Home.css">
<body>
	
			<div class="header">
	<div class="okidoki">
	<h3>Quizi Choice</h3>
	<p class="sp">System</p>
	</div>
	
	
	
	
	</div>

   <!--Ques 1-->
  
<div class="btncon">
   <button id="prevBtn" class="btnok">Previous</button>
   <button id="nextBtn" class="btnok">Next</button>
   <p>Page <span id="pageIndex">${status.index + 1}</span> of ${quelist.size()}</p>
</div>
<form action="CheckAnswer" method="POST">
<input type="hidden" name="currentQuestionIndex" value="${currentQuestionIndex}">

<c:forEach items="${quelist}" var="que" varStatus="status">
<input type="hidden" name="questioncode" value="${que.questioncode}">

    <div class="questionform" data-form-index="${status.index}" style="display: ${status.index == 0 ? 'block' : 'none'}">

        <div class="question">
            ${que.question_title}
        </div>
        <div class="optionflex">
            <div class="optioncontiain">
                <div class="option">
                    <input type="radio" name="answeroption-${status.index}-${que.question_id}" value="null"><p>${que.description}</p>
                </div>
                <div class="option">
                    <input type="radio" name="answeroption-${status.index}-${que.question_id}" value="null"><p>${que.descriptiontwo}</p>
                </div>
            </div>

            <div class="optioncontiain">
                <div class="option">
                    <input type="radio" name="answeroption-${status.index}-${que.question_id}" value="null"><p>${que.descriptionthree}</p>
                </div>
                <div class="option">
                    <input type="radio" name="answeroption-${status.index}-${que.question_id}" value="${que.answeroption_id}" data-answer="${que.answeroption_id}">
                    <p>${que.answerdescription}</p>
                </div>
            </div>
        </div>
    </div>
</c:forEach>



<div class="btncon">
   <input type="submit" class="btnok" value="Submit">
</div>
 
  
</form>




<script>
    const optionContainers = document.querySelectorAll('.questionform');
    let currentFormIndex = 0;

    function setActiveRadio(container) {
        const selectedRadioId = container.getAttribute('data-selected-radio');
        if (selectedRadioId) {
            const selectedRadio = container.querySelector(`#${selectedRadioId}`);
            if (selectedRadio) {
                selectedRadio.checked = true;
                selectedRadio.parentElement.style.backgroundColor = 'lightgreen';
            }
        }
    }

    function resetBackgroundColors(container) {
        const options = container.querySelectorAll('.option');
        options.forEach(option => {
            option.style.backgroundColor = '';
        });
    }

    optionContainers.forEach((optionContainer, index) => {
        optionContainer.setAttribute('data-selected-radio', ''); // Initialize selected radio attribute
        setActiveRadio(optionContainer);

        const radios = optionContainer.querySelectorAll('input[type="radio"]');
        radios.forEach(radio => {
            radio.addEventListener('click', function(event) {
                const clickedOption = event.target.parentElement;

                resetBackgroundColors(optionContainer);
                clickedOption.style.backgroundColor = 'lightgreen';

                optionContainer.setAttribute('data-selected-radio', radio.id);
            });
        });

        if (index !== currentFormIndex) {
            optionContainer.style.display = 'none'; // Hide forms except the first one
        }
    });

  
    prevBtn.addEventListener('click', function() {
        optionContainers[currentFormIndex].style.display = 'none';
        currentFormIndex = (currentFormIndex - 1 + optionContainers.length) % optionContainers.length;
        optionContainers[currentFormIndex].style.display = 'block';
        setActiveRadio(optionContainers[currentFormIndex]);
    });

    nextBtn.addEventListener('click', function() {
        optionContainers[currentFormIndex].style.display = 'none';
        currentFormIndex = (currentFormIndex + 1) % optionContainers.length;
        optionContainers[currentFormIndex].style.display = 'block';
        setActiveRadio(optionContainers[currentFormIndex]);
    });

        var currentIndex = 0;
        var questionSets = document.querySelectorAll(".questionform");

        function showQuestionSet(index) {
            for (var i = 0; i < questionSets.length; i++) {
                if (i === index) {
                    questionSets[i].style.display = "block";
                } else {
                    questionSets[i].style.display = "none";
                }
            }
        }

        function prevQuestionSet() {
            currentIndex = Math.max(0, currentIndex - 1);
            showQuestionSet(currentIndex);
        }

        function nextQuestionSet() {
            currentIndex = Math.min(questionSets.length - 1, currentIndex + 1);
            showQuestionSet(currentIndex);
        }
   
    // Function to shuffle an array
    function shuffleArray(array) {
        for (let i = array.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [array[i], array[j]] = [array[j], array[i]];
        }
    }

    // Shuffling options for each question form
    document.addEventListener('DOMContentLoaded', function() {
        const questionForms = document.querySelectorAll('.questionform');
        
        questionForms.forEach((form, index) => {
            const optionContainer = form.querySelector('.optionflex');
            const options = Array.from(optionContainer.querySelectorAll('.option'));
            shuffleArray(options);
            options.forEach(option => optionContainer.appendChild(option));
        });
    });

   var pageIndex = ${status.index + 1}; // Initialize page index from JSTL
   var maxIndex = ${quelist.size()};    // Initialize maximum index from JSTL

   document.getElementById("prevBtn").addEventListener("click", function() {
       if (pageIndex > 1) {
           pageIndex--;
           document.getElementById("pageIndex").textContent = pageIndex;
       }
   });

   document.getElementById("nextBtn").addEventListener("click", function() {
       if (pageIndex < maxIndex) {
           pageIndex++;
           document.getElementById("pageIndex").textContent = pageIndex;
       }
   });
</script>


</body>
</html>