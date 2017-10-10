//########################################################################
//Author:   Randy McCleary
//File Name: newsTicker.java
//Program:  News Ticker version 1.0.0
//Program Description: This is a news ticker applet. It takes input
//  parameters from the HTML source and displays short text messages
//  formated by the input parameters. This applet can be used to display
//  sports scores, stock updates, short messages, news updates, up coming
//  events, and ect... 

//########################################################################

package Scroller;

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.io.PrintStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.*;

public class newsTicker extends Applet
    implements Runnable
{

    int bgci;          //Background Color Integer
    int fci;           //Foreground Color Integer
    int fontsize;      //Font Size
    int fontstyle;     //Font Style 1,2,3(Bold,Italic,Both)
    int appWidth;      //Stores the applet's Width
    int appHeight;     //Stores the applet's Height
    int hlci;          //Highlight Color Integer
    int tcount;        //Counter
    int i;             //Counter
    int delay_time;    //Delay Time Between
    int scroll_delay;  //Scroll Delay Time
    int scrollspeed;   //Scroll Speed
    int fontHeight;    //Font Height in points
    int appMiddle;     //The middle section of the applet
    int uyu;           //Delay Time
    int X;             //Counter
    int curr;          //Counter
    int mesafe;        //Counter
    int cordx;         //Coordinate X
    int cordY;         //Coordinate Y
    int downtut;       //Timer
    int tutX;          //Timer
    int left_margin;   //Left margin indent
    int metrik[];      //
    int duryer[];      //
    boolean reg;       //Stores T/F for registration code
    boolean yan1;      //
    boolean yan2;      //
    boolean bd1;       //Validate link one
    boolean bd2;       //Validate link two
    Color bgcc;        //Background Color (R,G,B)
    Color fcc;         //Foreground Color
    Color hlcc;        //Highlight  Color
    String fonttype;   //Font Type
    String text_alignment; //Font Alignment
    String target_frame;   //Target Frame
    String infostr;        //Info String ex: Author's Name
    String regcode;        //Registration Code
    String strText = "";   //String for Text
    String strLink = "";   //String for Links
    String texts[];        //Array for Text
    String links[];        //Array for Links
    Font font;             //The Font
    FontMetrics fmetrics;  //The Font Metrics
    Graphics offScreeng;   //Off screen graphics
    Graphics offbuff;      //Off buffer graphics
    Image offscrimg;   //Off screen image
    Image normi[];     //Normal Image Array
    Image hlighti[];   //Highlight Image Array
    Thread runner;     //The thread runner
    URL u;             //Url links

    public void init()
    {
        X = 0;

        //Grab the input parameters: bgcolor, fontcolor, highlightcolor
        //  and convert the hexidecimal to an integer so it can be
        //  converted to a color using the Red,Green, Blue format in Java.
        //  The R,G,B range is 0,0,0 - 255,255,255.
        try
        {
            bgci = Integer.parseInt(getParameter("bgcolor"), 16);
        }
        catch(Exception _ex)
        {
            bgci = 0;
        }
        try
        {
            fci = Integer.parseInt(getParameter("fontcolor"), 16);
        }
        catch(Exception _ex)
        {
            fci = 0xffffff;
        }
        try
        {
            hlci = Integer.parseInt(getParameter("highlightcolor"), 16);
        }
        catch(Exception _ex)
        {
            hlci = 0;
        }

        //Take the color integer and converts it into a color using the
        //  Red Green Blue format.
        bgcc = new Color(bgci);
        fcc = new Color(fci);
        hlcc = new Color(hlci);

        //Grab the input parameters info and regcode from html file.
        //Both of these parameters are used to protect the coder's work.
        //The info parameter would help keep the Author's name in the HTML
        //  source as a PARAM, the regcode value must match the value
        //  that is set below or it will display a unregistered version
        //  in the status bar.
        infostr = getParameter("info");
        regcode = getParameter("regcode");

        //Check the registration code value.
        //  If it's not null compare the values to check if they match.
        //  if they match it returns the value true, if not it returns false.
        if(regcode != null)
        {
          if(regcode.equals("nwt786"))
          {
            reg = true;
          }
          else
          {
            reg = false;
          }
        }
        //If the registration code is null then return false.
        else
        {
          reg = false;
        }

        //Get the input parameters FontType,FontSize, and FontStyle.
        //  FontType is inputted as a string so its easier than the others
        //  FontSize has to be an integer, but just using getParameter it
        //    brings it in as a string, so use Integer.valueOf().intValue()
        //    function to convert it to an integer, FontStyle is the same.
        fonttype = getParameter("fonttype");
        //fontsize = Integer.valueOf(getParameter("fontsize")).intValue();
        //fontstyle = Integer.valueOf(getParameter("fontstyle")).intValue();

        //Now to you have to create the font as a new Font for java to use.
        //  the Font consists of the FontType,FontStyle,FontSize in that order.
        //  After that you'll need to get the Font Metrics.
        font = new Font(fonttype, fontstyle, fontsize);
        fmetrics = getFontMetrics(font);

        //Get the leftmargin parameter.
        left_margin = Integer.valueOf(getParameter("leftmargin")).intValue();

        //Get the applet's width and height.
        appWidth = size().width;
        appHeight = size().height;

        //Get the targetframe and textalignment.
        target_frame = getParameter("targetframe");
        text_alignment = getParameter("textalignment");


        Vector textVector = new Vector();
        Vector linkVector = new Vector();

        tcount = 0;

        //Do while loop to add the text and links to the vectors.
        do
        {
          tcount++;

          //Get the input parameters text+N and link+N.
          //  The numbers will start with 1 for example:
          //  text1 and link1, text2 and link2.
          strText = getParameter("text" + tcount);
          strLink = getParameter("link" + tcount);

          if(strText == null)
          {
            tcount--;
            break;
          }

          if(strText.equals(""))
          {
            tcount--;
            break;
          }

          if(strLink == null)
          {
            strLink = "";
          }

          //Add text and links to the vectors
          linkVector.addElement(strLink);
          textVector.addElement(strText);
        } while(true);

        //Create new string array for texts
        texts = new String[tcount + 1];

        //Create new string array for texts
        links = new String[tcount + 1];

        //Create new image array for normal text
        normi = new Image[tcount + 1];

        //Create new image array for highlighted text
        hlighti = new Image[tcount + 1];

        metrik = new int[tcount + 1];
        duryer = new int[tcount + 1];

        Enumeration enumeration = textVector.elements();
        i = 0;

        while(enumeration.hasMoreElements()) 
        {
          i++;
          texts[i] = (String)enumeration.nextElement();

          //Display Info Parameter Error! if someone has tried to remove
          //  the author's name from the info PARAM or tried to omit the
          //  info PARAM in the HTML source.
          if(!infostr.equals("Author"))
          {
            texts[i] = "Info Parameter Error!!!";
          }
        }

        Enumeration enumeration1 = linkVector.elements();
        i = 0;

        while(enumeration1.hasMoreElements()) 
        {
          i++;
          links[i] = (String)enumeration1.nextElement();
        }

        //Get the parameters delaytime, scrolldelay, and scrollspeed and
        //  convert them to integers.
        delay_time = Integer.valueOf(getParameter("delaytime")).intValue();
        scroll_delay = Integer.valueOf(getParameter("scrolldelay")).intValue();
        scrollspeed = Integer.valueOf(getParameter("scrollspeed")).intValue();
        //uyu = delay_time;

        //Get the height of the font in points.
        fontHeight = fmetrics.getHeight ();

        //Finds the difference from the applet's height and the font's height
        //  and divided by 2, so the text can be centered in the applet.
        appMiddle = (appHeight - fontHeight) / 2;

        for(i = 1; i <= tcount; i++)
        {
          metrik[i] = fmetrics.stringWidth(texts[i]);
          normi[i] = createImage(metrik[i], appHeight);
          hlighti[i] = createImage(metrik[i], appHeight);
          if(text_alignment.equals("center"))
          {
            duryer[i] = (appWidth - metrik[i]) / 2;
          }
          else
          {
            duryer[i] = left_margin;
          }

          //Create the normal view of the text, set the font, the font color,
          //  fill the rectangle, set the foreground color and draw the text.
          offbuff = normi[i].getGraphics();
          offbuff.setFont(font);
          offbuff.setColor(bgcc);
          offbuff.fillRect(0, 0, metrik[i], appHeight);
          offbuff.setColor(fcc);
          offbuff.drawString(texts[i], 0, appMiddle + fmetrics.getAscent());
          offbuff = null;

          //Create the highlighted view of the text.set the font, the font color,
          //  fill the rectangle, set the foreground color and draw the text.
          //  This is on mouse over. Only works if there's a link being used.
          offbuff = hlighti[i].getGraphics();
          offbuff.setFont(font);
          offbuff.setColor(bgcc);
          offbuff.fillRect(0, 0, metrik[i], appHeight);
          offbuff.setColor(hlcc);
          offbuff.drawString(texts[i], 0, appMiddle + fmetrics.getAscent());
        }

        //Make sure the graphics buffer is empty
        if(offbuff != null)
        {
          offbuff.dispose();
        }

        //Create the off screen image to be scrolled next.
        offscrimg = createImage(appWidth, appHeight);
        offScreeng = offscrimg.getGraphics();
        offScreeng.setColor(bgcc);
        offScreeng.fillRect(0, 0, appWidth, appHeight);

        curr = 0;
        cordx = -1;
        cordY = -1;
        X = 10;

        if(tcount > 0)
        {
          X = duryer[1];
        }

        mesafe = 0;
    } // End of init()

    public void update(Graphics g)
    {
      paint(g);
    }

    public void paint(Graphics g)
    {
      g.drawImage(offscrimg, 0, 0, this);
    }

    public boolean mouseDown(Event event, int j, int k)
    {
      if(tcount < 1)
      {
        return true;
      }

      else
      {
        stop();
        downtut = j;
        tutX = X;
        return true;
      }
    } //End of mouseDown()

    public boolean mouseUp(Event event, int j, int k)
    {
      if(tcount < 1)
      {
        return true;
      }

      isle();
      kur();
      start();
      try
      {
        if(yan1)
        {
          u = new URL(links[curr]);
          getAppletContext().showDocument(u, target_frame);
        }

        if(yan2)
        {
          u = new URL(links[curr % tcount + 1]);
          getAppletContext().showDocument(u, target_frame);
        }
      }

      catch(Exception _ex)
      {
        System.out.println("url error!");
      }
      return true;
    } // End of mouseUp()

    public boolean mouseMove(Event event, int j, int k)
    {
      if(tcount < 1)
      {
        return true;
      }

      else
      {
        cordx = j;
        cordY = k;
        buildLinks(cordx, cordY);
        return true;
      }
    } //End of mouseMove()

    public boolean mouseDrag(Event event, int j, int k)
    {
      if(tcount < 1)
      {
        return true;
      }

      else
      {
        cordx = j;
        cordY = k;
        X = (tutX + j) - downtut;
        offScreeng.fillRect(0, 0, appWidth, appHeight);
        kur();
        buildLinks(j, k);
        paintFunction();
        return true;
      }
    } //End of mouseDrag()

    public boolean mouseEnter(Event event, int j, int k)
    {
      if(tcount < 1)
      {
        return true;
      }

      //If if registration code is not true then display the status bar message.
      if(!reg)
      {
        showStatus("This is an unregistered version of newsticker Java applet");
      }
      return true;
    } // End of mouseEnter()

    public boolean mouseExit(Event event, int j, int k)
    {
      if(tcount < 1)
      {
        return true;
      }

      yan1 = false;
      yan2 = false;
      cordx = -1;
      cordY = -1;
      buildLinks(cordx, cordY);
      paintFunction();
      repaint();
      showStatus("");

      //If if registration code is not true then display the status bar message.
      if(!reg)
      {
        showStatus("This is an unregistered version of newsticker Java applet");
      }
      return true;
    } // End of mouseExit()

    public void start()
    {
      if(runner == null || !runner.isAlive())
      {
        runner = new Thread(this);
      }

      runner.start();
    } // End of start()

    public void stop()
    {
      if(runner != null && runner.isAlive())
      {
        runner.stop();
      }
    } //End of stop()

    public void destroy()
    {
      runner = null;
    } // End of destroy()

    public void buildLinks(int j, int k)
    {
      if(tcount < 1)
      {
        return;
      }

      if(j < X)
      {
        yan1 = false;
        yan2 = false;
      }

      if(j >= 0 && j >= X && j <= X + metrik[curr])
      {
        if(links[curr] != null)
        {
          if(links[curr].startsWith("http://"))
          {
            yan1 = true;
          }

          else
          {
            yan1 = false;
          }
        }

        else
        {
          yan1 = false;
        }

        yan2 = false;
      }

      if(j > X + metrik[curr] && j < X + metrik[curr] + mesafe)
      {
        yan1 = false;
        yan2 = false;
      }

      if(j >= 0 && j >= X + metrik[curr] + mesafe && j <= X + metrik[curr] + mesafe + metrik[curr % tcount + 1])
      {
        yan1 = false;

        if(links[curr % tcount + 1] != null)
        {
          if(links[curr % tcount + 1].startsWith("http://"))
          {
            yan2 = true;
          }

          else
          {
            yan2 = false;
          }
        }

        else
        {
          yan2 = false;
        }
      }

      if(j >= 0 && j > X + metrik[curr] + mesafe + metrik[curr % tcount + 1])
      {
        yan1 = false;
        yan2 = false;
      }

      if(bd1 != yan1 || bd2 != yan2)
      {
        if(yan1 || yan2)
        {
          ((Frame)getParent()).setCursor(12);

          if(yan1)
          {
            if(links[curr] != null)
            {
              if(links[curr].startsWith("http://"))
              {
                showStatus("" + links[curr]);
              }

              else
              {
                showStatus("");
              }
            }

            else
            {
              showStatus("");
            }
          }

          if(yan2)
          {
            if(links[curr % tcount + 1] != null)
            {
              if(links[curr % tcount + 1].startsWith("http://"))
              {
                showStatus("" + links[curr % tcount + 1]);
              }
              else
              {
                showStatus("");
              }
            }

            else
            {
              showStatus("");
            }
          }
        }

        else
        {
          ((Frame)getParent()).setCursor(0);
          showStatus("");
        }
        paintFunction();
      }
    } // End of buildLinks(int,int)

    public void paintFunction()
    {
      //Check to see if the current link is not null
      if(links[curr] != null)
      {
        //Check to see if link starts with http://
        if(yan1 && links[curr].startsWith("http://"))
        {
          //Draw next off screen highlighted image
          offScreeng.drawImage(hlighti[curr], X, 0, this);
          bd1 = true;
        }

        else
        {
          //Draw next off screen normal image
          offScreeng.drawImage(normi[curr], X, 0, this);
          bd1 = false;
        }
      }

      //If the links[curr] is null
      else
      {
        offScreeng.drawImage(normi[curr], X, 0, this);
        bd1 = false;
      }

      if(links[curr % tcount + 1] != null)
      {
        if(yan2 && links[curr % tcount + 1].startsWith("http://"))
        {
          offScreeng.drawImage(hlighti[curr % tcount + 1], X + mesafe + metrik[curr], 0, this);
          bd2 = true;
        }

        else
        {
          offScreeng.drawImage(normi[curr % tcount + 1], X + mesafe + metrik[curr], 0, this);
          bd2 = false;
        }
      }

      else
      {
        offScreeng.drawImage(normi[curr % tcount + 1], X + mesafe + metrik[curr], 0, this);
        bd2 = false;
      }
      repaint();
    } // End of paintFunction()

    public void isle()
    {
      uyu = scroll_delay;
      X = X - scrollspeed;
    }

    public void kur()
    {
      if(X + metrik[curr] + mesafe <= duryer[curr % tcount + 1])
      {
        curr++;
        uyu = delay_time;

        if(curr > tcount || curr == 0)
        {
          curr = 1;
        }

        if(metrik[curr] >= metrik[curr % tcount + 1])
        {
          mesafe = duryer[curr % tcount + 1] + duryer[curr];
        }

        else
        {
          mesafe = duryer[curr % tcount + 1] + duryer[curr];
        }

        if(!text_alignment.equals("center"))
        {
          mesafe = appWidth - metrik[curr] - 10;
        }

        X = duryer[curr];
        tutX = X;
        downtut = cordx;
      }
      else
      {
        if(X > duryer[curr])
        {
          curr--;
          if(curr == 0)
          {
            curr = tcount;
          }

          if(metrik[curr] >= metrik[curr % tcount + 1])
          {
            mesafe = duryer[curr % tcount + 1] + duryer[curr];
          }

          else
          {
            mesafe = duryer[curr % tcount + 1] + duryer[curr];
          }

          if(!text_alignment.equals("center"))
          {
            mesafe = appWidth - metrik[curr] - 10;
          }

          X = X - mesafe - metrik[curr];
          tutX = X;
          downtut = cordx;
        }
      }
      offScreeng.fillRect(0, 0, appWidth, appHeight);
    } // End of kur()

    public void run()
    {
      //If if registration code is not true then display the status bar message.
      if(!reg)
      {
        showStatus("This is an unregistered version of newsticker Java applet");
      }

      if(tcount < 1)
      {
        return;
      }
        
      do
      {
        isle();
        kur();
        buildLinks(cordx, cordY);
        paintFunction();
        try
        {
          Thread.sleep(uyu);
        }
        catch(InterruptedException interruptedexception)
        {
          interruptedexception.printStackTrace();
        }
      } while(true);
    } //End of run()

    public newsTicker()
    {
      //Default values
      curr = 1;
      cordx = -1;
      cordY = -1;
      downtut = -1;
      left_margin = 10;
      fonttype = "Courier";
      fontsize = 12;
      text_alignment = "left";
      target_frame = "";
      infostr = "";
      regcode = "";
      reg = false;
      yan1 = false;
      yan2 = false;
      bd1 = false;
      bd2 = false;
    } // End of newsTicker()
}
