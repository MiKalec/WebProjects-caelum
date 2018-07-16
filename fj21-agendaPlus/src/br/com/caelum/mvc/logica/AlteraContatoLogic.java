package br.com.caelum.mvc.logica;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AlteraContatoLogic implements Logica{

	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		
		Connection connection = (Connection) req.getAttribute("connection");
		
		ContatoDao dao = new ContatoDao(connection);
		
		Contato contato = (Contato) dao.pesquisar(id);
		
		PrintWriter out = res.getWriter();
		
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto); 
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		}catch (ParseException e) {
			out.println("Erro de conversão de data");
			return "mvc?logica=ListaContatosLogic";
		}
				
		dao.altera(contato, nome, email, endereco, dataNascimento);
		
		return "mvc?logica=ListaContatosLogic";
	}

}
