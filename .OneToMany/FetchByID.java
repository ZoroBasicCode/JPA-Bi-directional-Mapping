package org.SRK;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FetchByID {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter hospital id");
		int hid=sc.nextInt();
		EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
		EntityManager m=f.createEntityManager();
		
		Query q=m.createQuery("select b from Branch b where b.hospital.id=?1");
		q.setParameter(1, hid);
		List<Branch> branchs=q.getResultList();
		for(Branch b : branchs)
		{
			System.out.println("id : "+b.getId());
			System.out.println("name  : "+b.getName());
			System.out.println("mail  : "+b.getMail());
			System.out.println("phone  : "+b.getPhon());
			System.out.println("==============================================");
		}
	}
}






