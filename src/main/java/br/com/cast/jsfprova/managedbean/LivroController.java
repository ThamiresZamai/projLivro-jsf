package br.com.cast.jsfprova.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.cast.jsfprova.business.AutorBusiness;
import br.com.cast.jsfprova.business.CategoriaBusiness;
import br.com.cast.jsfprova.business.LivroBusiness;
import br.com.cast.jsfprova.dto.AutorDTO;
import br.com.cast.jsfprova.dto.CategoriaDTO;
import br.com.cast.jsfprova.dto.LivroDTO;

@ManagedBean(name="livroController")
public class LivroController {
	
	private LivroDTO livrodto;
	private LivroBusiness livrobusiness;
	private AutorBusiness autorbusiness;
	private CategoriaBusiness catbusiness;
	private List<LivroDTO> lstlivrodto;
	private List<AutorDTO> lstautor;
	private List<CategoriaDTO> lstcategoria;
	
	@PostConstruct
	public void init() {
		this.livrodto = new LivroDTO();
		this.livrobusiness = new LivroBusiness();
		this.autorbusiness = new AutorBusiness();
		this.catbusiness = new CategoriaBusiness();
		lstautor = autorbusiness.buscarTodos();
		lstcategoria = catbusiness.buscarTodos();
		atualizarListaDeLivro();
	}
	
	public void atualizarListaDeLivro() {
		lstlivrodto = livrobusiness.buscarTodos();
	}
	
	public List<LivroDTO> getListarLivro(){
		return lstlivrodto;
	}
	
	public List<AutorDTO> getListarAutor(){
		return lstautor;
	}
	
	public List<CategoriaDTO> getListarCategoria(){
		return lstcategoria;
	}
	
	public void salvar() {
		livrobusiness.Salvar(livrodto);
		String msg = String.format("Registro %s com sucesso", 
				livrodto.getId() != null ? "alterado" : "inserido");
		
		FacesContext.getCurrentInstance().addMessage("mensagens", 
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		
		livrodto = new LivroDTO();
	}
	
	public String criticaSelecionada(Integer id) {
		this.livrodto = livrobusiness.buscarPorId(id);
		return "Cadastro";
	}
	
	public String excluir(Integer id) {
		livrobusiness.excluir(id);
		atualizarListaDeLivro();
		return"index";
	}

	public LivroDTO getLivrodto() {
		return livrodto;
	}

	public void setLivrodto(LivroDTO livrodto) {
		this.livrodto = livrodto;
	}

	public LivroBusiness getLivrobusiness() {
		return livrobusiness;
	}

	public void setLivrobusiness(LivroBusiness livrobusiness) {
		this.livrobusiness = livrobusiness;
	}

	public List<LivroDTO> getLstlivrodto() {
		return lstlivrodto;
	}

	public void setLstlivrodto(List<LivroDTO> lstlivrodto) {
		this.lstlivrodto = lstlivrodto;
	}

}
