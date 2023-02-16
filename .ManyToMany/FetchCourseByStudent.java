package org.SRK;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FetchCourseByStudent {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	Scanner sc= new Scanner(System.in);
	System.out.println(" enter student id ");
	int sid=sc.nextInt();
	String qr="select s from Student s where s.id=?1";
	Query q=m.createQuery(qr);
	q.setParameter(1, sid);
	List<Student> student=q.getResultList();
	for(Student s:student)
	{
		List<Course> course=s.getCourses();
		for(Course c:course)
		{
			System.out.println("id  :"+c.getId());
			System.out.println("subject  :"+c.getSubject());
			System.out.println("Duriation  :"+c.getDuriation());
			System.out.println("____________________________________");
		}
		
	}
}
}
