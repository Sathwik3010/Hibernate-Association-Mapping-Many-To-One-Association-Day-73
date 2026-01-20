package com.codegnan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.model.Branch;
import com.codegnan.model.Stud;

public class App {
	public static void main(String[] args) {
	StandardServiceRegistry registry = 
			new StandardServiceRegistryBuilder()
										.configure("hibernate.cfg.xml")
										.build();
	Metadata metadata=new MetadataSources(registry)
			.getMetadataBuilder()
			.build();
	SessionFactory sessionFactory = metadata
			.getSessionFactoryBuilder()
			.build();
	// perform operations
	insertData(sessionFactory);
	retrieveData(sessionFactory);
	sessionFactory.close();
	}
	public static void insertData(SessionFactory sessionFactory) {
		try(Session session = sessionFactory.openSession()){
			Transaction tx = session.beginTransaction();
			Branch cse = new Branch("B0001","CSE","HYD");
			Branch ece = new Branch("B0002","ECE","BLR");
			session.save(cse);
			session.save(ece);
			
			// create Student many to one
			Stud s1 = new Stud("ravi","vjy",540,cse);
			Stud s2 = new Stud("navi","blr",740,cse);
			Stud s3 = new Stud("mavi","guntur",500,ece);
			Stud s4 = new Stud("vavi","chennai",760,cse);
			session.save(s1);
			session.save(s2);
			session.save(s3);
			session.save(s4);
			tx.commit();
			System.out.println("Data inserted succesfully");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void retrieveData(SessionFactory sessionFactory) {
		try(Session session=sessionFactory.openSession()){
			List<Stud> students = session.createQuery("From Student",Stud.class).list();
			System.out.println("Student Details with branch info");
			for(Stud s:students) {
				System.out.println("Student Id: "+s.getSid());
				System.out.println("Name: "+s.getSname());
				System.out.println("City: "+s.getCity());
				System.out.println("Marks: "+s.getMarks());
				System.out.println("Branch Name: "+s.getBranch().getBname());
				System.out.println("Branch Location: "+s.getBranch().getLocation());
				System.out.println("-----------------------------------------------");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
