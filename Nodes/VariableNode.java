package Nodes;

import Util.SymbolTable;

/**
 * Created by shrikanth on 14-02-2017.
 */
public class VariableNode implements MerpNode {
    private java.lang.String name;


    public VariableNode(java.lang.String name){
        this.name=name;
    }


    @Override
    public int evaluate(SymbolTable symbolTable) {
        int val=symbolTable.get(name);
        return val;
    }


    @Override
    public String toPrefixString() {
        return name;
    }

    @Override
    public String toInfixString() {
        return name;
    }

    @Override
    public String toPostfixString() {
        return name;
    }

    @Override
    public int getPrecedence() {

        return Precedence.CONSTANT.getPrecedence();
    }

    @Override
    public boolean isOperation() {
        return false;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.Variable;
    }




}
