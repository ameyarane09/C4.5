import java.io.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
public class XO implements ActionListener
{
    Frame f = new Frame();
    Frame f1 = new Frame();
    
    static int k;
    
    Label x = new Label("PLAYER 1 (O):");
    Label o = new Label("PLAYER 2 (X):");
    Label p1 = new Label("PLAYER 1 WINS");
    Label p2 = new Label("PLAYER 2 WINS");
    Label draw = new Label("IT'S A DRAW!");
    Label message = new Label("START NEW GAME?");
    
    JLabel cross= new JLabel("X");
    JLabel criss= new JLabel("O");
    
    JButton b1; 
    JButton b2; 
    JButton b3; 
    JButton b4; 
    JButton b5; 
    JButton b6; 
    JButton b7; 
    JButton b8; 
    JButton b9; 
    
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    
    int visited[];
    
    JButton exit = new JButton("EXIT");
    JButton reset = new JButton("RESET");
    JButton yes = new JButton("YES");
    JButton no = new JButton("NO");
    
    public void firstFrame()
    {
        b1 = new JButton();
        b1.setText("");
        b2 = new JButton();
        b3 = new JButton();
        b4 = new JButton();
        b5 = new JButton();
        b6 = new JButton();
        b7 = new JButton();
        b8 = new JButton();
        b9 = new JButton();
        
        visited = new int[9];
        
        for(int i=0;i<9;i++)
        visited[i]=0;
        
        x.setBounds(10,50,90,20);
        t1.setBounds(120,50,100,20);
        o.setBounds(10,100,90,20);
        t2.setBounds(120,100,100,20);
        
        b1.setBounds(10,150,100,100);
        b2.setBounds(115,150,100,100);
        b3.setBounds(220,150,100,100);
        b4.setBounds(10,255,100,100);
        b5.setBounds(115,255,100,100);
        b6.setBounds(220,255,100,100);
        b7.setBounds(10,360,100,100);
        b8.setBounds(115,360,100,100);
        b9.setBounds(220,360,100,100);
        
        exit.setBounds(195,475,50,50);
        reset.setBounds(90,475,50,50);
               
        k=0;
        
        f.add(x);
        f.add(t1);
        f.add(o);
        f.add(t2);
        
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);  
        
        
        
        f.add(exit);
        f.add(reset);
        
       
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);       
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        
        reset.addActionListener(this);
        exit.addActionListener(this);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(330,550);
        f.setTitle("CrissCross - Ameya Sachin Rane");
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
    }
    
    public int getNumber()
    {
        int n;
        k++;
        if(k%2==0)
        n=1;
        else
        n=0;
        return n;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        XO ob =  new XO();
        int n = ob.getNumber();
        String s="ameya";
        p1.setBounds(50,40,200,30);
        p2.setBounds(50,40,200,30);
        Font font = new Font("Calibiri",Font.BOLD,22);        
        p1.setFont(font); 
        p2.setFont(font);
        draw.setBounds(50,40,200,30);
        draw.setFont(font);
        criss.setFont(font);
        cross.setFont(font);
        cross.setForeground(Color.RED);
        criss.setForeground(Color.BLUE);
        String cri = criss.getText();
        String cro = cross.getText();
        message.setBounds(50,100,200,30);
        yes.setBounds(50,145,50,50);
        no.setBounds(125,145,50,50);
        int sum=0;
        String args[] = {};
        if(e.getSource()==b1)
        {
            if(visited[0]==1)
            {
                k--;
            }
            else if(n==1)
            {
                s="X";
                b1.setText(cross.getText());                
            }
            else
            {
                s="O";
                b1.setText("O");                
            }   
            visited[0]=1;
            b1.setFont(font);
        }
        
        else if(e.getSource()==b2)
        {
            if(visited[1]==1)
            k--;
            else if(n==1)
            {
                b2.setText("X");
                s="X";
            }
            else
            {
                b2.setText("O");                
                s="O";
            }
            visited[1]=1;
            b2.setFont(font);
        }
        
        else if(e.getSource()==b3)
        {
            if(visited[2]==1)
            k--;
            else if(n==1)
            {
                b3.setText("X");
                s="X";
            }
            else
            {
                b3.setText("O");
                s="O";
            }
            visited[2]=1;
            b3.setFont(font);
        }
        
        else if(e.getSource()==b4)
        {
            if(visited[3]==1)
            k--;
            else if(n==1)
            {
                b4.setText("X");
                s="X";
            }
            else
            {
                b4.setText("O");
                s="O";
            }
            visited[3]=1;
            b4.setFont(font);
        }
        
        else if(e.getSource()==b5)
        {
            if(visited[4]==1)
            k--;
            else if(n==1)
            {
                b5.setText("X");
                s="X";
            }
            else
            {
                b5.setText("O");
                s="O";
            }
            visited[4]=1;
            b5.setFont(font);
        }
        
        else if(e.getSource()==b6)
        {
            if(visited[5]==1)
            k--;
            else if(n==1)
            {
                b6.setText("X");
                s="X";
            }
            else
            {
                b6.setText("O");
                s="O";
            }
            visited[5]=1;
            b6.setFont(font);
        }
        
        else if(e.getSource()==b7)
        {
            if(visited[6]==1)
            k--;
            else if(n==1)
            {
                b7.setText("X");
                s="X";
            }
            else
            {
                b7.setText("O");
                s="O";
            }
            visited[6]=1;
            b7.setFont(font);
        }
        
        else if(e.getSource()==b8)
        {
            if(visited[7]==1)
            k--;
            else if(n==1)
            {
                b8.setText("X");
                s="X";
            }
            else
            {
                b8.setText("O");
                s="O";
            }
            visited[7]=1;
            b8.setFont(font);
        }
        
        else if(e.getSource()==b9)
        {
            if(visited[8]==1)
            k--;
            else if(n==1)
            {
                b9.setText("X");
                s="X";
            }
            else
            {
                b9.setText("O");
                s="O";
            }
            visited[8]=1;
            b9.setFont(font);
        }
        
        else
        {

        }
        
        if((b1.getText().equalsIgnoreCase(s)&&b2.getText().equalsIgnoreCase(s)&&b3.getText().equalsIgnoreCase(s))||(b4.getText().equalsIgnoreCase(s)&&b5.getText().equalsIgnoreCase(s)&&b6.getText().equalsIgnoreCase(s))
        ||(b7.getText().equalsIgnoreCase(s)&&b8.getText().equalsIgnoreCase(s)&&b9.getText().equalsIgnoreCase(s))||(b1.getText().equalsIgnoreCase(s)&&b4.getText().equalsIgnoreCase(s)&&b7.getText().equalsIgnoreCase(s))
        ||(b2.getText().equalsIgnoreCase(s)&&b5.getText().equalsIgnoreCase(s)&&b8.getText().equalsIgnoreCase(s))||(b3.getText().equalsIgnoreCase(s)&&b6.getText().equalsIgnoreCase(s)&&b9.getText().equalsIgnoreCase(s))
        ||(b1.getText().equalsIgnoreCase(s)&&b5.getText().equalsIgnoreCase(s)&&b9.getText().equalsIgnoreCase(s))||(b3.getText().equalsIgnoreCase(s)&&b5.getText().equalsIgnoreCase(s)&&b7.getText().equalsIgnoreCase(s)))
        {
            if(s.equalsIgnoreCase("O"))
            {
                f1.add(p1);
            }
            else 
            {
                f1.add(p2);
            }
            f1.add(message);
            f1.add(yes);
            f1.add(no);
            yes.addActionListener(this);
            no.addActionListener(this);
            f1.setLayout(null);
            f1.setVisible(true);
            f1.setTitle("CrissCross - Ameya Sachin Rane");
            f1.setSize(300,300);
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - f1.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - f1.getHeight()) / 2);
            f1.setLocation(x, y);
            
            
        }
        
        for(int i=0;i<9;i++)
        {
            sum = sum + visited[i];
        }
        if(sum==9)
        {
            f1.add(draw);
            f1.add(message);
            f1.add(yes);
            f1.add(no);
            yes.addActionListener(this);
            no.addActionListener(this);
            f1.setLayout(null);
            f1.setVisible(true);
            f1.setTitle("CrissCross - Ameya Sachin Rane");
            f1.setSize(300,300);
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - f1.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - f1.getHeight()) / 2);
            f1.setLocation(x, y);
        }
        
        if(e.getSource()==yes)
        {
            f1.dispose();
            f.dispose();
            ob.firstFrame();            
        }
        
        if(e.getSource()==no)
        {
            //System.exit(0);
            f1.dispose();
            f.dispose();
        }
        
        if(e.getSource()==reset)
        {
            f.dispose();
            ob.firstFrame();
        }
        
        if(e.getSource()==exit)
        {
            f.dispose();
            //System.exit(0);
        }
    }
    public static void main(String args[])
    {
        XO ob =  new XO();
        ob.firstFrame();
    }
}