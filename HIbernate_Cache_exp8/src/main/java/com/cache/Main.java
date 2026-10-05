package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // First Session
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        long start1 = System.nanoTime();

        Cache c1 = new Cache(1L, "Viraj");
        session.save(c1);
        tx.commit();
        
        Cache cache1 = session.get(Cache.class, 1L);
        long end1 = System.nanoTime();

        System.out.println("Time taken (First Query): "
                + (end1 - start1) + " ns");

        session.close();


        // Second Session
        Session session2 = sessionFactory.openSession();

        long start2 = System.nanoTime();

        // Second query
        Cache cache2 = session2.get(Cache.class, 1L);

        long end2 = System.nanoTime();

        System.out.println("Time taken (Second Query): "
                + (end2 - start2) + " ns");

        session2.close();

        sessionFactory.close();
    }
}