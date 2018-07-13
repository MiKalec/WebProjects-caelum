package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.modelo.Contato;

public class MostraParaAdicaoLogic implements Logica{

	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Contato contato = new Contato();
		
		req.setAttribute("contato", contato);
		
		return "adiciona-contato.jsp";
	}

}
