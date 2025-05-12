
package com.mycompany.bibliosistem2;

import jakarta.persistence.EntityManager;

public class LivroJPA {
    
    public static void cadastrarLivro(Livro l){
        EntityManager manager= JPAUtil.conectar();
        try{
            manager.getTransaction().begin();
            manager.persist(l);
            manager.getTransaction().commit();
        }catch(Exception e){
            manager.getTransaction().rollback();
        }finally{
            JPAUtil.desconectar();

        }
    }
    
}
