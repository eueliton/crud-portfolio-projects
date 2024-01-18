<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>View Pessoa List</title>

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
			<li class="nav-item active">
				<a class="nav-link" href="/pessoa/list">Pessoas</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/projeto/list">Projetos</a>
			</li>

		</ul>

	</div>
</nav>

    <div class="container">

        <h1 class="p-3"> Pessoas</h1>
		<div class="container text-left">
			<a href="/pessoa/add" class="btn btn-primary btn-block">Add Pessoa</a>
		</div>

 		<br>


		<form:form>

            <table class="table table-bordered">
            	<tr>
            		<th>Id</th>
            		<th>Nome</th>
            		<th>Cpf</th>
					<th>Dt. Nascimento</th>
					<th>Cargo</th>
            		<th></th>
            		<th></th>
            	</tr>

            	<c:forEach var="pessoa" items="${pessoaList}">
                    <tr>
                		<td>${pessoa.id}</td>
                		<td>${pessoa.nome}</td>
						<td>${pessoa.cpf}</td>

						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${pessoa.datanascimento}" /></td>
						<td>${pessoa.gerente ? "Gerente" :"Funcionário"}</td>
                		<td>
							<a href="/pessoa/edit/${pessoa.id}" style="margin:auto; text-align:center; display:block;"  class="btn btn-success">Editar</a>
                		</td>
                		<td>
							<a href="/pessoa/delete/${pessoa.id}"  style="margin:auto; text-align:center; display:block;" class="btn btn-danger">Apagar</a>
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