package org.casarini.prbm.model;
import java.io.*;
import java.util.Vector;

import org.casarini.prbm.parser.PRBMParser;
import org.casarini.prbm.parser.PRBMParserNode;
import org.casarini.prbm.util.DiskUtil;


public class Albero extends Scheda implements java.io.Serializable
{
    public String nomeComune;
    public String nomeScientifico;
    public String desAlbero;
    public String portamento;
    public String corteccia;
    public String foglie;
    public String fiori;
    public String frutti;
    public int altezza;
    public String habitat;
    public String distribuzione;
    public String proprieta;
    public String curiosita;
    
    public Albero()
    {
        super();
        nomeComune=new String("");
        nomeScientifico=new String("");
        desAlbero=new String("");
        portamento=new String("");
        corteccia=new String("");
        foglie=new String("");
        fiori=new String("");
        frutti=new String("");
        altezza=-1;
        habitat=new String("");
        distribuzione=new String("");
        proprieta=new String("");
        curiosita=new String("");
        immagine=new String("");
        video=new String("");
    }

	public Scheda copy()
	{
		Albero s=new Albero();
		s.didascalia=didascalia;
		s.icona=icona;
		s.timestamp=timestamp;
		s.note=note;

		s.nomeComune=nomeComune;
		s.nomeScientifico=nomeScientifico;
		s.desAlbero=desAlbero;
		s.portamento=portamento;
		s.corteccia=corteccia;
		s.foglie=foglie;
		s.fiori=fiori;
		s.frutti=frutti;
		s.altezza=altezza;
		s.habitat=habitat;
		s.distribuzione=distribuzione;
		s.proprieta=proprieta;
		s.curiosita=curiosita;
		s.immagine=immagine;
		s.video=video;

		return (Scheda)s;
	}

	public void toHTML(String file, String template)
    {
        String sTipo="Albero/Arbusto";
        String sIcoTipo=icona;
		String dir=file.substring(0,file.lastIndexOf("/")+1);

        Vector nodes;
        PRBMParser parser;

        nodes = new Vector();
        nodes.addElement(new PRBMParserNode('S',"scheda.ico.src", sIcoTipo, 0, null));
        nodes.addElement(new PRBMParserNode('S',"scheda.tipo", sTipo, 0, null));
        nodes.addElement(new PRBMParserNode('S',"scheda.didascalia", didascalia, 0, null));
        if(immagine.length()>0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.immagine", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.immagine.src", immagine.substring(immagine.lastIndexOf("\\")+1), 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.immagine", null, 0, null));
        if(video.length()>0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.video", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.video.src", video.substring(video.lastIndexOf("\\")+1), 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.video", null, 0, null));
        if(timestamp.length()!=0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.dataora", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.dataora.value", TimeStamp.toHtml(timestamp), 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.dataora", null, 0, null));
        if(nomeComune.length()!=0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.nomeComune", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.nomeComune.value", nomeComune, 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.nomeComune", null, 0, null));
        if(nomeScientifico.length()!=0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.nomeScientifico", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.nomeScientifico.value", nomeScientifico, 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.nomeScientifico", null, 0, null));
        if(desAlbero.length()!=0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.desAlbero", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.desAlbero.value", desAlbero, 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.desAlbero", null, 0, null));
        if(portamento.length()!=0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.portamento", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.portamento.value", portamento, 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.portamento", null, 0, null));
        if(corteccia.length()!=0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.corteccia", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.corteccia.value", corteccia, 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.corteccia", null, 0, null));
        if(foglie.length()!=0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.foglie", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.foglie.value", foglie, 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.foglie", null, 0, null));
        if(fiori.length()!=0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.fiori", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.fiori.value", fiori, 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.fiori", null, 0, null));
        if(frutti.length()!=0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.frutti", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.frutti.value", frutti, 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.frutti", null, 0, null));
        if(altezza!=-1)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.altezza", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.altezza.value", Integer.toString(altezza), 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.altezza", null, 0, null));
        if(habitat.length()!=0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.habitat", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.habitat.value", habitat, 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.habitat", null, 0, null));
        if(distribuzione.length()!=0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.distribuzione", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.distribuzione.value", distribuzione, 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.distribuzione", null, 0, null));
        if(curiosita.length()!=0)
        {
            nodes.addElement(new PRBMParserNode('I',"scheda.curiosita", null, 1, null));
            nodes.addElement(new PRBMParserNode('S',"scheda.curiosita.value", curiosita, 0, null));
        }
        else
            nodes.addElement(new PRBMParserNode('I',"scheda.curiosita", null, 0, null));
        parser = new PRBMParser("template\\"+template+"\\albero.tmpl", file, nodes);
        parser.parse();

        if(immagine.length()!=0)
        {
            File f=new File(immagine);
            if(f.exists())
                DiskUtil.copyFile(immagine,dir+immagine.substring(immagine.lastIndexOf("\\")+1));
            else
                System.out.println("Errore: non esiste il file "+dir+immagine.substring(immagine.lastIndexOf("\\")+1));
        }
        if(video.length()!=0)
        {
            File f=new File(video);
            if(f.exists())
                DiskUtil.copyFile(video,dir+video.substring(video.lastIndexOf("\\")+1));
            else
                System.out.println("Errore: non esiste il file "+dir+immagine.substring(immagine.lastIndexOf("\\")+1));
        }
    }

}