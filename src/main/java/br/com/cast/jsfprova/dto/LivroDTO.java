package br.com.cast.jsfprova.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;


public class LivroDTO {

	
	private Integer id;
	@NotBlank(message="Campo em branco!")
	private String titulo;
	private Date dataPublicacao;
	private AutorDTO autordto;
	private CategoriaDTO categoriadto;
	private Integer id_autor;
	private Integer id_categoria;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public AutorDTO getAutordto() {
		return autordto;
	}
	public void setAutordto(AutorDTO autordto) {
		this.autordto = autordto;
	}
	public CategoriaDTO getCategoriadto() {
		return categoriadto;
	}
	public void setCategoriadto(CategoriaDTO categoriadto) {
		this.categoriadto = categoriadto;
	}
	public Integer getId_autor() {
		return id_autor;
	}
	public void setId_autor(Integer id_autor) {
		this.id_autor = id_autor;
	}
	public Integer getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	
	
}
