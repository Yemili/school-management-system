document.getElementById('LoginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission


// Get user details
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
    const errorMessage = document.getElementById('errorMessage');
    const displayArea = document.getElementById('displayArea');
    const LoginForm = document.getElementById('LoginForm');
	const myheader=document.getElementById('myheader');
	
    errorMessage.textContent = ''; // Clear previous error messages
    displayArea.innerHTML = ''; // Clear previous display
	LoginForm.innerHTML ='';
    myheader.innerHTML='';

    // If validation passes, display the submitted values
    LoginForm.innerHTML = `
        <h2>Login Successful</h2>
        <p><strong>Username:</strong> ${username}</p>
        <p><strong>Password:</strong> ${password}</p>
        <p><strong>Password is not displayed for security reasons.</strong></p>
    `;
    
});