package com.fourfinance.loan.sample.lendmoney.service.Constants;

public enum ServiceConstants {

    APPROVED("Approved"),
    REJECTED("Rejected"),
    NULL("");

    private final String str;

    ServiceConstants(String str) {
        this.str = str;
    }
}
