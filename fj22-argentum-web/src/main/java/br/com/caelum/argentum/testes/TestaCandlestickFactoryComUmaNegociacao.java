package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.factory.CandleFactory;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.Negociacao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestaCandlestickFactoryComUmaNegociacao {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao1);

        CandleFactory factory = new CandleFactory();

        Candle candlestick = factory.constoiCandleParaData(hoje, negociacoes);

        System.out.println(candlestick);
    }
}
