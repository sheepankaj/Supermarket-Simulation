package simulator.ui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

public class SimulatorUI extends JFrame {

	private JPanel contentPane;
	private JTextField txTotWaitCustomer;
	private JTextField txTotUtiForCheckout;
	private JTextField txTotProductsProcessed;
	private JTextField txAvgCustomerWaitTime;
	private JTextField textField;
	private JTextField txAvgProductsPerTrolley;
	private JTextField txNoOfLostCustomers;
	/**
	 * Create the frame.
	 */
	public SimulatorUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 1200, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel checkOuts = new JPanel();
		checkOuts.setBounds(904, 11, 270, 539);
		checkOuts.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Checkout Queues", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(checkOuts);
		checkOuts.setLayout(new BoxLayout(checkOuts, BoxLayout.Y_AXIS));
		
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
						.addComponent(lbCheckoutUtilization)
						.addComponent(lbAvgProductsPerTrolley)
						.addComponent(lbNoOfLostCustomers))
					.addGap(38)
					.addGroup(gl_parameters.createParallelGroup(Alignment.LEADING)
						.addComponent(txNoOfLostCustomers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txAvgProductsPerTrolley, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txAvgCustomerWaitTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txTotProductsProcessed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txTotUtiForCheckout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txTotWaitCustomer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(115, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_parameters.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCheckoutUtilization)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_parameters.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbAvgProductsPerTrolley)
						.addComponent(txAvgProductsPerTrolley, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_parameters.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbNoOfLostCustomers)
						.addComponent(txNoOfLostCustomers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		parameters.setLayout(gl_parameters);
	}
}
