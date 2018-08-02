package br.com.caelum.argentum.modelo;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Calendar;

public class CandleTest {
    @Test(expected = IllegalArgumentException.class)
    public void precoMaximoNaoPodeSerMenorQueMinimo(){
        new Candle(40.0, 38.0, 40.0,
                38.0, 20000.0, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void valorAberturaNegativo(){
        new Candle(-40.0, 38.0, 40.0,
                38.0, 20000.0, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void valorFechamentoNegativo(){
        new Candle(40.0, -38.0, 40.0,
                38.0, 20000.0, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void valorMinimoNegativo(){
        new Candle(40.0, 38.0, -40.0,
                38.0, 20000.0, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void valorMaximoNegativo(){
        new Candle(40.0, 38.0, 40.0,
                -38.0, 20000.0, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void valorVolumeNegativo(){
        new Candle(40.0, 38.0, 40.0,
                38.0, -20000.0, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void dataNulla(){
        new Candle(40.0, 38.0, 40.0,
                38.0, -20000.0, null);
    }

    @Test
    public void aberturaIgualFechamentoEhAlta(){
        Candle candle = new Candle(40.0, 40.0,
                40.0, 45.0, 2310.0, Calendar.getInstance());

        assertTrue(candle.isAlta());
    }
}
