import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Filtration {

    AirlineSystem system;
    Messages message_window = new Messages();
    DefaultTableModel previous_model = new DefaultTableModel();
    private FillTables tables ;
    JTextField minPriceField,maxPriceField;

    public Filtration(AirlineSystem system)
    {
        this.system=system;
        minPriceField=system.getMinPriceField();
        maxPriceField=system.getMaxPriceField();
        tables=system.getTables();
    }

    public void filtration()
    {
        int min_price=0,max_price=0;
        if(!minPriceField.getText().equals(""))
            min_price = Integer.parseInt(minPriceField.getText());
        if(!maxPriceField.getText().equals(""))
            max_price = Integer.parseInt(maxPriceField.getText());

        if(minPriceField.getText().equals("") && maxPriceField.getText().equals("")){
            message_window.information_window("Set a minimum or maximum price");
            return;
        }

        if(maxPriceField.getText().equals("")) {
            for (int i = 0; i < tables.getFlightsmodel().getRowCount(); i++) {
                if (Integer.parseInt(tables.getFlightsmodel().getValueAt(i, 11).toString()) < min_price) {
                    tables.getFlightsmodel().removeRow(i);
                    i=0;
                }
            }
        }

        else if(minPriceField.getText().equals(""))
        {
            for (int i = 0; i < tables.getFlightsmodel().getRowCount(); i++) {
                if (Integer.parseInt(tables.getFlightsmodel().getValueAt(i, 11).toString()) > max_price) {
                    tables.getFlightsmodel().removeRow(i);
                    i=0;
                }

            }
        }

        else {
            for (int i = 0; i < tables.getFlightsmodel().getRowCount(); i++) {
                if (Integer.parseInt(tables.getFlightsmodel().getValueAt(i, 11).toString()) > max_price ||
                        Integer.parseInt(tables.getFlightsmodel().getValueAt(i, 11).toString()) < min_price) {
                    tables.getFlightsmodel().removeRow(i);
                    i=0;
                }
            }
        }
    }


    public void copy_model()
    {
        previous_model.setColumnIdentifiers(tables.getCol());
        previous_model.setRowCount(0);
        for (int i = 0; i < tables.getFlightsmodel().getRowCount(); i++) {
            previous_model.addRow(new Object[]{tables.getFlightsmodel().getValueAt(i, 0),
                    tables.getFlightsmodel().getValueAt(i, 1), tables.getFlightsmodel().getValueAt(i, 2),
                    tables.getFlightsmodel().getValueAt(i, 3), tables.getFlightsmodel().getValueAt(i, 4),
                    tables.getFlightsmodel().getValueAt(i, 5), tables.getFlightsmodel().getValueAt(i, 6),
                    tables.getFlightsmodel().getValueAt(i, 7), tables.getFlightsmodel().getValueAt(i, 8),
                    tables.getFlightsmodel().getValueAt(i, 9), tables.getFlightsmodel().getValueAt(i, 10),
                    tables.getFlightsmodel().getValueAt(i,11)});
        }
    }

    public void restore_rows()
    {
        for (int i = 0; i < previous_model.getRowCount(); i++) {
            tables.getFlightsmodel().addRow(new Object[]{previous_model.getValueAt(i, 0),
                    previous_model.getValueAt(i, 1), previous_model.getValueAt(i, 2),
                    previous_model.getValueAt(i, 3), previous_model.getValueAt(i, 4),
                    previous_model.getValueAt(i, 5), previous_model.getValueAt(i, 6),
                    previous_model.getValueAt(i, 7), previous_model.getValueAt(i, 8),
                    previous_model.getValueAt(i, 9), previous_model.getValueAt(i, 10),
                    previous_model.getValueAt(i,11)});
        }
    }

    public void clear_filtration()
    {
       minPriceField.setText("");
        maxPriceField.setText("");
    }

}
