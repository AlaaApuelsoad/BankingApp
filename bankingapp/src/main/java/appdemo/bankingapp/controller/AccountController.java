package appdemo.bankingapp.controller;

import appdemo.bankingapp.dto.AccountDto;
import appdemo.bankingapp.entity.Account;
import appdemo.bankingapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){

        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // Get Account REST API
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable long accountId){

        AccountDto accountDto = accountService.getAccountById(accountId);

        return ResponseEntity.ok(accountDto);
    }

    // Get All Accounts REST API
    @GetMapping
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    // Deposit REST API
    @PutMapping("/{accountId}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable long accountId,
                                              @RequestBody Map<String,Double> request){

        Double amount = request.get("amount");

        AccountDto accountDto = accountService.deposit(accountId,amount);
        return ResponseEntity.ok(accountDto);
    }

    // Withdraw REST API
    @PutMapping("/{accountId}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable long accountId,
                                               @RequestBody Map<String,Double> request){

        Double amount = request.get("amount");

        AccountDto accountDto = accountService.withdraw(accountId,amount);

        return ResponseEntity.ok(accountDto);
    }

    // Delete Account REST API
    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable long accountId){

        accountService.deleteAccount(accountId);

        return ResponseEntity.ok("Account id- "+accountId+" Deleted successfully!");
    }
}
