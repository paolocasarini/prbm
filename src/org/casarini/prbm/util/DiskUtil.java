package org.casarini.prbm.util;

import java.io.*;

public class DiskUtil
{
    public static void copyFile(String s,String d)
    {
        byte[] buffer = new byte[4096];
        int letti, scritti;
        FileInputStream fs;
        FileOutputStream fd;
        
        try
        {
            fs=new FileInputStream(s);
            fd=new FileOutputStream(d);
            letti=fs.read(buffer);
            while(letti!=-1&&letti!=0)
            {
                    fd.write(buffer,0,letti);
                    letti=fs.read(buffer);
            }
            fd.flush();
            fs.close();
            fd.close();
        }
        catch (Exception e) {System.out.println(e);}
    }

    public static String getRealDir(String dir)
    {
    	File dirfile=new File(dir);
    	File homefile=new File("");
        String home=homefile.getAbsolutePath();

        if(!dirfile.isAbsolute())
        {
        	dir=home+"\\"+dir;
        	dirfile=new File(dir);
        }

    	if(dirfile.exists()&&dirfile.isDirectory())
    		return dir;
    	else
    		return ".";
    }
}