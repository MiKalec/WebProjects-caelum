package br.com.caelum.argentum.beans;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.factory.CandleFactory;
import br.com.caelum.argentum.factory.IndicadorFactory;
import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.*;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;

@SuppressWarnings({ "serial", "unused" })
@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable {

	/*
	 * por conta do ViewScoped, que define o escopo da classe como sendo escopo de
	 * uma View, deve implementar serializable
	 */

	private List<Negociacao> negociacoes;
	private ChartModel modeloGrafico;
	private String nomeMedia;
	private String nomeIndicadorBase;

	public ArgentumBean() {
		this.negociacoes = new ClienteWebService().getNegociacoes();
		geraGrafico();
	}

	public void geraGrafico() {
		System.out.println("Plotando: " + nomeMedia + " de " + nomeIndicadorBase);
		List<Candle> candles = new CandleFactory().constoiCandles(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);

		GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
		geradorGrafico.plotaIndicador(new IndicadorFactory(this.nomeMedia, this.nomeIndicadorBase).defineIndicador());
		this.modeloGrafico = geradorGrafico.getModeloGrafico();
	}

	public List<Negociacao> getNegociacoes() {
		return this.negociacoes;
	}

	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}

	public String getNomeMedia() {
		return nomeMedia;
	}

	public void setNomeMedia(String nomeMedia) {
		this.nomeMedia = nomeMedia;
	}

	public String getNomeIndicadorBase() {
		return nomeIndicadorBase;
	}

	public void setNomeIndicadorBase(String nomeIndicadorBase) {
		this.nomeIndicadorBase = nomeIndicadorBase;
	}

}
