package com.millsofmn.codility.stacksandqueues;

import java.util.Stack;

/**
 * A string S consisting of N characters is considered to be properly nested if
 * any of the following conditions is true:
 * <p>
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if S is
 * properly nested and 0 otherwise.
 * <p>
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters:
 * "(", "{", "[", "]", "}" and/or ")".
 */
public class Brackets {
    public static void main(String[] args) {
        System.out.println("1 => " + new Brackets().solution("{[()()]}"));
        System.out.println("0 => " + new Brackets().solution("([)()]"));
        System.out.println("1 => " + new Brackets().solution("[{()}]"));
        System.out.println("0 => " + new Brackets().solution("]["));
        System.out.println("1 => " + new Brackets().solution("()[]{}()[]{}"));
        System.out.println("0 => " + new Brackets().solution("()[]{}()[]{"));
        System.out.println("0 => " + new Brackets().solution("ab{"));
    }

    /**
     * Udemy Solution
     * https://app.codility.com/demo/results/trainingWMYJYU-RZK/
     */
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return 0;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return 0;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    /**
     * My solution after hint 100%
     * https://app.codility.com/demo/results/training22UBHR-7TY/
     */
    public int solution3(String S) {
        Stack<Character> stack = new Stack<>();

        for (char b : S.toCharArray()) {
            if (b == '{' || b == '[' || b == '(') {
                stack.push(b);
            } else if (!stack.empty()) {
                char pop = stack.pop();

                if ((b == '}' && pop == '{') ||
                        (b == ']' && pop == '[') ||
                        (b == ')' && pop == '(')) {
                    continue;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }

        if (stack.empty())
            return 1;
        else
            return 0;
    }

    /**
     * 62% With Udemy Hint 1
     * https://app.codility.com/demo/results/trainingSQ2ET4-6DX/
     */
    public int solution2(String S) {
        char[] stack = new char[S.length()];
        int pos = 0;

        for (char b : S.toCharArray()) {

            if (b == '{' || b == '[' || b == '(') {
                pos++;
                stack[pos] = b;

            } else if (b == '}' || b == ']' || b == ')') {
                char popped = stack[pos];

                if (b == '}' && popped == '{') pos--;
                else if (b == ']' && popped == '[') pos--;
                else if (b == ')' && popped == '(') pos--;
                else return 0;
            } else {
                return 0;
            }
        }
        return 1;
    }

    /**
     * 37%
     * https://app.codility.com/demo/results/trainingHKSDJ7-NKB/
     */
    public int solution1(String S) {

        int pos = 0;
        int[] stack = new int[S.length() + 1];

        char openBracket = '{';
        char closedBracket = '}';

        char openBrace = '[';
        char closedBrace = ']';

        char openParen = '(';
        char closedParen = ')';


        for (char c : S.toCharArray()) {
            int item = 0;

            if (c == openBracket) item = 1;
            else if (c == closedBracket) item = -1;
            else if (c == openBrace) item = 2;
            else if (c == closedBrace) item = -2;
            else if (c == openParen) item = 3;
            else if (c == closedParen) item = -3;

            if (stack[pos] + item == 0)
                pos--;
            else {
                pos++;
                stack[pos] = item;
            }

        }
        if (pos == 0)
            return 1;
        else
            return 0;
    }
}
