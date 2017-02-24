package Nodes;

import Util.Errors;
import Util.SymbolTable;

/**
 * Created by shrikanth on 23-02-2017.
 */
public class DivisionNode extends BinaryOperatorNode  {

    public DivisionNode(MerpNode left,MerpNode right){
        super(left,right,Precedence.MULT_DIVIDE,"//");
    }

    public int evaluate(SymbolTable symbolTable){
        int result=this.rightChild.evaluate(symbolTable);
        if (result==0){
             Errors.error("The right child is zero",0);
        }
        return this.leftChild.evaluate(symbolTable)/this.rightChild.evaluate(symbolTable);
    }
}
