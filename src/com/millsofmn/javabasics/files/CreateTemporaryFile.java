package com.millsofmn.javabasics.files;

import java.io.File;
import java.io.IOException;

public class CreateTemporaryFile {
    public static void main(String[] args) {
        try {
            File tempFile = File.createTempFile("foo", ".bar");
            tempFile.deleteOnExit();
            System.out.format("File %s was created.", tempFile.getCanonicalFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
