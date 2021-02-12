import javax.swing.*;
import java.util.Vector;

public class Initialization {

    AirlineSystem system;
    private final JComboBox subjectBox,adultsBox,childrensBox,infantsBox,classBox,leavingBox;
    Vector<String> cities = new Vector<>();
    Read_from_File file_read = new Read_from_File();

    public Initialization(AirlineSystem system) {
        this.system=system;
        subjectBox=system.getSubjectBox();
        adultsBox=system.getAdultsBox();
        childrensBox=system.getChildrensBox();
        infantsBox=system.getInfantsBox();
        classBox=system.getClassBox();
        leavingBox=system.getLeavingBox();
        read_data();
    }

    public void read_data() {
        cities.add("");
        file_read.reading_from_file(cities,"all_cities.txt");
    }

    public void setBoxes() {
        subjectBox.addItem("Searchings");
        subjectBox.addItem("Bookings");
        subjectBox.addItem("Prices");
        subjectBox.addItem("Travelling");
        for (int i = 0; i <= 5; i++) {
            adultsBox.addItem(String.valueOf(i));
            childrensBox.addItem(String.valueOf(i));
            infantsBox.addItem(String.valueOf(i));
        }
        adultsBox.setSelectedIndex(1);
        classBox.addItem("Economy");
        classBox.addItem("Premium Economy");
        classBox.addItem("Business");
        classBox.addItem("First Class");
    }


    public void setLeaving() {
        for (String city : cities) {
            leavingBox.addItem(city);
        }
    }

    public void setGoing() {
        int removed = 0;
        String selected = system.getLeavingBox().getSelectedItem().toString();
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).equals(selected)) cities.remove(i);
            removed = i;
        }
        for (String city : cities) {
            system.getGoingBox().addItem(city);
        }
        cities.add(removed, selected);
    }

}
