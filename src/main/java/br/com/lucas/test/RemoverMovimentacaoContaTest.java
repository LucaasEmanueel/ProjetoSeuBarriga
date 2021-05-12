package br.com.lucas.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.lucas.core.BaseTest;
import br.com.lucas.page.ContasPage;
import br.com.lucas.page.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ContasPage contasPage = new ContasPage();
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		contasPage.removerContaEmUso("Conta com movimentacao");
		assertEquals("Conta em uso na movimentações", contasPage.obterMensagemError());
	}

}
