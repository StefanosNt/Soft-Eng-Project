
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AddExamsFrame extends JFrame {

	public JButton btnAdd;
	public JTextField pee;
	public JTextField blood;
	public JTextField year;
	public JTextField afm;
	private JLabel peeLbl;
	private JLabel yearLbl;
	private JLabel bloodLbl;
	private JLabel afmLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddExamsFrame frame = new AddExamsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddExamsFrame() {
		 
		setBounds(100, 100, 266, 250);
		getContentPane().setLayout(null);

		pee = new JTextField();
		pee.setBounds(111, 30, 86, 20);
		getContentPane().add(pee);
		pee.setColumns(10);

		blood = new JTextField();
		blood.setBounds(111, 61, 86, 20);
		getContentPane().add(blood);
		blood.setColumns(10);

		year = new JTextField();
		year.setBounds(110, 92, 86, 20);
		getContentPane().add(year);
		year.setColumns(10);

		peeLbl = new JLabel("\u039F\u03CD\u03C1\u03B1 :");
		peeLbl.setBounds(55, 33, 46, 14);
		getContentPane().add(peeLbl);

		bloodLbl = new JLabel("\u0391\u03B9\u03BC/\u03BA\u03AD\u03C2 :");
		bloodLbl.setBounds(44, 64, 46, 14);
		getContentPane().add(bloodLbl);

		yearLbl = new JLabel("\u03A7\u03C1\u03BF\u03BD\u03BF\u03BB\u03BF\u03B3\u03AF\u03B1 :");
		yearLbl.setBounds(24, 95, 65, 14);
		getContentPane().add(yearLbl);

		btnAdd = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		btnAdd.setBounds(76, 166, 89, 23);
		getContentPane().add(btnAdd);
		
		afm = new JTextField();
		afm.setBounds(111, 123, 86, 20);
		getContentPane().add(afm);
		afm.setColumns(10);
		
		afmLbl = new JLabel("\u0391\u03A6\u039C :");
		afmLbl.setBounds(55, 126, 46, 14);
		getContentPane().add(afmLbl);
	}
}
