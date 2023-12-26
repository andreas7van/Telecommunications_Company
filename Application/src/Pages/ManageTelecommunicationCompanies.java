package Pages;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Models.Plan;
import Models.TelecommunicationCompany;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageTelecommunicationCompanies extends JFrame {

	private DefaultTableModel _tableModel;
	private ArrayList<TelecommunicationCompany> _companiesList = new ArrayList<TelecommunicationCompany>();	
	private ArrayList<Plan> _plansList = new ArrayList<Plan>();
	private int _companiesAutoCode = 1;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	
	//Overloaded constructor
	public ManageTelecommunicationCompanies(ArrayList<TelecommunicationCompany> Companies, ArrayList<Plan> Plans) {
		
		_companiesList = Companies;
		_plansList = Plans;
		
		DefaultInitialization(this);		
		CreateTableColumns();
		LoadTelecommunicationCompanies(_companiesList);
	}
	
	private void DefaultInitialization(ManageTelecommunicationCompanies form) {
		setTitle("Διαχείριση Εταιρειών Τηλεπικοινωνιών");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1142, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 44, 505, 569);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Εταιρείες Τηλεπικοινωνιών");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(161, 11, 228, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Επωνυμία:");
		lblName.setFont(new Font("Arial", Font.BOLD, 12));
		lblName.setBackground(Color.DARK_GRAY);
		lblName.setBounds(550, 91, 78, 33);
		contentPane.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(624, 94, 352, 27);
		contentPane.add(textFieldName);
		
		JLabel lblPhone = new JLabel("Τηλέφωνο:");
		lblPhone.setFont(new Font("Arial", Font.BOLD, 12));
		lblPhone.setBackground(Color.DARK_GRAY);
		lblPhone.setBounds(550, 135, 78, 33);
		contentPane.add(lblPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(624, 138, 352, 27);
		contentPane.add(textFieldPhone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmail.setBackground(Color.DARK_GRAY);
		lblEmail.setBounds(550, 179, 78, 33);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(624, 182, 352, 27);
		contentPane.add(textFieldEmail);
		
		JButton btnInsert = new JButton("Καταχώρηση");
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddTelecommunicationCompany(textFieldName,textFieldPhone,textFieldEmail);
			}
		});
		btnInsert.setBounds(550, 247, 138, 33);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Ενημέρωση");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateTelecommunicationCompany(textFieldPhone,textFieldEmail);
			}
		});
		btnUpdate.setBounds(698, 247, 127, 33);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Διαγραφή");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoveTelecommunicationCompany();
			}
		});
		btnDelete.setBounds(835, 247, 141, 33);
		contentPane.add(btnDelete);
		
		JButton btnReturn = new JButton("Επιστροφή");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				form.dispose();
			}
		});
		btnReturn.setBackground(Color.LIGHT_GRAY);
		btnReturn.setBounds(24, 624, 115, 27);
		contentPane.add(btnReturn);
		
		JButton btnInsert_1 = new JButton("Αναζήτηση");
		btnInsert_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchTelecommunicationCompany(textFieldName);
			}
		});
		btnInsert_1.setBounds(986, 91, 115, 33);
		contentPane.add(btnInsert_1);
	}
		
	private void CreateTableColumns() {
		_tableModel = (DefaultTableModel) table.getModel();
		_tableModel.addColumn("A/A");
		_tableModel.addColumn("Κωδικός");
		_tableModel.addColumn("Επωνυμία");
		_tableModel.addColumn("Τηλέφωνο");
		_tableModel.addColumn("E-mail");
	}
	
	private void ClearTable() {
		
		for (int i = _tableModel.getRowCount() - 1; i >= 0; i--) {
			_tableModel.removeRow(i);
		}
	}
	
	private void LoadTelecommunicationCompanies(ArrayList<TelecommunicationCompany> companies) {
		
		ClearTable();
		
		for(int counter = 0; counter < companies.size(); counter++) {
			
			TelecommunicationCompany company = companies.get(counter);
			
			int index = counter;
			index++;
			String[] rowData = { String.valueOf(index), String.valueOf(company.getId()), company.getName(), company.getTelephone(), company.getEmail()};
			_tableModel.addRow(rowData);
		}
	}
		
	private void AddTelecommunicationCompany(JTextField nameField, JTextField phoneField, JTextField emailField) {
		
		//Validations
		if(nameField.getText().isEmpty() || phoneField.getText().isEmpty() || emailField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Πρέπει να συμπληρωθούν όλα τα πεδία!");
			return;
		}
		
		//Fields are not empty, create new object
		TelecommunicationCompany comp = new TelecommunicationCompany(_companiesAutoCode++, nameField.getText(), phoneField.getText(), emailField.getText());	
		
		//Add the above object to list
		_companiesList.add(comp);
		
		//Refresh the grid
		LoadTelecommunicationCompanies(_companiesList);
		
		//Reset the fields
		nameField.setText("");
		phoneField.setText("");
		emailField.setText("");
			
	}
	
	private void RemoveTelecommunicationCompany() {
		
		//Validations
		if(table.getRowCount() == 0 || table.getSelectedRow() == -1)
			return;
		
		Object SelectedId = table.getValueAt(table.getSelectedRow(), 1);
		
		int IdtoRemove = Integer.parseInt((String) SelectedId);
		
		for(int counter = 0; counter < _companiesList.size(); counter++) {
			
			TelecommunicationCompany company = _companiesList.get(counter);
			if(company.getId() == IdtoRemove) {
				//Check if company is registered to plan.
				if(!IsRegisteredtoPlan(company.getId())) {
					_companiesList.remove(counter);
				}
				else {
					JOptionPane.showMessageDialog(null, "Υπάρχει καταχωρημένο πρόγραμμα στο σύστημα που σχετίζεται με την παρούσα εταιρεία!");
				}
				break;
			}

		}
			
		LoadTelecommunicationCompanies(_companiesList);
			
	}
	
	private void UpdateTelecommunicationCompany(JTextField phoneField, JTextField emailField) {
			
		//Validations
		if(table.getRowCount() == 0 || table.getSelectedRow() == -1)
			return;
		
		//Get selected 
		Object SelectedId = table.getValueAt(table.getSelectedRow(), 1);
				
		//Parse the selected value into integer
		int IdtoUpdate = Integer.parseInt((String) SelectedId);
		
		//Find the company with the same id and update the fields.
		for(int counter = 0; counter < _companiesList.size(); counter++) {
			
			TelecommunicationCompany company = _companiesList.get(counter);
			if(company.getId() == IdtoUpdate) {
				
				if(!phoneField.getText().isEmpty())	
					company.setTelephone(phoneField.getText());	
				
				if(!emailField.getText().isEmpty())
					company.setEmail(emailField.getText());
				break;
			}
		}
		
		//Refresh
		LoadTelecommunicationCompanies(_companiesList);
		
		//Reset
		phoneField.setText("");
		emailField.setText("");
		
	}
	
	private void SearchTelecommunicationCompany(JTextField nameField) {
		
		String companyName = nameField.getText();
		if(companyName != null && companyName.isEmpty()) {
			//No company name provided - Load all companies
			LoadTelecommunicationCompanies(_companiesList);
		}
		else
		{
			ArrayList<TelecommunicationCompany> dummyList = new ArrayList<TelecommunicationCompany>();	
			
			for(int counter = 0; counter < _companiesList.size(); counter++) {
				
				TelecommunicationCompany company = _companiesList.get(counter);
				if(company.getName().equals(companyName)) {
					dummyList.add(company);
				}
			}
	
			LoadTelecommunicationCompanies(dummyList);
		}
	
	}
	
	private boolean IsRegisteredtoPlan(int CompanyId) {
		boolean result = false;
		
		for(int counter = 0; counter < _plansList.size(); counter++) {
			
			Plan plan = _plansList.get(counter);
			if(plan.getTelecommunicationCompanyId() == CompanyId) {
				result = true;
			}
		}
	
		return result;		
	}
	
}