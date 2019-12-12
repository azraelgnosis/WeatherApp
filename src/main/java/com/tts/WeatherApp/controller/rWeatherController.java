package com.tts.WeatherApp.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.WeatherApp.model.Request;
import com.tts.WeatherApp.model.Response;
import com.tts.WeatherApp.service.WeatherService;

@Controller
public class WeatherController {
	private WeatherService weatherService;
	
	@GetMapping
	public String getIndex(Model model) {
		model.addAttribute("request", new Request());  
	    return "index";
	}
	
	@PostMapping
	public String postIndex(Request request, Model model) {
		System.out.println(request);
		System.out.println(model);
		String x = request.getZipCode();
	    Response data = weatherService.getForecast(x);
	    model.addAttribute("data", data);
	    return "index";
	}
}
