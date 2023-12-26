import java.awt.EventQueue;

import javax.swing.JFrame;

import Models.Client;
import Models.Contract;
import Models.Plan;
import Models.TelecommunicationCompany;
import Pages.ManageClients;
import Pages.ManageContracts;
import Pages.ManagePlans;
import Pages.ManageTelecommunicationCompanies;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ProjectSoftware {
	
	//Lists
	ArrayList<TelecommunicationCompany> Companies = new ArrayList<TelecommunicationCompany>();	
	ArrayList<Plan> Plans = new ArrayList<Plan>();
	ArrayList<Client> Clients = new ArrayList<Client>();
	ArrayList<Contract> Contracts = new ArrayList<Contract>();
	
	//Pages
	private ManagePlans managePlansPage;
	private ManageTelecommunicationCompanies manageTelCompPage;
	private ManageClients manageClientsPage;
	private ManageContracts manageContractsPage;
	
	private JFrame mainForm;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectSoftware window = new ProjectSoftware();
					window.mainForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProjectSoftware() {
		initialize();
	}

	private void initialize() {
		mainForm = new JFrame();
		mainForm.setTitle("\u039A\u03B1\u03C4\u03AC\u03C3\u03C4\u03B7\u03BC\u03B1 \u03A0\u03B1\u03C1\u03BF\u03C7\u03AE\u03C2 \u03A4\u03B7\u03BB\u03B5\u03C0\u03B9\u03BA\u03BF\u03B9\u03BD\u03C9\u03BD\u03B9\u03B1\u03BA\u03CE\u03BD \u03A5\u03C0\u03B7\u03C1\u03B5\u03C3\u03B9\u03CE\u03BD");
		mainForm.setBounds(100, 100, 1104, 532);
		mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainForm.setLocationRelativeTo(null);

		//Initialize pages
		manageTelCompPage = new ManageTelecommunicationCompanies(Companies, Plans);
		managePlansPage = new ManagePlans(Companies, Plans, Contracts);
		manageClientsPage = new ManageClients(Clients, Contracts);
		manageContractsPage = new ManageContracts(Plans, Clients, Contracts);
		 
		JButton btnManageCompanies = new JButton("\u0395\u03C4\u03B1\u03B9\u03C1\u03AF\u03B5\u03C2 \u03A4\u03B7\u03BB\u03B5\u03C0\u03B9\u03BA\u03BF\u03B9\u03BD\u03C9\u03BD\u03B9\u03CE\u03BD");
		btnManageCompanies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Open ManageTelecommunicationCompanies page
				manageTelCompPage.setVisible(true);
			}
		});
		btnManageCompanies.setToolTipText("");
		
		JButton btnManagePlans = new JButton("\u03A0\u03C1\u03BF\u03B3\u03C1\u03AC\u03BC\u03BC\u03B1\u03C4\u03B1");
		btnManagePlans.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Open ManagePlans page
				managePlansPage.setVisible(true);
			}
		});
		
		JButton btnManageClients = new JButton("\u03A0\u03B5\u03BB\u03AC\u03C4\u03B5\u03C2");
		btnManageClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Open ManageClients page
				manageClientsPage.setVisible(true);
			}
		});
		
		JButton btnManageContracts = new JButton("\u03A3\u03C5\u03BC\u03B2\u03CC\u03BB\u03B1\u03B9\u03B1");
		btnManageContracts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manageContractsPage.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(mainForm.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addComponent(btnManageCompanies, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(81)
					.addComponent(btnManagePlans, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(84)
					.addComponent(btnManageClients, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addComponent(btnManageContracts, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(195)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnManageCompanies, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnManagePlans, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnManageClients, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnManageContracts, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
					.addContainerGap(226, Short.MAX_VALUE))
		);
		mainForm.getContentPane().setLayout(groupLayout);
	}
}
