package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class PaymentController {


	

	@GetMapping("/")
	public String viewHomePage(Model model) {
		return "payment";	
	}
	
	@GetMapping("/payment")
	public String payment(@RequestParam String cardHolderName , String cardNumber , String expDate, String cvv, String userId) {

		
		if(cardHolderName.length() > 0 && cardNumber.length() > 0 && expDate.length() > 0 && cvv.length() > 0) {
			return "payment completed";
		}else {
			return "something went wrong";
		}

	}
	
}