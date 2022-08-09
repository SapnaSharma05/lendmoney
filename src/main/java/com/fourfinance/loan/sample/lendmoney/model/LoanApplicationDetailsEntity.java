package com.fourfinance.loan.sample.lendmoney.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "LoanApplicationDetails")
@Access(value= AccessType.FIELD)
public class LoanApplicationDetailsEntity {

    @Id
    @Column(name ="ReferenceId")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    int referenceId;

    @Column(name ="ApplicantName")
    String applicantName;

    @Column(name = "ApplicantDateOfBirth")
    String applicantDateOfBirth;

    @Column(name = "Gender")
    String gender;

    @Column(name = "ContactNumber")
    String contactNumber;

    @Column(name = "EmailAddress")
    String emailAddress;

    @Column(name = "PermanentAddress")
    String permanentAddress;

    @Column(name = "PresentAddress")
    String presentAddress;

    @Column(name = "TaxPayerId")
    String taxPayerId;

    @Column(name = "EmploymentStatus")
    String employmentStatus;

    @Column(name = "NoOfDependents")
    int noOfDependents;

    @Column(name = "LoanAmount")
    int loanAmount;

    @Column(name = "LoanTenure")
    int loanTenure;

    @Column(name = "AnnualIncome")
    int annualIncome;

    @Column(name = "Interest")
    double interest;

    @Column(name = "DueDate")
    Date dueDate;

    @Column(name = "RevisedInterest")
    double revisedInterest;

    @Column(name = "RevisedDueDate")
    Date revisedDueDate;


    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantDateOfBirth() {
        return applicantDateOfBirth;
    }

    public void setApplicantDateOfBirth(String applicantDateOfBirth) {
        this.applicantDateOfBirth = applicantDateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getTaxPayerId() {
        return taxPayerId;
    }


    public void setTaxPayerId(String taxPayerId) {
        this.taxPayerId = taxPayerId;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public int getNoOfDependents() {
        return noOfDependents;
    }

    public void setNoOfDependents(int noOfDependents) {
        this.noOfDependents = noOfDependents;
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

    public double getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getRevisedInterest() {
        return revisedInterest;
    }

    public void setRevisedInterest(double revisedInterest) {
        this.revisedInterest = revisedInterest;
    }

    public Date getRevisedDueDate() {
        return revisedDueDate;
    }

    public void setRevisedDueDate(Date revisedDueDate) {
        this.revisedDueDate = revisedDueDate;
    }
}
