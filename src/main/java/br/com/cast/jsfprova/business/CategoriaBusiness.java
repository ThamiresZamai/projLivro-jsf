package br.com.cast.jsfprova.business;

import java.util.List;

import br.com.cast.jsfprova.dto.CategoriaDTO;
import br.com.cast.jsfprova.entidade.Categoria;
import br.com.cast.jsfprova.persistencia.CategoriaDAO;

public class CategoriaBusiness {
	
	private CategoriaDAO categoriadao;
	
	public CategoriaBusiness() {
		this.categoriadao = new CategoriaDAO();
	}
	
	public List<CategoriaDTO> buscarTodos() {
		List<CategoriaDTO> lstcategoriadto = categoriadao.buscarTodos();
		return lstcategoriadto;
	}
	
	public Categoria buscarPOrId(Integer id) {
		return categoriadao.buscarPOrId(id);
	}

}
