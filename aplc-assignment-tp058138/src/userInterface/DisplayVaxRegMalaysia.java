package userInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import beans.VaxRegMalaysia;



public class DisplayVaxRegMalaysia {

	private JFrame frmMalaysiaVaccinationRegistration;
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
					DisplayVaxRegMalaysia window = new DisplayVaxRegMalaysia();
					window.frmMalaysiaVaccinationRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayVaxRegMalaysia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMalaysiaVaccinationRegistration = new JFrame();
		frmMalaysiaVaccinationRegistration.setTitle("Malaysia Vaccination Registration Record");
		frmMalaysiaVaccinationRegistration.setSize(1350,500);
		frmMalaysiaVaccinationRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMalaysiaVaccinationRegistration.getContentPane().setLayout(new BoxLayout(frmMalaysiaVaccinationRegistration.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frmMalaysiaVaccinationRegistration.getContentPane().add(panel);
        DefaultTableModel csv_data=new DefaultTableModel();
        
        //retrieve data
		List<VaxRegMalaysia> dataList=VaxRegMalaysia.getVaxRegMalaysiaList();
		List<String> columnList = VaxRegMalaysia.getColumns();
		
		//populate columns with data
		columnList.stream().forEach(column->csv_data.addColumn(column));
		
		//populate rows with data
		dataList.stream().forEach(bean->{
			Vector<String> row=new Vector<String>();
        	row.add(bean.getDate());
        	row.add(bean.getState());
        	row.add(bean.getTotal());
        	row.add(bean.getPhase2());
        	row.add(bean.getMysj());
        	row.add(bean.getCall());
        	row.add(bean.getWeb());
        	row.add(bean.getChildren());
        	row.add(bean.getChildren_solo());
        	row.add(bean.getAdolescents());
        	row.add(bean.getElderly());
        	row.add(bean.getComorb());
        	row.add(bean.getOku());
            csv_data.addRow(row);
		});
		
        table = new JTable();
		table.setModel(csv_data);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);

        String title="Malaysia Vaccination Registration Record";
		
		panel_1 = new JPanel();
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard();
				frmMalaysiaVaccinationRegistration.dispose();
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
					.addComponent(btnNewButton)
					.addContainerGap(1059, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
					.addGap(70))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		
		frmMalaysiaVaccinationRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMalaysiaVaccinationRegistration.setVisible(true);
	}
	

}
