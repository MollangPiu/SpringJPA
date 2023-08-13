package kr.mollang.TestSeq;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class JpaStart {

    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            MemberSeq memberSeq = new MemberSeq();
            memberSeq.setName("Tiger");
            memberSeq.setItem(Item.BOX);

            em.persist(memberSeq);

            memberSeq = new MemberSeq();

            memberSeq.setName("MC");
            memberSeq.setItem(Item.FOOD);
            em.persist(memberSeq);

            tx.commit();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("================ END ===================");
            em.close();
        }
    }
}
