package kr.mollang.ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class ManyDanger {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setTeamName("Python 강의");
            team.setId(10L);

            em.persist(team);


            MemberTest member = new MemberTest();
            member.setName("Gang");
            member.setTeam(team);
            team.getMember().add(member);
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
