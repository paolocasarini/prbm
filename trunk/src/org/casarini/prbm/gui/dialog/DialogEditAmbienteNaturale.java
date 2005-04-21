/* DialogEditAmbienteNaturale.java
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

 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package org.casarini.prbm.gui.dialog;
import java.awt.*;
import java.io.File;
import java.util.StringTokenizer;

import org.casarini.prbm.gui.PRB;
import org.casarini.prbm.gui.component.CTextField;
import org.casarini.prbm.gui.component.DimButton;
import org.casarini.prbm.gui.component.IconViewer;
import org.casarini.prbm.model.AmbienteNaturale;
import org.casarini.prbm.model.Resource;
import org.casarini.prbm.model.TimeStamp;
import org.casarini.prbm.util.DiskUtil;
import org.casarini.prbm.util.IconFactory;


public class DialogEditAmbienteNaturale extends Dialog
{
    Panel panel,panel1,panel2,panel3;
    DimButton okbutton,cancelbutton,bPrev,bSucc,browseI,browseA,browseV,iPrev,iSucc;
    CardLayout lay;
    Font fontN,fontB;
    CTextField tfDidascalia,tfLocalita,tfImmagine,tfAudio,tfVideo;
    CTextField tfGiorno,tfMese,tfAnno,tfOra,tfMinuti,tfSecondi;
    TextArea taDesGenerale,taHabitat,taOkPiaciuto,taKoPiaciuto,taFlora,taFauna;
    TextArea taUomo,taPositivo,taNegativo;
    IconViewer cIcona;
    Image icona;
    AmbienteNaturale scheda;
    PRB parent;
    Resource rs;
    int numlay=1;
	public static final String icoDir="icone/amb/";
	String icone[];
	int iIcona=0;
    
	public DialogEditAmbienteNaturale(PRB parent,Resource rs)
	{
		super(parent, true);
		this.parent=parent;
		this.rs=rs;
		this.setTitle("Modifica scheda Ambiente Naturale");
       	setBackground(Color.lightGray);
		scheda=(AmbienteNaturale)rs.scheda;
		icone = (new File(DialogEditAmbienteNaturale.class.getResource("../../resources/" + icoDir).getFile())).list();
		if(scheda.icona.length()!=0)
		{
			boolean done=false;
			int i;
			for(i=0;i<icone.length&&!done;i++)
				if(scheda.icona.equals(icoDir+icone[i]))
					done=true;
			if(done)
				iIcona=i-1;
			else
				iIcona=0;
		}
		else
			iIcona=0;
		scheda.icona=icoDir+icone[iIcona];
		
		fontN=new Font("Dialog", Font.PLAIN, 12);
		fontB=new Font("Dialog", Font.BOLD, 12);

        icona = IconFactory.getInstance().getImage(scheda.icona);

		setLayout(new BorderLayout(5,5));
		setVisible(false);
		setSize(insets().left + insets().right + 500,insets().top + insets().bottom + 425);
		Label label1 = new Label("Propriet� scheda Ambiente Naturale",Label.CENTER);
		label1.setFont(new Font("Dialog", Font.BOLD, 14));
		add("North",label1);
		
		panel=new Panel();
 		panel.setLayout(lay=new CardLayout());
 		add("Center",panel);

		panel1=new Panel();
		panel1.setLayout(null);
		panel1.setSize(470,310);
		cIcona = new IconViewer();
		cIcona.setBounds(430,15,52,52);
  		cIcona.setImage(icona);
		panel1.add(cIcona);
		Label label0 = new Label("Icona");
		label0.setBounds(440,0,250,16);
		label0.setFont(fontB);
		panel1.add(label0);
 
		Label label2 = new Label("Didascalia:");
		label2.setBounds(9,7,63,12);
		label2.setFont(fontB);
		panel1.add(label2);
		tfDidascalia = new CTextField(CTextField.CTF_ALL,50);
		tfDidascalia.setBounds(78,4,336,18);
		tfDidascalia.setBackground(Color.yellow);
		panel1.add(tfDidascalia);
		Label label2a = new Label("Data rilevamento:");
		label2a.setBounds(9,30,102,12);
		label2a.setFont(fontB);
		panel1.add(label2a);
		tfGiorno = new CTextField(CTextField.CTF_NUM,2);
		tfGiorno.setBounds(117,27,24,18);
		panel1.add(tfGiorno);
		tfMese = new CTextField(CTextField.CTF_NUM,2);
		tfMese.setBounds(147,27,24,18);
		panel1.add(tfMese);
		tfAnno = new CTextField(CTextField.CTF_NUM,4);
		tfAnno.setBounds(177,27,44,18);
		panel1.add(tfAnno);
		Label label2a1 = new Label("/");
		label2a1.setBounds(143,30,6,12);
		label2a1.setFont(fontB);
		panel1.add(label2a1);
		Label label2a2 = new Label("/");
		label2a2.setBounds(173,30,6,12);
		label2a2.setFont(fontB);
		panel1.add(label2a2);
		Label label2b = new Label("Ora rilevamento:");
		label2b.setBounds(231,30,96,12);
		label2b.setFont(fontB);
		panel1.add(label2b);
		tfOra = new CTextField(CTextField.CTF_NUM,2);
		tfOra.setBounds(330,27,24,18);
		panel1.add(tfOra);
		tfMinuti = new CTextField(CTextField.CTF_NUM,2);
		tfMinuti.setBounds(360,27,24,18);
		panel1.add(tfMinuti);
		tfSecondi = new CTextField(CTextField.CTF_NUM,2);
		tfSecondi.setBounds(390,27,24,18);
		panel1.add(tfSecondi);
		Label label2b1 = new Label(":");
		label2b1.setBounds(356,30,6,12);
		label2b1.setFont(fontB);
		panel1.add(label2b1);
		Label label2b2 = new Label(":");
		label2b2.setBounds(386,30,6,12);
		label2b2.setFont(fontB);
		panel1.add(label2b2);
		Label label3 = new Label("Localit�:");
		label3.setBounds(9,53,50,12);
		label3.setFont(fontB);
		panel1.add(label3);
		tfLocalita = new CTextField(CTextField.CTF_ALL,50);
		tfLocalita.setBounds(62,50,352,18);
		tfLocalita.setBackground(Color.yellow);
		panel1.add(tfLocalita);
		Label label5 = new Label("Descrizione generale:");
		label5.setBounds(9,76,160,12);
		label5.setFont(fontB);
		panel1.add(label5);
		taDesGenerale = new TextArea();
		taDesGenerale.setBounds(9,91,476,54);
		taDesGenerale.setBackground(Color.yellow);
		panel1.add(taDesGenerale);
		Label label6 = new Label("Tipo Ambiente / Habitat:");
		label6.setBounds(9,158,150,12);
		label6.setFont(fontB);
		panel1.add(label6);
		taHabitat = new TextArea();
		taHabitat.setBounds(9,171,476,54);
		panel1.add(taHabitat);
		Label label7 = new Label("Descrizione della Flora presente:");
		label7.setBounds(9,237,202,12);
		label7.setFont(fontB);
		panel1.add(label7);
		taFlora = new TextArea();
		taFlora.setBounds(9,250,476,54);
		panel1.add(taFlora);
		iPrev = new DimButton(16,14);
		iPrev.setActionCommand("iprev");
		iPrev.setLabel("<");
		iPrev.setSize(16,14);
		iPrev.setBounds(430,69,26,14);
		iPrev.setBackground(new Color(12632256));
		panel1.add(iPrev);
		iSucc = new DimButton(16,14);
		iSucc.setActionCommand("isucc");
		iSucc.setLabel(">");
		iSucc.setBackground(new Color(12632256));
		iSucc.setBounds(456,69,26,14);
		panel1.add(iSucc);
		setEnabledIconButtons();
		panel.add("1",panel1);
		
		panel2=new Panel();
		panel2.setLayout(null);
		Label label16 = new Label("Descrizione della Fauna presente:");
		label16.setBounds(9,4,281,12);
		label16.setFont(fontB);
		panel2.add(label16);
		taFauna = new java.awt.TextArea();
		taFauna.setBounds(9,19,476,54);
		panel2.add(taFauna);
		Label label14 = new Label("Impatto dell'Uomo:");
		label14.setBounds(9,84,180,12);
		label14.setFont(fontB);
		panel2.add(label14);
		taUomo = new TextArea();
		taUomo.setBounds(9,99,476,54);
		panel2.add(taUomo);
		Label label15 = new Label("Cosa � piaciuto di pi�:");
		label15.setBounds(9,164,181,12);
		label15.setFont(fontB);
		panel2.add(label15);
		taOkPiaciuto = new TextArea();
		taOkPiaciuto.setBounds(9,179,476,54);
		panel2.add(taOkPiaciuto);
		Label label12 = new Label("Cosa � piaciuto di meno:");
		label12.setBounds(9,244,181,12);
		label12.setFont(fontB);
		panel2.add(label12);
		taKoPiaciuto = new TextArea();
		taKoPiaciuto.setBounds(9,259,476,54);
		panel2.add(taKoPiaciuto);
		panel.add("2",panel2);

		panel3=new Panel();
		panel3.setLayout(null);
		Label label9 = new Label("Sensazioni personali positive:");
		label9.setBounds(9,4,281,12);
		label9.setFont(fontB);
		panel3.add(label9);
		taPositivo = new java.awt.TextArea();
		taPositivo.setBounds(9,19,476,54);
		panel3.add(taPositivo);
		Label label10 = new Label("Sensazioni personali negative:");
		label10.setBounds(9,84,281,12);
		label10.setFont(fontB);
		panel3.add(label10);
		taNegativo = new TextArea();
		taNegativo.setBounds(9,99,476,54);
		panel3.add(taNegativo);
		Label label11 = new Label("Immagine:");
		label11.setBounds(9,164,60,12);
		label11.setFont(fontB);
		panel3.add(label11);
		tfImmagine = new CTextField(CTextField.CTF_ALL,255);
		tfImmagine.setBounds(75,161,345,18);
		panel3.add(tfImmagine);
		browseI=new DimButton(62,20);
		browseI.setLabel("Sfoglia");
		browseI.setBounds(423,160,62,20);
		panel3.add(browseI);
		Label label4 = new Label("Audio:");
		label4.setBounds(9,187,40,12);
		label4.setFont(fontB);
		panel3.add(label4);
		tfAudio = new CTextField(CTextField.CTF_ALL,255);
		tfAudio.setBounds(55,184,365,18);
		panel3.add(tfAudio);
		browseA=new DimButton(62,20);
		browseA.setLabel("Sfoglia");
		browseA.setBounds(423,183,62,20);
		panel3.add(browseA);
		Label label13 = new Label("Video:");
		label13.setBounds(9,210,40,12);
		label13.setFont(fontB);
		panel3.add(label13);
		tfVideo = new CTextField(CTextField.CTF_ALL,255);
		tfVideo.setBounds(55,207,365,18);
		panel3.add(tfVideo);
		browseV=new DimButton(62,20);
		browseV.setLabel("Sfoglia");
		browseV.setBounds(423,206,62,20);
		panel3.add(browseV);
		panel.add("3",panel3);
		
		Panel bPanel=new Panel();
		Panel b1Panel=new Panel();
		Panel b2Panel=new Panel();
		b1Panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
		b2Panel.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		bPanel.setLayout(new BorderLayout(1,1));
		bPrev = new DimButton(16,14);
		bPrev.setActionCommand("prev");
		bPrev.setLabel("<");
		bPrev.setSize(16,14);
		bPrev.setBackground(new Color(12632256));
		b2Panel.add(bPrev);
		bSucc = new DimButton(16,14);
		bSucc.setActionCommand("succ");
		bSucc.setLabel(">");
		bSucc.setBackground(new Color(12632256));
		b2Panel.add(bSucc);
		okbutton = new DimButton(62,24);
		okbutton.setActionCommand("OK");
		okbutton.setLabel("OK");
		okbutton.setFont(new Font("Dialog", Font.BOLD, 12));
		okbutton.setBackground(new Color(12632256));
		b1Panel.add(okbutton);
		cancelbutton = new DimButton(62,24);
		cancelbutton.setActionCommand("KO");
		cancelbutton.setLabel("Annulla");
		cancelbutton.setFont(new Font("Dialog", Font.BOLD, 12));
		cancelbutton.setBackground(new Color(12632256));
		b1Panel.add(cancelbutton);
	    bPrev.setEnabled(false);   	    
	    bSucc.setEnabled(true);
	    bPanel.add("Center",b1Panel);
	    bPanel.add("North",b2Panel);
	    add("South",bPanel);

		//LISTENERS
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymMouse aSymMouse = new SymMouse();
		okbutton.addMouseListener(aSymMouse);
		cancelbutton.addMouseListener(aSymMouse);
        bPrev.addMouseListener(aSymMouse);
        bSucc.addMouseListener(aSymMouse);
		iPrev.addMouseListener(aSymMouse);
        iSucc.addMouseListener(aSymMouse);
        browseI.addMouseListener(aSymMouse);
        browseA.addMouseListener(aSymMouse);
        browseV.addMouseListener(aSymMouse);
		SymKey aSymKey = new SymKey();
		tfDidascalia.addKeyListener(aSymKey);
		tfGiorno.addKeyListener(aSymKey);
		tfMese.addKeyListener(aSymKey);
		tfAnno.addKeyListener(aSymKey);
		tfOra.addKeyListener(aSymKey);
		tfMinuti.addKeyListener(aSymKey);
		tfSecondi.addKeyListener(aSymKey);
		tfLocalita.addKeyListener(aSymKey);
		tfImmagine.addKeyListener(aSymKey);
		tfAudio.addKeyListener(aSymKey);
		tfVideo.addKeyListener(aSymKey);
        
        
   		//Init dei campi
		tfDidascalia.setText(scheda.didascalia);
		if(rs.scheda.timestamp.length()==0)
		{
			rs.scheda.timestamp=parent.c_param.data;
		}
		if(rs.scheda.timestamp.length()!=0)
		{
		    StringTokenizer t=new StringTokenizer(scheda.timestamp,"-");
		    tfGiorno.setText(t.nextToken());
		    tfMese.setText(t.nextToken());
		    tfAnno.setText(t.nextToken());
		    tfOra.setText(t.nextToken());
		    tfMinuti.setText(t.nextToken());
		    tfSecondi.setText(t.nextToken());
		}
		tfLocalita.setText(scheda.localita);
		taDesGenerale.setText(scheda.desGenerale);
		taHabitat.setText(scheda.habitat);
		taFlora.setText(scheda.flora);
		taFauna.setText(scheda.fauna);
		taUomo.setText(scheda.uomo);
		taOkPiaciuto.setText(scheda.okPiaciuto);
		taKoPiaciuto.setText(scheda.koPiaciuto);
        taPositivo.setText(scheda.positivo);
        taNegativo.setText(scheda.negativo);
        tfImmagine.setText(scheda.immagine);
        tfAudio.setText(scheda.audio);
        tfVideo.setText(scheda.video);
	}

	//mette a posto l'attivazione dei bottoni per l'icona
	void setEnabledIconButtons()
	{
		if(icone.length<=1)
		{
			iPrev.setEnabled(false);
			iSucc.setEnabled(false);
		}
		else
		{
			if(iIcona==0)
			{
				iPrev.setEnabled(false);
				iSucc.setEnabled(true);
			}
			else if(iIcona==icone.length-1)
			{
				iPrev.setEnabled(true);
				iSucc.setEnabled(false);
			}
			else
			{
				iPrev.setEnabled(true);
				iSucc.setEnabled(true);
			}
		}
	}

/*	public void addNotify()
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
	boolean fComponentsAdjusted = false;*/


    public void show()
	{
		Rectangle bounds = getParent().bounds();
		Rectangle abounds = bounds();

		move(bounds.x + (bounds.width - abounds.width)/ 2,
			 bounds.y + (bounds.height - abounds.height)/2);

		super.show();
	}
	
    class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == DialogEditAmbienteNaturale.this)
				DialogEditAmbienteNaturale_WindowClosing(event);
		}
	}
	
	void DialogEditAmbienteNaturale_WindowClosing(java.awt.event.WindowEvent event)
	{
		setVisible(false);
		dispose();
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
			else if (object == bPrev)
				bPrev_MouseClick(event);
			else if (object == bSucc)
				bSucc_MouseClick(event);
			else if (object == browseI)
				browseFile(tfImmagine,"Scegli l'immagine...");
			else if (object == browseA)
				browseFile(tfAudio,"Scegli l'audio...");
			else if (object == browseV)
				browseFile(tfVideo,"Scegli il video...");
			else if (object == iPrev)
				iPrev_MouseClick();
			else if (object == iSucc)
				iSucc_MouseClick();
		}
	}

	void iPrev_MouseClick()
	{
		iIcona--;
		scheda.icona=icoDir+icone[iIcona];

        icona = IconFactory.getInstance().getImage(scheda.icona);
  		cIcona.setImage(icona);
		cIcona.repaint();

		setEnabledIconButtons();
	}

	void iSucc_MouseClick()
	{
		iIcona++;
		scheda.icona=icoDir+icone[iIcona];

        icona = IconFactory.getInstance().getImage(scheda.icona);
  		cIcona.setImage(icona);
		cIcona.repaint();

		setEnabledIconButtons();
	}

	void okbutton_MouseClick(java.awt.event.MouseEvent event)
	{
	    String didascalia,loc,desG;
	    if((didascalia=tfDidascalia.getText()).length()==0)
	    {
	        AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il campo Didascalia non pu� essere vuoto.");
		    d.display();
   		    if(numlay!=1){lay.first(panel);numlay=1;}
		    tfDidascalia.requestFocus();
		}
	    else if((loc=tfLocalita.getText()).length()==0)
	    {
	        AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il campo Localit� non pu� essere vuoto.");
		    d.display();
		    if(numlay!=1){lay.first(panel);numlay=1;}
		    tfLocalita.requestFocus();
		}
	    else if((desG=taDesGenerale.getText()).length()==0)
	    {
	        AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il campo Descrizione Generale non pu� essere vuoto.");
		    d.display();
		    if(numlay!=1){lay.first(panel);numlay=1;}
		    taDesGenerale.requestFocus();
		}
		else
		{
            rs.title=didascalia;
            scheda.didascalia=didascalia;
            scheda.localita=loc;
            scheda.desGenerale=desG;
            //rs.scheda.icona=icona;
            if(tfGiorno.getText().length()!=0||tfMese.getText().length()!=0||
               tfAnno.getText().length()!=0||tfOra.getText().length()!=0||
               tfMinuti.getText().length()!=0||tfSecondi.getText().length()!=0)
            {
               TimeStamp t=new TimeStamp(tfGiorno.getText(),tfMese.getText(),tfAnno.getText(),
                                        tfOra.getText(),tfMinuti.getText(),tfSecondi.getText());
                if(t.validate())
                    scheda.timestamp=t.toString();
                else
                {
	                AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Data/Ora errata.");
		            d.display();
        		    if(numlay!=1){lay.first(panel);numlay=1;}
        		    tfGiorno.requestFocus();
		            return;
		        }
		    }
		    else
		        scheda.timestamp="";
			scheda.habitat=taHabitat.getText();
			scheda.flora=taFlora.getText();
			scheda.fauna=taFauna.getText();
			scheda.uomo=taUomo.getText();
            scheda.okPiaciuto=taOkPiaciuto.getText();
            scheda.koPiaciuto=taKoPiaciuto.getText();
            scheda.positivo=taPositivo.getText();
            scheda.negativo=taNegativo.getText();
			File f;
			if(tfImmagine.getText().length()!=0)
			{
				f=new File(tfImmagine.getText());
				if(f.exists() && f.isAbsolute() && f.isFile())
		            scheda.immagine=tfImmagine.getText();
				else
				{
	                AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il file immagine "+tfImmagine.getText()+" non � corretto!");
					d.display();
		            return;
				}
			}
			if(tfAudio.getText().length()!=0)
			{
				f=new File(tfAudio.getText());
				if(f.exists() && f.isAbsolute() && f.isFile())
		            scheda.audio=tfAudio.getText();
				else
				{
	                AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il file audio "+tfAudio.getText()+" non � corretto!");
					d.display();
		            return;
				}
			}
			if(tfVideo.getText().length()!=0)
			{
				f=new File(tfVideo.getText());
				if(f.exists() && f.isAbsolute() && f.isFile())
		            scheda.video=tfVideo.getText();
				else
				{
	                AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il file video "+tfVideo.getText()+" non � corretto!");
					d.display();
		            return;
				}
			}
	    
    		setVisible(false);
    		dispose();
    	}
	}

	void cancelbutton_MouseClick(java.awt.event.MouseEvent event)
	{
		setVisible(false);
		dispose();
	}

	void bPrev_MouseClick(java.awt.event.MouseEvent event)
	{
	    lay.previous(panel);
	    if(numlay==2)
	    {
    	    bPrev.setEnabled(false);
	        bSucc.setEnabled(true);
	        tfDidascalia.requestFocus();
	    }
	    else if(numlay==3)
	    {
    	    bPrev.setEnabled(true);
	        bSucc.setEnabled(true);
	        taFauna.requestFocus();
	    }
	    numlay--;
	}
	void bSucc_MouseClick(java.awt.event.MouseEvent event)
	{
   	    lay.next(panel);
   	    if(numlay==1)
   	    {
    	    bPrev.setEnabled(true);   	    
	        bSucc.setEnabled(true);
	        taFauna.requestFocus();
	    }
	    else if(numlay==2)
   	    {
    	    bPrev.setEnabled(true);   	    
	        bSucc.setEnabled(false);
	        taPositivo.requestFocus();
	    }
	    numlay++;
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