package org.casarini.prbm.model;

import java.io.*;
import java.util.Vector;

import org.casarini.prbm.parser.PRBMParser;
import org.casarini.prbm.parser.PRBMParserNode;
import org.casarini.prbm.util.DiskUtil;


public class Scheda implements Serializable
{
    public String didascalia;
    public String icona;
    public String timestamp;
    public String note;
    public String immagine;
    public String video;
    public transient String html;
    
    public Scheda()
    {
        didascalia=new String("");
        icona=new String("");
        timestamp=new String("");
        note=new String("");
        immagine=new String("");
        video=new String("");
    }

	public Scheda copy()
	{
		Scheda s=new Scheda();
		s.didascalia=didascalia;
		s.icona=icona;
		s.timestamp=timestamp;
		s.note=note;

		return s;
	}
    
    public void toHTML(String file, String template)
    {
        String sTipo="Paesaggio";
        String sIcoTipo=icona;
		String dir=file.substring(0,file.lastIndexOf("/")+1);

        Vector nodes;
        PRBMParser parser;

        nodes = new Vector();
        nodes.addElement(new PRBMParserNode('S',"scheda.ico.src", sIcoTipo, 0, null));
        nodes.addElement(new PRBMParserNode('S',"scheda.tipo", sTipo, 0, null));
        nodes.addElement(new PRBMParserNode('S',"scheda.didascalia", didascalia, 0, null));
        System.out.println (didascalia);
        if (immagine == null)
            immagine=new String("");
        if(immagine.length()>0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.immagine", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.immagine.src", immagine.substring(immagine.lastIndexOf("\\")+1), 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.immagine", null, 0, null));
        if (video == null)
            video=new String("");
        if(video.length()>0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.video", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.video.src", video.substring(video.lastIndexOf("\\")+1), 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.video", null, 0, null));
        nodes.addElement(new PRBMParserNode('S',"scheda.dataora.value", TimeStamp.toHtml(timestamp), 0, null));
        nodes.addElement(new PRBMParserNode('S',"scheda.note", note, 0, null));
        parser = new PRBMParser("template\\"+template+"\\paesaggio.tmpl", file, nodes);
        parser.parse();

        if(immagine.length()!=0)
        {
            File f=new File(immagine);
            if(f.exists())
                DiskUtil.copyFile(immagine,dir+immagine.substring(immagine.lastIndexOf("\\")+1));
            else
                System.out.println("Errore");
        }
        if(video.length()!=0)
        {
            File f=new File(video);
            if(f.exists())
                DiskUtil.copyFile(video,dir+video.substring(video.lastIndexOf("\\")+1));
            else
                System.out.println("Errore");
        }
    }
}