<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>View Projeto List</title>

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




</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light navbar-light" style="background-color: #e3f2fd;">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
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
            <li class="nav-item active">
                <a class="nav-link" href="/projeto/list">Projetos</a>
            </li>

        </ul>

    </div>
</nav>

<div class="container">

    <h1 class="p-3"> Projetos</h1>
    <div class="container text-left">
        <a href="/projeto/add" class="btn btn-primary btn-block">Add Projeto</a>
    </div>

    <br>


    <form:form>

        <table class="table table-bordered">
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Dt. Início</th>
                <th>Dt. Prev. Fim</th>
                <th>Dt. Fim</th>
                <th>Descrição</th>
                <th>Status</th>
                <th>Orçamento</th>
                <th>Risco</th>
                <th>Gerente</th>
                <th>Membros</th>
                <th></th>
                <th></th>
            </tr>

            <c:forEach var="projeto" items="${projetoList}">
                <tr>
                    <td>${projeto.id}</td>
                    <td>${projeto.nome}</td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${projeto.data_inicio}" /></td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${projeto.data_previsao_fim}" /></td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${projeto.data_fim}" /></td>
                    <td>${projeto.descricao}</td>
                    <td>${projeto.status}</td>
                    <td><fmt:formatNumber pattern="#,#00.00#"   value="${projeto.orcamento}" /></td>
                    <td>${projeto.risco}</td>
                    <td>${projeto.nomeGerente}</td>
                    <td>${projeto.membros}</td>

                    <td>
                        <a href="/projeto/edit/${projeto.id}" style="margin:auto; text-align:center; display:block;"  class="btn btn-success">Editar</a>
                    </td>
                    <td>
                        <a href="/projeto/delete/${projeto.id}"  style="margin:auto; text-align:center; display:block;" class="btn btn-danger">Apagar</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </form:form>


</div>

<script th:inline="javascript">
    window.onload = function() {

        var msg = "${message}";
        console.log(msg);
        if (msg == "Save Success") {
            Command: toastr["success"]("Registro adicionado com sucesso!")
        } else if (msg == "Delete Success") {
            Command: toastr["success"]("Registro apagada com sucesos!")
        } else if (msg == "Delete Failure") {
            Command: toastr["error"]("Algum erro ocorreu ao apagar o registro!")
        } else if (msg == "Edit Success") {
            Command: toastr["success"]("Registro atualizado com sucesso!")
        } else if (msg == "Delete Failure Status") {
            Command: toastr["error"]("O status atual do projeto não permite apagar o registro!")
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
</script>

</body>

</html>