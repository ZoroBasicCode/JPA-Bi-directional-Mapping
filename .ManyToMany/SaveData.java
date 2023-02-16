package org.SRK;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.*;

public class SaveData {
public static void main(String[] args) {
	EntityManagerFactory f=Persistence.createEntityManagerFactory("dev");
	EntityManager m=f.createEntityManager();
	EntityTransaction t=m.getTransaction();
	Course c1,c2;
	c1=new Course();
	c1.setSubject("JAVA");
	c1.setDuriation(60);
	
	c2=new Course();
	c2.setSubject("SQL");
	c2.setDuriation(45);
	
	Student s1,s2,s3;
	s1=new Student();
	s1.setName("Babu");
	s1.setPhon(777);
	s1.setPerc(90.8);
	
	s2=new Student();
	s2.setName("Kishore");
	s2.setPhon(888);
	s2.setPerc(95.8);
	
	s3=new Student();
	s3.setName("Harish");
	s3.setPhon(999);
	s3.setPerc(80.8);
	
	c1.setStudent(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
	c2.setStudent(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
	s1.setCourses(new ArrayList<Course>(Arrays.asList(c1,c2)));
	s2.setCourses(new ArrayList<Course>(Arrays.asList(c1,c2)));
	s3.setCourses(new ArrayList<Course>(Arrays.asList(c1,c2)));
	m.persist(c1);
	m.persist(c2);
	m.persist(s1);
	m.persist(s2);
	m.persist(s3);
	t.begin();
	t.commit();
}
}
