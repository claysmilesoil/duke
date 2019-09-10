/**
 * Represents a ToDo object as a Task.
 */
public class ToDo extends Task{
    /**
     * Instantiates a ToDo object with a description of the todo.
     * The method to instantiate this object is the same as its superclass Task.
     * @param description
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Overwrites the Task method toString to print a ToDo object with "[T]" followed by Task object.
     * @return String of type of task, statusIcon and description
     */
    @Override
    public String toString() {
        return ("[T]" + super.toString());
    }

    /**
     * Adds an event to the task list.
     * Prints an error message when the description is missing.
     *
     * @param input the user input string containing "todo" followed by a description of the todo
     */
    public static void addToDo(String input) {
            if (input.substring(4).isBlank()) {
                System.out.println("Uh, the description of a todo cannot be empty.");
            } else {
                TaskList.itemList.add(new ToDo(input.substring(5).trim()));
                addTask();
            }
    }
}
