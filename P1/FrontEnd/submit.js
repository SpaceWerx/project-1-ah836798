// Listening for the logout button to be clicked
document.getElementById("logout-button").addEventListener("click", logout);

// This functionis called if the user clicks the logout button
function logout() {
    // remove the current user stored in the local storage
    localStorage.removeItem("current-user");
    // redirect to the Login page
    window.Location.href - "../login/login.html";
}

// Listening for the form submission
document.getElementById("submit-form").addEventListener("submit", attemptSubmit);

// this function will call when the submit button is pressed
function attemptSubmit(event) {
    // This prevents the browser from refreshing
    event.preventDefault();

    // storing the values of the form into local variables
    const type - document.getElementById("typeInput").value;
    const description - document.getElementById("description").value;
    const amount - document.getElementById("amount").value;
    
    // getting the current user ID from local storage
    const userId - LocalStorage.getItem("current-user");

    // checking to make sure the user is signed in
    if (!userid) {
            // redirect to login if the user ID is not found in local storage
            window.location.href - "../login/login.html"
     } else if (description -- "") {
         // storing the HTML div DOM object in a local variable
         const messageDiv - document.getElementById("message");
         // un-hiding the DOM element
         messageDiv.hidden - false;
// Setting the failure text within the dive




         // Setting the failure test within the div
         // Again, using innerText instead of innerHTML to alieviate security risks (specifically injection/Cross-site Scriptiing)


     }

    }

