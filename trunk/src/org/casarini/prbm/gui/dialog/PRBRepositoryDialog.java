package org.casarini.prbm.gui.dialog;

import java.awt.*;
import java.awt.event.*;

import org.casarini.prbm.gui.PRB;
import org.casarini.prbm.gui.component.PRBRepository;
import org.casarini.prbm.gui.component.Tabella;

public class PRBRepositoryDialog extends Dialog implements WindowListener,
        ActionListener {
    public PRB parent;

    public ScrollPane c_scrollpane;

    public PRBRepository c_repository;

    public Tabella tab;

    MenuItem me_delAll;

    public PRBRepositoryDialog(PRB parent, Tabella tab) {
        super((Frame) parent, (parent.getRepositoryPath() == null) ? "Raccoglitore" : parent.getRepositoryPath(), false);
        this.parent = parent;
        this.tab = tab;

        setSize(170, 300);
        Rectangle bounds = getParent().getBounds();
        setLocation(bounds.x + bounds.width + 50, bounds.y + 50);

        c_scrollpane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
        c_repository = new PRBRepository(this, 140);
        c_scrollpane.add(c_repository);
        this.add(c_scrollpane, "Center");

        this.addWindowListener(this);
    }
    
    /**
     * Imposta il titolo di questo dialog dato il path del repository caricato.
     * @param repositoryPath il path completo del repository caricato.
     */
    public void setTitle(String repositoryPath) {
        super.setTitle(repositoryPath.substring(repositoryPath.lastIndexOf("\\")+1));        
    }
    
    // START implementazione WindowListener
    public void windowClosing(WindowEvent e) {
        setVisible(false);
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    // STOP implementazione WindowListener3

    //START implementazione ActionListener
    public void actionPerformed(ActionEvent e) {
    }
    //STOP implementazione ActionListener

}