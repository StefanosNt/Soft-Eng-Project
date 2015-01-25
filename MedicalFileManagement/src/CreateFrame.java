import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class CreateFrame extends JFrame {

	private JPanel contentPane;
	public JButton btnAdd;
	public JTextField name;
	public JTextField surName;
	public JTextField birthDate;
	public JTextField afm;
	public JTextField phone;
	public JTextField address;
	private JLabel surNameLbl;
	private JLabel birthDateLbl;
	private JLabel afmLbl;
	private JLabel addressLbl;
	private JLabel phoneLbl;
	private JLabel nameLbl;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateFrame frame = new CreateFrame();
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
	public CreateFrame() {
		 
		setBounds(100, 100, 306, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAdd = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		btnAdd.setBounds(89, 215, 120, 38);
		contentPane.add(btnAdd);

		name = new JTextField();
		name.setBounds(123, 24, 86, 20);
		contentPane.add(name);
		name.setColumns(10);

		surName = new JTextField();
		surName.setBounds(123, 55, 86, 20);
		contentPane.add(surName);
		surName.setColumns(10);

		birthDate = new JTextField();
		birthDate.setBounds(123, 86, 86, 20);
		contentPane.add(birthDate);
		birthDate.setColumns(10);

		nameLbl = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		nameLbl.setBounds(40, 30, 46, 14);
		contentPane.add(nameLbl);

		surNameLbl = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF");
		surNameLbl.setBounds(40, 61, 46, 14);
		contentPane.add(surNameLbl);

		birthDateLbl = new JLabel(
				"\u0397\u03BC. \u0393\u03AD\u03BD\u03BD\u03B7\u03C3\u03B7\u03C2");
		birthDateLbl.setBounds(40, 92, 88, 14);
		contentPane.add(birthDateLbl);

		afm = new JTextField();
		afm.setBounds(123, 117, 86, 20);
		contentPane.add(afm);
		afm.setColumns(10);

		afmLbl = new JLabel("\u0391\u03A6\u039C");
		afmLbl.setBounds(40, 123, 46, 14);
		contentPane.add(afmLbl);

		phone = new JTextField();
		phone.setBounds(123, 176, 86, 20);
		contentPane.add(phone);
		phone.setColumns(10);

		addressLbl = new JLabel("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7");
		addressLbl.setBounds(40, 151, 73, 14);
		contentPane.add(addressLbl);

		address = new JTextField();
		address.setBounds(123, 148, 86, 20);
		contentPane.add(address);
		address.setColumns(10);

		phoneLbl = new JLabel("\u03A4\u03B7\u03BB\u03AD\u03C6\u03C9\u03BD\u03BF");
		phoneLbl.setBounds(40, 179, 62, 14);
		contentPane.add(phoneLbl);

	}
}
