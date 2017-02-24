package Nodes;

import Util.Errors;
import Util.SymbolTable;

/**
 * Created by shrikanth on 23-02-2017.
 */
public class SquareRootNode extends UnaryOperatorNode {

    public SquareRootNode(MerpNode child){
        super(child,Precedence.POWER,"@");
    }

    public int evaluate(SymbolTable symbolTable){
        int result=this.child.evaluate(symbolTable);
        if (result<0){
            Errors.error("The number is less than one",result);
        }
        double x=Math.sqrt(result);
        int y=(int) x ;
        return y;
    }
}
