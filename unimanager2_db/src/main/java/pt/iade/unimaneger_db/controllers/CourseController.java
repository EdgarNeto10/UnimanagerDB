package pt.iade.unimaneger_db.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimaneger_db.models.Curso;
import pt.iade.unimaneger_db.models.PlanoEstudo;
import pt.iade.unimaneger_db.models.repositories.CourseRepository;




@RestController
@RequestMapping(path="/api/courses")

public class CourseController {
    private Logger logger = LoggerFactory.
           getLogger(CourseController.class);
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping(path ="", produces= MediaType.
           APPLICATION_JSON_VALUE)
        public Iterable <Curso> getCursos(){
            logger.info("Sending all cursos");
            return courseRepository.findAll();
        } 
        
        
        @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
        public Curso getCurso(@PathVariable int id) {
             logger.info("Sending curso with id "+id);
             Optional<Curso> _curso= courseRepository.findById(id);
             return _curso.get();
        }

        @PostMapping(path = "/{courseId}/units",produces = MediaType.APPLICATION_JSON_VALUE  )
        public SimpleResult saveUnitInCourse( @RequestBody PlanoEstudo plan) {
            logger.info("Adding unit with id " + plan.getUnidade().getDis_id());
            courseRepository.addUnitToCourse(plan);
            return new SimpleResult("Added unit with id "+ plan.getUnidade().getDis_id(),plan);
            
        }

        @PostMapping(path ="", produces = MediaType.APPLICATION_JSON_VALUE ) // mesmo caminho q o find all
        public Curso saveCurso(@RequestBody Curso curso) {
        Curso savedCurso = courseRepository.save(curso);
        logger.info("Saving curso with id "+ savedCurso.getNome());
        return savedCurso;

}


}