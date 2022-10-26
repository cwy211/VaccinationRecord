package userInterface;

import java.awt.EventQueue;
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


import javax.swing.LayoutStyle.ComponentPlacement;


public class DisplayVaxMalaysia {

	private JFrame frmMalaysiaVaccinationRecord;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayVaxMalaysia window = new DisplayVaxMalaysia();
					window.frmMalaysiaVaccinationRecord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayVaxMalaysia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMalaysiaVaccinationRecord = new JFrame();
		frmMalaysiaVaccinationRecord.setTitle("Malaysia Vaccination Record");
		frmMalaysiaVaccinationRecord.setSize(1350,500);
		frmMalaysiaVaccinationRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMalaysiaVaccinationRecord.getContentPane().setLayout(new BoxLayout(frmMalaysiaVaccinationRecord.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frmMalaysiaVaccinationRecord.getContentPane().add(panel);
        DefaultTableModel csv_data=new DefaultTableModel();
        //retrieve data
		List<VaxMalaysia> dataList=VaxMalaysia.getVaxMalaysiaList();
		//retrieve table column data
		List<String> columnList = VaxMalaysia.getColumns();
		//add table column
		columnList.stream().forEach(column->csv_data.addColumn(column));
		//add data into table rows
		dataList.stream().forEach(bean->{
			Vector<String> row=new Vector<String>();
        	row.add(bean.getDate());
        	row.add(bean.getDaily_partial());
        	row.add(bean.getDaily_full());
        	row.add(bean.getDaily_booster());
        	row.add(bean.getDaily());
        	row.add(bean.getDaily_partial_adol());
        	row.add(bean.getDaily_full_adol());
        	row.add(bean.getDaily_partial_child());
        	row.add(bean.getDaily_full_child());
        	row.add(bean.getCumul_partial());
        	row.add(bean.getCumul_full());
        	row.add(bean.getCumul_booster());
        	row.add(bean.getCumul());
        	row.add(bean.getCumul_partial_adol());
        	row.add(bean.getCumul_full_adol());
        	row.add(bean.getCumul_partial_child());
        	row.add(bean.getCumul_full_child());
        	row.add(bean.getPfizer1());
        	row.add(bean.getPfizer2());
        	row.add(bean.getPfizer3());
        	row.add(bean.getSinovac1());
        	row.add(bean.getSinovac2());
        	row.add(bean.getSinovac3());
        	row.add(bean.getAstra1());
        	row.add(bean.getAstra2());
        	row.add(bean.getAstra3());
        	row.add(bean.getSinopharm1());
        	row.add(bean.getSinopharm2());
        	row.add(bean.getSinopharm3());
        	row.add(bean.getCansino());
        	row.add(bean.getCansino3());
        	row.add(bean.getPending1());
        	row.add(bean.getPending2());
        	row.add(bean.getPending3());
            csv_data.addRow(row);
		});

        table = new JTable();
		table.setModel(csv_data);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);

        String title="Malaysia Vaccination Record";
		
		panel_1 = new JPanel();
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard();
				frmMalaysiaVaccinationRecord.dispose();
			}
		});
		
		
		lblNewLabel = new JLabel(title);
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
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(75)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		
		frmMalaysiaVaccinationRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMalaysiaVaccinationRecord.setVisible(true);
	}

}
