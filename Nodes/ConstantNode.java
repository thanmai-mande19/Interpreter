package Nodes;

import Nodes.Precedence;
import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description: Constant MerpNode
 * Filename:  ConstantNode.java
 */
public class ConstantNode implements MerpNode {

    private int value;


    /**
     * Constructor that sets the value of this node
     * @param value integer value of this node
     */
    public ConstantNode(int value){
        this.value=value;
    }


    /**
     * Returns the value of this node
     * @param symbolTable the symbol table to use for variable processing
     * @return integer value of the node
     */

    /**
     * Returns the value of this node
     * @param symbolTable the symbol table to use for variable processing
     * @return value of node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
            return value;
    }


    /**
     * Returns the value of this node in prefix notation
     * @return string representation in prefix
     */
    @Override
    public String toPrefixString() {
        return String.valueOf(value);
    }


    /**
     * Returns the value of this node in infix notation
     * @return string representation in infix
     */
    @Override
    public String toInfixString() {
        return String.valueOf(value);
    }


    /**
     * Returns the value of this node in postfix notation
     * @return string representation in postfix
     */
    @Override
    public String toPostfixString() {
        return String.valueOf(value);
    }

    /**
     * Returns the precedence of this node
     * @return returns the precedence of CONSTANT
     */
    @Override
    public int getPrecedence() {
        return Precedence.CONSTANT.getPrecedence();
    }


    /**
     * determines if the node is an operation node
     * @return true if an operation node, false otherwise
     */
    @Override
    public boolean isOperation() {
        return false;
    }


    /**
     * return type of node
     * @return type of node
     */
    @Override
    public NodeType getNodeType() {
        return NodeType.Constant;

    }
}
