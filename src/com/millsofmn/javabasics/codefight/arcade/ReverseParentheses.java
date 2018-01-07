package com.millsofmn.javabasics.codefight.arcade;

@SuppressWarnings("Duplicates")
public class ReverseParentheses {

    public static void main(String[] args) {
        String test1 = "a(bc)de";
        String expected1 = "acbde";
        String result1 = reverseParentheses(test1);
        System.out.println(String.format("%-30s | %-30s | %-30s  ", test1, expected1, result1 ));

        String test2 = "a(bcdefghijkl(mno)p)q";
        String expected2 = "apmnolkjihgfedcbq";
        String result2 = reverseParentheses(test2);
        System.out.println(String.format("%-30s | %-30s | %-30s  ", test2, expected2, result2 ));

        String test3 = "co(de(fight)s)";
        String expected3 = "cosfighted";
        String result3 = reverseParentheses(test3);
        System.out.println(String.format("%-30s | %-30s | %-30s  ", test3, expected3, result3 ));

        String test4 = "Code(Cha(lle)nge)";
        String expected4 = "CodeegnlleahC";
        String result4 = reverseParentheses(test4);
        System.out.println(String.format("%-30s | %-30s | %-30s  ", test4, expected4, result4 ));

        String test5 = "Where are the parentheses?";
        String expected5 = "Where are the parentheses?";
        String result5 = reverseParentheses(test5);
        System.out.println(String.format("%-30s | %-30s | %-30s  ", test5, expected5, result5 ));

        String test6 = "abc(cba)ab(bac)c";
        String expected6 = "abcabcabcabc";
        String result6 = reverseParentheses(test6);
        System.out.println(String.format("%-30s | %-30s | %-30s  ", test6, expected6, result6 ));

        String test7 = "The nworb( kciuq( xof jumps over the lazy) dog)";
        String expected7 = "The god quick nworb xof jumps over the lazy";
        String result7 = reverseParentheses(test7);
        System.out.println(String.format("%-30s | %-30s | %-30s  ", test7, expected7, result7 ));

        String test8 = "The (brow(n f)ox) (is r)unnin(g( over a)nd over) again!";
        String expected8 = "The god quick nworb xof jumps over the lazy";
        String result8 = reverseParentheses(test8);
        System.out.println(String.format("%-30s | %-30s | %-30s  ", test8, expected8, result8 ));
    }

    private static String reverseParentheses(String s) {
        int lstLftParen = s.lastIndexOf("(");

        while(lstLftParen != -1){
            int rghtParen = s.indexOf(")", lstLftParen);
            String sub = s.substring(lstLftParen, rghtParen +1);
            String backwardSub = "";
            for (int x = sub.length() - 2; x > 0; x--) {
                backwardSub += sub.charAt(x);
            }
            s = s.replace(sub, backwardSub);
            lstLftParen = s.lastIndexOf("(");
        }
        return s;
    }

}
