package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;  
public class DiscreteLog implements ActionListener 
{
	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/discrete";
	static final String u = "root";
	static final String p = "root";
	
	JFrame f;
	JFrame f1;
	JTextField tprime;
	JTextField tgenerator;
	JTextField tkey;
	ArrayList<Long> arr;
	JButton enter;
	JButton back;
	JLabel footer;
	long result;
	long time;
	
    DiscreteLog()
    {  
    	f=new JFrame("Discete Log Problem");//creating instance of JFrame  
    	
    	//Label
    	JLabel prime = new JLabel("Prime Number");
    	JLabel generator = new JLabel("Generator");
    	JLabel key = new JLabel("Key");
    	footer = new JLabel("Copyright "+"\u00a9"+" 2016. ");
    	//Label
    	
    	//Textfield
    	tprime = new JTextField();
    	tgenerator = new JTextField();
    	tkey = new JTextField();
    	//Textfield
    	
    	//Button
    	enter = new JButton("Enter");
    	enter.addActionListener(this);
    	//Button
        
    	//setBounds
    	prime.setBounds(50, 50, 100, 30);
        tprime.setBounds(150, 50, 120, 25);
        generator.setBounds(50, 100, 100, 30);
        tgenerator.setBounds(150, 100, 120, 25);
        key.setBounds(50, 150, 100, 30);
        tkey.setBounds(150, 150, 120, 25);
        footer.setBounds(50, 275, 400, 30);
        enter.setBounds(150, 200, 120, 25);
    	//setBounds
    	         
        //add
    	f.add(prime);
    	f.add(tprime);
    	f.add(generator);
    	f.add(tgenerator);
    	f.add(key);
    	f.add(tkey);
    	f.add(footer);
    	f.add(enter);
    	//add
    	
    	//Frame details
    	f.setSize(350,390);//300 width and 500 height  
    	f.setLayout(null);//using no layout managers  
    	f.setVisible(true);//making the frame visible
    	//Frame details
    	
    	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f.getHeight()) / 2);
        f.setLocation(x,y);
    } 
    
    public static long power(long a, long m, long n)
    {
		// Find a^m mod n
		BigInteger base = BigInteger.valueOf(a);
		BigInteger exponent = BigInteger.valueOf(m);
		BigInteger module = BigInteger.valueOf(n);
		BigInteger p = base.modPow(exponent, module);
		return p.longValue();
	}
	public static long inverse(long a, long n) 
	{
		// Find a^(-1) mod n
		BigInteger r1 = BigInteger.valueOf(a);
		BigInteger r2 = BigInteger.valueOf(n);
		BigInteger inv = r1.modInverse(r2);
		return inv.longValue();		
	}
    
    public void displayResults()
    {
    	f1 = new JFrame("Discrete Log Problem Results");
    	
    	back = new JButton("Back");
    	
    	String s="";
    	for(int i=0;i<arr.size();i++)
    	{
    		if(arr.size()-i != 1)
    			s += arr.get(i) +", ";
    		else
    			s += arr.get(i);
    	}
    	
    	JLabel r = new JLabel(s);
    	
    	r.setBounds(100, 100, 300, 100);
    	back.setBounds(200, 300, 100, 25);
    	
    	back.addActionListener(this);
    	
    	f1.add(back);
    	f1.add(r);
    	
    	//Frame details
    	f1.setSize(400,400);//300 width and 500 height  
    	f1.setLayout(null);//using no layout managers  
    	f1.setVisible(true);//making the frame visible
    	//Frame details
    	
    	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f1.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f1.getHeight()) / 2);
        f1.setLocation(x,y);
    }
    
    public long bruteForce()
    {
    	long start = System.nanoTime();
    	long p = Long.parseLong(tprime.getText().trim());
		long g = Long.parseLong(tgenerator.getText().trim());
		long k = Long.parseLong(tkey.getText().trim());
		double a=0,b=0;
		int power=0;
		arr = new ArrayList<Long>();
		do
		{
			a = Math.pow(g, power);
			b = a%p;
			power++;
			if(b==k)	
			{
				arr.add((long)power-1);
				result = arr.get(0);
			}
		}
		while(arr.size()<1);
		time = System.nanoTime()-start;
		return time;
    }
    
    public long babyStepGiantStep()
    {
    	
    		time=0;
    	long start = System.nanoTime();
    	long p = Long.parseLong(tprime.getText().trim());
		long g = Long.parseLong(tgenerator.getText().trim());
		long k = Long.parseLong(tkey.getText().trim());
    	int count=1;
		while(Math.pow(count, 2)<(p-1))
		{
			count++;
		}
		ArrayList<Double> arr1 = new ArrayList<Double>();
		ArrayList<Double> arr2 = new ArrayList<Double>();
		int index=1,r=1,x=1;
		double power=0;
		while(index<count)
		{
			arr1.add((Math.pow(g, index)%p));
			r=index*count;
			power = Math.pow(g,r);
			while(((x*power)%p)!=1)
			{
				x++;
			}
			arr2.add((double)(k*x)%p);
			x=1;
			index++;
		}
		ArrayList<Double> arr3 = new ArrayList<Double>(arr1);
		arr3.retainAll(arr2);
		int i=0,j=0;
		try{
		i = arr2.indexOf(arr3.get(0));
		i = (i+1)*count;
		j = arr1.indexOf(arr3.get(0));
		j=j+1;
		time = System.nanoTime()-start;
		return time;
		}
		catch(Exception e)
    	{
			time = System.nanoTime()-start;
    		return time;
    	}
    }
    
    public long pohligHellman()
    {
    	long start = System.nanoTime();
    	long p = Long.parseLong(tprime.getText().trim());//p  41
		long alpha = Long.parseLong(tgenerator.getText().trim());//g  7
		long beta = Long.parseLong(tkey.getText().trim());//k  12
		long phi = 0;
		long n = p-1;
		phi=n;
		long prod=1;
		ArrayList<Long> primefactors = new ArrayList<Long>();
		while(n%2 == 0)
		{
			prod*=2;
			n=n/2;
		}
		primefactors.add(prod);
		prod=1;
		for(int i=3;i<=Math.sqrt(n);i=i+2)
		{
			if(n%i==0){
			while(n%i==0)
			{
				prod*=i;
				n=n/i;
			}
			primefactors.add(prod);
			prod=1;
			}
		}
		if(n>2)
		{
			primefactors.add(n);
		}
		long[] b = new long[primefactors.size()];
		for (int i=0; i<primefactors.size(); i++) 
		{
			long e = phi/primefactors.get(i);
			long betaPow = power(beta, e, p);
			long alphaPow = power(alpha, e, p);
			for (long j=0; j<primefactors.get(i); j++) 
			{
				long a1 = power(alphaPow, j, p);
				if (a1 == betaPow) 
				{
					b[i] = j; 
					break;
				}
			}
		}
		long M = 1;
		long[] m = new long[b.length];
		for (int i=0; i<primefactors.size(); i++) 
			M = M*primefactors.get(i);
		for (int i=0; i<primefactors.size(); i++) 
		{
			m[i] = inverse(M/primefactors.get(i), primefactors.get(i));
		}
		long answer = 0;
		for (int i=0; i<b.length; i++) 
		{
			answer = (answer + b[i]*m[i]*M/primefactors.get(i))%M;
		}
		time = System.nanoTime()-start;
		return time;
    }
    
    public boolean isPrime(long n)
    {
    	for(int i=2;i<n;i++)
    	{
    		if(n%i==0)
    			return false;
    	}
		return true;
    }
    
    public void actionPerformed(ActionEvent e)
    {  
    	if(e.getSource().equals(enter))
    	{
    		//Textfield checks
    		int check=0;
    		if(tprime.getText().equals(null)||tprime.getText().equals("")||tgenerator.getText().equals("")||tgenerator.getText().equals(null)||tkey.getText().equals("")||tkey.getText().equals(null))
    		{
    			check=1;
    			JOptionPane.showMessageDialog(f1,"Please enter values", "Error",JOptionPane.ERROR_MESSAGE);
    		}
    		else if(tprime.getText().matches("[a-zA-Z]+"))
    		{
    			check=1;
    			JOptionPane.showMessageDialog(f1,"Cannot enter alphabets", "Error",JOptionPane.ERROR_MESSAGE);
    		}
    		else if(tgenerator.getText().matches("[a-zA-Z]+"))
    		{
    			check=1;
    			JOptionPane.showMessageDialog(f1,"Cannot enter alphabets", "Error",JOptionPane.ERROR_MESSAGE);
    		}
    		else if(tkey.getText().matches("[a-zA-Z]+"))
    		{
    			check=1;
    			JOptionPane.showMessageDialog(f1,"Cannot enter alphabets", "Error",JOptionPane.ERROR_MESSAGE);
    		}
    		else if(!isPrime(Long.parseLong(tprime.getText().trim())))
    		{
    			check=1;
    			JOptionPane.showMessageDialog(f1,"Please enter a Prime Number", "Error",JOptionPane.ERROR_MESSAGE);
    		}
    		if(check==0){
    		long tbrute=0,tbsgs=0,tpohlig=0;
    		tbrute=bruteForce();
    		tbsgs=babyStepGiantStep();
    		tpohlig=pohligHellman();
    		Connection conn = null;
    		Statement stmt = null;
    		ResultSet rs = null;
    		ArrayList<Object[]> data = new ArrayList<>();
    		try
    		{
    			Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL,u,p);
                String q = "insert into log values('"+tprime.getText().trim()+"','"+tgenerator.getText().trim()+"','"+tkey.getText().trim()+"','"+result+"','"+tbrute+"','"+tbsgs+"','"+tpohlig+"');";
                PreparedStatement statement = (PreparedStatement) conn.prepareStatement(q);
	            statement.execute();
    		}
    		catch(Exception e1)
    		{
    			e1.printStackTrace();
    		}
    		//displayResults();// create log table
    		ArrayList<Long> max = new ArrayList<Long>();
    		ArrayList<Long> mid = new ArrayList<Long>();
    		ArrayList<Long> min = new ArrayList<Long>();
    		String columnNames[] = {"Prime Number","Generator","Key","X","Brute Force Time","Baby Step Giant Step Time","Pohlig Hellman Time"};
    		try
    		{
    			Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL,u,p);
                String q = "select * from log;";
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
                	if(rs.getLong(5)>rs.getLong(6)&&rs.getLong(5)>rs.getLong(7))
                    {
                    	max.add(rs.getLong(5));
                    	if(rs.getLong(6)>rs.getLong(7))
                    	{
                    		mid.add(rs.getLong(6));
                    		min.add(rs.getLong(7));
                    	}
                    	else
                    	{
                    		mid.add(rs.getLong(7));
                    		min.add(rs.getLong(6));
                    	}
                    }
                    else if(rs.getLong(6)>rs.getLong(5)&&rs.getLong(6)>rs.getLong(7))
                    {
                    	max.add(rs.getLong(6));
                    	if(rs.getLong(5)>rs.getLong(7))
                    	{
                    		mid.add(rs.getLong(5));
                    		min.add(rs.getLong(7));
                    	}
                    	else
                    	{
                    		mid.add(rs.getLong(7));
                    		min.add(rs.getLong(5));
                    	}
                    }
                    else if(rs.getLong(7)>rs.getLong(6)&&rs.getLong(7)>rs.getLong(5))
                    {
                    	max.add(rs.getLong(7));
                    	if(rs.getLong(6)>rs.getLong(5))
                    	{
                    		mid.add(rs.getLong(6));
                    		min.add(rs.getLong(5));
                    	}
                    	else
                    	{
                    		mid.add(rs.getLong(5));
                    		min.add(rs.getLong(6));
                    	}
                    }
                }
                Object[][] realData = data.toArray(new Object[data.size()][]);
                JTable table_paylist= new JTable(realData, columnNames)
                		{
                			/**
							 * 
							 */
							private static final long serialVersionUID = 1L;

							@Override
                			public Component prepareRenderer(TableCellRenderer renderer, int row, int col)
							{
                		        Component comp = super.prepareRenderer(renderer, row, col);
                		        Object value = getModel().getValueAt(row, col);
                		        if(max.contains(Long.parseLong((String) value)))
                		        {
                		        	//ystem.out.println("IN");
                		        	comp.setBackground(Color.RED);
                		        }
                		        else if(mid.contains(Long.parseLong((String) value)))
                		        {
                		        	comp.setBackground(Color.YELLOW);
                		        }
                		        else if(min.contains(Long.parseLong((String) value)))
                		        {
                		        	comp.setBackground(Color.GREEN);
                		        }
                		        else
                		        {
                		        	comp.setBackground(Color.WHITE);
                		        }
								return comp;
							}
                		};
                /*DefaultTableCellRenderer center = new DefaultTableCellRenderer();
                center.setHorizontalAlignment(SwingConstants.CENTER);
                table_paylist.setDefaultRenderer(getClass(), center);*/
                JScrollPane scroll_paylist= new JScrollPane(table_paylist);        
                table_paylist.setPreferredScrollableViewportSize(new Dimension(800, 200));
                table_paylist.setFillsViewportHeight(true);
                
                //create frame
                f1 = new JFrame("Discrete Log Problem Results");
            	back = new JButton("Back");
            	back.setBounds(200, 300, 100, 25);
            	footer = new JLabel("Copyright "+"\u00a9"+" 2016. ");
            	footer.setBounds(100, 500, 400, 30);
            	back.addActionListener(this);
            	f1.add(back);
            	f1.add(footer);
            	f1.setLayout(new BorderLayout());
                f1.add(scroll_paylist, BorderLayout.CENTER); 
            	//Frame details
            	f1.setSize(700,700);//300 width and 500 height  
            	//f1.setLayout(null);//using no layout managers  
            	f1.setVisible(true);//making the frame visible
            	//Frame details
            	
            	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (int) ((dimension.getWidth() - f1.getWidth()) / 2);
                int y = (int) ((dimension.getHeight() - f1.getHeight()) / 2);
                f1.setLocation(x,y);

    		}
    		catch(Exception e1)
    		{
    			e1.printStackTrace();
    		}
    		}
    	}
    	if(e.getSource() == back)
    	{
    		f.dispose();
    		f1.dispose();
    		new DiscreteLog();
    	}
    }  
    
	public static void main(String args[])throws IOException
	{
		new DiscreteLog();
	}
}
