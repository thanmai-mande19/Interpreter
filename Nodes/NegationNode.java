package Nodes;

import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description: Negation MerpNode
 * Filename:  NegationNode.java
 */
public class NegationNode extends UnaryOperatorNode {

    /**
     * Constructor that sets the left child and sets the operator to the string _ The precedence is set to MULT_DIVIDE
     * @param child MerpNode that is the child of this node
     */
    public NegationNode(MerpNode child){
        super(child,Precedence.MULT_DIVIDE,"_");

    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return integer value of the node
     */
    public int evaluate(SymbolTable symbolTable){
        return (0-this.child.evaluate(symbolTable));
    }
}
