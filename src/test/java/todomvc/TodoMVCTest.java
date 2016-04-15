package todomvc;

import org.junit.Test;
import pages.todomvc.ToDoMVC;
import testconfig.BaseTest;

import static core.ConciseAPI.$;
import static pages.todomvc.ToDoMVC.*;
import static pages.todomvc.ToDoMVC.Task.Status;
import static pages.todomvc.ToDoMVC.Task.Status.ACTIVE;
import static pages.todomvc.ToDoMVC.Task.Status.COMPLETED;
import static pages.todomvc.ToDoMVC.Task.aTask;


public class TodoMVCTest extends BaseTest {

    @Test
    public void testAddAtAll() {
        givenAtAll(ToDoMVC.aTask("a", COMPLETED));

        add("b");
        assertTasks("a","b");
        assertItemsLeft(1);
    }

    @Test
    public void testEditAtAll() {
        givenAtAll(ToDoMVC.aTask("a", COMPLETED));

        startEditing("a", "a edited").pressEnter();
        assertTasks("a edited");
        assertItemsLeft(0);
    }

    @Test
    public void testCancelEditAtAll() {
        givenAtAll(ToDoMVC.aTask("a", COMPLETED));

        startEditing("a", "a edited").pressEscape();
        assertTasks("a");
        assertItemsLeft(0);
    }

    @Test
    public void testEditAndClickOutsideAtAll() {
        givenAtAll(ACTIVE, "a", "b");

        startEditing("a", "a edited");
        newTask.click();
        assertTasks("a edited", "b");
        assertItemsLeft(2);
    }

    @Test
    public void testCompleteAtAll() {
        givenAtAll(ToDoMVC.aTask("a", ACTIVE),
                ToDoMVC.aTask("b", COMPLETED));

        assertItemsLeft(1);
        toggle("a");
        assertItemsLeft(0);
    }

    @Test
    public void testClearCompletedAtAll() {
        givenAtAll(ToDoMVC.aTask("a", COMPLETED),
                ToDoMVC.aTask("b", COMPLETED));

        assertItemsLeft(0);
        сlearCompleted();
        assertNoTasks();
    }

    @Test
    public void testActivateAtAll() {
        givenAtAll(ToDoMVC.aTask("a", COMPLETED));

        assertItemsLeft(0);
        toggle("a");
        assertItemsLeft(1);
    }

    @Test
    public void testActivateTasksAtAll() {
        givenAtAll(ToDoMVC.aTask("a", COMPLETED),
                ToDoMVC.aTask("b", COMPLETED));

        assertItemsLeft(0);
        toggleAll();
        assertItemsLeft(2);
    }

    //ACTIVE FILTER

    @Test
    public void testAddAtActive() {
        givenAtActive(ToDoMVC.aTask("a", ACTIVE));

        assertTasks("a");
        assertItemsLeft(1);
    }

    @Test
    public void testCompeleteAtActive() {
        givenAtActive(ToDoMVC.aTask("a", ACTIVE));

        toggle("a");
        assertNoTasks();
        assertItemsLeft(0);
    }

    @Test
    public void testCompleteTasksAtActive() {
        givenAtActive(ACTIVE, "a", "b");

        toggleAll();
        assertNoTasks();
        assertItemsLeft(0);
    }

    @Test
    public void testEditAtActive() {
        givenAtActive(ACTIVE, "a", "b");

        startEditing("a", "a edited").pressEnter();
        assertTasks("a edited", "b");
        assertItemsLeft(2);
    }

    @Test
    public void testCancelEditAtActive() {
        givenAtActive(ACTIVE, "a", "b");

        startEditing("b", "b edited").pressEscape();
        assertTasks("a", "b");
        assertItemsLeft(2);
    }

    @Test
    public void testDeleteWhileEditingAtActive() {
        givenAtActive(ToDoMVC.aTask("a", ACTIVE));

        startEditing("a", " ").pressEnter();
        assertNoTasks();
    }

    @Test
    public void testClearCompletedAtActive() {
        givenAtActive(ToDoMVC.aTask("a", COMPLETED));

        сlearCompleted();
        assertNoTasks();
    }

    @Test
    public void testDeleteAtActive() {
        givenAtActive(ToDoMVC.aTask("a", ACTIVE));

        delete("a");
        assertNoTasks();
    }

    //COMPLETED FILTER

    @Test
    public void testEditAtCompleted() {
        givenAtCompleted(ToDoMVC.aTask("a", COMPLETED),
                ToDoMVC.aTask("b", COMPLETED));

        startEditing("a", "a edited").pressEnter();
        assertTasks("a edited", "b");
        assertItemsLeft(0);
    }

    @Test
    public void testCancelEditAtCompleted() {
        givenAtCompleted(ToDoMVC.aTask("a", COMPLETED));

        startEditing("a", "a edited").pressEscape();
        assertTasks("a");
        assertItemsLeft(0);
    }

    @Test
    public void testActivateAllAtCompleted() {
        givenAtCompleted(ToDoMVC.aTask("a", COMPLETED),
                ToDoMVC.aTask("b", COMPLETED));

        toggleAll();
        assertNoTasks();
        assertItemsLeft(2);
    }

    @Test
    public void testDeleteAtCompleted() {
        givenAtCompleted(ToDoMVC.aTask("a", COMPLETED),
                ToDoMVC.aTask("b", COMPLETED));

        delete("a");
        assertTasks("b");
        assertItemsLeft(0);
    }

    @Test
    public void testClearCompletedAtCompleted() {
        givenAtCompleted(ToDoMVC.aTask("a", COMPLETED),
                ToDoMVC.aTask("b", COMPLETED));

        assertItemsLeft(0);
        сlearCompleted();
        assertNoTasks();
    }

    // COMMON TEST FLOW

    @Test
    public void testTasksCommonFlow() {

        givenAtAll();
        add("a");
        assertTasks("a");
        assertItemsLeft(1);
        toggleAll();

        filterActive();
        assertNoTasks();

        filterCompleted();
        assertTasks("a");

        //activate task
        toggle("a");
        assertNoTasks();
        assertItemsLeft(1);

        filterAll();
        assertTasks("a");

        filterCompleted();
        assertNoTasks();

        filterActive();
        assertTasks("a");

        filterAll();
        delete("a");
        assertNoTasks();
    }
}
