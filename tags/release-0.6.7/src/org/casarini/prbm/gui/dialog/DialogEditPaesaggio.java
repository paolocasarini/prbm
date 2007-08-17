/* DialogEditPaesaggio.java
 * 
 * Copyright (C) 2004 Paolo Casarini <paolo@casarini.org>
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package org.casarini.prbm.gui.dialog;

import java.awt.*;
import java.io.File;
import java.util.Vector;
import java.util.StringTokenizer;

import org.casarini.prbm.gui.PRB;
import org.casarini.prbm.gui.component.CTextField;
import org.casarini.prbm.gui.component.DimButton;
import org.casarini.prbm.gui.component.IconViewer;
import org.casarini.prbm.model.Resource;
import org.casarini.prbm.model.TimeStamp;
import org.casarini.prbm.util.DiskUtil;
import org.casarini.prbm.util.IconFactory;


public class DialogEditPaesaggio extends Dialog
{
	Font fontN,fontB;
    Vector nomiImg;
    Vector imgIcone;
    Resource rs;
    PRB parent;
    
	public DialogEditPaesaggio(PRB parent,Resource rs)
	{
		super(parent, true);
		this.rs=rs;
		this.parent=parent;
		nomiImg=new Vector();
		imgIcone=new Vector();
		setBackground(Color.lightGray);

		fontN=new Font("Dialog", Font.PLAIN, 12);
		fontB=new Font("Dialog", Font.BOLD, 12);

		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		//{{INIT_CONTROLS
		setLayout(null);
		setVisible(false);
		setSize(insets().left + insets().right + 467,insets().top + insets().bottom + 448);
		tfTitolo = new CTextField(CTextField.CTF_ALL,50);
		tfTitolo.setBounds(insets().left + 81,insets().top + 39,380,18);
		tfTitolo.setBackground(Color.yellow);
		add(tfTitolo);
		label1 = new java.awt.Label("Propriet� scheda Paesaggio",Label.CENTER);
		label1.setBounds(insets().left + 7,insets().top + 6,453,18);
		label1.setFont(new Font("Dialog", Font.BOLD, 14));
		add(label1);
		label2 = new java.awt.Label("Didascalia:");
		label2.setBounds(insets().left + 12,insets().top + 42,64,12);
		label2.setFont(fontB);
		add(label2);
		label3 = new java.awt.Label("Elemento Paesaggistico:");
		label3.setBounds(insets().left + 12,insets().top + 66,200,14);
		label3.setFont(fontB);
		add(label3);
		label4 = new java.awt.Label("Data rilevamento:");
		label4.setBounds(insets().left + 228,insets().top + 84,102,12);
		label4.setFont(fontB);
		add(label4);
		tfGiorno = new CTextField(CTextField.CTF_NUM,2);
		tfGiorno.setBounds(insets().left + 336,insets().top + 81,24,18);
		add(tfGiorno);
		tfMese = new CTextField(CTextField.CTF_NUM,2);
		tfMese.setBounds(insets().left + 366,insets().top + 81,24,18);
		add(tfMese);
		tfAnno = new CTextField(CTextField.CTF_NUM,4);
		tfAnno.setBounds(insets().left + 396,insets().top + 81,44,18);
		add(tfAnno);
		label5 = new java.awt.Label("/");
		label5.setBounds(insets().left + 360,insets().top + 84,6,12);
		label5.setFont(fontB);
		add(label5);
		label6 = new java.awt.Label("/");
		label6.setBounds(insets().left + 390,insets().top + 84,6,12);
		label6.setFont(fontB);
		add(label6);
		label7 = new java.awt.Label("Ora rilevamento:");
		label7.setBounds(insets().left + 234,insets().top + 108,96,12);
		label7.setFont(fontB);
		add(label7);
		tfOra = new CTextField(CTextField.CTF_NUM,2);
		tfOra.setBounds(insets().left + 336,insets().top + 105,24,18);
		add(tfOra);
		tfMinuti = new CTextField(CTextField.CTF_NUM,2);
		tfMinuti.setBounds(insets().left + 366,insets().top + 105,24,18);
		add(tfMinuti);
		tfSecondi = new CTextField(CTextField.CTF_NUM,2);
		tfSecondi.setBounds(insets().left + 396,insets().top + 105,24,18);
		add(tfSecondi);
		label8 = new java.awt.Label(":");
		label8.setBounds(insets().left + 360,insets().top + 108,6,12);
		label8.setFont(fontB);
		add(label8);
		label9 = new java.awt.Label(":");
		label9.setBounds(insets().left + 390,insets().top + 108,6,12);
		label9.setFont(fontB);
		add(label9);
		label10 = new java.awt.Label("Note:");
		label10.setBounds(insets().left + 12,insets().top + 321,30,12);
		label10.setFont(fontB);
		add(label10);
		textArea1 = new java.awt.TextArea();
		textArea1.setBounds(insets().left + 48,insets().top + 318,411,75);
		add(textArea1);
		lIcona = new java.awt.List(0,false);
		add(lIcona);
		lIcona.setBounds(insets().left + 12,insets().top + 84,186,180);
		okbutton = new java.awt.Button();
		okbutton.setActionCommand("button");
		okbutton.setLabel("OK");
		okbutton.setBounds(insets().left + 160,insets().top + 408,62,24);
		okbutton.setFont(fontB);
		okbutton.setBackground(new Color(12632256));
		add(okbutton);
		cancelbutton = new java.awt.Button();
		cancelbutton.setActionCommand("button");
		cancelbutton.setLabel("Annulla");
		cancelbutton.setBounds(insets().left + 244,insets().top + 408,62,24);
		cancelbutton.setFont(fontB);
		cancelbutton.setBackground(new Color(12632256));
		add(cancelbutton);
		cIcona = new IconViewer();
		cIcona.setBounds(insets().left + 298,insets().top + 198,60,60);
		add(cIcona);
		label11 = new java.awt.Label("Preview Icona",Label.CENTER);
		label11.setBounds(insets().left + 204,insets().top + 171,250,16);
		label11.setFont(fontB);
		add(label11);
		Label label12= new Label("Immagine:");
		label12.setBounds(9,274,60,12);
		label12.setFont(fontB);
		add(label12);
		tfImmagine = new CTextField(CTextField.CTF_ALL,255);
		tfImmagine.setBounds(75,271,318,18);
		add(tfImmagine);
		browse=new DimButton(62,20);
		browse.setLabel("Sfoglia");
		browse.setBounds(396,270,62,20);
		add(browse);
		Label label13 = new Label("Video:");
		label13.setBounds(9,296,40,12);
		label13.setFont(fontB);
		add(label13);
		tfVideo = new CTextField(CTextField.CTF_ALL,255);
		tfVideo.setBounds(55,293,338,18);
		add(tfVideo);
		browseV=new DimButton(62,20);
		browseV.setLabel("Sfoglia");
		browseV.setBounds(396,292,62,20);
		add(browseV);
		setTitle("Modifica Scheda Paesaggio");
		//}}
		
		lIcona.addItem("Paesaggio generico");
		nomiImg.addElement((Object) new String("paesaggi/standard.gif"));
		lIcona.addItem("ferrovia");
		nomiImg.addElement((Object) new String("paesaggi/ferrovia.gif"));		
		lIcona.addItem("stazione ferroviaria");
		nomiImg.addElement((Object) new String("paesaggi/stazferro.gif"));		
		lIcona.addItem("galleria ferroviaria");
		nomiImg.addElement((Object) new String("paesaggi/gallferro.gif"));		
		lIcona.addItem("ponte ferroviario");
		nomiImg.addElement((Object) new String("paesaggi/ponteferro.gif"));		
		lIcona.addItem("passaggio a livello");
		nomiImg.addElement((Object) new String("paesaggi/passlivello.gif"));		
		lIcona.addItem("funicolare");
		nomiImg.addElement((Object) new String("paesaggi/funicolare.gif"));
		lIcona.addItem("teleferica");
		nomiImg.addElement((Object) new String("paesaggi/teleferica.gif"));		
		lIcona.addItem("funivia");
		nomiImg.addElement((Object) new String("paesaggi/funivia.gif"));
		lIcona.addItem("seggiovia");
		nomiImg.addElement((Object) new String("paesaggi/seggiovia.gif"));
		lIcona.addItem("sciovia (skylift)");
		nomiImg.addElement((Object) new String("paesaggi/sciovia.gif"));
		lIcona.addItem("autostrada");
		nomiImg.addElement((Object) new String("paesaggi/autostra.gif"));
		lIcona.addItem("casello autostradale");
		nomiImg.addElement((Object) new String("paesaggi/casello.gif"));
		lIcona.addItem("galleria autostradale");
		nomiImg.addElement((Object) new String("paesaggi/galleria autostrada.gif"));
		lIcona.addItem("ponte autostradale");
		nomiImg.addElement((Object) new String("paesaggi/ponteautostrada.gif"));
		lIcona.addItem("strada");
		nomiImg.addElement((Object) new String("paesaggi/strada.gif"));
		lIcona.addItem("galleria stradale");
		nomiImg.addElement((Object) new String("paesaggi/galleria stradale.gif"));
		lIcona.addItem("ponte stradale");
		nomiImg.addElement((Object) new String("paesaggi/ponte stradale.gif"));
		lIcona.addItem("ponte pedonale");
		nomiImg.addElement((Object) new String("paesaggi/pontepedonale.gif"));
		lIcona.addItem("ponte di barche");
		nomiImg.addElement((Object) new String("paesaggi/pontebarche.gif"));
		lIcona.addItem("strada carreggiabile");
		nomiImg.addElement((Object) new String("paesaggi/strada carreggiabile.gif"));
		lIcona.addItem("mulattiera");
		nomiImg.addElement((Object) new String("paesaggi/mulattiera.gif"));
		lIcona.addItem("sentiero");
		nomiImg.addElement((Object) new String("paesaggi/sentiero.gif"));
		lIcona.addItem("casa in muratura");
		nomiImg.addElement((Object) new String("paesaggi/casamura.gif"));
		lIcona.addItem("baracca");
		nomiImg.addElement((Object) new String("paesaggi/baracca.gif"));
		lIcona.addItem("capanna");
		nomiImg.addElement((Object) new String("paesaggi/capanna.gif"));
		lIcona.addItem("rudere");
		nomiImg.addElement((Object) new String("paesaggi/rudere.gif"));
		lIcona.addItem("stazione di rifornimento");
		nomiImg.addElement((Object) new String("paesaggi/stazione di rifornimento.gif"));
		lIcona.addItem("fabbrica");
		nomiImg.addElement((Object) new String("paesaggi/fabbrica.gif"));
		lIcona.addItem("centrale idroelettrica");
		nomiImg.addElement((Object) new String("paesaggi/centrale idroelettrica.gif"));
		lIcona.addItem("centrale termoelettrica");
		nomiImg.addElement((Object) new String("paesaggi/centrale termoelettrica.gif"));
		lIcona.addItem("chiesa");
		nomiImg.addElement((Object) new String("paesaggi/chiesa.gif"));
		lIcona.addItem("cappella");
		nomiImg.addElement((Object) new String("paesaggi/cappella.gif"));
		lIcona.addItem("tabernacolo");
		nomiImg.addElement((Object) new String("paesaggi/tabernacolo.gif"));
		lIcona.addItem("croce isolata");
		nomiImg.addElement((Object) new String("paesaggi/crocefisso.gif"));
		lIcona.addItem("cimitero");
		nomiImg.addElement((Object) new String("paesaggi/cimitero.gif"));
		lIcona.addItem("fumaiolo");
		nomiImg.addElement((Object) new String("paesaggi/fumaiolo.gif"));
		lIcona.addItem("torre");
		nomiImg.addElement((Object) new String("paesaggi/torre.gif"));
		lIcona.addItem("pietra o colonna indicatrice");
		nomiImg.addElement((Object) new String("paesaggi/pietra o colonna indicatrice.gif"));
		lIcona.addItem("castello");
		nomiImg.addElement((Object) new String("paesaggi/castello.gif"));
		lIcona.addItem("villa antica");
		nomiImg.addElement((Object) new String("paesaggi/villaantica.gif"));
		lIcona.addItem("monumento notevole");
		nomiImg.addElement((Object) new String("paesaggi/monumento notevole.gif"));
		lIcona.addItem("antenna per telecominicazioni");
		nomiImg.addElement((Object) new String("paesaggi/antennatelecom.gif"));
		lIcona.addItem("miniera");
		nomiImg.addElement((Object) new String("paesaggi/miniera.gif"));
		lIcona.addItem("pozzo di petrolio/gas");
		nomiImg.addElement((Object) new String("paesaggi/pozzopetrolio.gif"));
		lIcona.addItem("grotta");
		nomiImg.addElement((Object) new String("paesaggi/grotta.gif"));
		lIcona.addItem("faro");
		nomiImg.addElement((Object) new String("paesaggi/faro.gif"));
		lIcona.addItem("pozzo d'acqua");
		nomiImg.addElement((Object) new String("paesaggi/pozzo d'acqua.gif"));
		lIcona.addItem("sorgente d'acqua");
		nomiImg.addElement((Object) new String("paesaggi/sorgente d'acqua.gif"));
		lIcona.addItem("fontana");
		nomiImg.addElement((Object) new String("paesaggi/fontana.gif"));
		lIcona.addItem("cisterna");
		nomiImg.addElement((Object) new String("paesaggi/cisterna.gif"));
		lIcona.addItem("abbeveratoio");
		nomiImg.addElement((Object) new String("paesaggi/abbeveratoio.gif"));
		lIcona.addItem("abbeveratoio con fontana");
		nomiImg.addElement((Object) new String("paesaggi/abbeveratoio con fontana.gif"));
		lIcona.addItem("muro a calce");
		nomiImg.addElement((Object) new String("paesaggi/muroacalce.gif"));
		lIcona.addItem("muro a secco o maceria");
		nomiImg.addElement((Object) new String("paesaggi/muroasecco.gif"));
		lIcona.addItem("muro di sostegno");
		nomiImg.addElement((Object) new String("paesaggi/murosostegno.gif"));
		lIcona.addItem("palizzata/staccionata");
		nomiImg.addElement((Object) new String("paesaggi/staccionata.gif"));
		lIcona.addItem("siepe");
		nomiImg.addElement((Object) new String("paesaggi/siepe.gif"));
		lIcona.addItem("filo spinato");
		nomiImg.addElement((Object) new String("paesaggi/filospinato.gif"));
		lIcona.addItem("acquedotto");
		nomiImg.addElement((Object) new String("paesaggi/acquedotto.gif"));
		lIcona.addItem("torrente");
		nomiImg.addElement((Object) new String("paesaggi/torrente.gif"));
		lIcona.addItem("fiume piccolo");
		nomiImg.addElement((Object) new String("paesaggi/fiume piccolo.gif"));
		lIcona.addItem("fiume grosso");
		nomiImg.addElement((Object) new String("paesaggi/fiume grosso.gif"));
		lIcona.addItem("cascata");
		nomiImg.addElement((Object) new String("paesaggi/cascata.gif"));
		lIcona.addItem("laghetto");
		nomiImg.addElement((Object) new String("paesaggi/laghetto.gif"));
		lIcona.addItem("lago");
		nomiImg.addElement((Object) new String("paesaggi/lago.gif"));
		lIcona.addItem("diga");
		nomiImg.addElement((Object) new String("paesaggi/diga.gif"));
		lIcona.addItem("aeroporto");
		nomiImg.addElement((Object) new String("paesaggi/aeroporto.gif"));
		lIcona.addItem("idroscalo");
		nomiImg.addElement((Object) new String("paesaggi/idroscalo.gif"));
		lIcona.addItem("porto");
		nomiImg.addElement((Object) new String("paesaggi/porto.gif"));
		lIcona.addItem("punto di quota");
		nomiImg.addElement((Object) new String("paesaggi/punto di quota.gif"));
		lIcona.addItem("campo da tennis");
		nomiImg.addElement((Object) new String("paesaggi/campo_tennis.gif"));
		lIcona.addItem("traliccio corrente");
		nomiImg.addElement((Object) new String("paesaggi/traliccio_corrente.gif"));

		
        for(int i=0;i<nomiImg.size();i++)
        {
            imgIcone.addElement(IconFactory.getInstance().getImage((String)nomiImg.elementAt(i)));
        }
        
        
		//{{REGISTER_LISTENERS
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymItem lSymItem = new SymItem();
		lIcona.addItemListener(lSymItem);
		SymMouse aSymMouse = new SymMouse();
		okbutton.addMouseListener(aSymMouse);
		cancelbutton.addMouseListener(aSymMouse);
		SymKey aSymKey = new SymKey();
		tfTitolo.addKeyListener(aSymKey);
		tfGiorno.addKeyListener(aSymKey);
		tfMese.addKeyListener(aSymKey);
		tfAnno.addKeyListener(aSymKey);
		tfOra.addKeyListener(aSymKey);
		tfMinuti.addKeyListener(aSymKey);
		tfSecondi.addKeyListener(aSymKey);
        browse.addMouseListener(aSymMouse);
        browseV.addMouseListener(aSymMouse);
		//}}
		
		//Init dei campi
		tfTitolo.setText(rs.scheda.didascalia);
		if(rs.scheda.timestamp.length()==0)
		{
			rs.scheda.timestamp=parent.c_param.data;
		}
		if(rs.scheda.timestamp.length()!=0)
		{
		    StringTokenizer t=new StringTokenizer(rs.scheda.timestamp,"-");
		    tfGiorno.setText(t.nextToken());
		    tfMese.setText(t.nextToken());
		    tfAnno.setText(t.nextToken());
		    tfOra.setText(t.nextToken());
		    tfMinuti.setText(t.nextToken());
		    tfSecondi.setText(t.nextToken());
		}
		int sel=nomiImg.indexOf((Object)rs.scheda.icona);
		if(sel!=-1)
		{
  		    cIcona.setImage((Image)imgIcone.elementAt(sel));
            lIcona.select(sel);
		}
		else
		{
  		    cIcona.setImage((Image)imgIcone.elementAt(0));
            lIcona.select(0);
        }
        tfImmagine.setText(rs.scheda.immagine);
        tfVideo.setText(rs.scheda.video);
		textArea1.setText(rs.scheda.note);
	}
	
	public void addNotify()
	{
  	    // Record the size of the window prior to calling parents addNotify.
	    Dimension d = getSize();

		super.addNotify();

		if (fComponentsAdjusted)
			return;

		// Adjust components according to the insets
		setSize(insets().left + insets().right + d.width, insets().top + insets().bottom + d.height);
		Component components[] = getComponents();
		for (int i = 0; i < components.length; i++)
		{
			Point p = components[i].getLocation();
			p.translate(insets().left, insets().top);
			components[i].setLocation(p);
		}
		fComponentsAdjusted = true;
	}

    // Used for addNotify check.
	boolean fComponentsAdjusted = false;


	public void show()
	{
		Rectangle bounds = getParent().bounds();
		Rectangle abounds = bounds();

		move(bounds.x + (bounds.width - abounds.width)/ 2,
			 bounds.y + (bounds.height - abounds.height)/2);

		super.show();
	}

	//{{DECLARE_CONTROLS
	CTextField tfTitolo;
	java.awt.Label label1;
	java.awt.Label label2;
	java.awt.Label label3;
	java.awt.Label label4;
	CTextField tfGiorno;
	CTextField tfMese;
	CTextField tfAnno;
	java.awt.Label label5;
	java.awt.Label label6;
	java.awt.Label label7;
	CTextField tfOra;
	CTextField tfMinuti;
	CTextField tfSecondi;
	java.awt.Label label8;
	java.awt.Label label9;
	java.awt.Label label10;
	java.awt.TextArea textArea1;
	java.awt.List lIcona;
	java.awt.Button okbutton;
	java.awt.Button cancelbutton;
	IconViewer cIcona;
	java.awt.Label label11;
    CTextField tfImmagine;
    CTextField tfVideo;
    DimButton browse, browseV;
	//}}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == DialogEditPaesaggio.this)
				Dialog1_WindowClosing(event);
		}
	}
	
	void Dialog1_WindowClosing(java.awt.event.WindowEvent event)
	{
		setVisible(false);
		dispose();
	}

	class SymItem implements java.awt.event.ItemListener
	{
		public void itemStateChanged(java.awt.event.ItemEvent event)
		{
			Object object = event.getSource();
			if (object == lIcona)
				lIcona_ItemStateChanged(event);
		}
	}

	void lIcona_ItemStateChanged(java.awt.event.ItemEvent event)
	{
        int i=lIcona.getSelectedIndex();
        cIcona.setImage((Image)imgIcone.elementAt(i));
        //tfTitolo.setText(lIcona.getSelectedItem());

		//{{CONNECTION
		// Repaint the Canvas
        cIcona.repaint();
		//}}
	}

	class SymMouse extends java.awt.event.MouseAdapter
	{
		public void mouseClicked(java.awt.event.MouseEvent event)
		{
			Object object = event.getSource();
			if (object == okbutton)
				okbutton_MouseClick(event);
			else if (object == cancelbutton)
				cancelbutton_MouseClick(event);
			else if (object == browse)
				browseFile(tfImmagine,"Scegli l'immagine...");
			else if (object == browseV)
				browseFile(tfVideo,"Scegli il video...");
		}
	}

	void okbutton_MouseClick(java.awt.event.MouseEvent event)
	{
	    String didascalia,icona;
	    if((didascalia=tfTitolo.getText()).length()==0)
	    {
	        AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il campo Didascalia non pu� essere vuoto.");
		    d.display();
		}
		else if((icona=((String)nomiImg.elementAt(lIcona.getSelectedIndex()))).length()==0)
	    {
	        AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Deve essere selezionata una icona.");
		    d.display();
		}
		else
		{
            rs.title=didascalia;
            rs.scheda.didascalia=didascalia;
            rs.scheda.icona=icona;
            if(tfGiorno.getText().length()!=0||tfMese.getText().length()!=0||
               tfAnno.getText().length()!=0||tfOra.getText().length()!=0||
               tfMinuti.getText().length()!=0||tfSecondi.getText().length()!=0)
            {
               TimeStamp t=new TimeStamp(tfGiorno.getText(),tfMese.getText(),tfAnno.getText(),
                                        tfOra.getText(),tfMinuti.getText(),tfSecondi.getText());
                if(t.validate())
                    rs.scheda.timestamp=t.toString();
                else
                {
	                AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Data/Ora errata.");
		            d.display();
		            return;
		        }
		    }
		    else
		        rs.scheda.timestamp="";
            rs.scheda.note=textArea1.getText();
			File f;
			if(tfImmagine.getText().length()!=0)
			{
				f=new File(tfImmagine.getText());
				if(f.exists() && f.isAbsolute() && f.isFile())
		            rs.scheda.immagine=tfImmagine.getText();
				else
				{
	                AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il file immagine "+tfImmagine.getText()+" non � corretto!");
					d.display();
		            return;
				}
			} else {
				rs.scheda.immagine = "";
			}
			if(tfVideo.getText().length()!=0)
			{
				f=new File(tfVideo.getText());
				if(f.exists() && f.isAbsolute() && f.isFile())
		            rs.scheda.video=tfVideo.getText();
				else
				{
	                AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il file video "+tfVideo.getText()+" non � corretto!");
					d.display();
		            return;
				}
			} else {
				rs.scheda.video = "";
			}
    		//{{CONNECTION
    		// Hide the Dialog
    		setVisible(false);
    		//}}
    		dispose();
        }
	}

	void cancelbutton_MouseClick(java.awt.event.MouseEvent event)
	{
		// to do: code goes here.
	    
		//{{CONNECTION
		// Hide the Dialog
		setVisible(false);
		//}}
		dispose();
	}

	void browseFile(TextField tf,String title)
	{
		FileDialog fd=new FileDialog(parent,title,FileDialog.LOAD);
		File iFile;

		//Setto la directory e il nome file all'interno del dialog
		iFile=new File(tf.getText());
		if(iFile.exists() && iFile.isFile() && iFile.isAbsolute())
		{
			fd.setDirectory(iFile.getParent());
			fd.setFile(iFile.getName());
		}
		else
		{
			if(((PRB)parent).c_param.dir.length()>0)
				fd.setDirectory(DiskUtil.getRealDir(((PRB)parent).c_param.dir));
			else
				fd.setDirectory(".");
		}

		//mostro il dialog
		fd.setVisible(true);

		//catturo il nome file
		if(fd.getFile()!=null)
		{
			String strFile=fd.getDirectory()+fd.getFile();
			File oFile=new File(strFile);
			if(!oFile.exists())
			{
				AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il file "+strFile+" non esiste!!");
				d.display();
			}
			else
				tf.setText(strFile);
		}
		fd.dispose();
	}

    class SymKey extends java.awt.event.KeyAdapter
	{
//		public void keyTyped(java.awt.event.KeyEvent event)
//		{
//			Object object = event.getSource();
//          ...
//		}
	}

}