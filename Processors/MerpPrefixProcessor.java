package Processors;

import Nodes.*;
import Util.SymbolTable;

import java.util.ArrayList;

/**
 * @author Venkata Thanmai Mande
 * Description: Class to process Merp expressions using postfix notation
 * Filename:  MerpPostfixProcessor.java
 */
public class MerpPrefixProcessor extends MerpProcessor {

    public MerpPrefixProcessor(){

    }

    /**
     * Constructs and assigns a Merp tree from the provided list of MerpNode tokens using postfix notation
     * @param tokens list of IerpNodes used to create the pares tree
     */
    @Override
    public void constructTree(ArrayList<String> tokens) {

        this.tree=constructTreeHelper(tokens);
        if (tree!=null){
            int x=1;
            int y=3;
        }

    }


    /**
     * Helper to recursively contstruct the parse tree
     * @param tokens list of IerpNodes to process
     * @return root of the node
     */

    private MerpNode constructTreeHelper(java.util.ArrayList<java.lang.String> tokens){
        if (tokens.isEmpty()){
            return null;
        }
        else {
            String first=tokens.remove(0);
            if (isNumeric(first)){

                return new ConstantNode(Integer.parseInt(first));
            }

            else if(isVariable(first)){

                return new VariableNode(first);

            }

            else{
                if (first.equals("_")){

                    return new NegationNode(constructTreeHelper(tokens));
                }
                else if (first.equals("@")){

                    return new SquareRootNode(constructTreeHelper(tokens));
                }

                else if (first.equals("|")){

                    return new AbsValueNode(constructTreeHelper(tokens));
                }




                else if (first.equals("+")){



                    return new AdditionNode(constructTreeHelper(tokens),constructTreeHelper(tokens));
                }
                else if (first.equals("-")){

                    return new SubtractionNode(constructTreeHelper(tokens),constructTreeHelper(tokens));
                }
                else if(first.equals("*")){

                    return  new MultiplicationNode(constructTreeHelper(tokens),constructTreeHelper(tokens));
                }
                else if (first.equals("//")){

                    return new DivisionNode(constructTreeHelper(tokens),constructTreeHelper(tokens));
                }
                else if (first.equals("^")){

                    return new PowerNode(constructTreeHelper(tokens),constructTreeHelper(tokens));
                }
                else if (first.equals(">=")){

                    return new GreaterThanEqualNode(constructTreeHelper(tokens),constructTreeHelper(tokens));
                }
                else if (first.equals(">")){

                    return new GreaterThanNode(constructTreeHelper(tokens),constructTreeHelper(tokens));
                }
                else if (first.equals("<")){

                    return new LessThanNode(constructTreeHelper(tokens),constructTreeHelper(tokens));
                }
                else if (first.equals("<=")){

                    return new LessThanEqualNode(constructTreeHelper(tokens),constructTreeHelper(tokens));
                }
                else if (first.equals("==")){
                    return new EqualityNode(constructTreeHelper(tokens),constructTreeHelper(tokens));
                }
                else if (first.equals("!=")){

                    return new NotEqualityNode(constructTreeHelper(tokens),constructTreeHelper(tokens));
                }


            }

        }
        return tree;


    }


}
