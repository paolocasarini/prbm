package org.casarini.prbm.gui.dialog;

import java.awt.*;
import java.awt.event.*;

import org.casarini.prbm.gui.PRB;

public class OpenPRBOptionPane extends Dialog implements ActionListener {
    /**
     * Frame principale rispetto a cui essere modale
     */
    PRB parent;

    /**
     * Risultato della dialog
     */
    private int result = PRB.IDCANCEL;

    public OpenPRBOptionPane(PRB parent) {
        super((Frame) parent, PRB.MENU_PRB_OPEN, true);
        setResizable(false);
        setBackground(Color.lightGray);

        this.parent = parent;

        //{{INIT_CONTROLS
        setLayout(null);
        addNotify();
        setSize(getInsets().left + getInsets().right + 379, getInsets().top
                + getInsets().bottom + 102);
        Button OKButton = new Button("OK");
        add(OKButton);
        OKButton.setBounds(getInsets().left + 68, getInsets().top + 65, 91, 26);
        Button NOButton = new Button("NO");
        add(NOButton);
        NOButton
                .setBounds(getInsets().left + 215, getInsets().top + 65, 91, 26);
        Label label1 = new Label(
                "Aprendo un nuovo documento PRB, si perderanno le modifiche");
        add(label1);
        label1.setBounds(getInsets().left + 7, getInsets().top + 13, 357, 13);
        Label label2 = new Label(
                "non salvate del documento corrente. Vuoi continuare?");
        add(label2);
        label2.setBounds(getInsets().left + 7, getInsets().top + 33, 357, 13);
        //}}
        OKButton.addActionListener(this);
        NOButton.addActionListener(this);
    }

    public void setVisible(boolean visible) {
        if (visible) {
            Rectangle bounds = getParent().getBounds();
            Rectangle abounds = getBounds();
    
            setLocation(bounds.x + (bounds.width - abounds.width) / 2, bounds.y
                    + (bounds.height - abounds.height) / 2);
        }
        super.setVisible(visible);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equalsIgnoreCase("Ok"))
            result = PRB.IDOK;
        else if (cmd.equalsIgnoreCase("No"))
            result = PRB.IDCANCEL;
        setVisible(false);
    }

    /**
     * Restituisce il risultato della dialog.
     * 
     * @return <tt>PRB.IDOK</tt> se e' stato premuto il bottone per la
     *         risposta affermativa; <tt>IDCANCEL</tt> altrimenti.
     */
    public int getResult() {
        return result;
    }
}