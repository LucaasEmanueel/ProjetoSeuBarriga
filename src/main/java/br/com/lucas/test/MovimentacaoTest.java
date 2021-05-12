package br.com.lucas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import br.com.lucas.core.BaseTest;
import br.com.lucas.page.MenuPage;
import br.com.lucas.page.MovimentacaoPage;
import static br.com.lucas.utils.DataUtils.*;

public class MovimentacaoTest extends BaseTest {
		
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	
	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.setMovimentacaoReceita();
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movimentacaoPage.setDataPagamento(obterDataFormatada(new Date()));
		movimentacaoPage.setDescricao("Pagamento efetuado no ano de 2021");
		movimentacaoPage.setInteressado("Lucas Emanuel Tester");
		movimentacaoPage.setDigitarValor("500");
		movimentacaoPage.setConta("Conta para movimentacoes");
		movimentacaoPage.setStatusPago();
		movimentacaoPage.salvar();
		assertEquals("Movimenta��o adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());
		
	}
	
	@Test
	public void test2_CamposObrigatorios() {
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.salvar();
		
		List<String> erros = movimentacaoPage.obterErros();
		assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio",
				"Interessado � obrigat�rio",
				"Valor � obrigat�rio",
				"Valor deve ser um n�mero"
				)));
		assertEquals(6, erros.size());
	
	}
	
	@Test
	public void test3_InserirMovimentacaoFutura() {
		menuPage.acessarTelaCriarMovimentacao();
		movimentacaoPage.setMovimentacaoReceita();
		
		Date dataFutura = obterDataComDiferencaDias(5);
				
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movimentacaoPage.setDataPagamento(obterDataFormatada(dataFutura));
		movimentacaoPage.setDescricao("Pagamento efetuado para fins lucrativo");
		movimentacaoPage.setInteressado("Lucas Testes");
		movimentacaoPage.setDigitarValor("500");
		movimentacaoPage.setConta("Conta com movimentacao");
		movimentacaoPage.setStatusPago();
		movimentacaoPage.salvar();
		
		List<String> erros = movimentacaoPage.obterErros();
		assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
		assertEquals(1, erros.size());
		
	}
	
}
