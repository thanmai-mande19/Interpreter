package Nodes;

import Util.SymbolTable;


/**
 * Interface for all MerpNodes
 */
public interface MerpNode {

    /**
     * Enum to represent Node types
     */
    public enum NodeType{
        BinaryOperation,
        UnaryOperation,
        Constant,
        Variable
    }

    /**
     * Evaluates the node
     * @param symbolTable the symbol table to use for variable processing
     * @return integer value of the node
     */
    public int evaluate(SymbolTable symbolTable);

    /**
     * Constructs prefix representation of the node
     * @return prefix representation of the node
     */
    public String toPrefixString();

    /**
     * Constructs infix representation of the node
     * @return prefix representation of the node
     */
    public String toInfixString();

    /**
     * Constructs postfix representation of the node
     * @return prefix representation of the node
     */
    public String toPostfixString();

    /**
     * gets the precedence of this node
     * @return integer value of the node's precedence
     */
    public int getPrecedence();

    /**
     * determines if the node is an operation node
     * @return - true if an operation node, false otherwise
     */
    public boolean isOperation();

    /**
     * Determines the node type
     * @return the type of this node
     */
    public NodeType getNodeType();
}
