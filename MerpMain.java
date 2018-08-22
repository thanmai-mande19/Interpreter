import Processors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MerpMain {

    private MerpProcessor merpProcessor;

    public void run(){

        System.out.println("Enter the type of expression: ");
        Scanner for_processor=new Scanner(System.in);

        String processor=for_processor.nextLine();
        processor=processor.trim();

        if (processor.equals("infix")){
            merpProcessor=new MerpInfixProcessor();

        }
        else if (processor.equals("postfix")){
            merpProcessor=new MerpPostfixProcessor();
        }
        else{
            merpProcessor=new MerpPrefixProcessor();

        }

        System.out.println("Enter the lines to process:");

        ArrayList<String> equations=new ArrayList<>();

        Scanner for_lines=new Scanner(System.in);

        String line=for_lines.nextLine();
        line=line.trim();
        while (!line.equals("")){
            equations.add(line);
             line=for_lines.nextLine();
            line=line.trim();
        }

        EquationProcessor ep=new EquationProcessor(equations,merpProcessor);


        ep.processEquations();

    }

    public static void main(String[] args){

        MerpMain merpMain=new MerpMain();
        merpMain.run();


    }

}
