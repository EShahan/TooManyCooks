//Toggles loginBlock display between none and block.
function toggleLoginBlock() {
    currentState = document.getElementById("loginBlock").style.display;
    if (currentState == "block")
    {
        document.getElementById("loginBlock").style.display = "none";
    }
    else
    {
        document.getElementById("loginBlock").style.display = "block";
    }
}

//sets login form display = 'none'.
function hideLoginBlock() {
    document.getElementById("loginBlock").style.display = "none"
}