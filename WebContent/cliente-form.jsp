<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Formulário Cliente</title>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${cliente != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${cliente == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${cliente != null}">
            			Edit Cliente
            		</c:if>
						<c:if test="${cliente == null}">
            			Add New Cliente
            		</c:if>
					</h2>
				</caption>

				<c:if test="${cliente != null}">
					<input type="hidden" name="cpf" value="<c:out value='${cliente.cpf}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${cliente.nome}' />" class="form-control"
						name="nome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${cliente.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Data de Nascimento</label> <input type="text"
						value="<c:out value='${cliente.dtNasc}' />" class="form-control"
						name="dt_nasc">
				</fieldset>
				
				<fieldset class="form-check">
					<label>Sexo</label> <input type="radio"
						value="<c:out value='${cliente.sexo}' />" class="form-check"
						name="sexo">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Estado Civil</label> 
					<option><input type="text"
						value="<c:out value='${cliente.estadoCivil}' />" class="form-control"
						name="estado_civil">
					</option>
				</fieldset>
				
				<fieldset class="form-check">
					<label>Ativo</label> <input type="checkbox"
						value="<c:out value='${cliente.ativo}' />" class="form-check-input"
						name="ativo">
				</fieldset>

				<button type="submit" class="btn btn-success">Enviar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>