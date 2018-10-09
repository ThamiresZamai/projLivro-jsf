package br.com.cast.jsfprova.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cast.jsfprova.dto.CategoriaDTO;
import br.com.cast.jsfprova.entidade.Categoria;

public class CategoriaDAO {
	
	private EntityManager em;
	
	public CategoriaDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoWeb");
		em = emf.createEntityManager();
	}
	
	public Categoria buscarPOrId(Integer id) {
		return em.find(Categoria.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<CategoriaDTO> buscarTodos() {
		List<CategoriaDTO> lstautor = em.createQuery("Select c from " + Categoria.class.getName() + " c ").getResultList();
		return lstautor;
	}

}
