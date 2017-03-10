package Nodes;

import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description: Multiplication Node
 * Filename: MultiplicationNode.java
 */
public class MultiplicationNode extends BinaryOperatorNode {

    /**
     * Constructor that sets the left/right children and sets the operator to the string * The precedence is set to MULT_DIVIDE
     * @param left- left child
     * @param right-right child
     */
    public MultiplicationNode(MerpNode left,
                              MerpNode right){
        super(left,right,Precedence.MULT_DIVIDE,"*");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return integer value of the node
     */
    public int evaluate(SymbolTable symbolTable){
        return this.leftChild.evaluate(symbolTable)*this.rightChild.evaluate(symbolTable);

    }
}
