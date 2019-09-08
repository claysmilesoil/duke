import java.io.*;
import java.text.ParseException;

public class Memory{
    public static void writeListToFile() throws IOException, NullPointerException{
        File f = new File("data");
        f.mkdir(); // create directory if it doesn't exist
        File file = new File ("data/List.txt");
        file.delete(); // deletes old file
        FileWriter fw = new FileWriter("data/List.txt");
        try {
            for (Task v : Task.itemList) {
                String done = v.isDone ? "y" : "n";
                if (v instanceof ToDo) {
                    fw.write("T|" + done + "|" + ((ToDo) v).description + "\n");
                } else if (v instanceof Deadline) {
                    fw.write("D|" + done + "|" + ((Deadline) v).description + ">" + ((Deadline) v).dateBackup + "\n");
                } else if (v instanceof Event) {
                    fw.write("E|" + done + "|" + ((Event) v).description + ">" + ((Event) v).dateBackup + "\n");
                }
            }
            fw.close();
        } catch (IOException | NullPointerException e) {
            throw e;
        } finally {
            fw.close();
        }
    }

    public static void readListFromFile() throws ParseException, DukeException {
        try {
            BufferedReader r = new BufferedReader(new FileReader("data/List.txt"));
            String line = r.readLine();
            while (line != null) {
                Task.addFromFile(line);
                line = r.readLine();
            }
        } catch (IOException e) {
            File f = new File("data/List.txt");
        }
    }
}
