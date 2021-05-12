package br.com.lucas.test;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.lucas.core.BaseTest;
import static br.com.lucas.core.DriverFactory.*;
import br.com.lucas.page.MenuPage;
import br.com.lucas.page.ResumoMensalPage;


public class ResumoMensalTest extends BaseTest {
	
	private ResumoMensalPage resumoMen = new ResumoMensalPage();
	private MenuPage menu = new MenuPage();
	
	@Test
	public void test1_RemoverMovimentacao() {
		menu.acessarTelaResumoMensal();
		resumoMen.clicarBotaoRemover();
		assertEquals("Movimentação removida com sucesso!", resumoMen.obterMensagemDeSucesso());
	}
	
	@Test
	public void test2_resumoMensal() {
		menu.acessarTelaResumoMensal();
		assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		resumoMen.selecionarAno("2020");
		resumoMen.buscar();
		
		List<WebElement> elementosEncontrados =	getDriver().findElements(By.xpath("//table[@id='tabelaExtrato']/tbody/tr"));
		assertEquals(0,elementosEncontrados.size());
		
	
	}

}
