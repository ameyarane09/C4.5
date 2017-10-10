import java.io.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class SnakesNLadders implements ActionListener
{
    Frame f = new Frame();
    Frame f1 = new Frame();
    JButton b[] = new JButton[101];
    JButton exit = new JButton("EXIT");
    JButton roll = new JButton("ROLL DICE");
    JButton screen = new JButton();
    Label win = new Label("PLAYER WINS!");
    int tiles[][] = new int[10][10];
    int n[] = new int[2];
    static int k;
    public void first()
    {
        int x=50, y=50,ch=0;
        int c=0,d=0;
        for(int i=100;i>0;i--)
        {
            if(i%10==0&&i!=100)
            {
                if(i==90||i==70||i==50||i==30||i==10)
                {
                    x=545;
                    y=y+55;
                    ch=1;
                    d=9;
                }
                else
                {
                    x=50;
                    y=y+55;
                    ch=0;
                    d=0;
                }
                c++;
            }
            tiles[c][d] = i;
            b[i] = new JButton(String.valueOf(i));
            b[i].setBounds(x,y,50,50);
            if(ch==0)
            {
                x+=55;
                d++;
            }
            else
            {
                x-=55;
                d--;
            }
            f.add(b[i]);
        }
        b[1].setText("A B");
        roll.setBounds(250,620,50,20);
        roll.addActionListener(this);
        f.add(roll);
        exit.setBounds(350,620,50,20);
        exit.addActionListener(this);
        screen.setBounds(700,200,100,100);
        screen.setFont(new Font("Calibiri",Font.BOLD,28));
        f.add(screen);
        f.add(exit);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(1000,1000);
        f.setTitle("Snakes and Ladders - Ameya Sachin Rane");
        n[0]=1;
        n[1]=1;
        k=0;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int xo = (int) ((dimension.getWidth() - f.getWidth()) / 2);
        int yo = (int) ((dimension.getHeight() - f.getHeight()) / 2);
        f.setLocation(xo, yo);
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
    String c[] = {"A","B"};
    public void actionPerformed(ActionEvent e)
    {
        Font font = new Font("Calibiri",Font.BOLD,18);
        int num=0;
        SnakesNLadders ob = new SnakesNLadders();
        int m = ob.getNumber();
        if(e.getSource()==exit)
        {
            f.dispose();
        }
        if(e.getSource()==roll)
        {
            num = (int)(Math.random()*6)+1;
            screen.setText(String.valueOf(num));
            n[m]=n[m]+num;
            if(n[0]==n[1])
            {
                b[n[m]].setText("A B");
                
            }
            else
            {
                b[n[m]].setText(c[m]);
                b[n[m]].setText(String.valueOf(n[m]));
            }
            /*int diff=0;
            DateFormat df = new SimpleDateFormat("hh:mm:ss");
            Date date = new Date();
            int hour = Integer.parseInt(df.format(date).toString().substring(0,2));
            int min = Integer.parseInt(df.format(date).toString().substring(3,5));
            int sec = Integer.parseInt(df.format(date).toString().substring(6));
            int time1 = (hour*60*60)+(min*60)+sec;
            DateFormat df1 = new SimpleDateFormat("hh:mm:ss");
            Date dateobj = new Date();
            hour = Integer.parseInt(df1.format(dateobj).toString().substring(0,2));
            min = Integer.parseInt(df1.format(dateobj).toString().substring(3,5));
            sec = Integer.parseInt(df1.format(dateobj).toString().substring(6));
            int time2 = (hour*60*60)+(min*60)+sec;
            diff=1;
            for(int i=1;i<=4;i++)
            {
                while(time2-time1!=diff)
                {
                    DateFormat df2 = new SimpleDateFormat("hh:mm:ss");
                    Date dateob = new Date();
                    hour = Integer.parseInt(df2.format(dateob).toString().substring(0,2));
                    min = Integer.parseInt(df2.format(dateob).toString().substring(3,5));
                    sec = Integer.parseInt(df2.format(dateob).toString().substring(6));
                    time2 = (hour*60*60)+(min*60)+sec;
                }
                b[i].setText("o");

                diff=diff+1;
                //b[i-1].setText(String.valueOf(i-1));
            }*/
            
            win.setBounds(25,25,100,40);
            win.setFont(font);
            if(n[m]==100)
            {
                f1.add(win);
                f1.setLayout(null);
                f1.setVisible(true);
                f1.setSize(250,250);
                f1.setTitle("Snakes and Ladders - Ameya Sachin Rane");
                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int xo = (int) ((dimension.getWidth() - f1.getWidth()) / 2);
                int yo = (int) ((dimension.getHeight() - f1.getHeight()) / 2);
                f1.setLocation(xo, yo);
            }
            else if(n[m]>100)
            {
                n[m]=n[m]-num;
            }
            
        }
    }
}