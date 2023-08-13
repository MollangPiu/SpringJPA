package kr.mollang.ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class ManyStart {

    public static void main(String[] args) {

        //Presistence.xml의 설정을 가져온다.
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();



        try {

            Team team = new Team();
            team.setId(1L);
            team.setTeamName("Java 동호회");

            em.persist(team);

            Member member = new Member();
            member.setName("Tiher");
            member.setTeam(team);

            em.persist(member);

            tx.commit();


        }
        catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            em.close();
        }
    }
}
