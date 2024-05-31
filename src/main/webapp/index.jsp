<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="./css/styles.css">
</head>

<body class="principal">
  <section class="container mt-3">
    <div class="d-flex justify-content-center">
    <a href="pages/menuprincipal.jsp">
      <img src="./img/logo.png" alt="Logo" class="img-fluid">
    </a>
    </div>
    <div class="formulario">
      <!-- Alert -->
      <div id="alertMessage"></div>
      <!-- Alert -->
      <h2 class="text-dark text-center">Inicio de sesión</h2>
      <form id="loginForm" action="/LoginServlet" method="post">
        <div class="form-group">
          <label class="text-dark mb-2 fw-bold" for="email"></label>
          <div class="input-group">
            <span class="input-group-prepend">
              <span class="input-group-text"><i class="bi bi-person-fill"></i></span>
            </span>
            <input type="email" class="form-control" id="email" name="email" placeholder="Correo electronico">
          </div>
        </div>
        <div class="form-group">
          <label class="text-dark mb-2 mt-2 fw-bold" for="password"></label>
          <div class="input-group">
            <span class="input-group-prepend">
              <span class="input-group-text"><i class="bi bi-lock-fill"></i></span>
            </span>
            <input type="password" class="form-control" id="password" name="password" placeholder="Contraseña">
          </div>
        </div>
        <button type="submit" class="btn btn-dark text-warning w-100 mt-md-4 mt-4">Ingresar</button>
      </form>
    </div>
  </section>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
    integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
    integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
    crossorigin="anonymous"></script>
</body>

</html>
