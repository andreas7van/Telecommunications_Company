package Pages;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Models.Contract;
import Models.LandlinePlan;
import Models.MobilePlan;
import Models.Plan;
import Models.TelecommunicationCompany;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.border.BevelBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagePlans extends JFrame {

	private DefaultTableModel _tableModel;
	private ArrayList<TelecommunicationCompany> _companiesList = new ArrayList<TelecommunicationCompany>();	
	private ArrayList<Plan> _plansList = new ArrayList<Plan>();
	ArrayList<Contract> _contractsList = new ArrayList<Contract>();
	private int _plansCounter = 1;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textFieldLineSpeed;
	
	//Overloaded constructor
	public ManagePlans(ArrayList<TelecommunicationCompany> Companies, ArrayList<Plan> Plans,
			ArrayList<Contract> Contracts) {
		
		_companiesList = Companies;
		_plansList = Plans;
		_contractsList = Contracts;
					
		DefaultInitialization(this);
		CreateTableColumns();
		LoadPlans(Plans);
	}
	
	private void DefaultInitialization(ManagePlans form) {
		setTitle("Διαχείριση Προγραμμάτων");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1633, 791);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReturn = new JButton("Επιστροφή");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				form.dispose();
			}
		});
		btnReturn.setBackground(new Color(192, 192, 192));
		btnReturn.setBounds(49, 675, 115, 27);
		contentPane.add(btnReturn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 59, 998, 592);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
				
		JLabel lblCode = new JLabel("Τύπος Προγράμματος:");
		lblCode.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode.setBackground(Color.DARK_GRAY);
		lblCode.setBounds(1059, 126, 169, 33);
		contentPane.add(lblCode);
		
		JLabel lblCode_1 = new JLabel("Εταιρία Τηλεπικοινωνιών:");
		lblCode_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1.setBackground(Color.DARK_GRAY);
		lblCode_1.setBounds(1059, 170, 153, 33);
		contentPane.add(lblCode_1);
		
		JLabel lblCode_2 = new JLabel("Πλήθος Δωρεάν Κλήσεων:");
		lblCode_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_2.setBackground(Color.DARK_GRAY);
		lblCode_2.setBounds(1059, 214, 169, 33);
		contentPane.add(lblCode_2);
		
		JSpinner spinnerFreeCalls = new JSpinner();
		spinnerFreeCalls.setBounds(1222, 219, 82, 22);
		contentPane.add(spinnerFreeCalls);
		
		JLabel lblCode_2_1 = new JLabel("Κόστος Προγράμματος:");
		lblCode_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_2_1.setBackground(Color.DARK_GRAY);
		lblCode_2_1.setBounds(1059, 258, 169, 33);
		contentPane.add(lblCode_2_1);
		
		JSpinner spinnerCost = new JSpinner();
		spinnerCost.setBounds(1222, 263, 82, 22);
		contentPane.add(spinnerCost);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(1059, 321, 282, 139);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCode_2_1_1 = new JLabel("Mobile Plan");
		lblCode_2_1_1.setBounds(104, 11, 65, 14);
		lblCode_2_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_2_1_1.setBackground(Color.DARK_GRAY);
		panel.add(lblCode_2_1_1);
		
		JLabel lblCode_2_2 = new JLabel("Δωρεάν SMS:");
		lblCode_2_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_2_2.setBackground(Color.DARK_GRAY);
		lblCode_2_2.setBounds(10, 43, 83, 33);
		panel.add(lblCode_2_2);
		
		JSpinner spinnerFreeSMS = new JSpinner();
		spinnerFreeSMS.setBounds(104, 48, 72, 22);
		panel.add(spinnerFreeSMS);
		
		JLabel lblCode_2_2_1 = new JLabel("Δωρεάν GB:");
		lblCode_2_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_2_2_1.setBackground(Color.DARK_GRAY);
		lblCode_2_2_1.setBounds(10, 87, 83, 33);
		panel.add(lblCode_2_2_1);
		
		JSpinner spinnerFreeGB = new JSpinner();
		spinnerFreeGB.setBounds(102, 93, 72, 22);
		panel.add(spinnerFreeGB);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(1059, 486, 282, 139);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCode_2_1_1_1 = new JLabel("LandLine Plan");
		lblCode_2_1_1_1.setBounds(98, 11, 80, 14);
		lblCode_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_2_1_1_1.setBackground(Color.DARK_GRAY);
		panel_1.add(lblCode_2_1_1_1);
		
		JLabel lblCode_2_2_2 = new JLabel("Ονομαστική Ταχύτητα Γραμμής:");
		lblCode_2_2_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_2_2_2.setBackground(Color.DARK_GRAY);
		lblCode_2_2_2.setBounds(10, 46, 175, 33);
		panel_1.add(lblCode_2_2_2);
		
		JLabel lblCode_2_2_2_1 = new JLabel("Τύπος Γραμμής:");
		lblCode_2_2_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_2_2_2_1.setBackground(Color.DARK_GRAY);
		lblCode_2_2_2_1.setBounds(10, 90, 109, 33);
		panel_1.add(lblCode_2_2_2_1);
		
		textFieldLineSpeed = new JTextField();
		textFieldLineSpeed.setColumns(10);
		textFieldLineSpeed.setBounds(195, 49, 86, 27);
		panel_1.add(textFieldLineSpeed);
		
		JComboBox<String> comboBoxLineType = new JComboBox<String>();
		comboBoxLineType.addItem("ADSL");
		comboBoxLineType.addItem("VDSL");
		comboBoxLineType.setBounds(195, 95, 86, 22);
		panel_1.add(comboBoxLineType);
		
		JComboBox<String> comboBoxPlanType = new JComboBox<String>();
		comboBoxPlanType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnableDisableControls(comboBoxPlanType, spinnerFreeSMS, spinnerFreeGB, 
						textFieldLineSpeed, comboBoxLineType);
			}
		});
		comboBoxPlanType.addItem("Landline");
		comboBoxPlanType.addItem("Mobile");
		comboBoxPlanType.setBounds(1222, 131, 148, 22);
		contentPane.add(comboBoxPlanType);
				
		JComboBox<String> comboBoxCompanies = new JComboBox<String>();
		CreateComboBoxCompanies(comboBoxCompanies);
		comboBoxCompanies.setBounds(1222, 175, 148, 22);
		contentPane.add(comboBoxCompanies);
				
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				CreateComboBoxCompanies(comboBoxCompanies);
			}
		});
		
		JButton btnInsert = new JButton("Καταχώρηση");
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPlan(comboBoxPlanType, comboBoxCompanies, spinnerFreeCalls, 
						spinnerCost, spinnerFreeSMS, spinnerFreeGB, 
						textFieldLineSpeed, comboBoxLineType);
			}
		});
		btnInsert.setBounds(1059, 659, 138, 33);
		contentPane.add(btnInsert);
		
		JButton btnSearchPlanType = new JButton("Αναζήτηση");
		btnSearchPlanType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchPlansByPlanType(comboBoxPlanType);
			}
		});
		btnSearchPlanType.setBounds(1481, 129, 105, 27);
		contentPane.add(btnSearchPlanType);
		
		JButton btnSearchCompany = new JButton("Αναζήτηση");
		btnSearchCompany.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchPlansByCompany(comboBoxCompanies);
			}
		});
		btnSearchCompany.setBounds(1481, 173, 105, 27);
		contentPane.add(btnSearchCompany);
		
		JButton btnRefresh = new JButton("Ανανέωση");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadPlans(_plansList);
			}
		});
		btnRefresh.setBackground(Color.GREEN);
		btnRefresh.setBounds(934, 19, 115, 27);
		contentPane.add(btnRefresh);
		
		JLabel lblCode_3 = new JLabel("Προγράμματα Κινητής & Σταθερής Τηλεφωνίας");
		lblCode_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblCode_3.setBackground(Color.DARK_GRAY);
		lblCode_3.setBounds(360, 15, 387, 33);
		contentPane.add(lblCode_3);
		
		JButton btnUpdate = new JButton("Ενημέρωση");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdatePlan(comboBoxPlanType, spinnerFreeCalls, 
						spinnerCost, spinnerFreeSMS, spinnerFreeGB, 
						textFieldLineSpeed, comboBoxLineType);
			}
		});
		btnUpdate.setBounds(1233, 659, 127, 33);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Διαγραφή");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemovePlan();
			}
		});
		btnDelete.setBounds(1432, 657, 141, 33);
		contentPane.add(btnDelete);

	}
	
	private void EnableDisableControls(JComboBox<String> comboBoxPlanType, JSpinner spinnerFreeSMS, JSpinner spinnerFreeGB, 
			JTextField textFieldLineSpeed, JComboBox<String> comboBoxLineType) {
		
		String planType = comboBoxPlanType.getSelectedItem().toString();
		if(planType == "Mobile") {
			textFieldLineSpeed.setEnabled(false);
			comboBoxLineType.setEnabled(false);
			spinnerFreeSMS.setEnabled(true);
			spinnerFreeGB.setEnabled(true);
		}
		else
		{
			textFieldLineSpeed.setEnabled(true);
			comboBoxLineType.setEnabled(true);
			spinnerFreeSMS.setEnabled(false);
			spinnerFreeGB.setEnabled(false);
		}
	}
	
	private String GetCompanyNameByCompanyId(int CompanyId) {
		
		for(int counter = 0; counter < _companiesList.size(); counter++) {	
			
			TelecommunicationCompany company = _companiesList.get(counter);
			if(company.getId() == CompanyId) {
				return company.getName();
			}
		}
		return null;
	}
	
	private int GetCompanyIdByCompanyName(String CompanyName) {
		
		for(int counter = 0; counter < _companiesList.size(); counter++) {	
			
			TelecommunicationCompany company = _companiesList.get(counter);
			if(company.getName().equals(CompanyName)) {
				return company.getId();
			}
		}
		return 0;
	}
	
	private void CreateComboBoxCompanies(JComboBox<String> comboBoxCompanies) {
		
		comboBoxCompanies.removeAllItems();
		if(_companiesList.size() == 0) {
			comboBoxCompanies.setEnabled(false);
		}
		else {
			comboBoxCompanies.setEnabled(true);
			for(int counter = 0; counter < _companiesList.size(); counter++) {
				
				TelecommunicationCompany comp = _companiesList.get(counter);
				comboBoxCompanies.addItem(comp.getName());
				
				}
		}

	}
	
	private void CreateTableColumns() {
		_tableModel = (DefaultTableModel) table.getModel();
		_tableModel.addColumn("A/A");
		_tableModel.addColumn("Κωδικός");
		_tableModel.addColumn("Τύπος");
		_tableModel.addColumn("Εταιρεία");
		_tableModel.addColumn("Δωρεάν Κλήσεις");
		_tableModel.addColumn("Κόστος");
		_tableModel.addColumn("Δωρεάν SMS");
		_tableModel.addColumn("Δωρεάν GB");
		_tableModel.addColumn("Ταχύτητα Γραμμής");
		_tableModel.addColumn("Τύπος Γραμμής");
	}
	
	private void ClearTable() {
		
		for (int i = _tableModel.getRowCount() - 1; i >= 0; i--) {
			_tableModel.removeRow(i);
		}
	}
	
	private void LoadPlans(ArrayList<Plan> plansList) {
		
		ClearTable();
		
		for(int counter = 0; counter < plansList.size(); counter++) {
			
			int index = counter;
			index++;
			
			Plan plan =  plansList.get(counter);
			if(plan.getClass() == MobilePlan.class) {
				
				MobilePlan mobilePlan = (MobilePlan) plan;
				String[] rowData = { String.valueOf(index), String.valueOf(mobilePlan.getId()), "Mobile", GetCompanyNameByCompanyId(mobilePlan.getTelecommunicationCompanyId()), 
						String.valueOf(mobilePlan.getFreeCallTime()), String.valueOf(mobilePlan.getCost()), String.valueOf(mobilePlan.getFreeSMS()), 
						String.valueOf(mobilePlan.getFreeGB()), "-","-"};
				_tableModel.addRow(rowData);
			}
			else {
				LandlinePlan landlinePlan = (LandlinePlan) plan;
				String[] rowData = { String.valueOf(index), String.valueOf(landlinePlan.getId()), "Landline", GetCompanyNameByCompanyId(landlinePlan.getTelecommunicationCompanyId()), 
						String.valueOf(landlinePlan.getFreeCallTime()), String.valueOf(landlinePlan.getCost()), "-", "-", String.valueOf(landlinePlan.getLineSpeed()),
						String.valueOf(landlinePlan.getLineType())};
				_tableModel.addRow(rowData);
			}		
		}
	}
	
	private void AddPlan(JComboBox<String> comboBoxPlanType, JComboBox<String> comboBoxCompanies, JSpinner spinnerFreeCalls, 
			JSpinner spinnerCost, JSpinner spinnerFreeSMS, JSpinner spinnerFreeGB, 
			JTextField textFieldLineSpeed, JComboBox<String> comboBoxLineType) {
		
		//Validations
		if(!comboBoxCompanies.isEnabled()) {
			//There aren't any companies
			JOptionPane.showMessageDialog(null, "Πρέπει να γίνει καταχώρηση εταιρείας πρώτα!");
			return;
		}
		
		String companyName = comboBoxCompanies.getSelectedItem().toString();
		String planType = comboBoxPlanType.getSelectedItem().toString();
		if(planType == "Mobile") {
			Plan mobilePlan = new MobilePlan(_plansCounter++,GetCompanyIdByCompanyName(companyName), (Integer)spinnerFreeCalls.getValue(),
					(Integer)spinnerCost.getValue(),(Integer)spinnerFreeSMS.getValue(),(Integer)spinnerFreeGB.getValue());
			_plansList.add(mobilePlan);
		}
		else {
			//Validation
			if(textFieldLineSpeed.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Πρέπει να συμπληρωθούν όλα τα πεδία!");
				return;
			}
			
			String lineType = comboBoxLineType.getSelectedItem().toString();
			Plan landlinePlan = new LandlinePlan(_plansCounter++,GetCompanyIdByCompanyName(companyName),(Integer)spinnerFreeCalls.getValue(),
					(Integer)spinnerCost.getValue(),textFieldLineSpeed.getText(),lineType);
			_plansList.add(landlinePlan);
		}
		
		LoadPlans(_plansList);
		
	}
	
	private void UpdatePlan(JComboBox<String> comboBoxPlanType, JSpinner spinnerFreeCalls, 
			JSpinner spinnerCost, JSpinner spinnerFreeSMS, JSpinner spinnerFreeGB, 
			JTextField textFieldLineSpeed, JComboBox<String> comboBoxLineType) {
		
		//Validations
		if(table.getRowCount() == 0 || table.getSelectedRow() == -1)
			return;
		
		String planType = comboBoxPlanType.getSelectedItem().toString();
		Object SelectedId = table.getValueAt(table.getSelectedRow(), 1);
		
		int IdtoUpdate = Integer.parseInt((String) SelectedId);
		
		for(int counter = 0; counter < _plansList.size(); counter++) {
			
			Plan plan = _plansList.get(counter);
			if(plan.getId() == IdtoUpdate) {
				if(planType == "Mobile") { 
					//Mobile Case
					if(plan.getClass() == MobilePlan.class) {
						//Mobile Object - Just update.
						MobilePlan mobilePlan = (MobilePlan) plan;
						mobilePlan.setFreeCallTime((Integer)spinnerFreeCalls.getValue());
						mobilePlan.setCost((Integer)spinnerCost.getValue());
						mobilePlan.setFreeSMS((Integer)spinnerFreeSMS.getValue());
						mobilePlan.setFreeGB((Integer)spinnerFreeGB.getValue());	
					}
					else {
						//Landline Object - Delete and create new one (different type).
						int OldPlanId = plan.getId();
						int OldPlanCompanyId = plan.getTelecommunicationCompanyId();
						
						_plansList.remove(counter);
						
						Plan mobPlan = new MobilePlan(OldPlanId, OldPlanCompanyId, (Integer)spinnerFreeCalls.getValue(),
								(Integer)spinnerCost.getValue(),(Integer)spinnerFreeSMS.getValue(),(Integer)spinnerFreeGB.getValue());
						
						_plansList.add(counter, mobPlan);
						
					}
				}
				else {
					//Landline Case
					if(plan.getClass() == LandlinePlan.class) {
						//Landline Object - Just update.
						LandlinePlan landLinePlan = (LandlinePlan) plan;
						landLinePlan.setFreeCallTime((Integer)spinnerFreeCalls.getValue());
						landLinePlan.setCost((Integer)spinnerCost.getValue());
						landLinePlan.setLineSpeed(textFieldLineSpeed.getText());
						landLinePlan.setLineType(comboBoxLineType.getSelectedItem().toString());	
					}
					else {
						//Mobile Object - Delete and create new one (different type).
						int OldPlanId = plan.getId();
						int OldPlanCompanyId = plan.getTelecommunicationCompanyId();
						
						_plansList.remove(counter);
						
						Plan landPlan = new LandlinePlan(OldPlanId, OldPlanCompanyId, (Integer)spinnerFreeCalls.getValue(),
								(Integer)spinnerCost.getValue(),textFieldLineSpeed.getText(),comboBoxLineType.getSelectedItem().toString());
						
						_plansList.add(counter, landPlan);
						
					}
					
				}
				break;
			}

		}
				
		LoadPlans(_plansList);
		
		
	}
	
	private void SearchPlansByPlanType(JComboBox<String> comboBoxPlanType) {
		
		String planType = comboBoxPlanType.getSelectedItem().toString();
		
		ArrayList<Plan> dummyList = new ArrayList<Plan>();	
		
		for(int counter = 0; counter < _plansList.size(); counter++) {
			
			Plan plan = _plansList.get(counter);
			if(plan.getClass() == MobilePlan.class && planType.equals("Mobile")) {
				dummyList.add(plan);
			}
			else if(plan.getClass() == LandlinePlan.class && planType.equals("Landline"))
			{
				dummyList.add(plan);
			}
		}

		LoadPlans(dummyList);
		
	}
	
	private void SearchPlansByCompany(JComboBox<String> comboBoxCompanies) {
		
		String companyName = comboBoxCompanies.getSelectedItem().toString();
		
		ArrayList<Plan> dummyList = new ArrayList<Plan>();	
		
		for(int counter = 0; counter < _plansList.size(); counter++) {
			
			Plan plan = _plansList.get(counter);
			if(plan.getTelecommunicationCompanyId() == GetCompanyIdByCompanyName(companyName)) {
				dummyList.add(plan);
			}
		}

		LoadPlans(dummyList);
		
	}
	
	private void RemovePlan() {
		
		//Validations
		if(table.getRowCount() == 0 || table.getSelectedRow() == -1)
			return;
		
		Object SelectedId = table.getValueAt(table.getSelectedRow(), 1);
		
		int IdtoRemove = Integer.parseInt((String) SelectedId);
				
		for(int counter = 0; counter < _plansList.size(); counter++) {
			
			Plan plan = _plansList.get(counter);
			if(plan.getId() == IdtoRemove) {
				//Check if plan is registered to contract
				if(!IsRegisteredtoContract(plan.getId())) {
					_plansList.remove(counter);
				}
				else {
					JOptionPane.showMessageDialog(null, "Υπάρχει καταχωρημένο συμβόλαιο στο σύστημα που σχετίζεται με το παρόν πρόγραμμα!");
				}
				break;
			}

		}
			
		LoadPlans(_plansList);
			
	}
	
	private boolean IsRegisteredtoContract(int planId) {
		boolean result = false;
		
		for(int counter = 0; counter < _contractsList.size(); counter++) {
			
			Contract contract = _contractsList.get(counter);
			if(contract.getPlanId() == planId) {
				result = true;
			}
		}
	
		return result;		
	}
}
