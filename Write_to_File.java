import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Vector;

public class Write_to_File {

    AirlineSystem system;
    FileWriter writer;
    Calendar calendar;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    Vector<String> fields_names = new Vector<>(Arrays.asList("Username: ","First name: ","Last name: ",
            "Phone number: ","Email: ","Password: ","Gender: ","Day of birth: ","Month of birth: ",
            "Year of birth: "));


    public Write_to_File(AirlineSystem system){
        this.system=system;
    }

    public void creating_a_file()
    {
       try {
           writer = new FileWriter("users.txt",true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
   }

    public void write_to_file(Vector<User> users,int user_index) {

        Vector<String> text_fields = new Vector<>(Arrays.asList(users.get(user_index).getUsername(),
                users.get(user_index).getFirst_name(), users.get(user_index).getLast_name(),
                String.valueOf(users.get(user_index).getPhone_number()),users.get(user_index).getEmail(),
                users.get(user_index).getPassword(),users.get(user_index).getGender(),
                String.valueOf(users.get(user_index).getDay_of_birth()),users.get(user_index).getMonth_of_birth(),
                String.valueOf(users.get(user_index).getYear_of_birth())));

        try {
            calendar = Calendar.getInstance();
            writer=new FileWriter("users.txt",true);
            writer.write(formatter.format(calendar.getTime()));
            writer.write("\n");
            writer.write("User ID: " + user_index);
            writer.write("\n\n");
            for(int i=0;i<text_fields.size();i++) {
                writer.write(fields_names.get(i));
                writer.write(text_fields.get(i));
                writer.write("\n");
            }
            writer.write("\n\n");
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Error while writing");
        }
    }

}
