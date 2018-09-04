<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Agendamento de Transferências</title>
	   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
		
			<h1>Lista de Agendamentos</h1>
	        <table id="agendamentos" class="table table-hover">
	        	<thead>
		            <tr>
		                <td>Conta Origem</td>
		                <td>Conta Destino</td>
		                <td>Valor (R$)</td>
		                <td>Taxa (R$)</td>
		                <td>Data da Transferência</td>
		                <td>Data da Solicitação</td>
		            </tr>
				</thead>
				<tbody>
		            <c:forEach items="${transferenciaList}" var="item">
		            <tr>
		                <td>${item.contaOrigem}</td>
		                <td>${item.contaDestino}</td>
		                <td><fmt:formatNumber type="number" value="${item.valor}" /></td>
		                <td><fmt:formatNumber type="number" value="${item.taxa}" /></td>
		                <td>${item.dataTransferencia} </td>
		                <td>${item.dataAgendamento}</td>
		            </tr>
		            </c:forEach>
				</tbody>
	        </table>      
	        <br/>
	          
	        <a href="${linkTo[ContaController].form}">Agendar</a>
		</div>
	</body>
</html>