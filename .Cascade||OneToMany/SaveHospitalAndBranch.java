package org.SRK;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveHospitalAndBranch {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	EntityTransaction t=m.getTransaction();
	Hospital h=new Hospital();
	h.setName("Apollo");

	Branch b1,b2,b3;
	b1=new Branch();
	b1.setName("Apollo1");
	b1.setEmail("AB@gmail.com");
	b1.setHospital(h);
	
	b2=new Branch();
	b2.setName("Apollo2");
	b2.setEmail("AM@gmail.com");
	b2.setHospital(h);
	
	b3=new Branch();
	b3.setName("Apollo3");
	b3.setEmail("AR@gmail.com");
	b3.setHospital(h);
	
	h.setBranchs(new ArrayList<Branch>(Arrays.asList(b1,b2,b3)));
	
	m.persist(h);
	t.begin();
	t.commit();
}
}
