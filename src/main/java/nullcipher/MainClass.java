/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nullcipher;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author kostis
 */
public class MainClass {
     private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static void main(String[] args) {
       System.out.println("Starting JPA...");

        openEntityManagerFactory();
       //printStudent();
        
//         //create student
          Student s = new Student("Stavros");
          createStudent(s);
        
//        Student s = getStudentById(2);
//        System.out.println("Student before update: "+ s);
//       s.setName("Nikolas");//Update customer
//       updateStudent(s);
//        System.out.println("Student after update: "+s);
        
        closeEmf();
   
}
    
      private static Student updateStudent(Student s) {
        openEntityManager();
        em.getTransaction().begin();
        s = em.merge(s);//like update
        em.getTransaction().commit();//Send the query to the Database
        closeEntityManager();
        return s;
    }
    
  private static void createStudent(Student s) {
        openEntityManager();
        em.getTransaction().begin();
        em.persist(s);//Add student
        em.getTransaction().commit();
        closeEntityManager();
    }
  
  
   private static Student getStudentById(int id) {
        openEntityManager();
        Student student = em.find(Student.class, id);
        System.out.println("*******************");
        System.out.println("customer:" + student);
        System.out.println("*******************");
        closeEntityManager();
        return student;
    }
    
 private static void printStudent() {
        openEntityManager();
        String sql = "SELECT s FROM Student s";//JPQL: Java Persistence Query Language
        Query query = em.createQuery(sql, Student.class);//We create Object TypedQuery from EntityManager
        List<Student> list = query.getResultList();//Execute the query and get the result
        System.out.println("******************");
        for (Student s : list) {
            System.out.println(s);
        }
        System.out.println("******************");
        closeEntityManager();
    }
    
    
 private static void openEntityManager() {
        em = emf.createEntityManager();
    }

    private static void closeEntityManager() {
        em.close();
    }

    private static void openEntityManagerFactory() {
        System.out.println("Opening EntityManagerFactory...");
        emf = Persistence.createEntityManagerFactory("mainPU");
    }

    private static void closeEmf() {
        emf.close();
        System.out.println("Closing EntityManagerFactory...");
    }}
