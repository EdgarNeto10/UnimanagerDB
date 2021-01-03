package pt.iade.unimaneger_db.models.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.unimaneger_db.models.Curso;
import pt.iade.unimaneger_db.models.PlanoEstudo;

public interface CourseRepository extends CrudRepository<Curso, Integer> {
    Optional<Curso> findById(int id);

    @Modifying
    @Transactional
    @Query(value="Insert into planoestudos "+
    "(pla_cur_id,pla_dis_id,pla_semestre) "+
    "values(:#{#plan.curso.id}, "+
    ":#{#plan.unidade.dis_id},:#{#plan.semestre})",
    nativeQuery=true)
    void addUnitToCourse(@Param("plan") PlanoEstudo plan);

    
}
