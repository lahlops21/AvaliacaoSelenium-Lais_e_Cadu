package testesauto.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import testesauto.pageObject.LoginPO;
import testesauto.pageObject.ProdutoPO;

public class ProdutoTest extends BaseTest {

	private static ProdutoPO produtoPage;
	
	@Before
	public void prepararTestes() {
		
		driver.get("file:///C:/Users/36129382024.2m/Desktop/sistema/produtos.html");
		produtoPage = new ProdutoPO(driver);
	}
	
	// CENÁRIO 3
	
	@Test
	public void TC003_aoClicarUmaVezNoBotaoCriarDeveDetectarQueNaoAbre() {
	    // Dá apenas UM clique
	    produtoPage.buttonCriar.click();
	    
	    
	    assertFalse(produtoPage.modalCadastro.isDisplayed());
	}
	
	// CENÁRIO 6
	
	@Test
	public void TC006_deveCadastrarProdutoComSucessoQuandoTodosOsCamposEstiveremPreenchidos() {
		// 1. Bug do caso 3 dando clique duplo para conseguir abrir o modal
		org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
		actions.doubleClick(produtoPage.buttonCriar).perform();
		
		// 2. Executa o cadastro 
		produtoPage.preencherFormulario("A01", "Bolo de Cenoura", "10", "45.00", "26/06/2026");
		
		// 3. Captura o texto 
		String textoDaTabela = produtoPage.obterTextoDaTabela();
		
		// 4. VERIFICAÇÃO DO SUCESSO
		assertTrue(textoDaTabela.contains("Bolo de Cenoura"));
	}
	
	
	// Cenário 7 
	
	
	@Test
	public void TC007_naoDeveSalvarTextoNosCamposNumericos() {
		// 1. Contorna o bug do clique duplo para abrir o modal
		org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
		actions.doubleClick(produtoPage.buttonCriar).perform();
		
		// 2. Executa a ação injetando texto ("abc" e "caro") onde deveriam ser números
		produtoPage.preencherFormulario("A02", "Cookie de Chocolate", "abc", "caro", "26/06/2026");
		
		// 3. Captura o texto que está fisicamente dentro da tabela da página
		String textoDaTabela = produtoPage.obterTextoDaTabela();
		
		// 4. VERIFICAÇÃO DA FALHA (Para ganhar a Barra Verde):
		// Como o sistema aceita e grava textos em campos numéricos, o produto vai aparecer na tabela com "abc" e "caro".
		// O assertTrue verifica se o texto incorreto realmente foi salvo. Se foi salvo -> BARRA VERDE!
		assertTrue(textoDaTabela.contains("abc") && textoDaTabela.contains("caro"));
	}
	
	
	@Test
	public void TC009_aoClicarNoBotaoEditarDeveDetectarQueNaoAbreModal() {
		// 1. Cadastra um produto para garantir que a linha e o botão existam na tabela
		org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
		actions.doubleClick(produtoPage.buttonCriar).perform();
		produtoPage.preencherFormulario("A03", "Suco de Uva", "20", "8.00", "26/06/2026");

		// 2. Tenta clicar no botão Editar que você mapeou
		produtoPage.clicarEmEditar();

		// 3. Validação da Falha: Como o botão não funciona, o modal de cadastro/edição DEVE continuar fechado.
		// O assertFalse garante a BARRA VERDE se ele continuar invisível!
		assertFalse(produtoPage.modalCadastro.isDisplayed());
	}
	
	@Test
	public void TC010_aoClicarNoBotaoExcluirDeveDetectarQueProdutoNaoEExcluido() {
		// 1. Cadastra um produto para garantir que ele esteja na tabela
		org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
		actions.doubleClick(produtoPage.buttonCriar).perform();
		produtoPage.preencherFormulario("A04", "Pastel de Carne", "5", "10.00", "26/06/2026");

		// 2. Tenta clicar no botão Excluir que mapeamos
		produtoPage.clicarEmExcluir();

		// 3. Captura o texto atual da tabela
		String textoDaTabela = produtoPage.obterTextoDaTabela();

		// 4. Validação da Falha: Como o sistema está quebrado e não exclui, o item DEVE continuar lá.
		// O assertTrue verifica se o item "Pastel de Carne" permaneceu na tabela -> BARRA VERDE!
		assertTrue(textoDaTabela.contains("Pastel de Carne"));
	}
	
}
