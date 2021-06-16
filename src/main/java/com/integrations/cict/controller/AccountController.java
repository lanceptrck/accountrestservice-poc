package com.integrations.cict.controller;

import com.integrations.cict.dto.AccountDTO;
import com.integrations.cict.dto.ErrorDTO;
import com.integrations.cict.dto.OutageStatusDTO;
import com.integrations.cict.dto.PaymentDetailDTO;
import com.integrations.cict.exception.AccountNotFoundException;
import com.integrations.cict.model.Account;
import com.integrations.cict.model.Status;
import com.integrations.cict.utils.ResourceLibUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {

    private final Logger logger = LoggerFactory.getLogger(AccountController.class);
    private final static String ACCOUNT_DETAILS_ENDPOINT = "/converge/cxp/v1/account/account/details/";
    private final static String PAYMENT_DETAILS_ENDPOINT = "/converge/cxp/v1/account/payment/info/";
    private final static String OUTAGE_STATUS_ENDPOINT = "/converge/ibas/v1/crm/account/outage/status/";

    @Value("${esb.host}")
    private String host;

    @Value("${esb.token}")
    private String token;

    @Operation(summary = "Get account details of the provided account number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the nearest nap box",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AccountDTO.class))}),
            @ApiResponse(responseCode = "406", description = "Account doesn't exist",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class))})
    })
    @GetMapping("/info/{account_no}")
    public ResponseEntity<?> getAccountDetails(@PathVariable(name = "account_no", required = true) String account_no) {

        Account account = ResourceLibUtil.getSampleAccount();

        if (account == null) {
            throw new AccountNotFoundException("Account doesn't exist");
        }

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setStatus(Status.SUCCESS);
        accountDTO.setData(account);
        accountDTO.setResponseCode(HttpStatus.OK.value());

        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @Operation(summary = "Get payment details of provided account number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the payment details of the account",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentDetailDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Account doesn't exist",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class))})
    })
    @GetMapping("/payment/info/{account_no}")
    public ResponseEntity<?> getPaymentDetails(@PathVariable(name = "account_no", required = true) String account_no) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get outage status of given account number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the outage details of the account",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OutageStatusDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Account doesn't exist",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class))})
    })
    @GetMapping("/outage/status/{account_no}")
    public ResponseEntity<?> getOutageStatus(@PathVariable(name = "account_no", required = true) String account_no) {
        return ResponseEntity.ok().build();
    }


}
