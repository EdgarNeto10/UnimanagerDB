package pt.iade.unimaneger_db.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimaneger_db.models.Unit;
import pt.iade.unimaneger_db.models.repositories.UnitRepository;





@RestController
@RequestMapping(path="/api/units")

public class UnitController {
    private Logger logger = LoggerFactory.
           getLogger(UnitController.class);
    @Autowired
    private UnitRepository unitRepository;
    @GetMapping(path ="", produces= MediaType.
           APPLICATION_JSON_VALUE)
        public Iterable <Unit> getUnits(){
            logger.info("Sending all units");
            return unitRepository.findAll();
        } 
        
        
        @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
        public Unit getUnit(@PathVariable int id) {
             logger.info("Sending unit with id "+id);
             Optional<Unit> _unit= unitRepository.findById(id);
             return _unit.get();
        }

    
}
