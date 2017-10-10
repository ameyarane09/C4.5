package com.pane;

import com.login.*;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class TabbedPaneDemo extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JButton logout = new JButton("Logout");
	
    public TabbedPaneDemo() {
        initializeUI();
    }

    private void initializeUI() {
        JTabbedPane pane = new JTabbedPane();
        
        logout.setBounds(100, 100, 50, 20);
        logout.addActionListener(this);

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.add(new JLabel("Register"));
        // Add Dashboard Tab
        pane.addTab("Register", dashboardPanel);

        JPanel transactionPanel = new JPanel();
        transactionPanel.add(new JLabel("Lease"));
        // Add Transactions Tab
        pane.addTab("Lease", transactionPanel);

        JPanel accountPanel = new JPanel();
        accountPanel.add(new JLabel("Inventory"));
        // Add Account Tab
        pane.addTab("Inventory", accountPanel);
        
        JPanel logoutPanel = new JPanel();
        logoutPanel.add(new JLabel("Logout"));
        logoutPanel.add(logout);
        pane.addTab("Logout", logoutPanel);
        
        /*logout.addActionListener(this);
        pane.add(logout);*/

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(400, 200));
        this.add(pane, BorderLayout.CENTER);
    }
    
    /*public void actionPerformed(ActionEvent ae)
	{
    	System.out.println("IN");
    	if(ae.getSource().equals(logout))
    	{
    		new Login();
    	}
	}*/

    public static void showFrame() {
        JPanel panel = new TabbedPaneDemo();
        panel.setOpaque(true);
        	
        JFrame frame = new JFrame("BookLease");
        
        //frame.add(logout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TabbedPaneDemo.showFrame();
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
