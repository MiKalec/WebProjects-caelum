<html>
	<body>
		<%--JSP come�a aqui --%>
		<%
			String mensagem = "Bem vindo ao sistema de agenda";
		%>
		<%out.println(mensagem);%>
		<br />
		<%
			String desenvolvido = "Desenvolvido por Micael";
		%>
		<%--outro modo de printar --%>
		<%= desenvolvido %>
		
		<br />
		<%-- o System.out.... � executado no console da aplica��o, nesse caso do Tomcat --%>
		<% 
			System.out.println("Tudo foi executado!");
		%>
	</body>

</html>