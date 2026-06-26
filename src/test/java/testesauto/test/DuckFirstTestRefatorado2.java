package testesauto.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import testesauto.pageObject.DuckPO;

public class DuckFirstTestRefatorado2 extends BaseTest{
	
	private static DuckPO duckPage;
	
	@Before
	public void prepararTestes() {
		driver.get("https://duckduckgo.com");
		duckPage = new DuckPO(driver);
	}

	
	@Test
	public void testPesquisarNoDuckGo() {
		//Montagem do cenário
		//iniciar();
		
		//Preparação
		//WebElement inputPesquisa = driver.findElement(By.id("searchbox_input"));
		
		//Execução
		//inputPesquisa.sendKeys("Cookie" + Keys.ENTER);
		duckPage.inputPesquisa.sendKeys("Cookie" + Keys.ENTER);
		
		//String resultado = driver.findElement(By.cssSelector("span.EKtkFWMYpwzMKOYr0GYm")).getText();
		String resultado = duckPage.resultado.getText();
		
		System.out.println(resultado);
		
		//Verificação e Análise
		assertTrue(resultado, resultado.contains("Cookie"));
		
		//driver.quit();
		
	}
	
	
	@Test
	public void testPesquisarNoDuckGo2() {
		duckPage.inputPesquisa.sendKeys("Cookie" + Keys.ENTER);
		
		String resultado = duckPage.resultado.getText();
		
		assertTrue(resultado, resultado.contains("Cookie"));	
	}

}




