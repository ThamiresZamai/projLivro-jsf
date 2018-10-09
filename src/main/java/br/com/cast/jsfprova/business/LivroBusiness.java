package br.com.cast.jsfprova.business;



import java.util.ArrayList;
import java.util.List;

import br.com.cast.jsfprova.dto.AutorDTO;
import br.com.cast.jsfprova.dto.CategoriaDTO;
import br.com.cast.jsfprova.dto.LivroDTO;
import br.com.cast.jsfprova.entidade.Autor;
import br.com.cast.jsfprova.entidade.Categoria;
import br.com.cast.jsfprova.entidade.Livro;
import br.com.cast.jsfprova.persistencia.AutorDAO;
import br.com.cast.jsfprova.persistencia.CategoriaDAO;
import br.com.cast.jsfprova.persistencia.LivroDAO;

public class LivroBusiness {

	public LivroDAO livrodao;
	public CategoriaDAO categoriadao;
	public AutorDAO autordao;
	
	public LivroBusiness() {
		this.livrodao = new LivroDAO();
		this.categoriadao = new CategoriaDAO();
		this.autordao = new AutorDAO();
	}
	
	public void Salvar(LivroDTO livrodto) {
		Categoria categoria = categoriadao.buscarPOrId(livrodto.getId_categoria());
		Autor autor = autordao.buscarPOrId(livrodto.getId_autor());
		
		Livro livro = new Livro();
		livro.setId(livrodto.getId());
		livro.setTitulo(livrodto.getTitulo());
		livro.setDataPublicacao(livrodto.getDataPublicacao());
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		
		if(livro.getId() != null) {
			livrodao.alterar(livro);
		}else {
			livrodao.inserir(livro);
		}
		
		
	}
	
	public LivroDTO buscarPorId(Integer id) {
		Livro livro = livrodao.buscarPorId(id);
		
		LivroDTO livrodto = new LivroDTO();
		livrodto.setId(livro.getId());
		livrodto.setTitulo(livro.getTitulo());
		livrodto.setDataPublicacao(livro.getDataPublicacao());
		
		Categoria categoria = livro.getCategoria();
		if(categoria != null) {
			livrodto.setId_categoria(categoria.getId());
		}
		Autor autor = livro.getAutor();
		if(autor != null) {
			livrodto.setId_autor(autor.getId());
		}
		return livrodto;
	}
	
	public void excluir(Integer id) {
		Livro livro = livrodao.buscarPorId(id);
		livrodao.excluir(livro);
	}
	
	public List<LivroDTO> buscarTodos() {
		
		List<Livro> livros = livrodao.buscarTodos();
		List<LivroDTO> livrosdto = new ArrayList<>();
		
		for (Livro livro : livros) {
			LivroDTO livrodto = new LivroDTO();
			livrodto.setId(livro.getId());
			livrodto.setTitulo(livro.getTitulo());
			livrodto.setDataPublicacao(livro.getDataPublicacao());
			
			Categoria categoria = livro.getCategoria();
			if(categoria != null) {
				CategoriaDTO categoriadto = new CategoriaDTO();
				categoriadto.setId(categoria.getId());
				categoriadto.setDescricao(categoria.getDescricao());
				
				livrodto.setCategoriadto(categoriadto);
			}
			
			Autor autor = livro.getAutor();
			if(autor != null) {
				AutorDTO autordto = new AutorDTO();
				autordto.setId(autor.getId());
				autordto.setNome(autor.getNome());
				autordto.setPseudonimo(autor.getPseudonimo());
				
				livrodto.setAutordto(autordto);
				
			}
			
			livrosdto.add(livrodto);
		}
		return livrosdto;
	}
}
