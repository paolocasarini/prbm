package org.casarini.prbm.model;

public class PRBParam implements java.io.Serializable
{
    public String title;
    public String site;
    public boolean ext;
    public String data;
    public String modifica;
    public String autori;
    public String note;
    public String dir;

    public PRBParam()
    {
        this("","",false,"","","","","");
    }
    public PRBParam(String title,String site,boolean ext,String data,String modifica,String autori,String note,String dir)
    {
        this.title=title;
        this.site=site;
        this.ext=ext;
        this.data=data;
        this.modifica=modifica;
        this.autori=autori;
        this.note=note;
        this.dir=dir;
    }

    public void copyFrom(PRBParam param)
    {
        this.title=param.title;
        this.site=param.site;
        this.ext=param.ext;
        this.data=param.data;
        this.modifica=param.modifica;
        this.autori=param.autori;
        this.note=param.note;
        this.dir=param.dir;
    }
}