package org.SRK;


import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class UpdateCourseById {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	EntityTransaction t=m.getTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter id ");
	int sid =sc.nextInt();
	String qr="select c from Course c where c.id=?1";
	Query q=m.createQuery(qr);
	q.setParameter(1, sid);
	List<Course> course=q.getResultList();
	for(Course c:course)
	{
		System.out.println("enter name");
		String name=sc.next();
		c.setSubject(name);
		System.out.println("enter duriation");
		int duriation=sc.nextInt();
		c.setDuriation(duriation);
		System.out.println("data is updated");
		m.merge(c);
		t.begin();
		t.commit();
	}
}
}
