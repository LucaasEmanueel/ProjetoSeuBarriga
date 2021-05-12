package br.com.lucas.page;

import org.openqa.selenium.By;

import br.com.lucas.core.BasePage;

public class ContasPage extends BasePage {
	
	public void setNome(String nome) {
		escrever("nome", nome);
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}	
	
	public void clicarAlterarConta(String string) {
		obterCelula("Conta",string, "Ações","tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}
	
	public String obterMensagemSucesso(){
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obterMensagemError(){
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public void removerContaEmUso(String string) {
		obterCelula("Conta", string, "Ações","tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	

}
