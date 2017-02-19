package Nodes;

import Nodes.Precedence;
import Util.SymbolTable;

/**
 * Created by shrikanth on 14-02-2017.
 */
public class ConstantNode implements MerpNode {

    private int value;

    public ConstantNode(int value){
        this.value=value;
    }


    @Override
    public int evaluate(SymbolTable symbolTable) {
            return value;
    }

    @Override
    public String toPrefixString() {
        return String.valueOf(value);
    }

    @Override
    public String toInfixString() {
        return String.valueOf(value);
    }

    @Override
    public String toPostfixString() {
        return String.valueOf(value);
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
        return NodeType.Constant;

    }
}
