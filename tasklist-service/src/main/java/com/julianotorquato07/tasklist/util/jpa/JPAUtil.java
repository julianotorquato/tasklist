package com.julianotorquato07.tasklist.util.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static EntityManager criaEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("TaskListPU");
		return factory.createEntityManager();
	}
	
	public static void main(String[] args) {
	    JPAUtil.criaEntityManager();
    }
}
