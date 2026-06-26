package testesauto.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	protected static WebDriver driver;
	private static final String URL_BASE = "https://duckduckgo.com/";
	private static final String PATH_DRIVE = "src/test/resources/chromedriver.exe";

	//Prepara e abre o navegador Chrome antes dos testes automatizados começarem
	@BeforeClass
	public static void iniciar() { 
		//Define onde está o arquivo chromedriver.exe, que é o programa usado pelo Selenium para controlar o Chrome
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);

		//Cria uma nova instância do navegador em Chrome
		driver = new ChromeDriver();

		//Abre o navegador em tela maximizada
		driver.manage().window().maximize();

		//Acessa a URL definida
		driver.get(URL_BASE);
	}

	@AfterClass
	public static void finalizar() {
		driver.quit();
	}

}
