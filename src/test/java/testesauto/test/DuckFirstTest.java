package testesauto.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuckFirstTest {
	private WebDriver driver;
	private final String URL_BASE = "https://duckduckgo.com/";
	private final String PATH_DRIVE = "src/test/resources/chromedriver.exe";
	
	//Prepara e abre o navegador Chrome antes dos testes automatizados começarem
	private void iniciar() { 
		//Define onde está o arquivo chromedriver.exe, que é o programa usado pelo Selenium para controlar o Chrome
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		
		//Cria uma nova instância do navegador em Chrome
		driver = new ChromeDriver();
		
		//Abre o navegador em tela maximizada
		driver.manage().window().maximize();
		
		//Acessa a URL definida
		driver.get(URL_BASE);
	}
	
	@Test
	public void testPesquisarNoDuckGo() {
		//Montagem do cenário
		iniciar();
		
		//Preparação
		WebElement inputPesquisa = driver.findElement(By.id("searchbox_input"));
		
		//Execução
		inputPesquisa.sendKeys("Cookie" + Keys.ENTER);
		
		String resultado = driver.findElement(By.cssSelector("span.EKtkFWMYpwzMKOYr0GYm")).getText();
		
		System.out.println(resultado);
		
		//Verificação e Análise
		assertTrue(resultado, resultado.contains("Cookie"));
		
		driver.quit();
		
	}

}




