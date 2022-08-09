package com.fourfinance.loan.sample.lendmoney.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanHistoryResponse {

    private int referenceId;
    private String taxPayerId;
    private int loanAmount;
    private int loanTenure;
    private int annualIncome;
    private int interest;
    private Date loanStatus;
    private int revisedInterest;
    private Date revisedDueDate;
}
