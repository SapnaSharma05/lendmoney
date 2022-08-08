package com.fourfinance.loan.sample.lendmoney.dao;

import com.fourfinance.loan.sample.lendmoney.model.LoanApplicationDetailsEntity;
import com.fourfinance.loan.sample.lendmoney.model.LoanRequest;
import com.fourfinance.loan.sample.lendmoney.utility.LoanUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LoanApplicationDao {

    public String saveLoanApplicationDetails(LoanRequest req) {

        LoanApplicationDetailsEntity loanApplicationDetails = new LoanApplicationDetailsEntity();
        loanApplicationDetails.setApplicantName(req.getApplicantName());
        loanApplicationDetails.setApplicantDateOfBirth(req.getApplicantDateOfBirth());
        loanApplicationDetails.setGender(req.getGender());
        loanApplicationDetails.setContactNumber(req.getContactNumber());
        loanApplicationDetails.setEmailAddress(req.getEmailAddress());
        loanApplicationDetails.setPermanentAddress(req.getPermanentAddress());
        loanApplicationDetails.setPresentAddress(req.getPresentAddress());
        loanApplicationDetails.setTaxPayerId(req.getTaxPayerId());
        loanApplicationDetails.setEmploymentStatus(req.getEmploymentStatus());
        loanApplicationDetails.setNoOfDependents(req.getNoOfDependants());
        loanApplicationDetails.setLoanAmount(req.getLoanAmount());
        loanApplicationDetails.setLoanTenure(req.getLoanTenure());
        loanApplicationDetails.setAnnualIncome(req.getAnnualIncome());
        loanApplicationDetails.setInterest(7);
        loanApplicationDetails.setDueDate(new Date());

        Session session = LoanUtil.getDatabaseConnection();
        Transaction tx = session.beginTransaction();
        Object referenceId = session.save(loanApplicationDetails);
        tx.commit();
        session.close();

        return referenceId.toString();
    }
}
