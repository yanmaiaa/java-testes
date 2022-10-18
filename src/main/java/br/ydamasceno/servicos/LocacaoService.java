package br.ydamasceno.servicos;

import static br.ydamasceno.utils.DataUtils.adicionarDias;

import java.util.Date;

import br.ydamasceno.entidades.Filme;
import br.ydamasceno.entidades.Locacao;
import br.ydamasceno.entidades.Usuario;

public class LocacaoService {
	
	//Testando visibilidade das variáveis, pois, como a estrutura da pasta de teste dessa classe está no mesmo pacote, só que na parte de testes
	//ela terá acesso a determinados métodos e variáveis dessa classe conforme a sua visibilidade 
	//Por esse motivo é bom colocarmos na mesma estrutura de pastas a parte dos testes, pois o java entenderá que estão juntos e dará a visibilidade
	//necessária para a classe de teste.
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