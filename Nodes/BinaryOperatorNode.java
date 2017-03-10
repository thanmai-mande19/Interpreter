package Nodes;

import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description:Abstract class to represent a binary operator Has a left/right child, precedence, and operator
 * Filename: BinaryOperatorNode.java
 */
public class BinaryOperatorNode implements MerpNode {
    protected MerpNode leftChild;
    protected MerpNode rightChild;
    protected Precedence precedence;
    protected java.lang.String operator;


    /**
     * Binary Node Constructor
     * @param leftChild-MerpNode representing the left child
     * @param rightChild-MerpNode representing the right child
     * @param precedence- precedence of the operator
     * @param operator-String representing the operator
     */
    public BinaryOperatorNode(MerpNode leftChild,
                              MerpNode rightChild,
                              Precedence precedence,
                              java.lang.String operator){
        this.leftChild=leftChild;
        this.rightChild=rightChild;
        this.precedence=precedence;
        this.operator=operator;
    }


    /**
     * Setter for left child
     * @param leftChild-The MerpNode to be set at this node's left child
     */
    public void setLeftChild(MerpNode leftChild){
        this.leftChild=leftChild;
    }

    /**
     * setter for the right child
     * @param rightChild-The MerpNode to be set at this node's right child
     */
    public void setRightChild(MerpNode rightChild){
        this.rightChild=rightChild;
    }


    /**
     * Evaluate the node
     * @param symbolTable the symbol table to use for variable processing
     * @return zero
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return 0;
    }

    /**
     * Displays this node as prefix notation expression string
     * @return String representation in prefix form
     */
    @Override
    public String toPrefixString() {
        return (operator+" "+this.leftChild.toPrefixString()+" "+this.rightChild.toPrefixString());
    }


    /**
     * Displays this node as infix notation expression string
     * @return string representation in infix
     */
    @Override
    public String toInfixString() {
        return ("("+this.leftChild.toInfixString()+" "+ operator+" "+this.rightChild.toInfixString()+")");
    }

    /**
     * Displays this node as postfix notation expression string
     * @return string represetation in postfix
     */
    @Override
    public String toPostfixString() {
        return (this.leftChild.toPostfixString()+" "+this.rightChild.toPostfixString()+" "+operator);
    }


    /**
     *Returns the precedence of this node
     * @return precendence
     */
    @Override
    public int getPrecedence() {
        switch (operator){
            case "+": return (Precedence.ADD_SUBTRACT.getPrecedence());
            case "-":return (Precedence.ADD_SUBTRACT.getPrecedence());
            case "*":return (Precedence.MULT_DIVIDE.getPrecedence());
            case "//":return (Precedence.MULT_DIVIDE.getPrecedence());
            case "^":return (Precedence.POWER.getPrecedence());
            case ">":return (Precedence.BOOLEAN.getPrecedence());
            case">=":return (Precedence.BOOLEAN.getPrecedence());
            case "<":return (Precedence.BOOLEAN.getPrecedence());
            case "<=":return (Precedence.BOOLEAN.getPrecedence());
            case"==":return (Precedence.BOOLEAN.getPrecedence());
            case "!=":return (Precedence.BOOLEAN.getPrecedence());
        }
        return 0;
    }

    /**
     * determines if the node is an operation node

     * @return true if an operation node, false otherwise
     */
    @Override
    public boolean isOperation() {
        if (operator!=null){
            return true;
        }
        return false;
    }

    /**
     * Retruns operator
     * @return string value of operator
     */
    public String getOperator(){
        return this.operator;
    }


    /**
     * Determines the node type
     * @return type of node
     */
    @Override
    public NodeType getNodeType() {
        return NodeType.BinaryOperation;
    }
}
