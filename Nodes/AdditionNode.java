package Nodes;

import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description: Addition MerpNode
 * Filename: AdditionNode.java
 */
public class AdditionNode extends BinaryOperatorNode {

    /**
     * Constructor of the class
     * @param left- the MerpNode representing the left child
     * @param right- the MerpNode representing the right child
     */
    public AdditionNode(MerpNode left,MerpNode right){
        super(left,right,Precedence.ADD_SUBTRACT,"+");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable-the symbol table to use for variable processing
     * @return integer value of the
     */

    public int evaluate(SymbolTable symbolTable){
        return this.leftChild.evaluate(symbolTable)+this.rightChild.evaluate(symbolTable);
    }
}
