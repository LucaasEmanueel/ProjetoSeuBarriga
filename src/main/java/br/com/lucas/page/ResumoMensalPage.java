package br.com.lucas.page;

import org.openqa.selenium.By;
import br.com.lucas.core.BasePage;

public class ResumoMensalPage extends BasePage {
		
	public void clicarBotaoRemover() {
		clicarBotao(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String obterMensagemDeSucesso() {
		return obterTexto(By.xpath(".//div[@class='alert alert-success']"));
	}
	
	public void selecionarAno(String ano) {
		selecionaOCombo("ano", ano);
	}
	
	public void buscar() {
		clicarBotao(By.xpath("//input[@value='Buscar']"));
	}
}
