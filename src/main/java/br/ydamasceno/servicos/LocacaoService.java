package br.ydamasceno.servicos;

import static br.ydamasceno.utils.DataUtils.adicionarDias;

import java.util.Date;

import br.ydamasceno.entidades.Filme;
import br.ydamasceno.entidades.Locacao;
import br.ydamasceno.entidades.Usuario;

public class LocacaoService {
	
	//Testando visibilidade das vari�veis, pois, como a estrutura da pasta de teste dessa classe est� no mesmo pacote, s� que na parte de testes
	//ela ter� acesso a determinados m�todos e vari�veis dessa classe conforme a sua visibilidade 
	//Por esse motivo � bom colocarmos na mesma estrutura de pastas a parte dos testes, pois o java entender� que est�o juntos e dar� a visibilidade
	//necess�ria para a classe de teste.
	public String variavelPublica;
	protected String variavelProtegida;
	private String variavelPrivada;
	String variavelDefault;
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);

		
		return locacao;
	}
    
	
}