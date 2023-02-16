package org.SRK;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteOneBranch {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	EntityTransaction t=m.getTransaction();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the branch id which you want deleted");
	int bid=sc.nextInt();
	String qr="select b from Branch b where b.id=?1";
	Query q=m.createQuery(qr);
	q.setParameter(1, bid);
	List<Branch> branch=q.getResultList();
	for(Branch b:branch)
	{
		m.remove(b);
		t.begin();
		t.commit();
		System.out.println("data is deleted");
	}
	
	}
}

