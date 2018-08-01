package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.factory.CandleFactory;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.Negociacao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestaDataNulla {
    public static void main(String[] args){
        Calendar hoje = null;

        Negociacao petrobras = new Negociacao(30, 32, hoje);

        List<Negociacao> negociacoes = Arrays.asList(petrobras);

        CandleFactory factory = new CandleFactory();
        Candle candlestick = factory.constoiCandleParaData(hoje, negociacoes);

        System.out.println(candlestick);
    }
}
