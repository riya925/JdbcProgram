import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class MyProcedure
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n Driver Register Successfully.... ");
			
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gtukb","root","");
			System.out.println("\n Database Found Successfully.... ");
			
			CallableStatement cst=con.prepareCall(" { call proc(?,?)} ");
			
			System.out.println("\n Enter name : ");
			String na=scan.nextLine();
			
			cst.setString(1,na);
			cst.registerOutParameter(2, Types.INTEGER);
			cst.execute();
			
			System.out.println("\n Age is : "+cst.getInt(2));
			
			cst.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("\n Error Message : "+e.getMessage());
		}
	}
}