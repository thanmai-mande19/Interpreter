package Nodes;

import Util.SymbolTable;

/**
 * Created by shrikanth on 23-02-2017.
 */
public class MultiplicationNode extends BinaryOperatorNode {

    public MultiplicationNode(MerpNode left,
                              MerpNode right){
        super(left,right,Precedence.MULT_DIVIDE,"*");
    }

    public int evaluate(SymbolTable symbolTable){
        return this.leftChild.evaluate(symbolTable)*this.rightChild.evaluate(symbolTable);

    }
}
