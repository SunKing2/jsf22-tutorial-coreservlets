package mystuff;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

@ManagedBean
public class BankingBean {
	private String customerId = "anything surely but John !!! ;)";
	private String password = "defaultpassword";
	private Customer customer;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public Customer findCustomer(String customerId) {
	    Map<String, Customer> customerMap = new HashMap<>();
	    customerMap.put("id001", new Customer("id001", "Harry Hacker",      -3456.78));
	    customerMap.put("id002", new Customer("id002", "Codie Coder",        1234.56));
	    customerMap.put("id003", new Customer("id003", "Polly Programmer", 987654.32));
	    customer = customerMap.get(customerId);

	    return customer;
	}
	
	public String showBalance() {
    	String myMessage;
    	String myNextPage;
    	
    	Customer customer = findCustomer(customerId);
    	
    	// fake the database
    	if (customer == null) {
    		myMessage="Oops, no customer!";
    		myNextPage = "bank-lookup";
    	}
    	else if (customer.getBalance() < 0) {
    		myMessage="negative!";
    		myNextPage = "negative-balance";
    	}
    	else if (customer.getBalance() < 10000) {
    		myMessage = "Thanks!";
    		myNextPage="normal-balance";
    	}
    	else {
    		myMessage="high!";
    		myNextPage = "bank-lookup";
    	}
    	
	    FacesContext.getCurrentInstance().
	        addMessage(null, new FacesMessage(myMessage));

    	return myNextPage;
    }
	public String hopToStartPage() {
		return ("bank-lookup");
	}
	public String bla() {
		return "bla";
	}
}
