package Pages;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Models.Client;
import Models.Contract;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ManageClients extends JFrame {
	
	private DefaultTableModel _tableModel;
	ArrayList<Client> _clientsList = new ArrayList<Client>();
	ArrayList<Contract> _contractsList = new ArrayList<Contract>();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldIdentityNumber;
	private JTextField textFieldVatNumber;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	
	//Overloaded constructor
	public ManageClients(ArrayList<Client> Clients, ArrayList<Contract> Contracts) {
		
		_clientsList = Clients;
		_contractsList = Contracts;
		
		DefaultInitialization(this);
		CreateTableColumns();
		LoadClients(Clients);
	}
	
	private void DefaultInitialization(ManageClients form) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1434, 788);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 40, 1006, 591);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnReturn = new JButton("Επιστροφή");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				form.dispose();
			}
		});
		btnReturn.setBackground(Color.LIGHT_GRAY);
		btnReturn.setBounds(35, 669, 115, 27);
		contentPane.add(btnReturn);
		
		JLabel lblCode = new JLabel("Αριθμός Ταυτότητας:");
		lblCode.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode.setBackground(Color.DARK_GRAY);
		lblCode.setBounds(1051, 69, 121, 33);
		contentPane.add(lblCode);
		
		textFieldIdentityNumber = new JTextField();
		textFieldIdentityNumber.setColumns(10);
		textFieldIdentityNumber.setBounds(1173, 72, 187, 27);
		contentPane.add(textFieldIdentityNumber);
		
		JLabel lblCode_1 = new JLabel("Α.Φ.Μ:");
		lblCode_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1.setBackground(Color.DARK_GRAY);
		lblCode_1.setBounds(1068, 110, 169, 33);
		contentPane.add(lblCode_1);
		
		textFieldVatNumber = new JTextField();
		textFieldVatNumber.setColumns(10);
		textFieldVatNumber.setBounds(1173, 113, 187, 27);
		contentPane.add(textFieldVatNumber);
		
		JLabel lblCode_1_1 = new JLabel("Ονοματεπώνυμο:");
		lblCode_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1.setBackground(Color.DARK_GRAY);
		lblCode_1_1.setBounds(1068, 152, 169, 33);
		contentPane.add(lblCode_1_1);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(1173, 155, 187, 27);
		contentPane.add(textFieldName);
		
		JLabel lblCode_1_1_1 = new JLabel("Ιδιότητα:");
		lblCode_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1_1.setBackground(Color.DARK_GRAY);
		lblCode_1_1_1.setBounds(1068, 199, 169, 33);
		contentPane.add(lblCode_1_1_1);
		
		JComboBox<String> comboBoxClientType = new JComboBox<String>();
		comboBoxClientType.addItem("Ιδιώτης");
		comboBoxClientType.addItem("Φοιτητής");
		comboBoxClientType.addItem("Επαγγελματίας");
		comboBoxClientType.setBounds(1173, 200, 187, 30);
		contentPane.add(comboBoxClientType);
		
		JButton btnSearchPlanType = new JButton("Αναζήτηση");
		btnSearchPlanType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchClient(textFieldIdentityNumber, textFieldVatNumber);
			}
		});
		btnSearchPlanType.setBounds(1494, 95, 105, 27);
		contentPane.add(btnSearchPlanType);
		
		JLabel lblCode_1_1_2 = new JLabel("Διεύθυνση:");
		lblCode_1_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1_2.setBackground(Color.DARK_GRAY);
		lblCode_1_1_2.setBounds(1068, 246, 169, 33);
		contentPane.add(lblCode_1_1_2);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(1173, 249, 187, 27);
		contentPane.add(textFieldAddress);
		
		JLabel lblCode_1_1_2_1 = new JLabel("Τηλέφωνο:");
		lblCode_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1_2_1.setBackground(Color.DARK_GRAY);
		lblCode_1_1_2_1.setBounds(1068, 287, 115, 33);
		contentPane.add(lblCode_1_1_2_1);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(1173, 290, 187, 27);
		contentPane.add(textFieldPhone);
		
		JLabel lblCode_1_1_2_1_1 = new JLabel("E-mail:");
		lblCode_1_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblCode_1_1_2_1_1.setBackground(Color.DARK_GRAY);
		lblCode_1_1_2_1_1.setBounds(1068, 331, 169, 33);
		contentPane.add(lblCode_1_1_2_1_1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(1173, 334, 187, 27);
		contentPane.add(textFieldEmail);
		
		JButton btnInsert = new JButton("Καταχώρηση");
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddClient(textFieldIdentityNumber, textFieldVatNumber, textFieldName,
						 comboBoxClientType, textFieldAddress, textFieldPhone, textFieldEmail);
			}
		});
		btnInsert.setBounds(1105, 397, 115, 33);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Ενημέρωση");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateClient(textFieldIdentityNumber, textFieldVatNumber, textFieldName,
						 comboBoxClientType, textFieldAddress, textFieldPhone, textFieldEmail);
			}
		});
		btnUpdate.setBounds(1254, 397, 106, 33);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Διαγραφή");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoveClient();
			}
		});
		btnDelete.setBounds(1390, 397, 141, 33);
		contentPane.add(btnDelete);
		
		JButton btnRefresh = new JButton("Ανανέωση");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadClients(_clientsList);
			}
		});
		btnRefresh.setBackground(Color.GREEN);
		btnRefresh.setBounds(989, 11, 115, 27);
		contentPane.add(btnRefresh);
		
		JLabel lblNewLabel = new JLabel("Πελάτες");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(479, 14, 228, 33);
		contentPane.add(lblNewLabel);
	}
	
	private void CreateTableColumns() {
		_tableModel = (DefaultTableModel) table.getModel();
		_tableModel.addColumn("A/A");
		_tableModel.addColumn("Αριθμός Ταυτότητας");
		_tableModel.addColumn("Α.Φ.Μ");
		_tableModel.addColumn("Ονοματεπώνυμο");
		_tableModel.addColumn("Ιδιότητα");
		_tableModel.addColumn("Διεύθυνση");
		_tableModel.addColumn("Τηλέφωνο");
		_tableModel.addColumn("E-mail");
	}
	
	private void ClearTable() {
		
		for (int i = _tableModel.getRowCount() - 1; i >= 0; i--) {
			_tableModel.removeRow(i);
		}
	}
	
	private void LoadClients(ArrayList<Client> clients) {
		
		ClearTable();
		
		for(int counter = 0; counter < clients.size(); counter++) {
			
			Client client = clients.get(counter);
			
			int index = counter;
			index++;
			String[] rowData = { String.valueOf(index), client.getIdentityNumber(), client.getVatNumber(), client.getName(), client.getClientType(),
					client.getAddress(), client.getPhone(), client.getEmail()};
			_tableModel.addRow(rowData);
		}
	}
	
	private void AddClient(JTextField textFieldIdentityNumber, JTextField textFieldVatNumber, JTextField textFieldName,
	JComboBox<String> comboBoxClientType, JTextField textFieldAddress, JTextField textFieldPhone, JTextField textFieldEmail) {
		
		//Validations
		if(textFieldIdentityNumber.getText().isEmpty() || textFieldVatNumber.getText().isEmpty() || textFieldName.getText().isEmpty() || 
				textFieldAddress.getText().isEmpty() || textFieldPhone.getText().isEmpty() || textFieldEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Πρέπει να συμπληρωθούν όλα τα πεδία!");
			return;
		}
		
		//Create new client object
		Client client = new Client(textFieldIdentityNumber.getText(), textFieldVatNumber.getText(), textFieldName.getText(),
				comboBoxClientType.getSelectedItem().toString(), textFieldAddress.getText(), textFieldEmail.getText(), textFieldPhone.getText());
		
		//Add to list
		_clientsList.add(client);
		
		textFieldIdentityNumber.setText("");
		textFieldVatNumber.setText("");
		textFieldName.setText("");
		textFieldAddress.setText("");
		textFieldPhone.setText("");
		textFieldEmail.setText("");
		
		LoadClients(_clientsList);
	}
	
	private void SearchClient(JTextField textFieldIdentityNumber, JTextField textFieldVatNumber) {
				
		ArrayList<Client> dummyList = new ArrayList<Client>();	
		
		for(int counter = 0; counter < _clientsList.size(); counter++) {
			
			Client client = _clientsList.get(counter);
			if(client.getIdentityNumber().equals(textFieldIdentityNumber.getText())|| client.getVatNumber().equals(textFieldVatNumber.getText())) {
				dummyList.add(client);
			}
		}

		LoadClients(dummyList);
		
	}
	
	private void UpdateClient(JTextField textFieldIdentityNumber, JTextField textFieldVatNumber, JTextField textFieldName,
			JComboBox<String> comboBoxClientType, JTextField textFieldAddress, JTextField textFieldPhone, JTextField textFieldEmail	) {
		
		//Validations
		if(table.getRowCount() == 0 || table.getSelectedRow() == -1)
			return;
		
		String SelectedId = table.getValueAt(table.getSelectedRow(), 1).toString();
		
		for(int counter = 0; counter < _clientsList.size(); counter++) {
			
			Client client = _clientsList.get(counter);
			if(client.getIdentityNumber().equals(SelectedId)) {
				
				if(!textFieldName.getText().isEmpty())
					client.setName(textFieldName.getText());
				
				client.setClientType(comboBoxClientType.getSelectedItem().toString());
				
				if(!textFieldAddress.getText().isEmpty())
					client.setAddress(textFieldAddress.getText());
				if(!textFieldPhone.getText().isEmpty())
					client.setPhone(textFieldPhone.getText());
				if(!textFieldEmail.getText().isEmpty())
					client.setEmail(textFieldEmail.getText());
				break;
			}
		}
				
		LoadClients(_clientsList);
		
		textFieldIdentityNumber.setText("");
		textFieldVatNumber.setText("");
		textFieldName.setText("");
		textFieldAddress.setText("");
		textFieldPhone.setText("");
		textFieldEmail.setText("");
		
	}
	
	private void RemoveClient() {
		
		//Validations
		if(table.getRowCount() == 0 || table.getSelectedRow() == -1)
			return;
		
		String SelectedVatNumber = table.getValueAt(table.getSelectedRow(), 2).toString();
				
		for(int counter = 0; counter < _clientsList.size(); counter++) {
			
			Client client = _clientsList.get(counter);
			if(client.getVatNumber().equals(SelectedVatNumber)) {
				//Check if client is registered to contract
				if(!IsRegisteredtoContract(client.getVatNumber())) {
					_clientsList.remove(counter);
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "Υπάρχει καταχωρημένο συμβόλαιο στο σύστημα που σχετίζεται με το παρόν πελάτη!");
				}
			}

		}
			
		LoadClients(_clientsList);
			
	}
	
	private boolean IsRegisteredtoContract(String clientVatNumber) {
		boolean result = false;
		
		for(int counter = 0; counter < _contractsList.size(); counter++) {
			
			Contract contract = _contractsList.get(counter);
			if(contract.getClientVatNumber().equals(clientVatNumber)) {
				result = true;
			}
		}
	
		return result;		
	}
}
