<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Add Projeto</title>

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

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"
            integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA="
            crossorigin="anonymous"
    ></script>
    <script src="/js/validate.js"></script>
    <script src="https://cdn.jsdelivr.net/gh/plentz/jquery-maskmoney@master/dist/jquery.maskMoney.min.js"></script>



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
            <li class="nav-item">
                <a class="nav-link" href="/projeto/list">Projetos</a>
            </li>

        </ul>

    </div>
</nav>
<div class="container">

    <h1 class="p-3"> Add Projeto </h1>

    <form:form action="/projeto/save" method="post" onsubmit="return validarProjeto()" modelAttribute="projeto">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="nome">NOME</label>
                <div class="col-md-6">
                    <form:input type="text" path="nome" id="nome"
                                class="form-control input-sm" required="required" />
                </div>
            </div>
        </div>



        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="data_inicio">DT INICIO</label>
                <div class="col-md-6">
                    <form:input type="text" path="data_inicio" id="data_inicio"
                                class="form-control input-sm" required="required" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="data_previsao_fim">DT PREV. FIM</label>
                <div class="col-md-6">
                    <form:input type="text" path="data_previsao_fim" id="data_previsao_fim"
                                class="form-control input-sm" required="required" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="data_fim">DT. FIM</label>
                <div class="col-md-6">
                    <form:input type="text" path="data_fim" id="data_fim"
                                class="form-control input-sm" required="required" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="descricao">DESCRICAO</label>
                <div class="col-md-6">
                    <form:input type="text" path="descricao" id="descricao"
                                class="form-control input-sm" required="required" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="status">STATUS</label>
                <div class="col-md-6">
                    <select path="status" id="status"
                            class="form-control input-sm" required="required" name="status">
                        <option value="">Selecione um risco...</option>
                        <c:forEach items="${statusList}" var="status">
                            <option value="${status}">${status}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="orcamento">ORCAMENTO</label>
                <div class="col-md-6">
                    <form:input type="text" path="orcamento" id="orcamento"
                                class="form-control input-sm" required="required" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="risco">RISCO</label>
                <div class="col-md-6">
                    <select path="risco" id="risco"
                            class="form-control input-sm" required="required" name="risco">
                        <option value="">Selecione um risco...</option>
                        <c:forEach items="${riscoList}" var="risco">
                            <option value="${risco}">${risco}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3" for="risco">GERENTE</label>
                <div class="col-md-6">
                    <select path="idgerente" id="idgerente"
                            class="form-control input-sm" required="required" name="idgerente">
                        <option value="">Selecione um gerente...</option>
                        <c:forEach items="${gerentes}" var="pessoa">
                            <option value="${pessoa.id}">${pessoa.nome}</option>
                        </c:forEach>
                    </select>

                </div>
            </div>
        </div>

        <div class="row p-2">
            <div class="col-md-2">
                <button type="submit" value="Register"  class="btn btn-success">Salvar</button>
            </div>
        </div>

    </form:form>

</div>

<script th:inline="javascript">


    window.onload = function() {


        $('#orcamento').maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});


        var msg = "${message}";
        console.log(msg);
        if (msg == "Save Failure") {
            Command: toastr["error"]("Ocorreu um erro ao salvar.")
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

    $('input[name="data_inicio"]').mask('00/00/0000');
    $('input[name="data_fim"]').mask('00/00/0000');
    $('input[name="data_previsao_fim"]').mask('00/00/0000');

</script>



</body>

</html>