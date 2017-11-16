package me.soulyana.soultrustbank.repositories;

import me.soulyana.soultrustbank.entities.UserData;
import me.soulyana.soultrustbank.entities.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserData, Long> {
    UserRole findByRole(String role);

}
