package Nodes;

import Util.SymbolTable;

/**
 * Created by shrikanth on 23-02-2017.
 */
public class NegationNode extends UnaryOperatorNode {

    public NegationNode(MerpNode child){
        super(child,Precedence.MULT_DIVIDE,"_");

    }

    public int evaluate(SymbolTable symbolTable){
        return (0-this.child.evaluate(symbolTable));
    }
}
