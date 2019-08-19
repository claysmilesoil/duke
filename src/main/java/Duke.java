import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String line = "_________________________\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(line + "What can I do for you?\nCurrently all I can do is echo.\n"+ line);
        Scanner inp = new Scanner(System.in);
        String input = inp.nextLine();
        while (!input.equals("bye")) {
            System.out.println(line + input + "\n" + line);
            input = inp.nextLine();
        }
        System.out.println(line + "Bye, see you soon!\n" + line);
    }
}
