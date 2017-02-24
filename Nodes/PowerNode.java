package Nodes;

import Util.SymbolTable;

/**
 * Created by shrikanth on 23-02-2017.
 */
public class PowerNode extends BinaryOperatorNode {

    public PowerNode(MerpNode left,MerpNode right){
        super(left,right,Precedence.POWER,"^");
    }

    public int evaluate(SymbolTable symbolTable){
        return (int) Math.pow(this.leftChild.evaluate(symbolTable),this.rightChild.evaluate(symbolTable));
    }
}
