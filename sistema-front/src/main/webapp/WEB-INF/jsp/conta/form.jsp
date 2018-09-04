<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Agendamento de Transferências</title>
		<style> 
			input[type=text] {
			    width: 100%;
			    padding: 12px 20px;
			    margin: 8px 0;
			    box-sizing: border-box;
			    border: 3px solid #ccc;
			    -webkit-transition: 0.5s;
			    transition: 0.5s;
			    outline: none;
			}
			
			input[type=text]:focus {
			    border: 3px solid #555;
			}
			
		</style>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 		
 		<script src="../js/datepicker-pt-BR.js"></script>
 		<script>
		  $( function() {
		    $( "#dataTransferencia" ).datepicker("option", "dateFormat", "dd/mm/yy");
		    $( "#dataTransferencia" ).datepicker("option", $.datepicker.regional[ "pt-BR" ]);
		    $( "#dataTransferencia" ).datepicker({
		    	changeMonth: true,
		      	changeYear: true
		    });
		  } );
		</script>
	</head>
	<body>
		<div class="container">
			<h1>Agendamento de Transferência</h1>
			
			<c:forEach var="error" items="${errors}">
			    <div class="alert alert-danger"><strong>Erro: </strong>${error.message}</div>
			</c:forEach>
			
			<form action="${linkTo[ContaController].agendar}" method="post">
	            <span>Conta Origem: </span>
	            <input type="text" name="agendamento.contaOrigem"/>
	            
	            <span>Conta Destino: </span>
	            <input type="text" name="agendamento.contaDestino"/>
	            
	            <span>Valor da Transferência: </span>
	            <input type="text" name="agendamento.valorTransferencia"/>
	            
	            <span>Data da Transferência: </span>
	            <input type="text" id="dataTransferencia" name="agendamento.dataTransferencia"/>
	            
	            
	            <button type="submit">Agendar</button>
	        </form>
	        
		</div>
		
	</body>
</html>