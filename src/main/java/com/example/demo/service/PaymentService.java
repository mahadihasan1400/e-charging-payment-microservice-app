package com.example.demo.service;



import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Payment;

public interface PaymentService {
	List<Payment> getAllPayments();
	void savePayment(Payment payment);
	Payment getPaymentById(long id);
	void deletePaymentById(long id);
	Page<Payment> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}