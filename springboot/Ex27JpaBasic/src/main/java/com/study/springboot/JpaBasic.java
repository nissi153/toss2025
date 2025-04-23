package com.study.springboot;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaBasic {
    public static void main(String[] args) {
        System.out.println("jpa-basic");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-basic");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            //실제 메소드 들어가는 곳
            Member detachedMember = new Member();
            detachedMember.setId(2L);
            detachedMember.setName("Merged");

            Member managed = em.merge(detachedMember); // 병합 후 managed 객체 반환

            tx.commit(); //flush(), commit()
        }
        catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.clear();
            emf.close();
        }

    }
}
