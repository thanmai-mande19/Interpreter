package Processors;

import Nodes.*;
import Util.SymbolTable;

import java.util.ArrayList;

/**
 * Created by shrikanth on 27-02-2017.
 */
public class MerpPrefixProcessor extends MerpProcessor {

    public MerpPrefixProcessor(){

    }

    @Override
    public void constructTree(ArrayList<String> tokens) {

        this.tree=constructTreeHelper(tokens);
        if (tree!=null){
            int x=1;
            int y=3;
        }



    }

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

    public static void main(String[] args){
        ArrayList<String> x=new ArrayList<>();
        x.add("*");
        x.add("1");
        x.add("+");
        x.add("2");
        x.add("//");
        x.add("4");
        x.add("2");
        MerpPrefixProcessor p1=new MerpPrefixProcessor();
        System.out.println(x);
        p1.constructTree(x);
        SymbolTable s1=new SymbolTable();
        MerpNode t=p1.getTree();
        String y=t.toPrefixString();
        System.out.println(y);
        int v=t.evaluate(s1);
        System.out.println(v);
    }
}
