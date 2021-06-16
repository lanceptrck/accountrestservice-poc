package com.integrations.cict.controller;

import com.integrations.cict.payload.AccountRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ESBCallerTest {

    private final static String ACCOUNT_DETAILS_ENDPOINT = "/converge/cxp/v1/account/account/details/";
    private final static String PAYMENT_DETAILS_ENDPOINT = "/converge/cxp/v1/account/payment/info/";
    private final static String OUTAGE_STATUS_ENDPOINT = "/converge/ibas/v1/crm/account/outage/status/";

    @Value("${esb.host}")
    private String host;

    @Value("${esb.token}")
    private String token;

    public void rest_template_test() throws URISyntaxException {
        RestTemplate rs = new RestTemplate();
        final String accountDetailsUrl = host+""+ACCOUNT_DETAILS_ENDPOINT;
        URI uri = new URI(accountDetailsUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        AccountRequest ar = new AccountRequest();
        ar.setAcct_no("");

        HttpEntity<AccountRequest> request = new HttpEntity<>(ar, headers);

        ResponseEntity<String> result = rs.postForEntity(uri, request, String.class);

        assertEquals(201, result.getStatusCode());

    }

}
