package invbase;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbService {
	private static Connection conn = null;
	private static Statement stat = null;
	
	dbService() {
		try {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection("jdbc:sqlite:invbase.db");
			stat = conn.createStatement();
			System.out.println("SQLite connect");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertSample(int ACCENUMB, 
			String COUNTRY, 
			String ACCENAME,
			int YEAR,
			int HEIGHT,
			int DATEM,
			int DATED,
			int STAB1,
			int STAB2,
			int STAB3) {
		String sql = "INSERT INTO SAMPLES (ACCENUMB, COUNTRY, ACCENAME, YEAR, HEIGHT, DATEM, DATED, STAB1, STAB2, STAB3) "
				+ "VALUES ("
				+ String.valueOf(ACCENUMB) + ", "
				+ "'" + COUNTRY + "', "
				+ "'" + ACCENAME + "', "
				+ String.valueOf(YEAR) + ", "
				+ String.valueOf(HEIGHT) + ", "
				+ String.valueOf(DATEM) + ", "
				+ String.valueOf(DATED) + ", "
				+ String.valueOf(STAB1) + ", "
				+ String.valueOf(STAB2) + ", "
				+ String.valueOf(STAB3)
				+ ");";
		try {
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteSample(int id) {
		String sql = "DELETE FROM SAMPLES WHERE ID=" + String.valueOf(id) +";";
		try {
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveSample(int id,
			int ACCENUMB, 
			String COUNTRY, 
			String ACCENAME,
			int YEAR,
			int HEIGHT,
			int DATEM,
			int DATED,
			int STAB1,
			int STAB2,
			int STAB3) {
		String sql = "UPDATE SAMPLES SET "
				+ "ACCENUMB=" + String.valueOf(ACCENUMB) + ", "
				+ "COUNTRY='" + COUNTRY + "', "
				+ "ACCENAME='" + ACCENAME + "', "
				+ "YEAR=" + String.valueOf(YEAR) + ", "
				+ "HEIGHT=" + String.valueOf(HEIGHT) + ", "
				+ "DATEM=" +  String.valueOf(DATEM) + ", "
				+ "DATED=" + String.valueOf(DATED) + ", "
				+ "STAB1=" + String.valueOf(STAB1) + ", "
				+ "STAB2=" + String.valueOf(STAB2) + ", "
				+ "STAB3=" + String.valueOf(STAB3) + " "
				+ "WHERE ID=" + id
				+ ";";
		try {
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeHTMLSampleEdit(PrintWriter writer, int id) {
		String sql = "SELECT * FROM SAMPLES WHERE ID=" + String.valueOf(id) +";";
		try {
			ResultSet rs = stat.executeQuery(sql);
			writer.println("<div id='editTr2'>"
					+ "<div id='editTdInf'>ACCENUMB</div>"
					+ "<div><input class='edit-row' id='EditInputACCENUMB' value='"
					+ rs.getInt("ACCENUMB") + "' /></div></div>");
			writer.println("<div id='editTr2'>"
					+ "<div id='editTdInf'>COUNTRY</div>"
					+ "<div><input class='edit-row' id='EditInputCOUNTRY' value='"
					+ rs.getString("COUNTRY") + "' /></div></div>");
			writer.println("<div id='editTr2'>"
					+ "<div id='editTdInf'>ACCENAME</div>"
					+ "<div><input class='edit-row' id='EditInputACCENAME' value='"
					+ rs.getString("ACCENAME") + "' /></div></div>");
			writer.println("<div id='editTr2'>"
					+ "<div id='editTdInf'>YEAR</div>"
					+ "<div><input class='edit-row' id='EditInputYEAR' value='"
					+ rs.getInt("YEAR") + "' /></div></div>");
			writer.println("<div id='editTr2'>"
					+ "<div id='editTdInf'>HEIGHT</div>"
					+ "<div><input class='edit-row' id='EditInputHEIGHT' value='"
					+ rs.getInt("HEIGHT") + "' /></div></div>");
			writer.println("<div id='editTr2'>"
					+ "<div id='editTdInf'>MONTH</div>"
					+ "<div><input class='edit-row' id='EditInputDATEM' value='"
					+ rs.getInt("DATEM") + "' /></div></div>");
			writer.println("<div id='editTr2'>"
					+ "<div id='editTdInf'>DAY</div>"
					+ "<div><input class='edit-row' id='EditInputDATED' value='"
					+ rs.getInt("DATED") + "' /></div></div>");
			writer.println("<div id='editTr2'>"
					+ "<div id='editTdInf'>STAB1</div>"
					+ "<div><input class='edit-row' id='EditInputSTAB1' value='"
					+ rs.getInt("STAB1") + "' /></div></div>");
			writer.println("<div id='editTr2'>"
					+ "<div id='editTdInf'>STAB2</div>"
					+ "<div><input class='edit-row' id='EditInputSTAB2' value='"
					+ rs.getInt("STAB1") + "' /></div></div>");
			writer.println("<div id='editTr2'>"
					+ "<div id='editTdInf'>STAB3</div>"
					+ "<div><input class='edit-row' id='EditInputSTAB3' value='"
					+ rs.getInt("STAB3") + "' /></div></div>");
			writer.println("<br>\r\n"
		    		+ "  		<input id='EditSaveButton' type='button' value='Save' onclick='ajaxSave(" + id + ")' />");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeHTML(PrintWriter writer, 
			boolean moderRang,
			String sortTD,
			boolean sortMOVE,
			String SearchInputACCENUMB,
			String SearchInputCOUNTRY,
			String SearchInputACCENAME,
			String SearchInputYEAR,
			String SearchInputHEIGHT,
			String SearchInputDATE,
			String SearchInputSTAB1,
			String SearchInputSTAB2,
			String SearchInputSTAB3) {
		
		String sql = "SELECT * FROM SAMPLES ";
		
		boolean haveWHERE = false;
		if(!SearchInputACCENUMB.equals("")) {
			try {
				Integer.valueOf(SearchInputACCENUMB);
				sql = sql + " WHERE (ACCENUMB=" + SearchInputACCENUMB + ")";
				haveWHERE = true;
			} catch (NumberFormatException e) {
				writer.println("Incorrect search ACCENUMB");
				return;
			}
		}
		if(!SearchInputYEAR.equals("")) {
			try {
				Integer.valueOf(SearchInputYEAR);
				if(haveWHERE == false) {
					sql = sql + " WHERE (YEAR=" + SearchInputYEAR + ")";
					haveWHERE = true;
				} else {
					sql = sql + " AND (YEAR=" + SearchInputYEAR + ")";
				}			
			} catch (NumberFormatException e) {
				writer.println("Incorrect search YEAR");
				return;
			}
		}
		if(!SearchInputHEIGHT.equals("")) {
			try {
				Integer.valueOf(SearchInputHEIGHT);
				if(haveWHERE == false) {
					sql = sql + " WHERE (HEIGHT=" + SearchInputHEIGHT + ")";
					haveWHERE = true;
				} else {
					sql = sql + " AND (HEIGHT=" + SearchInputHEIGHT + ")";
				}			
			} catch (NumberFormatException e) {
				writer.println("Incorrect search HEIGHT");
				return;
			}
		}
		if(!SearchInputSTAB1.equals("")) {
			try {
				Integer.valueOf(SearchInputSTAB1);
				if(haveWHERE == false) {
					sql = sql + " WHERE (STAB1=" + SearchInputSTAB1 + ")";
					haveWHERE = true;
				} else {
					sql = sql + " AND (STAB1=" + SearchInputSTAB1 + ")";
				}			
			} catch (NumberFormatException e) {
				writer.println("Incorrect search STAB1");
				return;
			}
		}
		if(!SearchInputSTAB2.equals("")) {
			try {
				Integer.valueOf(SearchInputSTAB2);
				if(haveWHERE == false) {
					sql = sql + " WHERE (STAB2=" + SearchInputSTAB2 + ")";
					haveWHERE = true;
				} else {
					sql = sql + " AND (STAB2=" + SearchInputSTAB2 + ")";
				}			
			} catch (NumberFormatException e) {
				writer.println("Incorrect search STAB2");
				return;
			}
		}
		if(!SearchInputSTAB3.equals("")) {
			try {
				Integer.valueOf(SearchInputSTAB3);
				if(haveWHERE == false) {
					sql = sql + " WHERE (STAB3=" + SearchInputSTAB3 + ")";
					haveWHERE = true;
				} else {
					sql = sql + " AND (STAB3=" + SearchInputSTAB3 + ")";
				}			
			} catch (NumberFormatException e) {
				writer.println("Incorrect search STAB3");
				return;
			}
		}
		
		
		
		sql = sql + " ORDER BY ";
		if (sortTD.equals("DATE")) {
			sql = sql + "DATEM";
			if(!sortMOVE) {
				sql = sql + " DESC";
			}
			sql = sql + ", DATED";
			if(!sortMOVE) {
				sql = sql + " DESC";
			}
		} else {
			sql = sql + sortTD;
			if(!sortMOVE) {
				sql = sql + " DESC";
			}
		}
		sql = sql + ";";
		
		try {		
			ResultSet rs = stat.executeQuery(sql);

			writer.println("<table id=\"TableResult\" border=1 width=100%>");
			writer.println("<tr>");
			writer.println("<td> ACCENUMB </td> <td> COUNTRY </td> <td> ACCENAME </td> <td> YEAR </td> <td> HEIGHT </td> <td> DATE </td> <td> STAB1 </td> <td> STAB2 </td> <td> STAB3 </td> <td> Edit </td>  <td> Delete </td> </tr>");
			
			while ( rs.next() ) {
				writer.println("<tr>");
				writer.println("<td>" + rs.getInt("ACCENUMB") + "</td>");
				writer.println("<td>" + rs.getString("COUNTRY") + "</td>");
				writer.println("<td>" + rs.getString("ACCENAME") + "</td>");
				writer.println("<td>" + rs.getInt("YEAR") + "</td>");
				writer.println("<td>" + rs.getInt("HEIGHT") + "</td>");
				writer.println("<td>" + rs.getInt("DATED") + "." + rs.getInt("DATEM") + "</td>");
				writer.println("<td>" + rs.getInt("STAB1") + "</td>");
				writer.println("<td>" + rs.getInt("STAB2") + "</td>");
				writer.println("<td>" + rs.getInt("STAB3") + "</td>");
				if (moderRang) {
					writer.println("<td> <input type='button' value='Edit' onclick='ajaxEdit(" + rs.getInt("ID") + ")' /></td>");
					writer.println("<td> <input type='button' value='Delete' onclick='ajaxDelete(" + rs.getInt("ID") + ")' /></td>");
				} else {
					writer.println("<td></td>");
					writer.println("<td></td>");
				}
				writer.println("</tr>");
			}
			
			writer.println("</table>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
