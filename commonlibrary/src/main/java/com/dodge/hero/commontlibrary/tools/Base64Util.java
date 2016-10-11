package com.dodge.hero.commontlibrary.tools;

import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by LinZheng on 2016/10/11.
 */

public class Base64Util {

    public static String encode(String string) {
        return Base64.encodeToString(string.getBytes(), Base64.DEFAULT);
    }


    public static String decode(String encodedString) {
        return new String(Base64.decode(encodedString, Base64.DEFAULT));
    }

    public static String encode(File file) {
        FileInputStream inputFile;
        try {
            inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
            inputFile.close();
            return Base64.encodeToString(buffer, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void decode(File file, String encodedString) {
        FileOutputStream fos;
        try {
            byte[] decodeBytes = Base64.decode(encodedString.getBytes(), Base64.DEFAULT);
            fos = new FileOutputStream(file);
            fos.write(decodeBytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
