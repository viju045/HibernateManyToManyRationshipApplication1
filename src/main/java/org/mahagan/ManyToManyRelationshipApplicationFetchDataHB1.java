package org.mahagan;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.domain.Employees;
import org.mahagan.domain.Projects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ManyToManyRelationshipApplicationFetchDataHB1 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tsx = session.beginTransaction();

        TypedQuery query = session.createQuery("from Projects projects");
        List<Projects>list = query.getResultList();
        Iterator<Projects>iterator = list.iterator();

        while(iterator.hasNext())
        {
            Projects projects = iterator.next();
            System.out.println(projects.getProjectName()+" "+projects.getProjectDomain()+" "+projects.getProjectVersion());

            Set<Employees>set1 =projects.getEmployees();
            Iterator<Employees>iterator1 = set1.iterator();
            while(iterator1.hasNext())
            {
                Employees employees= iterator1.next();
                System.out.println(employees.getEmpName()+" "+employees.getEmpAddress());
            }


        }
        session.close();
        System.out.println("Data Inserted successsfully");
    }
}
