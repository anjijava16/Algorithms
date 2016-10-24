package com.cci;

/**
 * Created by sunilpatil on 10/16/16.
 */
public class Chapter3 {
    /**
     * Write a program to sort a stack in ascending order.
     * You should not make any assump- tions about how the stack
     * is implemented. The following are the only functions that should be
     * used to write this program: push | pop | peek | isEmpty.
     */

    public static Stack sort(Stack s) {
        Stack r = new Stack();
        while (!s.empty()) {
            int tmp = s.pop();
            while (!r.empty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }


    public static void main(String[] argv) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);


        for (Integer i : stack)
            System.out.print(i + " ");

        Stack sorted = sort(stack);
        System.out.println();

        for (Integer i : sorted)
            System.out.print(i + " ");
    }
}
