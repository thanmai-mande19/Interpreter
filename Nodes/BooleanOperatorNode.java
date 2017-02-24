package Nodes;

/**
 * Created by shrikanth on 24-02-2017.
 */
public class BooleanOperatorNode extends BinaryOperatorNode {

    public BooleanOperatorNode(MerpNode left,MerpNode right,java.lang.String operator){
        super(left,right,Precedence.BOOLEAN,operator);
    }

    public int getPrecedence(){
        return Precedence.BOOLEAN.getPrecedence();
    }
}
