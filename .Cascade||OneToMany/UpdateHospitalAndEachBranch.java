package org.SRK;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateHospitalAndEachBranch {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	EntityTransaction t=m.getTransaction();
	Hospital h=m.find(Hospital.class, 2);
	if(h!=null)
	{
		h.setName("GovernmentHospital");
		System.out.println("____________________");
		Branch b1=h.getBranchs().get(0);
		if(b1!=null)
		{
			b1.setName("GOVTHospital_1");
			b1.setEmail("GOVTH1@gmail.com");
			System.out.println("branch 1 data is updated");
		}
		Branch b2=h.getBranchs().get(1);
		if(b2!=null)
		{
			b2.setName("GOVTHospital_2");
			b2.setEmail("GOVTH2@gmail.com");
			System.out.println("branch b2 data is updated");
		}
		Branch b3=h.getBranchs().get(2);
		if(b3!=null)
		{
			b3.setName("GOVTHospital_3");
			b3.setEmail("GOVTH3@gmail.com");
		}
		m.merge(h);
		t.begin();
		t.commit();
	}
}
}
