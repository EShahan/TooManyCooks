function addFn() {
            const divEle = document.getElementById("instructionInputs");
            divEle.innerHTML += `
            <div>
                <label> Instruction Step : <input type="text" name="instructions"/></label><br>
                <a style='color:blue' onclick='this.parentElement.remove()'>Remove This Instruction Step</a>
            </div>
      `;
}