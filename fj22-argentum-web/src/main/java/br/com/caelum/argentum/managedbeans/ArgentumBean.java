package br.com.caelum.argentum.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.factory.CandleFactory;
import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.IndicadorAbertura;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelPonderada;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;

@SuppressWarnings({ "serial", "unused" })
@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable{
	
	//por conta do ViewScoped deve implementar serializable
	
	private List<Negociacao> negociacoes;
	private ChartModel modeloGrafico;
	
	public ArgentumBean() {
		this.negociacoes = new ClienteWebService().getNegociacoes();
		List<Candle> candles = new CandleFactory().constoiCandles(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		
		GeradorModeloGrafico geradorGrafico = 
				new GeradorModeloGrafico(serie, 2, serie.getUltimaPosicao());
		geradorGrafico.plotaIndicador(new MediaMovelSimples(new IndicadorFechamento()));
		this.modeloGrafico = geradorGrafico.getModeloGrafico();
	}
	
	public List<Negociacao> getNegociacoes(){
		return this.negociacoes;
	}
	
	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}
}
