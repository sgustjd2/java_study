package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CloserTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CloserTest obj = new CloserTest();
		Scanner key = new Scanner(System.in);

		System.out.print("주소:");
		String addr = key.next();
		obj.select(addr);
	}

	public void select(String addr) {

 
 
		String sql = "SELECT * FROM customer WHERE addr like ?";

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC";
		String user = "exam";
		String password = "1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+addr+"%");

			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getDate(5) + "\t");
				System.out.println(rs.getInt(6) + "\t");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패!!");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
