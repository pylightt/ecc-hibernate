package xyz.merccurion;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.util.Scanner;

public class Util {
    private SessionFactory sessionFactory;

    private Scanner scan = new Scanner(System.in);

    public Util() {}

    public SessionFactory getSessionFactory() {
        File directory = new File("./infra/src/main/resources/hibernate.cfg.xml");
        Configuration configuration = new Configuration().configure(directory);

        StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
        
        ServiceRegistry serviceRegistry = srb.applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        return sessionFactory;
    }

    public String getString(String text) {
        System.out.print(text);
        String str = scan.nextLine();
        return str;
    }

    public int getInt(String text) {
        System.out.print(text);
        int integer = Integer.parseInt(scan.nextLine());
        return integer;
    }

    public double getDouble(String text) {
        System.out.printf(text);
        double value = Double.parseDouble(scan.nextLine());
        return value;
    }

    public long getLong(String text) {
        System.out.print(text);
        long value = Long.parseLong(scan.nextLine());
        return value;
    }
    public boolean getBoolean(String text) {
        System.out.printf(text);
        String result = scan.nextLine();
        boolean isHired = true;
        if (result.equalsIgnoreCase("Y")) {
            isHired = true;
        }
        else if (result.equalsIgnoreCase("N")) {
            isHired = false; 
        } 
        return isHired;
    }
    
}