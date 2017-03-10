package Nodes;

import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description: Node representing the less than operator
 * Filename: LessThanNode.java
 */
public class LessThanNode extends BooleanOperatorNode {

    /**
     * Constructor that sets the left/right children and sets the operator to the string <
     * @param left  the MerpNode representing the left child
     * @param right  the MerpNode representing the right child
     */
    public LessThanNode(MerpNode left,MerpNode right){
        super(left,right,"<");
    }

    /**
     * Evaluates the node to determine its integer value 1 for true, zero for false
     * @param symbolTable the symbol table to use for variable processing
     * @return integer value of the node
     */
    public int evaluate(SymbolTable symbolTable){
        if (leftChild.evaluate(symbolTable)<rightChild.evaluate(symbolTable)){
            return 1;
        }
        return 0;
    }
}
