package org.casarini.prbm.parser;
import java.util.Vector;

public class PRBMParserNode 
{
    private char cmd;
    private String arg;
    private String value;
    private int level;
    private Vector nodes;

    public PRBMParserNode(char cmd, String arg, String value, int level, Vector nodes) {
        this.cmd=cmd;
        this.arg=arg;
        this.value=value;
        this.level=level;
        this.nodes=nodes;
    }

    public char getCmd() {
        return cmd;
    }

    public String getArg() {
        return arg;
    }

    public String getValue() {
        return value;
    }

    public int getLevel() {
        return level;
    }

    public Vector getNodes() {
        return nodes;
    }
};
