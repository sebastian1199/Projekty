import javax.swing.*;
import java.util.Objects;
import java.util.Vector;

    public class RandomData {
    AirlineSystem system ;
    private JComboBox LeavingBox,GoingBox,ClassBox;
    private JTable flightstable ;
    Passengers passengers ;
    Read_from_File file_read = new Read_from_File();

    Vector<String> American_cities = new Vector<>();
    Vector<String> Asian_cities = new Vector<>();
    Vector<String> European_cities = new Vector<>();
    Vector<String> American_Airlines = new Vector<>();
    Vector<String> Asian_Airlines = new Vector<>();
    Vector<String> European_Airlines = new Vector<>();

    public RandomData(AirlineSystem system) {
        this.system=system;
        LeavingBox=system.getLeavingBox();
        GoingBox=system.getGoingBox();
        ClassBox=system.getClassBox();
        flightstable=system.getFlightsTable();
        passengers= system.getPassengers();
        read_data_from_file();
    }

    public void read_data_from_file() {
        file_read.reading_from_file(American_cities,"American_cities.txt");
        file_read.reading_from_file(Asian_cities,"Asian_cities.txt");
        file_read.reading_from_file(European_cities,"European_cities.txt");
        file_read.reading_from_file(American_Airlines,"American_Airlines.txt");
        file_read.reading_from_file(Asian_Airlines,"Asian_Airlines.txt");
        file_read.reading_from_file(European_Airlines,"European_Airlines.txt");
    }

    public int generateRandomAirlines() {
        return (int) (Math.random() * 999 + 100);
    }

    public String generateRandomAirline(JComboBox box) {
        for (String americacity : American_cities) {
            if (Objects.requireNonNull(box.getSelectedItem()).toString().equals(americacity))
                return American_Airlines.get((int) (Math.random() * American_Airlines.size() - 1));
        }
        for (String europecity : European_cities) {
            if (Objects.requireNonNull(box.getSelectedItem()).toString().equals(europecity))
                return European_Airlines.get((int) (Math.random() * European_Airlines.size() - 1));
        }
        for (String asiacity : Asian_cities) {
            if (Objects.requireNonNull(box.getSelectedItem()).toString().equals(asiacity))
                return Asian_Airlines.get((int) (Math.random() * Asian_Airlines.size() - 1));
        }
        return "";
    }

    public int set_price(int low, int up) {
        String selected_class = ClassBox.getSelectedItem().toString();
        int price1 = (int) ((Math.random() * (up - low)) + low);
        int price2 = price1 - price1 % 5;
        if (selected_class.equals("Premium Economy")) return (int) (price2 * 1.4);
        else if (selected_class.equals("First Class")) return (price2 * 2);
        else if (selected_class.equals("Business Class")) return (int) (price2 * 1.8);
        else return price2;
    }

    public int set_final_price() {
        int trip_type = 1;
        if (system.getTrip().equals("Roundtrip")) trip_type = 2;
        for (String a : American_cities) {
            for (String b : European_cities) {
                for (String c : Asian_cities) {
                    if ((LeavingBox.getSelectedItem().toString().equals(a) && GoingBox.getSelectedItem().toString().equals(b))
                            || (LeavingBox.getSelectedItem().toString().equals(b) && GoingBox.getSelectedItem().toString().equals(a)))
                        return trip_type * set_price(300, 500);
                    else if ((LeavingBox.getSelectedItem().toString().equals(a) && GoingBox.getSelectedItem().toString().equals(c))
                            || (LeavingBox.getSelectedItem().toString().equals(c) && GoingBox.getSelectedItem().toString().equals(a)))
                        return trip_type * set_price(500, 700);
                    else if ((LeavingBox.getSelectedItem().toString().equals(b) && GoingBox.getSelectedItem().toString().equals(c))
                            || (LeavingBox.getSelectedItem().toString().equals(c) && GoingBox.getSelectedItem().toString().equals(a)))
                        return trip_type * set_price(100, 300);
                }
            }
        }
        return trip_type * set_price(100, 200);
    }


    public String setDepartureTime() {
        int hour = (int) ((Math.random() * (23 - 6)) + 6);
        int minutes1 = (int) (Math.random() * (55 + 1));
        int minutes2 = minutes1 - minutes1 % 5 ;
        if (minutes2 < 10) return hour + ":" + 0 + minutes2;
        else return hour + ":" + minutes2;
    }

    public int setSeats() {
        return (int) (Math.random() * 400 + 1);
    }

    public String setArrivalTime(String Departuretime) {
        int Arrivalminutes1 = (int) ((Math.random() * (55 - 1)) + 1);
        int Arrivalminutes2 = Arrivalminutes1 - Arrivalminutes1 % 5;
        int ArrivalHour = (int) ((Math.random() * (4 - 3)) + 3);
        for (String a : American_cities) {
            for (String b : European_cities) {
                for (String c : Asian_cities) {
                    if ((LeavingBox.getSelectedItem().toString().equals(a) && GoingBox.getSelectedItem().toString().equals(b))
                            || (LeavingBox.getSelectedItem().toString().equals(b) && GoingBox.getSelectedItem().toString().equals(a)))
                        ArrivalHour = (int) ((Math.random() * (7 - 4)) + 4);
                    else if ((LeavingBox.getSelectedItem().toString().equals(a) && GoingBox.getSelectedItem().toString().equals(c))
                            || (LeavingBox.getSelectedItem().toString().equals(c) && GoingBox.getSelectedItem().toString().equals(a)))
                        ArrivalHour = (int) ((Math.random() * (12 - 7)) + 7);
                    else if ((LeavingBox.getSelectedItem().toString().equals(b) && GoingBox.getSelectedItem().toString().equals(c))
                            || (LeavingBox.getSelectedItem().toString().equals(c) && GoingBox.getSelectedItem().toString().equals(a)))
                        ArrivalHour = (int) ((Math.random() * (4 - 3)) + 3);
                }
            }
        }
        String digit;
        if (Character.isDigit(Departuretime.charAt(1))) digit = Departuretime.substring(0, 2);
        else digit = Departuretime.substring(0, 1);

        ArrivalHour += Integer.parseInt(digit);

        if (ArrivalHour >= 24) ArrivalHour -= 24;
        if (Arrivalminutes2 < 10) return ArrivalHour + ":" + 0 + Arrivalminutes2;
        else return ArrivalHour + ":" + Arrivalminutes2;
    }


    public String setDuration(String DepartureTime, String ArrivalTime) {
        int departureHours, arrivalHours;
        int departureMinutes, arrivalMinutes;
        if (Character.isDigit(DepartureTime.charAt(0)) && Character.isDigit(DepartureTime.charAt(1))) {
            departureHours = Integer.parseInt(DepartureTime.substring(0, 2));
            departureMinutes = Integer.parseInt(DepartureTime.substring(3, 5));
        } else {
            departureHours = Integer.parseInt(DepartureTime.substring(0, 1));
            departureMinutes = Integer.parseInt(DepartureTime.substring(2, 4));
        }
        if (Character.isDigit(ArrivalTime.charAt(0)) && Character.isDigit(ArrivalTime.charAt(1))) {
            arrivalHours = Integer.parseInt(ArrivalTime.substring(0, 2));
            arrivalMinutes = Integer.parseInt(ArrivalTime.substring(3, 5));
        } else {
            arrivalHours = Integer.parseInt(ArrivalTime.substring(0, 1));
            arrivalMinutes = Integer.parseInt(ArrivalTime.substring(2, 4));
        }
        int hours = arrivalHours - departureHours;
        if (hours < 0) hours = arrivalHours + (24 - departureHours);
        int minutes = arrivalMinutes + (60 - departureMinutes);
        if (hours == 1 && arrivalMinutes < departureMinutes) hours -= 1;
        if (minutes > 55) {
            minutes -= 60;
        }
        if(arrivalMinutes<departureMinutes) hours-=1;
        String duration = hours + ":" + minutes;
        if (minutes == 0) {
            int indexReplaced = duration.lastIndexOf("0");
            duration = duration.substring(0, indexReplaced - 1);
        }
        if (minutes < 10) {
            duration = hours + ":" + 0 + minutes;
        }
        return duration;
    }


    public String getreturningdate(String departingdate, String dTime, String aTime) {
        int dHour, aHour;
        if (Character.isDigit(dTime.charAt(1))) dHour = Integer.parseInt(dTime.substring(0, 2));
        else dHour = Integer.parseInt(dTime.substring(0, 1));
        if (Character.isDigit(aTime.charAt(1))) aHour = Integer.parseInt(aTime.substring(0, 2));
        else aHour = Integer.parseInt(aTime.substring(0, 1));

        int departingday = Integer.parseInt(departingdate.substring(0, 2));
        int departingmonth = Integer.parseInt(departingdate.substring(3, 5));
        int departingyear = Integer.parseInt(departingdate.substring(6, 10));

        if (dHour > aHour) departingday++;
        if (departingday > 31) {
            departingday -= 31;
            departingmonth++;
        }
        if (departingmonth > 12) {
            departingmonth -= 12;
            departingyear++;
        }

        String returningday = String.valueOf(departingday);
        String returningmonth = String.valueOf(departingmonth);
        String returningyear = String.valueOf(departingyear);

        if (departingday < 10) returningday = "0" + returningday;
        if (departingmonth < 10) returningmonth = "0" + returningmonth;

        return returningday + "/" + returningmonth + "/" + returningyear;
    }


        public int setpriceadult(int row) {
            return Integer.parseInt(flightstable.getValueAt(row, 11).toString());
        }

        public double setpricechildren(int row)
        {
            return Integer.parseInt(flightstable.getValueAt(row, 11).toString()) *0.7;
        }

        public double setpriceinfants(int row)
        {
            return Integer.parseInt(flightstable.getValueAt(row, 11).toString()) *0.4;
        }


    public double ticketprice(int i) {
        double ticket_price;
        Vector<String> passengeres_vec;
        if(system.getTrip().equals("One-way")) passengeres_vec=system.getPassengersvec();
        else passengeres_vec=system.getPassengersvec_roundtrip();
        if(passengeres_vec.get(i).equals("Adult")) ticket_price=setpriceadult(system.getSelected_row_oneway());
        else if(passengeres_vec.get(i).equals("Children")) ticket_price=setpricechildren(system.getSelected_row_oneway());
        else ticket_price=setpriceinfants(system.getSelected_row_oneway());
        ticket_price-=ticket_price%1;
        return ticket_price;
    }

    public double price_sum()
    {
        return passengers.getAdults()*setpriceadult(system.getSelected_row_oneway())+passengers.getChildrens()*setpricechildren(system.getSelected_row_oneway())+
                passengers.getInfants()*setpriceinfants(system.getSelected_row_oneway());
    }
}
