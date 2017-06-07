package de.pottmeier.controller;

import de.pottmeier.model.TerminDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * http://howtodoinjava.com/spring/spring-restful/spring-restful-client-resttemplate-example/
 *
 * @author ludger
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestTester {

    final String baseuri = "http://localhost:8090/knobelapp-backend/termine";

    public void contextLoads() {
    }

    @Test
    public void testCRUD() {
        testcreate();
        testRead();

        testReadAll();
        testDelete();

    }

    public void testcreate() {
        String uri = baseuri + "/";

        TerminDto first = new TerminDto("1", new Date(), "Hier", "Knobeln");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(getMessageConverters());

        restTemplate.postForObject(uri, first, TerminDto.class);
        TerminDto second = new TerminDto("2", new Date(), "Dort", "Essen");

        restTemplate.postForObject(uri, second, TerminDto.class);
    }

    public void testRead() {
        String uri = baseuri + "/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "1");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(getMessageConverters());
        TerminDto result = restTemplate.getForObject(uri, TerminDto.class, params);
        Assert.assertEquals(result.ort, "Hier");
    }

    public void testReadAll() {
        String uri = baseuri + "/";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(getMessageConverters());
        List<TerminDto> res = restTemplate.getForObject(uri, List.class);
        Assert.assertEquals(res.size(), 2);
    }

    public void testDelete() {
        {
            String uri = baseuri + "/{id}";
            Map<String, String> params = new HashMap<String, String>();
            params.put("id", "1");

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete(uri, params);

            params.put("id", "2");
            restTemplate.delete(uri, params);
        }
        {
            String uri = baseuri + "/";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setMessageConverters(getMessageConverters());
            List<TerminDto> res = restTemplate.getForObject(uri, List.class);
            Assert.assertEquals(res.size(), 0);
        }
    }

    private static List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> converters
                = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2HttpMessageConverter());
        return converters;
    }
}
