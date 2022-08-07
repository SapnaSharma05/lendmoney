package com.fourfinance.loan.sample.lendmoney.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ErrorResponse {
    String errorCode;
    String errorMessage;
}
