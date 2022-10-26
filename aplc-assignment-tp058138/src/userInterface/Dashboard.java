package userInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;


public class Dashboard {

	private JFrame frmRegistration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frmRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistration = new JFrame();
		frmRegistration.setTitle("Vaccination Record and Vaccine Program Registration");
//		frame.setBounds(100, 100, 450, 300);
		frmRegistration.setBounds(500, 500, 500, 500);
		frmRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistration.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Vaccination Record and Vaccine Program Registration");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Vaccination Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisplayVaxMalaysia();
				frmRegistration.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Vaccination Registration Record");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisplayVaxRegMalaysia();
				frmRegistration.dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Fully Vaccinated People By State");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisplayFullVaxByState();
				frmRegistration.dispose();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Fully Vaccinated People By Month");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisplayFullVaxByMonth();
				frmRegistration.dispose();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Highest/Lowest Weekly Adolescent and Children Vaccination");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisplayWeeklyHighLowVax();
				frmRegistration.dispose();
			}
		});
		
		JButton btnNewButton_5 = new JButton("Weekly Vaccination of Vaccine Type");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisplayWeeklyVaccineTypeAmount();
				frmRegistration.dispose();
			}
		});
		
		JButton btnNewButton_6 = new JButton("Total Vaccination Registration by State");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new DisplayTotalVaxRegState();
				frmRegistration.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmRegistration.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_6)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_1)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_2))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(19)
					.addComponent(btnNewButton_2)
					.addGap(18)
					.addComponent(btnNewButton_3)
					.addGap(18)
					.addComponent(btnNewButton_4)
					.addGap(18)
					.addComponent(btnNewButton_5)
					.addGap(18)
					.addComponent(btnNewButton_6)
					.addContainerGap(144, Short.MAX_VALUE))
		);
		frmRegistration.getContentPane().setLayout(groupLayout);
		frmRegistration.setVisible(true);
	}
}
