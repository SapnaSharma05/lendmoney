package com.fourfinance.loan.sample.lendmoney.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoanHistoryResponse {

    private String referenceId;
    private Integer loanAmount;
    private Integer tenure;
    private Integer interest;
    private String dueDate;
    private String paymentDate;
}
