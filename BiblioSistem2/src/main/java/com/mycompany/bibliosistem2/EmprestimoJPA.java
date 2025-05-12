
package com.mycompany.bibliosistem2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class EmprestimoJPA {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca_db");

    public static boolean Emprestar(Emprestimo e) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        } finally {
            em.close();
        }
    }

    public static Usuario buscarUsuarioPorNome(String nome) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome", Usuario.class)
                     .setParameter("nome", nome)
                     .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public static Livro buscarLivroPorTitulo(String titulo) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM Livro l WHERE l.titulo = :titulo", Livro.class)
                     .setParameter("titulo", titulo)
                     .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
    
  public static List<Object[]> listar() {
    EntityManager em = emf.createEntityManager();

    try {
        return em.createQuery(
    "SELECT e.usuario.nome, e.livro.titulo, e.data FROM Emprestimo e", Object[].class
         ).getResultList();
    } finally {
        em.close();
    }
  }
}
   


    


    

