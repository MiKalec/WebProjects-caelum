<html>
	<body>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

		<c:import url="cabecalho.jsp"/>

		<!-- Não se faz mais necessária
			 <jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao" />
		-->
		
		<table border="1">
			<tr>
			<td>ID:</td>
			<td>Nome:</td>
			<td>E-mail:</td>
			<td>Endereço:</td>
			<td>Data de Nascimento:</td>
			</tr>
			<c:forEach var="contato" items="${contatos}" varStatus="id">
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
					<td><fmt:formatDate value = "${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
					<td>
						<a href="mvc?logica=RemoveContatoLogic&id=${contato.id }">Remover</a>
					</td>
					 <td>
						<a href="mvc?logica=MostraParaAlteracaoLogic&id=${contato.id }">Alterar</a>
					</td> 
				</tr>
			</c:forEach>
		</table>
		<button>
			<a href="adiciona-contato.jsp"> Adicionar Contatos</a>
		</button>
		<c:import url="rodape.jsp"/>
	</body>
</html>