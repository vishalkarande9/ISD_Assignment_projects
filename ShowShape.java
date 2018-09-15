import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ShowShape extends Applet
{

	boolean displayMessageFlag = true;
	boolean paramMissingFlag = false;
	boolean textSetFlag = true;
	String shape = "default";
    String fontStyle = "default";
    String fontSize = "default";
	public void paint(Graphics g)
	{
		FontMetrics fontmetric = g.getFontMetrics();   // rendering of a perticular font
		Dimension dimension = getSize();      // dimention of applet
		String backgroundColor = getParameter("BGColor");   // background color
		String foregroundColor = getParameter("Color");     // foreground color
		int x = Integer.parseInt(getParameter("X"));	//width
		int y = Integer.parseInt(getParameter("Y"));	//height
		String message = getParameter("Message");            // message to print
		String originalMessage = getParameter("Message");    // message to print 
		int messageWidth = fontmetric.stringWidth(message);     // message width
		int messageHeight = fontmetric.getAscent();             // height of the lagest character in the message  
		int firstCentreX = (getSize().width)/2;    // to get the center of applet
		int firstCentreY = (getSize().height)/2;    // same to get the center of applet
		int secCentreX = x/2;                     // to get the center of shape 
		int secCentreY = y/2;                      // to get the center of shape 
		int startPoint = firstCentreX - secCentreX;	//x coordinate
        int endPoint = firstCentreY - secCentreY;	//y coordinate
        int textCentreX = dimension.width / 2 - messageWidth / 2;
        int textCentreY = dimension.height / 2 + fontmetric.getDescent();
 

        if(getParameter("FTStyle")==null){
            fontStyle="";
        } else{
            fontStyle=getParameter("FTStyle");   
        }

        if(getParameter("Shape")==null){
            shape="";
        } else{
            shape=getParameter("Shape");   
        }

        if(getParameter("FTSize")==null){
            fontSize="";
        } else{
            fontSize=getParameter("FTSize");   
        }

        if(getParameter("BGColor")==null){
            backgroundColor="BLACK";
        } else{
            backgroundColor=getParameter("BGColor");
        }

        if(getParameter("Color")==null){
            foregroundColor="RED";
        } else{
            foregroundColor=getParameter("Color");
        }

  		switch(fontStyle){
			case "REGULAR":
			    g.setFont(new Font(fontStyle, Font.PLAIN, Integer.parseInt(fontSize)));
				break;
			case "ITALIC":
			    g.setFont(new Font(fontStyle, Font.ITALIC, Integer.parseInt(fontSize)));
			    break;	
			case "BOLD":
			    g.setFont(new Font(fontStyle, Font.BOLD, Integer.parseInt(fontSize)));
			    break;
			case "BOLD+ITALIC":
			    g.setFont(new Font(fontStyle, Font.BOLD + Font.ITALIC, Integer.parseInt(fontSize)));
			    break;
			default:
				paramMissingFlag = (fontStyle.length() < 1) ? true : false;
				g.setFont(new Font("TimesRoman", Font.BOLD, 15));
        }
        
          
		switch(shape){
			case "OVAL":
				g.drawOval(startPoint,endPoint,x,y);
				changeBackgroundColor(backgroundColor, g, startPoint, endPoint);
				changeForegroundColor(foregroundColor, g, startPoint, endPoint);
				break;
			case "RECT":
				g.drawRect(startPoint,endPoint,x,y);
				changeBackgroundColor(backgroundColor, g, startPoint, endPoint);
				changeForegroundColor(foregroundColor, g, startPoint, endPoint);
				break;
			case "ROUNDRECT":
                g.drawRoundRect(startPoint,endPoint,x,y,20,20);
				changeBackgroundColor(backgroundColor, g, startPoint, endPoint);
				changeForegroundColor(foregroundColor, g, startPoint, endPoint);
				break;
            default:
                paramMissingFlag = (shape.length() < 1) ? true : false;
				g.drawOval(startPoint,endPoint,x,y);
				changeBackgroundColor(backgroundColor, g, startPoint, endPoint);
				changeForegroundColor(foregroundColor, g, startPoint, endPoint);
		}
        

		if(paramMissingFlag == true)
		{
			message = "MISSING PARAMETERS";
			paramMissingFlag = false;
            g.drawString(message,startPoint,endPoint);
		}
		else if(displayMessageFlag == true)
		{			
			if(getHeight() < y || getWidth() < x)
	    	{
	    		textSetFlag = false;
	    		message = "SHAPE IS BIGGER THAN APPLET";
	    		g.drawString(message,startPoint,0);
	    	}			
		}
		else
		{
			message = "CANNOT RECOGNIZE PARAMETERS";
			g.drawString(message,startPoint,endPoint);
        }
        
                
		FontMetrics fontmetric1 = g.getFontMetrics();
		g.drawString(originalMessage, dimension.width / 2 - fontmetric1.stringWidth(originalMessage) / 2, dimension.height / 2 + fontmetric1.getDescent());
        
        
		if(fontmetric1.stringWidth(originalMessage) > x || fontmetric1.getHeight() > y)
		{
		  Font	font = new Font("TimesRoman", Font.PLAIN, 15);
			g.setFont(font);
			g.drawString("Text is too larger than the shape",0, endPoint);			
        }
        
    }

	public void changeForegroundColor(String color, Graphics g, int startPoint, int endPoint)
	{
		switch(color){
            case "yellow":
				setForeground(Color.YELLOW);
				break;
			case "blue":
				setForeground(Color.BLUE);
				break;
			case "black":
				setForeground(Color.BLACK);
				break;
			case "cyan":
				setForeground(Color.CYAN);
				break;
			case "darkGray":
				setForeground(Color.darkGray);
                break;
            case "red":
				setForeground(Color.RED);
				break;    
			case "gray":
				setForeground(Color.GRAY);
                break;
            case "white":
				setForeground(Color.WHITE);
				break;    
			case "green":
				setForeground(Color.GREEN);
				break;
			case "lightGray":
				setForeground(Color.lightGray);
				break;
			case "magenta":
				setForeground(Color.MAGENTA);
				break;
			case "orange":
				setForeground(Color.ORANGE);
				break;
			case "pink":
				setForeground(Color.PINK);
				break;
	
			default:
				setForeground(Color.RED);
		}
    }
    
    public void changeBackgroundColor(String color, Graphics g, int startPoint, int endPoint)
	{
		switch(color){
            case "white":
                setBackground(Color.WHITE);
                break;
			case "blue":
				setBackground(Color.BLUE);
				break;
			case "black":
				setBackground(Color.BLACK);
				break;
			case "cyan":
				setBackground(Color.CYAN);
				break;
			case "darkGray":
				setBackground(Color.darkGray);
				break;
			case "gray":
				setBackground(Color.GRAY);
				break;
			case "green":
				setBackground(Color.GREEN);
				break;
			case "lightGray":
				setBackground(Color.lightGray);
				break;
			case "orange":
				setBackground(Color.ORANGE);
				break;
			case "pink":
				setBackground(Color.PINK);
                break;
            case "magenta":
				setBackground(Color.MAGENTA);
				break;    
			case "red":
				setBackground(Color.RED);
				break;
			case "yellow":
				setBackground(Color.YELLOW);
				break;
			default:
				setBackground(Color.BLACK);
		}
	}

}

