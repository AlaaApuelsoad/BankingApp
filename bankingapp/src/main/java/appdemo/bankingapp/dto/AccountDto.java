package appdemo.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {

    private long id;
    private String accountName;
    private double balance;

}
