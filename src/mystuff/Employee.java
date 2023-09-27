package mystuff;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

@ManagedBean
public class Employee {
	private int id;
	private String name = "anything surely but John !!! ;)";
	private double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
    public String submitMyStuff() {
    	String myMessage;
    	String myNextPage;
    	
    	// fake the database
    	if (name.equals("John")) {
    		myMessage="Oops, can't save!, duplicate record!";
    		myNextPage = "employeeform";
    	}
    	else {
    		myMessage = "Thanks!";
    		myNextPage="employeeadded";
    	}
    	
	    FacesContext.getCurrentInstance().
	        addMessage(null, new FacesMessage(myMessage));

    	return myNextPage;
    }
	public String hopToStartPage() {
		return ("employeeform");
	}
	public String bla() {
		return "bla";
	}
}
