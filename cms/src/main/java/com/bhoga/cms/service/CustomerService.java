package com.bhoga.cms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bhoga.cms.dao.CustomerDAO;
import com.bhoga.cms.exception.CustomerNotFoundException;
import com.bhoga.cms.model.Customer;

@Component
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
//	private List<Customer> customerList = new CopyOnWriteArrayList<>();
//	private int latestCustomerId = 1;

	public Customer addCustomer(Customer customer) {
//		customer.setCustId(latestCustomerId);
//		customerList.add(customer);
//		latestCustomerId++;
//		return customer;
		return customerDAO.save(customer);
	}

	public List<Customer> getCustomers() {
//		return customerList;
		return customerDAO.findAll();
	}

	public Customer getCustomer(int customerId) {
//		return customerList
//		  .stream()
//		  .filter(c -> c.getCustId() == customerId)
//		  .findFirst()
//		  .get();
		Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
		if (!optionalCustomer.isPresent()) {
			throw new CustomerNotFoundException("Customer record is not available...");
		}
		return optionalCustomer.get();
	}

	public Customer updateCustomer(int customerId, Customer customer) {

//		customerList
//		  .stream()
//		  .forEach(c-> {
//			  if (c.getCustId() == customerId) {
//				  c.setFirstName(customer.getFirstName());
//				  c.setLastName(customer.getLastName());
//				  c.setEmail(customer.getEmail());
//				  c.setPhone(customer.getPhone());
//				  c.setStreetAddress(customer.getStreetAddress());
//				  c.setCity(customer.getCity());
//				  c.setState(customer.getState());
//				  c.setZip(customer.getZip());
//			  }
//		  });
//		
//		return customerList
//				.stream()
//				.filter(c -> c.getCustId() == customerId)
//				.findFirst()
//				.get();
		customer.setCustId(customerId);
		return customerDAO.save(customer);
	}

	public void deleteCustomer(int customerId) {
//		customerList
//		.stream()
//		.forEach(c -> {
//			if (c.getCustId() == customerId) {
//				customerList.remove(c);
//			}
//		});
		customerDAO.deleteById(customerId);
	}
}
