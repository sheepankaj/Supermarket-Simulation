package simulator.demos;

import simulator.ui.SimulatorUI;

import javax.swing.*;
import java.awt.*;

public class Demo
{

        public static void main(String[] args) {
            JFrame frame = new JFrame("SimulatorUI");
            SimulatorUI ui = new SimulatorUI();
            JPanel panel = ui.getMainPanel();
            panel.setPreferredSize(new Dimension(1200,650));
            frame.setContentPane(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }

}
