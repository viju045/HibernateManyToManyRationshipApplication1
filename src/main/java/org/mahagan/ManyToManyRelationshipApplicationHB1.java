package org.mahagan;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.domain.Employees;
import org.mahagan.domain.Projects;



public class ManyToManyRelationshipApplicationHB1 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tsx = session.beginTransaction();

        Employees employees = new Employees();
        employees.setEmpName("vijay");
        employees.setEmpAddress("Pune");

        Projects projects = new Projects();
        projects.setProjectName("IOT");
        projects.setProjectDomain("Internet provider");
        projects.setProjectVersion("2.0");

        employees.getProjects().add(projects);
        projects.getEmployees().add(employees);

        session.persist(employees);
        tsx.commit();
        session.close();
        System.out.println("Data Inserted successsfully");

    }
}