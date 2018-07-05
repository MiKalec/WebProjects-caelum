<%@ page
	import="java.util.*,br.com.caelum.jdbc.dao.*,br.com.caelum.jdbc.modelo.*,java.text.SimpleDateFormat"%>
<html>
<body>
	<table>
		<tr>
			<td>Nome</td>
			<td>E-mail</td>
			<td>Endereço</td>
			<td>Data de Nascimento</td>
		</tr>
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			for (Contato contato : contatos) {
		%>
		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<%
				String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime());
			%>
			<td><%=dataFormatada%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>