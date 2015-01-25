import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;

public class Form {

	private JFrame Frame;
	
	private JButton LogInBtn;
	private JButton ExitBtn;
	private JLabel nameLabel;
	private JLabel passLabel;
	private JComboBox CategoryCB;
	private JTextField PasswordTxt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Form() {
		initialize();
	}
	private void initialize() {

		Frame = new JFrame();
		Frame.getContentPane().setLayout(new CardLayout(0, 0));
		Frame.setSize(312, 250);
		Frame.setLocation(600, 400);

		JPanel JForm = new JPanel();
		Frame.getContentPane().add(JForm, "name_10293113117315");
		JForm.setLayout(null);

		//Δημιουργία ενός πεδίου επιλογής για τον κάθε χρήστη της εφαρμογής

		String[] categ = { "Secretary", "Nurse", "Doctor" };
		
		CategoryCB = new JComboBox(categ);
		CategoryCB.setBounds(117, 51, 132, 20);
		CategoryCB.setSelectedIndex(0);
		JForm.add(CategoryCB);

		nameLabel = new JLabel("User");
		nameLabel.setBounds(70, 53, 63, 17);
		JForm.add(nameLabel);

		//Δημιουργία του πεδίου για το κωδικό πρόσβασης 
		
		PasswordTxt = new JPasswordField();
		PasswordTxt.setBounds(117, 82, 132, 23);
		JForm.add(PasswordTxt);

		passLabel = new JLabel("Password");
		passLabel.setBounds(44, 87, 63, 14);
		JForm.add(passLabel);

		//Μόλις πατηθεί το κουμπί Log In θα γίνει έλεγχος των στοιχείων.Ανάλογα με τήν ιδιότητα του κάθε χρήστη(Γιατρός,Νοσοκόμος,Γραμματεία)
		//θα εμφάνιστει μπροστά του το αντίστοιχο περιβαλλόν με τις λειτουργίες που μπορεί να εκτελέσει ο κάθε ενας απο αυτούς
		
		LogInBtn = new JButton("Log In");
		LogInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DB.conn(); //Connect to the database when login gets clicked
				
				String CategoryName = String.valueOf(CategoryCB.getSelectedItem());
				String CategoryPass = PasswordTxt.getText();

				String secstr = "1111";
				String nurstr = "2222";
				String docstr = "3333";

				if (secstr.equals(CategoryPass) && CategoryName == "Secretary") {
					
					Secretary sec = new Secretary();
					sec.setVisible(true);			
					Frame.setVisible(false);
					
				}
				if (docstr.equals(CategoryPass) && CategoryName == "Doctor") {
					
					Doctor doc = new Doctor();
					doc.setVisible(true);
					Frame.setVisible(false);

				}

				if (nurstr.equals(CategoryPass) && CategoryName == "Nurse") {
					
					Nurse nur = new Nurse();
					nur.setVisible(true);
					Frame.setVisible(false);
				}
			}
		});
		
		LogInBtn.setBounds(44, 133, 89, 23);
		JForm.add(LogInBtn);

		//Έξοδος απο την εφαρμογή
		ExitBtn = new JButton("Exit");
		ExitBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		ExitBtn.setBounds(162, 133, 89, 23);
		JForm.add(ExitBtn);
		
		
	}
}