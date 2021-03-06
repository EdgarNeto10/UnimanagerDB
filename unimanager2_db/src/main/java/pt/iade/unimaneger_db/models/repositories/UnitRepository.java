package pt.iade.unimaneger_db.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.unimaneger_db.models.Unit;

public interface UnitRepository extends CrudRepository<Unit, Integer> {
    
    Optional<Unit> findById(int id);
}
