var MAX_CHOICE_NUMBER = 20;
var MIN_CHOICE_NUMBER = 2;

var nbChoices = 2;
var choicesDiv;

document.addEventListener('DOMContentLoaded', function(){
  choicesDiv = document.getElementById("choices");
});

function addChoice()
{
  if(nbChoices < MAX_CHOICE_NUMBER)
  {
    nbChoices++;

    var choicex = 'choice-' + nbChoices;
    var newInput = document.createElement('input');

    newInput.type = 'text';
    newInput.placeholder = 'Choice ' + nbChoices;
    newInput.className = 'form-control mt-2';
    newInput.id = choicex;
    newInput.name = choicex;

    choicesDiv.appendChild(newInput);
  }
}

function removeChoice()
{
  if(nbChoices > MIN_CHOICE_NUMBER)
  {
    document.getElementById("choice-"+nbChoices).remove();
    nbChoices--;
  }

}