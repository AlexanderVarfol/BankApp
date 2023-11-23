package com.bankservice.app.mapper;

import com.bankservice.app.dto.AccountDTO;
import com.bankservice.app.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "client.client_status", target = "client_status")
    @Mapping(source = "agreement.interestRate", target = "interestRate")
    @Mapping(source = "agreement.agreement_status", target = "agreement_status")
    AccountDTO toDTO(Account account);




    //Account toEntity(AccountDTO accountDTO);


}
