package com.example.OpdrachtWeek5.Controllers;

import com.example.OpdrachtWeek5.Models.Account;
import com.example.OpdrachtWeek5.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * Create account account.
     *
     * @param account the account
     * @return the account
     */
    @PostMapping("/accounts")
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }

    /**
     * Update user response entity.
     *
     * @param accountId the user id
     * @param accountDetails the user details
     * @return the response entity
     * @throws RuntimeException the resource not found exception
     */
    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateAccount(
            @PathVariable(value = "id") Long accountId, @Valid @RequestBody Account accountDetails){
        Account account =
                accountRepository
                        .findById(accountId)
                        .orElseThrow(() -> new RuntimeException("User not found on :: " + accountId));
        account.setAccountNumber(account.getAccountNumber());
        account.setIban(account.getIban());
        final Account updatedAccount = accountRepository.save(account);
        return ResponseEntity.ok(updatedAccount);
    }

    /**
     * Delete user map.
     *
     * @param accountId the account id
     * @return the map
     * @throws RuntimeException the exception
     */
    @DeleteMapping("/accounts/{id}")
    public Map<String, Boolean> deleteAccount(@PathVariable(value = "id") Long accountId){
        Account account =
                accountRepository
                        .findById(accountId)
                        .orElseThrow(() -> new RuntimeException("User not found on :: " + accountId));
        accountRepository.delete(account);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
