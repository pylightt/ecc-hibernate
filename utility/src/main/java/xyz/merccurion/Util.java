package xyz.merccurion;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.Scanner;

public class Util {
    private SessionFactory factory;

    private Scanner scan = new Scanner(System.in);

    public Util() {}

    public SessionFactory getSessionFactory() {
        try {
            File directory = new File("./infra/src/main/resources/hibernate.cfg.xml");
            factory = new Configuration().configure(directory).buildSessionFactory();
         } catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
         }
         return factory;
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
        System.out.print(text);
        double value = Double.parseDouble(scan.nextLine());
        return value;
    }

    public boolean getBoolean(String text) {
        System.out.print(text);
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