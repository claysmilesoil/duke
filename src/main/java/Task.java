import java.text.ParseException;
import java.util.ArrayList;

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

    /**
     * An empty static ArrayList of Task objects initialized to a capacity of 100.
     */
    public static ArrayList<Task> itemList = new ArrayList<Task>(100);

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
        System.out.println("Got it, I've added this task:\n   " + itemList.get(itemList.size() - 1) + "\nNow you have "
                + itemList.size() + " task(s) in the list.");
    }

    /**
     * Finds the task item in the task list itemList based on user input's number and marks that task as done, then prints a confirmation message.
     * Prints an error message if the number does not correspond to items in the list or input is not a number.
     * If the task has already been marked as done, prints a message.
     *
     * @param input The user input string, "done" followed by a number corresponding to am item in task list.
     */
    public static void doneTask(String input) {
        try {
            int listIdx = Integer.parseInt(input.substring(5).trim()) - 1;
            if (listIdx >= itemList.size() || listIdx < 0) {
                System.out.println("There's no task on the list corresponding to that number.");
            } else if (itemList.get(listIdx).isDone) {
                System.out.println("You've already marked this task as done:");
                System.out.println("   " + itemList.get(listIdx));
            } else {
                itemList.get(listIdx).markAsDone();
                System.out.println("Great, I've marked this task as done:\n    " + itemList.get(listIdx) +
                        "\nNow you have " + itemList.size() + " task(s) in the list.");
            }
        } catch (StringIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Specify the number corresponding to the task on the list.\n");
        }
    }

    /**
     * Deletes the task in the task list itemList corresponding to the number in user input.
     * Prints a confirmation message of the deletion of the Task from the list.
     * Prints an error message if the number does not correspond to items in the list or input is not a number.
     *
     * @param input The user input string, "delete" followed by a number corresponding to an item in task list.
     */
    public static void deleteTask(String input) {
        try {
            int listIdx = Integer.parseInt(input.substring(6).trim()) - 1;
            if (listIdx >= itemList.size() || listIdx < 0) {
                System.out.println("There's no task on the list corresponding to that number.");
            } else {
                System.out.println("Noted, I've removed this task:\n    " + itemList.get(listIdx) +
                        "\nNow you have " + (itemList.size()-1) + " task(s) in the list.");
                itemList.remove(listIdx);
            }
        } catch (StringIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Specify the number corresponding to the task on the list.\n" + e.getMessage());
        }
    }

    /**
     * Finds Task objects that contain the keyword in user input from the task list itemList.
     * Prints the Task objects whose description contains the keyword in user input.
     * Prints a message when itemList does not contain any tasks.
     *
     * @param input the user input string "find" followed by keyword(s) to find
     */
    public static void findTask(String input) {
        if (itemList.isEmpty()) {
            System.out.println("You have no tasks in your list.");
        } else {
            String keyword = input.substring(4).trim();
            ArrayList<Task> queryList = new ArrayList<>(100);
            for (Task v : itemList) {
                if (v.description.contains(keyword)) queryList.add(v);
            }
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < queryList.size(); i++) {
                System.out.println(i + 1 + ". " + queryList.get(i));
            }
        }
    }

    /**
     * Parses the line that is read from a .txt file, constructs a Task object based on the line and adds that Task to itemList.
     *
     * @param line the line read from file to be parsed, in the format T|s|description or C|s|description>date
     *             where C is letter corresponding to type of Task and s representing the completion status (y/n)
     * @throws ParseException thrown when there is an error in parsing the file when constructing Task objects
     * @throws DukeException thrown when the method does not recognize the format of the line
     */
    public static void addFromFile(String line) throws ParseException, DukeException{
        try {
            switch(line.charAt(0)){
                case ('T'):
                    itemList.add(new ToDo(line.substring(4)));
                    break;
                case ('D'):
                    itemList.add(new Deadline(line.substring(4,line.indexOf(">")), line.substring(line.indexOf(">")+ 1)));
                    break;
                case ('E'):
                    itemList.add(new Event(line.substring(4,line.indexOf(">")), line.substring(line.indexOf(">") + 1)));
                    break;
                default:
                    throw new DukeException();
            }
            itemList.get(itemList.size() - 1).isDone = (line.charAt(2) == 'y');
        } catch (ParseException | DukeException e) {
            throw e;
        }
    }
}
