package com.integrations.cict.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.integrations.cict.dto.old.OldAccountDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SerializationTest {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Area area;
    private Subscription subscription;
    private Account account;
    private OldAccountDTO dto;

    @BeforeEach
    public void init() {
        subscription = null;
        area = null;
        account = null;
        dto = null;
    }

    @Test
    public void create_account_object() {

        loadArea();
        loadSubscription();

        account = new Account();
        account.setArea(area);
        account.addSubscription(subscription);

        System.out.println(account);

    }

    @Test
    public void serialize_full_account_object_from_actual_payload() {
        account = gson.fromJson("{\n" +
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

        //System.out.println(gson.toJson(account));

    }

    @Test
    public void deserialize_whole_dto() {
        dto = gson.fromJson("{\"success\":true,\n" +
                "   \"errors\":[\n" +
                "      \n" +
                "   ],\n" +
                "   \"data\":{\n" +
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
                "   }\n" +
                "}", OldAccountDTO.class);


        account = dto.getData();

        //System.out.println(gson.toJson(account));

    }

    private void loadArea() {
        area = gson.fromJson("{" +
                "\"municipality\":\"IMUS\",\n" +
                "         \"province\":\"CAVITE\",\n" +
                "         \"service_address\":\"B63 L53, JADE RESIDENCES, MALAGASANG I-G 76, IMUS, CAVITE, PHILIPPINES\"\n" +
                "      }", Area.class);
    }

    private void loadSubscription() {
        subscription = gson.fromJson("{\n" +
                "            \"item_code\":\"00029194\",\n" +
                "            \"serial_no\":\"05070117290001328\",\n" +
                "            \"mac_address\":\"9C62AB1EDDD9\",\n" +
                "            \"subscription\":\"FIBER X 1500 - STAGGERED OTC - PLUS 99\",\n" +
                "            \"product_id\":\"FTTX_35MB\",\n" +
                "            \"currency_code\":\"PHP\",\n" +
                "            \"mrc\":\"1599.00\"\n" +
                "         }", Subscription.class);
    }

}
