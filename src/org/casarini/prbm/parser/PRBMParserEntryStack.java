package org.casarini.prbm.parser;
public class PRBMParserEntryStack
{
    private String arg;
    private PRBMParserNode node;
    private long startOffset;
    private int counter;

    public PRBMParserEntryStack(String arg, PRBMParserNode node, long startOffset, int counter)
    {
        this.arg=arg;
        this.node=node;
        this.startOffset=startOffset;
        this.counter=counter;
    }

    public String getArg() {
        return arg;
    }

    public PRBMParserNode getNode() {
        return node;
    }

    public long getStartOffset() {
        return startOffset;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter=counter;
    }
};