package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;


import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import beans.VaxMalaysia;
import controller.FullVaxByMonth;


public class DisplayFullVaxByMonth {

	private JFrame frmFullyVaccinatedPeople;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JPanel panel_1;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public DisplayFullVaxByMonth() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */

	
	private void initialize() {
		frmFullyVaccinatedPeople = new JFrame();
		frmFullyVaccinatedPeople.setTitle("Fully Vaccinated People By Month");
		frmFullyVaccinatedPeople.setSize(1350,500);
		frmFullyVaccinatedPeople.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFullyVaccinatedPeople.getContentPane().setLayout(new BoxLayout(frmFullyVaccinatedPeople.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frmFullyVaccinatedPeople.getContentPane().add(panel);
        DefaultTableModel csv_data=new DefaultTableModel();

        List<VaxMalaysia> dataList=VaxMalaysia.getVaxMalaysiaList();
		
		//add table column
		csv_data.addColumn("Month");
		csv_data.addColumn("Fully Vaccinated People");
		
			List<String> monthYearList = FullVaxByMonth.getMonthYearList(dataList);
			monthYearList.stream().forEach(monthyear->{
				Vector<String> row=new Vector<String>();
				row.add(monthyear);
				row.add(FullVaxByMonth.searchByMonth(dataList,monthyear));
				csv_data.addRow(row);
			});
			
			

			

		//create table and add data
        table = new JTable();
		table.setModel(csv_data);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		
		panel_1 = new JPanel();
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard();
				frmFullyVaccinatedPeople.dispose();
			}
		});
		
		
		lblNewLabel = new JLabel("Fully Vaccinated People By Month");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel)
					.addGap(31)
					.addComponent(btnNewButton))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addComponent(btnNewButton))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(75)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		
		
		frmFullyVaccinatedPeople.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmFullyVaccinatedPeople.setVisible(true);
	}
	

}
