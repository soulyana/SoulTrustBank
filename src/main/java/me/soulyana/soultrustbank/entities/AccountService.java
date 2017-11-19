package me.soulyana.soultrustbank.entities;

import me.soulyana.soultrustbank.repositories.AccountRepository;
import me.soulyana.soultrustbank.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    TransactionRepository transactionRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account findByAcctNum(int acctNum) {
        return accountRepository.findByAcctNum(acctNum);
    }

    public Long countByAcctNum(int acctNum) {
        return accountRepository.countByAcctNum(acctNum);
    }

    public Account findByUser(User user) {
        return accountRepository.findByUser(user);
    }

    public Long countByUser(User user) {
        return accountRepository.countByUser(user);
    }


    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public boolean withdraw(Account account, double amount, String reason) {

        account.setBalance(account.getBalance()-amount);
        if(account.getBalance() > 0) {
            Transaction transaction = new Transaction();

            accountRepository.save(account);
            transaction.setAmount(amount);
            transaction.setAction("withdraw");
            transaction.setAccount(account);
            transaction.setReason(reason);

            transactionRepository.save(transaction);

            return true;
        }
        return false;
    }

    public void deposit(Account account, double amount, String reason) {
        account.setBalance(account.getBalance()+amount);
        Transaction transaction = new Transaction();

        accountRepository.save(account);
        transaction.setAmount(amount);
        transaction.setAction("deposit");
        transaction.setAccount(account);
        transaction.setReason(reason);

        transactionRepository.save(transaction);
    }
}
