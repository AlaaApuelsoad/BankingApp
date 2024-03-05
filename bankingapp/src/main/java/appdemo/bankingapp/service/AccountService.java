package appdemo.bankingapp.service;

import appdemo.bankingapp.dto.AccountDto;
import appdemo.bankingapp.entity.Account;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(long accountId);

    List<Account> getAccounts();

    AccountDto deposit(long accountId, double amount);

    AccountDto withdraw(long accountId,double amount);

    void deleteAccount(long accountId);

}
