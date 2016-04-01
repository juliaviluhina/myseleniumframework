package gmail;

import core.Configuration;
import gmail.testdata.AccountData;
import org.junit.Test;
import pages.gmail.Gmail;
import pages.gmail.Mails;
import pages.gmail.Menu;
import testconfig.BaseTest;

import static core.Helpers.getUniqueText;


public class GmailTest extends BaseTest {

    static {
        Configuration.timeout = 15000;
    }

    @Test
    public void testGmailCommonFlow() {

        String subject = getUniqueText("test");

        Gmail.visit();
        Gmail.login(AccountData.email, AccountData.password);

        Mails.send(AccountData.email, subject);
        Menu.refresh();
        Mails.assertMail(0, subject);

        Menu.openSent();
        Mails.assertMail(0, subject);

        Menu.openInbox();
        Menu.search(subject);
        Mails.assertMails(subject);
    }
}

