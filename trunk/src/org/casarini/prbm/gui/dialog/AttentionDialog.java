package org.casarini.prbm.gui.dialog;
import java.awt.*;
import java.awt.event.*;

public class AttentionDialog extends Dialog implements ActionListener
{
	Label label1;
	Button okButton;

	public AttentionDialog(Frame parent, String title, String message)
	{
		super(parent, title, true);
		setBackground(Color.lightGray);
        Font font=new Font("Dialog", Font.BOLD, 12);
    	addNotify();
		label1 = new Label(message);
		Panel p1=new Panel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		p1.add(label1);
		add(p1,"Center");
		
		okButton = new Button("OK");
		okButton.setFont(font);
		okButton.addActionListener(this);
		Panel p=new Panel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		p.add(okButton);
		add(p,"South");
		this.pack();

		Rectangle bounds = getParent().bounds();
		Rectangle abounds = bounds();

		move(bounds.x + (bounds.width - abounds.width)/ 2,
			 bounds.y + (bounds.height - abounds.height)/2);

		super.setVisible(true);
	}

	public void display(){;}

    public void actionPerformed(ActionEvent e)
    {
            setVisible(false);
            dispose();
    }
}