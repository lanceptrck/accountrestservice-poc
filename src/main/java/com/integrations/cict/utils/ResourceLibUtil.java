package com.integrations.cict.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.integrations.cict.model.Account;
import com.integrations.cict.model.OutageStatus;
import com.integrations.cict.model.PaymentDetail;

import java.util.Date;

public class ResourceLibUtil {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private ResourceLibUtil(){

    }

    public static Account getSampleAccount(){
        Account account = gson.fromJson("{\n" +
                "      \"module\":\"ibas\",\n" +
                "      \"company\":\"COMCL\",\n" +
                "      \"division\":\"TMINT\",\n" +
                "      \"acct_no\":\"1050602039596\",\n" +
                "      \"jo_no\":\"00035755\",\n" +
                "      \"first_name\":\"EDISON\",\n" +
                "      \"middle_name\":\"GUICO\",\n" +
                "      \"last_name\":\"ALMAREZ\",\n" +
                "      \"birthday\":\"1983-07-17\",\n" +
                "      \"mother_maiden_name\":\"\",\n" +
                "      \"email_address\":[\n" +
                "         \"edison.almarez@gmail.com\"\n" +
                "      ],\n" +
                "      \"mobile_no\":[\n" +
                "         \"09494956030\",\n" +
                "         \"09552833467\"\n" +
                "      ],\n" +
                "      \"subscriber_type\":\"residential\",\n" +
                "      \"package\":\"FIBERX1500 (PROMO)\",\n" +
                "      \"nap_code\":\"IMC001 LP344 NP3-4\",\n" +
                "      \"area\":{\n" +
                "         \"municipality\":\"IMUS\",\n" +
                "         \"province\":\"CAVITE\",\n" +
                "         \"service_address\":\"B63 L53, JADE RESIDENCES, MALAGASANG I-G 76, IMUS, CAVITE, PHILIPPINES\"\n" +
                "      },\n" +
                "      \"subscriptions\":[\n" +
                "         {\n" +
                "            \"item_code\":\"00030410\",\n" +
                "            \"serial_no\":\"ZTEGC8CD0815\",\n" +
                "            \"mac_address\":\"C85A9FC0C336\",\n" +
                "            \"subscription\":\"FIBERX1500 (PROMO)\",\n" +
                "            \"product_id\":\"FTTX_25MB\",\n" +
                "            \"currency_code\":\"PHP\",\n" +
                "            \"mrc\":\"1500.00\"\n" +
                "         }\n" +
                "      ],\n" +
                "      \"status\":\"active\"\n" +
                "   }", Account.class);

        return account;
    }

    public static OutageStatus getSampleOutageStatus(){
        OutageStatus status = new OutageStatus();
        status.set_online(true);
        status.setAs_of(new Date());

        return status;
    }

    public static PaymentDetail getSamplePaymentDetail(){

        PaymentDetail detail = new PaymentDetail();
        detail.setCurrency_code("PHP");
        detail.setDue_date(new Date());
        detail.setMonths_arrear(9);
        detail.setCurrent_ar(1500.00);

        return detail;
    }

}
