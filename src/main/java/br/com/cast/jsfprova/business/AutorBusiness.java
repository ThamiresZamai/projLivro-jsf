package br.com.cast.jsfprova.business;

import java.util.List;

import br.com.cast.jsfprova.dto.AutorDTO;
import br.com.cast.jsfprova.entidade.Autor;
import br.com.cast.jsfprova.persistencia.AutorDAO;

public class AutorBusiness {
	
	private AutorDAO autordao;
	
	public AutorBusiness() {
		this.autordao = new AutorDAO();
	}
	
	public Autor buscarPOrId(Integer id) {
		return autordao.buscarPOrId(id);
	}
	
	public List<AutorDTO> buscarTodos() {
		List<AutorDTO> lstautordto = autordao.buscarTodos();
		return lstautordto;
	}

}
