package com.fourfinance.loan.sample.lendmoney.controller;

import com.fourfinance.loan.sample.lendmoney.model.ErrorResponse;
import com.fourfinance.loan.sample.lendmoney.model.LoanHistoryResponse;
import com.fourfinance.loan.sample.lendmoney.model.LoanRequest;
import com.fourfinance.loan.sample.lendmoney.model.LoanResponse;
import com.fourfinance.loan.sample.lendmoney.service.LoanProcessingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Tag(name = "LoanApplicationJourney", description = "API to handle loan application requests")

@RestController
@AllArgsConstructor
public class LoanProcessingController {

    private final LoanProcessingService loanProcessingService;

    @PostMapping(path = "/newLoanRequest")
    @Operation(
            summary = "Process new loan request",
            tags = {"LoanApplicationJourney"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Successful operation",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = LoanResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "400", description = "Bad request",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "500", description = "Internal service error",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}
            )
    })
    public ResponseEntity<Object> loanApplicationRequest(
            @RequestBody LoanRequest loanRequest,
            HttpServletRequest httpRequest
    ) {
        return new ResponseEntity<>(loanProcessingService.processLoanRequest(loanRequest, httpRequest.getRemoteAddr())
                , HttpStatus.OK);
    }

    @PostMapping(path = "/extendLoan")
    @Operation(
            summary = "To extend existing due date",
            tags = {"LoanApplicationJourney"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Successful operation",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = LoanResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "400", description = "Bad request",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "500", description = "Internal service error",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}
            )
    })
    public ResponseEntity<Object> loanPostponeRequest(
            @RequestBody LoanRequest loanRequest
    ) {
        return new ResponseEntity<>(loanProcessingService.postponeLoanRequest()
                , HttpStatus.OK);
    }


    @GetMapping(
            value = "/retrieveLoanHistory",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Get the history of loans for a customer",
            description = "Retrieves loan history and loan extensions for a customer", tags = {
            "LoanApplicationJourney"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Successful operation",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = LoanHistoryResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "404", description = "No loan history found",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}
            ),
            @ApiResponse(
                    responseCode = "500", description = "Internal service error",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}
            )
    })
    public ResponseEntity<Object> getLoanHistory() {
        return new ResponseEntity<>(loanProcessingService.getLoanHistory(),
                HttpStatus.OK);
    }
}
