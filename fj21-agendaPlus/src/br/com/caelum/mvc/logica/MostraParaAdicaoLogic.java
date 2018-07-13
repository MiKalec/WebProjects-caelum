package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.modelo.Contato;

public class MostraParaAdicaoLogic implements Logica{

	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
				
		return "adiciona-contato.jsp";
	}

}
