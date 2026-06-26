package testesauto.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{

	public ProdutoPO(WebDriver driver) {
		super(driver);
				
	}

	@FindBy(id = "btn-adicionar")
	public WebElement buttonCriar;
	
	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id = "valor")
	public WebElement inputValor;
	
	@FindBy(id = "codigo")
	public WebElement inputCodigo;
	
	@FindBy(id = "nome")
	public WebElement inputNome;
	
	@FindBy(id = "data")
	public WebElement inputData;
	
	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;

	@FindBy(id = "btn-sair")
	public WebElement buttonSair;

	@FindBy(id = "cadastro-produto") 
	public WebElement modalCadastro;

	@FindBy(id = "mensagem") 
	public WebElement spanMensagem;
	
	@FindBy(css = "table.table tbody") // Mapeia o corpo da tabela onde os produtos cadastrados aparecem
	public WebElement corpoTabela;
	
	@FindBy(css = "table.table tbody tr:nth-child(1) td:nth-child(6) button:nth-child(1)")
	public WebElement buttonEditar;

	@FindBy(css = "table.table tbody tr:nth-child(1) td:nth-child(6) button:nth-child(2)")
	public WebElement buttonExcluir;
	
	
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto, Keys.TAB);
	}
	
	public void preencherFormulario(String codigo, String nome, String quantidade, String valor, String data) {
		escrever(inputCodigo, codigo);
		escrever(inputNome, nome);
		escrever(inputQuantidade, quantidade);
		escrever(inputValor, valor);
		escrever(inputData, data);
		buttonSalvar.click();
	}
	
	public String obterMensagemDoModal() {
		return this.spanMensagem.getText();
	}
	
	public String obterTextoDaTabela() {
		return this.corpoTabela.getText();
	}
	
	
	public void clicarEmEditar() {
			buttonEditar.click();
	}

	public void clicarEmExcluir() {
			buttonExcluir.click();
	}
	
}
