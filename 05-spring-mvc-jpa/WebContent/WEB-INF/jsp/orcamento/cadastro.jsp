<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tags:template titulo="Orçamento">
	
	<h1>Cadastro de Orçamento</h1>
	
	<c:if test="${not empty msg}">
		<div class="alert alert-success">${msg }</div>
	</c:if>
	
	<form:form action="cadastrar" method="post" commandName="orcamento">
		<div class="form-group">
			<form:label path="descricao">Descrição</form:label>
			<form:textarea path="descricao" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="data">Data</form:label>
			<form:input path="data" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="valor">Valor</form:label>
			<form:input path="valor" cssClass="form-control"/>
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary">
	</form:form>
	
</tags:template>