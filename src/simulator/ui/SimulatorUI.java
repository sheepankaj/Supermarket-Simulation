package simulator.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

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

import simulator.demos.Demo;

/**
 * @author Pankaj Kumar Shee-18125638 
 * This class having the whole UI part
 */
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
	private JTextField txAvgCheckoutUtilization;
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
	private Map<Integer,JTextField> checkOutAssociationMap = new HashMap<>(8);
	private Map<Integer,JLabel> checkOutLabelAssociationMap = new HashMap<>(8);
	private JTextField txTotalCustomersInMarket;
	private JTextField txCurrentlyProcessing;
	/**
	 * Create the frame.
	 */
	public SimulatorUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 650, 450);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel checkOuts = new JPanel();
		checkOuts.setBounds(395, 25, 199, 331);
		checkOuts.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Checkout Queues", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(checkOuts);
		
		JLabel lbCheckout_1 = new JLabel("Checkout : 01");
		checkOutLabelAssociationMap.put( 1, lbCheckout_1 );
		
		txCheckout_1 = new JTextField();
		txCheckout_1.setText("0");
		checkOutAssociationMap.put( 1, txCheckout_1 );
		txCheckout_1.setColumns(5);
		
		JLabel lbCheckout_2 = new JLabel("Checkout : 02");
		checkOutLabelAssociationMap.put( 2, lbCheckout_2 );
		
		txCheckout_2 = new JTextField();
		txCheckout_2.setText("0");
		checkOutAssociationMap.put( 2, txCheckout_2 );
		txCheckout_2.setColumns(5);
		
		JLabel lbCheckout_3 = new JLabel("Checkout : 03");
		checkOutLabelAssociationMap.put( 3, lbCheckout_3 );
		txCheckout_3 = new JTextField();
		txCheckout_3.setText("0");
		checkOutAssociationMap.put( 3, txCheckout_3 );
		txCheckout_3.setColumns(5);
		
		JLabel lbCheckout_4 = new JLabel("Checkout : 04");
		checkOutLabelAssociationMap.put( 4, lbCheckout_4 );
		
		txCheckout_4 = new JTextField();
		txCheckout_4.setText("0");
		checkOutAssociationMap.put( 4, txCheckout_4 );
		txCheckout_4.setColumns(5);
		
		JLabel lbCheckout_5 = new JLabel("Checkout : 05");
		checkOutLabelAssociationMap.put( 5, lbCheckout_5 );
		
		txCheckout_5 = new JTextField();
		txCheckout_5.setText("0");
		checkOutAssociationMap.put( 5, txCheckout_5 );
		txCheckout_5.setColumns(5);
		
		JLabel lbCheckout_6 = new JLabel("Checkout : 06");
		checkOutLabelAssociationMap.put( 6, lbCheckout_6 );
		
		txCheckout_6 = new JTextField();
		txCheckout_6.setText("0");
		checkOutAssociationMap.put( 6, txCheckout_6 );
		txCheckout_6.setColumns(5);
		
		JLabel lbCheckout_7 = new JLabel("Checkout : 07");
		checkOutLabelAssociationMap.put( 7, lbCheckout_7 );
		
		txCheckout_7 = new JTextField();
		txCheckout_7.setText("0");
		checkOutAssociationMap.put( 7, txCheckout_7 );
		
		txCheckout_7.setColumns(5);
		
		JLabel lbCheclout_8 = new JLabel("Checkout : 08");
		checkOutLabelAssociationMap.put( 8, lbCheclout_8 );
		
		txCheckout_8 = new JTextField();
		txCheckout_8.setText("0");
		checkOutAssociationMap.put( 8, txCheckout_8 );
		txCheckout_8.setColumns(5);
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
		parameters.setBounds(22, 25, 343, 211);
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
		
		txAvgCheckoutUtilization = new JTextField();
		txAvgCheckoutUtilization.setColumns(10);
		
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
						.addComponent(txAvgCheckoutUtilization, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(txAvgCheckoutUtilization, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbCheckoutUtilization))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_parameters.createParallelGroup(Alignment.LEADING)
						.addComponent(txAvgProductsPerTrolley, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbAvgProductsPerTrolley))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_parameters.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbNoOfLostCustomers)
						.addComponent(txNoOfLostCustomers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		parameters.setLayout(gl_parameters);
		
		JButton btnStart = new JButton("Start");
		SimulatorUI ui = this;
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Demo demo = Demo.getDemoInstance();
				demo.setUi( ui );
				demo.startCheckoutQueues();
				demo.startCustomerGenerator();	
				demo.startStatCalculator(ui);
			}
		});
		btnStart.setBounds(22, 377, 89, 23);
		contentPane.add(btnStart);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 248, 343, 66);
		contentPane.add(panel);
		
		JLabel lbCustomersArrived = new JLabel("Customers Arrived");
		
		txTotalCustomersInMarket = new JTextField();
		txTotalCustomersInMarket.setColumns(10);
		
		JLabel lbCurrentlyProcessing = new JLabel("Currently Processing");
		
		txCurrentlyProcessing = new JTextField();
		
		txCurrentlyProcessing.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbCustomersArrived)
						.addComponent(lbCurrentlyProcessing))
					.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txTotalCustomersInMarket, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txCurrentlyProcessing, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCustomersArrived)
						.addComponent(txTotalCustomersInMarket, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCurrentlyProcessing)
						.addComponent(txCurrentlyProcessing, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	
	public JTextField getTxCurrentlyProcessing()
	{
		return txCurrentlyProcessing;
	}

	public JTextField getTxCheckout_1()
	{
		return txCheckout_1;
	}
	public JTextField getTxCheckout_2()
	{
		return txCheckout_2;
	}
	public JTextField getTxCheckout_3()
	{
		return txCheckout_3;
	}
	public JTextField getTxCheckout_4()
	{
		return txCheckout_4;
	}
	public JTextField getTxCheckout_5()
	{
		return txCheckout_5;
	}
	public JTextField getTxCheckout_6()
	{
		return txCheckout_6;
	}
	public JTextField getTxCheckout_7()
	{
		return txCheckout_7;
	}
	public JTextField getTxCheckout_8()
	{
		return txCheckout_8;
	}

	public Map<Integer, JTextField> getCheckOutAssociationMap()
	{
		return checkOutAssociationMap;
	}

	public JTextField getTxTotalCustomersInMarket()
	{
		return txTotalCustomersInMarket;
	}

	public JTextField getTxTotWaitCustomer()
	{
		return txTotWaitCustomer;
	}

	public JTextField getTxTotUtiForCheckout()
	{
		return txTotUtiForCheckout;
	}

	public JTextField getTxTotProductsProcessed()
	{
		return txTotProductsProcessed;
	}

	public JTextField getTxAvgCustomerWaitTime()
	{
		return txAvgCustomerWaitTime;
	}

	public JTextField getTxAvgCheckoutUtilization()
	{
		return txAvgCheckoutUtilization;
	}

	public JTextField getTxAvgProductsPerTrolley()
	{
		return txAvgProductsPerTrolley;
	}

	public JTextField getTxNoOfLostCustomers()
	{
		return txNoOfLostCustomers;
	}

	public Map<Integer, JLabel> getCheckOutLabelAssociationMap()
	{
		return checkOutLabelAssociationMap;
	}
	
	
}
