function addRecipeDetailInput() {
    const divEle = document.getElementById("recipeDetailInputs");
    var recipeDetailInput = document.createElement('div');
    recipeDetailInput.innerHTML += `
        <ul>
            <li><label> Detail : <br><textarea name="recipeDetails" class="detailedInstructionsText"></textarea></label></li>
        </ul>
        <a style='color:blue' onclick='this.parentElement.remove()'>Remove This Detail</a>
    `;
    divEle.appendChild(recipeDetailInput);
}

function addRecipeInstructionInput() {
    const divEle = document.getElementById("recipeInstructionInputs");
    var recipeInstructionInput = document.createElement('div');
    recipeInstructionInput.innerHTML += `
                <ul>
                    <li><label> Detailed Instruction : <br><textarea name="recipeInstructions" class="detailedInstructionsText"></textarea></label></li>
                </ul>
                <a style='color:blue' onclick='this.parentElement.remove()'>Remove This Instruction Step</a>
    `;
    divEle.appendChild(recipeInstructionInput)
}

function addInstructionCardInput() {
            const divEle = document.getElementById("instructionCardInputs");
            var instructionInput = document.createElement('div');
            instructionInput.innerHTML += `
                <ul>
                    <li><label> Instruction Step : <br><textarea name="instructions" class="addInstructionsText"></textarea></label></li>
                    <a style='color:blue' onclick='this.parentElement.parentElement.remove()'>Remove This Instruction Step</a>
                </ul>
      `;
      divEle.appendChild(instructionInput);
}

function addIngredientCardInput() {
            const divEle = document.getElementById("ingredientCardInputs");
            var ingredientInput = document.createElement('div');
            ingredientInput.innerHTML += `
                    <ul>
                        <li><label> Ingredient : <input type="text" name="ingredient"/></label></li>
                        <li><label> Amount : <input type="text" name="amount"/></label></li>
                        <li><label> Measurement : <input type="text" name="measurement"/></label></li>
                        <a style='color:blue' onclick='this.parentElement.parentElement.remove()'>Remove This Ingredient</a>
                    </ul>
      `;
      divEle.appendChild(ingredientInput);
}