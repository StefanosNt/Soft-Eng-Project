import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class UpdateInfoFrame extends JFrame {

	private JPanel contentPane;
	public	JButton btnUpdate;
	public JComboBox comboBox;
	public JTextField afm;
	public JTextField fieldUpd;
	private JLabel afmLbl;
	private JLabel fieldLbl;
	private JLabel updateLbl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateInfoFrame frame = new UpdateInfoFrame();
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
	public UpdateInfoFrame() {
		 
		setBounds(100, 100, 283, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[] categ = { "surname", "name", "birthdate","afm","address","phone" };

		comboBox = new JComboBox(categ);
		comboBox.setBounds(26, 55, 120, 20);
		comboBox.setSelectedItem(null);
		contentPane.add(comboBox);
		 
		
		
		afm = new JTextField();
		afm.setBounds(26, 118, 86, 20);
		contentPane.add(afm);
		afm.setColumns(10);

		fieldUpd = new JTextField();
		fieldUpd.setBounds(26, 183, 86, 20);
		contentPane.add(fieldUpd);
		fieldUpd.setColumns(10);
		
		btnUpdate = new JButton("\u0395\u03BD\u03B7\u03BC\u03AD\u03C1\u03C9\u03C3\u03B7");
		btnUpdate.setBounds(50, 226, 120, 38);
		contentPane.add(btnUpdate);



		afmLbl = new JLabel("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u03B1\u03C3\u03B8\u03B5\u03BD\u03BF\u03CD\u03C2 \u03BC\u03AD\u03C3\u03C9 \u0391\u03A6\u039C");
		afmLbl.setBounds(26, 86, 250, 25);
		contentPane.add(afmLbl);
		
		updateLbl = new JLabel("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u03B4\u03B5\u03B4\u03BF\u03BC\u03AD\u03BD\u03BF\u03C5 \u03C0\u03C1\u03BF\u03C2 \u03B1\u03BD\u03B1\u03BD\u03AD\u03C9\u03C3\u03B7");
		updateLbl.setBounds(26, 149, 250, 25);
		contentPane.add(updateLbl);
		
		
		
		fieldLbl = new JLabel("\u0395\u03C0\u03B9\u03BB\u03BF\u03B3\u03AE \u03C0\u03B5\u03B4\u03AF\u03BF\u03C5 \u03C0\u03C1\u03CC\u03C2 \u03B1\u03BB\u03BB\u03B1\u03B3\u03AE");
		fieldLbl.setBounds(26, 25, 226, 25);
		contentPane.add(fieldLbl);
		
		
		
		
		
		
	}
}
