package Nodes;

import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description: Variable MerpNode
 * FileName: VariableNode.java
 */
public class VariableNode implements MerpNode {
    private java.lang.String name;


    /**
     * Constructor
     * @param name variable name
     */
    public VariableNode(java.lang.String name){
        this.name=name;
    }


    /**
     * Evaluates the node to determine its integer value
     * @param symbolTable the symbol table to use for variable processing
     * @return the integer value of this node
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        int val=symbolTable.get(name);
        return val;
    }


    /**
     * Displays this node as prefix notation expression string
     * @return string representing the node as prefix notation
     */
    @Override
    public String toPrefixString() {
        return name;
    }


    /**
     * Displays this node as infix notation expression string
     * @return string representing the node as infix notation
     */
    @Override
    public String toInfixString() {
        return name;
    }

    /**
     * Displays this node as postfix notation expression string
     * @return string representing the node as postfix notation
     */
    @Override
    public String toPostfixString() {
        return name;
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
     * Determines the node type
     * @return type of node
     */
    @Override
    public NodeType getNodeType() {
        return NodeType.Variable;
    }




}
