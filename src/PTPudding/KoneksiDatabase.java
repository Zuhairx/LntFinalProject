package PTPudding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import PTPudding.GUI;
public class KoneksiDatabase {
	//deklarasi variabel
		public Connection conn;
		private Statement st;
		ImageIcon icon = new ImageIcon("success.png");
		
		//koneksi1
		public void connect() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				this.conn = DriverManager.getConnection("jdbc:mysql://localhost/pt_pudding",
						"root","");
				this.st = conn.createStatement();
				JOptionPane.showMessageDialog(null,"Database Connected","Message", JOptionPane.INFORMATION_MESSAGE,icon);
				 
			}
			catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Database Failed Connected ","Message" , JOptionPane.ERROR_MESSAGE);
			}
		}
		
		//koneksi2
		public void connect2() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				this.conn = DriverManager.getConnection("jdbc:mysql://localhost/pt_pudding",
						"root","");
				this.st = conn.createStatement(); 
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Database Failed Connected ","Message" , JOptionPane.ERROR_MESSAGE);				
			}
		}
		
		public ResultSet query(String q) throws SQLException {
			return this.st.executeQuery(q);
		}
		
		public boolean queryDel(String q) throws SQLException {
			if(this.st.execute(q)) {
				return true;
			}
			return false; 
		}
		
	}

