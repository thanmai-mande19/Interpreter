package Processors;

import Nodes.MerpNode;
import Util.SymbolTable;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by shrikanth on 27-02-2017.
 */
public class EquationProcessor {

    MerpProcessor processor;
    SymbolTable symbolTable;
    java.util.ArrayList<java.lang.String> equations;




    public EquationProcessor(java.util.ArrayList<java.lang.String> equations,
                             MerpProcessor processor){
        this.processor=processor;
        this.equations=equations;
        symbolTable=new SymbolTable();

    }

    public void processEquations(){
        for (String eq:equations){
            processEquation(eq);
        }

    }

    private void processEquation(java.lang.String eq) {
        String trimmer = eq.trim();
        String[] fields = trimmer.split(" ");
        if (trimmer.startsWith("printV")) {
            symbolTable.dump();
        }
        else if (trimmer.startsWith("print")) {
            ArrayList<String> tokens = new ArrayList<>();
            String sub=trimmer.substring(6,trimmer.length()-1);
            String trimmer1=sub.trim();
            String[] fields1=trimmer1.split(" ");


            for (int i = 0; i < fields1.length ; i++) {
                tokens.add(fields1[i]);

            }
            processor.constructTree(tokens);
            int ans = processor.evaluateTree(symbolTable);
            System.out.println(ans);
        }

        else if (processor.isVariable(fields[0]) && fields[1].equals("=")) {
            ArrayList<String> tokens = new ArrayList<>();
            for (int i = 2; i < fields.length; i++) {
                tokens.add(fields[i]);

            }
            processor.constructTree(tokens);
            int ans = processor.evaluateTree(symbolTable);
            symbolTable.put(fields[0], ans);

        }

        else if (eq.startsWith("if")) {
            ArrayList<String> tokens = new ArrayList<>();

            String sub=trimmer.substring(3,trimmer.length()-1);
            String trimmer2=sub.trim();
            String[] fields2=trimmer2.split(",");
            String[] condition=fields2[0].split(" ");

            for (String i:condition){
                tokens.add(i);
            }
            processor.constructTree(tokens);
            int ans=processor.evaluateTree(symbolTable);
            if (ans==1){
                processEquation(fields2[1]);

            }
            else{
                processEquation(fields2[2]);
            }




        }
        else{
            ArrayList<String> tokens = new ArrayList<>();
            for (String i:fields){
                tokens.add(i);
            }
            processor.constructTree(tokens);
            int ans=processor.evaluateTree(symbolTable);
            System.out.println(ans);
        }
    }


    public static void main(String[] args){
        MerpProcessor a=new MerpPrefixProcessor();
        ArrayList<String> c=new ArrayList<>();
        c.add("print( > 5 2 )");
        EquationProcessor b=new EquationProcessor(c,a);
        b.processEquations();
    }
}
