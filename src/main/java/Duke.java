import java.util.Scanner;
public class Duke {
    private static String line = "____________________________________________\n";
    private static Scanner inp = new Scanner(System.in);

    private Duke() {
        // Greeting
        // startup
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.print(line + "Hello, I'm Duke!\nWhat can I do for you?\n" + line);
        // load list from List.txt
        Memory.readListFromFile();
    }
    public static void main(String[] args) {

        new Duke();

        String input = inp.nextLine();
        while (!input.equals("bye")) {
            System.out.print(line);
            if (input.equals("list")) {
                // lists all tasks
                if (Task.itemList.isEmpty()) {
                    System.out.println("You have no tasks in your list.");
                } else {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < Task.itemList.size(); i++) {
                        System.out.println(i + 1 + ". " + Task.itemList.get(i));
                    }
                }
            } else if (input.indexOf("find") == 0) {
                Task.findTask(input);
            } else if (input.indexOf("done") == 0){
                // mark a task as completed
                Task.doneTask(input);
            } else if (input.indexOf("todo") == 0){
                // add new to-do to list
                ToDo.addToDo(input);
            } else if (input.indexOf("deadline") == 0){
                // add new deadline to list
                Deadline.addDeadline(input);
            } else if (input.indexOf("event") == 0) {
                Event.addEvent(input);
            } else if (input.indexOf("delete") == 0) {
                Task.deleteTask(input);
            } else if (input.equals("help")){
                System.out.println("Here are the currently available commands:\n" +
                        "    1. todo [field]                 -- Add a todo task to the list\n" +
                        "    2. deadline [field] /by [time]  -- Add a deadline task to the list\n" +
                        "    3. event [field] /at [time]     -- Add an event to the list\n" +
                        "    4. done [number]                -- Mark corresponding task on the list as completed\n" +
                        "    5. delete [number]              -- Delete corresponding task on the list\n" +
                        "    5. list                         -- Display list of tasks\n" +
                        "    6. help                         -- Bring up this manual\n" +
                        "    7. bye                          -- Close the program. ");
            } else {
                // filter out gibberish
                System.out.println("Uh, dunno what that means. Type \"help\" for the list of commands available.");
            }
            System.out.println(line);
            input = inp.nextLine();
        }
        Memory.writeListToFile();
        System.out.print(line + "Bye, see you soon!\n" + line);
    }
}