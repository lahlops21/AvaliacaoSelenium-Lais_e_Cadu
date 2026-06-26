package testesauto.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;

import testesauto.pageObject.DuckPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DuckFirstTestRefatorado4 extends BaseTest{
	
	private static DuckPO duckPage;
	
	@Before
	public void prepararTestes() {
		driver.get("https://duckduckgo.com");
		duckPage = new DuckPO(driver);
	}

	@Test
	//public void testPesquisarNoDuckGo2() {
	public void TC001_deveSerPossivelPesquisarNoDuckGoTextoReceitaDeCookie() {
		duckPage.inputPesquisa.sendKeys("Cookie" + Keys.ENTER);
		
		String resultado = duckPage.resultado.getText();
		
		assertTrue(resultado, resultado.contains("Cookie"));	
	}
	
	@Test
	//public void testPesquisarNoDuckGo3() {
	public void TC002_deveSerPossivelPesquisarNoDuckGoTextoReceitaDeCookie() {
		//duckPage.inputPesquisa.sendKeys("Cookie" + Keys.ENTER);
		duckPage.pesquisar("Cookie"); //mesma coisa da linha acima, porém mais elegante
		
		//String resultado = duckPage.resultado.getText();
		String resultado = duckPage.obterResultadoDaPesquisa(); //mesma coisa da linha acima, porém mais elegante
		
		assertTrue(resultado, resultado.contains("Cookie"));	
	}

}




