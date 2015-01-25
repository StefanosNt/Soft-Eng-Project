import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB { 
	
	public static String viewString ;					//Μεταβλητή για την ανάθεση αποτελεσμάτων μετά από queries
	public static String [] str = new String[20];		//Πίνακας με δεδομένα μετά απο queries που επιστρέφουν πολλαπλές καταχωρήσεις
	public static int i = 0;							//Counter
	public static int flag;								//Μεταβλητή για τον προσδιορισμό επιτυχίας (ή μη) τών λειτουργιών 
														//Σε περίπτωση επιτυχής λειτουργίας ανατίθεται η τιμη 1.Σε αντίθετη περίπτωση flag=0
	public static Connection conn = null;				
	
	public static int conn() {							
		//Σύνδεση με τη βάση δεδομένων		
		
		flag=1;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String connection = "jdbc:mysql://localhost:3306/kliniki";
			String user = "root";
			String pass = "root";

			conn = DriverManager.getConnection(connection, user, pass);

		} catch (Exception e) {
			flag=0;								
			e.printStackTrace();
		}
		return flag;
	}
	public static int create(String name, String surname, String birthdate,String afm, String address, String phone){
		//Συνάρτηση η οποία δημιουργεί μια καταχώρηση στον πίνακα των ασθενών
		
		flag =1;
		PreparedStatement ps = null;
		
		try {
			//Δημιουργία του αντίστοιχου query για την προσθήκη τών στοιχείων του ασθενούς στον αντίστοιχο πινακα
			
			ps = conn.prepareStatement("insert into patients values (?,?,?,?,?,?)");
			ps.setString(1, surname);  
			ps.setString(2, name);
			ps.setString(3, birthdate);
			ps.setString(4, afm);
			ps.setString(5, address);
			ps.setString(6, phone); 
			ps.executeUpdate();
			
			//Μαζί με τη καταχώρηση του ασθενούς στη βάση δημιουργείται και ένας καινούργιος μοναδικός πίνακας για τον καθένα,
			//του οποίου το περιεχόμενο θα είναι οι αιματολογικές και ουρολογικές εξέτασεις του εκάστοτε ασθενή ανα χρονική περίοδο
			
			ps=conn.prepareStatement("create table id"+afm+"(bloodExams varchar(2),PeeExams varchar(2),year varchar(5));");
			ps.executeUpdate();

		} catch (Exception e) {
			flag = 0;
			e.printStackTrace();
		}
		return flag;
	}
	public static String[] search(String afm,String year){
		//Συνάρτηση για τη αναζήτηση εξετάσεων με βάση το προσδιορίστικο στοιχείο του κάθε ασθενη (το Α.Φ.Μ του)
 		
		flag =1;
		String newafm = "id"+afm;
		PreparedStatement ps = null;
		ResultSet rs;
		try {
			//Αν το πεδίο "Χρονολογία" κατά την αναζήτηση είναι κενό τότε στην οθόνη θα εμφανιστούν όλες οι εξετάσεις του ασθενή 
			if(year.equals("")){
				
				ps=conn.prepareStatement("select * from "+newafm+";");
				rs=ps.executeQuery();
				
			//Σε αντίθετη περίπτωση θα εμφανιστούν όσες εξετάσεις έχουν γίνει τη συγκεκριμένη χρονολογία	
			}else{
				
				ps = conn.prepareStatement("select * from "+newafm+" where year="+year+";");
				rs = ps.executeQuery();
					
			}
			
			while(rs.next()){
				String bloodexams = rs.getString("bloodExams");
		        String peeexams = rs.getString("peeExams");
		        String year1= rs.getString("year");
		         
		        str[i] =bloodexams+"  "+peeexams+"  "+year1;
		        i++; 
		        
			}
		}catch (Exception e){
			flag = 0;
			e.printStackTrace();
		} 
		return str; //Επιστροφή των αποτελεσμάτων 
		
	}
	public static String view(String afm){
		//Συνάρτηση για την προβολή των στοιχείων ενός ασθενή με βάση το μοναδικό του προσδιοριστικό (Α.Φ.Μ)
		
		flag=1; 
		PreparedStatement ps = null;
		ResultSet rs;
		try {
			ps = conn.prepareStatement("select * from patients where afm="+afm+";");			
			rs = ps.executeQuery();
			
			boolean val = rs.next();
			if(val==false){
				flag=0;
			}
			while(val){
				
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String birthdate = rs.getString("birthdate");
				String afm1 = rs.getString("afm");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				
				viewString =surname+"  "+name+"  "+birthdate+"  "+afm1+"  "+address+"  "+phone;
				
				val=rs.next();
			}
			

			 
		}catch (Exception e){
			flag = 0;
			e.printStackTrace();
		}
		return viewString;	//Επιστροφή της καταχώρησης για την οποία εγινε η αναζήτηση
		
	}
	public static int editPatients(String afm,String updField,String updVal) {
		//Συνάρτηση για την επεξεργασία κάποιου στοιχείου ενός ασθενή 
		
		flag =1;
		PreparedStatement ps = null;

		try {

			ps = conn.prepareStatement("update patients set "+updField+"=? where afm=?;" );
			ps.setString(1,updVal);
			ps.setString(2, afm);
			
			ps.executeUpdate();

		} catch (Exception e) {
			flag = 0;
			e.printStackTrace();
		}
		return flag;
	}
	public static int updateExams(String afm,String bloodExams,String PeeExams,String year){
		//Συνάρτηση για την πρσθήκη καταχώρησης στον πίνακα εξετάσεων του εκάστοτε ασθενη
		
		flag =1;
		PreparedStatement ps = null;
		try {

			ps = conn.prepareStatement("insert into id"+afm+" values (?,?,?)");
			ps.setString(1, bloodExams);
			ps.setString(2, PeeExams);
			ps.setString(3, year);
			ps.executeUpdate();

		} catch (Exception e) {
			flag = 0;
			e.printStackTrace();
		}
		return flag;
		
		
	}
	
}
