package excel;

import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Extract_data {
	private static final long serialVersionUID = 1L;
	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/flight";
	static final String u = "root";
	static final String p = "root";
	
	public void readExcel() throws BiffException, IOException {
		String FilePath = "D:\\FlightDelays.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		/*for (int row = 0; row < totalNoOfRows; row++) {

			for (int col = 0; col < totalNoOfCols; col++) {
				System.out.print(sh.getCell(col, row).getContents() + "\t");
			}
			System.out.println();
		}*/
		for(int i = 1; i< totalNoOfRows; i++)
		{
		
		String q = "insert into flightdelay values("+sh.getCell(0, i).getContents()+",'"+sh.getCell(1,i).getContents()+"',"+sh.getCell(2,i).getContents()+",'"+sh.getCell(3,i).getContents()+"',"+sh.getCell(4,i).getContents()+",";
		q = q + "'"+sh.getCell(5,i).getContents()+"',"+sh.getCell(6, i).getContents()+",'"+sh.getCell(7,i).getContents()+"',"+sh.getCell(8,i).getContents()+","+sh.getCell(9,i).getContents()+",";
		q = q + sh.getCell(10,i).getContents()+",'"+sh.getCell(11,i).getContents()+"','"+sh.getCell(12,i).getContents()+"');";
		//System.out.println(q);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,u,p);
            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q);
            statement.execute();
            conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		}
		System.out.println("DONE!");
	}

	public static void main(String args[]) throws BiffException, IOException {
		Extract_data DT = new Extract_data();
		DT.readExcel();
	}
}