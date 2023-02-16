package org.SRK;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FetchStudetntPhonNameByCourse {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter course name in caps");
	String nm=sc.next();
	String qr="select c from Course c where c.subject=?1";
	Query q=m.createQuery(qr);
	q.setParameter(1, nm);
	List<Course> course=q.getResultList();
	for(Course c: course)
	{
		List<Student> student=c.getStudent();
		for(Student s:student)
		{
			System.out.println("id  :"+s.getId());
			System.out.println("name  : "+s.getName());
			System.out.println("phon  : "+s.getPhon());
			System.out.println("percentage  :"+s.getPerc());
			System.out.println("______________________________________");
		}
	}
}
}
