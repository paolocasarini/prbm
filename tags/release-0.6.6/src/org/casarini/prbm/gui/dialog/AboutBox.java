package org.casarini.prbm.gui.dialog;

import java.awt.*;
import java.awt.event.*;

public class AboutBox extends Dialog implements ActionListener
{
	public static final String VERSION="0.6.6";
	Label label1,label2,label3,label4,label5;
	Button OKButton;

	public AboutBox(Frame parent)
	{
		super(parent, "Informazioni sul Programma", true);
		setResizable(false);
		setLayout(null);
		setSize(330,180);
		setBackground(Color.lightGray);

		label1 = new Label("Percorso Rettificato Belga Multimediale",Label.CENTER);
		label1.setBounds(6,25,318,13);
		add(label1);
		label2 = new Label("versione "+VERSION,Label.CENTER);
		label2.setBounds(6,44,318,13);
		add(label2);
		label3 = new Label("realizzato da Paolo Casarini, Copyright (C) 1998-2003",Label.CENTER);
		label3.setBounds(6,70,318,13);
		add(label3);
		label4 = new Label("Andrea Baitelli: documento di specifica",Label.CENTER);
		label4.setBounds(6,90,318,13);
		add(label4);
		label5 = new Label("Filippo Tonellotto: icone",Label.CENTER);
		label5.setBounds(6,110,318,13);
		add(label5);
		OKButton = new Button("Grazie");
		OKButton.setBounds(132,145,66,26);
		add(OKButton);

		OKButton.setActionCommand("OK");
		OKButton.addActionListener(this);

		Rectangle bounds = getParent().getBounds();
		Rectangle abounds = getBounds();
		setLocation(bounds.x + (bounds.width - abounds.width)/ 2,bounds.y + (bounds.height - abounds.height)/2);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		setVisible(false);
		dispose();
	}
}