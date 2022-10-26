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

import controller.TotalVaxRegState;
import plWriter.GeneratePL;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DisplayTotalVaxRegState {

	private JFrame frmTotalVaccinationRegistration;
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
	public DisplayTotalVaxRegState() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frmTotalVaccinationRegistration = new JFrame();
		frmTotalVaccinationRegistration.setTitle("Total Vaccination Registration by State");
		frmTotalVaccinationRegistration.setSize(1350,500);
		frmTotalVaccinationRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTotalVaccinationRegistration.getContentPane().setLayout(new BoxLayout(frmTotalVaccinationRegistration.getContentPane(), BoxLayout.X_AXIS));
		
		GeneratePL.createPL();
		JPanel panel = new JPanel();
		frmTotalVaccinationRegistration.getContentPane().add(panel);
        DefaultTableModel csv_data=new DefaultTableModel();
        csv_data.addColumn("State");
        csv_data.addColumn("Total Vaccination Registration");		
        
		List<String> stateTotalList=TotalVaxRegState.getResult();
		stateTotalList.stream().forEach(elem->{
			String[] stateTotal = elem.split(", ");
			Vector<String> row=new Vector<String>();
	        row.add(stateTotal[0]);
	        row.add(stateTotal[1]);
	    	csv_data.addRow(row);
		});
		
		
		Vector<String> row=new Vector<String>();
		row.add("Sum");
        row.add(TotalVaxRegState.getSum());
    	csv_data.addRow(row);
    	

		

        table = new JTable();
		table.setModel(csv_data);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);

		
		panel_1 = new JPanel();
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard();
				frmTotalVaccinationRegistration.dispose();
			}
		});
		
		
		lblNewLabel = new JLabel("Total Vaccination Registration by State");
		
		JButton btnNewButton_1 = new JButton("Ascending Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel csv_data_asc=(DefaultTableModel)table.getModel();
				csv_data_asc.setRowCount(0);
				List<String> stateTotalList=TotalVaxRegState.getAscendingResult();
				stateTotalList.stream().forEach(elem->{
					String[] stateTotal = elem.split(", ");
					Vector<String> row=new Vector<String>();
			        row.add(stateTotal[0]);
			        row.add(stateTotal[1]);
			        csv_data_asc.addRow(row);
				});
				row.add("Sum");
		        row.add(TotalVaxRegState.getSum());
		        csv_data_asc.addRow(row);
				table.setModel(csv_data_asc);
				table.repaint();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Descending Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel csv_data_asc=(DefaultTableModel)table.getModel();
				csv_data_asc.setRowCount(0);
				List<String> stateTotalList=TotalVaxRegState.getDescendingResult();
				stateTotalList.stream().forEach(elem->{
					String[] stateTotal = elem.split(", ");
					Vector<String> row=new Vector<String>();
			        row.add(stateTotal[0]);
			        row.add(stateTotal[1]);
			        csv_data_asc.addRow(row);
				});
				row.add("Sum");
		        row.add(TotalVaxRegState.getSum());
		        csv_data_asc.addRow(row);
				table.setModel(csv_data_asc);
				table.repaint();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
					.addGap(45))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(75)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 611, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		
		
		frmTotalVaccinationRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmTotalVaccinationRegistration.setVisible(true);
	}
}
