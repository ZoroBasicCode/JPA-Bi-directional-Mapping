package org.SRK;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FetchCourseBySubject {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter name in caps");
	String sub=sc.next();
	String qr="select c from Course c where c.subject=?1";
	Query q=m.createQuery(qr);
	q.setParameter(1, sub);
	List<Course> course=q.getResultList();
	for(Course c:course)
	{
		System.out.println("id  :"+c.getId());
		System.out.println("subject  :"+c.getSubject());
		System.out.println("Duriation  :"+c.getDuriation());
		System.out.println("____________________________________");
	}
}
}
