package dev.spring.firstproject.apibackend.repository;

import dev.spring.firstproject.apibackend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    public abstract ArrayList<User> findByPrioridad(boolean prioridad);
}
