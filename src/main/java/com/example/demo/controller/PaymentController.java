package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	

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