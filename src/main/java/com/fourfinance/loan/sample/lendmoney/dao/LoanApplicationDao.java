package com.fourfinance.loan.sample.lendmoney.dao;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@AllArgsConstructor
public class LoanApplicationDao {

    public static void main(String s[]){
        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            /*  ManageEmployee ME = new ManageEmployee();
             *//* Add few employee records in database *//*
            Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
            Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
            Integer empID3 = ME.addEmployee("John", "Paul", 10000);
            *//* List down all the employees *//*
            ME.listEmployees();
            *//* Update employee's records *//*
            ME.updateEmployee(empID1, 5000)*/
            System.out.print("test");


            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }


/*
      @Override
    public void run(String args[]){
        IPAddressEntity iPAddressEntity =  IPAddressEntity.builder()
                .ipAddress("1.2.3.4")
                .count(1).build();
        loanRepo.save(iPAddressEntity);

    }
*/

}
