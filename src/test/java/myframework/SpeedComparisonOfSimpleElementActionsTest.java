package myframework;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testconfig.BaseTest;

import static core.ConciseAPI.$;
import static core.ConciseAPI.getDriver;
import static core.ConciseAPI.open;
import static org.junit.Assert.assertTrue;
import static pages.todomvc.ToDoMVC.givenAtAll;

public class SpeedComparisonOfSimpleElementActionsTest extends BaseTest {
    @BeforeClass
    public static void opensite() {
        open("https://todomvc4tasj.herokuapp.com/#");
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#new-todo")));
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

        WebElement newTask = getDriver().findElement(By.cssSelector("#new-todo"));

        for (int i = 0; i < 10; i++) {
            newTask.sendKeys("task " + i + Keys.ENTER);
        }

        return System.currentTimeMillis() - startTime;
    }

    public long createTasksWithRawSeleniumWithResearch() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            WebElement newTask = getDriver().findElement(By.cssSelector("#new-todo"));
            newTask.sendKeys("task " + i + Keys.ENTER);
        }

        return System.currentTimeMillis() - startTime;
    }

    public long createTasksWithMyFrameWorkAndSenKeys() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            $("#new-todo").sendKeys("task " + i + Keys.ENTER);
        }

        return System.currentTimeMillis() - startTime;
    }

}
