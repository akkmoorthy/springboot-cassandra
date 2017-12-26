package com.spring.springboot.controller;

import com.spring.springboot.entity.LeadPriceDetails;
import com.spring.springboot.repository.CassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // This means that this class is a Controller
public class CassandraController {
	@Autowired
	private CassandraRepository cassandraRepository;

	@RequestMapping(path = "/property/{userId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	LeadPriceDetails getUser(@PathVariable Integer userId) {
		// This returns a JSON or XML with the users
		return cassandraRepository.findById(userId, LeadPriceDetails.class);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	// @GetMapping(path = "/all")
	public @ResponseBody Iterable<LeadPriceDetails> getAllUsers() {
		// This returns a JSON or XML with the users
		List<Object> userList = new ArrayList<>();
		userList.add(new String("1"));
		userList.add(new String("2"));

		return cassandraRepository.findAll(userList, LeadPriceDetails.class);
	}
}