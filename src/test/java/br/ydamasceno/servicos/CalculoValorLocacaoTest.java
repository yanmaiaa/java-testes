package br.ydamasceno.servicos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ydamasceno.entidades.Filme;
import br.ydamasceno.entidades.Locacao;
import br.ydamasceno.entidades.Usuario;
import br.ydamasceno.exceptions.FilmeSemEstoqueException;
import br.ydamasceno.exceptions.LocadoraException;

@RunWith(Parameterized.class) //Data Driven Test
public class CalculoValorLocacaoTest {
	
	//Deixando o teste generico
	@Parameter //valor principal
	public List<Filme> filmes;
	
	@Parameter(value=1) //segundo registro do array, valor 1
	public Double valorLocacao;
	
	@Parameter(value=2)
	public String cenario;
	
	private LocacaoService service;
	
	@Before
	public void setup() {
		service = new LocacaoService();
	}
	
	private static Filme filme1 = new Filme("Filme 1", 2, 4.0);
	private static Filme filme2 = new Filme("Filme 2", 2, 4.0);
	private static Filme filme3 = new Filme("Filme 3", 2, 4.0);
	private static Filme filme4 = new Filme("Filme 4", 2, 4.0);
	private static Filme filme5 = new Filme("Filme 5", 2, 4.0);
	private static Filme filme6 = new Filme("Filme 6", 2, 4.0);
	private static Filme filme7 = new Filme("Filme 6", 2, 4.0);
	
	
	//conjunto de dados
	@Parameters(name="{2}")
	public static Collection<Object[]> getParametros(){
		return Arrays.asList(new Object[][] {
			{Arrays.asList(filme1, filme2), 8.00, "2 Filmes: Sem Desconto"}, //cenario adicionado novo
			{Arrays.asList(filme1, filme2, filme3), 11.00, "3 Filmes: 25%"}, //cenario 1
			{Arrays.asList(filme1, filme2, filme3, filme4), 13.00, "4 Filmes: 50%"}, //cenario 2
			{Arrays.asList(filme1, filme2, filme3, filme4, filme5), 14.00, "5 Filmes: 75%"}, //cenario 3
			{Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6), 14.00, "6 Filmes: 100%"}, //cenario 4
			{Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6, filme7), 18.00, "7 Filmes: Sem Desconto"} //cenario adicionado novo
		});
	}
	
	@Test
	public void deveCalcularValorLocacaoConsiderandoDescontos() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		Usuario usuario = new Usuario("Usuario 1");
		
		//acao
		Locacao resultado = service.alugarFilme(usuario, filmes);
		
		//verificacao
		assertThat(resultado.getValor(), is(valorLocacao));
		
	}
	


}
