import java.io.*;
public class Memory{
    public static void writeToFile(Task v) {
        try {
            File f = new File("data");
            f.mkdir(); // create directory if it doesn't exist
            FileWriter fw = new FileWriter("data/List.txt", true);
            String done = v.isDone? "y" : "n";
            if (v instanceof ToDo){
                fw.write("T|" + done + "|" + ((ToDo)v).description + "\n");
            }
            else if (v instanceof Deadline) {
                fw.write("D|"+ done + "|" + ((Deadline)v).description + ">" + ((Deadline)v).date + "\n");
            }
            else if (v instanceof Event) {
                fw.write("E|"+ done + "|" + ((Event)v).description + ">" + ((Event)v).date + "\n");
            }

            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Caught NPE, file not saved.");
        }
    }

    public static void readListFromFile(){
        try {
            BufferedReader r = new BufferedReader(new FileReader("data/List.txt"));
            String line = r.readLine();
            while (line != null) {
                Task.addFromFile(line);
                line = r.readLine();
            }
        } catch (IOException e) {
            File f = new File ("data/List.txt");
        } catch (Exception e) {
            System.out.println("Error reading from file; file data may be corrupted.");
        }
    }
}
