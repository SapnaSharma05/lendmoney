package com.fourfinance.loan.sample.lendmoney.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

import static com.fourfinance.loan.sample.lendmoney.utility.LoanUtil.getDatabaseConnection;

@Component
public class LoanExtendDao {

    public List<Object[]> getDetailsForLoanExtend(int referenceId){

        String hql = "Select L.dueDate, L.interest from LoanApplicationDetailsEntity L where L.referenceId = :referenceId";

        Session session = getDatabaseConnection();
        Query query = session.createQuery(hql);
        query.setParameter("referenceId",referenceId);
        List<Object[]> results = query.list();
        session.close();
        return results;
    }

    public int updateLoanDetailsForExtension(int referenceId, double revisedInterest, Timestamp revisedDueDate){

        String hql = "UPDATE LoanApplicationDetailsEntity set RevisedInterest = :revisedInterest , RevisedDueDate = :revisedDueDate" +
                " WHERE referenceId = :referenceId";

        Session session = getDatabaseConnection();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery(hql);

        query.setParameter("revisedInterest", revisedInterest);
        query.setParameter("revisedDueDate", revisedDueDate);
        query.setParameter("referenceId", referenceId);
        int result = query.executeUpdate();

        tx.commit();
        session.close();
        System.out.println("Rows affected: " + result);
        return result;
    }
}
