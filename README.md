# BankingApp

The most important services thet any bank provides to the clients is the ability to deposite and withdraw money,
In this demoApp there is an implementation of these two functions using :
- Java 17
- Spring Web
- Spring Data JPA
- Lombok
- MySQL Workbench

by using the dempApp you can :
- Add new Bank Account
- Deposit money
- Withdraw money
- Delete Bank Account
- Get All Accounts
- Get Account By Id

API's endpoints:



▪ Add new bank account: POST http://localhost:8080/api/accounts


▪ Get all accounts    : GET http://localhost:8080/api/accounts


▪ Get account by id   : GET http://localhost:8080/api/accounts/{accountId}



▪ Deposit             : PUT http://localhost:8080/api/accounts/{accountId}/deposit



▪ Withdraw            : PUT http://localhost:8080/api/accounts/{accountId}/withdraw



▪ Delete              : DELETE http://localhost:8080/api/accounts/{accountId}

