package com.algo4.chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Stack;

/**
 * Created by sunilpatil on 9/12/16.
 */
public class DijkstrasExpression {

    public static void main(String[] argv){


        String[] exp = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )".split(" ");
        System.out.println(evaluate(exp));


    }

    private static double evaluate(String[] strings){
        Stack<String> ops = new Stack<>();
        Stack<Double> values = new Stack<>();

        for(String s: strings){
            s = s.trim();
            if(s.equals("("))
                ;
            else if(s.equals("+"))
                ops.push("+");
            else if(s.equals("-"))
                ops.push("-");
            else if(s.equals("*"))
                ops.push("*");
            else if(s.equals("/"))
                ops.push("/");
            else if(s.equals("%"))
                ops.push("%");
            else if(s.equals(")")){
                String op = ops.pop();
                double v = values.pop();
                if(op.equals("+")){
                    v = values.pop() +v;
                }else if(op.equals("-")){
                    v = values.pop() -v;
                }else if(op.equals("*")){
                    v = values.pop() *v;
                }else if(op.equals("/")){
                    v = values.pop() /v;
                }else if(op.equals("%")){
                    v = values.pop() %v;
                }
                values.push(v);
            }else {
                System.out.println("Double.parseDouble(s) ->" +Double.parseDouble(s));
                values.push(Double.parseDouble(s));
                System.out.println("values.size " +values.size());
            }

        }
        return values.pop();
    }


}
