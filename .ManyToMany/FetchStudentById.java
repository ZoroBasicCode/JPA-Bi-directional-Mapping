package org.SRK;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FetchStudentById {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter id");
	int sid=sc.nextInt();
	String qr="select s from Student s where s.id=?1";
	Query q=m.createQuery(qr);
	q.setParameter(1, sid);
	List<Student> student=q.getResultList();
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
