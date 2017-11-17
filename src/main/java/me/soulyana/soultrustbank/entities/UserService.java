package me.soulyana.soultrustbank.entities;

import me.soulyana.soultrustbank.repositories.RoleRepository;
import me.soulyana.soultrustbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//    UserData findByUsername(String username);
//    UserData findBySsn(String ssn);
//    UserData findByAcct(int acct);
    public UserData findByAcct(int acct) {
        return userRepository.findByAcct(acct);
    }

    public Long countByAcct(int acct) {
        return userRepository.countByAcct(acct);
    }

    public UserData findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Long countByUsername(String username) {
        return userRepository.countByUsername(username);
    }

    public UserData findBySsn(String ssn) {
        return userRepository.findBySsn(ssn);
    }

    public void saveUserData(UserData user) {
        user.addRole(roleRepository.findByRole("ROLE_USER"));
        user.setEnabled(true);
        userRepository.save(user);

    }

    public void saveAdmin(UserData user) {
        user.addRole(roleRepository.findByRole("ADMIN"));
        user.setEnabled(true);
        userRepository.save(user);
    }

}
