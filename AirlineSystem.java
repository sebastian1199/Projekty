import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;

public class AirlineSystem extends JPanel {
    private JPanel homePanel;
    private JButton searchButton;
    private JButton homeButton;
    private JButton helpButton;
    private JLabel planeLabel;
    private JButton signButtonTop;
    private JPanel panel0;
    private JPanel planePanel;
    private JPanel loginPanel;
    private JPanel contactPanel;
    private JTextField loginField;
    private JPasswordField passwordField1;
    private JButton LoginButton;
    private JButton registerButton;
    private JPanel registerPanel;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField mailText;
    private JTextField usernameField;
    private JButton createButton;
    private JPasswordField regpassLabel;
    private JPasswordField regpass2Label;
    private JTextField phoneText;
    private JLabel logfailLabel;
    private JLabel usernameLabel2;
    private JPanel searchPanel;
    private JButton sendButton;
    private JCheckBox captchaBox;
    private JTextArea contactTextArea;
    private JComboBox subjectBox;
    private JComboBox adultsBox;
    private JComboBox childrensBox;
    private JComboBox classBox;
    private JComboBox infantsBox;
    private JComboBox leavingBox;
    private JButton onewayButton;
    private JComboBox goingBox;
    private JButton roundtripButton;
    private JPanel flightsPanel;
    private JTable flightsTable;
    private JButton flightsButton;
    private JButton goConfirmButton;
    private JPanel paymentPanel;
    private JRadioButton cardRadioButton;
    private JLabel creditLabel;
    private JTextField cardnameField;
    private JTextField cardnumberField;
    private JPanel paymentoptionsPanel;
    private JPanel cardPanel;
    private JPanel blikPanel;
    private JTextField mmyycardField;
    private JTextField CVCfield;
    private JRadioButton blikRadioButton;
    private JTextField blikTextField;
    private JLabel blikLabel;
    private JComboBox userComboBox;
    private JButton paymentButton;
    private JButton blikButton;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JPanel userSettings;
    private  JTextField usernamefield;
    private JTextField firstnamefield;
    private JTextField lastnamefield;
    private JTextField phonenumberfield;
    private JTextField emailfield;
    private JRadioButton settingsmaleButton;
    private JTextField passwordfield;
    private JRadioButton settingsfemaleButton;
    private JButton saveSettingsButton;
    private JPanel ReservationsPanel;
    private JTable rtreservationsTable;
    private JPanel confirmonewayPanel;
    private JLabel flightnumberLabelright;
    private JLabel airlineLabelright;
    private JLabel tripLabelright;
    private JLabel departingdateright;
    private JLabel fromLabelright;
    private JLabel toLabelright;
    private JLabel departureLabelright;
    private JLabel arrivalLabelright;
    private JLabel durationLabelright;
    private JLabel priceLabelright;
    private JButton goPaymentButton;
    private JTextField leavingdate;
    private JTextField returningdate;
    private JLabel carryonleft;
    private JLabel carryonright;
    private JLabel checkedleft;
    private JLabel checkedright;
    private JButton cancelButton;
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;
    private JComboBox daySettingsBox;
    private JComboBox monthSettingsBox;
    private JComboBox yearSettingBox;
    private JLabel slideshowLabel;
    private JPanel slidePanel;
    private JLabel returningLabel;
    private JLabel returningdateleft;
    private JLabel returningdateright;
    private JLabel purchaseLabel;
    private JCheckBox purchaseleft;
    private JCheckBox purchaseright;
    private JTextField confirmnewpassTextField;
    private JLabel confirmnewpassLabel;
    private JPanel roundtripPanel;
    private JTable roundtripTable;
    private JPanel confirmroundtripPanel;
    private JLabel flightnumberrtleft;
    private JLabel airlinertleft;
    private JLabel triprtleft;
    private JLabel returningdatertleft;
    private JLabel fromrtleft;
    private JLabel tortleft;
    private JLabel departurertleft;
    private JLabel arrivalrtleft;
    private JLabel durationrtleft;
    private JLabel carryonrtleft;
    private JLabel checkedbagrtleft;
    private JLabel flightnumberrtright;
    private JLabel airlinertright;
    private JLabel triprtright;
    private JLabel departingdatertright;
    private JLabel returningdatertright;
    private JLabel fromrtright;
    private JLabel tortright;
    private JLabel departurertright;
    private JLabel arrivalrtright;
    private JLabel durationrtright;
    private JLabel carryonrtright;
    private JLabel checkedbagrtright;
    private JButton gopaymentrtButton;
    private JButton goconfirmrt;
    private JLabel totalpricert;
    private JCheckBox yesbagrtright;
    private JCheckBox nobagrtright;
    private JCheckBox nobagrtleft;
    private JCheckBox yesbagrtleft;
    private JTable onewayreservationsTable;
    private JTextField minPriceField;
    private JTextField maxPriceField;
    private JButton filtrationButton;
    private JButton ResetButton;
    private JLabel departingdatertleft;
    private JLabel nameLabel;
    private final ImageIcon planePicture;
    private final ImageIcon creditPicture,paypalPicture;
    private String currentUsername = new String();
    private Vector<Boolean> logged_out = new Vector<>();
    private int selected_flights = 0;
    private int selected_row_oneway = 0,selected_row_roundtrip = 0;
    private int checked_value = 0;
    private Boolean newpassword = false;
    private int checked_value_roundtrip = 0;
    private String trip = "";
    private final Vector<String> passengersvec = new Vector<>();
    private final Vector<String> passengersvec_roundtrip = new Vector<>();
    private final Messages message_window = new Messages();
    private final Passengers passengers = new Passengers(this);
    private final Verification verification = new Verification(this);
    private final getUsers users= new getUsers(this) ;
    private final SaveRows save_rows = new SaveRows(this);
    private final Slides slide = new Slides(this);
    private final RandomData data= new RandomData(this) ;
    private final FillTables tables = new FillTables(this);
    private final Filtration filtration  = new Filtration(this);
    private final Cancel cancellation = new Cancel(this);
    private final Initialization init = new Initialization(this);
    private final Write_File file = new Write_File(this);
    private int user_index = 0;


    public AirlineSystem() {
        slide.setslideshow();
        set_colors();
        file.creating_a_file();

        planePicture = new ImageIcon(new ImageIcon("plane.jpg").getImage().getScaledInstance(1520, 740,
                Image.SCALE_DEFAULT));
        planeLabel.setIcon(planePicture);
        planeLabel.setText("");
        init.setBoxes();

        creditPicture = new ImageIcon(new ImageIcon("credit.png").getImage().getScaledInstance(200, 20,
                Image.SCALE_DEFAULT));
        creditLabel.setIcon(creditPicture);
        creditLabel.setText("");

        paypalPicture = new ImageIcon(new ImageIcon("blik.png").getImage().getScaledInstance(80, 35,
                Image.SCALE_DEFAULT));
        blikLabel.setIcon(paypalPicture);
        blikLabel.setText("");

        users.filldate();

        logged_out.setSize(10);
        for(int i=0;i<logged_out.size();i++) {
            logged_out.set(i,false);
        }

        signButtonTop.addActionListener(e -> {
            loginClear();
            showPanel(loginPanel);
        });

        userComboBox.setVisible(false);
        showPanel(planePanel);

        registerButton.addActionListener(e -> {
            registration_Clear();
            showPanel(registerPanel);
        });

        helpButton.addActionListener(e -> {
            contactClear();
            showPanel(contactPanel);
        });

        homeButton.addActionListener(e -> showPanel(planePanel));

        createButton.addActionListener(e -> {
            if ((usernameField.getText().equals("") || fnameField.getText().equals("") ||
                    lnameField.getText().equals("") || phoneText.getText().equals("")
                    || mailText.getText().equals("") || String.valueOf(regpassLabel.getPassword()).equals("") ||
                    String.valueOf(regpass2Label.getPassword()).equals("")) || (!maleRadioButton.isSelected() &&
                    !femaleRadioButton.isSelected()))
                message_window.information_window("Please fill all fields!");

            else if(!String.valueOf(regpassLabel.getPassword()).equals(String.valueOf(regpass2Label.getPassword())))
                message_window.information_window("Both passwords must be the same");

            else {
                users.getInformationfromRegister();
                file.write_to_file(users.getUsers(),user_index++);
                loginClear();
                registerPanel.setVisible(false);
                loginPanel.setVisible(true);
            }
        });


        LoginButton.addActionListener(e -> {

            if(users.getUsers().size()==0)
                logfailLabel.setText("Login failed");

            for (int i = 0; i < users.getUsers().size(); i++) {
                if (loginField.getText().equals(users.getUsers().get(i).getUsername()) &&
                        String.valueOf(passwordField1.getPassword()).equals(users.getUsers().get(i).getPassword())) {
                    currentUsername = users.getUsers().get(i).getUsername();
                    for (int r = 0; r < users.getUsers().size(); r++) {
                        if (users.getUsers().get(r).getUsername().equals(currentUsername))
                            if (logged_out.get(r).equals(true)) {
                                tables.fill_after_logout();
                            }
                    }
                    users.setUserBox();
                    userComboBox.setVisible(true);
                    searchClear();
                    loginPanel.setVisible(false);
                    searchPanel.setVisible(true);
                }
                else logfailLabel.setText("Login failed");
            }
        });

        searchButton.addActionListener(e -> {
           searchClear();
            tables.getFlightsmodel().setRowCount(0);
            showPanel(searchPanel);
        });

        init.setLeaving();

        flightsButton.addActionListener(e -> {
            if(trip.equals("One-way")) goConfirmButton.setText("Details");
            else goConfirmButton.setText("Next");

            if (leavingBox.getSelectedItem() != "" && !currentUsername.equals("")) {
                if (verification.checkdates()) {
                    passengers.getpassengers();
                    if(trip.equals("One-way"))
                        passengers.setpassengersvec(passengersvec);
                    else
                    passengers.setpassengersvec(passengersvec_roundtrip);

                    tables.flightstableSettings();
                    filtration.copy_model();
                    filtration.clear_filtration();
                    searchPanel.setVisible(false);
                    flightsPanel.setVisible(true);

                } else {
                    message_window.information_window("Invalid date");
                    return;
                }
            }
            else if (currentUsername.equals("")) {
                message_window.picturewindow("usericon.png","You must be logged in");
            }
        });

        leavingBox.addActionListener(e -> {
            if (leavingBox.getSelectedIndex() != 0) {
                goingBox.removeAllItems();
                init.setGoing();
            }
        });

        onewayButton.addActionListener(e -> {
            trip = onewayButton.getText();
            returningLabel.setVisible(false);
            returningdate.setVisible(false);
        });

        roundtripButton.addActionListener(e -> {
            trip = roundtripButton.getText();
            returningLabel.setVisible(true);
            returningdate.setVisible(true);
        });

        goConfirmButton.addActionListener(e -> {
            if (selected_flights == 1 && trip.equals("One-way")) {
                fill_confirmation_oneway(selected_row_oneway);
                purchaseright.setSelected(false);
                flightsPanel.setVisible(false);
                purchaseleft.setSelected(true);
                confirmonewayPanel.setVisible(true);
            }
            else if (selected_flights == 1 && trip.equals("Roundtrip")) {
                tables.getRoundtripmodel().setRowCount(0);
                tables.fillroundtriptable();
                nobagrtleft.setSelected(true);
                nobagrtright.setSelected(true);
                flightsPanel.setVisible(false);
                roundtripPanel.setVisible(true);
            }
            selected_flights = 0;

        });

        cardRadioButton.addActionListener(e -> {
            mmyycardField.setText("MM/YY");
            CVCfield.setText("***");
            cardnumberField.setText("16 Numbers");

            blikPanel.setVisible(false);
            paymentoptionsPanel.setVisible(true);
            cardPanel.setVisible(true);
            blikRadioButton.setSelected(false);
        });

        blikRadioButton.addActionListener(e -> {
            blikTextField.setText("******");
            cardRadioButton.setSelected(false);
            paymentoptionsPanel.setVisible(true);
            cardPanel.setVisible(false);
            blikPanel.setVisible(true);
        });

        maleRadioButton.addActionListener(e -> femaleRadioButton.setSelected(false));
        femaleRadioButton.addActionListener(e -> maleRadioButton.setSelected(false));

        userComboBox.addActionListener(e -> {

            if (Objects.requireNonNull(userComboBox.getSelectedItem()).toString().equals("Settings")) {
                users.fillUserInformation();
                newpassword = false;
                confirmnewpassTextField.setText("");
                showPanel(userSettings);
            }

            if (userComboBox.getSelectedItem().toString().equals("Reservations")) {
                tables.settablevec();
                tables.settablevec_rt();
                showPanel(ReservationsPanel);
            }

            if (userComboBox.getSelectedItem().toString().equals("Log out")) {
                for (int i = 0; i < users.getUsers().size(); i++) {
                    if (currentUsername.equals(users.getUsers().elementAt(i).getUsername())) {
                        logged_out.set(i, true);
                    }
                }
                currentUsername = "";
                loginClear();
                tables.getConfirmflightsmodel().setRowCount(0);
                tables.getConfirmflightsmodel_rt().setRowCount(0);
                userComboBox.setVisible(false);
                userComboBox.removeAllItems();
                tables.getFlightsmodel().setRowCount(0);
                tables.getRoundtripmodel().setRowCount(0);
                showPanel(loginPanel);
            }

        });

        saveSettingsButton.addActionListener(e -> {
            int user_index=0;
            for(int i=0;i<users.getUsers().size();i++) {
                if(currentUsername.equals(users.getUsers().get(i).getUsername())) user_index=i;
            }
            users.saveSettings();
            currentUsername=users.getUsers().get(user_index).getUsername();
        });

        settingsmaleButton.addActionListener(e -> {
            if (settingsmaleButton.isSelected()) settingsfemaleButton.setSelected(false);
        });

        settingsfemaleButton.addActionListener(e -> {
            if (settingsfemaleButton.isSelected()) settingsmaleButton.setSelected(false);
        });


        flightsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                selected_row_oneway = flightsTable.getSelectedRow();
                ++selected_flights;
                if (selected_flights > 1) {
                    message_window.information_window("Choose one flight");
                    selected_flights = 0;
                    flightsTable.clearSelection();
                }
            }
        });

        goPaymentButton.addActionListener(e -> {
            paymentPanel.setVisible(true);
            confirmonewayPanel.setVisible(false);
            cardRadioButton.setSelected(false);
            blikRadioButton.setSelected(false);
        });

        sendButton.addActionListener(e -> {
            if (currentUsername.equals(""))
                message_window.picturewindow("usericon.png","You must be logged in");
            else if (contactTextArea.getText().equals(""))
                message_window.information_window("Type your message");
            else if (!captchaBox.isSelected())
                message_window.information_window("The CAPTCHA verification failed");
            else
            message_window.picturewindow("messagesent.png","Message was sent");
        });

        cancelButton.addActionListener(e -> cancellation.cancelflight());

        leavingdate.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                leavingdate.setHorizontalAlignment(JTextField.CENTER);
                leavingdate.setText("//");
            }
        });

        returningdate.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                returningdate.setHorizontalAlignment(JTextField.CENTER);
                returningdate.setText("//");
            }
        });

        paymentButton.addActionListener(e -> {
            if (verification.checkcardpayment() && trip.equals("One-way")) {
                save_rows.informations_update(save_rows.getActualrows(),save_rows.getRowsvec(),
                        save_rows.getActual_rows_index(), save_rows.getNumber_of_reservations(),
                        save_rows.getFlightvalue(),save_rows.getLastUsername());
                tables.fill_confirmation_Table(tables.getConfirmflightsmodel(),tables.getOnewayreservationsTable(),
                         tables.getNum_res());
            }
            else if (verification.checkcardpayment() && trip.equals("Roundtrip")) {
                save_rows.informations_update(save_rows.getActualrows_rt(),save_rows.getRowsvec_rt(),
                        save_rows.getActual_rows_index_roundtrip(),save_rows.getNumber_of_reservations_rt(),
                        save_rows.getFlightvalue_rt(),save_rows.getLastUsername_rt());
                tables.fill_confirmation_Table(tables.getConfirmflightsmodel_rt(),tables.getRtreservationsTable(),
                        tables.getNum_res_rt());
            }
                else
            message_window.information_window("Please fill all fields");
        });

        blikButton.addActionListener(e -> {
            if (verification.checkblikpayment() && trip.equals("One-way")) {
                save_rows.informations_update(save_rows.getActualrows(),save_rows.getRowsvec(),
                        save_rows.getActual_rows_index(), save_rows.getNumber_of_reservations(),
                        save_rows.getFlightvalue(),save_rows.getLastUsername());
                tables.fill_confirmation_Table(tables.getConfirmflightsmodel(),tables.getOnewayreservationsTable(),
                        tables.getNum_res());
            }
           else if (verification.checkblikpayment() && trip.equals("Roundtrip"))
            {
                save_rows.informations_update(save_rows.getActualrows_rt(),save_rows.getRowsvec_rt(),
                        save_rows.getActual_rows_index_roundtrip(),save_rows.getNumber_of_reservations_rt(),
                        save_rows.getFlightvalue_rt(),save_rows.getLastUsername_rt());
                tables.fill_confirmation_Table(tables.getConfirmflightsmodel_rt(),tables.getRtreservationsTable(),
                        tables.getNum_res_rt());
            }
            else
            message_window.information_window("Please fill all fields");

        });

        blikTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                blikTextField.setText("");
            }
        });

        cardnumberField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                cardnumberField.setText("");
            }
        });

        mmyycardField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                mmyycardField.setText("/");
            }
        });

        CVCfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                CVCfield.setText("");
            }
        });

        purchaseleft.addActionListener(e -> {
            purchaseright.setSelected(false);
            priceLabelright.setText(data.price_sum() + " $");
        });

        purchaseright.addActionListener(e -> {
            purchaseleft.setSelected(false);
            priceLabelright.setText((data.price_sum() + checked_value) + " $");
        });

        passwordfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                confirmnewpassLabel.setVisible(true);
                confirmnewpassTextField.setVisible(true);
            }
        });

        usernamefield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                usernamefield.setText("");
            }
        });

        firstnamefield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                firstnamefield.setText("");
            }
        });

        lastnamefield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                lastnamefield.setText("");
            }
        });

        phonenumberfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                phonenumberfield.setText("");
            }
        });

        emailfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                emailfield.setText("");
            }
        });

        passwordfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                newpassword = true;
                passwordfield.setText("");
            }
        });

        roundtripTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                selected_row_roundtrip = roundtripTable.getSelectedRow();
            }
        });

        goconfirmrt.addActionListener(e -> {
            fill_confirmation_oneway(selected_row_oneway);
           fill_confirmation_roundtrip(selected_row_oneway, selected_row_roundtrip);
            roundtripPanel.setVisible(false);
            confirmroundtripPanel.setVisible(true);
            yesbagrtleft.setSelected(false);
            yesbagrtright.setSelected(false);
        });

        gopaymentrtButton.addActionListener(e -> {
            cardRadioButton.setSelected(false);
            blikRadioButton.setSelected(false);
            showPanel(paymentPanel);
        });

        nobagrtleft.addActionListener(e -> {
            yesbagrtleft.setSelected(false);
            back_roundtrip_price(checked_value);
        });

        yesbagrtleft.addActionListener(e -> {
            nobagrtleft.setSelected(false);
            set_roundtrip_price(checked_value);
        });

        nobagrtright.addActionListener(e -> {
            yesbagrtright.setSelected(false);
            back_roundtrip_price(checked_value_roundtrip);
        });

        yesbagrtright.addActionListener(e -> {
            nobagrtright.setSelected(false);
            set_roundtrip_price(checked_value_roundtrip);
        });

        filtrationButton.addActionListener(e -> filtration.filtration());

        ResetButton.addActionListener(e -> {
        tables.getFlightsmodel().setRowCount(0);
        filtration.restore_rows();
        });

    }


    public void showPanel(JPanel which) {
        Vector<JPanel> panels = new Vector<>();
        panels.add(planePanel);
        panels.add(contactPanel);
        panels.add(registerPanel);
        panels.add(searchPanel);
        panels.add(flightsPanel);
        panels.add(paymentPanel);
        panels.add(userSettings);
        panels.add(ReservationsPanel);
        panels.add(confirmonewayPanel);
        panels.add(loginPanel);
        panels.add(blikPanel);
        panels.add(userSettings);
        panels.add(paymentoptionsPanel);
        panels.add(roundtripPanel);
        panels.add(confirmroundtripPanel);

        for (int i = 0; i < panels.size(); i++) {
            if (panels.get(i).equals(which)) {
                panels.get(i).setVisible(true);
                panels.remove(i);
            }
        }
        for (JPanel panel : panels) {
            panel.setVisible(false);
        }
    }

    public void set_colors() {
        loginPanel.setBackground(new Color(159, 208, 233));
        contactPanel.setBackground(new Color(228, 228, 243, 255));
        registerPanel.setBackground(new Color(159, 208, 233));
        searchPanel.setBackground(new Color(225, 220, 203));
        slidePanel.setBackground(new Color(225, 220, 203));
        paymentPanel.setBackground(new Color(202, 228, 246));
        blikPanel.setBackground(new Color(202, 228, 246));
        cardPanel.setBackground(new Color(202, 228, 246));
        userSettings.setBackground(new Color(224, 210, 210, 255));
        confirmonewayPanel.setBackground(new Color(225, 220, 203));
        panel0.setBackground(new Color(188, 190, 199));
        homePanel.setBackground(new Color(188, 190, 199));
        roundtripPanel.setBackground(new Color(225,220,203));
        confirmonewayPanel.setBackground(new Color(241, 236, 184, 255));
        confirmroundtripPanel.setBackground(new Color(241,236,184));
        ReservationsPanel.setBackground(new Color(207, 208, 248));
    }


    public void set_roundtrip_price(int additional_price) {
        int dollar_index = totalpricert.getText().lastIndexOf('$');
        double price = Double.parseDouble(totalpricert.getText().substring(0, dollar_index - 2));
        price += additional_price;
        totalpricert.setText(price + " $");
    }

    public void back_roundtrip_price(int minus_price) {
        int dollar_index = totalpricert.getText().lastIndexOf('$');
        double price = Double.parseDouble(totalpricert.getText().substring(0, dollar_index - 2));
        price -= minus_price;
        totalpricert.setText(price + " $");
    }
    
    public void registration_Clear() {
        usernameField.setText("");
        fnameField.setText("");
        lnameField.setText("");
        phoneText.setText("");
        mailText.setText("");
        regpassLabel.setText("");
        regpass2Label.setText("");
        maleRadioButton.setSelected(false);
        femaleRadioButton.setSelected(false);
        dayComboBox.setSelectedItem(1);
        monthComboBox.setSelectedItem("January");
        yearComboBox.setSelectedItem(2000);
    }

    public void loginClear() {
        loginField.setText("");
        passwordField1.setText("");
        logfailLabel.setText("");
    }

    public void contactClear() {
        subjectBox.setSelectedIndex(0);
        contactTextArea.setText("");
        captchaBox.setSelected(false);
    }

    public void searchClear() {
        adultsBox.setSelectedIndex(1);
        childrensBox.setSelectedIndex(0);
        infantsBox.setSelectedIndex(0);
        classBox.setSelectedIndex(0);
        leavingBox.setSelectedItem("");
        goingBox.setSelectedItem("");
    }


    public void fill_fields(Vector<JLabel> components,JTable table,int selected_row,int checked_value)
    {
        for(int i=0;i<components.size();i++)
        {
            components.get(i).setText(table.getModel().getValueAt(selected_row,i).toString());
            if(i==8){
                components.get(++i).setText(table.getModel().getValueAt(selected_row, 9).toString() + " h");
                components.get(++i).setText("Included up to " + ((int) ((Math.random() * (9 - 6)) + 6)) + " kg");
                components.get(++i).setText(checked_value + " $" + " up to " + (int) ((Math.random() * (23 - 10)) + 10)
                        + " kg");
            }
        }
    }


    public void fill_confirmation_oneway(int selected_row) {
        checked_value = (int) ((Math.random() * (40 - 20)) + 20);
        Vector<JLabel> oneway_components = new Vector<>(Arrays.asList(flightnumberLabelright,airlineLabelright,
                tripLabelright,departingdateright,returningdateright,fromLabelright,toLabelright,
                departureLabelright,arrivalLabelright,durationLabelright,carryonright,checkedright));

        fill_fields(oneway_components,flightsTable,selected_row,checked_value);
        priceLabelright.setText(data.price_sum() + " $");
    }


    public void fill_confirmation_roundtrip(int selected_row, int selected_row_rt) {
        checked_value_roundtrip = (int) ((Math.random() * (40 - 20)) + 20);
        Vector<JLabel> roundtrip_components_left= new Vector<>(Arrays.asList(flightnumberrtleft,airlinertleft,
                triprtleft,departingdatertleft,returningdatertleft,fromrtleft,tortleft,departurertleft,
                arrivalrtleft,durationrtleft,carryonrtleft,checkedbagrtleft));

        Vector<JLabel> roundtrip_components_right = new Vector<>(Arrays.asList(flightnumberrtright,airlinertright,
                triprtright,departingdatertright,returningdatertright,fromrtright,tortright,departurertright,
                arrivalrtright,durationrtright,carryonrtright,checkedbagrtright));

        fill_fields(roundtrip_components_left,flightsTable,selected_row,checked_value);
        fill_fields(roundtrip_components_right,roundtripTable,selected_row_rt,checked_value_roundtrip);
        totalpricert.setText(data.price_sum() + " $");

    }


    public JComboBox getAdultsBox()
    {
        return adultsBox;
    }
    public JComboBox getChildrensBox()
    {
        return childrensBox;
    }
    public JComboBox getInfantsBox()
    {
        return infantsBox;
    }
    public JComboBox getLeavingBox()
    {
        return leavingBox;
    }
    public JComboBox getGoingBox()
    {
        return goingBox;
    }
    public JComboBox getClassBox()
    {
        return classBox;
    }
    public JComboBox getSubjectBox(){
        return subjectBox;
    }
    public JTextField getMinPriceField()
    {
        return minPriceField;
    }
    public JTextField getMaxPriceField()
    {
        return maxPriceField;
    }
    public String getTrip()
    {
        return trip;
    }
    public JTable getFlightsTable()
    {
        return flightsTable;
    }
    public JTable getRoundtripTable()
    {
        return roundtripTable;
    }
    public JLabel getSlideshowLabel()
    {
        return slideshowLabel;
    }
    public JTextField getLeavingdate()
    {
        return leavingdate;
    }
    public JTextField getUsernameField()
    {
        return usernameField;
    }
    public JTextField getUsernamefield(){return usernamefield;}
    public JTextField getFnameField()
    {
        return fnameField;
    }
    public JTextField getPhoneText()
    {
        return phoneText;
    }
    public JTextField getMailText()
    {
        return mailText;
    }
    public JRadioButton getMaleRadioButton()
    {
        return maleRadioButton;
    }
    public JTextField getlnameField()
    {
        return lnameField;
    }
    public JPasswordField getRegpassLabel()
    {
        return regpassLabel;
    }
    public JComboBox getDayComboBox()
    {
        return dayComboBox;
    }
    public JComboBox getMonthComboBox()
    {
        return monthComboBox;
    }
    public JComboBox getYearComboBox()
    {
        return yearComboBox;
    }
    public String getCurrentUsername()
    {
        return currentUsername;
    }
    public int getSelected_row_oneway(){return selected_row_oneway;}
    public int getSelected_row_roundtrip(){return selected_row_roundtrip;}

    public JTextField getReturningdate()
    {
        return returningdate;
    }
    public JTextField getCardnameField()
    {
        return cardnameField;
    }
    public JTextField getCardnumberField()
    {
        return cardnumberField;
    }
    public JTextField getMmyycardField()
    {
        return mmyycardField;
    }
    public JTextField getCVCfield()
    {
        return CVCfield;
    }
    public JTextField getBlikTextField()
    {
        return blikTextField;
    }
    public JTextField getFirstnamefield()
    {
        return firstnamefield;
    }
    public JTextField getLastnamefield()
    {
        return lastnamefield;
    }
    public JTextField getPhonenumberfield()
    {
        return phonenumberfield;
    }
    public JTextField getEmailfield()
    {
        return emailfield;
    }
    public JTextField getPasswordfield()
    {
        return passwordfield;
    }
    public JTextField getConfirmnewpassTextField()
    {
        return confirmnewpassTextField;
    }
    public JRadioButton getSettingsmaleButton()
    {
        return settingsmaleButton;
    }
    public JComboBox getDaySettingsBox()
    {
        return daySettingsBox;
    }
    public JComboBox getMonthSettingsBox()
    {
        return monthSettingsBox;
    }
    public JComboBox getYearSettingBox()
    {
        return yearSettingBox;
    }
    public JComboBox getUserComboBox()
    {
        return userComboBox;
    }
    public Vector<String> getPassengersvec()
    {
        return passengersvec;
    }
    public Vector<String> getPassengersvec_roundtrip(){return passengersvec_roundtrip;}

    public JLabel getConfirmnewpassLabel()
    {
        return confirmnewpassLabel;
    }
    public JRadioButton getSettingsfemaleButton()
    {
        return settingsfemaleButton;
    }
    public JTable getOnewayreservationsTable()
    {
        return onewayreservationsTable;
    }
    public JTable getRtreservationsTable()
    {
        return rtreservationsTable;
    }
    public Vector<Boolean> getLogged_out()
    {
        return logged_out;
    }
    public RandomData getData(){
        return data;
    }
    public getUsers getUsers()
    {
        return users;
    }
    public SaveRows getSave_rows()
    {
        return save_rows;
    }
    public FillTables getTables()
    {
        return tables;
    }
    public Passengers getPassengers(){return passengers;}
    public Messages getMessage_window()
    {
        return message_window;
    }
    public Boolean getNewpassword(){return newpassword;}



    public static void main(String[] args) {
        JFrame frame = new JFrame("AirlineSystem");
        frame.setMinimumSize(new Dimension(1530, 820));
        frame.setContentPane(new AirlineSystem().homePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
