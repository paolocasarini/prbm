package org.casarini.prbm.gui.dialog;
import java.awt.*;
import java.awt.event.*;

public class QuitBox extends Dialog implements ActionListener
{
    Frame parent;
    Button yesButton;
    Button noButton;

    public QuitBox(Frame parent)
    {
	    super(parent, "Bim Bum...", true);
	    setResizable(false);

        this.parent=parent;

    	setLayout(null);
    	addNotify();
    	setSize(257,96);
    	yesButton=new Button("Crack");
    	add(yesButton);
    	yesButton.setBounds(66,46,48,26);
    	noButton=new Button("OoPs");
    	add(noButton);
    	noButton.setBounds(132,46,48,26);

    	yesButton.addActionListener(this);
       	noButton.addActionListener(this);

    	Rectangle bounds = getParent().getBounds();
    	Rectangle abounds = getBounds();
    	setLocation(bounds.x + (bounds.width - abounds.width)/ 2,bounds.y + (bounds.height - abounds.height)/2);
    	setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String cmd=e.getActionCommand();
        if(cmd.equalsIgnoreCase("Crack"))
        {
       	    setVisible(false);
    	    dispose();
            parent.setVisible(false);
            parent.dispose();
            System.exit(0);
        }
        else if(cmd.equalsIgnoreCase("OoPs"))
        {
    	    setVisible(false);
    	    dispose();
    	}
    }
}
