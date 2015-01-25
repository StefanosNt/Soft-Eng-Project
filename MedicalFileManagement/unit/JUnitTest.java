
import static org.junit.Assert.*;
import java.sql.PreparedStatement;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTest {

	@Before 
	public void create(){
		//Δημιουργία μιας καταχώρησης και του αντίστοιχου φακέλου εξετάσεων αυτής πρίν την διεξαγωγή του testing
		
		DB.conn(); 
		DB.create("nikos", "koukos","29/02/1995","0123456","ggfies","21021121311");
	} 
	@After 
	public void delete(){
		//Διαγραφή τών παραπάνω αφότου το testing φτάσει είς πέρας
		
		DB.conn(); 
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		
		try{
			ps1=DB.conn.prepareStatement("delete from patients where afm=0123456;");
			ps2=DB.conn.prepareStatement("drop table id0123456;");
			
			ps1.executeUpdate();
			ps2.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	} 
	@Test
	public void testConn() {
		DB.conn(); 
		assertEquals(1,DB.conn());	//Αν το flag=1 σύνδεση επιτυχείς
	}

	@Test
	public void testCreate() {
		DB.conn(); 
		assertEquals(0,DB.create("nikos", "koukos","29/02/1995","0123456","ggfies","21021121311")); //Αν flag=0 ο ασθενής υπάρχει ήδη
	}

	@Test
	public void testSearch() {
		DB.conn(); 
		assertEquals(20,DB.search("2332","2008").length); //Έλεγχος αν το μήκος του string μέ τις εξετάσεις ενός ασθενή ειναι 20 
	}

	@Test
	public void testView() {
		new  DB();
		DB.conn();
		String str="temenaros  klarino  1992  1122  11 martiou  210223333";
		assertEquals(str,DB.view("1122"));	//Έλεγχος αν το str είναι ίδιο με το επιστρεφόμενο αποτέλεσμα της συνάρτησης view τότε 
	}

	@Test
	public void testEditPatients() {
		new  DB();
		DB.conn();
		assertEquals(1,DB.editPatients("1122", "name", "klarino")); //Αν flag=1 τότε γίνεται επιτυχής ενημέρωση στοιχείων 
	}
	@Test
	public void testUpdateExams() {
		new  DB();
		DB.conn();
		assertEquals(1,DB.updateExams("1122","Y","Y","1994")); //Αν flag=1 τότε γίνεται επιτυχής προσθήκη εξετάσεων ασθενούς
	}
	
	@Test
	public void testFrames(){
		Secretary mysec = new Secretary(); 
		Doctor mydoc = new Doctor();
		Nurse mynur = new Nurse();

		//Έλεγχος αν το μήκος και το μήκος και το ύχος τών παραθύρων ειναι 560 και 636 αντίστοιχα
		
		assertEquals(560,mysec.getHeight());
		assertEquals(636,mysec.getWidth());

		assertEquals(560,mynur.getHeight());
		assertEquals(636,mynur.getWidth());
	
		assertEquals(560,mydoc.getHeight());
		assertEquals(636,mydoc.getWidth());
	}
	
}
