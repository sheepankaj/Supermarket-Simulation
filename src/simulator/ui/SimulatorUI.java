package simulator.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class SimulatorUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txTotWaitCustomer;
	private JTextField txTotUtiForCheckout;
	private JTextField txTotProductsProcessed;
	private JTextField txAvgCustomerWaitTime;
	private JTextField textField;
	private JTextField txAvgProductsPerTrolley;
	private JTextField txNoOfLostCustomers;
	private JTextField txCheckout_1;
	private JTextField txCheckout_2;
	private JTextField txCheckout_3;
	private JTextField txCheckout_4;
	private JTextField txCheckout_5;
	private JTextField txCheckout_6;
	private JTextField txCheckout_7;
	private JTextField txCheckout_8;
	/**
	 * Create the frame.
	 */
	public SimulatorUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 700, 450);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel checkOuts = new JPanel();
		checkOuts.setBounds(387, 25, 270, 331);
		checkOuts.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Checkout Queues", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(checkOuts);
		
		JLabel lbCheckout_1 = new JLabel("Checkout : 01");
		
		txCheckout_1 = new JTextField();
		txCheckout_1.setColumns(10);
		
		JLabel lbCheckout_2 = new JLabel("Checkout : 02");
		
		txCheckout_2 = new JTextField();
		txCheckout_2.setColumns(10);
		
		JLabel lbCheckout_3 = new JLabel("Checkout : 03");
		
		txCheckout_3 = new JTextField();
		txCheckout_3.setColumns(10);
		
		JLabel lbCheckout_4 = new JLabel("Checkout : 04");
		
		txCheckout_4 = new JTextField();
		txCheckout_4.setColumns(10);
		
		JLabel lbCheckout_5 = new JLabel("Checkout : 05");
		
		txCheckout_5 = new JTextField();
		txCheckout_5.setColumns(10);
		
		JLabel lbCheckout_6 = new JLabel("Checkout : 06");
		
		txCheckout_6 = new JTextField();
		txCheckout_6.setColumns(10);
		
		JLabel lbCheckout_7 = new JLabel("Checkout : 07");
		
		txCheckout_7 = new JTextField();
		txCheckout_7.setColumns(10);
		
		JLabel lbCheclout_8 = new JLabel("Checkout : 08");
		
		txCheckout_8 = new JTextField();
		txCheckout_8.setColumns(10);
		GroupLayout gl_checkOuts = new GroupLayout(checkOuts);
		gl_checkOuts.setHorizontalGroup(
			gl_checkOuts.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_checkOuts.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_checkOuts.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_checkOuts.createSequentialGroup()
							.addComponent(lbCheckout_4)
							.addGap(18)
							.addComponent(txCheckout_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_checkOuts.createSequentialGroup()
							.addComponent(lbCheckout_1)
							.addGap(18)
							.addComponent(txCheckout_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_checkOuts.createSequentialGroup()
							.addGroup(gl_checkOuts.createParallelGroup(Alignment.TRAILING)
								.addComponent(lbCheckout_3)
								.addComponent(lbCheckout_2))
							.addGap(18)
							.addGroup(gl_checkOuts.createParallelGroup(Alignment.LEADING)
								.addComponent(txCheckout_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txCheckout_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_checkOuts.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_checkOuts.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_checkOuts.createSequentialGroup()
									.addComponent(lbCheckout_6)
									.addGap(18)
									.addComponent(txCheckout_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_checkOuts.createSequentialGroup()
									.addComponent(lbCheckout_5)
									.addGap(18)
									.addComponent(txCheckout_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_checkOuts.createSequentialGroup()
									.addComponent(lbCheckout_7)
									.addGap(18)
									.addComponent(txCheckout_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_checkOuts.createSequentialGroup()
									.addComponent(lbCheclout_8)
									.addGap(18)
									.addComponent(txCheckout_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		gl_checkOuts.setVerticalGroup(
			gl_checkOuts.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_checkOuts.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_checkOuts.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCheckout_1)
						.addComponent(txCheckout_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_checkOuts.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCheckout_2)
						.addComponent(txCheckout_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_checkOuts.createParallelGroup(Alignment.BASELINE)
						.addComponent(txCheckout_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbCheckout_3))
					.addGap(18)
					.addGroup(gl_checkOuts.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCheckout_4)
						.addComponent(txCheckout_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_checkOuts.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCheckout_5)
						.addComponent(txCheckout_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_checkOuts.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCheckout_6)
						.addComponent(txCheckout_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_checkOuts.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCheckout_7)
						.addComponent(txCheckout_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_checkOuts.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCheclout_8)
						.addComponent(txCheckout_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(225, Short.MAX_VALUE))
		);
		checkOuts.setLayout(gl_checkOuts);
		
		JPanel parameters = new JPanel();
		parameters.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Statistics", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		parameters.setBounds(22, 25, 343, 209);
		contentPane.add(parameters);
		
		JLabel lbTotWaitCustomer = new JLabel("Total wait time for Customer");
		
		JLabel lbTotUtiForCheckout = new JLabel("Total Utilization for Checkout");
		
		txTotWaitCustomer = new JTextField();
		txTotWaitCustomer.setColumns(10);
		
		txTotUtiForCheckout = new JTextField();
		txTotUtiForCheckout.setColumns(10);
		
		JLabel lbTotProductsProcessed = new JLabel("Total Products Processed");
		
		txTotProductsProcessed = new JTextField();
		txTotProductsProcessed.setColumns(10);
		
		JLabel lbAvgCustomerWaitTime = new JLabel("Avg Customer wait time");
		
		txAvgCustomerWaitTime = new JTextField();
		txAvgCustomerWaitTime.setColumns(10);
		
		JLabel lbCheckoutUtilization = new JLabel("Avg Checkout Utilization");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lbAvgProductsPerTrolley = new JLabel("Avg Products per trolley");
		
		txAvgProductsPerTrolley = new JTextField();
		txAvgProductsPerTrolley.setColumns(10);
		
		JLabel lbNoOfLostCustomers = new JLabel("No Of  lost Customers");
		
		txNoOfLostCustomers = new JTextField();
		txNoOfLostCustomers.setColumns(10);
		GroupLayout gl_parameters = new GroupLayout(parameters);
		gl_parameters.setHorizontalGroup(
			gl_parameters.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_parameters.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_parameters.createParallelGroup(Alignment.LEADING)
						.addComponent(lbTotWaitCustomer)
						.addComponent(lbTotUtiForCheckout)
						.addComponent(lbTotProductsProcessed)
						.addComponent(lbAvgCustomerWaitTime)
						.addComponent(lbNoOfLostCustomers)
						.addComponent(lbCheckoutUtilization)
						.addComponent(lbAvgProductsPerTrolley))
					.addGap(38)
					.addGroup(gl_parameters.createParallelGroup(Alignment.LEADING)
						.addComponent(txNoOfLostCustomers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txAvgProductsPerTrolley, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txAvgCustomerWaitTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txTotProductsProcessed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txTotUtiForCheckout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txTotWaitCustomer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_parameters.setVerticalGroup(
			gl_parameters.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_parameters.createSequentialGroup()
					.addGroup(gl_parameters.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbTotWaitCustomer)
						.addComponent(txTotWaitCustomer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_parameters.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbTotUtiForCheckout)
						.addComponent(txTotUtiForCheckout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_parameters.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbTotProductsProcessed)
						.addComponent(txTotProductsProcessed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_parameters.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbAvgCustomerWaitTime)
						.addComponent(txAvgCustomerWaitTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_parameters.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbCheckoutUtilization))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_parameters.createParallelGroup(Alignment.LEADING)
						.addComponent(txAvgProductsPerTrolley, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbAvgProductsPerTrolley))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_parameters.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbNoOfLostCustomers)
						.addComponent(txNoOfLostCustomers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		parameters.setLayout(gl_parameters);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("works");
			}
		});
		btnStart.setBounds(22, 333, 89, 23);
		contentPane.add(btnStart);
	}
}
