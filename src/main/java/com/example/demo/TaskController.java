package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/rest-test")
	public ResponseEntity<String> restTest(@PathParam(value = "restTest") String restTest) throws IOException {
		
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "application/json;charset=UTF-8");

		URL url;
		String output = "";
		String tagRemove = "";
		try {
			String line = null;  
			url = new URL("http://ec2-13-125-175-179.ap-northeast-2.compute.amazonaws.com:8080");
			InputStream is = url.openStream();  
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));  
			while ((line = reader.readLine()) != null) {
				output += line;
			}
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if("not".equals(restTest)) {
			tagRemove = output.replaceAll("\\<.*?\\>", "");
			System.out.println(tagRemove);
			output = tagRemove; 
		}
		return new ResponseEntity<String>(output, resHeaders, HttpStatus.OK) ;
	}
}
