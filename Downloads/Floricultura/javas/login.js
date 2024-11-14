// Login Functionality
document.getElementById('login-form').addEventListener('submit', function (e) {
  e.preventDefault(); // Prevent form submission

  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;

  if (username === 'admin' && password === '1234') {
    alert('Login realizado com sucesso!');
    window.location.href = 'home.html'; // Redirecionamento para página inicial
  } else {
    alert('Usuário ou senha incorretos.');
  }
});

// Register Functionality
document.getElementById('register-form').addEventListener('submit', function (e) {
  e.preventDefault(); // Prevent form submission

  const username = document.getElementById('username').value;
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;
  const confirmPassword = document.getElementById('confirm-password').value;

  if (password === confirmPassword) {
    alert('Cadastro realizado com sucesso!');
    window.location.href = 'login.html'; // Redirecionamento para a tela de login
  } else {
    alert('As senhas não coincidem.');
  }
});
