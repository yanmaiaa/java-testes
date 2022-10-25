package br.ydamasceno.servicos;

import static br.ydamasceno.utils.DataUtils.adicionarDias;

import java.util.Date;
import java.util.List;

import br.ydamasceno.entidades.Filme;
import br.ydamasceno.entidades.Locacao;
import br.ydamasceno.entidades.Usuario;
import br.ydamasceno.exceptions.FilmeSemEstoqueException;
import br.ydamasceno.exceptions.LocadoraException;

public class LocacaoService {
	
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws FilmeSemEstoqueException, LocadoraException{
		
		if(usuario == null) {
			throw new LocadoraException("Usuario vazio");
		}
		
		if(filmes == null || filmes.isEmpty()) {
			throw new LocadoraException("Filme vazio");
		}
		
		for(Filme filme: filmes) {
			if(filme.getEstoque() == 0) {
				throw new FilmeSemEstoqueException();
			}
		}
		
		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		Double valorTotal = 0d;
		for(Filme filme: filmes) {
			valorTotal += filme.getPrecoLocacao();
		}
		locacao.setValor(valorTotal);
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);

		
		return locacao;
	}
    
	
}