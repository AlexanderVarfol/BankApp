package com.bankservice.app.mapper;

import com.bankservice.app.dto.AccountDTO;
import com.bankservice.app.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDTO toDTO(Account account);
    Account toEntity(AccountDTO accountDTO);


}
