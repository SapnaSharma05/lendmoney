package com.fourfinance.loan.sample.lendmoney.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoanRequest {

    private String applicantName;
    private Integer loanAmount;
    private Integer loanTenure;
    private String applicantDateOfBirth;
    private String gender;
    private String contactNumber;
    private String presentAddress;
    private String permanentAddress;
    private String taxPayerId;
    private String employmentStatus;
    private Integer noOfDependants;
    private int annualIncome;
    private String emailAddress;
}
