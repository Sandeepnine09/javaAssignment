package java8;

import java.sql.*;

public class DerbyJdbcEx {

	public static void main(String[] args) {
		Connection con = null;
		Statement stat = null;
		String s;
		try {

			//goto C:\Derby\db-derby-10.14.2.0-bin\bin & 
			//batch file run startNetworkServer

			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			//		Class.forName("org.apache.derby.jdbc.ClientDriver");

			// if using java 5.0 or earlier
			// Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			con = DriverManager.getConnection("jdbc:derby:namadb;create=true;user=nama;password=nama");

			// con=DriverManager.getConnection("jdbc:derby://localhost:1527/derbydb;create=true;user=nama;password=nama");

			System.out.println("The connection is established...");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			stat = con.createStatement();
			s = "create table student1(Rollno int,Name varchar(50),serName varchar(50))";
			stat.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			stat = con.createStatement();
			s = "insert into student1 values(1,'Mohammad','Shami')";
			stat.executeUpdate(s);
			s = "insert into student1 values(2,'Jaspreet','Bumrah')";
			stat.executeUpdate(s);
			s = "insert into student1 values(3,'KL','Rahul')";
			stat.executeUpdate(s);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			stat.close();
		} catch (SQLException e) {
		}

		System.out.println("Creation is successfully done...");

		try {
			stat = con.createStatement();
			s = "select * from student1";
			ResultSet rset = stat.executeQuery(s);

			while (rset.next())
				System.out.println(rset.getInt(1) + " " + rset.getString(2) + "    " + rset.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			stat.close();
		} catch (SQLException se) {

		}

	}
}