package Nodes;

import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description: Power Node
 * Filename: PowerNode.java
 */
public class PowerNode extends BinaryOperatorNode {

    /**
     * Constructor that sets the left/right children and sets the operator to the string ^ The precedence is set to POWER
     * @param left-the MerpNode representing the base
     * @param right-the MerpNode representing the power
     */
    public PowerNode(MerpNode left,MerpNode right){
        super(left,right,Precedence.POWER,"^");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    public int evaluate(SymbolTable symbolTable){
        int a=this.leftChild.evaluate(symbolTable);
        int b=this.rightChild.evaluate(symbolTable);
        double i=Math.pow(a,b);
        return (int) Math.pow(this.leftChild.evaluate(symbolTable),this.rightChild.evaluate(symbolTable));
    }
}
