package Nodes;

import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description: Absolute Value MerpNode
 * Filename: AbsValueNode.java
 */

public class AbsValueNode extends UnaryOperatorNode {

    /**
     * Constructor for the child
     * @param child- MerpNode that is the child of this node
     */

    public AbsValueNode(MerpNode child){
        super(child,Precedence.MULT_DIVIDE,"|");
    }

    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable-the symbol table to use for variable processing
     * @return  value of the child
     */
    public int evaluate(SymbolTable symbolTable){
        int result=this.child.evaluate(symbolTable);
        if (result>=0){
            return result;
        }
        return Math.abs(result);

    }
}
