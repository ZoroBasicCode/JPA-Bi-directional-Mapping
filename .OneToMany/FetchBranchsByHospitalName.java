package org.SRK;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FetchBranchsByHospitalName {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter name ");
	String nm=sc.next();
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	
	String qr="select b from Branch b where b.hospital.name=?1";
	Query q=m.createQuery(qr);
	q.setParameter(1, nm);
	List<Branch> branchs=q.getResultList();
	for(Branch b:branchs)
	{
		System.out.println("id  : "+b.getId());
		System.out.println("name  : "+b.getName());
		System.out.println("mail  : "+b.getMail());
		System.out.println("phon  : "+b.getPhon());
		System.out.println("________________________________________");
	}
}
}
