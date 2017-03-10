package Nodes;

import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description: Abstract class to represent a unary operator Unary operators only have a single child
 * Filename:  UnaryOperatorNode.java
 */
public abstract class UnaryOperatorNode implements MerpNode {
    protected MerpNode child;
    protected java.lang.String operator;
    protected Precedence precedence;


    /**
     * Constructor of the class
     * @param child left child of the node
     * @param precedence right child of the node
     * @param operator string value of operator
     */
    public UnaryOperatorNode(MerpNode child,
                             Precedence precedence,
                             java.lang.String operator){

    this.child=child;
    this.precedence=precedence;
    this.operator=operator;
    }


    /**
     * Sets the child of this node
     * @param child the MerpNode representing the child
     */
    public void setChild(MerpNode child){
        this.child=child;
    }


    /**
     * evaluate the node
     * @param symbolTable the symbol table to use for variable processing
     * @return 0
     */
    @Override
    public int evaluate(SymbolTable symbolTable) {
        return 0;
    }

    /**
     * Displays this node as prefix notation expression string
     * @return string representing the node as prefix notation
     */
    @Override
    public String toPrefixString() {
        return(operator+" "+child.toPrefixString());
    }

    /**
     *Displays this node as infix notation expression string
     * @return string representing the node as infix notation
     */
    @Override
    public String toInfixString() {
        return("("+operator+" "+child.toInfixString()+")");
    }

    /**
     * Displays this node as postfix notation expression string
     * @return  string representing the node as postfix notation
     */
    @Override
    public String toPostfixString() {
        return(child.toPostfixString()+" "+ operator);
    }

    /**
     * Returns the precedence of this node
     * @return Returns the precedence of this node as an int value
     */
    @Override
    public int getPrecedence() {
        if (operator.equals("_")){
            return Precedence.MULT_DIVIDE.getPrecedence();
        }
        else if(operator.equals("@")){
            return Precedence.POWER.getPrecedence();
        }

        return Precedence.MULT_DIVIDE.getPrecedence();

    }


    /**
     * determines if the node is an operation node
     * @return true if an operation node, false otherwise
     */
    @Override
    public boolean isOperation() {
        return true;
    }


    /**
     * the operator of the node
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
        return NodeType.UnaryOperation;
    }
}
