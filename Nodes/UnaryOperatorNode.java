package Nodes;

import Util.SymbolTable;

/**
 * Created by shrikanth on 14-02-2017.
 */
public abstract class UnaryOperatorNode implements MerpNode {
    protected MerpNode child;
    protected java.lang.String operator;
    protected Precedence precedence;


    public UnaryOperatorNode(MerpNode child,
                             Precedence precedence,
                             java.lang.String operator){

    this.child=child;
    this.precedence=precedence;
    this.operator=operator;
    }


    public void setChild(MerpNode child){
        this.child=child;
    }






    @Override
    public int evaluate(SymbolTable symbolTable) {
        return 0;
    }

    @Override
    public String toPrefixString() {
        return(operator+" "+child.toPrefixString());
    }

    @Override
    public String toInfixString() {
        return("("+operator+" "+child.toInfixString()+")");
    }

    @Override
    public String toPostfixString() {
        return(child.toPostfixString()+" "+ operator);
    }

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

    @Override
    public boolean isOperation() {
        return true;
    }

    public String getOperator(){
        return this.operator;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.UnaryOperation;
    }
}
