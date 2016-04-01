package pages.gmail;

import core.wrappers.collection.LazyCollection;
import org.openqa.selenium.By;

import static core.ConciseAPI.*;
import static core.conditions.CustomCollectionConditions.listNthElementHasText;
import static core.conditions.CustomCollectionConditions.texts;

public class Mails {

    public static LazyCollection emails = $$("[role='main'] .zA");

    public static void send(String email, String subject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(email);
        $(By.name("subjectbox")).sendKeys(subject);
        $(byText("Send")).click();
    }

    public static void assertMails(String... subjects) {
        emails.shouldHave(texts(subjects));
    }

    public static void assertMail(int index, String subject) {
        emails.shouldHave(listNthElementHasText(index, subject));
    }
}
