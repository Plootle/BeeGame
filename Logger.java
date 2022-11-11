import java.util.*;
import java.io.*;

//we implemetn the singleton pattern here
public class Logger 
{
    public PrintWriter out;

    // continually updating
    public List<String> words = new ArrayList<String>();

    // establishing the file path and setting the local storage
    String path = "C:\\ObjectOutput\\"; 

    // constructor
    public Logger(String name) throws FileNotFoundException 
    { 
        this.out = new PrintWriter(path + name + ".txt");
    }

    // update
    public void addString(String line)
    {
        words.add(line);
    } 

    // writes to the file
    public void writes(List<String> words, PrintWriter out) throws IOException
    { 
        for(int i = 0; i < words.size(); i++)
        {
            out.write(words.get(i) + "\r\n");
        }
    }

    // close the file
    public void close(PrintWriter out)
    { 
        out.close();
    }
}