package Nodes;

import Util.Errors;
import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description: Square Root MerpNode
 * Filename: SquareRootNode.java
 */
public class SquareRootNode extends UnaryOperatorNode {

    /**
     * Constructor that sets the left child and sets the operator to the string @ The precedence is set to POWER
     * @param child MerpNode that is the child of this node
     */
    public SquareRootNode(MerpNode child){
        super(child,Precedence.POWER,"@");
    }

    /**
     * Evaluates the node to determine its integer value Errors if the child evaluates to a negative number
     * @param symbolTable the symbol table to use for variable processing
     * @return integer value of node
     */
    public int evaluate(SymbolTable symbolTable){
        int result=this.child.evaluate(symbolTable);
        if (result<0){
            Errors.error("The number is less than one",result);
        }
        double x=Math.sqrt(result);
        int y=(int) x ;
        return y;
    }
}
