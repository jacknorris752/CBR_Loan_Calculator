import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;

public class MyGUI extends JFrame {
	private JTextField nameField;
	private JTextField ageField;
	private JTextField salaryField;
	private JTextField expensesField;
	private JTextField amountField;
	private JTextField timeField;
	private static JTextArea responseTextA;
	
	
	public MyGUI() {
		setPreferredSize(new Dimension(500, 280));
		setMinimumSize(new Dimension(500, 400));
		myGUI();
	}
	
	
	public void myGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CarLoanCaltulator");
		getContentPane().setBackground(Color.YELLOW);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel Inputpanel = new JPanel();
		panel.add(Inputpanel);
		Inputpanel.setBackground(new Color(153, 204, 255));
		Inputpanel.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel nameGroup = new JPanel();
		FlowLayout flowLayout = (FlowLayout) nameGroup.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		nameGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Inputpanel.add(nameGroup);
		
		JLabel nameLabel = new JLabel("Name");
		nameGroup.add(nameLabel);
		
		nameField = new JTextField();
		nameGroup.add(nameField);
		nameField.setColumns(10);
		
		JPanel ageGroup = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) ageGroup.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		ageGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Inputpanel.add(ageGroup);
		
		JLabel ageLabel = new JLabel("Age");
		ageGroup.add(ageLabel);
		
		ageField = new JTextField();
		ageField.setColumns(10);
		ageGroup.add(ageField);
		
		JPanel salaryGroup = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) salaryGroup.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		salaryGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Inputpanel.add(salaryGroup);
		
		JLabel salaryLabel = new JLabel("Yearly Salary");
		salaryGroup.add(salaryLabel);
		
		salaryField = new JTextField();
		salaryField.setColumns(10);
		salaryGroup.add(salaryField);
		
		JPanel timeGroup = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) timeGroup.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		timeGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Inputpanel.add(timeGroup);
		
		JLabel timeLabel = new JLabel("Months at Current Job");
		timeGroup.add(timeLabel);
		
		timeField = new JTextField();
		timeField.setToolTipText("How many months have you worked at your current job? 0 if unemployed");
		timeField.setColumns(10);
		timeGroup.add(timeField);
		
		JPanel expensesGroup = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) expensesGroup.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		expensesGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Inputpanel.add(expensesGroup);
		
		JLabel expensesLabel = new JLabel("Yearly Expenses");
		expensesGroup.add(expensesLabel);
		
		expensesField = new JTextField();
		expensesField.setToolTipText("Total yearly expenses");
		expensesField.setColumns(10);
		expensesGroup.add(expensesField);
		
		JPanel amountGroup = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) amountGroup.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		amountGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Inputpanel.add(amountGroup);
		
		JLabel amountLabel = new JLabel("Requested Amount");
		amountGroup.add(amountLabel);
		
		amountField = new JTextField();
		amountField.setColumns(10);
		amountGroup.add(amountField);
		
		JPanel Responsepanel = new JPanel();
		panel.add(Responsepanel);
		Responsepanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Responsepanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		responseTextA = new JTextArea();
		responseTextA.setEditable(false);
		Responsepanel.add(responseTextA);
		
		JPanel Buttonpanel = new JPanel();
		Buttonpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(Buttonpanel);
		
		//creating check button
		JButton checkButton = new JButton("Check if Elegible");
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check the person
				Person current = new Person();
				current.name = nameField.getText();
				current.age = Integer.parseInt(ageField.getText());
				current.yearly_salary = Double.parseDouble(salaryField.getText());
				current.months_at_job = Integer.parseInt(timeField.getText());
				current.yearly_expenses = Double.parseDouble(expensesField.getText());
				current.amount_to_borrow = Double.parseDouble(amountField.getText());
				CaseChecker cs = new CaseChecker();
				cs.check(current);
			}
		});
		Buttonpanel.setLayout(new GridLayout(5, 1, 0, 0));
		Buttonpanel.add(checkButton);
		
		//creating save button
		JButton saveButton = new JButton("Save Case");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO CHECK ALL FIELDS ARE VALID
				//if no then throw errors to field at bottom
				Person current = new Person();
				current.name = nameField.getText();
				current.age = Integer.parseInt(ageField.getText());
				current.yearly_salary = Double.parseDouble(salaryField.getText());
				current.months_at_job = Integer.parseInt(timeField.getText());
				current.yearly_expenses = Double.parseDouble(expensesField.getText());
				ReadWrite rw = new ReadWrite();
				rw.save(current);
			}
		});
		Buttonpanel.add(saveButton);
		
		JButton loadButton = new JButton("Load Case By Name");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Loads specific case
				ReadWrite rw = new ReadWrite();
				Person temp = new Person();
				temp = rw.loadSpecific(nameField.getText());
				
				//set all fields to loaded persons details AND clear others
				ageField.setText(String.valueOf(temp.age));
				salaryField.setText(String.valueOf(temp.yearly_salary));
				timeField.setText(String.valueOf(temp.months_at_job));
				expensesField.setText(String.valueOf(temp.yearly_expenses));
				amountField.setText("");	//makes it empty as this is irrelevant here
			}
		});
		loadButton.setToolTipText("Will load case based on name field");
		Buttonpanel.add(loadButton);
		
		JButton Clear = new JButton("Clear");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clears all
				nameField.setText("");
				ageField.setText("");
				salaryField.setText("");
				timeField.setText("");
				expensesField.setText("");
				amountField.setText("");
				responseTextA.setText("");
			}
		});
		Clear.setToolTipText("Clears The Screen");
		Buttonpanel.add(Clear);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	//updates the response text field
	public static void responseText(String text) {
		responseTextA.setText(text);
	}

}
