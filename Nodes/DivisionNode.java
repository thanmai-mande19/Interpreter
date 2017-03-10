package Nodes;

import Util.Errors;
import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description: Division Node
 * Filename:  DivisionNode.java
 */
public class DivisionNode extends BinaryOperatorNode  {


    /**
     * Constructor that sets the left/right children and sets the operator to the string // The precedence is set to MULT_DIVIDE
     * @param left the MerpNode representing the left child
     * @param right the MerpNode representing the right child
     */
    public DivisionNode(MerpNode left,MerpNode right){
        super(left,right,Precedence.MULT_DIVIDE,"//");
    }


    /**
     * Evaluates the node to determine its integer value Errors if the right child evaluates to zero
     * @param symbolTable the symbol table to use for variable processing
     * @return integer value of node
     */
    public int evaluate(SymbolTable symbolTable){
        int result=this.rightChild.evaluate(symbolTable);
        if (result==0){
             Errors.error("The right child is zero",0);
        }

        return this.leftChild.evaluate(symbolTable)/this.rightChild.evaluate(symbolTable);
    }
}
