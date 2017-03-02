package Processors;

import Nodes.AdditionNode;
import Nodes.MerpNode;

import java.util.ArrayList;
import java.util.Stack;
import Nodes.UnaryOperatorNode;
import Nodes.BinaryOperatorNode;
import Util.SymbolTable;

/**
 * Created by shrikanth on 27-02-2017.
 */
public class MerpPostfixProcessor extends MerpProcessor {
    @Override
    public void constructTree(ArrayList<String> tokens) {
        this.tree=constructTreeHelper(tokens);


    }
    public MerpNode constructTreeHelper(ArrayList<String> tokens) {

        if (!tokens.isEmpty()) {
            String token = tokens.remove(tokens.size() - 1);

            if(isNumeric(token) || isVariable(token)) {
                return createMerpNode(token);
            }

            else if (token.equals("|") || token.equals("@") || token.equals("_")) {
                UnaryOperatorNode node = (UnaryOperatorNode)createMerpNode(token);
                node.setChild(constructTreeHelper(tokens));
                return node;
            }

            else if (token.equals("+") || token.equals("//") || token.equals("==") || token.equals(">=") || token.equals(">")
                    || token.equals("<=") || token.equals("<") || token.equals("*") || token.equals("!=") || token.equals("^")
                    || token.equals("-")) {
                BinaryOperatorNode node = (BinaryOperatorNode)createMerpNode(token);
                node.setRightChild(constructTreeHelper(tokens));
                node.setLeftChild(constructTreeHelper(tokens));
                return node;
            }
        }

        return null;

    }


    public static void main(String[] args){
        ArrayList<String> x=new ArrayList<>();
        x.add("3");
        x.add("2");
        x.add("*");
        x.add("1");
        x.add("+");
        //x.add("4");
        //x.add("2");
        MerpPostfixProcessor p1=new MerpPostfixProcessor();
        System.out.println(x);
        p1.constructTree(x);
        SymbolTable s1=new SymbolTable();
        MerpNode t=p1.getTree();
        String y=t.toPostfixString();
        System.out.println(y);
        int v=t.evaluate(s1);
        System.out.println(v);
    }

}


