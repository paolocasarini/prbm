package org.casarini.prbm.gui.dialog;
import java.awt.*;
import java.io.File;
import java.util.StringTokenizer;

import org.casarini.prbm.gui.PRB;
import org.casarini.prbm.gui.component.CTextField;
import org.casarini.prbm.gui.component.DimButton;
import org.casarini.prbm.gui.component.IconViewer;
import org.casarini.prbm.model.Curiosita;
import org.casarini.prbm.model.Resource;
import org.casarini.prbm.model.TimeStamp;
import org.casarini.prbm.util.DiskUtil;


public class DialogEditCuriosita extends Dialog
{
    Panel panel,panel1,panel2;
    DimButton okbutton,cancelbutton,bPrev,bSucc,browseI,browseA,browseV,iPrev,iSucc;
    CardLayout lay;
    Font fontN,fontB;
    CTextField tfDidascalia,tfImmagine,tfAudio,tfVideo;
    CTextField tfGiorno,tfMese,tfAnno,tfOra,tfMinuti,tfSecondi;
    TextArea taDescrizione,taPerche,taImpressioni;
    IconViewer cIcona;
    Image icona;
    Curiosita scheda;
    PRB parent;
    Resource rs;
    int numlay=1;
	public static final String icoDir="icone/cur/";
	String icone[];
	int iIcona=0;

	public DialogEditCuriosita(PRB parent,Resource rs)
	{
		super(parent, true);
		this.parent=parent;
		this.rs=rs;
		this.setTitle("Modifica scheda Curiosità/Osservazione");
		scheda=(Curiosita)rs.scheda;
        setBackground(Color.lightGray);
		icone=(new File(icoDir)).list();
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

        Toolkit tkit=getToolkit();
        icona=tkit.getImage(scheda.icona);
        MediaTracker tracker=new MediaTracker(this);
        tracker.addImage(icona,0);
        try{tracker.waitForID(0);}catch(Exception e){System.out.println(e.toString());}

		setLayout(new BorderLayout(5,5));
		setVisible(false);
		setSize(insets().left + insets().right + 500,insets().top + insets().bottom + 425);
		Label label1 = new Label("Proprietà scheda Curiosità/Osservazione",Label.CENTER);
		label1.setFont(new Font("Dialog", Font.BOLD, 14));
		add("North",label1);

		panel=new Panel();
 		panel.setLayout(lay=new CardLayout());
 		add("Center",panel);

		panel1=new Panel();
		panel1.setLayout(null);
		panel1.setSize(470,310);
		cIcona = new IconViewer();
		cIcona.setBounds(428,0,52,52);
  		cIcona.setImage(icona);
		panel1.add(cIcona);
		//Label label0 = new Label("Icona");
		//label0.setBounds(440,2,250,16);
		//label0.setFont(fontB);
		//panel1.add(label0);

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
		Label label5 = new Label("Descrizione:");
		label5.setBounds(9,53,160,12);
		label5.setFont(fontB);
		panel1.add(label5);
		taDescrizione = new TextArea();
		taDescrizione.setBounds(9,68,476,54);
		taDescrizione.setBackground(Color.yellow);
		panel1.add(taDescrizione);
		Label label6 = new Label("Perchè è importante riportare questa curiorità");
		label6.setBounds(9,135,330,12);
		label6.setFont(fontB);
		panel1.add(label6);
		taPerche = new TextArea();
		taPerche.setBounds(9,148,476,54);
		panel1.add(taPerche);
		Label label7 = new Label("Impressioni e stato d'animo particolare:");
		label7.setBounds(9,214,250,12);
		label7.setFont(fontB);
		panel1.add(label7);
		taImpressioni = new TextArea();
		taImpressioni.setBounds(9,227,476,54);
		panel1.add(taImpressioni);
		iPrev = new DimButton(16,14);
		iPrev.setActionCommand("iprev");
		iPrev.setLabel("<");
		iPrev.setSize(16,14);
		iPrev.setBounds(428,53,26,14);
		iPrev.setBackground(new Color(12632256));
		panel1.add(iPrev);
		iSucc = new DimButton(16,14);
		iSucc.setActionCommand("isucc");
		iSucc.setLabel(">");
		iSucc.setBackground(new Color(12632256));
		iSucc.setBounds(454,53,26,14);
		panel1.add(iSucc);
		setEnabledIconButtons();
		panel.add("1",panel1);

		panel2=new Panel();
		panel2.setLayout(null);
		Label label11 = new Label("Immagine:");
		label11.setBounds(9,4,60,12);
		label11.setFont(fontB);
		panel2.add(label11);
		tfImmagine = new CTextField(CTextField.CTF_ALL,255);
		tfImmagine.setBounds(75,1,345,18);
		panel2.add(tfImmagine);
		browseI=new DimButton(62,20);
		browseI.setLabel("Sfoglia");
		browseI.setBounds(423,0,62,20);
		panel2.add(browseI);
		Label label4 = new Label("Audio:");
		label4.setBounds(9,27,40,12);
		label4.setFont(fontB);
		panel2.add(label4);
		tfAudio = new CTextField(CTextField.CTF_ALL,255);
		tfAudio.setBounds(55,24,365,18);
		panel2.add(tfAudio);
		browseA=new DimButton(62,20);
		browseA.setLabel("Sfoglia");
		browseA.setBounds(423,23,62,20);
		panel2.add(browseA);
		Label label13 = new Label("Video:");
		label13.setBounds(9,50,40,12);
		label13.setFont(fontB);
		panel2.add(label13);
		tfVideo = new CTextField(CTextField.CTF_ALL,255);
		tfVideo.setBounds(55,47,365,18);
		panel2.add(tfVideo);
		browseV=new DimButton(62,20);
		browseV.setLabel("Sfoglia");
		browseV.setBounds(423,46,62,20);
		panel2.add(browseV);
		panel.add("2",panel2);

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
		taDescrizione.setText(scheda.descrizione);
		taPerche.setText(scheda.perche);
		taImpressioni.setText(scheda.impressioni);
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
			if (object == DialogEditCuriosita.this)
				DialogEditCuriosita_WindowClosing(event);
		}
	}

	void DialogEditCuriosita_WindowClosing(java.awt.event.WindowEvent event)
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

		Toolkit tkit=getToolkit();
        icona=tkit.getImage(scheda.icona);
        MediaTracker tracker=new MediaTracker(this);
        tracker.addImage(icona,0);
        try{tracker.waitForID(0);}catch(Exception e){System.out.println(e.toString());}
  		cIcona.setImage(icona);
		cIcona.repaint();

		setEnabledIconButtons();
	}

	void iSucc_MouseClick()
	{
		iIcona++;
		scheda.icona=icoDir+icone[iIcona];

		Toolkit tkit=getToolkit();
        icona=tkit.getImage(scheda.icona);
        MediaTracker tracker=new MediaTracker(this);
        tracker.addImage(icona,0);
        try{tracker.waitForID(0);}catch(Exception e){System.out.println(e.toString());}
  		cIcona.setImage(icona);
		cIcona.repaint();

		setEnabledIconButtons();
	}

	void okbutton_MouseClick(java.awt.event.MouseEvent event)
	{
	    String didascalia,des;
	    if((didascalia=tfDidascalia.getText()).length()==0)
	    {
	        AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il campo Didascalia non può essere vuoto.");
		    d.display();
   		    if(numlay!=1){lay.first(panel);numlay=1;}
		    tfDidascalia.requestFocus();
		}
	    else if((des=taDescrizione.getText()).length()==0)
	    {
	        AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il campo Descrizione non può essere vuoto.");
		    d.display();
		    if(numlay!=1){lay.first(panel);numlay=1;}
		    taDescrizione.requestFocus();
		}
/*		else if((icona=((String)nomiImg.elementAt(lIcona.getSelectedIndex()))).length()==0)
	    {
	        AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Deve essere selezionata una icona.");
		    d.display();
		}*/
		else
		{
            rs.title=didascalia;
            scheda.didascalia=didascalia;
            scheda.descrizione=des;
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
			scheda.perche=taPerche.getText();
			scheda.impressioni=taImpressioni.getText();
			File f;
			if(tfImmagine.getText().length()!=0)
			{
				f=new File(tfImmagine.getText());
				if(f.exists() && f.isAbsolute() && f.isFile())
		            scheda.immagine=tfImmagine.getText();
				else
				{
	                AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il file immagine "+tfImmagine.getText()+" non è corretto!");
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
	                AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il file audio "+tfAudio.getText()+" non è corretto!");
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
	                AttentionDialog d=new AttentionDialog(parent,"ATTENZIONE!","Il file video "+tfVideo.getText()+" non è corretto!");
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
	    numlay--;
	}
	void bSucc_MouseClick(java.awt.event.MouseEvent event)
	{
   	    lay.next(panel);
        if(numlay==1)
   	    {
    	    bPrev.setEnabled(true);
	        bSucc.setEnabled(false);
	        //.requestFocus();
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