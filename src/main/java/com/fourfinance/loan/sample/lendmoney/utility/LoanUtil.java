package com.fourfinance.loan.sample.lendmoney.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.Calendar;

public class LoanUtil {

    public static Session getDatabaseConnection(){
        Configuration cfg = new Configuration();
        SessionFactory factory
                = cfg.configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = factory.openSession();
        return session;
    }

    public static Timestamp addDays(Timestamp date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return new Timestamp(cal.getTime().getTime());

    }
}
