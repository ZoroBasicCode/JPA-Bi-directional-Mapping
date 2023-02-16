package org.SRK;

import java.util.List;

import javax.persistence.*;

public class FetchHospitalByname {
public static void main(String[] args) {
	
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	
	String qr="select h from Hospital h where name=?1";
	Query q=m.createQuery(qr);
	q.setParameter(1, "Apollo");
	List<Hospital> hospital=q.getResultList();
	for(Hospital h:hospital)
	{
		System.out.println("id  : "+h.getId());
		System.out.println("name : "+h.getName());
		System.out.println("founder : "+h.getFounder());
		System.out.println("---------------------------------------");
	}
}
}
