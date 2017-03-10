package Nodes;

import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Descripton: Node representing the equality boolean operator
 * Filename:  EqualityNode.java
 */
public class EqualityNode extends BooleanOperatorNode {


    /**
     * Constructor that sets the left/right children and sets the operator to the string ==
     * @param left  the MerpNode representing the left child
     * @param right the MerpNode representing the right child
     */
    public EqualityNode(MerpNode left,MerpNode right){
        super(left,right,"==");
    }


    /**
     * Evaluates the node to determine its integer value 1 for true, zero for false
     * @param symbolTable the symbol table to use for variable processing
     * @return 1 if true else 0.
     */
    public int evaluate(SymbolTable symbolTable){
        if (this.leftChild.evaluate(symbolTable)==this.rightChild.evaluate(symbolTable)){
            return 1;
        }
        return 0;
    }
}
