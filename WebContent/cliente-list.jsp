<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Clientes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark">

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Clientes</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Clientes</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>CPF</th>
						<th>Nome</th>
						<th>Email</th>
						<th>Nascimento</th>
						<th>Sexo</th>
						<th>Estado Civil</th>
						<th>Ativo</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="cliente" items="${listClientes}">

						<tr>
							<td><c:out value="${cliente.cpf}" /></td>
							<td><c:out value="${cliente.nome}" /></td>
							<td><c:out value="${cliente.email}" /></td>
							<td><c:out value="${cliente.dtNasc}" /></td>
							<td><c:out value="${cliente.sexo}" /></td>
							<td><c:out value="${cliente.estadoCivil}" /></td>
							<td><c:out value="${cliente.ativo}" /></td>
							<td><a href="edit?id=<c:out value='${cliente.cpf}' />">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${cliente.cpf}' />">Remover</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>