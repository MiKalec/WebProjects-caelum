package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {
	
	private Indicador outroIndicador;

	public MediaMovelPonderada() {
	}
	
	public MediaMovelPonderada(Indicador outroIndicador) {
		outroIndicador = outroIndicador;
	}
	
	

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		int peso = 3;

		for (int i = posicao; i > posicao - 3; i--) {
			soma += this.outroIndicador.calcula(i, serie) * peso;
			peso--;
		}

		return soma / 6;
	}

	@Override
	public String toString() {
		return "MMP de Fechamento";
	}

	/*
	 * private int intervaloDeDias;
	 * 
	 * public MediaMovelPonderada(int intervaloDeDias) { if(intervaloDeDias <= 0) {
	 * throw new IllegalArgumentException("Intervalo de dias negativo ou zero"); }
	 * this.intervaloDeDias = intervaloDeDias; }
	 */
}
