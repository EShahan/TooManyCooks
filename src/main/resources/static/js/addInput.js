function addInstructionInput() {
            const divEle = document.getElementById("instructionInputs");
            var instructionInput = document.createElement('div');
            instructionInput.innerHTML += `
                <label> Instruction Step : <input type="text" name="instructions"/></label><br>
                <a style='color:blue' onclick='this.parentElement.remove()'>Remove This Instruction Step</a>
      `;
      divEle.appendChild(instructionInput);
}

function addIngredientInput() {
            const divEle = document.getElementById("ingredientInputs");
            var ingredientInput = document.createElement('div');
            ingredientInput.innerHTML += `
                            <label> Ingredient : <input type="text" name="ingredient"/></label>
                            <label> Amount : <input type="text" name="amount"/></label>
                            <label> Measurement : <input type="text" name="measurement"/></label>
                <a style='color:blue' onclick='this.parentElement.remove()'>Remove This Ingredient</a>
      `;
      divEle.appendChild(ingredientInput);
}