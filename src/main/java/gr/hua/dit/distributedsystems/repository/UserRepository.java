package gr.hua.dit.distributedsystems.repository;


import gr.hua.dit.distributedsystems.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="users")
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}

