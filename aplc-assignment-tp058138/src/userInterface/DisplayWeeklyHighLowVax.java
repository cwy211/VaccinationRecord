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
import controller.WeeklyHighLowVax;

public class DisplayWeeklyHighLowVax {

	private JFrame frmHighestlowestWeeklyAdolescent;
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
	public DisplayWeeklyHighLowVax() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */


	
	private void initialize() {
		frmHighestlowestWeeklyAdolescent = new JFrame();
		frmHighestlowestWeeklyAdolescent.setTitle("Highest/Lowest Weekly Adolescent and Children Vaccination");
		frmHighestlowestWeeklyAdolescent.setSize(1350,500);
		frmHighestlowestWeeklyAdolescent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHighestlowestWeeklyAdolescent.getContentPane().setLayout(new BoxLayout(frmHighestlowestWeeklyAdolescent.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frmHighestlowestWeeklyAdolescent.getContentPane().add(panel);
        DefaultTableModel csv_data=new DefaultTableModel();

		csv_data.addColumn("Week");
		csv_data.addColumn("Highest Vaccination for Adolescent");
		csv_data.addColumn("Lowest Vaccination for Adolescent");
		csv_data.addColumn("Highest Vaccination for Children");
		csv_data.addColumn("Lowest Vaccination for Children");
		
		List<VaxMalaysia> dataList=VaxMalaysia.getVaxMalaysiaList();
		List<String> uniqueWeekYearList = WeeklyHighLowVax.getUniqueWeekYearList(dataList);
		uniqueWeekYearList.stream().forEach(weekyear->{
			Vector<String> row=new Vector<String>();
		
			row.add(weekyear);
			List<Integer> result = WeeklyHighLowVax.getResult(dataList,weekyear);
			result.stream().forEach(elem->row.add(elem.toString()));
			csv_data.addRow(row);
		
		});

        table = new JTable();
		table.setModel(csv_data);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);

		
		panel_1 = new JPanel();
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard();
				frmHighestlowestWeeklyAdolescent.dispose();
			}
		});
		
		
		lblNewLabel = new JLabel("Highest/Lowest Weekly Adolescent and Children Vaccination");
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
		
		
		frmHighestlowestWeeklyAdolescent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmHighestlowestWeeklyAdolescent.setVisible(true);
	}

}
