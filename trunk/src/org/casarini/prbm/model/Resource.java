package org.casarini.prbm.model;

import java.awt.*;
import java.awt.image.*;

import org.casarini.prbm.gui.component.Tabella;
import org.casarini.prbm.gui.util.YellowFilter;

public class Resource implements java.io.Serializable
{
    public int type;
    public String title;
    public transient Image n, y;
    public Scheda scheda;
    
    public void updateImg(Tabella t)
    {
        Image normal=t.createImage(t.m_size_col-4,16);
        Graphics gnormal= normal.getGraphics();
        gnormal.drawImage(t.icone[type],1,1,t);
        gnormal.setFont(t.m_FontNormal);
        gnormal.drawString(title,17,13);
        ImageFilter f=new YellowFilter();
        ImageProducer producer=new FilteredImageSource(normal.getSource(),f);
        Image yellow=t.createImage(producer);
        this.n=normal;
        this.y=yellow;
    }

	public Resource copyRes(Tabella t)
	{
		Resource ret=new Resource();
		ret.type=this.type;
		ret.title=this.title;
		ret.n=(Image)t.createImage(this.n.getSource());
		ret.y=(Image)t.createImage(this.y.getSource());

        switch(type)
        {
            case 0:
                ret.scheda=scheda.copy();
                break;
            case 1:
                ret.scheda=(Fiore)scheda.copy();
                break;
            case 2:
                ret.scheda=(Albero)scheda.copy();
                break;
            case 3:
                ret.scheda=(Fauna)scheda.copy();
                break;
            case 4:
                ret.scheda=(AmbienteNaturale)scheda.copy();
                break;
            case 5:
                ret.scheda=(Meteo)scheda.copy();
                break;
            case 6:
                ret.scheda=(Monumento)scheda.copy();
                break;
            case 7:
                ret.scheda=(Intervista)scheda.copy();
                break;
            case 8:
                ret.scheda=(Fatto)scheda.copy();
                break;
            case 9:
                ret.scheda=(Curiosita)scheda.copy();
                break;
        }

		return ret;
	}
}
