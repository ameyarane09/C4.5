import java.io.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
public class Sudoku implements ActionListener
{
    Frame f = new Frame();
    Frame f1 = new Frame();
    
    JButton b[] = new JButton[82];
    JButton exit = new JButton("EXIT");
    JButton vertical1 = new JButton();
    JButton vertical2 = new JButton();
    JButton horizontal1 = new JButton();
    JButton horizontal2 = new JButton();
    JButton cancel = new JButton("CANCEL");
    JButton done = new JButton("DONE");
    JButton c[] = new JButton[10];
    
    int n;
    int h;
    
    int num[][] = {{0,4,0,0,0,0,0,2,0},{3,0,0,8,0,7,0,0,4},{0,8,0,5,0,6,0,1,0},{4,0,9,3,0,5,2,0,6},{0,0,0,0,0,0,0,0,0},{2,0,5,9,0,8,3,0,7},{0,6,0,7,0,9,0,5,0},{9,0,0,2,0,4,0,0,1},{0,2,0,0,0,0,0,3,0}};
    //int num[][] = {{0,3,7,1,0,0,0,6,0},{0,0,0,0,8,0,2,0,0},{6,8,0,0,7,0,0,0,0},{0,4,0,6,0,0,0,0,0},{0,5,8,2,0,9,7,3,0},{0,0,0,0,0,7,0,2,0},{0,0,0,0,9,0,0,1,7},{0,0,4,0,6,0,0,0,0},{0,1,0,0,0,3,9,4,0}};
    
    int q[] = new int[81];
    
    public void first()
    {
        int x=50, y=50;
        for(int i=1;i<=81;i++)
        {
            b[i] = new JButton();
            b[i].setBounds(x,y,50,50);
            x+=55;
            if(i%9==0)
            {
                x=50;
                y=y+55;
            }
            b[i].addActionListener(this);
            /*b[i].setBackground(Color.gray);
            b[i].setOpaque(true);
            b[i].setBorderPainted(false);*/
            f.add(b[i]);

        }
        
        int sum=0;
        
        vertical1.setBounds(210,50,5,490);
        vertical1.setBackground(Color.black);
        vertical1.setOpaque(true);
        vertical1.setBorderPainted(false);
        f.add(vertical1);
        vertical2.setBounds(375,50,5,490);
        vertical2.setBackground(Color.black);
        vertical2.setOpaque(true);
        vertical2.setBorderPainted(false);
        f.add(vertical2);
        horizontal1.setBounds(50,210,490,5);
        horizontal1.setBackground(Color.black);
        horizontal1.setOpaque(true);
        horizontal1.setBorderPainted(false);
        f.add(horizontal1);
        horizontal2.setBounds(50,375,490,5);
        horizontal2.setBackground(Color.black);
        horizontal2.setOpaque(true);
        horizontal2.setBorderPainted(false);
        f.add(horizontal2);
        
        exit.setBounds(250,580,100,30);
        exit.addActionListener(this);
        f.add(exit);
        
        Font font = new Font("Calibiri",Font.BOLD,18);
        
        h=0;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                sum++;
                if(num[i][j]==0)
                {}
                else
                {
                    b[sum].setText(Integer.toString(num[i][j]));
                    b[sum].setForeground(Color.blue);
                    b[sum].setFont(font);
                    q[h]=sum;
                    h++;
                }
            }
        }
        
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(585,630);
        f.setTitle("Match the Color - Ameya Sachin Rane");
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int xo = (int) ((dimension.getWidth() - f.getWidth()) / 2);
        int yo = (int) ((dimension.getHeight() - f.getHeight()) / 2);
        f.setLocation(xo, yo);
        
        x=50;
        y=50;
        for(int i=1;i<=9;i++)
        {
            c[i] = new JButton(String.valueOf(i));
            c[i].setBounds(x,y,50,50);
            x+=55;
            if(i%3==0)
            {
                x=50;
                y=y+55;
            }
            c[i].addActionListener(this);
            /*b[i].setBackground(Color.gray);
            b[i].setOpaque(true);
            b[i].setBorderPainted(false);*/
            f1.add(c[i]);
        }
        f1.setLayout(null);
        f1.setVisible(false);
        f1.setSize(250,250);
        f1.setTitle("Match the Color - Ameya Sachin Rane");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        xo = (int) ((dim.getWidth() - f1.getWidth()) / 2);
        yo = (int) ((dim.getHeight() - f1.getHeight()) / 2);
        f1.setLocation(xo, yo);
    }
    
    
    
    public void actionPerformed(ActionEvent e)
    {
        Font font = new Font("Calibiri",Font.BOLD,18);
        int sum=0;
        int x=0,y=0;
        Sudoku ob = new Sudoku();
        int check=0;
        if(e.getSource()==exit)
        {
            f.dispose();
        }
        if(e.getSource()==c[1])
        {
            b[n].setText("1");
            f1.dispose();
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    sum++;
                    if(b[n]==b[sum])
                    {
                        x=i;
                        y=j;
                        break;
                    }
                }
            }
            num[x][y] = 1;
            for(int i=0;i<9;i++)
            {
                if(i==x)
                {}
                else if(num[i][y]==1)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            for(int j=0;j<9;j++)
            {
                if(j==y)
                {}
                else if(num[x][j]==1)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            if(check==0)
            b[n].setForeground(Color.green);
            b[n].setFont(font);
        }
        if(e.getSource()==c[2])
        {
            b[n].setText("2");
            f1.dispose();
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    sum++;
                    if(b[n]==b[sum])
                    {
                        x=i;
                        y=j;
                        break;
                    }
                }
            }
            num[x][y] = 2;
            for(int i=0;i<9;i++)
            {
                if(i==x)
                {}
                else if(num[i][y]==2)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            for(int j=0;j<9;j++)
            {
                if(j==y)
                {}
                else if(num[x][j]==2)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            if(check==0)
            b[n].setForeground(Color.green);
            b[n].setFont(font);
        }
        if(e.getSource()==c[3])
        {
            b[n].setText("3");
            f1.dispose();
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    sum++;
                    if(b[n]==b[sum])
                    {
                        x=i;
                        y=j;
                        break;
                    }
                }
            }
            num[x][y] = 3;
            for(int i=0;i<9;i++)
            {
                if(i==x)
                {}
                else if(num[i][y]==3)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            for(int j=0;j<9;j++)
            {
                if(j==y)
                {}
                else if(num[x][j]==3)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            if(check==0)
            b[n].setForeground(Color.green);
            b[n].setFont(font);
        }
        if(e.getSource()==c[4])
        {
            b[n].setText("4");
            f1.dispose();
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    sum++;
                    if(b[n]==b[sum])
                    {
                        x=i;
                        y=j;
                        break;
                    }
                }
            }
            num[x][y] = 4;
            for(int i=0;i<9;i++)
            {
                if(i==x)
                {}
                else if(num[i][y]==4)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            for(int j=0;j<9;j++)
            {
                if(j==y)
                {}
                else if(num[x][j]==4)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            if(check==0)
            b[n].setForeground(Color.green);
            b[n].setFont(font);
        }
        if(e.getSource()==c[5])
        {
            b[n].setText("5");
            f1.dispose();
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    sum++;
                    if(b[n]==b[sum])
                    {
                        x=i;
                        y=j;
                        break;
                    }
                }
            }
            num[x][y] = 5;
            for(int i=0;i<9;i++)
            {
                if(i==x)
                {}
                else if(num[i][y]==5)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            for(int j=0;j<9;j++)
            {
                if(j==y)
                {}
                else if(num[x][j]==5)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            if(check==0)
            b[n].setForeground(Color.green);
            b[n].setFont(font);
        }
        if(e.getSource()==c[6])
        {
            b[n].setText("6");
            f1.dispose();
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    sum++;
                    if(b[n]==b[sum])
                    {
                        x=i;
                        y=j;
                        break;
                    }
                }
            }
            num[x][y] = 6;
            for(int i=0;i<9;i++)
            {
                if(i==x)
                {}
                else if(num[i][y]==6)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            for(int j=0;j<9;j++)
            {
                if(j==y)
                {}
                else if(num[x][j]==6)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            if(check==0)
            b[n].setForeground(Color.green);
            b[n].setFont(font);
        }
        if(e.getSource()==c[7])
        {
            b[n].setText("7");
            f1.dispose();
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    sum++;
                    if(b[n]==b[sum])
                    {
                        x=i;
                        y=j;
                        break;
                    }
                }
            }
            num[x][y] = 7;
            for(int i=0;i<9;i++)
            {
                if(i==x)
                {}
                else if(num[i][y]==7)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            for(int j=0;j<9;j++)
            {
                if(j==y)
                {}
                else if(num[x][j]==7)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            if(check==0)
            b[n].setForeground(Color.green);
            b[n].setFont(font);
        }
        if(e.getSource()==c[8])
        {
            b[n].setText("8");
            f1.dispose();
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    sum++;
                    if(b[n]==b[sum])
                    {
                        x=i;
                        y=j;
                        break;
                    }
                }
            }
            num[x][y] = 8;
            for(int i=0;i<9;i++)
            {
                if(i==x)
                {}
                else if(num[i][y]==8)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            for(int j=0;j<9;j++)
            {
                if(j==y)
                {}
                else if(num[x][j]==8)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            if(check==0)
            b[n].setForeground(Color.green);
            b[n].setFont(font);
        }
        if(e.getSource()==c[9])
        {
            b[n].setText("9");
            f1.dispose();
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    sum++;
                    if(b[n]==b[sum])
                    {
                        x=i;
                        y=j;
                        break;
                    }
                }
            }
            num[x][y] = 9;
            for(int i=0;i<9;i++)
            {
                if(i==x)
                {}
                else if(num[i][y]==9)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            for(int j=0;j<9;j++)
            {
                if(j==y)
                {}
                else if(num[x][j]==9)
                {
                    b[n].setForeground(Color.red);
                    check=1;
                    break;
                }
            }
            if(check==0)
            b[n].setForeground(Color.green);
            b[n].setFont(font);
        }
        
        for(int i=0;i<h;i++)
        {
            if(/*e.getSource()==b[2]||e.getSource()==b[8]||e.getSource()==b[10]||e.getSource()==b[13]||e.getSource()==b[15]||e.getSource()==b[18]||e.getSource()==b[20]||
            e.getSource()==b[22]||e.getSource()==b[24]||e.getSource()==b[26]||e.getSource()==b[28]||e.getSource()==b[30]||e.getSource()==b[31]||e.getSource()==b[33]||
            e.getSource()==b[34]||e.getSource()==b[36]||e.getSource()==b[46]||e.getSource()==b[48]||e.getSource()==b[49]||e.getSource()==b[51]||e.getSource()==b[52]||
            e.getSource()==b[54]||e.getSource()==b[56]||e.getSource()==b[58]||e.getSource()==b[60]||e.getSource()==b[62]||e.getSource()==b[64]||e.getSource()==b[67]||
            e.getSource()==b[69]||e.getSource()==b[72]||e.getSource()==b[74]||e.getSource()==b[80]*/e.getSource()==b[q[i]])
            {break;}
            else if(e.getSource()==b[i])
            {
                n=i;
                f1.setVisible(true);
                break;
            }
        }
    }
    
    public static void main(String args[])
    {
        Sudoku ob = new Sudoku();
        ob.first();
    }
}