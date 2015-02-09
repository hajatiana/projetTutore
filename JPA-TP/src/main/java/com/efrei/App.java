package com.efrei;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
//		Person p = new Person();
//		p.setId(1);
//		p.setName("Haja");
//		entityManager.persist(p);
//		tx.commit();		
		
		TypedQuery<Person> query =entityManager.createQuery("SELECT p FROM PERSON p", Person.class);
		List<Person> results = query.getResultList();
		for (Person person : results) {
			System.out.println("id="+person.getId()+" et nom="+person.getName());
		}
    }
}
