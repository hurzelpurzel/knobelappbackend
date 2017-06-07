/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pottmeier.controller;

import de.pottmeier.model.TerminDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ludger
 */
@RestController
@RequestMapping("/termine")
public class TerminProvider {

    @Autowired
    private de.pottmeier.beans.TerminRepositoryMongo rep;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody TerminDto termin) {

        rep.insert(termin);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDto> updateTermin(@PathVariable("id") int id, @RequestBody TerminDto termin) {
        rep.save(termin);
        return new ResponseEntity<TerminDto>(termin, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
        rep.delete(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDto> getTermin(@PathVariable(value = "id") String id) {
        
        TerminDto termin = rep.findOne(id);
        if(termin == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TerminDto>(termin, HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDto>> getTermine() {

        List<TerminDto> termine= rep.findAll();
        
       return new ResponseEntity(termine,HttpStatus.OK);
    }

}
