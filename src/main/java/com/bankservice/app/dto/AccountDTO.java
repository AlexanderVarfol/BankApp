package com.bankservice.app.dto;

import com.bankservice.app.entity.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ClientInfoStatus;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AccountDTO {

//Account
    private String name;
    private String type;

//Client
    private String client_status;

//Agreement
    private String interestRate;
    private String agreement_status;
}
