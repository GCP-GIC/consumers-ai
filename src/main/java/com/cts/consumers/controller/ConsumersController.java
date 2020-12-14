package com.cts.consumers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.consumers.entity.ConsumerQuery;
import com.cts.consumers.model.ConsumerQueryBO;
import com.cts.consumers.repo.ConsumerQueryRepository;

@RequestMapping("/v1")
@RestController
public class ConsumersController {

	
	@Autowired
	ConsumerQueryRepository  consumerQueryRepository;
	
	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String sayHello() {
		return "Hello world!";
	};
	
	@PostMapping(path = "/submit", consumes = "application/json")
	public String storeConsumerQuery(
			@RequestBody ConsumerQueryBO consumerQueryBO) {
		ConsumerQuery consumerQuery = new ConsumerQuery();
		consumerQuery.setBrands(consumerQueryBO.getBrands());
		consumerQuery.setColors(consumerQueryBO.getColors());
		consumerQuery.setConsumerId(consumerQueryBO.getConsumerId());
		consumerQuery.setSegments(consumerQueryBO.getSegments());
		consumerQuery.setMaxBudget(consumerQueryBO.getMaxBudget());
		consumerQueryRepository.save(consumerQuery);
		return "Consumer Query is stored!";
	}
	
	@GetMapping(value = "/retreive", produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsumerQueryBO getConsumerQuery(@RequestParam String consumerId) throws Exception {
		ConsumerQuery consumerQuery = consumerQueryRepository.findByConsumerID(consumerId);
		if(consumerQuery==null)
			throw new Exception("Customer id not found");
		ConsumerQueryBO consumerQueryBO = new ConsumerQueryBO();
		consumerQueryBO.setBrands(consumerQuery.getBrands());
		consumerQueryBO.setColors(consumerQuery.getColors());
		consumerQueryBO.setConsumerId(consumerQuery.getConsumerId());
		consumerQueryBO.setSegments(consumerQuery.getSegments());
		consumerQueryBO.setMaxBudget(consumerQuery.getMaxBudget());
		return consumerQueryBO;
	};
}
