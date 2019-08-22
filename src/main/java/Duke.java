import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        // formatting
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String line = "_________________________\n";

        // initialising array of Tasks
        Task[] itemList = new Task[100];

        // Greeting
        System.out.println("Hello from\n" + logo);
        System.out.print(line + "Hello, I'm Duke!\nWhat can I do for you?\n" + line);

        Scanner inp = new Scanner(System.in);
        String input = inp.nextLine();
        int listSize = 0;

        //TODO: write input handling into its own class
        while (!input.equals("bye")) {
            System.out.print(line);
            if (input.equals("list")) {
                // lists all tasks
                if (listSize == 0) {
                    System.out.println("You have no tasks in your list.");
                } else {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < listSize; i++) {
                        System.out.println(i + 1 + ". " + itemList[i]);
                    }
                }
            } else if (input.substring(0,4).equals("done")){
                // mark a task as completed
                int number = Integer.parseInt(input.substring(5)) - 1;
                if (number >= listSize || number < 0) {
                    System.out.println("Don't do that.");
                } else if (itemList[number].isDone) {
                    System.out.println("You've already marked this task as done:");
                    System.out.println("   " + itemList[number]);
                } else {
                    itemList[number].markAsDone();
                    System.out.println("Great, I've marked this task as done:\n    " + itemList[number] +
                            "\nNow you have " + listSize + " task(s) in the list.");
                }

            } else if (input.substring(0,4).equals("todo")){
                // add new to-do to list
                itemList[listSize++] = new ToDo(input.substring(5));
                System.out.println("Got it, I've added this task:\n   " + itemList[listSize-1] + "\nNow you have "
                        + listSize + " task(s) in the list.");
            } else if (input.substring(0,8).equals("deadline")){
                // add new deadline to list
                int dateIdx = input.indexOf("/by");
                if (dateIdx == -1) System.out.println("Specify a date or time using the keyword /by");
                else {
                    itemList[listSize++] = new Deadline(input.substring(9, dateIdx), input.substring(dateIdx + 4));
                    System.out.println("Got it, I've added this task:\n   " + itemList[listSize - 1] + "\nNow you have "
                            + listSize + " task(s) in the list.");
                }
            } else if (input.substring(0,5).equals("event")) {
                int dateIdx = input.indexOf("/at");
                if (dateIdx == -1) System.out.println("Specify a date or time using the keyword /at");
                else {
                    itemList[listSize++] = new Event(input.substring(6, dateIdx), input.substring(dateIdx + 4));
                    System.out.println("Got it, I've added this task:\n   " + itemList[listSize - 1] + "\nNow you have "
                            + listSize + " task(s) in the list.");
                }
            }
            System.out.println(line);
            input = inp.nextLine();
        }

        System.out.print(line + "Bye, see you soon!\n" + line);
    }
}