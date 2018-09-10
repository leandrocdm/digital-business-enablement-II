<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tags:template titulo="Cadastro de Produto">
	<h1>Cadastro de Produto</h1>
	
<c:if test="${not empty msg }">
	<div class="alert alert-success">
		${msg }
	</div>
</c:if>
	
<form action="cadastrar" method="post">
	<div class="form-group">
		<label for="id-nome">Nome</label>
		<input type="text" name="nome" class="form-control" id="id-nome">
	</div>
	<div class="form-group">
		<label for="id-preco">Preço</label>
		<input type="text" name="preco" class="form-control" id="id-preco">
	</div>
	<div class="form-group">
		<input type="checkbox" id="id-perecivel" name="perecivel">
		<label for="id-perecivel">Perecível</label>
	</div>
	<input type="submit" value="Cadastrar" class="btn btn-primary">
</form>
	
</tags:template>