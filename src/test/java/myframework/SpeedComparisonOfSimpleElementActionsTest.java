package myframework;

import core.ConciseAPI;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.ConciseAPI.$;
import static core.ConciseAPI.getDriver;
import static core.ConciseAPI.open;
import static core.conditions.ElementConditions.visible;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class SpeedComparisonOfSimpleElementActionsTest {

    static WebDriver driverForSeleniumActions;

    @BeforeClass
    public static void opensite() {
        ConciseAPI.setDriver(new FirefoxDriver());
        open("https://todomvc4tasj.herokuapp.com/#");
        $("#new-todo").shouldBe(visible());

        driverForSeleniumActions = new FirefoxDriver();
        driverForSeleniumActions.get("https://todomvc4tasj.herokuapp.com/#");
        new WebDriverWait(driverForSeleniumActions, 4).until(visibilityOfElementLocated(By.cssSelector("#new-todo")));
    }

    @AfterClass
    public static void teardown() {
        ConciseAPI.getDriver().quit();
        driverForSeleniumActions.quit();
    }


    @Test
    public void testMyFrameworkIsAlmostAsFastSeleniumWithResearch() {
        long seleniumTime = createTasksWithRawSeleniumWithResearch();
        long myFrameworkTime = createTasksWithMyFrameWorkAndSenKeys();

        System.out.println(String.format("%s vs %s (Difference = %s while expected is < 12)", myFrameworkTime, seleniumTime, (myFrameworkTime - seleniumTime) * 100/seleniumTime));

        assertTrue( myFrameworkTime < 1.12 * seleniumTime);
    }

    @Test
    public void testMyFrameworkIsTo50PercentsSlowerThanSelenium() {
        long seleniumTime = createTasksWithRawSelenium();
        long myFrameworkTime = createTasksWithMyFrameWorkAndSenKeys();

        System.out.println(String.format("%s vs %s (Actual difference = %s while expected is < 51", myFrameworkTime, seleniumTime, (myFrameworkTime - seleniumTime) * 100 /seleniumTime));

        assertTrue( myFrameworkTime < 1.51 * seleniumTime);
    }


    public long createTasksWithRawSelenium() {
        long startTime = System.currentTimeMillis();

        WebElement newTask = driverForSeleniumActions.findElement(By.cssSelector("#new-todo"));

        for (int i = 0; i < 10; i++) {
            newTask.sendKeys("selenium " + i + Keys.ENTER);
        }

        return System.currentTimeMillis() - startTime;
    }

    public long createTasksWithRawSeleniumWithResearch() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            WebElement newTask = driverForSeleniumActions.findElement(By.cssSelector("#new-todo"));
            newTask.sendKeys("selenium " + i + Keys.ENTER);
        }

        return System.currentTimeMillis() - startTime;
    }

    public long createTasksWithMyFrameWorkAndSenKeys() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            $("#new-todo").sendKeys("my framework " + i + Keys.ENTER);
        }

        return System.currentTimeMillis() - startTime;
    }

}
