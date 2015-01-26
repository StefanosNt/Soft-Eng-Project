import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class Nurse extends JFrame {

	private JPanel contentPane;
	private JButton btnClear;
	private JButton btnView;
	private JButton btnSearch;  
	private JTextArea textArea;
	private int i = 0 ;
	 
	public Nurse() {
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
