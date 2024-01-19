<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Edit Pessoa</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"
            integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA="
            crossorigin="anonymous"
    ></script>
    <script src="/js/validate.js"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light navbar-light" style="background-color: #e3f2fd;">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01"
            aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <a class="navbar-brand" href="#">Gerenciador de Portólios</a>
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/pessoa/list">Pessoas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/projeto/list">Projetos</a>
            </li>
        </ul>

    </div>
</nav>

<div class="container">

    <h1 class="p-3"> Edit Pessoa </h1>

    <form:form action="/pessoa/editSave" method="post" onsubmit="return validarPessoa()" modelAttribute="pessoa">

        <div class="row">
            <div class="form-group col-md-12">
                <div class="col-md-6">
                    <form:hidden path="id" class="form-control input-sm"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="nome">NOME</label>
                <div class="col-md-6">
                    <form:input type="text" path="nome" id="nome"
                                class="form-control input-sm" required="required"/>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="cpf">DT. NASCIMENTO</label>
                <div class="col-md-6">
                    <form:input type="text" path="datanascimento" id="datanascimento"
                                class="form-control input-sm" required="required"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="cpf">CPF</label>
                <div class="col-md-6">
                    <form:input type="text" path="cpf" id="cpf"
                                class="form-control input-sm" required="required"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="cargo">Name</label>
                <div class="col-md-6">
                    <td><input type="radio" name="cargo" value="1" ${pessoa.funcionario ? 'checked' :''}>Funcionário
                    </td>
                    <td><input type="radio" name="cargo" value="2" ${pessoa.gerente ? 'checked' :''}>Gerente</td>
                </div>
            </div>
        </div>


        <div class="row p-2">
            <div class="col-md-2">
                <button type="submit" value="Register" class="btn btn-success">Salvar</button>
            </div>
        </div>

    </form:form>

</div>

<script th:inline="javascript">
    window.onload = function () {

        var msg = "${message}";
        console.log(msg);
        if (msg == "Edit Failure") {
            Command: toastr["error"]("Something went wrong with the edit.")
        }

        toastr.options = {
            "closeButton": true,
            "debug": false,
            "newestOnTop": false,
            "progressBar": true,
            "positionClass": "toast-top-right",
            "preventDuplicates": false,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }
    }
    $('input[name="cpf"]').mask('000.000.000-00');
    $('input[name="datanascimento"]').mask('00/00/0000');
</script>

</body>

</html>