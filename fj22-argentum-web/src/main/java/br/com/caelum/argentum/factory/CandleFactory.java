package br.com.caelum.argentum.factory;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.Negociacao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandleFactory {

	public Candle constoiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		double maximo = 0;
		double minimo = Double.MAX_VALUE;
		double volume = 0;

		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();

			double preco = negociacao.getPreco(); 	
			if (preco > maximo) {
				maximo = preco;
			}

			if (preco < minimo) {
				minimo = preco;
			}
		}

		if (negociacoes.isEmpty()) {
			minimo = 0.0;
		}

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();

		return new Candle(abertura, fechamento, minimo, maximo, volume, data);
	}

	public List<Candle> constoiCandles(List<Negociacao> negociacoes) {
		List<Candle> candles = new ArrayList<>();

		List<Negociacao> negociacoesDoDia = new ArrayList<>();
		Calendar dataAtual = negociacoes.get(0).getData();

		for (Negociacao negociacao : negociacoes) {
			if (negociacao.getData().before(dataAtual)) {
				throw new IllegalStateException("Negociações em ordem errada");
			}
			if (!negociacao.isMesmoDia(dataAtual)) {
				criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);
				negociacoesDoDia = new ArrayList<>();
				dataAtual = negociacao.getData();
			}
			negociacoesDoDia.add(negociacao);
		}
		criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);
		return candles;
	}

	private void criaEGuardaCandle(List<Candle> candles, List<Negociacao> negociacoesDoDia, Calendar dataAtual) {
		Candle candleDoDia = constoiCandleParaData(dataAtual, negociacoesDoDia);
		candles.add(candleDoDia);
	}
}
