package simulator.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SimulatorUI extends JFrame {

	private JPanel contentPane;
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
		parameters.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Parameters", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		parameters.setBounds(33, 278, 399, 199);
		contentPane.add(parameters);
		
		JLabel lbProdPerTrolley = new JLabel("Products per Trolley");
		
		JSlider slProdPerTrolley = new JSlider();
		slProdPerTrolley.setMinorTickSpacing(10);
		slProdPerTrolley.setMajorTickSpacing(50);
		slProdPerTrolley.setPaintLabels(true);
		slProdPerTrolley.setPaintTicks(true);
		slProdPerTrolley.setMaximum(200);
		
		JLabel lbScanTime = new JLabel("Scan Time");
		
		JSlider slScanTime = new JSlider();
		slScanTime.setMaximum(6);
		GroupLayout gl_parameters = new GroupLayout(parameters);
		gl_parameters.setHorizontalGroup(
			gl_parameters.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_parameters.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_parameters.createParallelGroup(Alignment.LEADING)
						.addComponent(lbProdPerTrolley)
						.addComponent(lbScanTime))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(gl_parameters.createParallelGroup(Alignment.LEADING, false)
						.addComponent(slScanTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(slProdPerTrolley, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_parameters.setVerticalGroup(
			gl_parameters.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_parameters.createSequentialGroup()
					.addGroup(gl_parameters.createParallelGroup(Alignment.LEADING)
						.addComponent(slProdPerTrolley, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbProdPerTrolley))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_parameters.createParallelGroup(Alignment.LEADING)
						.addComponent(slScanTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbScanTime))
					.addContainerGap(118, Short.MAX_VALUE))
		);
		parameters.setLayout(gl_parameters);
	}
}
