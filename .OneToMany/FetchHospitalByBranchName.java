package org.SRK;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FetchHospitalByBranchName {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter branch name");
	String nm=sc.next();
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	
	String qr="select b from Branch b where b.name=?1";
	Query q=m.createQuery(qr);
	q.setParameter(1, nm);
	List<Branch> branchs=q.getResultList();
	for(Branch b:branchs)
	{
		Hospital h=b.getHospital();
		System.out.println("id  : "+h.getId());
		System.out.println("name  : "+h.getName());
		System.out.println("founder  : "+h.getFounder());
		System.out.println("___________________________________");
	}
	
}
}
