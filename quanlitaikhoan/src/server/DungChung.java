package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DungChung {
	
	public static Connection cnn;
	public void ketnoi() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://localhost:1433;databaseName=qlitaikhoan;user=sa; password=sa123;";
		     cnn = DriverManager.getConnection(url);
		//    System.out.print("kết nối thành công");
	}
	public static void main(String []args) throws ClassNotFoundException, SQLException {	
		DungChung sc=new DungChung();
			sc.ketnoi();
	}
}
