package kr.mollang;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

/**
 * Hello world!
 *
 */
public class JpaInsert
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
            //Insert 부분
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);

            tx.commit(); //commit
        }
        catch (Exception e) {
            tx.rollback();  //rollback
        }
        em.close();

        System.out.println( "Hello World!" );
    }
}
