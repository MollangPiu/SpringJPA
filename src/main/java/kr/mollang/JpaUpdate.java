package kr.mollang;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class JpaUpdate
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
            findMember.setName("Change");       //DB 내용이 변경된다.

            tx.commit(); //Transaction이 set을 가지고 있어서, commit을 하는 순간 기록된 내용을 한 번에 저장한다.
        }
        catch (Exception e) {
            tx.rollback();  //rollback
        }
        em.close();

        System.out.println( "Hello World!" );
    }
}
