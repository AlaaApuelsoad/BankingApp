package appdemo.bankingapp.mapper;

import appdemo.bankingapp.dto.AccountDto;
import appdemo.bankingapp.entity.Account;

public class AccountMapper {

    //Mapping AccountDto to Account
    public static Account mapToAccount(AccountDto accountDto){

        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountName(),
                accountDto.getBalance()
        );
        return account;
    }

    //Mapping Account to AccountDto
    public static AccountDto mapToAccountDto(Account account){

        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountName(),
                account.getBalance()
        );

        return accountDto;
    }
}
