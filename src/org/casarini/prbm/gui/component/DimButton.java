package org.casarini.prbm.gui.component;
import java.awt.Button;
import java.awt.Dimension;

public class DimButton extends Button
{
    Dimension d;
    public DimButton(int w,int h)
    {
        super();
        d=new Dimension(w,h);
    }
    public Dimension getPreferredSize()
    {
        return d;
    }
}