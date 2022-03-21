<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri= 'http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usu�rios Cadastrados</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">UNION</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.html">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="CreateAndFind">Lista de Usu�rios</a>
        </li>
      </ul>
      <form action="CreateAndFind" method="GET" class="d-flex">
        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o Nome ou CPF" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Buscar</button>
      </form>
    </div>
  </div>
</nav>
<br>
<div class="container">
	<div class="row">
		<div class="cold-md-7">
			<hr>
			<h3>Usu�rios Cadastrados</h3>
			<hr>
			<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>Genero</th>
					<th>CPF</th>
					<th>Nascimento</th>
					<th>Email</th>
					<th>Telefone</th>
					<th>Busca</th>
					<th>Situa��o</th>
				</tr>
			</thead>
			<tbody>			
				<c:forEach items="${clientes}" var="cliente">
				 	<tr>
				 		<td>${cliente.id}</td>
				 		<td>${cliente.nome}</td>
				 		<td>${cliente.genero}</td>
				 		<td>${cliente.cpf}</td>
				 		<td>${cliente.nascimento}</td>
				 		<td>${cliente.email}</td>
				 		<td>${cliente.telefone}</td>
				 		<td>${cliente.busca}</td>
				 		<td>${cliente.situacao}</td>
				 		<td>
				 			<a href="UserDelete?clienteId=${cliente.id}">Deletar</a>
				 			<a href="UserUpdate?clienteId=${cliente.id}">Atualizar</a>
				 		</td>
				 	</tr>
				</c:forEach>
			</tbody>
			</table>
			<h5><a href="index.html">Voltar para o cadastro de usu�rios</a></h5>
		</div>
		
	</div>
</div>

</body>
</html>