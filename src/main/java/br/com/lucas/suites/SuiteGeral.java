package br.com.lucas.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.lucas.core.DriverFactory;
import br.com.lucas.page.LoginPage;
import br.com.lucas.test.ContaTest;
import br.com.lucas.test.MovimentacaoTest;
import br.com.lucas.test.RemoverMovimentacaoContaTest;
import br.com.lucas.test.ResumoMensalTest;
import br.com.lucas.test.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoMensalTest.class
})

public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		page.setEmail("lucas.qa@teste.com");
		page.setSenha("lucas.qa");
		page.entrar();
		page.resetar();
		DriverFactory.killDriver();
	}
}
