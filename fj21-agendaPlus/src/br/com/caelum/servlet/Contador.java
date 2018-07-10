package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
@SuppressWarnings("all")
public class Contador extends HttpServlet {
	private int contador = 0;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando Contador");
	}

	public void destroy() {
		super.destroy();
		log("Destruindo Contador");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		contador++;

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("Contador agora é: " + this.contador);
		out.println("</body>");
		out.println("</html>");
	}
}
