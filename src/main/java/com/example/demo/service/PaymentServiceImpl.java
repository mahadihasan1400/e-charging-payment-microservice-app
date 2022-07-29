package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	@Override
	public void savePayment(Payment payment) {
		this.paymentRepository.save(payment);
	}

	@Override
	public Payment getPaymentById(long id) {
		Optional<Payment> optional = paymentRepository.findById(id);
		Payment payment = null;
		if (optional.isPresent()) {
			payment = optional.get();
		} else {
			throw new RuntimeException(" payment not found for id :: " + id);
		}
		return payment;
	}

	@Override
	public void deletePaymentById(long id) {
		this.paymentRepository.deleteById(id);
	}

	@Override
	public Page<Payment> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.paymentRepository.findAll(pageable);
	}
}
