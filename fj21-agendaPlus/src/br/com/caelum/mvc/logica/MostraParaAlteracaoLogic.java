package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class MostraParaAlteracaoLogic implements Logica{

	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		Connection connection = (Connection) req.getAttribute("connection");
		
		Contato contato = (Contato) new ContatoDao(connection).pesquisar(id);
		
		req.setAttribute("contato", contato);
		
		return "altera-contato.jsp";
	}

}
