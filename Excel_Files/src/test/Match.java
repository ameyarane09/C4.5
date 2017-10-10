package test;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
public class Match implements ActionListener
{
    Frame f = new Frame();
    Frame f1 = new Frame();
    
    JButton b[] = new JButton[66];
    JButton exit = new JButton("EXIT");
    
    String color[] = new String[66];
    String colors[] = new String[4];
    int v[] = new int[66];
    
    int num[] = new int[37];
    public void first()
    {
        int x=50, y=50;
        for(int i=1;i<=64;i++)
        {
            b[i] = new JButton();
            b[i].setBounds(x,y,50,50);
            x+=55;
            if(i%8==0)
            {
                x=50;
                y=y+55;
            }
            b[i].addActionListener(this);
            b[i].setBackground(Color.gray);
            b[i].setOpaque(true);
            b[i].setBorderPainted(false);
            f.add(b[i]);
            v[i]=0;
        }
        exit.setBounds(200,600,100,30);
        exit.addActionListener(this);
        f.add(exit);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(1000,1000);
        f.setTitle("Match the Color - Ameya Sachin Rane");
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int xo = (int) ((dimension.getWidth() - f.getWidth()) / 2);
        int yo = (int) ((dimension.getHeight() - f.getHeight()) / 2);
        f.setLocation(xo, yo);
    }
    
    static int n=1;
    static int k=0;
    
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
    String chance[] = new String[2];
    int ch[] = new int[2];
    public void actionPerformed(ActionEvent e)
    {
        Match ob = new Match();
        int p = ob.getNumber();
        if(e.getSource()==b[1]&&v[1]==0)
        {
            b[1].setBackground(Color.RED);
            b[1].setOpaque(true);
            b[1].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 1;
        }
        if(e.getSource()==b[2]&&v[2]==0)
        {
            b[2].setBackground(Color.green);
            b[2].setOpaque(true);
            b[2].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 2;
        }
        if(e.getSource()==b[3]&&v[3]==0)
        {
            b[3].setBackground(Color.yellow);
            b[3].setOpaque(true);
            b[3].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 3;
        }
        if(e.getSource()==b[4]&&v[4]==0)
        {
            b[4].setBackground(Color.blue);
            b[4].setOpaque(true);
            b[4].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 4;
        }
        if(e.getSource()==b[5]&&v[5]==0)
        {
            b[5].setBackground(Color.yellow);
            b[5].setOpaque(true);
            b[5].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 5;
        }
        if(e.getSource()==b[6]&&v[6]==0)
        {
            b[6].setBackground(Color.green);
            b[6].setOpaque(true);
            b[6].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 6;
        }
        if(e.getSource()==b[7]&&v[7]==0)
        {
            b[7].setBackground(Color.RED);
            b[7].setOpaque(true);
            b[7].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 7;
        }
        if(e.getSource()==b[8]&&v[8]==0)
        {
            b[8].setBackground(Color.blue);
            b[8].setOpaque(true);
            b[8].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 8;
        }
        if(e.getSource()==b[9]&&v[9]==0)
        {
            b[9].setBackground(Color.blue);
            b[9].setOpaque(true);
            b[9].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 9;
        }
        if(e.getSource()==b[10]&&v[10]==0)
        {
            b[10].setBackground(Color.RED);
            b[10].setOpaque(true);
            b[10].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 10;
        }
        if(e.getSource()==b[11]&&v[11]==0)
        {
            b[11].setBackground(Color.green);
            b[11].setOpaque(true);
            b[11].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 11;
        }
        if(e.getSource()==b[12]&&v[12]==0)
        {
            b[12].setBackground(Color.yellow);
            b[12].setOpaque(true);
            b[12].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 12;
        }
        if(e.getSource()==b[13]&&v[13]==0)
        {
            b[13].setBackground(Color.green);
            b[13].setOpaque(true);
            b[13].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 13;
        }
        if(e.getSource()==b[14]&&v[14]==0)
        {
            b[14].setBackground(Color.RED);
            b[14].setOpaque(true);
            b[14].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 14;
        }
        if(e.getSource()==b[15]&&v[15]==0)
        {
            b[15].setBackground(Color.blue);
            b[15].setOpaque(true);
            b[15].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 15;
        }
        if(e.getSource()==b[16]&&v[16]==0)
        {
            b[16].setBackground(Color.yellow);
            b[16].setOpaque(true);
            b[16].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 16;
        }
        if(e.getSource()==b[17]&&v[17]==0)
        {
            b[17].setBackground(Color.yellow);
            b[17].setOpaque(true);
            b[17].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 17;
        }
        if(e.getSource()==b[18]&&v[18]==0)
        {
            b[18].setBackground(Color.RED);
            b[18].setOpaque(true);
            b[18].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 18;
        }
        if(e.getSource()==b[19]&&v[19]==0)
        {
            b[19].setBackground(Color.blue);
            b[19].setOpaque(true);
            b[19].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 19;
        }
        if(e.getSource()==b[20]&&v[20]==0)
        {
            b[20].setBackground(Color.green);
            b[20].setOpaque(true);
            b[20].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 20;
        }
        if(e.getSource()==b[21]&&v[21]==0)
        {
            b[21].setBackground(Color.blue);
            b[21].setOpaque(true);
            b[21].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 21;
        }
        if(e.getSource()==b[22]&&v[22]==0)
        {
            b[22].setBackground(Color.RED);
            b[22].setOpaque(true);
            b[22].setBorderPainted(false);
            chance[p] = "red";
            ch[p] =22;
        }
        if(e.getSource()==b[23]&&v[23]==0)
        {
            b[23].setBackground(Color.RED);
            b[23].setOpaque(true);
            b[23].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 23;
        }
        if(e.getSource()==b[24]&&v[24]==0)
        {
            b[24].setBackground(Color.green);
            b[24].setOpaque(true);
            b[24].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 24;
        }
        if(e.getSource()==b[25]&&v[25]==0)
        {
            b[25].setBackground(Color.yellow);
            b[25].setOpaque(true);
            b[25].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 25;
        }
        if(e.getSource()==b[26]&&v[26]==0)
        {
            b[26].setBackground(Color.blue);
            b[26].setOpaque(true);
            b[26].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 26;
        }
        if(e.getSource()==b[27]&&v[27]==0)
        {
            b[27].setBackground(Color.blue);
            b[27].setOpaque(true);
            b[27].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 27;
        }
        if(e.getSource()==b[28]&&v[28]==0)
        {
            b[28].setBackground(Color.green);
            b[28].setOpaque(true);
            b[28].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 28;
        }
        if(e.getSource()==b[29]&&v[29]==0)
        {
            b[29].setBackground(Color.yellow);
            b[29].setOpaque(true);
            b[29].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 29;
        }
        if(e.getSource()==b[30]&&v[30]==0)
        {
            b[30].setBackground(Color.yellow);
            b[30].setOpaque(true);
            b[30].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 30;
        }
        if(e.getSource()==b[31]&&v[31]==0)
        {
            b[31].setBackground(Color.RED);
            b[31].setOpaque(true);
            b[31].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 31;
        }
        if(e.getSource()==b[32]&&v[32]==0)
        {
            b[32].setBackground(Color.blue);
            b[32].setOpaque(true);
            b[32].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 32;
        }
        if(e.getSource()==b[33]&&v[33]==0)
        {
            b[33].setBackground(Color.green);
            b[33].setOpaque(true);
            b[33].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 33;
        }
        if(e.getSource()==b[34]&&v[34]==0)
        {
            b[34].setBackground(Color.yellow);
            b[34].setOpaque(true);
            b[34].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 34;
        }
        if(e.getSource()==b[35]&&v[35]==0)
        {
            b[35].setBackground(Color.RED);
            b[35].setOpaque(true);
            b[35].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 35;
        }
        if(e.getSource()==b[36]&&v[36]==0)
        {
            b[36].setBackground(Color.green);
            b[36].setOpaque(true);
            b[36].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 36;
        }
        if(e.getSource()==b[37]&&v[37]==0)
        {
            b[37].setBackground(Color.RED);
            b[37].setOpaque(true);
            b[37].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 37;
        }
        if(e.getSource()==b[38]&&v[38]==0)
        {
            b[38].setBackground(Color.yellow);
            b[38].setOpaque(true);
            b[38].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 38;
        }
        if(e.getSource()==b[39]&&v[39]==0)
        {
            b[39].setBackground(Color.green);
            b[39].setOpaque(true);
            b[39].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 39;
        }
        if(e.getSource()==b[40]&&v[40]==0)
        {
            b[40].setBackground(Color.RED);
            b[40].setOpaque(true);
            b[40].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 40;
        }
        if(e.getSource()==b[41]&&v[41]==0)
        {
            b[41].setBackground(Color.yellow);
            b[41].setOpaque(true);
            b[41].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 41;
        }
        if(e.getSource()==b[42]&&v[42]==0)
        {
            b[42].setBackground(Color.green);
            b[42].setOpaque(true);
            b[42].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 42;
        }
        if(e.getSource()==b[43]&&v[43]==0)
        {
            b[43].setBackground(Color.RED);
            b[43].setOpaque(true);
            b[43].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 43;
        }
        if(e.getSource()==b[44]&&v[44]==0)
        {
            b[44].setBackground(Color.blue);
            b[44].setOpaque(true);
            b[44].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 44;
        }
        if(e.getSource()==b[45]&&v[45]==0)
        {
            b[45].setBackground(Color.blue);
            b[45].setOpaque(true);
            b[45].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 45;
        }
        if(e.getSource()==b[46]&&v[46]==0)
        {
            b[46].setBackground(Color.blue);
            b[46].setOpaque(true);
            b[46].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 46;
        }
        if(e.getSource()==b[47]&&v[47]==0)
        {
            b[47].setBackground(Color.yellow);
            b[47].setOpaque(true);
            b[47].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 47;
        }
        if(e.getSource()==b[48]&&v[48]==0)
        {
            b[48].setBackground(Color.red);
            b[48].setOpaque(true);
            b[48].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 48;
        }
        if(e.getSource()==b[49]&&v[49]==0)
        {
            b[49].setBackground(Color.green);
            b[49].setOpaque(true);
            b[49].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 49;
        }
        if(e.getSource()==b[50]&&v[50]==0)
        {
            b[50].setBackground(Color.green);
            b[50].setOpaque(true);
            b[50].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 50;
        }
        if(e.getSource()==b[51]&&v[51]==0)
        {
            b[51].setBackground(Color.red);
            b[51].setOpaque(true);
            b[51].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 51;
        }
        if(e.getSource()==b[52]&&v[52]==0)
        {
            b[52].setBackground(Color.yellow);
            b[52].setOpaque(true);
            b[52].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 52;
        }
        if(e.getSource()==b[53]&&v[53]==0)
        {
            b[53].setBackground(Color.blue);
            b[53].setOpaque(true);
            b[53].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 53;
        }
        if(e.getSource()==b[54]&&v[54]==0)
        {
            b[54].setBackground(Color.yellow);
            b[54].setOpaque(true);
            b[54].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 54;
        }
        if(e.getSource()==b[55]&&v[55]==0)
        {
            b[55].setBackground(Color.green);
            b[55].setOpaque(true);
            b[55].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 55;
        }
        if(e.getSource()==b[56]&&v[56]==0)
        {
            b[56].setBackground(Color.blue);
            b[56].setOpaque(true);
            b[56].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 56;
        }
        if(e.getSource()==b[57]&&v[57]==0)
        {
            b[57].setBackground(Color.red);
            b[57].setOpaque(true);
            b[57].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 57;
        }
        if(e.getSource()==b[58]&&v[58]==0)
        {
            b[58].setBackground(Color.blue);
            b[58].setOpaque(true);
            b[58].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 58;
        }
        if(e.getSource()==b[59]&&v[59]==0)
        {
            b[59].setBackground(Color.yellow);
            b[59].setOpaque(true);
            b[59].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 59;
        }
        if(e.getSource()==b[60]&&v[60]==0)
        {
            b[60].setBackground(Color.green);
            b[60].setOpaque(true);
            b[60].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 60;
        }
        if(e.getSource()==b[61]&&v[61]==0)
        {
            b[61].setBackground(Color.green);
            b[61].setOpaque(true);
            b[61].setBorderPainted(false);
            chance[p] = "green";
            ch[p] = 61;
        }
        if(e.getSource()==b[62]&&v[62]==0)
        {
            b[62].setBackground(Color.yellow);
            b[62].setOpaque(true);
            b[62].setBorderPainted(false);
            chance[p] = "yellow";
            ch[p] = 62;
        }
        if(e.getSource()==b[63]&&v[63]==0)
        {
            b[63].setBackground(Color.blue);
            b[63].setOpaque(true);
            b[63].setBorderPainted(false);
            chance[p] = "blue";
            ch[p] = 63;
        }
        if(e.getSource()==b[64]&&v[64]==0)
        {
            b[64].setBackground(Color.red);
            b[64].setOpaque(true);
            b[64].setBorderPainted(false);
            chance[p] = "red";
            ch[p] = 64;
        }
        if(p==1)
        {
            if(ch[p-1]==ch[p])
            {
                b[ch[p-1]].setBackground(Color.gray);
                b[ch[p-1]].setOpaque(true);
                b[ch[p-1]].setBorderPainted(false);
                b[ch[p]].setBackground(Color.gray);
                b[ch[p]].setOpaque(true);
                b[ch[p]].setBorderPainted(false);
            }
            else if(chance[p-1].equalsIgnoreCase(chance[p]))
            {
                b[ch[p-1]].setBackground(Color.white);
                b[ch[p-1]].setOpaque(true);
                b[ch[p-1]].setBorderPainted(false);
                b[ch[p]].setBackground(Color.white);
                b[ch[p]].setOpaque(true);
                b[ch[p]].setBorderPainted(false);
                v[ch[p-1]] = 1;
                v[ch[p]] = 1;
            }
            else
            {
                b[ch[p-1]].setBackground(Color.gray);
                b[ch[p-1]].setOpaque(true);
                b[ch[p-1]].setBorderPainted(false);
                b[ch[p]].setBackground(Color.gray);
                b[ch[p]].setOpaque(true);
                b[ch[p]].setBorderPainted(false);
            }
            
        }
        if(e.getSource()==exit)
        {
            f.dispose();
        }
    }
    public static void main(String args[])throws IOException
    {
    	Match ob = new Match();
    	ob.first();
    }
}