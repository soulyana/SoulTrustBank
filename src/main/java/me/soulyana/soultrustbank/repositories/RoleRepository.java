package me.soulyana.soultrustbank.repositories;

import me.soulyana.soultrustbank.entities.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<UserRole, Long> {
    UserRole findByRole(String role);
}
