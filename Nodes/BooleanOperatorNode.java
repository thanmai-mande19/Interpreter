package Nodes;

/**
 * @author Venkata Thanmai Mande
 * Description: Abstract class to represent a boolean operator Has a left/right child, precedence, and operator
 * FileName: BooleanOperatorNode.java
 */
public class BooleanOperatorNode extends BinaryOperatorNode {

    /**
     * Constructor for Boolean operation nodes The precedence is set to BOOLEAN
     * @param left- the left child for this operation
     * @param right- the right child for this operation
     * @param operator-the string representing the operation for this node
     */
    public BooleanOperatorNode(MerpNode left,MerpNode right,java.lang.String operator){
        super(left,right,Precedence.BOOLEAN,operator);
    }

    /**
     * Returns the precedence of this node
     * @return returns the precedence of BOOLEAN
     */

    public int getPrecedence(){
        return Precedence.BOOLEAN.getPrecedence();
    }
}
