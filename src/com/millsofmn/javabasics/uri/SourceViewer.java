package com.millsofmn.javabasics.uri;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SourceViewer {

    public static void main(String[] args) {
        InputStream in = null;
        try {
            // open url for reading
            URL u = new URL("http://www.oreilly.com");
            in = u.openStream();

            // buffer input to increase performance
            in = new BufferedInputStream(in);

            // chain the input stream to a reader
            Reader r = new InputStreamReader(in);

            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }

        } catch (MalformedURLException ex) {
            System.err.println("Cannot parse URL");

        } catch (IOException ex) {
            System.err.println(ex);

        } finally {
            if (in != null) {
                try {
                    in.close();

                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }
}
