package org.casarini.prbm.model;

import java.awt.*;
import java.awt.image.*;
import java.util.Vector;

import org.casarini.prbm.gui.component.PRBRepository;
import org.casarini.prbm.gui.component.Tabella;
import org.casarini.prbm.gui.util.YellowFilter;

public class PRBRepositoryData implements java.io.Serializable
{
    public Vector resources;

    public PRBRepositoryData()
    {
        resources = new Vector();
    }

    public Resource getResource(int res)
    {
        return (Resource)resources.elementAt(res);
    }

    public int getHeight()
    {
        int max=0;
        if(!resources.isEmpty())
            max = resources.size();
        return max;
    }
    
    public Resource addResource(PRBRepository c, int type, String title, int pos)
    {
        Resource r = new Resource();
        Tabella t = c.parent.tab;
        r.type=type;
        r.title=title;
        Image normal=t.createImage(t.m_size_col-4,16);
        Graphics gnormal= normal.getGraphics();
        gnormal.drawImage(t.icone[type],1,1,t);
        gnormal.setFont(t.m_FontNormal);
        gnormal.drawString(title,17,13);
        ImageFilter f=new YellowFilter();
        ImageProducer producer=new FilteredImageSource(normal.getSource(),f);
        Image yellow=t.createImage(producer);
        r.n=normal;
        r.y=yellow;
        
        switch(type)
        {
            case 0:
                Scheda d0=new Scheda();
                r.scheda=d0;
                break;
            case 1:
                Fiore d1=new Fiore();
                r.scheda=(Scheda)d1;
                break;
            case 2:
                Albero d2=new Albero();
                r.scheda=(Scheda)d2;
                break;
            case 3:
                Fauna d3=new Fauna();
                r.scheda=(Scheda)d3;
                break;
            case 4:
                AmbienteNaturale d4=new AmbienteNaturale();
                r.scheda=(Scheda)d4;
                break;
            case 5:
                Meteo d5=new Meteo();
                r.scheda=(Scheda)d5;
                break;
            case 6:
                Monumento d6=new Monumento();
                r.scheda=(Scheda)d6;
                break;
            case 7:
                Intervista d7=new Intervista();
                r.scheda=(Scheda)d7;
                break;
            case 8:
                Fatto d8=new Fatto();
                r.scheda=(Scheda)d8;
                break;
            case 9:
                Curiosita d9=new Curiosita();
                r.scheda=(Scheda)d9;
                break;
        }

        resources.insertElementAt((Object)r,pos);

        return r;
    }
    public Resource addResource(Resource r, int pos)
	{
        resources.insertElementAt((Object)r, pos);
		return r;
	}
    public Resource cutResource(int pos)
    {
        Resource r=(Resource)resources.elementAt(pos);
        resources.removeElementAt(pos);
        return r;
    }
    
    public void delAllResource()
    {
        resources.removeAllElements();
    }
}
