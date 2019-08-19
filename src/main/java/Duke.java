import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String line = "_________________________\n";
        String[] itemlist = new String[100];

        System.out.println("Hello from\n" + logo);
        System.out.println(line + "Hello, I'm Duke!\nWhat can I do for you?\n" +
                "Currently I can create a list for you.\n"+ line);
        Scanner inp = new Scanner(System.in);
        String input = inp.nextLine();
        int listsize = 0;
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                System.out.print(line);
                if (listsize == 0) {
                    System.out.println("There is no item in the list.");
                } else {
                    for (int i = 0; i < listsize; i++) {
                        System.out.println(i + 1 + ". " + itemlist[i]);
                    }
                }
                System.out.println(line);
            } else {
                itemlist[listsize++] = input;
                System.out.println(line + "added: " + input + "\n" + line);
            }
            input = inp.nextLine();
        }
        System.out.println(line + "Bye, see you soon!\n" + line);
    }
}