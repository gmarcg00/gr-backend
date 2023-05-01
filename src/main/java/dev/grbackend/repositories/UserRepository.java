package dev.grbackend.repositories;

import dev.grbackend.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    public abstract User findByUserName(String username);
    public abstract User deleteByUserName(String username);
}