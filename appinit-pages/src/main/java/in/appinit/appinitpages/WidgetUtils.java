package in.appinit.appinitpages;

import org.apache.commons.lang.RandomStringUtils;

import java.util.List;

public class WidgetUtils {
    public static String createKey(List<String> usedKeys) {
        String newKey;
        do {
            newKey = RandomStringUtils.random(16, true, true);
        } while (usedKeys.contains(newKey));

        System.out.println("createdKey: " + newKey);
        return newKey;
    }

    public static String createKey() {
        return RandomStringUtils.random(16, true, true);
    }
}
