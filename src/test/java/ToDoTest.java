import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test to check if the fields of a ToDo object in a list are instantiated correctly
 */
public class ToDoTest{
    @Test
    public void addToDoTest() {
        ToDo.addToDo("       Finish JUnit tests     "); // extra spaces to check trim() method
        assertEquals(TaskList.itemList.get(TaskList.itemList.size() - 1).description, "Finish JUnit tests");
        assertEquals(TaskList.itemList.get(TaskList.itemList.size() - 1).isDone, false);
    }
}
