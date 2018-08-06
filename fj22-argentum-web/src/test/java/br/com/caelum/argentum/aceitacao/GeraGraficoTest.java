package br.com.caelum.argentum.aceitacao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class GeraGraficoTest {
	private static final String URL = "http://localhost:8080/fj22-argentum-web/index.xhtml";

	private WebDriver driver;

	@Before
	public void setUp() {
		this.driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		this.driver.close();
	}

	@Test
	public void testeAoGerarGraficoSemTituloMsgApresentada() {
		this.driver.navigate().to(URL);
		WebElement titulo = this.driver.findElement(By.id("dadosGrafico:titulo"));

		titulo.sendKeys("");
		titulo.submit();

		boolean existeMensagem = this.driver.getPageSource().contains("Value is required");

		assertTrue(existeMensagem);

	}
}
