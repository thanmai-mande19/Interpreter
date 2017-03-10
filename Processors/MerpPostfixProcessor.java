package Processors;

import Nodes.AdditionNode;
import Nodes.MerpNode;

import java.util.ArrayList;
import java.util.Stack;
import Nodes.UnaryOperatorNode;
import Nodes.BinaryOperatorNode;
import Util.SymbolTable;

/**
 * @author Venkata Thanmai Mande
 * Description: Class to process Merp expressions using postfix notation
 * Filename: MerpPostfixProcessor.java
 */
public class MerpPostfixProcessor extends MerpProcessor {
    /**
     * Constructs and assigns a Merp tree from the provided list of MerpNode tokens using postfix notation
     * @param tokens list of IerpNodes used to create the pares tree
     */
    @Override
    public void constructTree(ArrayList<String> tokens) {
        this.tree=constructTreeHelper(tokens);


    }

    /**
     * Helper to recursively contstruct the parse tree
     * @param tokens list of IerpNodes to process
     * @return root of the tree
     */
    private MerpNode constructTreeHelper(ArrayList<String> tokens) {

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


}


