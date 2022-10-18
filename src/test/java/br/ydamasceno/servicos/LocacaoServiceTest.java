package br.ydamasceno.servicos;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.ydamasceno.entidades.Filme;
import br.ydamasceno.entidades.Locacao;
import br.ydamasceno.entidades.Usuario;
import br.ydamasceno.utils.DataUtils;

public class LocacaoServiceTest {
	
	@Test
	public void testeInicial() {
		//cenario -> Inicializamos o que precisamos
		LocacaoService service = new LocacaoService(); 
		Usuario usuario = new Usuario();
		Filme filme = new Filme("Filme 1", 2, 5.0);
		//acao
	    Locacao locacao = service.alugarFilme(usuario, filme); 

		//verificacao
		Assert.assertEquals(5.0,locacao.getValor(), 0.1); //melhorando ordem para caso dê um erro a mensagem fique mais clara entre o esperado e 
		//o obtido pelo método. No assertThat muda a ordem, então é bom atentar ao que deve ser colocado no método
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(),DataUtils.obterDataComDiferencaDias(1)));
		
	}   

}
