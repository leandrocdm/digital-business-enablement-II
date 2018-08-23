<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tags:template titulo="Lista">



	<table class="table">

		<tr>
			<th>Nome</th>
			<th>Preco</th>
			<th>Perecivel</th>
		</tr>

		<c:forEach items="${listar}" var="produto">
			<tr>
				<td>${produto.nome }</td>
				<td>${produto.preco }</td>
				<td>${produto.perecivel }</td>
			</tr>
		</c:forEach>
	</table>


</tags:template>