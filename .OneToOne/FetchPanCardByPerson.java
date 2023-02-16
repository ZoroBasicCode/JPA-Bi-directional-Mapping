package org.SRK;

import java.util.List;

import javax.persistence.*;

public class FetchPanCardByPerson {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
//	EntityTransaction t=m.getTransaction();
	
	String qr1="select p from Person p ";
	Query q=m.createQuery(qr1);

	List<Person> ps= q.getResultList();
	for(Person p:ps)
	{
	System.out.println("name  "+p.getName());
	System.out.println("state  "+p.getState());
	System.out.println("id  :"+p.getId());
	System.out.println("____________________________");
	PanCard c=p.getPan();
	System.out.println("number :"+c.getNumber());
	System.out.println("country  :"+c.getCountry());
	System.out.println("================================");
	}
}
}
