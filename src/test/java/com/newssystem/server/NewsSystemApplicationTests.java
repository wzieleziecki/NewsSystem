package com.newssystem.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newssystem.server.repository.NewsRepository;
import net.minidev.json.writer.CollectionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = NewsSystemApplication.class)
@WebAppConfiguration
public class NewsSystemApplicationTests {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private NewsRepository newsRepository;

	@Test
	public void testCreateNews() throws IOException{
		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("text", "Czesc");
		requestBody.put("data", "10.03.2017");
		requestBody.put("title", "Urodziny 30");
		requestBody.put("author", "Wojtek");
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> httpEntity = new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);

		Map<String, Object> apiResponse = restTemplate.postForObject("http://localhost:8080/api/news/saveNews", httpEntity, Map.class, Collections.emptyMap());

		assertNotNull(apiResponse);

	}

}
