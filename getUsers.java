import javax.swing.*;
import java.util.Arrays;
import java.util.Vector;

public class getUsers {

    AirlineSystem system ;
    Messages message_window ;
    FillTables tables ;

    String lastUsername_row_rt;
    String lastUsername_row_oneway ;

    Vector<User> users = new Vector<>();

    private final JTextField usernameField,fnameField,lnameField,phoneText,mailText,firstnamefield,lastnamefield,
    phonenumberfield,emailfield,passwordfield,confirmnewpassTextField,usernamefield;
    Boolean newpassword;
    private final JRadioButton maleRadioButton,settingsmaleButton, settingsfemaleButton;
    private final JPasswordField regpassLabel;
    private final JComboBox dayComboBox,monthComboBox,yearComboBox,daySettingsBox,monthSettingsBox,yearSettingBox,userComboBox;
    private final JLabel confirmnewpassLabel;

    public getUsers(AirlineSystem system)
    {
    this.system=system;
    usernameField=system.getUsernameField();
    usernamefield=system.getUsernamefield();
    fnameField=system.getFnameField();
    lnameField=system.getlnameField();
    phoneText=system.getPhoneText();
    mailText=system.getMailText();
    maleRadioButton=system.getMaleRadioButton();
    regpassLabel=system.getRegpassLabel();
    dayComboBox=system.getDayComboBox();
    monthComboBox=system.getMonthComboBox();
    yearComboBox=system.getYearComboBox();
    firstnamefield=system.getFirstnamefield();
    lastnamefield=system.getLastnamefield();
    phonenumberfield=system.getPhonenumberfield();
    emailfield=system.getEmailfield();
    passwordfield=system.getPasswordfield();
    confirmnewpassTextField=system.getConfirmnewpassTextField();
    daySettingsBox=system.getDaySettingsBox();
    monthSettingsBox=system.getMonthSettingsBox();
    yearSettingBox=system.getYearSettingBox();
    settingsmaleButton=system.getSettingsmaleButton();
    settingsfemaleButton=system.getSettingsfemaleButton();
    confirmnewpassLabel=system.getConfirmnewpassLabel();
    userComboBox=system.getUserComboBox();
    tables= system.getTables();
    newpassword=system.getNewpassword();
    message_window=system.getMessage_window();
    }

    public void getInformationfromRegister() {
        String gender;
        if(maleRadioButton.isSelected()) gender="male";
        else gender="female";

        users.add(new User(usernameField.getText(),fnameField.getText(),lnameField.getText(),Integer.parseInt(phoneText.getText()),
                mailText.getText(),regpassLabel.getText(),gender,Integer.parseInt(dayComboBox.getSelectedItem().toString()),
                monthComboBox.getSelectedItem().toString(),Integer.parseInt(yearComboBox.getSelectedItem().toString())));
    }

    public void setfieldsSettings(int index) {
        usernamefield.setText(users.get(index).getUsername());
        firstnamefield.setText(users.get(index).getFirst_name());
        lastnamefield.setText(users.get(index).getLast_name());
        phonenumberfield.setText(String.valueOf(users.get(index).getPhone_number()));
        emailfield.setText(users.get(index).getEmail());
        passwordfield.setText(users.get(index).getPassword());
        if (users.get(index).getGender().equals("male")) settingsmaleButton.setSelected(true);
        else settingsfemaleButton.setSelected(true);
        daySettingsBox.setSelectedItem(users.get(index).getDay_of_birth());
        monthSettingsBox.setSelectedItem(users.get(index).getMonth_of_birth());
        yearSettingBox.setSelectedItem(users.get(index).getYear_of_birth());
        confirmnewpassLabel.setVisible(false);
        confirmnewpassTextField.setVisible(false);
    }

    public void saveSettings() {
        String user = system.getCurrentUsername();
        int index = 0;
        for (int i = 0; i < users.size(); i++) {
            if (user.equals(users.get(i).getUsername())) {
                index = i;
            }
        }

        if (usernameField.getText().equals("") || firstnamefield.getText().equals("") ||
               lastnamefield.getText().equals("") || phonenumberfield.getText().equals("") ||
                emailfield.getText().equals(""))
            message_window.information_window("One or more fields are empty!");

        else if (!passwordfield.getText().equals(confirmnewpassTextField.getText()) && newpassword.equals(true))
            message_window.information_window("Both passwords must be the same!");

        else if (newpassword.equals(true) && (passwordfield.getText().equals("") ||
                confirmnewpassTextField.getText().equals("")))
            message_window.information_window("One or more fields are empty");

        else {
            String gender;
            if (settingsmaleButton.isSelected()) gender="male";
            else gender="female";

            users.set(index,new User(usernamefield.getText(),firstnamefield.getText(),lastnamefield.getText(),
                    Integer.parseInt(phonenumberfield.getText()),emailfield.getText(),passwordfield.getText(),
                    gender,Integer.parseInt(daySettingsBox.getSelectedItem().toString()),monthSettingsBox.getSelectedItem().toString(),
                    Integer.parseInt(yearSettingBox.getSelectedItem().toString())));

            lastUsername_row_rt=users.get(index).getUsername();
            lastUsername_row_oneway=users.get(index).getUsername();

            message_window.information_window("Changes have been saved");
        }
    }


    public void setUserBox() {
        userComboBox.removeAllItems();
        userComboBox.addItem(system.getCurrentUsername());
        userComboBox.addItem("Reservations");
        userComboBox.addItem("Settings");
        userComboBox.addItem("Log out");
    }


    public void fillUserInformation() {
        String user = userComboBox.getItemAt(0).toString();
        int index = 0;
        for (int i = 0; i < users.size(); i++) {
            if (user.equals(users.get(i).getUsername())) index = i;
        }
       setfieldsSettings(index);
    }


    public void filldate() {
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
            daySettingsBox.addItem(i);
        }

        Vector<String> months = new Vector<>(Arrays.asList("January","February","March","April","May","June",
                "July","August","September","Oktober","November","December"));

        for(String month : months) {
            monthComboBox.addItem(month);
            monthSettingsBox.addItem(month);
        }

        for (int i = 1940; i <= 2020; i++) {
         yearComboBox.addItem(i);
           yearSettingBox.addItem(i);
        }
       yearComboBox.setSelectedIndex(60);
    }

    public Vector<User> getUsers(){return users;}
}
