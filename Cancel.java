import javax.swing.*;

public class Cancel {

    Messages message_window ;
    AirlineSystem system ;
    getUsers users ;
    FillTables tables ;
    JTable onewayreservationsTable,rtreservationsTable;

    public Cancel(AirlineSystem system)
    {
        this.system=system;
        onewayreservationsTable=system.getOnewayreservationsTable();
        rtreservationsTable=system.getRtreservationsTable();
        tables=system.getTables();
        users=system.getUsers();
        message_window=system.getMessage_window();
    }

    public void cancelflight() {
        int user_index=0;
        for (int i = 0; i < users.getUsers().size(); i++) {
            if (system.getCurrentUsername().equals(users.getUsers().get(i).getFirst_name()))
                user_index=i;
        }

        int selected_row = onewayreservationsTable.getSelectedRow();
        if(selected_row !=-1) {
            tables.getConfirmflightsmodel().removeRow(selected_row);
            tables.getTablemodelvec().get(user_index).removeRow(selected_row);
            message_window.information_window("Cancelation successfull!");
        }

        int selected_row_rt = rtreservationsTable.getSelectedRow();

        int first_row;
        int extra_row;
        if(selected_row_rt !=-1) {
            if (tables.getConfirmflightsmodel_rt().getValueAt(selected_row_rt,11) == "")  {
                extra_row=selected_row_rt-1;
                first_row=selected_row_rt-1;
                tables.getConfirmflightsmodel_rt().removeRow(selected_row_rt-1);
            } else {
                extra_row=selected_row_rt+1;
                first_row=selected_row_rt;
                tables.getConfirmflightsmodel_rt().removeRow(selected_row_rt+1);
            }
            tables.getConfirmflightsmodel_rt().removeRow(first_row);
            message_window.information_window("Cancelation successfull!");
            tables.getTablemodelvec_rt().get(user_index).removeRow(extra_row);
            tables.getTablemodelvec_rt().get(user_index).removeRow(first_row);
        }
    }
}
