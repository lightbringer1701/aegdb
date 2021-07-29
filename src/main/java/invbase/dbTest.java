package invbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbTest {
	
	private static Connection conn = null;
	private static Statement stat = null;

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:invbase.db");
			stat = conn.createStatement();
			//insertSample();

			
			ResultSet rs = stat.executeQuery( "SELECT name FROM sqlite_master WHERE type='table';" );
			while ( rs.next() ) {
				System.out.println(rs.getString("name"));
			} 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*
	private static void insertSample() {
		String sql = "INSERT INTO SAMPLES (ACCENUMB, COUNTRY, ACCENAME, YEAR, HEIGHT, DATEM, DATED, STAB1, STAB2, STAB3) "
				+ "VALUES (201, 'Russia', 'Ae Tau', 2015, 55, 5, 4, 9, 9, 9);";
		try {
			stat.executeUpdate(sql);
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void createTable() {
		String sql = "CREATE TABLE SAMPLES ("
				+ "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "ACCENUMB INT, "
				+ "COUNTRY TEXT, "
				+ "ACCENAME TEXT, "
				+ "YEAR INT, "
				+ "HEIGHT INT, "
				+ "DATEM INT, "
				+ "DATED INT, "
				+ "STAB1 INT, "
				+ "STAB2 INT, "
				+ "STAB3 INT"
				+ ");";
		try {
			stat.executeUpdate(sql);
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
*/
}
