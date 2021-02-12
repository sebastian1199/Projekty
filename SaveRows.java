import java.util.Vector;

public class SaveRows {

    Passengers passengers ;
    Messages message_window;
    getUsers users ;
    AirlineSystem system ;

    Vector<Integer> actualrows = new Vector<>();
    Vector<Integer> actualrows_rt = new Vector<>();
    int actual_rows_index = 0,actual_rows_index_roundtrip = 0;
    int flightvalue = 0, last_index = 0,flightvalue_rt = 0;
    int number_of_users=10;
    Vector<Vector<Integer>> rowsvec = new Vector<>();
    Vector<Vector<Integer>> rowsvec_rt = new Vector<>();
    Vector<Integer> number_of_reservations = new Vector<>();
    Vector<Integer> number_of_reservations_rt = new Vector<>();

    String lastUsername = new String();
    String lastUsername_rt = new String();


    public SaveRows(AirlineSystem system)
    {
        this.system=system;
        passengers= system.getPassengers();
        users= system.getUsers();
        message_window= system.getMessage_window();
        rowsvec_rt.setSize(number_of_users);
        rowsvec.setSize(number_of_users);
        number_of_reservations.setSize(number_of_users);
        number_of_reservations_rt.setSize(number_of_users);
        for(int i=0;i<number_of_users;i++) {
            number_of_reservations.set(i, 0);
            number_of_reservations_rt.set(i, 0);
        }
    }

    public void informations_update(Vector<Integer> actual_rows,Vector<Vector<Integer>> rows,Integer index,
                                  Vector<Integer> number_of_reservations,Integer flight_value,String last_username) {

        int sum_passengers = passengers.passengers_sum();
        int extra_value;

        if(system.getTrip().equals("One-way")) extra_value = sum_passengers;
        else extra_value=sum_passengers*2;

        if (!last_username.equals(system.getCurrentUsername())) {
            actual_rows.clear();
            actual_rows.setSize(10);
            for (int i = 0; i < users.getUsers().size(); i++) {
                if (system.getCurrentUsername().equals(users.getUsers().get(i).getUsername())) {
                    if (rows.get(i) == null) index = 0;
                    else index = rows.get(i).size();

                    if (number_of_reservations.get(i) != 0) {
                        flight_value = number_of_reservations.get(i);
                        flight_value+=extra_value;
                        number_of_reservations.set(i,flight_value);
                    } else {
                        flight_value = 0;
                        flight_value+=extra_value;
                        number_of_reservations.set(i, flight_value);
                    }
                    last_index = i;
                }
            }
            if(system.getTrip().equals("One-way")) actual_rows.set(index++, system.getSelected_row_oneway());
            else {
                actual_rows.set(index++, system.getSelected_row_oneway());
                actual_rows.set(index++, system.getSelected_row_roundtrip());
            }
        } else {
            flight_value+=extra_value;
            number_of_reservations.set(last_index, flight_value);
            if(system.getTrip().equals("One-way")) actual_rows.set(index++, system.getSelected_row_oneway());
            else{
                actual_rows.set(index, system.getSelected_row_oneway());
                actual_rows.set(index, system.getSelected_row_roundtrip());
            }
        }
        rows.set(last_index, actual_rows);
        if(system.getTrip().equals("One-way")) lastUsername = system.getCurrentUsername();
        else lastUsername_rt= system.getCurrentUsername();
        message_window.information_window("Ticked booked!");
    }


    public Vector<Vector<Integer>> getRowsvec() { return rowsvec; }
    public Vector<Vector<Integer>> getRowsvec_rt() { return rowsvec_rt; }
    public Vector<Integer> getNumber_of_reservations() { return number_of_reservations; }
    public Vector<Integer> getNumber_of_reservations_rt() { return number_of_reservations_rt; }
    public Vector<Integer> getActualrows(){ return actualrows;}
    public Vector<Integer> getActualrows_rt(){return actualrows_rt;}
    public int getActual_rows_index(){return actual_rows_index;}
    public int getActual_rows_index_roundtrip(){return actual_rows_index_roundtrip;}
    public int getFlightvalue(){return flightvalue;}
    public int getFlightvalue_rt(){return flightvalue_rt;}
    public String getLastUsername(){return lastUsername;};
    public String getLastUsername_rt(){return lastUsername_rt;}

}
