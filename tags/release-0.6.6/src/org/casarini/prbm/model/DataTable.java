package org.casarini.prbm.model;

import java.util.Vector;

import org.casarini.prbm.gui.component.Tabella;

public class DataTable implements java.io.Serializable
{
    public Vector data;

    public DataTable()
    {
        data=new Vector();
        Passo primo=new Passo();
        data.addElement((Object)primo);
    }
    
/*****************************************************************************/
/* metodi per la gestione delle risorse                                      */
/*****************************************************************************/


/*    public int getHeight()
    {
        return data.size();
    }*/
    //metodi per la gestione dei passi

    //ritorna il numero piu' componenti presenti in un passo
    public int getMaxHeight(int num)
    {
        Passo p=(Passo)data.elementAt(num);
        return p.getMaxHeight();
    }

    //ritorna il passo richiesto
    public Passo getPasso(int num)
    {
        return (Passo)data.elementAt(num);
    }
    //aggiunge una ricorsa ad una cella di un passo
    public Resource addResource(Tabella parent, int type, String file, int col, int num, int pos)
    {
        Passo p=(Passo)data.elementAt(num);
        return p.addResource(parent,type,file,col,pos);
    }
    public Resource addResource(Resource r, int col, int num, int pos)
    {
        Passo p=(Passo)data.elementAt(num);
        return p.addResource(r,col,pos);
    }
    //toglie una risorsa
    public Resource cutResource(int col, int num, int pos)
    {
        Passo p=(Passo)data.elementAt(num);
        return p.cutResource(col,pos);
    }
    //prende una risorsa
    public Resource getResource(int col, int num, int res)
    {
        Passo p=(Passo)data.elementAt(num);
        return (Resource)p.getResource(col,res);
    }
    //ritorna la dimensione di una cella
    public int getSizeCol(int col, int num)
    {
        Passo p=(Passo)data.elementAt(num);
        return p.getSizeCol(col);
    }

    //inserisce un passo
    public void addPasso(int azimut,int passi, int tempo, int pos)
    {
        Passo p=new Passo(azimut,passi,tempo);
        data.insertElementAt((Object)p,pos);
    }

    //taglia il passo indicato
    public Passo cutPasso(int pos)
    {
        Passo r=(Passo)data.elementAt(pos);
        r.delAllResource();
        data.removeElementAt(pos);
        return r;
    }
    //elimina tutte le risorse di un passo
    public void delAllResource(int pos)
    {
        Passo r=(Passo)data.elementAt(pos);
        r.delAllResource();
    }
}
