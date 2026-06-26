package testesauto.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import testesauto.pageObject.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest{
	
	private static LoginPO loginPage;
	
	@Before
	public void prepararTestes() {
		//driver.get("https://dukduckgo");
		driver.get("file:///C:/Users/aluno.santaluzia/Documents/sistema/sistema/login.html");
//		C:\Users\36129382024.2m\Desktop\sistema
		loginPage = new LoginPO(driver);
	}
	
	@Test
	public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
		//loginPage.inputEmail.sendKeys("");
		//loginPage.inputSenha.sendKeys("");
		//loginPage.buttonEntrar.click();
		loginPage.executarAcaoDeLogar("", "");
		
		String mensagemModal = loginPage.spanMensagem.getText();
		
		assertEquals(mensagemModal, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC004_naoDeveLogarNoSistemaComEmailESenhaErrados() {
		loginPage.executarAcaoDeLogar("teste", "teste");

		String mensagemModal = loginPage.obterMensagem();
		
		assertEquals(mensagemModal, "E-mail ou senha inválidos");
	}
	
	@Test
	public void TC007_deveLogarNoSistemaComEmailESenhaCorretos() {
		loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
		
		assertEquals(loginPage.obterTituloDaPagina(), "Controle de Produtos");
	}
}
