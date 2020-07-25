package io;

import java.io.*;

public class InputStreamTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream=null;
        try {
            inputStream = new BufferedInputStream(
                    new FileInputStream("/Users/zhao/Documents/temp/cas.log"));
            int r = -1;
            while ((r = inputStream.read()) != -1) {
                System.out.println(r);
            }
        }finally {
            inputStream.close();
        }
    }

}
