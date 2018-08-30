<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template titulo="Editar">


	<c:url var="link" value="/produto/editar"/>
	<form:form action="${link}" method="post" commandName="produto">
	<form:hidden path="codigo"/>
		<div class="container">
			<div class="form-group"> 
			<form:label path="nome">Nome</form:label> 
			<form:textarea path="nome" cssClass="form-control"/>
			 </div>

			<input type="submit" value="Editar" class="btn btn-info">
		</div>
	</form:form>


</tags:template>