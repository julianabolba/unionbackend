<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri= 'http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profissionais Cadastrados</title>
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
          <a class="nav-link" href="CreateAndFind">Lista de Profissionais</a>
        </li>
      </ul>
      <form action="CreateAndFind" method="GET" class="d-flex">
        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o Nome ou CPF" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Ajudar</button>
      </form>
    </div>
  </div>
</nav>
<br>
<div class="container">
	<div class="row">
		<div class="cold-md-7">
			<hr>
			<h3>Profissionais Cadastrados</h3>
			<hr>
			<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>Area</th>
					<th>CPF</th>
					<th>Nascimento</th>
					<th>Email</th>
					<th>Telefone</th>
					<th>Ajuda</th>
					<th>Situação</th>
				</tr>
			</thead>
			<tbody>			
				<c:forEach items="${profissionais}" var="profissional">
				 	<tr>
				 		<td>${profissional.id}</td>
				 		<td>${profissional.nome}</td>
				 		<td>${profissional.area}</td>
				 		<td>${profissional.cpf}</td>
				 		<td>${profissional.nascimento}</td>
				 		<td>${profissional.email}</td>
				 		<td>${profissional.telefone}</td>
				 		<td>${profissional.ajuda}</td>
				 		<td>${profissional.situacao}</td>
				 		<td>
				 			<a href="ProDelete?profissionalId=${profissional.id}">Deletar</a>
				 			<a href="ProUpdate?profissionalId=${profissional.id}">Atualizar</a>
				 		</td>
				 	</tr>
				</c:forEach>
			</tbody>
			</table>
			<h5><a href="indexpro.html">Voltar para o cadastro de profissionais</a></h5>
		</div>
		
	</div>
</div>

</body>
</html>