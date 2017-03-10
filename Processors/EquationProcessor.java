package Processors;


import Util.SymbolTable;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Venkata Thanmai Mande
 * Description:Class to process Merp Programming Language Statements
 * Filename:  EquationProcessor.java
 */
public class EquationProcessor {

    MerpProcessor processor;
    SymbolTable symbolTable;
    java.util.ArrayList<java.lang.String> equations;


    /**
     * Constructor to create an Equation Processor. Creates an empty SymbolTable.
     * @param equations ArrayList containing the equations
     * @param processor the Merp processor to use to process expressions
     */
    public EquationProcessor(java.util.ArrayList<java.lang.String> equations,
                             MerpProcessor processor){
        this.processor=processor;
        this.equations=equations;
        symbolTable=new SymbolTable();

    }

    /**
     * Processes the provided list of statements using the provided Merp Processor and Sysmbol Table.
     */
    public void processEquations(){
        for (String eq:equations){
            processEquation(eq);
        }

    }

    /**
     * Helper method of processEquations
     * @param eq the string to be processed.
     */

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

        else if (trimmer.startsWith("if")) {
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

        else if(trimmer.startsWith("while")){
            ArrayList<String> tokens1=new ArrayList<>();
            String sub=trimmer.substring(6,trimmer.length()-1);
            String[] fields2=sub.split(",");
            String condition=fields2[0].trim();
            String[] listc=condition.split(" ");
            for (String i:listc){
                tokens1.add(i);
            }
            ArrayList<String> tokens2=tokens1;
            processor.constructTree(tokens1);
            int ans=processor.evaluateTree(symbolTable);
            String[] run=fields2[1].split(";");
            while (ans==1){
                for (String j:run){
                    processEquation(j);
                }
                for (String i:listc){
                    tokens1.add(i);
                }
                processor.constructTree(tokens2);
                int ans2=processor.evaluateTree(symbolTable);
                ans=ans2;
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



}
