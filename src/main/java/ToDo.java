public class ToDo extends Task{
    public ToDo(String description) {
        super(description);
    }
    @Override
    public String toString() {
        return ("[T]" + super.toString());
    }

    public static void addToDo(String input) {
            if (input.substring(4).isBlank()) {
                System.out.println("Uh, the description of a todo cannot be empty.");
            } else {
                itemList.add(new ToDo(input.substring(5).trim()));
                addTask();
            }
    }
}
