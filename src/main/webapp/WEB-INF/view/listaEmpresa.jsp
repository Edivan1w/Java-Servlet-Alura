<%@page
	import="java.util.List, br.com.alura.gerenciador.modelo.Empresa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

     <c:import url="logout-parcial.jsp"></c:import>
       

     Usuário logado: ${usuario.login}

    <br/>
    <br/> 
    <br/>
	Lista de empresas:
	<br />
	<ul>
		<c:forEach items="${empresa }" var="empr">
			<li>${ empr.nome} <fmt:formatDate value="${ empr.dataAbertura }" pattern="dd/MM/yyyy"/> 
			<a href="/cadastro-empresa/entrada?acao=MostraEmpresa&id=${empr.id}">editar</a>
			<a href="/cadastro-empresa/entrada?acao=RemoveEmpresa&id=${empr.id}" >remove</a>
			</li>
		</c:forEach>
	</ul>
       <br/> 
    <br/>
    



</body>
</html>