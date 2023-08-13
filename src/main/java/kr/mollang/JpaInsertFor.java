package kr.mollang;

import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
class JpaInsertFor
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
            for(int num = 2; num <= 20; num++) {
                Member member = new Member();
                member.setId(Long.valueOf(num));

                Random rnd =new Random();
                StringBuffer buf =new StringBuffer();
                for(int i=0;i<20;i++){
                    // rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤 한 숫자를 StringBuffer 에 append 한다.
                    if(rnd.nextBoolean()){
                        buf.append((char)((int)(rnd.nextInt(26))+97));
                    }else{
                        buf.append((rnd.nextInt(10)));
                    }

                }
                member.setName(buf.toString());
                em.persist(member);

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
