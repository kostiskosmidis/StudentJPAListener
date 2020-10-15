/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nullcipher;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 *
 * @author kostis
 */
public class Listener {
   

@PrePersist
public void methodInvokedBeforePersist(Student stu) {
    System.out.println("persisting student with id = " + stu.getId());
}

@PostPersist
public void methodInvokedAfterPersist(Student stu) {
    System.out.println("Persisted student with id = " + stu.getId());
}

@PreUpdate
public void methodInvokedBeforeUpdate(Student stu) {
    System.out.println("Updating student with id = " + stu.getId());
}

@PostUpdate
public void methodInvokedAfterUpdate(Student stu) {
    System.out.println("Invoked after updating student" + stu.getId());
}

@PreRemove
public void methodInvokedBeforeRemove(Student stu) {
    System.out.println("Invoked before removing student" + stu.getId());
}

@PostRemove
public void methodInvokedAfterRemove(Student stu) {
    System.out.println("Invoked after removing student");
} 
}
