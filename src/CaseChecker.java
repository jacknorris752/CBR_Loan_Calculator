import java.text.DecimalFormat;
import java.util.ArrayList;

public class CaseChecker {
	
	public double interest = 1.04;		//4% interest
	
	public void check(Person person) {
		//System.out.println("This person is called " + person.name);
		
		//loan status
		boolean qualify = false;
		
		//create list for previous cases
		ArrayList<Person> people = new ArrayList<Person>();
		
		//load in array of cases
		ReadWrite rw = new ReadWrite();
		people = rw.load();
		//people.forEach(System.out::println);
		
		//do their case traits qualify
		for(int i=0; i<people.size();i++) {
			Person currentCase = people.get(i);
			if(person.age >= currentCase.age && person.yearly_salary >= currentCase.yearly_salary &&
					person.months_at_job >= currentCase.months_at_job) {
				qualify = true;
				//System.out.println("I qualify");
				break;
			}
			
		}
		
		//System.out.println("do i financially qualify?");
		
		//check their borrowing traits qualify and only if they already qualify
		double bank = person.yearly_salary - person.yearly_expenses;
		//check the person qualifies and that they're leftover money is more than 0
		if(qualify && bank > 0) {
			//sets up values based on monthly payment schedule of 12,24 or 36 months and figures the payments out with a 4% interest
			double m12,m24,m36;
			m12 = (person.amount_to_borrow/12) * interest;
			m24 = (person.amount_to_borrow/24) * interest;
			m36 = (person.amount_to_borrow/36) * interest;
			
			//multiplication is used to represent the money they would have in that time.
			if(m12 <= bank/12 || m24 <= (bank*2)/12 || m36 <= (bank*3)/12) {
				String message = "";
				DecimalFormat df = new DecimalFormat("#.##");
				if(m12 > 0 && m12 <= bank/12) {
					message += "\nOn a 12 month plan your monthly repayments would be: " + df.format(m12);
				}
				if(m24 > 0 && m24 <= (bank*2)/12) {
					message += "\nOn a 24 month plan your monthly repayments would be: " + df.format(m24);
				}
				if(m36 > 0 && m36 <= (bank*3)/12) {
					message += "\nOn a 36 month plan your monthly repayments would be: " + df.format(m36);
				}
				MyGUI.responseText(message);
				
				//System.out.println("YES");
				//System.out.println(message);
			}else {
				//send fail to gui
				MyGUI.responseText("Unfortunately you are unable to afford the monthly payments, please apply for a smaller amount.");
				qualify = false;
				//System.out.println("NO");
			}
			
			
		}else {
			//TODO
			//FIGURE OUT CAUSE HERE?
			MyGUI.responseText("Unfortunately you do not qualify for a loan at this time as you are unable to afford the loan or do not "
					+ "meet our case requirements");
		}

	}
	
	
}
