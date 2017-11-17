package me.soulyana.soultrustbank.repositories;

import me.soulyana.soultrustbank.entities.UserData;
import me.soulyana.soultrustbank.entities.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserData, Long> {
    UserData findByUsername(String username);
    UserData findBySsn(String ssn);
    UserData findByAcct(int acct);

    Long countByUsername(String username);
    Long countByAcct(int acct);

}
