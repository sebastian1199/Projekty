import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class FillTables {

    AirlineSystem system ;
    getUsers users ;
    SaveRows rows ;
    FillTables tables;
    RandomData data ;

    String[] roundtripcol = new String[]{"Flight", "Airline", "Trip type", "Departing date", "Returning date", "From",
            "To", "Departure", "Arrival", "Duration", "Seats available"};

    String[] ticketscol = new String[]{"Passenger","Flight", "Airline", "Trip type", "Departing date", "Returning date",
            "From", "To", "Departure", "Arrival", "Duration", "Price"};

    String[] col = new String[]{"Flight", "Airline", "Trip type", "Departing date", "Returning date", "From", "To",
            "Departure", "Arrival", "Duration", "Seats available", "Price"};

    int actual_selected_row_oneway=0,actual_selected_row_roundtrip=0,number_of_users=10;
    DefaultTableModel flightsmodel = new DefaultTableModel();
    DefaultTableModel roundtripmodel = new DefaultTableModel();
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    DefaultTableModel confirmflightsmodel = new DefaultTableModel();
    DefaultTableModel confirmflightsmodel_rt = new DefaultTableModel();

    String lastUsername_row_rt = new String();
    String lastUsername_row_oneway = new String();

    Vector<Integer> num_res = new Vector<>();
    Vector<Integer> num_res_rt = new Vector<>();

    JTable flightsTable,roundtripTable,onewayreservationsTable, rtreservationsTable;
    JComboBox leavingBox, goingBox;
    JTextField returningdate,leavingdate;

    Vector<DefaultTableModel> tablemodelvec = new Vector<>();
    Vector<DefaultTableModel> tablemodelvec_rt = new Vector<>();

    public FillTables(AirlineSystem system)
    {
        this.system=system;
        flightsTable=system.getFlightsTable();
        roundtripTable=system.getRoundtripTable();
        onewayreservationsTable=system.getOnewayreservationsTable();
        leavingBox=system.getLeavingBox();
        goingBox=system.getGoingBox();
        returningdate=system.getReturningdate();
        rtreservationsTable=system.getRtreservationsTable();
        leavingdate=system.getLeavingdate();
        data=system.getData();
        users=system.getUsers();
        tables=system.getTables();
        rows=system.getSave_rows();
        num_res.setSize(number_of_users);
        num_res_rt.setSize(number_of_users);
        tablemodelvec.setSize(number_of_users);
        tablemodelvec_rt.setSize(number_of_users);
        for(int i=0;i<number_of_users;i++) {
            num_res.set(i,0);
            num_res_rt.set(i,0);
            tablemodelvec.set(i, new DefaultTableModel());
            tablemodelvec_rt.set(i,new DefaultTableModel());
        }
    }

    public void flightstableSettings() {
        flightsmodel.setColumnIdentifiers(col);
        flightsTable.setModel(flightsmodel);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        int index = (int) (Math.random() * 50 + 10);
        for (int i = 0; i < index; i++) {
            String departure_Time = data.setDepartureTime();
            String arrival_Time = data.setArrivalTime(departure_Time);
            String departingdate = getdepartingdate();
            flightsmodel.addRow(new Object[]{data.generateRandomAirlines(), data.generateRandomAirline(leavingBox),
                    system.getTrip(), departingdate, data.getreturningdate(departingdate, departure_Time, arrival_Time),
                    leavingBox.getSelectedItem(), goingBox.getSelectedItem(), departure_Time, arrival_Time,
                    data.setDuration(departure_Time,arrival_Time), data.setSeats(), data.set_final_price()});
        }

        for (int i = 0; i < col.length; i++) {
            system.getFlightsTable().getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }


    public void fillroundtriptable() {
        roundtripmodel.setColumnIdentifiers(roundtripcol);
        roundtripTable.setModel(roundtripmodel);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        int index = (int) (Math.random() * 25 + 5);
        for (int i = 0; i < index; i++) {
            String departure_Time =data.setDepartureTime();
            String arrival_Time = data.setArrivalTime(departure_Time);
            String departing_date = returningdate.getText();
            roundtripmodel.addRow(new Object[]{data.generateRandomAirlines(), data.generateRandomAirline(goingBox),
                    system.getTrip(), departing_date, data.getreturningdate(departing_date, departure_Time,
                    arrival_Time),goingBox.getSelectedItem(),leavingBox.getSelectedItem(), departure_Time,
                    arrival_Time, data.setDuration(departure_Time, arrival_Time), data.setSeats()});
        }

        for (int i = 0; i < roundtripcol.length; i++) {
            roundtripTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }


    public void fill_confirmation_model(DefaultTableModel model,JTable table,int passenger_index,int username_index,
                                   Vector<String> passengers_vec,Vector<Vector<Integer>> rows_vec,
                                        int actual_selected_row) {
        String last_column ;
        if(actual_selected_row_roundtrip%2!=0) last_column="";
        else last_column=Double.toString(data.ticketprice(passenger_index));

        model.addRow(new Object[]{passengers_vec.get(passenger_index),
                table.getModel().getValueAt(rows_vec.get(username_index).get(actual_selected_row), 0),
                table.getModel().getValueAt(rows_vec.get(username_index).get(actual_selected_row), 1),
                table.getModel().getValueAt(rows_vec.get(username_index).get(actual_selected_row), 2),
                table.getModel().getValueAt(rows_vec.get(username_index).get(actual_selected_row), 3),
                table.getModel().getValueAt(rows_vec.get(username_index).get(actual_selected_row), 4),
                table.getModel().getValueAt(rows_vec.get(username_index).get(actual_selected_row), 5),
                table.getModel().getValueAt(rows_vec.get(username_index).get(actual_selected_row), 6),
                table.getModel().getValueAt(rows_vec.get(username_index).get(actual_selected_row), 7),
                table.getModel().getValueAt(rows_vec.get(username_index).get(actual_selected_row), 8),
                table.getModel().getValueAt(rows_vec.get(username_index).get(actual_selected_row), 9),
                last_column, 11});
    }


    public void fill_confirmation_Table(DefaultTableModel confirm_model,JTable table,Vector<Integer> num_res) {
        confirm_model.setColumnIdentifiers(ticketscol);
        table.setModel(confirm_model);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        int index = 0;
        int indexusername = 0;

        for (int i = 0; i < users.getUsers().size(); i++) {
            if (system.getCurrentUsername().equals(users.getUsers().elementAt(i).getUsername())) {
                if(system.getTrip().equals("One-way"))
                index = rows.getNumber_of_reservations().get(i);
                else {
                    index=rows.getNumber_of_reservations_rt().get(i)/2;
                }
                indexusername = i;
            }
        }

        int passengers_index=0;

        if(!lastUsername_row_oneway.equals(system.getCurrentUsername())) actual_selected_row_oneway=0;
        if(!lastUsername_row_rt.equals(system.getCurrentUsername())) actual_selected_row_roundtrip=0;

        for (int i = num_res.get(indexusername); i < index; i++) {
            actual_selected_row_roundtrip=0;

            if(system.getTrip().equals("One-way"))
            fill_confirmation_model(confirm_model,flightsTable,passengers_index,indexusername,system.getPassengersvec(),
                    rows.getRowsvec(), actual_selected_row_oneway);
            else {
                fill_confirmation_model(confirm_model,flightsTable, passengers_index, indexusername,
                        system.getPassengersvec_roundtrip(), rows.getRowsvec_rt(),actual_selected_row_roundtrip);

                actual_selected_row_roundtrip++;

                fill_confirmation_model(confirm_model, roundtripTable, passengers_index, indexusername,
                        system.getPassengersvec_roundtrip(), rows.getRowsvec_rt(),actual_selected_row_roundtrip);
            }
            passengers_index++;
        }
        if(system.getTrip().equals("One-way")) {
            actual_selected_row_oneway++;
            lastUsername_row_oneway = system.getCurrentUsername();
        }
        else lastUsername_row_rt=system.getCurrentUsername();

        for (int i = 0; i < col.length; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        num_res.set(indexusername, index);
    }


    public void fill_again_confirmation_table(int userindex,Vector<DefaultTableModel> tablemodelvec,
                                              DefaultTableModel model) {
        tablemodelvec.get(userindex).setColumnIdentifiers(ticketscol);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        tablemodelvec.get(userindex).setRowCount(0);
        for (int i = 0; i < model.getRowCount(); i++) {
            tablemodelvec.get(userindex).addRow(new Object[]{model.getValueAt(i, 0), model.getValueAt(i, 1),
                    model.getValueAt(i, 2), model.getValueAt(i, 3),
                    model.getValueAt(i, 4), model.getValueAt(i, 5),
                    model.getValueAt(i, 6), model.getValueAt(i, 7),
                    model.getValueAt(i, 8), model.getValueAt(i, 9),
                    model.getValueAt(i, 10), model.getValueAt(i, 11),
            });
        }
    }

    public void fill_after_logout() {
        for (int r = 0; r < users.getUsers().size(); r++) {
            if (users.getUsers().get(r).getUsername().equals(system.getCurrentUsername()))
                if(system.getLogged_out().get(r).equals(true)) {

                    for (int p = 0; p < tablemodelvec.get(r).getRowCount(); p++) {
                        confirmflightsmodel.insertRow(p, new Object[]{tablemodelvec.get(r).getValueAt(p, 0),
                                tablemodelvec.get(r).getValueAt(p, 1), tablemodelvec.get(r).getValueAt(p, 2),
                                tablemodelvec.get(r).getValueAt(p, 3), tablemodelvec.get(r).getValueAt(p, 4),
                                tablemodelvec.get(r).getValueAt(p, 5), tablemodelvec.get(r).getValueAt(p, 6),
                                tablemodelvec.get(r).getValueAt(p, 7), tablemodelvec.get(r).getValueAt(p, 8),
                                tablemodelvec.get(r).getValueAt(p, 9), tablemodelvec.get(r).getValueAt(p, 10)
                                , tablemodelvec.get(r).getValueAt(p, 11),});
                    }

                    for (int k = 0; k < tablemodelvec_rt.get(r).getRowCount(); k++) {
                        confirmflightsmodel_rt.insertRow(k, new Object[]{tablemodelvec_rt.get(r).getValueAt(k, 0),
                                tablemodelvec_rt.get(r).getValueAt(k, 1), tablemodelvec_rt.get(r).getValueAt(k, 2),
                                tablemodelvec_rt.get(r).getValueAt(k, 3), tablemodelvec_rt.get(r).getValueAt(k, 4),
                                tablemodelvec_rt.get(r).getValueAt(k, 5), tablemodelvec_rt.get(r).getValueAt(k, 6),
                                tablemodelvec_rt.get(r).getValueAt(k, 7), tablemodelvec_rt.get(r).getValueAt(k, 8),
                                tablemodelvec_rt.get(r).getValueAt(k, 9), tablemodelvec_rt.get(r).getValueAt(k, 10)
                                , tablemodelvec_rt.get(r).getValueAt(k, 11),});
                    }
                }
        }
    }

    public void settablevec() {
        for (int i = 0; i < users.getUsers().size(); i++) {
            if (users.getUsers().get(i).getUsername().equals(system.getCurrentUsername()))
                fill_again_confirmation_table(i,tablemodelvec,confirmflightsmodel);
        }
    }

    public void settablevec_rt() {
        for (int i = 0; i < users.getUsers().size(); i++) {
            if (users.getUsers().get(i).getUsername().equals(system.getCurrentUsername()))
                fill_again_confirmation_table(i,tablemodelvec_rt,confirmflightsmodel_rt);
        }
    }


    public String getdepartingdate() { return leavingdate.getText(); }
    public DefaultTableModel getFlightsmodel() { return flightsmodel; }
    public String[] getCol() { return col; }
    public DefaultTableModel getRoundtripmodel() { return roundtripmodel; }
    public DefaultTableModel getConfirmflightsmodel() { return confirmflightsmodel; }
    public DefaultTableModel getConfirmflightsmodel_rt() { return confirmflightsmodel_rt; }
    public Vector<DefaultTableModel> getTablemodelvec() { return tablemodelvec; }
    public Vector<DefaultTableModel> getTablemodelvec_rt() { return tablemodelvec_rt; }
    public JTable getOnewayreservationsTable(){return onewayreservationsTable;}
    public JTable getRtreservationsTable(){return rtreservationsTable;}
    public Vector<Integer> getNum_res(){return num_res;}
    public Vector<Integer> getNum_res_rt(){return num_res_rt;}
}
