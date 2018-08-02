package br.com.caelum.argentum.factory;

import java.lang.reflect.Constructor;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;

public class IndicadorFactory {

	private final String nomeMedia;
	private final String nomeIndicadorBase;

	public IndicadorFactory(String indicadorMedia, String indicadorBase) {
		this.nomeMedia = indicadorMedia;
		this.nomeIndicadorBase = indicadorBase;
		
	}
	
	public Indicador defineIndicador() {
		if (nomeIndicadorBase == null || nomeMedia == null) {
			return new MediaMovelSimples(new IndicadorFechamento());
		}
		try {
			// Classes serão definidas em tempo de execução com o reflect
			String pacote = "br.com.caelum.argentum.indicadores.";
			Class<?> classeIndicadorBase = Class.forName(pacote + this.nomeIndicadorBase);
			Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();

			Class<?> classeMedia = Class.forName(pacote + this.nomeMedia);
			Constructor<?> construtorMedia = classeMedia.getConstructor(Indicador.class);
			Indicador indicador = (Indicador) construtorMedia.newInstance(indicadorBase);

			return indicador;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
