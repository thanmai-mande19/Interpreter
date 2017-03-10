package Processors;

import Nodes.*;
import Util.SymbolTable;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Venkata Thanmai Mande
 * Description: Class to process Merp expressions using infix notation
 *  Filename:  MerpInfixProcessor.java
 */
public class MerpInfixProcessor extends MerpProcessor {

    /**
     * Constructs and assigns a Merp tree from the provided list of MerpNode tokens using infix notation
     * @param tokens list of IerpNodes used to create the pares tree
     */
    @Override
    public void constructTree(ArrayList<String> tokens) {
        ArrayList<String> queue=new ArrayList<>();
        Stack<MerpNode> stack=new Stack<>();
        ArrayList<MerpNode> helper=new ArrayList<>();
        for (String s:tokens){
            if (isNumeric(s)){
                queue.add(s);
            }
            else if (isVariable(s)){
                queue.add(s);
            }
            else{
                if (stack.isEmpty()){
                    stack.add(createMerpNode(s));
                }
                else{
                    MerpNode ele=createMerpNode(s);
                    int i=0;
                    while(i==0){

                          if (s.equals("(")) {
                              stack.add(null);
                              break;
                          }

                          else if (s.equals(")")){
                              MerpNode higher=stack.pop();
                              while (higher!=null){

                                  if (higher instanceof BinaryOperatorNode){
                                      BinaryOperatorNode higer1=(BinaryOperatorNode) higher;
                                      queue.add(higer1.getOperator());
                                  }
                                  else if(higher instanceof UnaryOperatorNode){
                                      UnaryOperatorNode higher2=(UnaryOperatorNode) higher;
                                      queue.add(higher2.getOperator());
                                      break;
                                  }
                                  higher=stack.pop();

                              }
                              break;
                          }
                            MerpNode top = stack.pop();
                          if (top==null){
                              stack.push(top);
                              stack.push(ele);
                              break;
                          }
                          String topop="a";
                          String eleop="b";
                          if (top instanceof BinaryOperatorNode){
                              BinaryOperatorNode dummy=(BinaryOperatorNode) top;
                               topop=dummy.getOperator();
                          }
                          if (ele instanceof BinaryOperatorNode){
                              BinaryOperatorNode dummy1=(BinaryOperatorNode) ele;
                               eleop=dummy1.getOperator();
                          }
                            if (ele.getPrecedence() < top.getPrecedence() || eleop.equals(topop)  ) {
                                stack.push(top);
                                stack.push(ele);
                                i = 1;

                            }


                        else if(top.getPrecedence()<=ele.getPrecedence() && ele!=null){


                            if (top instanceof BinaryOperatorNode){
                                BinaryOperatorNode higer1=(BinaryOperatorNode) top;
                                queue.add(higer1.getOperator());
                            }
                            else if(top instanceof UnaryOperatorNode){
                                UnaryOperatorNode higher2=(UnaryOperatorNode) top;
                                queue.add(higher2.getOperator());
                            }

                            int j=0;
                            while(j==0) {
                                if (stack.isEmpty()) {
                                    stack.add(ele);
                                    break;

                                } else if (stack.peek().getPrecedence() < ele.getPrecedence() && ele != null) {
                                    helper.add(stack.pop());
                                } else if (ele.getPrecedence() < stack.peek().getPrecedence() && ele != null) {
                                    stack.add(ele);
                                    j = 1;
                                }
                            }


                            for (MerpNode m:helper){
                                stack.push(m);
                            }
                            break;


                        }
                    }


                }
            }
        }
        while (!stack.isEmpty()){
            MerpNode higher=stack.pop();
            if (higher instanceof BinaryOperatorNode){
                BinaryOperatorNode higer1=(BinaryOperatorNode) higher;
                queue.add(higer1.getOperator());
            }
            else if(higher instanceof UnaryOperatorNode){
                UnaryOperatorNode higher2=(UnaryOperatorNode) higher;
                queue.add(higher2.getOperator());
            }

        }


        Stack<MerpNode> sendingstack=new Stack<>();
        for (String t:queue){
            sendingstack.add(createMerpNode(t));
        }
        processStack(sendingstack);




    }

    /**
     * Processes an stack of IerpNodes to create a Ierp Parse Tree
     * @param stack Processes an stack of IerpNodes to create a Ierp Parse Tree
     * @return the root of the parse tree
     */

    private MerpNode processStack(java.util.Stack<MerpNode> stack){

        ArrayList<String> infix=new ArrayList<>();
        for (MerpNode mn:stack){
            if (mn instanceof ConstantNode){
                ConstantNode mn1=(ConstantNode) mn;
                infix.add(mn1.toInfixString());
            }
            else if(mn instanceof VariableNode){
                VariableNode mn1=(VariableNode) mn;
                infix.add(mn1.toInfixString());
            }
            else if(mn instanceof BinaryOperatorNode){
                BinaryOperatorNode mn1=(BinaryOperatorNode)mn;
                infix.add(mn1.getOperator());
            }
            else if(mn instanceof UnaryOperatorNode){
                UnaryOperatorNode mn1=(UnaryOperatorNode) mn;
                infix.add(mn1.getOperator());
            }

        }

        MerpPostfixProcessor post=new MerpPostfixProcessor();
        post.constructTree(infix);
        this.tree=post.getTree();


        return tree;
    }



}
