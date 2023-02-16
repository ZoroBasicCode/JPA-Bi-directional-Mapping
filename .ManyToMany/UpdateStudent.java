package org.SRK;


import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class UpdateStudent {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	EntityTransaction t=m.getTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter id ");
	int sid =sc.nextInt();
	String qr="select s from Student s where s.id=?1";
	Query q=m.createQuery(qr);
	q.setParameter(1, sid);
	List<Student> student=q.getResultList();
	for(Student s:student)
	{
		System.out.println("enter name");
		String name=sc.next();
		s.setName(name);
		System.out.println("enter percentage");
		double perc=sc.nextDouble();
		s.setPerc(perc);
		System.out.println("enter phon");
		long phon=sc.nextLong();
		s.setPhon(phon);
		System.out.println("data is updated");
		m.merge(s);
		t.begin();
		t.commit();
	}
}
}
