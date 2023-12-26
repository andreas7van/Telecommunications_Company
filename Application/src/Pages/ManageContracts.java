package Pages;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Models.Client;
import Models.Contract;
import Models.MobilePlan;
import Models.Plan;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ManageContracts extends JFrame {
	
	private DefaultTableModel _tableModel;
	private ArrayList<Client> _clientsList = new ArrayList<Client>();	
	private ArrayList<Plan> _plansList = new ArrayList<Plan>();
	ArrayList<Contract> _contractsList = new ArrayList<Contract>();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldPhone;
	private JTextField textFieldClientVatNumber;
	private JTextField textFieldPhoneSearch;
	private JTextField textFieldEnableDate;
	
	//Overloaded constructor
	public ManageContracts(ArrayList<Plan> Plans, ArrayList<Client> Clients, ArrayList<Contract> Contracts) {
		_plansList = Plans;
		_clientsList = Clients;
		_contractsList = Contracts;
		
		DefaultInitialization(this);
		CreateTableColumns();
		LoadContracts(_contractsList);
	}
	
	private void DefaultInitialization(ManageContracts form) {
		setTitle("Διαχείριση Συμβολαίων");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1653, 974);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 43, 1341, 349);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblCode_1_1_2_1 = new JLabel("Τηλέφωνο:");
		lblCode_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1_2_1.setBackground(Color.DARK_GRAY);
		lblCode_1_1_2_1.setBounds(29, 409, 169, 33);
		contentPane.add(lblCode_1_1_2_1);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(141, 412, 230, 27);
		contentPane.add(textFieldPhone);
		
		JLabel lblNewLabel = new JLabel("Συμβόλαια");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(643, 7, 228, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblCode_1 = new JLabel("Α.Φ.Μ:");
		lblCode_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1.setBackground(Color.DARK_GRAY);
		lblCode_1.setBounds(29, 444, 82, 33);
		contentPane.add(lblCode_1);
		
		textFieldClientVatNumber = new JTextField();
		textFieldClientVatNumber.setColumns(10);
		textFieldClientVatNumber.setBounds(141, 453, 230, 27);
		contentPane.add(textFieldClientVatNumber);
		
		JLabel lblCode_1_1 = new JLabel("Κωδικός Προγράμματος:");
		lblCode_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1.setBackground(Color.DARK_GRAY);
		lblCode_1_1.setBounds(29, 488, 169, 33);
		contentPane.add(lblCode_1_1);
		
		JSpinner spinnerPlanId = new JSpinner();
		spinnerPlanId.setBounds(182, 491, 82, 22);
		contentPane.add(spinnerPlanId);
		
		JLabel lblCode_1_1_1 = new JLabel("Ημ/νια Ενεργοποίησης:");
		lblCode_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1_1.setBackground(Color.DARK_GRAY);
		lblCode_1_1_1.setBounds(29, 524, 169, 33);
		contentPane.add(lblCode_1_1_1);
		
		JLabel lblCode_1_1_1_1 = new JLabel("Διάρκεια:");
		lblCode_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1_1_1.setBackground(Color.DARK_GRAY);
		lblCode_1_1_1_1.setBounds(29, 563, 169, 33);
		contentPane.add(lblCode_1_1_1_1);
		
		JComboBox<String> comboBoxDuration = new JComboBox<String>();
		comboBoxDuration.addItem("12 Μήνες");
		comboBoxDuration.addItem("24 Μήνες");
		comboBoxDuration.setBounds(182, 568, 147, 22);
		contentPane.add(comboBoxDuration);
		
		JLabel lblCode_1_1_1_1_1 = new JLabel("Τύπος Λογαριασμού:");
		lblCode_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1_1_1_1.setBackground(Color.DARK_GRAY);
		lblCode_1_1_1_1_1.setBounds(29, 597, 169, 33);
		contentPane.add(lblCode_1_1_1_1_1);
		
		JComboBox<String> comboBoxType = new JComboBox<String>();
		comboBoxType.addItem("Έντυπος");
		comboBoxType.addItem("Ηλεκτρονικός");
		comboBoxType.setBounds(182, 601, 147, 22);
		contentPane.add(comboBoxType);
		
		JLabel lblCode_1_1_1_1_1_1 = new JLabel("Τρόπος Πληρωμής:");
		lblCode_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1_1_1_1_1.setBackground(Color.DARK_GRAY);
		lblCode_1_1_1_1_1_1.setBounds(29, 634, 169, 33);
		contentPane.add(lblCode_1_1_1_1_1_1);
		
		JComboBox<String> comboBoxPaymentMethod = new JComboBox<String>();
		comboBoxPaymentMethod.addItem("Πιστωτική Κάρτα");
		comboBoxPaymentMethod.addItem("Μετρητά");
		comboBoxPaymentMethod.setBounds(182, 641, 147, 22);
		contentPane.add(comboBoxPaymentMethod);
		
		JLabel lblCode_1_1_1_2 = new JLabel("(Σε μορφή ddMMyyyy)");
		lblCode_1_1_1_2.setForeground(SystemColor.controlDkShadow);
		lblCode_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1_1_2.setBackground(Color.DARK_GRAY);
		lblCode_1_1_1_2.setBounds(422, 529, 169, 33);
		contentPane.add(lblCode_1_1_1_2);
		
		JButton btnInsert = new JButton("Καταχώρηση");
		btnInsert.setBackground(Color.LIGHT_GRAY);
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddContract(textFieldPhone, textFieldClientVatNumber, spinnerPlanId, 
						textFieldEnableDate, comboBoxDuration,  comboBoxType,
						comboBoxPaymentMethod);
			}
		});
		btnInsert.setBounds(182, 678, 118, 28);
		contentPane.add(btnInsert);
		
		JButton btnRefresh = new JButton("Ανανέωση");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadContracts(_contractsList);
			}
		});
		btnRefresh.setBackground(Color.GREEN);
		btnRefresh.setBounds(1221, 11, 115, 27);
		contentPane.add(btnRefresh);
		
		JLabel lblNewLabel_1 = new JLabel("Αναζήτηση Συμβολαίων");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(794, 443, 228, 33);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(643, 474, 547, 156);
		contentPane.add(panel);
		
		JLabel lblCode_1_1_2_1_1 = new JLabel("Τηλέφωνο:");
		lblCode_1_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1_2_1_1.setBackground(Color.DARK_GRAY);
		lblCode_1_1_2_1_1.setBounds(10, 28, 124, 33);
		panel.add(lblCode_1_1_2_1_1);
		
		textFieldPhoneSearch = new JTextField();
		textFieldPhoneSearch.setColumns(10);
		textFieldPhoneSearch.setBounds(154, 31, 230, 27);
		panel.add(textFieldPhoneSearch);
		
		JLabel lblCode_1_1_2_1_1_1 = new JLabel("Τύπος Προγράμματος:");
		lblCode_1_1_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1_2_1_1_1.setBackground(Color.DARK_GRAY);
		lblCode_1_1_2_1_1_1.setBounds(10, 84, 148, 33);
		panel.add(lblCode_1_1_2_1_1_1);
		
		JComboBox<String> comboBoxPlanType = new JComboBox<String>();
		comboBoxPlanType.addItem("Mobile");
		comboBoxPlanType.addItem("Landline");
		comboBoxPlanType.setBounds(154, 87, 147, 27);
		panel.add(comboBoxPlanType);
		
		JButton btnSearchByPlanType = new JButton("Αναζήτηση");
		btnSearchByPlanType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchContractsByPlanType(comboBoxPlanType);
			}
		});
		btnSearchByPlanType.setBounds(422, 87, 105, 27);
		panel.add(btnSearchByPlanType);
		
		JButton btnSearchByPhone = new JButton("Αναζήτηση");
		btnSearchByPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchContractsByPhone(textFieldPhoneSearch);
			}
		});
		btnSearchByPhone.setBounds(422, 33, 105, 27);
		panel.add(btnSearchByPhone);
		
		JButton btnUpdate = new JButton("Ακύρωση Συμβολαίου");
		btnUpdate.setBackground(Color.RED);
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DisableContract();
			}
		});
		btnUpdate.setBounds(1066, 657, 175, 33);
		contentPane.add(btnUpdate);
		
		JButton btnReturn = new JButton("Επιστροφή");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				form.dispose();
			}
		});
		btnReturn.setBackground(Color.LIGHT_GRAY);
		btnReturn.setBounds(29, 678, 115, 27);
		contentPane.add(btnReturn);
		
		textFieldEnableDate = new JTextField();
		textFieldEnableDate.setColumns(10);
		textFieldEnableDate.setBounds(182, 532, 230, 27);
		contentPane.add(textFieldEnableDate);
	}

	private String GetPlanTypeById(int PlanId) {
		
		for(int counter = 0; counter < _plansList.size(); counter++) {	
			
			Plan plan = _plansList.get(counter);
			if(plan.getId() == PlanId) {
				if(plan.getClass() == MobilePlan.class) {
					return "Mobile";
				}
				else {
					return "Landline";
				}
			}
		}
		return null;
	}
	
	private Plan GetPlanById(int PlanId) {
		
		for(int counter = 0; counter < _plansList.size(); counter++) {	
			
			Plan plan = _plansList.get(counter);
			if(plan.getId() == PlanId) {
				return plan;
			}
		}
		return null;
	}
	
	private Client GetClientByVatNumber(String VatNumber) {
		
		for(int counter = 0; counter < _clientsList.size(); counter++) {	
			
			Client client = _clientsList.get(counter);
			if(client.getVatNumber().equals(VatNumber)) {
				return client;
			}
		}
		
		return null;
	}
	
	private double CalculateCost(Plan plan, double discountPerc) {
		
		double initialCost = plan.getCost();
		return initialCost - initialCost * discountPerc/100;
	}
	
	private double CalculateDiscountPercentage(Plan plan, Client client, String paymentMethod, String contractType) {
		
		double discount = 0;
		if(client.getClientType().equals("Επαγγελματίας")) {
			discount = 10;
		}
		else if (client.getClientType().equals("Φοιτητής")) {
			discount = 15;
		}
		
		if(plan.getFreeCallTime() > 1000) {
			if(plan.getClass() == MobilePlan.class) {
				discount += 11;
			}
			else {
				discount += 8;
			}
		}
		
		if(paymentMethod.equals("Πιστωτική Κάρτα")) {
			discount += 5;
		}

		if(contractType.equals("Ηλεκτρονικός")) {
			discount += 2;
		}
			
		
		return discount;
		

	}
	
	private void CreateTableColumns() {
		_tableModel = (DefaultTableModel) table.getModel();
		_tableModel.addColumn("A/A");
		_tableModel.addColumn("Κωδικός");
		_tableModel.addColumn("Τηλέφωνο");
		_tableModel.addColumn("Α.Φ.Μ");
		_tableModel.addColumn("Πρόγραμμα");
		_tableModel.addColumn("Ημ/νια Ενεργοποίησης");
		_tableModel.addColumn("Διάρκεια");
		_tableModel.addColumn("Έκπτωση(%)");
		_tableModel.addColumn("Κόστος");
		_tableModel.addColumn("Τύπος");
		_tableModel.addColumn("Τρόπος Πληρωμής");
		_tableModel.addColumn("Κόστος Ακύρωσης");
		_tableModel.addColumn("Ενεργό");
		
	}
	
	private void ClearTable() {
		
		for (int i = _tableModel.getRowCount() - 1; i >= 0; i--) {
			_tableModel.removeRow(i);
		}
	}
	
	private void LoadContracts(ArrayList<Contract> contracts) {
		
		ClearTable();
		
		for(int counter = 0; counter < contracts.size(); counter++) {
			
			Contract contract = contracts.get(counter);
			
			int index = counter;
			index++;
			String[] rowData = { String.valueOf(index), contract.getCode(), contract.getPhone(), contract.getClientVatNumber(), String.valueOf(contract.getPlanId()),
					String.valueOf(contract.getEnableDate()), contract.getDuration(), String.valueOf(contract.getDiscount()), String.valueOf(contract.getCost()),
					contract.getType(), contract.getPaymentMethod(), String.valueOf(contract.getCancellationFee()), contract.getIsEnabled() == true ? "Ενεργό" : "Ανενεργό"};
			_tableModel.addRow(rowData);
		}
	}
	
	private void AddContract(JTextField textFieldPhone, JTextField textFieldClientVatNumber, JSpinner spinnerPlanId, 
			JTextField textFieldEnableDate, JComboBox<String> comboBoxDuration, JComboBox<String> comboBoxType,
			JComboBox<String> comboBoxPaymentMethod) {
		
		//Validations
		if(textFieldPhone.getText().isEmpty() || textFieldClientVatNumber.getText().isEmpty() || textFieldEnableDate.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Πρέπει να συμπληρωθούν όλα τα πεδία!");
			return;
		}
		
		//Check if Client exists.
		Client client = GetClientByVatNumber(textFieldClientVatNumber.getText());
		if(client == null) {
			JOptionPane.showMessageDialog(null, "Δεν βρέθηκε πελάτης καταχωρημένος στο σύστημα!");
			return;
		}
		
		//Check if Client has enabled contract
		if(ClientΗasEnabledContract(client)) {
			JOptionPane.showMessageDialog(null, "Υπάρχει καταχωρημένο συμβόλαιο για τον συγκεκριμένο πελάτη!");
			return;
		}
		
		//Check if Plan exists.
		Plan plan = GetPlanById((Integer)spinnerPlanId.getValue());
		if(plan == null) {
			JOptionPane.showMessageDialog(null, "Δεν βρέθηκε πρόγραμμα καταχωρημένο στο σύστημα!");
			return;
		}
		
		
		//Validations - Mobile: 6xxxxxxxxxx | Landline: 2xxxxxxxxxx (10 digits)
		if(textFieldPhone.getText().length() != 10) {
			JOptionPane.showMessageDialog(null, "Το τηλέφωνο θα πρέπει να έχει 10 ψηφία!");
			return;
		}
		else {
			if(GetPlanTypeById(plan.getId()).equals("Mobile")) {
				//Mobile: Telephone should start with 6xx....
				if(textFieldPhone.getText().charAt(0) != '6') {
					JOptionPane.showMessageDialog(null, "Το τηλέφωνο θα πρέπει να αρχίζει με 6!");
					return;
				}
			}
			else {
				//Landline: Telephone should start with 2xx....
				if(textFieldPhone.getText().charAt(0) != '2') {
					JOptionPane.showMessageDialog(null, "Το τηλέφωνο θα πρέπει να αρχίζει με 2!");
					return;
				}
			}
		}
		
		String contractType = comboBoxType.getSelectedItem().toString();
		String paymentMethod = comboBoxPaymentMethod.getSelectedItem().toString();
		//Calculate discount and cost
		double discount = CalculateDiscountPercentage(plan,client,paymentMethod,contractType);
		double cost = CalculateCost(plan,discount);
		String contractCode = textFieldEnableDate.getText() + "-" + textFieldClientVatNumber.getText() + "-" + GetPlanTypeById(plan.getId());
		
		//Validations - Date parsing
		LocalDate date = null;
		try {
			 date = LocalDate.parse(textFieldEnableDate.getText(), DateTimeFormatter.ofPattern("ddMMyyyy"));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Λάθος format ημερομηνίας!");
			return;
		}
		
		//Create new contract
		Contract contract = new Contract(contractCode, textFieldPhone.getText(), client.getVatNumber(), plan.getId(),
		date,comboBoxDuration.getSelectedItem().toString(), 
		discount, cost, contractType, paymentMethod, 0, true);	
		
		_contractsList.add(contract);
			
		LoadContracts(_contractsList);
		
		textFieldPhone.setText("");
		textFieldClientVatNumber.setText("");
		textFieldEnableDate.setText("");
		spinnerPlanId.setValue(0);
	}
	
	private void DisableContract() {
		
		//Validations
		if(table.getRowCount() == 0 || table.getSelectedRow() == -1)
			return;
		
		String SelectedCode = table.getValueAt(table.getSelectedRow(), 1).toString();
		
		for(int counter = 0; counter < _contractsList.size(); counter++) {
			
			Contract contract = _contractsList.get(counter);
			if(contract.getCode().equals(SelectedCode)) {
				if(contract.getIsEnabled() == true) {
					
					LocalDate contractDate = contract.getEnableDate();
					LocalDate currDate = LocalDate.now();
					
					long months = ChronoUnit.MONTHS.between(contractDate, currDate);
					if(months < 3) {				
						double cancellationfee = contract.getCost() * 10/100;
						contract.setCancellationFee(cancellationfee);
					}
					contract.setIsEnabled(false);
					break;
					

				}
			}
		}
				
		LoadContracts(_contractsList);
	}
	
	private void SearchContractsByPlanType(JComboBox<String> comboBoxPlanType) {
		
		String planType = comboBoxPlanType.getSelectedItem().toString();
		
		ArrayList<Contract> dummyList = new ArrayList<Contract>();	
		
		for(int counter = 0; counter < _contractsList.size(); counter++) {
			
			Contract contract = _contractsList.get(counter);
			if(GetPlanTypeById(contract.getPlanId()).equals(planType)) {
				dummyList.add(contract);
			}
		}

		LoadContracts(dummyList);
	}
	
	private void SearchContractsByPhone(JTextField textFieldPhoneSearch) {
		
		String phone = textFieldPhoneSearch.getText();
		
		ArrayList<Contract> dummyList = new ArrayList<Contract>();	
		
		for(int counter = 0; counter < _contractsList.size(); counter++) {
			
			Contract contract = _contractsList.get(counter);
			if(contract.getPhone().equals(phone)) {
				dummyList.add(contract);
			}
		}

		LoadContracts(dummyList);
	}
	
	private boolean ClientΗasEnabledContract(Client client) {
		
		boolean result = false;
		for(int counter = 0; counter < _contractsList.size(); counter++) {
			
			Contract contract = _contractsList.get(counter);
			if(contract.getClientVatNumber().equals(client.getVatNumber()) && contract.getIsEnabled() == true)
				result = true;
		}
		return result;
	}
}
