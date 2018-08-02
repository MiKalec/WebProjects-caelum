package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.argentum.modelo.GeradorDeSerie;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderadaTest {

	@Test
	public void sequenciaSimplesDeCansles() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6);
		Indicador mmp = new MediaMovelPonderada();//Indicador mmp = new MediaMovelPonderada(3)

		assertEquals(14.0 / 6, mmp.calcula(2, serie), 0.00001);
		assertEquals(20.0 / 6, mmp.calcula(3, serie), 0.00001);
		assertEquals(26.0 / 6, mmp.calcula(4, serie), 0.00001);
		assertEquals(32.0 / 6, mmp.calcula(5, serie), 0.00001);
	}
	/*
	@Test(expected = IllegalArgumentException.class)
	public void negativo() {
		new MediaMovelPonderada(-2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void zerado() {
		new MediaMovelPonderada(0);
	}*/
	

}
