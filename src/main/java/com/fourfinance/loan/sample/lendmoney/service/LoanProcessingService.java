package com.fourfinance.loan.sample.lendmoney.service;


import com.fourfinance.loan.sample.lendmoney.dao.LoanApplicationDao;
import com.fourfinance.loan.sample.lendmoney.dao.LoanExtendDao;
import com.fourfinance.loan.sample.lendmoney.dao.LoanHistoryDao;
import com.fourfinance.loan.sample.lendmoney.model.LoanHistoryResponse;
import com.fourfinance.loan.sample.lendmoney.model.LoanRequest;
import com.fourfinance.loan.sample.lendmoney.model.LoanResponse;
import com.fourfinance.loan.sample.lendmoney.service.Constants.ServiceConstants;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanProcessingService {

    private final Integer MAX_POSSIBLE_AMOUNT = 5000;

    @Autowired
    LoanApplicationDao loanApplicationDao;
    LoanHistoryDao loanHistoryDao;
    LoanExtendDao loanExtendDao;

    public LoanResponse processLoanRequest(LoanRequest loanRequest, String remoteAddr){

        System.out.println("IP address "+remoteAddr);
        boolean isHighRisk = performRiskAnalysis(loanRequest.getLoanAmount());
        if(isHighRisk) {
            return LoanResponse.builder().referenceId(String.valueOf(ServiceConstants.NULL)).loanApplicationStatus(String.valueOf(ServiceConstants.REJECTED)).build();
        } else{
            return LoanResponse.builder().referenceId(loanApplicationDao.saveLoanApplicationDetails(loanRequest))
                    .loanApplicationStatus(String.valueOf(ServiceConstants.APPROVED)).build();

        }
    }

    public boolean performRiskAnalysis(Integer amount) {
        LocalTime rangeEnd = LocalTime.parse("06:00:00");
        LocalTime rangeStart = LocalTime.parse("00:00:00");
        if ((LocalTime.now().isAfter(rangeStart) && LocalTime.now().isBefore(rangeEnd))
                && (amount > MAX_POSSIBLE_AMOUNT)) {
            return true;
        }
        return false;
    }

    public List<LoanHistoryResponse> getLoanHistory(String taxPayerId){
        return loanHistoryDao.getLoanHistoryForUser(taxPayerId);
    }

    public LoanResponse postponeLoanRequest(int referenceId){
        int interest = 0;
        Date dueDate;

        List<Object[]> loanToExtend = loanExtendDao.getDetailsForLoanExtend(referenceId);
        for (Object[] row: loanToExtend) {
            interest = (int) row[0];
            dueDate = (Date) row[1];
        }
        //loanExtendDao.updateLoanDetailsForExtension(referenceId, (int) (interest*1.5),;);
        return new LoanResponse();
    }
}
