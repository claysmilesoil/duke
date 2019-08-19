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
        System.out.print(line + "Hello, I'm Duke!\nWhat can I do for you?\n" +
                "Currently I can create a todo list for you.\n"+ line);

        Scanner inp = new Scanner(System.in);
        String input = inp.nextLine();
        int listSize = 0;

        while (!input.equals("bye")) {
            System.out.print(line);
            if (input.equals("list")) {
                // lists all tasks
                if (listSize == 0) {
                    System.out.println("You have no tasks in your list.");
                } else {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < listSize; i++) {
                        System.out.println(i + 1 + ". " + itemList[i].statusIcon() + itemList[i].description);
                    }
                }
            } else if (input.substring(0,4).equals("done")){
                // mark a task as completed
                int number = Integer.parseInt(input.substring(5)) - 1;
                if (number >= listSize || number < 0) {
                    System.out.println("Sorry, you can't do that.");
                } else {
                    if (itemList[number].isDone) System.out.println("You've already marked this task as done:");
                    else {
                        System.out.println("Great, I've marked this task as done:");
                        itemList[number].markAsDone();
                    }
                    System.out.println("   " + itemList[number].statusIcon() + itemList[number].description);
                }
            } else {
                // add new task to list
                Task t = new Task(input);
                itemList[listSize++] = t;
                System.out.println("I've added that task to your list:\n   " + t.statusIcon() + t.description);
            }
            System.out.println(line);
            input = inp.nextLine();
        }

        System.out.print(line + "Bye, see you soon!\n" + line);
    }
}