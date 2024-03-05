package appdemo.bankingapp.service;

import appdemo.bankingapp.dto.AccountDto;
import appdemo.bankingapp.entity.Account;
import appdemo.bankingapp.mapper.AccountMapper;
import appdemo.bankingapp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(long accountId) {

        Account account = accountRepository.findById(accountId).
                orElseThrow(()-> new RuntimeException("Account doesn't exist"));

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public List<Account> getAccounts() {

        List<Account> accountDtoList = accountRepository.findAll();
        return accountDtoList;
    }

    @Override
    public AccountDto deposit(long accountId, double amount) {

        Account account = accountRepository.findById(accountId).
                orElseThrow(()-> new RuntimeException("Account doesn't exist"));

        if (amount < 0){
            throw new RuntimeException("Inappropriate amount");
        }

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(long accountId, double amount) {

        Account account = accountRepository.findById(accountId).
                orElseThrow(()-> new RuntimeException("Account doesn't exist"));

        if (account.getBalance() < amount || amount < 0 ){
            throw new RuntimeException("Insufficient amount");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public void deleteAccount(long accountId) {

        Account account = accountRepository.findById(accountId).
                orElseThrow(()->new RuntimeException("Account doesn't exist"));

        accountRepository.deleteById(accountId);
    }


}
