<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="example.model.Usuario" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession sessi = request.getSession(false);
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("../index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú Principal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="../index.jsp">
                <img src="../img/banco.png" alt="Logo" width="100" height="74" class="d-inline-block align-text-top logo-navbar">
            </a>
            <a class="navbar-brand text-dark fw-bold" href="../index.jsp">Alke Wallet</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link active text-dark fw-bold" aria-current="page" href="menuprincipal.jsp">Menú principal</a>
                    <a class="nav-link active text-dark fw-bold" aria-current="page" href="depositarfondos.jsp">Depositar fondos</a>
                    <a class="nav-link active text-dark fw-bold" aria-current="page" href="retirarfondos.jsp">Retirar fondos</a>
                    <a class="nav-link active text-dark fw-bold" aria-current="page" href="../index.jsp">Cerrar sesión</a>
                </div>
            </div>
        </div>
    </nav>
</header>

<main class="container mt-5">
    <div class="formulario2 d-flex flex-column justify-content-center text-white">
        <h1 class="text-secondary text-md-center p-2">Menú Principal</h1>
        <h2 class="text-secondary text-md-center p-2">Bienvenido, <%= usuario.getNombre() %></h2>
        <div class="form-group text-center">
            <label class="text-secondary" for="balance">Dinero en cuenta:</label>
            <h2 class="text-md-center text-black">$<span id="accountBalance"><%= usuario.getBalance() %></span></h2>
        </div>
        <div class="row">
            <div class="col-12 mb-3">
                <a href="depositarfondos.jsp" class="btn btn-dark text-warning w-100">Depósito</a>

            </div>
        </div>
    </div>
</main>

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
