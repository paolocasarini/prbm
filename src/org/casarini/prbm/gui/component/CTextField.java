package org.casarini.prbm.gui.component;
import java.awt.*;
import java.awt.event.*;  

public class CTextField extends TextField
{
    public static final int CTF_ALL=0;
    public static final int CTF_NUM=1;
    public static final int CTF_INT=2;
	public static final int CTF_FLOAT=3;
    int ctype;
    int len;
    
    public CTextField(String s,int n,int type,int len)
    {
        super(s,n);
        this.ctype=type;
        this.len=len;
    }
    public CTextField(String s,int type,int len)
    {
        super(s);
        this.ctype=type;
        this.len=len;
    }
    public CTextField(int n,int type,int len)
    {
        super(n);
        this.ctype=type;
        this.len=len;
    }
    public CTextField(int type,int len)
    {
        super();
        this.ctype=type;
        this.len=len;
    }
    
    protected void processKeyEvent(KeyEvent e)
    {
        int type=Character.getType(e.getKeyChar());
		char value=e.getKeyChar();
        if(getText().length()>=len&&type!=Character.CONTROL)
            e.consume();
        else
            switch(ctype)
            {
                case CTF_ALL:
                    super.processKeyEvent(e);
                    break;
                case CTF_NUM:
                    if(type==Character.DECIMAL_DIGIT_NUMBER ||
                       type==Character.CONTROL)
                        super.processKeyEvent(e);
                    else
                        e.consume();
                    break;
                case CTF_INT:
                    if(type==Character.DECIMAL_DIGIT_NUMBER ||
                       type==Character.CONTROL||
					   value=='-' || value=='+')
						if((value=='-' || value=='+') && getText().length()!=0)
							e.consume();
						else
							super.processKeyEvent(e);
                    else
                        e.consume();
                    break;
                case CTF_FLOAT:
                    if(type==Character.DECIMAL_DIGIT_NUMBER ||
                       type==Character.CONTROL ||
					   value=='.')
						if(value=='.' && (getText().length()==0 || getText().length()==len-1 || getText().indexOf('.')!=-1))
							e.consume();
						else
							super.processKeyEvent(e);
                    else
                        e.consume();
                    break;
                default:
                    super.processKeyEvent(e);
            }
    }    
}