package lesson5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {

    public static SessionFactory create() {
        return new Configuration().configure("configs/hibernate.cfg.xml").buildSessionFactory();
    }

    public static Session getSession() {
        Session session = create().openSession();
        return session;
    }

}
