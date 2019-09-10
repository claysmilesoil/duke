import java.text.ParseException;
import java.util.ArrayList;

/**
 * Represents a static list of Task objects with methods to read from or modify the list.
 */
public class TaskList{
    /**
     * An empty static ArrayList of Task objects initialized to a capacity of 100.
     */
    public static ArrayList<Task> itemList = new ArrayList<Task>(100);

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
