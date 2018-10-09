package br.com.cast.jsfprova.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import br.com.cast.jsfprova.entidade.Livro;

public class LivroDAO {
	
	private EntityManager em;
	
	public LivroDAO() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoWeb");
		em = emf.createEntityManager();
	}
	
	public void inserir(Livro livro) {
		em.getTransaction().begin();
		try {
			em.persist(livro);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public Livro buscarPorId(Integer id) {
		return em.find(Livro.class, id);
	}
	
	public void alterar(Livro livro) {
		em.getTransaction().begin();
		try {
			em.merge(livro);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(Livro livro) {
		em.getTransaction().begin();
		try {
			em.remove(livro);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Livro> buscarTodos() {
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("select l ")
			.append("from ").append(Livro.class.getName()).append(" l ")
			.append("inner join l.autor ")
			.append("inner join l.categoria");
		
		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
		
	}

}
