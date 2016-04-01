package pages.gmail;

import static core.ConciseAPI.$;
import static core.ConciseAPI.open;

public class Gmail {

    public static void login(String email, String password) {
        $("#Email").sendKeys(email).pressEnter();
        $("#Passwd").sendKeys(password).pressEnter();
    }

    public static void visit() {
        open("http://gmail.com");
    }
}
