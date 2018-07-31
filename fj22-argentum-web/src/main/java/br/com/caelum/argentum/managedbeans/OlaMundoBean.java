package br.com.caelum.argentum.managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {
	private String mensagem = "Who are you?";
	private String nome;
	
	public String getMensagem() {
		System.out.println("getM");
		return this.mensagem;
	}
	
	public String getNome() {
		System.out.println("getN");
		return this.nome;
	}
	
	public void setNome(String nome) {
		System.out.println("setN");
		this.nome = nome;
	}
	
	public void nomeFoiDigitado() {
		System.out.println("\nChamou el boton");
	}
}
