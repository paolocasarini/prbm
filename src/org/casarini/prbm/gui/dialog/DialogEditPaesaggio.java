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
import org.casarini.prbm.util.IconFactory;


public class DialogEditPaesaggio extends DefaultDialogEdit
{
	private static final long serialVersionUID = -7163576880980877540L;

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
		setSize(getInsets().left + getInsets().right + 467, getInsets().top + getInsets().bottom + 448);
		tfTitolo = new CTextField(CTextField.CTF_ALL,50);
		tfTitolo.setBounds(getInsets().left + 81,getInsets().top + 39,380,18);
		tfTitolo.setBackground(Color.yellow);
		add(tfTitolo);
		label1 = new java.awt.Label("Propriet� scheda Paesaggio",Label.CENTER);
		label1.setBounds(getInsets().left + 7,getInsets().top + 6,453,18);
		label1.setFont(new Font("Dialog", Font.BOLD, 14));
		add(label1);
		label2 = new java.awt.Label("Didascalia:");
		label2.setBounds(getInsets().left + 12,getInsets().top + 42,64,12);
		label2.setFont(fontB);
		add(label2);
		label3 = new java.awt.Label("Elemento Paesaggistico:");
		label3.setBounds(getInsets().left + 12,getInsets().top + 66,200,14);
		label3.setFont(fontB);
		add(label3);
		label4 = new java.awt.Label("Data rilevamento:");
		label4.setBounds(getInsets().left + 228,getInsets().top + 84,102,12);
		label4.setFont(fontB);
		add(label4);
		tfGiorno = new CTextField(CTextField.CTF_NUM,2);
		tfGiorno.setBounds(getInsets().left + 336,getInsets().top + 81,24,18);
		add(tfGiorno);
		tfMese = new CTextField(CTextField.CTF_NUM,2);
		tfMese.setBounds(getInsets().left + 366,getInsets().top + 81,24,18);
		add(tfMese);
		tfAnno = new CTextField(CTextField.CTF_NUM,4);
		tfAnno.setBounds(getInsets().left + 396,getInsets().top + 81,44,18);
		add(tfAnno);
		label5 = new java.awt.Label("/");
		label5.setBounds(getInsets().left + 360,getInsets().top + 84,6,12);
		label5.setFont(fontB);
		add(label5);
		label6 = new java.awt.Label("/");
		label6.setBounds(getInsets().left + 390,getInsets().top + 84,6,12);
		label6.setFont(fontB);
		add(label6);
		label7 = new java.awt.Label("Ora rilevamento:");
		label7.setBounds(getInsets().left + 234,getInsets().top + 108,96,12);
		label7.setFont(fontB);
		add(label7);
		tfOra = new CTextField(CTextField.CTF_NUM,2);
		tfOra.setBounds(getInsets().left + 336,getInsets().top + 105,24,18);
		add(tfOra);
		tfMinuti = new CTextField(CTextField.CTF_NUM,2);
		tfMinuti.setBounds(getInsets().left + 366,getInsets().top + 105,24,18);
		add(tfMinuti);
		tfSecondi = new CTextField(CTextField.CTF_NUM,2);
		tfSecondi.setBounds(getInsets().left + 396,getInsets().top + 105,24,18);
		add(tfSecondi);
		label8 = new java.awt.Label(":");
		label8.setBounds(getInsets().left + 360,getInsets().top + 108,6,12);
		label8.setFont(fontB);
		add(label8);
		label9 = new java.awt.Label(":");
		label9.setBounds(getInsets().left + 390,getInsets().top + 108,6,12);
		label9.setFont(fontB);
		add(label9);
		label10 = new java.awt.Label("Note:");
		label10.setBounds(getInsets().left + 12,getInsets().top + 321,30,12);
		label10.setFont(fontB);
		add(label10);
		textArea1 = new java.awt.TextArea();
		textArea1.setBounds(getInsets().left + 48,getInsets().top + 318,411,75);
		add(textArea1);
		lIcona = new java.awt.List(0,false);
		add(lIcona);
		lIcona.setBounds(getInsets().left + 12,getInsets().top + 84,186,180);
		okbutton = new java.awt.Button();
		okbutton.setActionCommand("button");
		okbutton.setLabel("OK");
		okbutton.setBounds(getInsets().left + 160,getInsets().top + 408,62,24);
		okbutton.setFont(fontB);
		okbutton.setBackground(new Color(12632256));
		add(okbutton);
		cancelbutton = new java.awt.Button();
		cancelbutton.setActionCommand("button");
		cancelbutton.setLabel("Annulla");
		cancelbutton.setBounds(getInsets().left + 244,getInsets().top + 408,62,24);
		cancelbutton.setFont(fontB);
		cancelbutton.setBackground(new Color(12632256));
		add(cancelbutton);
		cIcona = new IconViewer();
		cIcona.setBounds(getInsets().left + 298,getInsets().top + 198,60,60);
		add(cIcona);
		label11 = new java.awt.Label("Preview Icona",Label.CENTER);
		label11.setBounds(getInsets().left + 204,getInsets().top + 171,250,16);
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
		
		lIcona.add("Paesaggio generico");
		nomiImg.addElement((Object) new String("paesaggi/standard.gif"));
		lIcona.add("ferrovia");
		nomiImg.addElement((Object) new String("paesaggi/ferrovia.gif"));		
		lIcona.add("stazione ferroviaria");
		nomiImg.addElement((Object) new String("paesaggi/stazferro.gif"));		
		lIcona.add("galleria ferroviaria");
		nomiImg.addElement((Object) new String("paesaggi/gallferro.gif"));		
		lIcona.add("ponte ferroviario");
		nomiImg.addElement((Object) new String("paesaggi/ponteferro.gif"));		
		lIcona.add("passaggio a livello");
		nomiImg.addElement((Object) new String("paesaggi/passlivello.gif"));		
		lIcona.add("funicolare");
		nomiImg.addElement((Object) new String("paesaggi/funicolare.gif"));
		lIcona.add("teleferica");
		nomiImg.addElement((Object) new String("paesaggi/teleferica.gif"));		
		lIcona.add("funivia");
		nomiImg.addElement((Object) new String("paesaggi/funivia.gif"));
		lIcona.add("seggiovia");
		nomiImg.addElement((Object) new String("paesaggi/seggiovia.gif"));
		lIcona.add("sciovia (skylift)");
		nomiImg.addElement((Object) new String("paesaggi/sciovia.gif"));
		lIcona.add("autostrada");
		nomiImg.addElement((Object) new String("paesaggi/autostra.gif"));
		lIcona.add("casello autostradale");
		nomiImg.addElement((Object) new String("paesaggi/casello.gif"));
		lIcona.add("galleria autostradale");
		nomiImg.addElement((Object) new String("paesaggi/galleria autostrada.gif"));
		lIcona.add("ponte autostradale");
		nomiImg.addElement((Object) new String("paesaggi/ponteautostrada.gif"));
		lIcona.add("strada");
		nomiImg.addElement((Object) new String("paesaggi/strada.gif"));
		lIcona.add("galleria stradale");
		nomiImg.addElement((Object) new String("paesaggi/galleria stradale.gif"));
		lIcona.add("ponte stradale");
		nomiImg.addElement((Object) new String("paesaggi/ponte stradale.gif"));
		lIcona.add("ponte pedonale");
		nomiImg.addElement((Object) new String("paesaggi/pontepedonale.gif"));
		lIcona.add("ponte di barche");
		nomiImg.addElement((Object) new String("paesaggi/pontebarche.gif"));
		lIcona.add("strada carreggiabile");
		nomiImg.addElement((Object) new String("paesaggi/strada carreggiabile.gif"));
		lIcona.add("mulattiera");
		nomiImg.addElement((Object) new String("paesaggi/mulattiera.gif"));
		lIcona.add("sentiero");
		nomiImg.addElement((Object) new String("paesaggi/sentiero.gif"));
		lIcona.add("casa in muratura");
		nomiImg.addElement((Object) new String("paesaggi/casamura.gif"));
		lIcona.add("baracca");
		nomiImg.addElement((Object) new String("paesaggi/baracca.gif"));
		lIcona.add("capanna");
		nomiImg.addElement((Object) new String("paesaggi/capanna.gif"));
		lIcona.add("rudere");
		nomiImg.addElement((Object) new String("paesaggi/rudere.gif"));
		lIcona.add("stazione di rifornimento");
		nomiImg.addElement((Object) new String("paesaggi/stazione di rifornimento.gif"));
		lIcona.add("fabbrica");
		nomiImg.addElement((Object) new String("paesaggi/fabbrica.gif"));
		lIcona.add("centrale idroelettrica");
		nomiImg.addElement((Object) new String("paesaggi/centrale idroelettrica.gif"));
		lIcona.add("centrale termoelettrica");
		nomiImg.addElement((Object) new String("paesaggi/centrale termoelettrica.gif"));
		lIcona.add("chiesa");
		nomiImg.addElement((Object) new String("paesaggi/chiesa.gif"));
		lIcona.add("cappella");
		nomiImg.addElement((Object) new String("paesaggi/cappella.gif"));
		lIcona.add("tabernacolo");
		nomiImg.addElement((Object) new String("paesaggi/tabernacolo.gif"));
		lIcona.add("croce isolata");
		nomiImg.addElement((Object) new String("paesaggi/crocefisso.gif"));
		lIcona.add("cimitero");
		nomiImg.addElement((Object) new String("paesaggi/cimitero.gif"));
		lIcona.add("fumaiolo");
		nomiImg.addElement((Object) new String("paesaggi/fumaiolo.gif"));
		lIcona.add("torre");
		nomiImg.addElement((Object) new String("paesaggi/torre.gif"));
		lIcona.add("pietra o colonna indicatrice");
		nomiImg.addElement((Object) new String("paesaggi/pietra o colonna indicatrice.gif"));
		lIcona.add("castello");
		nomiImg.addElement((Object) new String("paesaggi/castello.gif"));
		lIcona.add("villa antica");
		nomiImg.addElement((Object) new String("paesaggi/villaantica.gif"));
		lIcona.add("monumento notevole");
		nomiImg.addElement((Object) new String("paesaggi/monumento notevole.gif"));
		lIcona.add("antenna per telecominicazioni");
		nomiImg.addElement((Object) new String("paesaggi/antennatelecom.gif"));
		lIcona.add("miniera");
		nomiImg.addElement((Object) new String("paesaggi/miniera.gif"));
		lIcona.add("pozzo di petrolio/gas");
		nomiImg.addElement((Object) new String("paesaggi/pozzopetrolio.gif"));
		lIcona.add("grotta");
		nomiImg.addElement((Object) new String("paesaggi/grotta.gif"));
		lIcona.add("faro");
		nomiImg.addElement((Object) new String("paesaggi/faro.gif"));
		lIcona.add("pozzo d'acqua");
		nomiImg.addElement((Object) new String("paesaggi/pozzo d'acqua.gif"));
		lIcona.add("sorgente d'acqua");
		nomiImg.addElement((Object) new String("paesaggi/sorgente d'acqua.gif"));
		lIcona.add("fontana");
		nomiImg.addElement((Object) new String("paesaggi/fontana.gif"));
		lIcona.add("cisterna");
		nomiImg.addElement((Object) new String("paesaggi/cisterna.gif"));
		lIcona.add("abbeveratoio");
		nomiImg.addElement((Object) new String("paesaggi/abbeveratoio.gif"));
		lIcona.add("abbeveratoio con fontana");
		nomiImg.addElement((Object) new String("paesaggi/abbeveratoio con fontana.gif"));
		lIcona.add("muro a calce");
		nomiImg.addElement((Object) new String("paesaggi/muroacalce.gif"));
		lIcona.add("muro a secco o maceria");
		nomiImg.addElement((Object) new String("paesaggi/muroasecco.gif"));
		lIcona.add("muro di sostegno");
		nomiImg.addElement((Object) new String("paesaggi/murosostegno.gif"));
		lIcona.add("palizzata/staccionata");
		nomiImg.addElement((Object) new String("paesaggi/staccionata.gif"));
		lIcona.add("siepe");
		nomiImg.addElement((Object) new String("paesaggi/siepe.gif"));
		lIcona.add("filo spinato");
		nomiImg.addElement((Object) new String("paesaggi/filospinato.gif"));
		lIcona.add("acquedotto");
		nomiImg.addElement((Object) new String("paesaggi/acquedotto.gif"));
		lIcona.add("torrente");
		nomiImg.addElement((Object) new String("paesaggi/torrente.gif"));
		lIcona.add("fiume piccolo");
		nomiImg.addElement((Object) new String("paesaggi/fiume piccolo.gif"));
		lIcona.add("fiume grosso");
		nomiImg.addElement((Object) new String("paesaggi/fiume grosso.gif"));
		lIcona.add("cascata");
		nomiImg.addElement((Object) new String("paesaggi/cascata.gif"));
		lIcona.add("laghetto");
		nomiImg.addElement((Object) new String("paesaggi/laghetto.gif"));
		lIcona.add("lago");
		nomiImg.addElement((Object) new String("paesaggi/lago.gif"));
		lIcona.add("diga");
		nomiImg.addElement((Object) new String("paesaggi/diga.gif"));
		lIcona.add("aeroporto");
		nomiImg.addElement((Object) new String("paesaggi/aeroporto.gif"));
		lIcona.add("idroscalo");
		nomiImg.addElement((Object) new String("paesaggi/idroscalo.gif"));
		lIcona.add("porto");
		nomiImg.addElement((Object) new String("paesaggi/porto.gif"));
		lIcona.add("punto di quota");
		nomiImg.addElement((Object) new String("paesaggi/punto di quota.gif"));
		lIcona.add("campo da tennis");
		nomiImg.addElement((Object) new String("paesaggi/campo_tennis.gif"));
		lIcona.add("traliccio corrente");
		nomiImg.addElement((Object) new String("paesaggi/traliccio_corrente.gif"));

		
        for(int i=0;i<nomiImg.size();i++)
        {
            imgIcone.addElement(IconFactory.getInstance().getImage((String)nomiImg.elementAt(i)));
        }
        
        
		//{{REGISTER_LISTENERS
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

		// Adjust components according to the getInsets
		setSize(getInsets().left + getInsets().right + d.width, getInsets().top + getInsets().bottom + d.height);
		Component components[] = getComponents();
		for (int i = 0; i < components.length; i++)
		{
			Point p = components[i].getLocation();
			p.translate(getInsets().left, getInsets().top);
			components[i].setLocation(p);
		}
		fComponentsAdjusted = true;
	}

    // Used for addNotify check.
	boolean fComponentsAdjusted = false;

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

    class SymKey extends java.awt.event.KeyAdapter
	{
//		public void keyTyped(java.awt.event.KeyEvent event)
//		{
//			Object object = event.getSource();
//          ...
//		}
	}

}