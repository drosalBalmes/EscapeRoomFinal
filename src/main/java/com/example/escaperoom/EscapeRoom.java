package com.example.escaperoom;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EscapeRoom {
    public static Session session1 = HibernateUtil.getSessionFactory().getCurrentSession();

    public static void main(String[] args) {
        int x=codigo1();
        int y=codigo2();
        int z=codigo3();
        int w=codigo4();

        System.out.println("Hola desde Hibernate");
        System.out.println("El código descubierto es :" +x+y+z+w);
        session1.getTransaction().commit();
        session1.close();
    }
    public static int codigo1() {
        //TO-DO
        Transaction transaction = session1.getTransaction();
        transaction.begin();
        Query q1 = session1.createQuery("select count(m) from ModuloEntity m");
        long result = (long)q1.uniqueResult();

        return (int) result;
    }
    public static int codigo2() {
        //TO-DO
        //Query query = session1.createQuery("SELECT DISTINCT (e.moduls.idModulo) from ExamenEntity e where e.moduls.idModulo > 0");
        Query query = session1.createQuery("SELECT DISTINCT (e.idModul) from ExamenEntity e where e.idModul > 0");
        long result = (long) query.getResultList().get(0);

        return (int) query.getResultList().size();
    }
    public static int codigo3() {
        Query query = session1.createQuery("SELECT ROUND(AVG(e.nota),0) FROM ExamenEntity e JOIN ModuloEntity m WHERE m.id = e.idModul AND m.nombre LIKE '%PRG%'");
        //Query query = session1.createQuery("SELECT ROUND(AVG(e.nota),0) FROM ExamenEntity e JOIN ModuloEntity m WHERE m.id = e.moduls.idModulo AND m.nombre LIKE '%PRG%'");
        //TO-DO
        double result = (double) query.getResultList().get(0);
        return (int) result;
    }
    public static int codigo4() {
        Query query =  session1.createQuery("SELECT COUNT(e) FROM AlumnoEntity e WHERE e.apellidos LIKE '%z%'");

        Long result = (Long) query.getResultList().get(0);

        return  result.intValue();
    }
}
