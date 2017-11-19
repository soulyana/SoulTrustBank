package me.soulyana.soultrustbank.entities;

import me.soulyana.soultrustbank.repositories.AccountRepository;
import me.soulyana.soultrustbank.repositories.TransactionRepository;
import me.soulyana.soultrustbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    AccountRepository accountRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByAcct(int acct) {
        return userRepository.findByAcct(acct);
    }

    public Long countByAcct(int acct) {
        return userRepository.countByAcct(acct);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Long countByUsername(String username) {
        return userRepository.countByUsername(username);
    }


    public void saveUser(User user) {
        user.setEnabled(true);
        userRepository.save(user);
        Account account = new Account(user);
        accountRepository.save(account);
    }
}
