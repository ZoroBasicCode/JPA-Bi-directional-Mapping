package org.SRK;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.*;

public class SaveData {
public static void main(String[] args) {
	
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	EntityTransaction t=m.getTransaction();
	
	Hospital h= new Hospital();
	h.setName("Apollo");
	h.setFounder("Appu");
	
	Branch b1,b2,b3;
	b1=new Branch();
	b1.setMail("AB@gmail.com");
	b1.setName("Apollo");
	b1.setPhon(7777);
	b1.setHospital(h);
	
	b2=new Branch();
	b2.setMail("AM@gmail.com");
	b2.setName("Apollo");
	b2.setPhon(8888);
	b2.setHospital(h);
	
	b3=new Branch();
	b3.setMail("AR@gmail.com");
	b3.setName("Apollo");
	b3.setPhon(9999);
	b3.setHospital(h);
	
	h.setBranchs(new ArrayList<Branch>(Arrays.asList(b1,b2,b3)));
	m.persist(b1);
	m.persist(b2);
	m.persist(b3);
	m.persist(h);
	t.begin();
	t.commit();
}
}
