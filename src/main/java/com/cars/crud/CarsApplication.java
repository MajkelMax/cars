package com.cars.crud;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class CarsApplication {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(CarsApplication.class, args);

		URL url = new URL("https://api.api-ninjas.com/v1/cars?model=camry");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("accept", "application/json");
		InputStream responseStream = connection.getInputStream();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(responseStream);
		System.out.println(root.path("fact").asText());
	}

}
