package testesauto.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{
	
	public LoginPO(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="email")
	public WebElement inputEmail;
	
	@FindBy(id="senha")
	public WebElement inputSenha;
	
	@FindBy(id="btn-entrar")
	public WebElement buttonEntrar;
	
	@FindBy(id="mensagem")
	public WebElement spanMensagem;
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto, Keys.TAB);
	}
	
	public void executarAcaoDeLogar(String email, String senha) {
		escrever(inputEmail, email);
		escrever(inputSenha, senha);
		buttonEntrar.click();
	}
	
	public String obterTituloDaPagina() {
		return driver.getTitle();
	}
	
	
	
	
	
	

}
