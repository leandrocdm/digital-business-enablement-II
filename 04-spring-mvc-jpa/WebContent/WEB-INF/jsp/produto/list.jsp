<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template titulo="Lista">

	<c:if test="${not empty msgEdicao }">
		<div class="alert alert-primary">${msgEdicao}</div>
	</c:if>
	
		<c:if test="${not empty msgDelete }">
		<div class="alert alert-danger">${msgDelete}</div>
	</c:if>

	<table class="table table-dark">

		<tr>
			<th>Nome</th>
			<th>Preco</th>
			<th>Perecivel</th>
			<th></th>
			<th></th>
		</tr>

		<c:forEach items="${listar}" var="produto">
			<tr>
				<td>${produto.nome }</td>
				<td>${produto.preco }</td>
				<td>${produto.perecivel ? "Sim":"Nao"}</td>
				<td>
				<a href="<c:url value="/produto/editar/${produto.codigo }"/>">Alterar</a>
				</td>
				<td>
				<a href="<c:url value="/produto/excluir/${produto.codigo }"/>">Excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>


</tags:template>