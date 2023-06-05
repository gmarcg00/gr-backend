package dev.grbackend.repositories;

import dev.grbackend.models.Reaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReactionRepository extends CrudRepository<Reaction,Long> {
    public abstract List<Reaction> findByUserName(String userName);
    public abstract List<Reaction> findBySlug(String userName);
}
