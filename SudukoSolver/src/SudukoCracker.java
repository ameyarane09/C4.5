import java.io.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
public class SudokuCracker implements ActionListener
{
    Frame f = new Frame();
    Frame f1 = new Frame();
    
    JButton b[][] = new JButton[9][9];
    JButton c[][] = new JButton[4][4];
    JButton exit = new JButton("EXIT");
    JButton solve = new JButton("SOLVE");
    JButton vertical1 = new JButton();
    JButton vertical2 = new JButton();
    JButton horizontal1 = new JButton();
    JButton horizontal2 = new JButton();
    
    int n[][] = new int[9][9];
    int ii,jj;
    int num;
    int visited[][] = new int[9][9];
    public void first()
    {
        Font font = new Font("Calibiri",Font.BOLD,18);
        int x=50, y=50;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                b[i][j] = new JButton();
                b[i][j].setBounds(x,y,50,50);
                x+=55;
                if(j==8)
                {
                    x=50;
                    y=y+55;
                }
                b[i][j].addActionListener(this);
                /*b[i].setBackground(Color.gray);
                 *b[i].setOpaque(true);
                 *b[i].setBorderPainted(false);*/
                 b[i][j].setFont(font);
                 b[i][j].setText(null);
                 visited[i][j]=0;
                f.add(b[i][j]);
            }
        }
        vertical1.setBounds(210,53,5,485);
        vertical1.setBackground(Color.black);
        vertical1.setOpaque(true);
        vertical1.setBorderPainted(false);
        f.add(vertical1);
        vertical2.setBounds(375,53,5,485);
        vertical2.setBackground(Color.black);
        vertical2.setOpaque(true);
        vertical2.setBorderPainted(false);
        f.add(vertical2);
        horizontal1.setBounds(53,209,485,5);
        horizontal1.setBackground(Color.black);
        horizontal1.setOpaque(true);
        horizontal1.setBorderPainted(false);
        f.add(horizontal1);
        horizontal2.setBounds(53,374,485,5);
        horizontal2.setBackground(Color.black);
        horizontal2.setOpaque(true);
        horizontal2.setBorderPainted(false);
        f.add(horizontal2);
        
        solve.setBounds(125,580,100,30);
        solve.addActionListener(this);
        f.add(solve);
        exit.setBounds(375,580,100,30);
        exit.addActionListener(this);
        f.add(exit);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(585,630);
        f.setTitle("Crack the Sudoku - Ameya Sachin Rane");
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int xo = (int) ((dimension.getWidth() - f.getWidth()) / 2);
        int yo = (int) ((dimension.getHeight() - f.getHeight()) / 2);
        f.setLocation(xo, yo);
        
        x=50;
        y=50;
        int g=1;
        for(int i=1;i<=3;i++)
        {
            for(int j=1;j<=3;j++)
            {
                c[i][j] = new JButton(String.valueOf(g));
                c[i][j].setBounds(x,y,50,50);
                x+=55;
                if(j==3)
                {
                    x=50;
                    y=y+55;
                }
                c[i][j].addActionListener(this);
                /*b[i].setBackground(Color.gray);
                 * b[i].setOpaque(true);
                 * b[i].setBorderPainted(false);*/
                f1.add(c[i][j]);
                g++;
            }
        }
        f1.setLayout(null);
        f1.setVisible(false);
        f1.setSize(250,250);
        f1.setTitle("Match the Color - Ameya Sachin Rane");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        xo = (int) ((dim.getWidth() - f1.getWidth()) / 2);
        yo = (int) ((dim.getHeight() - f1.getHeight()) / 2);
        f1.setLocation(xo, yo);
        num=1;
    }
    public void actionPerformed(ActionEvent e)
    {
        Font font = new Font("Calibiri",Font.BOLD,18);
        int sum=0;
        int check=0;
        if(e.getSource()==exit)
        {
            f.dispose();
        }
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(e.getSource()==b[i][j])
                {
                    f1.setVisible(true);
                    ii=i;jj=j;
                    break;
                }
            }
        }
        for(int i=1;i<=3;i++)
        {
            for(int j=1;j<=3;j++)
            {
                if(e.getSource()==c[i][j])
                {
                    b[ii][jj].setText(c[i][j].getText());
                    visited[ii][jj]=1;
                    n[ii][jj]=Integer.parseInt(c[i][j].getText());
                    f1.dispose();
                    break;
                }
            }
        }
        if(e.getSource()==solve)
        {
            check();
        }
    }
    void check()
    {
        num=1;
        int s=0;
        System.out.println("\u000c");
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(n[i][j]==0)
                {
                    n[i][j]=num;
                }
                for(int k=0;k<9;k++)
                {
                    if(visited[i][j]==0)
                    {
                        while(((n[i][j]==n[i][k]&&j!=k)||(n[i][j]==n[k][j]&&i!=k)))
                        {
                            n[i][j]++;
                            if(n[i][j]==10)
                            {
                                n[i][j]=1;
                            }
                        }
                    }
                }
                if((i>=0&&i<=2)&&(j>=0&&j<=2))
                {
                    for(int k=0;k<3;k++)
                    {
                        for(int l=0;l<3;l++)
                        {
                            s=n[k][l];
                            for(int kk=0;kk<3;kk++)
                            {
                                for(int ll=0;ll<3;ll++)
                                {
                                    if(s==n[kk][ll]&&kk!=k&&ll!=l&&visited[kk][ll]==0)
                                    {
                                        n[kk][ll]++;
                                
                                    }
                                }
                            }
                        }
                    }
                }
                else if((i>=0&&i<=2)&&(j>=3&&j<=5))
                {
                    for(int k=0;k<3;k++)
                    {
                        for(int l=3;l<6;l++)
                        {
                            s=n[k][l];
                            for(int kk=0;kk<3;kk++)
                            {
                                for(int ll=3;ll<6;ll++)
                                {
                                    if(s==n[kk][ll]&&kk!=k&&ll!=l&&visited[kk][ll]==0)
                                    {
                                        n[kk][ll]++;
            
                                    }
                                }
                            }
                        }
                    }
                }
                else if((i>=0&&i<=2)&&(j>=6&&j<=8))
                {
                    for(int k=0;k<3;k++)
                    {
                        for(int l=6;l<9;l++)
                        {
                            s=n[k][l];
                            for(int kk=0;kk<3;kk++)
                            {
                                for(int ll=6;ll<9;ll++)
                                {
                                    if(s==n[kk][ll]&&kk!=k&&ll!=l&&visited[kk][ll]==0)
                                    {
                                        n[kk][ll]++;
                     
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    System.out.print(n[i][j]+"\t");
                }
                System.out.println();
            }
    }
    public static void main()
    {
        SudokuCracker ob = new SudokuCracker();
        ob.first();
    }
}