import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;
    //protected static int numberOfTasks = 0;
    public static ArrayList<Task> itemList = new ArrayList<Task>(100);

    public Task (String description) {
        this.description = description;
        this.isDone = false;
        //numberOfTasks++;
    }

    public String statusIcon() {
        return (isDone ? "[\u2713] " : "[\u2718] " ); // check mark or x
    }

    @Override
    public String toString() {
        return (this.statusIcon() + this.description);
    }

    public void markAsDone() {
        this.isDone = true;
    } // TODO: find and change in file

    public static void addTask() {
        Memory.writeToFile(itemList.get(itemList.size() - 1));
        System.out.println("Got it, I've added this task:\n   " + itemList.get(itemList.size() - 1) + "\nNow you have "
                + itemList.size() + " task(s) in the list.");
    }

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
            System.out.println("Specify the number corresponding to the task on the list.");
        }
    }

    public static void addFromFile(String line) throws Exception {
        switch(line.charAt(0)){
            case ('T'):
                //itemList[numberOfTasks] = new ToDo(line.substring(4));
                itemList.add(new ToDo(line.substring(4)));
                break;
            case ('D'):
                //itemList[numberOfTasks] = new Deadline(line.substring(4,line.indexOf(">")), line.substring(line.indexOf(">")+ 1));
                itemList.add(new Deadline(line.substring(4,line.indexOf(">")), line.substring(line.indexOf(">")+ 1)));
                break;
            case ('E'):
                //itemList[numberOfTasks] = new Event(line.substring(4,line.indexOf(">")), line.substring(line.indexOf(">") + 1));
                itemList.add(new Event(line.substring(4,line.indexOf(">")), line.substring(line.indexOf(">") + 1)));
                break;
            default:
                throw new Exception();
        }
        itemList.get(itemList.size() - 1).isDone = (line.charAt(2) == 'y');
    }
}
