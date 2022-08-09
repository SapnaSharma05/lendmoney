package com.fourfinance.loan.sample.lendmoney.dao;

import com.fourfinance.loan.sample.lendmoney.model.LoanHistoryResponse;
import com.fourfinance.loan.sample.lendmoney.utility.LoanUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoanHistoryDao {

    public List<LoanHistoryResponse> getLoanHistoryForUser(String taxPayerId){
        String hql = "Select L.referenceId, L.interest, L.loanAmount from LoanHistoryEntity L where L.taxPayerId = :taxPayerId";

        Session session = LoanUtil.getDatabaseConnection();
        Query query = session.createQuery(hql);
        query.setParameter("taxPayerId",taxPayerId);
        Object results = query.list();
        session.close();
        return (List<LoanHistoryResponse>) results;
    }
}
