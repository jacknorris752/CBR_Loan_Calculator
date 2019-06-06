import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable{
	public String name;
	public int age;
	public double yearly_salary;
	public int months_at_job;
	public double yearly_expenses;
	public double amount_to_borrow;
	
	public ObjectOutputStream os;
	
	//constructor here
	public Person() {
		
	}
	
}
