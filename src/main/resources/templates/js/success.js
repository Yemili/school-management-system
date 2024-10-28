document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission

    // Get student details
    const name = document.getElementById('name').value;
    const gender = document.getElementById('gender').value;
    const email = document.getElementById('email').value;
    const mobilenumber = document.getElementById('mobilenumber').value;
    const password = document.getElementById('password').value; // Note: don't display passwords
    const age = document.getElementById('age').value;
    
    const errorMessage = document.getElementById('errorMessage');
    const displayArea = document.getElementById('displayArea');
    const myheader= document.getElementById('myheader');
	const registrationForm=document.getElementById('registrationForm');
    errorMessage.textContent = ''; // Clear previous error messages
    displayArea.innerHTML = ''; // Clear previous display
	registrationForm.innerHTML ='';
	myheader.innerHTML='';

	// If all validations pass, display the submitted values in the same window
    registrationForm.innerHTML = `
        <h1>Registration Successful</h1>
        <p>Name: ${name}</p>
        <p>Gender: ${gender || 'Not provided'}</p>
        <p>Email: ${email}</p>
        <p>Mobile Number: ${mobilenumber || 'Not provided'}</p>
        <p>Age: ${age || 'Not provided'}</p>
        <p><strong>Password is not displayed for security reasons.</strong></p>
    `;
});

document.getElementById('loginButton').addEventListener('click', function() {
    // Redirect to login page (update the URL as needed)
    window.location.href = '/view/login'; // Change to your actual login page URL
});