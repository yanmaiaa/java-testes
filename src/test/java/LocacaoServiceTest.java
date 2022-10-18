

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.ydamasceno.entidades.Filme;
import br.ydamasceno.entidades.Locacao;
import br.ydamasceno.entidades.Usuario;
import br.ydamasceno.servicos.LocacaoService;
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
		Assert.assertTrue(locacao.getValor() == 5.0);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(),DataUtils.obterDataComDiferencaDias(1)));
		
	}   

}
