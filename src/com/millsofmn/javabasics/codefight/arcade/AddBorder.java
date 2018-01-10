package com.millsofmn.javabasics.codefight.arcade;

public class AddBorder {
    public static void main(String[] args) {
        String[] picture = new String[]{"abc", "ded"};
        String[] thisPic = addBorder(picture);

        for(String s : thisPic){
            System.out.println(s);
        }
    }

static String[] addBorder(String[] picture) {
    int length = picture[0].length();
    String[] framed = new String[picture.length + 2];

    String header = "";
    for(int i = 0; i < picture[0].length() + 2; i++){
        header += "*";
    }
    int x = 0;
    framed[0] = header;
    for(int i = 0; i < picture.length; i++){
        framed[i+1] = "*" + picture[i] + "*";
        x = i + 1;
    }
    framed[x+1] = header;

    return framed;
}
}
