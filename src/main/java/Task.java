/**
 * Represents a Task object, with a description of the task and its completion status.
 */
public abstract class Task { // abstract?
    /**
     * The description of a task given by the user.
     */
    protected String description;
    /**
     * Value that marks whether the task is completed.
     */
    protected boolean isDone;

    // public static ArrayList<Task> itemList = new ArrayList<Task>(100);

    /**
     * Instantiates a Task object with the description of the task and marking isDone as false.
     * @param description the description of a task given by the user
     */
    public Task (String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns a check mark or a cross based on the value of isDone.
     *
     * @return check mark if isDone is true, cross if isDone is false
     */
    public String statusIcon() {
        return (isDone ? "[\u2713] " : "[\u2718] " ); // check mark or x
    }

    /**
     * Overrides the Object method toString to print a Task object with statusIcon followed by description.
     * @return String of statusIcon and description
     */
    @Override
    public String toString() {
        return (this.statusIcon() + this.description);
    }

    /**
     * Mark the task as done.
     * Assigns the isDone variable to true.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Prints a confirmation message of the task being added to the list.
     * Also prints how many tasks are in the list.
     */
    public static void addTask() {
        System.out.println("Got it, I've added this task:\n   " + TaskList.itemList.get(TaskList.itemList.size() - 1)
                + "\nNow you have " + TaskList.itemList.size() + " task(s) in the list.");
    }
}
