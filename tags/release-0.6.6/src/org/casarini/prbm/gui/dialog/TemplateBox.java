package org.casarini.prbm.gui.dialog;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class TemplateBox extends Dialog implements ActionListener
{
    private Frame parent;
    private Button yesButton;
    private Button noButton;
    private Choice template;
    private String result;

    public TemplateBox(Frame parent)
    {
	    super(parent, "Scelta del template...", true);
	    setResizable(false);

        this.parent=parent;
        result=new String("");

    	setLayout(null);
    	addNotify();
    	setSize(350,135);
        Label label = new Label("Scegli il template che vuoi utilizzare per l'esportazione:");
        add(label);
        label.setBounds(5,25,340,24);
        template = new Choice();
        add(template);
        template.setBounds(75,55,200,24);
        File homefile = new File("");
        String home=homefile.getAbsolutePath();
        home+="\\template";
		File[] list=(new File(home)).listFiles();
        for(int i=0;i<list.length;i++)
        	if(list[i].isDirectory())
        		template.addItem(list[i].getName());
        template.select(0);
        yesButton=new Button("Esporta");
    	add(yesButton);
    	yesButton.setBounds(100,90,60,24);
    	noButton=new Button("Annulla");
    	add(noButton);
    	noButton.setBounds(190,90,60,24);

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
        if(cmd.equalsIgnoreCase("Esporta"))
        {
       	    setVisible(false);
            result=template.getSelectedItem();
        }
        else if(cmd.equalsIgnoreCase("Annulla"))
        {
    	    setVisible(false);
    	}
    }

    public String getResult()
    {
        return result;
    }
}
