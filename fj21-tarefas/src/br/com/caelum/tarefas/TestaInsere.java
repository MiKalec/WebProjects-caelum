package br.com.caelum.tarefas;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

import java.util.Calendar;

public class TestaInsere {
    public static void main(String[]args){
    	Tarefa tarefa = new Tarefa();
    	JdbcTarefaDao dao = new JdbcTarefaDao();
    	
    	tarefa.setDescricao("Alguma coisa");
    	tarefa.setFinalizado(false);
    	tarefa.setDataFinalizacao(Calendar.getInstance());
    	
    	
        dao.adiciona(tarefa);

        System.out.println("Gravado!");
    }
}
