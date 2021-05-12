package br.com.lucas.page;
import br.com.lucas.core.BasePage;

public class MenuPage extends BasePage {
	
	
	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");	
	}
	
	public void acessarTelaListarConta() {
		clicarLink("Contas");
		clicarLink("Listar");
	}
	
	public void acessarTelaCriarMovimentacao() {
		clicarLink("Criar Movimentação");
	}
	
	public void acessarTelaResumoMensal() {
		clicarLink("Resumo Mensal");
	}
	
	public void acessarTelaHome() {
		clicarLink("Home");
	}
}
