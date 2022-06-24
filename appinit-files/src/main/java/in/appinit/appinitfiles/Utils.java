package in.appinit.appinitfiles;

import java.util.Random;

public class Utils {

    public static String createRandomFileName(String fileName) {
        String randomString = new Random().ints(48, 122 + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return randomString + "_" + System.currentTimeMillis() + "." + getFileExtension(fileName);
    }

    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

}
