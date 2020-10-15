/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nullcipher;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author kostis
 */
@Entity
@EntityListeners(Listener.class)
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;

    
    public Student() {
    }

    public Student(String first_name) {
        this.first_name = first_name;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return first_name;
    }

    public void setName(String name) {
        this.first_name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + first_name + '}';
    }
    
    
  
}
