/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pottmeier.beans;


import de.pottmeier.model.TerminDto;


import org.springframework.data.mongodb.repository.MongoRepository;



public interface TerminRepositoryMongo extends MongoRepository<TerminDto, String> {

    

}

