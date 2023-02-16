package org.SRK;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FetchBranchByPhon {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter phon");
	long pn=sc.nextLong();
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	
	String qr="select b from Branch b where b.phon=?1";
	Query q=m.createQuery(qr);
	q.setParameter(1, pn);
	List<Branch> branchs=q.getResultList();
	for(Branch b:branchs)
	{
		System.out.println("id  : "+b.getId());
		System.out.println("name  : "+b.getName());
		System.out.println("mail  : "+b.getMail());
		System.out.println("phon  : "+b.getPhon());
	}
}
}
