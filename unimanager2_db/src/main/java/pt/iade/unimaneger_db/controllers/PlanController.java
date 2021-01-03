package pt.iade.unimaneger_db.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimaneger_db.models.PlanoEstudo;
import pt.iade.unimaneger_db.models.repositories.PlanRepository;




@RestController
@RequestMapping(path="/api/planos")


public class PlanController {
    private Logger logger = LoggerFactory.
           getLogger(PlanController.class);
    @Autowired
    private PlanRepository planRepository;
    @GetMapping(path ="", produces= MediaType.
           APPLICATION_JSON_VALUE)
        public Iterable <PlanoEstudo> getPlanos(){
            logger.info("Sending all planos");
            return planRepository.findAll();
        } 
        
        


        @PostMapping(path ="", produces = MediaType.APPLICATION_JSON_VALUE ) // mesmo caminho q o find all
        public PlanoEstudo savePlano(@RequestBody PlanoEstudo plano) {
        PlanoEstudo savedPlano = planRepository.save(plano);
        logger.info("Saving plano with id "+ savedPlano.getCur_id());
        return savedPlano;
}

    
}
