package guru.springframework.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgdi.services.ConstructorGreetingServiceImpl;

public class PropertyInjectionControllerTest {

	PropertyInjectedController controller;
	
	@BeforeEach
	void setUp() {
		controller = new PropertyInjectedController();
		controller.greetingService = new ConstructorGreetingServiceImpl();
	}
	
	@Test
	public void getGreeting() {
		System.out.println(controller.getGreeting());
	}
}
