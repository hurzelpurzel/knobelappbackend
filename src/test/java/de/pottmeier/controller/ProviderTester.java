package de.pottmeier.controller;

import de.pottmeier.beans.TerminRepositoryMongo;
import de.pottmeier.model.TerminDto;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderTester {
        @Autowired
        TerminRepositoryMongo rep;
	
	public void contextLoads() {
	}
        
        @Test
        public void testCRUD(){
            TerminDto first = new TerminDto("1",new Date(),"Hier","Knobeln");
            TerminDto second = new TerminDto("2",new Date(),"Dort","Essen");
            rep.insert(first);
            rep.insert(second);
            Assert.assertEquals(rep.count(), 2);
            List res=rep.findAll();
            Assert.assertEquals(res.size(), 2);
             
            rep.delete("1");
            rep.delete("2");
            Assert.assertEquals(rep.count(), 0);
    
        }
        
        
}
