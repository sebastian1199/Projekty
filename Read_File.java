import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Read_File {

    FileReader reader;
    BufferedReader buffered_reader;
    String line;

    public void reading_from_file(Vector<String> data,String text_file)
    {
        try {
            reader = new FileReader(text_file);
        }
        catch (FileNotFoundException e){
            System.out.println("Error while creating text file");
        }

        buffered_reader=new BufferedReader(reader);

        try {
            while((line=buffered_reader.readLine()) != null){
                data.add(line);
            }
        }
        catch (IOException e) {
            System.out.println("Error while reading");
        }
    }
}
