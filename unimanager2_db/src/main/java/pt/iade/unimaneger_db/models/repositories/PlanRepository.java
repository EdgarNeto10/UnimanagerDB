package pt.iade.unimaneger_db.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.unimaneger_db.models.PlanoEstudo;

public interface PlanRepository extends CrudRepository<PlanoEstudo, Integer> {
    
    Optional<PlanoEstudo> findById(int id);
}
