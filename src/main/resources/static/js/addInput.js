function addInstructionInput() {
            const divEle = document.getElementById("instructionInputs");
            var instructionInput = document.createElement('div');
            instructionInput.innerHTML += `
                <ul>
                    <li><label> Instruction Step : <input type="text" name="instructions"/></label></li>

                <a style='color:blue' onclick='this.parentElement.parentElement.remove()'>Remove This Instruction Step</a>
                </ul>
      `;
      divEle.appendChild(instructionInput);
}

function addIngredientInput() {
            const divEle = document.getElementById("ingredientInputs");
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