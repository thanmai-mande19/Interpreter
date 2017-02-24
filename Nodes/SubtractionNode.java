package Nodes;

import Util.SymbolTable;

/**
 * Created by shrikanth on 23-02-2017.
 */
public class SubtractionNode extends BinaryOperatorNode {

    public SubtractionNode(MerpNode left,MerpNode right){
        super(left,right,Precedence.ADD_SUBTRACT,"-");
    }

    public int evaluate(SymbolTable symbolTable){
        return this.leftChild.evaluate(symbolTable)-this.rightChild.evaluate(symbolTable);
    }
}
