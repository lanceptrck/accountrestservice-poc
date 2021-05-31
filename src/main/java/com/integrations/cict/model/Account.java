package com.integrations.cict.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @NoArgsConstructor
public class Account implements Serializable {

    private String module;
    private String company;
    private String division;
    private String acct_no;
    private String jo_no;
    private String first_name;
    private String middle_name;
    private String last_name;
    private Date birthday;
    private String mother_maiden_name;
    private List<String> email_address;
    private List<String> mobile_no;
    private String subscriber_type;
    @SerializedName("package")
    private String planOrPackage;
    private String nap_code;
    private String status;
    private List<Subscription> subscriptions;
    private Area area;

    public void addSubscription(Subscription subscription){
        if(subscriptions == null){
            subscriptions = new ArrayList<>();
        }
        subscriptions.add(subscription);
    }

    @Override
    public String toString() {
        return "Account{" +
                "module='" + module + '\'' +
                ", company='" + company + '\'' +
                ", division='" + division + '\'' +
                ", acct_no='" + acct_no + '\'' +
                ", jo_no='O" + jo_no + '\'' +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birthday=" + birthday +
                ", mother_maiden_name='" + mother_maiden_name + '\'' +
                ", email_address=" + email_address +
                ", mobile_no=" + mobile_no +
                ", subscriber_type='" + subscriber_type + '\'' +
                ", planOrPackage='" + planOrPackage + '\'' +
                ", nap_code='" + nap_code + '\'' +
                ", status='" + status + '\'' +
                ", subscriptions=" + subscriptions +
                ", area=" + area +
                '}';
    }
}
