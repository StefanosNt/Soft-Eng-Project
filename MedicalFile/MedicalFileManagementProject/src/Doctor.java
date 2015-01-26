import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class Doctor extends JFrame {

	private JPanel contentPane;
	 
	private JButton btnView;
	private JButton btnSearch; 
	private JButton btnUpdate;
	private JButton btnClear;
	private	JTextArea textArea;
	private int i = 0 ;
 
	public Doctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		setBounds(100, 100,636, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textArea = new JTextArea();
		textArea.setBounds(10, 11, 600, 350);
		contentPane.add(textArea);
		textArea.setEditable(false);
		textArea.setText("");
	 
		
		
		btnView = new JButton("View");
		btnView.setBounds(156, 414, 98, 54);
		contentPane.add(btnView);

		//Μόλις πατήθει το κουμπί View θα εκτέλεστεί η λειτουργία προβολής των στοιχείων τού ασθένους προς αναζήτηση
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Δημιουργία παραθύρου για τήν εισαγωγή του Α.Φ.Μ του ασθενούς 
				ViewFrame vFrame = new ViewFrame();
				vFrame.setVisible(true);
				
				//Καθώς πατηθεί το κουμπί "Προβολή" τα στοιχεία μεταφέρονται στή συνάρτηση που είναι υπεύθυνη για την προβολή των στοιχείων του ασθενούς
				vFrame.btnView.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						DB.viewString = "" ;
						DB.view(vFrame.afm.getText());
						
						//Σε περίπτωση επιτυχίας εμφανίζονται τα στοιχεία του.Σε αντίθετη περίπτωση εμφανίζεται μήνυμα λάθους
						if( DB.flag == 1){
							textArea.append(DB.viewString+"\n");
						}
						else{
							textArea.append("Το ΑΦΜ που εισάγατε δεν υπάρχει.Προσπαθήστε ξανά \n");
						}
						
							
						
					}
				});
				
			}
		});
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(264, 414, 98, 54);
		contentPane.add(btnSearch);
		
		//Μόλις πατήθει το κουμπί Search θα εκτέλεστεί η λειτουργία αναζήτησης εξετάσεων ενός ασθένους
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Δημιουργία παραθύρου για τήν εισαγωγή του Α.Φ.Μ του ασθενούς και τη χρονολογία εξέτασης 
				SearchFrame srFrame = new SearchFrame();
				srFrame.setVisible(true);
				
				//Καθώς πατηθεί το κουμπί "Αναζήτηση" τα στοιχεία μεταφέρονται στή συνάρτηση που είναι υπεύθυνη για την εμφάνιση των εξετάσεων
					srFrame.btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						DB.viewString="";
						DB.view(srFrame.afm.getText());
						textArea.append(DB.viewString+"\n\n");
						
						DB.search(srFrame.afm.getText(),srFrame.year.getText());
						
						//Σε περίπτωση επιτυχίας εμφανίζονται οι εξετάσεις.Σε αντίθετη περίπτωση εμφανίζεται μήνυμα λάθους
						if( DB.flag == 1){
							while(i<DB.i){
								textArea.append(DB.str[i]+"\n");
								i++;
							} 
						}
						else{
							textArea.append("Η αναζήτηση δέν ήταν επιτυχής.Προσπαθήστε ξανά \n");
						}  
						 
					}
				});
				 
			}
		});

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(480, 414, 98, 54);
		contentPane.add(btnUpdate);
		
		//Μόλις πατήθει το κουμπί Update θα εκτέλεστεί η λειτουργία επεξεργασίας κάποιου στοιχείου ενός ασθενή 
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Δημιουργία παραθύρου για τήν εισαγωγή αιματολογίκων και ουρολογικών εξετάσεων καθώς και η χρονολογία διεξαγωγής τους
				AddExamsFrame addExams = new AddExamsFrame();
				addExams.setVisible(true);
				//Καθώς πατηθεί το κουμπί "Προσθήκη" τα στοιχεία μεταφέρονται στή συνάρτηση που είναι υπεύθυνη για την προσθήκη των εξετάσεων
				addExams.btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						DB.updateExams(addExams.afm.getText() , addExams.blood.getText(),addExams.pee.getText(),addExams.year.getText());
						
						//Σε περίπτωση επιτυχίας εμφανίζονται τα στοιχεία του.Σε αντίθετη περίπτωση εμφανίζεται μήνυμα λάθους
						if( DB.flag == 1){
							textArea.append("Η προσθήκη εξετάσεων ήταν επιτυχής \n");
						}
						else{
							textArea.append("Η προσθήκη εξετάσεων δεν ήταν επιτυχής.Προσπαθήστε ξανά \n");
						}
					}
				});
			}
		});
		
		
		  //Μόλις πατηθεί το κουμπί Clear θα γίνει καθάρισμός τών δεδομένων που έχουν απεικονιστεί
		  btnClear = new JButton("Clear");
		  btnClear.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent arg0) {
		    textArea.setText(null);
		   }
		  });
		  btnClear.setBounds(521, 372, 89, 23);
		  contentPane.add(btnClear);
		
	}

}
