package me.soulyana.soultrustbank.repositories;

import me.soulyana.soultrustbank.entities.Account;
import me.soulyana.soultrustbank.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository  extends CrudRepository<Account, Long> {

    Account findByAcctNum(int acctNum);
    Account findByUser(User user);

    Long countByAcctNum(int acctNum);
    Long countByUser(User user);
}
