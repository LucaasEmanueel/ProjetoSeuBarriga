package br.com.lucas.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import br.com.lucas.core.BaseTest;
import br.com.lucas.page.HomePage;
import br.com.lucas.page.MenuPage;

public class SaldoTest extends BaseTest {
	
	
	private HomePage home = new HomePage();
	MenuPage page = new MenuPage();
	
	@Test
	public void testSaldoEmConta() {
		page.acessarTelaHome();
		assertEquals("534.00", home.getSaldoDaConta("Conta para saldo"));
		
		
	}
}
