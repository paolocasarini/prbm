package org.casarini.prbm.gui.util;

import java.awt.image.*;

public class YellowFilter extends RGBImageFilter
{
    public YellowFilter()
    {
        canFilterIndexColorModel=true;
    }

    public int filterRGB(int x, int y, int rgb)
    {
        if(rgb==0xffffffff)
            return 0xffffff00;
        else
            return rgb;
    }
}
