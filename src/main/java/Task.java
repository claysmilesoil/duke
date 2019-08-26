public class Task {
    protected String description;
    protected boolean isDone;
    protected static int numberOfTasks = 0;

    public Task (String description) {
        this.description = description;
        this.isDone = false;
        numberOfTasks++;
    }

    public static Task[] itemList = new Task[100];

    public String statusIcon() {
        return (isDone ? "[\u2713] " : "[\u2718] " ); // check mark or x
    }

    @Override
    public String toString() {
        return (this.statusIcon() + this.description);
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public static void addTask() {
        System.out.println("Got it, I've added this task:\n   " + Task.itemList[Task.numberOfTasks - 1] + "\nNow you have "
                + Task.numberOfTasks + " task(s) in the list.");
    }

    public static void doneTask(String input) {
        try {
            int listIdx = Integer.parseInt(input.substring(5).trim()) - 1;
            if (listIdx >= Task.numberOfTasks || listIdx < 0) {
                System.out.println("There's no task on the list corresponding to that number.");
            } else if (Task.itemList[listIdx].isDone) {
                System.out.println("You've already marked this task as done:");
                System.out.println("   " + Task.itemList[listIdx]);
            } else {
                Task.itemList[listIdx].markAsDone();
                System.out.println("Great, I've marked this task as done:\n    " + Task.itemList[listIdx] +
                        "\nNow you have " + Task.numberOfTasks + " task(s) in the list.");
            }
        } catch (StringIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Specify the number corresponding to the task on the list.");
        }
    }
}
