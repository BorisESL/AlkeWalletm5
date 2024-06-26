<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="example.model.Usuario" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession sessi = request.getSession(false);
    Usuario usuario = (Usuario) sessi.getAttribute("usuario");
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
    <title>Depositar Fondos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
        <h1 class="text-secondary text-md-center p-2">Depositar Fondos</h1>
        <form action="/AlkeWalletModulo_4/procesarDeposito" method="post" class="text-center">
            <div class="form-group">
                <label class="text-secondary" for="monto">Monto a depositar:</label>
                <input type="number" name="monto" id="monto" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-dark text-warning mt-3">Depositar</button>
        </form>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
