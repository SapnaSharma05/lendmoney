package com.fourfinance.loan.sample.lendmoney.service;

import com.fourfinance.loan.sample.lendmoney.dao.LoanApplicationDao;
import com.fourfinance.loan.sample.lendmoney.dao.LoanExtendDao;
import com.fourfinance.loan.sample.lendmoney.dao.LoanHistoryDao;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanProcessingServiceTest {

    private final LoanApplicationDao loanApplicationDao = Mockito.mock(LoanApplicationDao.class);
    private final LoanHistoryDao loanHistoryDao = Mockito.mock(LoanHistoryDao.class);
    private final LoanExtendDao loanExtendDao = Mockito.mock(LoanExtendDao.class);

    LoanProcessingService loanProcessingService = new LoanProcessingService(loanApplicationDao,loanHistoryDao,loanExtendDao);

    @ParameterizedTest
    @CsvSource({"100,1,false","100,5,true"})
    public void testPerformHighRisk(int amount, int ipHits, boolean expectedResult){
        boolean result = loanProcessingService.performRiskAnalysis(amount,ipHits);
        assertEquals(expectedResult,result);
    }
}
