import javax.swing.*;

public class Verification {

    AirlineSystem system;
    JTextField leavingdate,returningdate,blikTextField,cardnameField,cardnumberField,mmyycardField,CVCfield;
    String trip ;

    public Verification(AirlineSystem system)
    {
        this.system=system;
        leavingdate=system.getLeavingdate();
        returningdate = system.getReturningdate();
        blikTextField=system.getBlikTextField();
        cardnameField=system.getCardnameField();
        cardnumberField=system.getCardnumberField();
        mmyycardField=system.getMmyycardField();
        CVCfield=system.getCVCfield();
        trip=system.getTrip();
    }


    public Boolean checkdates() {
        String actual_date = java.time.LocalDate.now().toString();
        int actual_day = Integer.parseInt(actual_date.substring(8, 10));
        int actual_month = Integer.parseInt(actual_date.substring(5, 7));
        int actual_year = Integer.parseInt(actual_date.substring(0, 4));

        String departing_date = leavingdate.getText();

        int day_index = departing_date.indexOf("/");
        int month_index = departing_date.lastIndexOf("/");
        String departing_day = departing_date.substring(0, day_index);
        String departing_month = departing_date.substring(day_index + 1, month_index);
        String departing_year = departing_date.substring(month_index + 1);

        if(departing_date.length()<10) return false;

        for(int i=0;i<departing_day.length();i++) {
            if(Character.isLetter(departing_day.charAt(i)) || Character.isLetter(departing_month.charAt(i)) ||
                    Character.isLetter(departing_year.charAt(i))) return false;
        }

        for(int k=0;k<departing_year.length();k++) {
            if(Character.isLetter(departing_year.charAt(k))) return false;
        }

        int dep_day = Integer.parseInt(departing_day);
        int dep_month = Integer.parseInt(departing_month);
        int dep_year = Integer.parseInt(departing_year);

        if (trip.equals("Roundtrip")) {
            String returning_date = returningdate.getText();

            int r_day_index = returning_date.indexOf("/");
            String returning_day = returning_date.substring(0, r_day_index);
            int r_month_index = returning_date.lastIndexOf("/");
            String returning_month = returning_date.substring(r_day_index + 1, r_month_index);
            String returning_year = returning_date.substring(r_month_index + 1);

            for(int i=0;i<returning_day.length();i++) {
                if(Character.isLetter(returning_day.charAt(i)) || Character.isLetter(returning_month.charAt(i)) ||
                        Character.isLetter(returning_year.charAt(i))) return false;
            }

            for(int k=0;k<returning_year.length();k++) {
                if(Character.isLetter(returning_year.charAt(k))) return false;
            }

            if(returning_date.length()<10) return false;

            int ret_day = Integer.parseInt(returning_day);
            int ret_month = Integer.parseInt(returning_month);
            int ret_year = Integer.parseInt(returning_year);

            if(ret_day<dep_day && ret_month == dep_month) return false;
            else if(ret_month<dep_month && ret_year == dep_year) return false;
            else if(ret_day>31 || ret_month >12 || ret_year<dep_year) return false;

        }

        if(dep_day<actual_day && dep_month == actual_month) return false;
        else if(dep_month<actual_month && dep_year == actual_year) return false;
        else if(dep_day>31 || dep_month >12 || dep_year<actual_year) return false;

        return true;
    }

    public Boolean checkcardpayment() {
        if (cardnameField.getText().equals("") || cardnumberField.getText().equals("") ||
                mmyycardField.getText().equals("") || CVCfield.getText().equals("")) return false;

        if (cardnumberField.getText().length() != 16 || cardnumberField.getText().equals("16 Numbers")
                || mmyycardField.getText().length() != 5 || mmyycardField.getText().equals("MM/YY") ||
                CVCfield.getText().length() != 3 || CVCfield.getText().equals("XXX")) return false;

        for (int i = 0; i < cardnumberField.getText().length(); i++) {
            if (Character.isLetter(cardnumberField.getText().charAt(i))) return false;
        }

        for (int p = 0; p < CVCfield.getText().length(); p++) {
            if (Character.isLetter(CVCfield.getText().charAt(p))) return false;
        }

        String expiration_date = mmyycardField.getText();
        if (expiration_date.charAt(2) != '/') return false;

        return true;
    }

    public Boolean checkblikpayment() {
        String blik_text =blikTextField.getText();
        if (blik_text.equals("") || blik_text.length() != 6 ||
                blik_text.equals("******")) return false;

        for (int i = 0; i < blik_text.length(); i++) {
            if (Character.isLetter(blik_text.charAt(i))) return false;
        }

        return true;
    }

}
