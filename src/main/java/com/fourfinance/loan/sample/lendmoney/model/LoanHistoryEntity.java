package com.fourfinance.loan.sample.lendmoney.model;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "LoanHistory")
@Access(value= AccessType.FIELD)
public class LoanHistoryEntity {

    @Id
    @Column(name ="ReferenceId")
    int referenceId;

    @Column(name = "TaxPayerId")
    String taxPayerId;

    @Column(name = "LoanAmount")
    int loanAmount;

    @Column(name = "LoanTenure")
    int loanTenure;

    @Column(name = "AnnualIncome")
    int annualIncome;

    @Column(name = "rateOfInterest")
    int interest;

    @Column(name = "LoanStatus")
    Date loanStatus;

    @Column(name = "RevisedInterest")
    int revisedInterest;

    @Column(name = "RevisedDueDate")
    Date revisedDueDate;

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    public String getTaxPayerId() {
        return taxPayerId;
    }

    public void setTaxPayerId(String taxPayerId) {
        this.taxPayerId = taxPayerId;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLoanTenure() {
        return loanTenure;
    }

    public void setLoanTenure(int loanTenure) {
        this.loanTenure = loanTenure;
    }

    public int getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public Date getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Date loanStatus) {
        this.loanStatus = loanStatus;
    }

    public int getRevisedInterest() {
        return revisedInterest;
    }

    public void setRevisedInterest(int revisedInterest) {
        this.revisedInterest = revisedInterest;
    }

    public Date getRevisedDueDate() {
        return revisedDueDate;
    }

    public void setRevisedDueDate(Date revisedDueDate) {
        this.revisedDueDate = revisedDueDate;
    }
}
