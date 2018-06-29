package dw.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Data Access Object.
 */
public class LivroModel {

	//"professores" é o nome da unidade de persistência no "persistence.xml".
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("professores");

	public static void inclui(String editora, String titulo) {
		// Obter "conexão".
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Livro livro = new Livro();
		livro.setEditora(editora);
		livro.setTitulo(titulo);

		// Grava o objeto no banco de dados.
		em.persist(livro);
		em.getTransaction().commit();
		em.close();
	}

	public static void alterar(String matricula, String nome) {
	}

	public static void excluir(String matricula) {
	}

	public static List<Livro> listar() {
		EntityManager em = emf.createEntityManager();
		//Não é SQL! É JPQL.
		String jpql = "from Livro";
		TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
		List<Livro> result = query.getResultList();
		em.close();
		return result;
	}
}
