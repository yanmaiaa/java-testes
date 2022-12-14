package br.ydamasceno.servicos;

import static br.ydamasceno.utils.DataUtils.adicionarDias;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.ydamasceno.entidades.Filme;
import br.ydamasceno.entidades.Locacao;
import br.ydamasceno.entidades.Usuario;
import br.ydamasceno.exceptions.FilmeSemEstoqueException;
import br.ydamasceno.exceptions.LocadoraException;
import br.ydamasceno.utils.DataUtils;

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
		for(int i = 0; i < filmes.size(); i++) {
			Filme filme = filmes.get(i);
			Double valorDoFilme = filme.getPrecoLocacao();
			
			switch(i) {
				case 2: valorDoFilme = valorDoFilme * 0.75;
					break;
				case 3: valorDoFilme = valorDoFilme * 0.5;
					break;
				case 4: valorDoFilme = valorDoFilme * 0.25;
					break;
				case 5: valorDoFilme = 0.0;
					break;
			}			
			
			valorTotal += valorDoFilme;
		}
		
		locacao.setValor(valorTotal);
		
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		
		if(DataUtils.verificarDiaSemana(dataEntrega, Calendar.SUNDAY)) {
			dataEntrega = adicionarDias(dataEntrega, 1); //se for domingo, acrescenta mais 1 dia para ir para segunda, que ? o dia onde faz entrega
		}

		locacao.setDataRetorno(dataEntrega);
		
		return locacao;
	}
    
	
}