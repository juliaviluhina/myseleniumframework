package core;

import org.openqa.selenium.NoSuchElementException;

public class Helpers {

    public static String getUniqueText(String prefix) {
        return (prefix + " " + System.currentTimeMillis());
    }


}
