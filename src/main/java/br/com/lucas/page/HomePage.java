package br.com.lucas.page;


import br.com.lucas.core.BasePage;

public class HomePage extends BasePage {
	
	public String getSaldoDaConta(String nomeDaConta) {
		return obterCelula("Conta", nomeDaConta, "Saldo", "tabelaSaldo").getText();
	}
}
