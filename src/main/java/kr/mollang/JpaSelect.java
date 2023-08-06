package kr.mollang;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class JpaSelect
{
    public static void main( String[] args )
    {

        //Presistence.xml의 설정을 가져온다.
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //Transaction을 가져온다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //Select
            Member findMember = em.find(Member.class, 1L);
            System.out.println("ID: "+ findMember.getName());   //PK의 1L을 기준으로 NAME을 찾는다.

            tx.commit(); //commit
        }
        catch (Exception e) {
            tx.rollback();  //rollback
        }
        em.close();

        System.out.println( "Hello World!" );
    }
}
