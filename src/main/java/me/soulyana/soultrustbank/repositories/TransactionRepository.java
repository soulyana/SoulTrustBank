package me.soulyana.soultrustbank.repositories;

import me.soulyana.soultrustbank.entities.Account;
import me.soulyana.soultrustbank.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Transaction findByAcctNum(Account account);
    Transaction findByAction(String action);
    Transaction findByAmount(Double amount);
    Transaction findByReason(String reason);

    Long countByAcctNum(Account account);
    Long countByAction(String action);
    Long countByAmount(Double amount);
    Long countByReason(String reason);
}
