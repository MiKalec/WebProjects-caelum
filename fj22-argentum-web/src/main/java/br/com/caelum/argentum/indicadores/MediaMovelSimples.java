package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {

	private Indicador outroIndicador;

	public MediaMovelSimples() {
	}

	public MediaMovelSimples(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
	}

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		for (int i = posicao; i > posicao - 3; i--) {
			soma += this.outroIndicador.calcula(i, serie);
		}

		return soma / 3;
	}

	@Override
	public String toString() {
		return "Média Móvel Simples";
	}

	/*
	 * private int intervaloDeDias;
	 * 
	 * public MediaMovelSimples(int intervaloDeDias) { if(intervaloDeDias <= 0) {
	 * throw new IllegalArgumentException("Intervalo de dias negativo ou zero"); }
	 * this.intervaloDeDias = intervaloDeDias; }
	 */

}
