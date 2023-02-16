package org.SRK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Deleteospital {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	EntityTransaction t=m.getTransaction();
	
	Hospital h=m.find(Hospital.class, 1);
	if(h!=null)
	{
		m.remove(h);
		t.begin();
		t.commit();
		System.out.println("data is deleted");
	}
}
}
