package org.casarini.prbm.gui.component;
import java.awt.*;

public class IconViewer extends Canvas
{
    protected Image image;
    
    public IconViewer()
    {
        super();
    }
    
    public void paint(Graphics g)
    {
        if(image!=null)
		{
			g.setColor(Color.white);
			g.fillRect(0,0,image.getWidth(this)+20,image.getHeight(this)+20);
			g.setColor(Color.black);
			g.drawRect(0,0,image.getWidth(this)+19,image.getHeight(this)+19);
            g.drawImage(image,10,10,this);
		}
        else
            super.repaint();
    }
    
    public void setImage(Image i)
    {
        image=i;
    }
}