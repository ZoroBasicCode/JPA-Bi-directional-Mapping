package org.SRK;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FetchStudentByPerce60 {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter persentage  ");
	double p=sc.nextDouble();
	String qr="select s from Student s where perc>=?1";
	Query q=m.createQuery(qr);
	q.setParameter(1, p);
	List<Student> student=q.getResultList();
	for(Student s:student)
	{
		System.out.println("id  :"+s.getId());
		System.out.println("name  :"+s.getName());
		System.out.println("phon  :"+s.getPhon());
		System.out.println("perc   :"+s.getPerc());
		System.out.println("_____________________________");
	}
}
}
