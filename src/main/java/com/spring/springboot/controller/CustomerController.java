package com.spring.springboot.controller;

import com.spring.springboot.entity.CustomerAccount;
import com.spring.springboot.repository.CustomerAccountRepository;
import com.spring.springboot.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after
								// Application path)
public class CustomerController {
	@Autowired
	private CustomerAccountRepository customerAccountRepository;

	@Autowired
	private CustomerDao customerDao;

	@RequestMapping(path = "/add")
	public @ResponseBody
	String addNewUser(@RequestParam String firstName, @RequestParam String lastName,
					  @RequestParam String email, @RequestParam String password) {
		CustomerAccount customerAccount = new CustomerAccount();
		customerAccount.setFirstName(firstName);
		customerAccount.setLastName(lastName);
		customerAccount.setEmail(email);
		customerAccount.setPassword(password);

		customerAccountRepository.save(customerAccount);
		return "Saved";
	}

	@RequestMapping(path = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody CustomerAccount getUser(@PathVariable Integer userId) {
		// This returns a JSON or XML with the users
		return customerDao.findOne(userId);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	// @GetMapping(path = "/all")
	public @ResponseBody Iterable<CustomerAccount> getAllUsers() {
		// This returns a JSON or XML with the users
		return customerDao.findAll();
	}
}