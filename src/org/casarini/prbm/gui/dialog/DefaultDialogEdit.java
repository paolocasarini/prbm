package org.casarini.prbm.gui.dialog;

import java.awt.Dialog;
import java.awt.Rectangle;

import org.casarini.prbm.gui.PRB;

public abstract class DefaultDialogEdit extends Dialog {
	
	DefaultDialogEdit(PRB parent, boolean modal) {
		super(parent, modal);
	}
	
    public void edit() {
		Rectangle bounds = getParent().getBounds();
		Rectangle abounds = getBounds();

		setLocation(bounds.x + (bounds.width - abounds.width)/ 2,
			 bounds.y + (bounds.height - abounds.height)/2);

		super.setVisible(true);
	}

}
