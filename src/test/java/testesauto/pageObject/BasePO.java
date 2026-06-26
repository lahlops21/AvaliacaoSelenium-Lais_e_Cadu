package testesauto.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePO {
	/**
	 *  Driver base que será usado pelas pages
	 */
	protected WebDriver driver;
	
	/**
	 * Cosntrutor base para a criação da fábrica de elementos (PageFactory)
	 * @param driver (Driver do navegador atual)
	 */
	public BasePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
