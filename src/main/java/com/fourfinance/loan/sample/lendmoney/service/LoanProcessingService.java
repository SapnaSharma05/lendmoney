package com.fourfinance.loan.sample.lendmoney.service;


import com.fourfinance.loan.sample.lendmoney.dao.LoanApplicationDao;
import com.fourfinance.loan.sample.lendmoney.dao.LoanExtendDao;
import com.fourfinance.loan.sample.lendmoney.dao.LoanHistoryDao;
import com.fourfinance.loan.sample.lendmoney.model.LoanHistoryResponse;
import com.fourfinance.loan.sample.lendmoney.model.LoanRequest;
import com.fourfinance.loan.sample.lendmoney.model.LoanResponse;
import com.fourfinance.loan.sample.lendmoney.service.Constants.ServiceConstants;
import com.fourfinance.loan.sample.lendmoney.utility.LoanUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanProcessingService {

    private final Integer MAX_POSSIBLE_AMOUNT = 5000;

    @Autowired
    LoanApplicationDao loanApplicationDao;
    LoanHistoryDao loanHistoryDao;
    LoanExtendDao loanExtendDao;

    public LoanResponse processLoanRequest(LoanRequest loanRequest, String remoteAddress) {

        if (remoteAddress != null)
            loanApplicationDao.saveIPAddress(remoteAddress, loanRequest.getTaxPayerId());
        int countOfIPhits = Integer.parseInt(loanApplicationDao.getIPAddressCount(remoteAddress, loanRequest.getTaxPayerId()));

        boolean isHighRisk = performRiskAnalysis(loanRequest.getLoanAmount(), countOfIPhits);

        return isHighRisk ? LoanResponse.builder().referenceId(String.valueOf(ServiceConstants.NULL)).loanApplicationStatus(String.valueOf(ServiceConstants.REJECTED)).build() :
                LoanResponse.builder().referenceId(loanApplicationDao.saveLoanApplicationDetails(loanRequest))
                        .loanApplicationStatus(String.valueOf(ServiceConstants.APPROVED)).build();
    }

    public boolean performRiskAnalysis(Integer amount, Integer countOfIPhits) {

        LocalTime rangeEnd = LocalTime.parse("06:00:00");
        LocalTime rangeStart = LocalTime.parse("00:00:00");
        if (((LocalTime.now().isAfter(rangeStart) && LocalTime.now().isBefore(rangeEnd))
                && (amount > MAX_POSSIBLE_AMOUNT)) || countOfIPhits > 3) {
            return true;
        }
        return false;
    }

    public List<LoanHistoryResponse> getLoanHistory(String taxPayerId) {
        return loanHistoryDao.getLoanHistoryForUser(taxPayerId);
    }

    public LoanResponse postponeLoanRequest(int referenceId) {
        Double interest = (Double) 0.0;
        Timestamp dueDate = null;
        List<Object[]> i = loanExtendDao.getDetailsForLoanExtend(referenceId);

        for (Object q[] : i) {
            dueDate = (Timestamp) q[0];
            interest = (Double) q[1];
        }

        loanExtendDao.updateLoanDetailsForExtension(referenceId, interest * 1.5, LoanUtil.addDays(dueDate, 7));
        return new LoanResponse();
    }
}
