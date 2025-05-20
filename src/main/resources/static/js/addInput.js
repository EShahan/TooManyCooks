function addInstructionInput() {
            const divEle = document.getElementById("instructionInputs");
            divEle.innerHTML += `
            <div>
                <label> Instruction Step : <input type="text" name="instructions"/></label><br>
                <a style='color:blue' onclick='this.parentElement.remove()'>Remove This Instruction Step</a>
            </div>
      `;
}

function addIngredientInput() {
            const divEle = document.getElementById("ingredientInputs");
            divEle.innerHTML += `
            <div>
                            <label> Ingredient : <input type="text" name="ingredient"/></label>
                            <label> Amount : <input type="text" name="amount"/></label>
                            <label> Measurement : <input type="text" name="measurement"/></label>
                <a style='color:blue' onclick='this.parentElement.remove()'>Remove This Ingredient</a>
            </div>
      `;
}