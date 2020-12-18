package br.edu.cesmac.si.nolweb.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestePersistenciaEditoria {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("jsfPU");
        EntityManager entityManager = managerFactory.createEntityManager();

        Editoria editoria = new Editoria();

        editoria.setNome("Cinema e Cultura");

        EntityTransaction entityTransaction = entityManager.getTransaction() ;
        entityTransaction.begin() ;
        entityManager.persist(editoria) ;
        entityTransaction.commit() ;


        entityManager.close();
        managerFactory.close();
    }
}
