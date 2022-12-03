package br.ydamasceno.servicos;



import static br.ydamasceno.matchers.MatchersProprios.caiEm;
import static br.ydamasceno.matchers.MatchersProprios.caiNumaSegunda;
import static br.ydamasceno.utils.DataUtils.isMesmaData;
import static br.ydamasceno.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ydamasceno.builder.FilmeBuilder;
import br.ydamasceno.builder.UsuarioBuilder;
import br.ydamasceno.entidades.Filme;
import br.ydamasceno.entidades.Locacao;
import br.ydamasceno.entidades.Usuario;
import br.ydamasceno.exceptions.FilmeSemEstoqueException;
import br.ydamasceno.exceptions.LocadoraException;
import br.ydamasceno.matchers.DiaSemanaMatcher;
import br.ydamasceno.matchers.MatchersProprios;
import br.ydamasceno.utils.DataUtils;


public class LocacaoServiceTest {
	
	private LocacaoService service;
	
	//Definicao do contador
	//private static int contador = 0; //colocado static para ir como escopo da classe, visto que, se não estivesse, a cada teste
	//sempre o valor continuaria sendo 1, ou seja, não incrementaria e acada teste ele seria reinicializado, o que ocasiona em uma
	//dependência entre os testes..

	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void steup() {
		//System.out.println("Before");
		service = new LocacaoService();
		//incremento
		//contador++;
		//impressao
		//System.out.println(contador);
	}
	
	@After
	public void tearDown() {
		//System.out.println("After");
	}
	
	@Test
	public void deveAlugarFilme() throws Exception {
		
		Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY)); //Não será exeutado no sábado
		//estratégia muito usada para verificar se um teste deve ser executado ou não de acordo com algum determinado recurso que esteja disponível
		//ou não.
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filme = Arrays.asList(FilmeBuilder.umFilme().comValor(4.0).agora());
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
			
		//verificacao
		Assert.assertEquals(5.0,locacao.getValor(), 0.1); //melhorando ordem para caso dê um erro a mensagem fique mais clara entre o esperado e 
		//o obtido pelo método. No assertThat muda a ordem, então é bom atentar ao que deve ser colocado no método
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	}
	
	@Test(expected = FilmeSemEstoqueException.class)
	public void deveLancarExceptionAoAlugarFilmeSemEstoque() throws Exception{
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filme = Arrays.asList(FilmeBuilder.umFilme().semEstoque().agora());
		
		//acao
		service.alugarFilme(usuario, filme);
	}
	
	@Test
	public void naoDeveAlugarFilmeSemUsuario() throws FilmeSemEstoqueException{
		//cenario
		List<Filme> filme = Arrays.asList(FilmeBuilder.umFilme().agora());
		
		//acao
		try {
			service.alugarFilme(null, filme);
			Assert.fail();
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usuario vazio"));
	
		}
	}
	

	@Test
	public void naoDeveAlugarFilmeSemFilme() throws FilmeSemEstoqueException, LocadoraException{
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		
		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");
		
		//acao
		service.alugarFilme(usuario, null);
	}
	
//	@Test
//	public void deveDevolverFilmeNaSegundaAoAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
//		Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY)); 
//		//cenario
//		Usuario usuario = UsuarioBuilder.umUsuario().agora();
//		List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().agora());
//		
//		//acao
//		Locacao retorno = service.alugarFilme(usuario, filmes);
//		
//		//verificacao
//		assertThat(retorno.getDataRetorno(), caiNumaSegunda());
//	}
//	
	
}
