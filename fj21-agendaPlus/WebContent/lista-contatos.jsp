<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>

<html>
	<body>
		<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao" />
		
		<table border="1">
			<tr>
			<td>ID:</td>
			<td>Nome:</td>
			<td>E-mail:</td>
			<td>Endereço:</td>
			<td>Data de Nascimento:</td>
			</tr>
			<c:forEach var="contato" items="${dao.lista}" varStatus="id">
				<tr bgcolor="#${id.count %2==0?'aaee88': 'ffffff'}">
					<td>${id.count}</td>
					<td>${contato.nome}</td>
					<td>
						<c:choose>
							<c:when test="${not empty contato.email}">
								<a href="mailto:${contato.email}"> ${contato.email}</a>
							</c:when>
							<c:otherwise>
								E-mail não informado
							</c:otherwise>
						</c:choose>
					</td>
					<td>${contato.endereco}</td>
					<td>${contato.dataNascimento.time}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>