import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewFrame extends JFrame {

	private JPanel contentPane;
	public JButton btnView;
	public JTextField afm;
	

	private String txtAfm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFrame frame = new ViewFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewFrame() {
	 
		setBounds(100, 100, 264, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		afm = new JTextField();
		afm.setColumns(10);
		afm.setBounds(94, 38, 112, 23);
		contentPane.add(afm);

		btnView = new JButton("\u03A0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE");
		btnView.setBounds(94, 86, 89, 23);
		contentPane.add(btnView);

		JLabel label = new JLabel("\u0391\u03A6\u039C:");
		label.setBounds(51, 42, 46, 14);
		contentPane.add(label);
	}
	/*
	 * public String getAfm(){ return this.afm.getText(); }
	 */
}
