package com.login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;
  
public class Login extends JFrame implements ActionListener, ItemListener
{
	private static final long serialVersionUID = 1L;
	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/library";
	static final String u = "root";
	static final String p = "root";
	
	JFrame f1 = new JFrame();
	JFrame f2 = new JFrame();
	JFrame f3 = new JFrame();
	JFrame f4 = new JFrame();
	JFrame f5 = new JFrame();
	JFrame f6 = new JFrame();
	JFrame f7 = new JFrame();
	JFrame f8 = new JFrame();
	
	JLabel username = new JLabel("Username"); 
	JLabel pass = new JLabel("Password");
	
	JTextField text1 = new JTextField();
	JPasswordField text2 = new JPasswordField();
	JTextField prn = new JTextField();
	JTextField firstname = new JTextField();
	JTextField lastname = new JTextField();
	JComboBox<String> branch = new JComboBox<String>();
	JComboBox<String> year = new JComboBox<String>();
	JTextField email = new JTextField();
	JTextField mobile = new JTextField();
	JTextField bookid = new JTextField();
	JTextField bookname = new JTextField();
	JTextField author = new JTextField();
	JTextField noofbooks = new JTextField();
	
	JButton submit = new JButton("Submit");
	JButton submit1 = new JButton("Submit");
	JButton submit2 = new JButton("Lease");
	JButton register = new JButton("Register");
	JButton lease = new JButton("Lease");
	JButton inventory = new JButton("Inventory");
	JButton leased = new JButton("Leased Books");
	JButton addbook = new JButton("Add Book");
	JButton ret = new JButton("Return Book");
	JButton submit3 = new JButton("Submit");
	
	JComboBox<String> semester = new JComboBox<String>();
	JComboBox<String> student = new JComboBox<String>();
	JComboBox<String> book = new JComboBox<String>();
	
	ArrayList<String> stud = new ArrayList<String>();
	ArrayList<String> boo = new ArrayList<String>();
	
	Login()//f1
	{
		username.setBounds(100,50,100,30);
		pass.setBounds(100,100,100,30);
		submit.setBounds(200, 250, 100, 40);		
		text1.setBounds(250,50,150,40);
		text2.setBounds(250,100,150,40);
		
		submit.addActionListener(this);

		f1.add(username);
		f1.add(pass);
		f1.add(text1);
		f1.add(text2);
		f1.add(submit);
		
		f1.setLayout(null);
        f1.setVisible(true);
        f1.setSize(500,500);
        f1.setTitle("Login");
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f1.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f1.getHeight()) / 2);
        f1.setLocation(x, y);
	}
	
	public void Frame2()//f2
	{
		register.setBounds(20,100,140,50);
		lease.setBounds(20,160,140,50);
		inventory.setBounds(20,220,140,50);
		leased.setBounds(20, 280, 140, 50);
		
		f2.add(register);
		f2.add(lease);
		f2.add(inventory);
		f2.add(leased);
		
		register.addActionListener(this);
		lease.addActionListener(this);
		inventory.addActionListener(this);
		leased.addActionListener(this);
		
		f2.setLayout(null);
        f2.setVisible(true);
        f2.setSize(200,400);
        f2.setTitle("BookLease");
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f2.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f2.getHeight()) / 2);
        f2.setLocation(x,y);
	}
	
	public void registerFrame()//f3
	{
		JLabel head = new JLabel("Register");
		JLabel p = new JLabel("PRN");
		JLabel f = new JLabel("First Name");
		JLabel l = new JLabel("Last Name");
		JLabel b = new JLabel("Branch");
		JLabel yr = new JLabel("Year");
		JLabel e = new JLabel("Email id");
		JLabel m = new JLabel("Mobile No.");
		
		head.setBounds(325,20,200,50);
		p.setBounds(200,100,100,50);
		f.setBounds(200, 150, 100, 50);
		l.setBounds(200, 200, 100, 50);
		b.setBounds(200, 250, 100, 50);
		yr.setBounds(200, 300, 100, 50);
		e.setBounds(200, 350, 100, 50);
		m.setBounds(200, 400, 100, 50);
		register.setBounds(20,100,100,50);
		lease.setBounds(20,160,100,50);
		inventory.setBounds(20,220,100,50);
		leased.setBounds(20, 280, 100, 50);
		prn.setBounds(325, 100, 150, 30);
		firstname.setBounds(325, 150, 150, 30);
		lastname.setBounds(325, 200, 150, 30);
		branch.setBounds(325, 250, 150, 30);
		year.setBounds(325, 300, 150, 30);
		email.setBounds(325, 350, 150, 30);
		mobile.setBounds(325, 400, 150, 30);
		submit1.setBounds(300, 450, 100, 50);
		
		branch.addItem("CS");
		branch.addItem("IT");
		branch.addItem("ENTC");
		branch.addItem("Mech");
		branch.addItem("Civil");
		
		year.addItem("2013-17");
		year.addItem("2014-18");
		year.addItem("2015-19");
		year.addItem("2016-20");
		
		f3.add(head);
		f3.add(p);
		f3.add(f);
		f3.add(l);
		f3.add(b);
		f3.add(yr);
		f3.add(e);
		f3.add(m);
		f3.add(prn);
		f3.add(firstname);
		f3.add(lastname);
		f3.add(branch);
		f3.add(year);
		f3.add(email);
		f3.add(mobile);
		f3.add(register);
		f3.add(lease);
		f3.add(inventory);
		f3.add(leased);
		f3.add(submit1);
		
		register.addActionListener(this);
		lease.addActionListener(this);
		inventory.addActionListener(this);
		submit1.addActionListener(this);
		leased.addActionListener(this);
		
		f3.setLayout(null);
        f3.setVisible(true);
        f3.setSize(700,700);
        f3.setTitle("BookLease");
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f3.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f3.getHeight()) / 2);
        f3.setLocation(x,y);
	}
	
	public void inventoryFrame()//f4 here
	{
		ArrayList<Object[]> data = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String columnNames[] = {"Book ID","Book Name","Author","Semester","Branch","No of books","Available"};
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,u,p);
            String q = "select * from book;";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(q);
            while(rs.next())
            {
            	Object[] row = new Object[]{rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)};
            	data.add(row);
            }
            Object[][] realData = data.toArray(new Object[data.size()][]);
            JTable table_paylist= new JTable(realData, columnNames);
            JScrollPane scroll_paylist= new JScrollPane(table_paylist);        
            table_paylist.setPreferredScrollableViewportSize(new Dimension(800, 200));
            table_paylist.setFillsViewportHeight(true);
            
            register = new JButton("Register");
            lease = new JButton("Lease");
            inventory = new JButton("Inventory");
            leased = new JButton("Leased Books");
            
            register.setBounds(20,300,100,50);
    		lease.setBounds(20,360,100,50);
    		inventory.setBounds(20,420,100,50);
    		leased.setBounds(20, 480, 100, 50);
    		addbook.setBounds(200, 300, 100, 50);
    		//ret.setBounds(310, 300, 100, 50);
    		
    		register.addActionListener(this);
    		lease.addActionListener(this);
    		inventory.addActionListener(this);
    		leased.addActionListener(this);
    		addbook.addActionListener(this);
    		//ret.addActionListener(this);
            
    		f4.add(register);
    		f4.add(lease);
    		f4.add(inventory);
    		f4.add(leased);
    		f4.add(addbook);
    		//f4.add(ret);
            f4.setLayout(new BorderLayout());
            f4.add(scroll_paylist, BorderLayout.CENTER); 
            f4.setVisible(true);
            f4.setSize(700,700);
            f4.setTitle("BookLease");
            
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - f4.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - f4.getHeight()) / 2);
            f4.setLocation(x,y);
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
	
	public void leaseFrame()
	{
		JLabel head = new JLabel("Lease");
		JLabel stu = new JLabel("Student");
		JLabel bo = new JLabel("Book");
		JLabel sem =  new JLabel("Semester");
		
		f5 = new JFrame("BookLease");
		
		submit2.setBounds(350, 300, 100, 50);
		head.setBounds(325,20,200,50);
		sem.setBounds(100, 100, 100, 50);
		stu.setBounds(100,200,100,50);
		bo.setBounds(450, 200, 100, 50);
		semester.setBounds(200,100,150,50);
		student.setBounds(200, 200, 150, 50);
		book.setBounds(525, 200, 150, 50);
		
		register.setBounds(20,300,100,50);
		lease.setBounds(20,360,100,50);
		inventory.setBounds(20,420,100,50);
		leased.setBounds(20, 480, 100, 50);
		
		register.addActionListener(this);
		lease.addActionListener(this);
		inventory.addActionListener(this);
		leased.addActionListener(this);
		
		/*student.removeAllItems();
		book.removeAllItems();
		semester.removeAllItems();*/
        
		for(int i=0;i<stud.size();i++)
		{
			student.addItem(stud.get(i));
		}
		
		for(int i=0;i<boo.size();i++)
		{
			book.addItem(boo.get(i));
		}
		
		for(int i=1;i<=8;i++)
		{
			semester.addItem(Integer.toString(i));
		}
		
		f5.add(register);
		f5.add(lease);
		f5.add(inventory);
		f5.add(leased);
		f5.add(bo);
		f5.add(book);
		f5.add(head);
		f5.add(stu);
		f5.add(sem);
		f5.add(semester);
		f5.add(student);
		f5.add(submit2);
		
		semester.addItemListener(this);
		submit2.addActionListener(this);
		/*student.addItemListener(this);
		book.addItemListener(this);*/
		
		f5.setLayout(null);
        f5.setVisible(true);
        f5.setSize(800,700);
        f5.setTitle("BookLease");
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f5.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f5.getHeight()) / 2);
        f5.setLocation(x,y);
	}
	
	public void leasedFrame()
	{
		JLabel head = new JLabel("Leased Books");
		
		ArrayList<Object[]> data = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String columnNames[] = {"Student Name","Book Name","Date"};
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,u,p);
            String q = "select * from lease order by studentname;";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(q);
            while(rs.next())
            {
            	Object[] rows = new Object[]{rs.getString(1), 
                        rs.getString(2), 
                        rs.getString(3)};
            	data.add(rows);
            }
            Object[][] realDatas = data.toArray(new Object[data.size()][]);
            /*for(int i=0;i<2;i++)
            {
            	for(int j=0;j<3;j++)
            	{
            		System.out.println(realDatas[i][j]);
            	}
            }*/
            JTable table_paylist1= new JTable(realDatas, columnNames);
            JScrollPane scroll_paylist1= new JScrollPane(table_paylist1);        
            table_paylist1.setPreferredScrollableViewportSize(new Dimension(800, 200));
            table_paylist1.setFillsViewportHeight(true);
            
            register.setBounds(20,300,100,50);
    		lease.setBounds(20,360,100,50);
    		inventory.setBounds(20,420,100,50);
    		
    		register.addActionListener(this);
    		lease.addActionListener(this);
    		inventory.addActionListener(this);
    		
//    		/System.out.println("Executed!");
    		
    		f6.add(register);
    		f6.add(lease);
    		f6.add(inventory);
    		f6.add(head);
    		f6.setLayout(new BorderLayout());
            f6.add(scroll_paylist1, BorderLayout.CENTER); 
			//f6.setLayout(null);
	        f6.setVisible(true);
	        f6.setSize(800,700);
	        f6.setTitle("BookLease");
	        
	        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	        int x = (int) ((dimension.getWidth() - f6.getWidth()) / 2);
	        int y = (int) ((dimension.getHeight() - f6.getHeight()) / 2);
	        f6.setLocation(x,y);
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
	
	public void addbookFrame()
	{
		JLabel head = new JLabel("Add New Book");
		JLabel bid = new JLabel("Book ID");
		JLabel bname = new JLabel("Book Name");
		JLabel aut = new JLabel("Author");
		JLabel sem = new JLabel("Semester");
		JLabel br = new JLabel("Branch");
		JLabel nob = new JLabel("No of Books");
		
		head.setBounds(325, 20, 300, 50);
		
		/*JTextField bookid = new JTextField();
		JTextField bookname = new JTextField();
		JTextField author = new JTextField();
		JTextField noofbooks = new JTextField();*/
		
		semester.removeAllItems();
		branch.removeAllItems();
		for(int i=1;i<=8;i++)
		{
			semester.addItem(Integer.toString(i));
		}
		
		branch.addItem("CS");
		branch.addItem("IT");
		branch.addItem("ENTC");
		branch.addItem("Mech");
		branch.addItem("Civil");
		
		register.setBounds(20,300,100,50);
		lease.setBounds(20,360,100,50);
		inventory.setBounds(20,420,100,50);
		leased.setBounds(20, 480, 100, 50);
		
		bid.setBounds(200, 100, 100, 50);
		bname.setBounds(200, 150, 100, 50);
		aut.setBounds(200, 200, 100, 50);
		sem.setBounds(200, 250, 100, 50);
		br.setBounds(200, 300, 100, 50);
		nob.setBounds(200, 350, 100, 50);
		
		bookid.setBounds(325, 100, 150, 30);
		bookname.setBounds(325, 150, 150, 30);
		author.setBounds(325, 200, 150, 30);
		semester.setBounds(325, 250, 150, 30);
		branch.setBounds(325, 300, 150, 30);
		noofbooks.setBounds(325, 350, 150, 30);
		
		submit3.setBounds(325, 400, 100, 50);
		
		register.addActionListener(this);
		lease.addActionListener(this);
		inventory.addActionListener(this);
		leased.addActionListener(this);
		submit3.addActionListener(this);

		f7.add(head);
		f7.add(bid);
		f7.add(bname);
		f7.add(aut);
		f7.add(sem);
		f7.add(br);
		f7.add(nob);
		f7.add(bookid);
		f7.add(bookname);
		f7.add(author);
		f7.add(semester);
		f7.add(branch);
		f7.add(noofbooks);
		f7.add(register);
		f7.add(lease);
		f7.add(inventory);
		f7.add(submit3);
		
		f7.setLayout(null);
        f7.setVisible(true);
        f7.setSize(700,700);
        f7.setTitle("BookLease");
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f7.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f7.getHeight()) / 2);
        f7.setLocation(x,y);
	}
	
	/*public void selectStudBook()
	{
		
		
		
	}*/

	public void itemStateChanged(ItemEvent e)
	{
		if(e.getStateChange()==e.SELECTED && e.getSource()==semester)
		{
			stud.clear();
			student.removeAllItems();
			boo.clear();
			book.removeAllItems();
			String item = (String) e.getItem();
			//System.out.println(item);
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try
			{
			  	Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL,u,p);
	            String q = "select * from member where semester = '"+item+"';";
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(q);
	            while(rs.next())
	            {
	            	stud.add(rs.getString("firstname")+" "+rs.getString("lastname"));
	            }
	            //System.out.println(stud);
				conn.close();
			}
			catch(Exception ae)
			{
				ae.printStackTrace();
			}
			conn=null;
			stmt=null;
			rs=null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL,u,p);
	            String q = "select * from book where semester = '"+item+"';";
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(q);
	            while(rs.next())
	            {
	            	boo.add(rs.getString("name"));
	            }
			}
			catch(Exception ae)
			{
				ae.printStackTrace();
			}
			leaseFrame();
		}
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
		   String value1=text1.getText();
		   String value2=text2.getText();
		   String q = "select * from loginid;";
		   ArrayList<String> us = new ArrayList<String>();
		   ArrayList<String> pa = new ArrayList<String>();
		   Connection conn = null;
	       Statement stmt = null;
	       ResultSet rs = null;
		   //int k=0;
		   try
		   {
			   Class.forName("com.mysql.jdbc.Driver");
			   conn = DriverManager.getConnection(DB_URL,u,p);
			   stmt = conn.createStatement();
			   rs = stmt.executeQuery(q);
			   while(rs.next())
			   {
		            us.add(rs.getString("username"));
		            pa.add(rs.getString("pass"));
			   }
			   boolean b = us.contains(value1);
			   if(b)
			   {
				   if(pa.contains(value2))
				   {
					   f1.dispose();
					   Frame2();
				   }
				   else
				   {
					   JOptionPane.showMessageDialog(this,"Incorrect login or password", "Error",JOptionPane.ERROR_MESSAGE);
				   }
			   }
			   else
			   {
				   JOptionPane.showMessageDialog(this,"Incorrect login or password", "Error",JOptionPane.ERROR_MESSAGE);
			   }
			   conn.close();
		   }
		   catch(SQLException e)
		   {
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(ae.getSource()==register)
		{
			f1.dispose();
			f2.dispose();
			f3.dispose();
			f4.dispose();
			f5.dispose();
			f6.dispose();
			registerFrame();
		}
		else if(ae.getSource()==submit1)
		{
			ArrayList<String> pr = new ArrayList<String>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try
			{
			  	Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL,u,p);
	            String q = "select prn from member;";
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(q);
	            while(rs.next())
	            {
	            	pr.add(rs.getString("prn"));
	            }
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			String prn = this.prn.getText();
			String firstname = this.firstname.getText();
			String lastname = this.lastname.getText();
			String email = this.email.getText();
			String mobile = this.mobile.getText();
			Calendar cal = Calendar.getInstance();
			String month = new SimpleDateFormat("MM").format(cal.getTime());
			int mon = Integer.parseInt(month);
			char sem;
			String semester="";
			if(mon>=7&&mon<=12)
			{
				sem='o';
			}
			else
			{
				sem='e';
			}
			int k=0;
			if(prn.equals(null)||prn.equals(""))
			{
				JOptionPane.showMessageDialog(this,"PRN cannot be empty", "Error",JOptionPane.ERROR_MESSAGE);
				k=1;
			}
			else if(pr.contains(prn))
			{
				JOptionPane.showMessageDialog(this,"User already exists", "Warning",JOptionPane.WARNING_MESSAGE);
				k=1;
			}
			else if(firstname.equals(null)||firstname.equals(""))
			{
				JOptionPane.showMessageDialog(this,"First Name cannot be empty", "Error",JOptionPane.ERROR_MESSAGE);
				k=1;
			}
			else if(lastname.equals(null)||lastname.equals(""))
			{
				JOptionPane.showMessageDialog(this,"Last Name cannot be empty", "Error",JOptionPane.ERROR_MESSAGE);
				k=1;
			}
			else if(email.equals(null)||email.equals(""))
			{
				JOptionPane.showMessageDialog(this,"Email id cannot be empty", "Error",JOptionPane.ERROR_MESSAGE);
				k=1;
			}
			else if(mobile.equals(null)||mobile.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Mobile no. cannot be empty", "Error",JOptionPane.ERROR_MESSAGE);
				k=1;
			}
			if(k==0)
			{
				//insert into database
				String yr = year.getSelectedItem().toString();
				if(yr.substring(0, 4).equals("2013"))
				{
					if(sem=='o')
						semester="7";
					else
						semester="8";
				}
				else if(yr.substring(0, 4).equals("2014"))
				{
					if(sem=='o')
						semester="5";
					else
						semester="6";
				}
				else if(yr.substring(0, 4).equals("2015"))
				{
					if(sem=='o')
						semester="3";
					else
						semester="4";
				}
				else if(yr.substring(0, 4).equals("2016"))
				{
					if(sem=='o')
						semester="1";
					else
						semester="2";
				}
				String q = "insert into member values('"+prn+"','"+firstname+"','"+lastname+"','"+branch.getSelectedItem().toString()+"','"+year.getSelectedItem().toString()+"','"+email+"','"+mobile+"','"+semester+"');";
				try
				{
					  	Class.forName("com.mysql.jdbc.Driver");
			            conn = DriverManager.getConnection(DB_URL,u,p);
			            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q);
			            statement.execute();
			            JOptionPane.showMessageDialog(this, "Member created", "inforation",JOptionPane.INFORMATION_MESSAGE);
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
			else
			{
				//Do nothing
			}
		}
		else if(ae.getSource()==lease)
		{
			f1.dispose();
			f2.dispose();
			f3.dispose();
			f4.dispose();
			f5.dispose();
			f6.dispose();
			leaseFrame();
		}
		else if(ae.getSource()==submit2)
		{
			//Add to database!
			String s = (String) student.getSelectedItem();
			String b = (String) book.getSelectedItem();
			java.util.Date today = Calendar.getInstance().getTime();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs=null;
			int flag=0;
			ArrayList<String> books = new ArrayList<String>();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL,u,p);
	            String q = "select bookname from lease where studentname = '"+s+"';";
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(q);
	            while(rs.next())
	            {
	            	books.add(rs.getString("bookname"));
	            }
	            if(books.contains(b))
	            {
	            	flag=1;
	            	JOptionPane.showMessageDialog(this, s+" has already leased "+b, "warning", JOptionPane.WARNING_MESSAGE);
	            }
	            conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(flag==0){
			String q = "insert into lease values('"+s+"','"+b+"','"+today+"');";//insert query
			try
			{
				  	Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection(DB_URL,u,p);
		            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q);
		            statement.execute();
		            JOptionPane.showMessageDialog(this, b+" have been leased to "+s, "information", JOptionPane.INFORMATION_MESSAGE);
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
			
			//String q = "select available from book where name = '"+b+"';";
			conn=null;
			stmt=null;
			rs=null;
			int n=0;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL,u,p);
	            q = "select available from book where name = '"+b+"';";
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(q);
	            while(rs.next())
	            {
	            	n = Integer.parseInt(rs.getString("available"));
	            	n--;
	            }
	            q = "update book set available = '"+n+"' where name = '"+b+"';";
	            stmt = conn.createStatement();
	            stmt.executeUpdate(q);
	            conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}}
		}
		else if(ae.getSource()==inventory)
		{
			f1.dispose();
			f2.dispose();
			f3.dispose();
			f4.dispose();
			f5.dispose();
			f6.dispose();
			inventoryFrame();
			
		}
		else if(ae.getSource()==addbook)//add book to book 
		{
			f1.dispose();
			f2.dispose();
			f3.dispose();
			f4.dispose();
			f5.dispose();
			f6.dispose();
			addbookFrame();
		}
		else if(ae.getSource()==ret)//remove entry from lease
		{
			
		}
		else if(ae.getSource()==leased)
		{
			f1.dispose();
			f2.dispose();
			f3.dispose();
			f4.dispose();
			f5.dispose();
			f6.dispose();
			leasedFrame();
		}
		else if(ae.getSource()==submit3)
		{
			ArrayList<String> books = new ArrayList<String>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs=null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL,u,p);
	            String q = "select bookid from book;";
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(q);
	            while(rs.next())
	            {
	            	books.add(rs.getString("bookid"));
	            }
	            if(books.contains(bookid))
	            {
	            	JOptionPane.showMessageDialog(this, "Book already registered", "error", JOptionPane.ERROR_MESSAGE);
	            }
	            else
	            {
	            	//add to database
	            	try
					{
					  	Class.forName("com.mysql.jdbc.Driver");
			            conn = DriverManager.getConnection(DB_URL,u,p);
			            q = "insert into book values('"+bookid.getText()+"','"+bookname.getText()+"','"+author.getText()+"','"+semester.getSelectedItem().toString()+"','"+branch.getSelectedItem().toString()+"','"+noofbooks.getText()+"','"+noofbooks.getText()+"');";
			            PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q);
			            statement.execute();
			            JOptionPane.showMessageDialog(this, "Book registered", "information", JOptionPane.INFORMATION_MESSAGE);
					}
	            	catch(Exception e)
	            	{
	            		e.printStackTrace();
	            	}
	            }
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
	}
	public static void main(String args[])
	{
		/*try
		{
			Login frame=new Login();
			frame.setSize(300,100);
			frame.setVisible(true);
		}
		catch(Exception e)
		{JOptionPane.showMessageDialog(null, e.getMessage());}*/
		new Login();
	}
 }