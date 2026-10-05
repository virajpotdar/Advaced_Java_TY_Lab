package com.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration()
        		.configure("hibernate.cfg.xml")
        		.buildSessionFactory();
        
        Session session1 = factory.openSession();
        Transaction tx1 = session1.beginTransaction();
        
        Student Student1 = new Student("Viraj", "virajpotdar@gmail.com");
        session1.save(Student1);
        
        Student Student2 = new Student("Shreeraj", "Shree@gmail.com");
        session1.save(Student2);
        
        Student Student3 = new Student("Aditya", "Aditya@gmail.com");
        session1.save(Student3);

        
        tx1.commit();
        session1.close();
//        System.out.println("Student Created with ID: " + newStudent.getId());
        
        
//        Session session2 = factory.openSession();
//        Student fetchedStudent = session2.get(Student.class, newStudent.getId());
//        System.out.println("Fetched Name: " + fetchedStudent.getName());
//        session2.close();

//        
//        Session session3 = factory.openSession();
//        Transaction tx3 = session3.beginTransaction();
//        
//        fetchedStudent.setEmail("virajpotdar7845@gmail.com");
//        session3.update(fetchedStudent);
//        
//        tx3.commit();
//        session3.close();
//        System.out.println("Student Email Updated.");

        // --- 4. DELETE ---
//        Session session4 = factory.openSession();
//        Transaction tx4 = session4.beginTransaction();
//        
//        session4.delete(fetchedStudent);
//        
//        tx4.commit();
//        session4.close();
//        System.out.println(">>> Student Deleted.");

        // Close Session Factory
        factory.close();
    }
}
