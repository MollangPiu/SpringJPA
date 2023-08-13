package kr.mollang;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
class JpaSelectTwo
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
            List<Member> result = em.createQuery("SELECT M FROM Member AS M", Member.class)
                .setFirstResult(5)      //offset
                .setMaxResults(8)       // limit
                .getResultList();

            for(Member member : result) {
                System.out.println("member.name: "+member.getName());
            }

            tx.commit(); //commit
        }
        catch (Exception e) {
            tx.rollback();  //rollback
        }
        em.close();

        System.out.println( "Hello World!" );
    }
}
