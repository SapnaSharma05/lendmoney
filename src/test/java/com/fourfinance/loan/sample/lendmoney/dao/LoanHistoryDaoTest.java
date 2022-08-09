package com.fourfinance.loan.sample.lendmoney.dao;

import com.fourfinance.loan.sample.lendmoney.model.LoanHistoryResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoanHistoryDaoTest {

    LoanHistoryDao LoanHistoryDao = new LoanHistoryDao();

    @Test
    public void testGet() {
        List<LoanHistoryResponse> result = LoanHistoryDao.getLoanHistoryForUser("EOYPS12364");
        assertFalse(result.isEmpty());
    }
}
