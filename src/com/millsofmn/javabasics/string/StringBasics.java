package com.millsofmn.javabasics.string;

import java.text.MessageFormat;

/**
 * Created by m108491 on 6/14/2016.
 */
public class StringBasics {

    public static void main(String[] args){
//        concatenation();
//        concatenationStringAndInt();
//        compare();
//        stringMessageFormat();
//        stringFormat();
        substring();
    }

    private static void concatenation() {
        String expletive = "Expletive";
        String pg13 = "deleted";
        String message = expletive + pg13;

        System.out.println(message);
    }

    private static void concatenationStringAndInt(){
        int total = 13;
        String baskets = "Baskets";
        String totalBaskets = baskets + " " + total;

        System.out.println(totalBaskets);
    }

    private static void compare(){
        System.out.println("\nString Compares --------------------------------");
        String str1 = "String";
        String str2 = "String";
        String str3 = "String2";
        String strCapital = "STRING";

        System.out.println("Values");
        System.out.println("str1=" + str1);
        System.out.println("str2=" + str2);
        System.out.println("strCapital=" + strCapital);

        System.out.println("\nString Equals");
        System.out.println("str1.equals(str1): " + str1.equals(str1));
        System.out.println("str1.equals(str1Capital): " + str1.equals(strCapital));
        System.out.println("string.equalsIgnoreCase(stringCapital): " + str1.equalsIgnoreCase(strCapital));

        System.out.println("\nString ==");
        boolean compareSameStr = str1 == str1;
        System.out.println("str1 == str1: " + compareSameStr );
        boolean compareSameValues = str1 == str2;
        System.out.println("str1 == str2: " + compareSameValues);
        boolean compareDiffValues = str1 == str3;
        System.out.println("str1 == str3: " + compareDiffValues);


    }

    private static void stringMessageFormat(){
        String message = "1 This is my message with value {0}";
        String value = "Value";

        String newString = MessageFormat.format(message, value);
        System.out.println(newString);

        String message2 = "2 This is my message with value {0}";

        String newString2 = MessageFormat.format(message2, null);
        System.out.println(newString2);

        String message3 = "3 This is my message with value";
        String value3 = "Value";

        String newString3 = MessageFormat.format(message3, value3);
        System.out.println(newString3);

        String message4 = "4 This is my message with value {0}, {1}";
        String value4 = "Value1";
        String value41 = "Value2";

        String newString4 = MessageFormat.format(message3, value4, value41);
        System.out.println(newString4);


    }

    private static void stringFormat(){
        String message = String.format("My String %s", "123");
        System.out.println(message);

        String CONJUGATOR = "&&";
        String msg = String.format("Cannot use '%s' in panel or sample class.", CONJUGATOR);
//        System.out.println(msg);

        if ("MNDP&&NGS22".contains(CONJUGATOR)) {
            System.out.println(msg);
        }
    }

    private static void substring(){
        String remoteFile = "/dlmp/prod/testDefinition/NMPAN-NGS22/pipelines/cnv/reporting.bed";
        String fileName = remoteFile.substring(remoteFile.lastIndexOf("/")+1, remoteFile.length());
        System.out.println(fileName);

        String hyphenName = remoteFile.replace("/", "-");
        System.out.println(hyphenName);
    }
}
