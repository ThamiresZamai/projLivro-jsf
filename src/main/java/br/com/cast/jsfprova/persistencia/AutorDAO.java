package br.com.cast.jsfprova.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cast.jsfprova.dto.AutorDTO;
import br.com.cast.jsfprova.entidade.Autor;

public class AutorDAO {

	private EntityManager em;

	public AutorDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoWeb");
		em = emf.createEntityManager();
	}

	public Autor buscarPOrId(Integer id) {
		return em.find(Autor.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<AutorDTO> buscarTodos() {
		List<AutorDTO> lstautor = em.createQuery("Select a from " + Autor.class.getName() + " a ").getResultList();
		return lstautor;
	}
}
