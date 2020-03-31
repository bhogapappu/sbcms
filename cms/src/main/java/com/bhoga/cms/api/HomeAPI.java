package com.bhoga.cms.api;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeAPI {

	@GetMapping
	public String home() {
		return "<h1>Hurray! Application Works.</h1><h2>This homepage will be updated soon!!!</h2><br>"+new Date();
	}
}
