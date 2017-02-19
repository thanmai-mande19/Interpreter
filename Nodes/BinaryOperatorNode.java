package Nodes;

import Util.SymbolTable;

/**
 * Created by shrikanth on 19-02-2017.
 */
public class BinaryOperatorNode implements MerpNode {
    protected MerpNode leftChild;
    protected MerpNode rightChild;
    protected Precedence precedence;
    protected java.lang.String operator;


    public BinaryOperatorNode(MerpNode leftChild,
                              MerpNode rightChild,
                              Precedence precedence,
                              java.lang.String operator){
        this.leftChild=leftChild;
        this.rightChild=rightChild;
        this.precedence=precedence;
        this.operator=operator;
    }

    public void setLeftChild(MerpNode leftChild){
        this.leftChild=leftChild;
    }


    public void setRightChild(MerpNode rightChild){
        this.rightChild=rightChild;
    }

    @Override
    public int evaluate(SymbolTable symbolTable) {
        return 0;
    }

    @Override
    public String toPrefixString() {
        return (operator+"("+this.leftChild.toPrefixString()+")"+"("+this.rightChild.toPrefixString()+")");
    }

    @Override
    public String toInfixString() {
        return (this.leftChild.toInfixString()+"("+operator+")"+this.rightChild.toInfixString());
    }

    @Override
    public String toPostfixString() {
        return ("("+this.leftChild.toPostfixString()+")"+"("+this.rightChild.toPostfixString()+")"+operator);
    }

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

    @Override
    public boolean isOperation() {
        if (operator!=null){
            return true;
        }
        return false;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.BinaryOperation;
    }
}
