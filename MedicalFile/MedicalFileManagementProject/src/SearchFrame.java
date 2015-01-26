import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchFrame extends JFrame{

	private JPanel contentPane;
	private JLabel label_1;
	public JTextField year;
	public JTextField afm;
	public JButton btnSearch; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFrame frame = new SearchFrame();
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
	public SearchFrame() {
		 
		setBounds(100, 100, 249, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		year = new JTextField();
		year.setBounds(114, 60, 86, 20);
		contentPane.add(year);
		year.setColumns(10);

		JLabel label = new JLabel("\u03A7\u03C1\u03BF\u03BD\u03BF\u03BB\u03BF\u03B3\u03AF\u03B1:");
		label.setBounds(39, 60, 74, 20);
		contentPane.add(label);
		
		afm = new JTextField();
		afm.setBounds(114, 29, 86, 20);
		contentPane.add(afm);
		afm.setColumns(10);

		label_1 = new JLabel("\u0391\u03A6\u039C:");
		label_1.setBounds(58, 32, 46, 14);
		contentPane.add(label_1);

		btnSearch = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		btnSearch.setBounds(71, 103, 89, 23);
		contentPane.add(btnSearch);
	}
	
}
