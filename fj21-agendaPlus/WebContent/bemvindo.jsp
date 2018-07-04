<html>
	<body>
		<%--JSP começa aqui --%>
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
		<%-- o System.out.... é executado no console da aplicação, nesse caso do Tomcat --%>
		<% 
			System.out.println("Tudo foi executado!");
		%>
	</body>

</html>