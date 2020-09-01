package com.sciops.demos.RESTful;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s";
	private static final String template2 = "Hello 2, %s";
	
	private final AtomicLong counter2 = new AtomicLong();
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/*")
	public Greeting greeting2(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter2.incrementAndGet(), String.format(template2, name));
	}
	
	@GetMapping("/home")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
