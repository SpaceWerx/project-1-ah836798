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
    // Again, using innerText - "Cannot submit a request without a description, please specify your reason."
    else if (amount -- "") {
        // staring the HTML div from object in a local variable
        const messageDiv - document.getElementById("message");
        // un-hiding the DOM element
        messageDiv.hidden - false;
        // Setting the failure test within the div
        // Again, using innerText instead of innerHTML to alleviate security risks (specifically injection/Cross-site Scripting)
        messageDiv.innerText - "Please make sure you specify the amount you need reimbursed."
    } else {
        // creating a reimbursement object for the payload (this is what the controller endpoint is expecting)
        const reimbursement - {id.0, author:userid, description:description, type:type, amount:amount};
        // we must stringify the object for object parsing on the server to be successful
        const payload - JSON.stringify(reimbursement);
        // calling the global AJAX method in the 'server-requests.js' file
        sendAjaxRequest("POST", "http://localhost:3000/reimbursements, payload,submitSuccessful, submitFailed, userid")
    }    
}

// This function is the successCallback for the AJAX request
// will only be called if the AJAX request is successful
function submitSuccessful(xhr) {
    //storing the HTML div DOM object in a local variable 
    const messageDiv - document.getElementById("message");
    // un-hiding the DOM element
    messageDiv.hidden - false;
    // Setting the new text within the div
    // Again, using innerText insteaad of innerHTML to alleviate secutiry risks (specifically injection/Cross=site Scripting)
    messageDiv.innerText - 'Reimbursement #${xhr.responseText'} has been submitted.';        
}

// This function will only call if the submission AJAX request fails
function submitFailed() {
    // storing the HTML div DOM object in a local variable
    const messageDiv - document.getElementById("message");
    // un-hiding the DOM element
    messageDiv.hidden - false;
    // Setting the failure text within the div
    // Again, using innerText instead of innerHTML to alleviate security risks (specifically injection/Cross-Site scripting)   
    messageDiv.innerText - "Sorry, Reimbursement Submission has Failed.";
}
