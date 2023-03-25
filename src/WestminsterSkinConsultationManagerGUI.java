
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class WestminsterSkinConsultationManagerGUI extends JFrame implements ActionListener {



//    JFrame frame;

    private WestminsterSkinConsultationManager manager;
    private JPanel mainPanel;
    private JTable doctorsTable;
    private JButton printDoctorsButton;
    private JButton bookConsultationButton;
    private JButton cancelConsultationButton;

    private JButton saveToFileButton;

    private JButton checkAvailabilityButton;
    private JTextField patientIdField;
    private JTextField patientNameField;
    private JTextField patientSurnameField;
    private JTextField patientDOBField;
    private JTextField patientMobileNumberField;

    private JTextField patientNotesNumberField;

    private JTextField consultationDateField;
    private JTextField consultationTimeField;
    private JTextField costField;

    private JTextField availabilityDateField;
    private JTextField availabilityTimeField;

    private JTextField addNotesField;

    private JButton checkConsultationsButton;

    private JButton sortButton;
    private JButton addNotesButton;
    private JButton selectImageButton;


    JLabel imageLabel;

    private JButton toHomeButton;

    public WestminsterSkinConsultationManagerGUI(WestminsterSkinConsultationManager manager) {



        this.manager = manager;
        this.mainPanel = new JPanel();

        // Set up the doctors table
        String[] columnNames = {"Name", "Surname", "Date of birth", "Mobile number", "Medical license number", "Specialization","Available Date","Available Time"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        this.doctorsTable = new JTable(model);
        doctorsTable.setPreferredScrollableViewportSize(new Dimension(800, 200));
        doctorsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        doctorsTable.setShowGrid(true);
        doctorsTable.setGridColor(Color.BLACK);


        // Set up the buttons
        this.printDoctorsButton = new JButton("Print Doctors");
        this.bookConsultationButton = new JButton("Book Consultation");
        this.cancelConsultationButton = new JButton("Cancel Consultation");
        this.saveToFileButton = new JButton("Save to File");

        this.checkAvailabilityButton = new JButton("Check Availability");
        this.sortButton = new JButton("Sort");
        this.addNotesButton = new JButton("ADD NOTES");


        this.selectImageButton = new JButton("Image");

        this.toHomeButton = new JButton("To Home");



        selectImageButton.setBounds(300,300,100,40);
        imageLabel = new JLabel();
        imageLabel.setBounds(10,10,670,250);

        // Set up the text fields
        this.patientIdField = new JTextField(10);
        this.patientNameField = new JTextField(10);
        this.patientSurnameField = new JTextField(10);
        this.patientDOBField = new JTextField(10);
        this.patientMobileNumberField = new JTextField(10);
        this.patientNotesNumberField = new JTextField(10);
        this.consultationDateField = new JTextField(10);
        this.consultationTimeField = new JTextField(10);
        this.costField = new JTextField(10);
        this.availabilityDateField = new JTextField(10);
        this.availabilityTimeField = new JTextField(10);

        this.addNotesField = new JTextField(0);

        this.checkConsultationsButton = new JButton("Check Consultations");






        // Set up the main panel
// mainPanel.setLayout(new GridLayout(12, 4));

        // Set up the doctors table panel
        JPanel doctorsTablePanel = new JPanel();
        doctorsTablePanel.add(new JScrollPane(doctorsTable));
//        doctorsTablePanel.add(printDoctorsButton);
//        doctorsTablePanel.add(saveToFileButton);

//        doctorsTablePanel.add(saveToFileButton);

//        JPanel saveToFilePanel = new JPanel();
//        saveToFilePanel.add(saveToFileButton);



        // Set up the patient information panel
        JPanel patientInformationPanel = new JPanel();
        patientInformationPanel.setLayout(new GridLayout(14, 2));
        patientInformationPanel.add(new JLabel("Patient Id : "));
        patientInformationPanel.add(patientIdField);
        patientInformationPanel.add(new JLabel("Patient Name:"));
        patientInformationPanel.add(patientNameField);
        patientInformationPanel.add(new JLabel("Patient Surname:"));
        patientInformationPanel.add(patientSurnameField);
        patientInformationPanel.add(new JLabel("Patient DOB:"));
        patientInformationPanel.add(patientDOBField);
        patientInformationPanel.add(new JLabel("Patient Mobile Number:"));
        patientInformationPanel.add(patientMobileNumberField);
        patientInformationPanel.add(new JLabel("Patient Notes:"));
        patientInformationPanel.add(patientNotesNumberField);

        patientInformationPanel.add(new JLabel("Consultation Details:"));
        patientInformationPanel.add(new JLabel("."));
        patientInformationPanel.add(new JLabel("Consultation Date:"));
        patientInformationPanel.add(consultationDateField);
        patientInformationPanel.add(new JLabel("Consultation Time:"));
        patientInformationPanel.add(consultationTimeField);



//        patientInformationPanel.add(costField);
        patientInformationPanel.add(bookConsultationButton);
        patientInformationPanel.add(cancelConsultationButton);
//        patientInformationPanel.add(selectImageButton);
//        patientInformationPanel.add(toHomeButton);

        patientInformationPanel.add(new JLabel("Availability Date:"));
        patientInformationPanel.add(availabilityDateField);

        patientInformationPanel.add(new JLabel("Availability Time:"));
        patientInformationPanel.add(availabilityTimeField);




        // Set up the consultation panel
//        JPanel consultationPanel = new JPanel();
//        consultationPanel.setLayout(new GridLayout(3, 2));
//        consultationPanel.add(new JLabel("Consultation Date:"));
//        consultationPanel.add(consultationDateField);
//        consultationPanel.add(new JLabel("Consultation Time:"));
//        consultationPanel.add(consultationTimeField);
//        consultationPanel.add(costField);
//        consultationPanel.add(bookConsultationButton);
//        consultationPanel.add(cancelConsultationButton);

//        consultationPanel.add(selectImageButton);
//
//        consultationPanel.add(toHomeButton);

        // Set up the save to file panel
//        JPanel saveToFilePanel = new JPanel();
//        saveToFilePanel.add(saveToFileButton);

        // Set up the availability panel
        JPanel availabilityPanel = new JPanel();
        availabilityPanel.setLayout(new GridLayout(14, 2));


        availabilityPanel.add(printDoctorsButton);

        availabilityPanel.add(sortButton);
//        availabilityPanel.add(new JLabel("Sort:"));
        availabilityPanel.add(saveToFileButton);

//        availabilityPanel.add(new JLabel("ADD NOTES"));
        availabilityPanel.add(addNotesButton);

        availabilityPanel.add(costField);



//        availabilityPanel.add(new JLabel("ADD Image"));
        availabilityPanel.add(imageLabel);


//        availabilityPanel.add(new JLabel(""));
        availabilityPanel.add(toHomeButton);
        availabilityPanel.add(selectImageButton);
        availabilityPanel.add(new JLabel(""));
        availabilityPanel.add(checkAvailabilityButton);
        availabilityPanel.add(checkConsultationsButton);
        // Set up the CheckConsultation panel
//        JPanel checkPanel = new JPanel();
//        checkPanel.add(checkConsultationsButton);

//         Set up the Sort panel
//        JPanel sortPanel = new JPanel();
//        sortPanel.add(sortButton);



        // Set up the addNotes panel
//        JPanel addNotesPanel = new JPanel();
//        addNotesPanel.setLayout(new GridLayout(2, 2));
//        addNotesPanel.add(new JLabel("ADD NOTES"));
//        addNotesPanel.add(addNotesButton);

//        JPanel imagePanel = new JPanel();
//        imagePanel.add(selectImageButton);




//        // Add the panels to the main panel
//        mainPanel.add(doctorsTablePanel);
//        //        mainPanel.add(saveToFilePanel);
//        mainPanel.add(patientInformationPanel);
////        mainPanel.add(consultationPanel);
//         mainPanel.add(availabilityPanel);


        // Add the panels to the main panel
        mainPanel.add(doctorsTablePanel);
        //        mainPanel.add(saveToFilePanel);
        mainPanel.add(patientInformationPanel);
//        mainPanel.add(consultationPanel);

        mainPanel.add(availabilityPanel);
//        mainPanel.add(checkPanel);
//        mainPanel.add(sortPanel);
//        mainPanel.add(imagePanel);
//        mainPanel.add(addNotesPanel);

//        JPanel imageLabelPanel = new JPanel();
//        imageLabelPanel.add(imageLabel);


        add(mainPanel);
        setTitle("Westminster Skin Consultation Manager");
        setSize(1000, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        bookConsultationButton.addActionListener(this);
        cancelConsultationButton.addActionListener(this);
        printDoctorsButton.addActionListener(this);
        saveToFileButton.addActionListener(this);
        checkAvailabilityButton.addActionListener(this);

        checkConsultationsButton.addActionListener(this);
        sortButton.addActionListener(this);
        selectImageButton.addActionListener(this);
        addNotesButton.addActionListener(this);

        toHomeButton.addActionListener(this);

        setTitle("Main Window");


        toHomeButton = new JButton("Open Second Window");
        toHomeButton.addActionListener(e -> {
            if(e.getSource() == toHomeButton){
//                frame.dispose();
                new Home();
            }
        });


//        toHomeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                openHome();
//            }
//        });
//        add(toHomeButton);
    }

//        private void openHome(){
//
//            Home home = new Home();
//            home.setVisible(true);
//
//
//        }









//    Home home = new Home();
//    home.show();
//
//    dispose();

    // Set the title and size of the window
//    setTitle("Main Window");
//    setSize(300, 200);

    // Create a button to open the second window





    private void bookConsultation() throws ParseException {
        // Get the selected doctor from the table
        int selectedRow = doctorsTable.getSelectedRow();
        String name = (String) doctorsTable.getValueAt(selectedRow, 0);
        String surname = (String) doctorsTable.getValueAt(selectedRow, 1);
        String dob = (String) doctorsTable.getValueAt(selectedRow, 2);
        String mobileNumber = (String) doctorsTable.getValueAt(selectedRow, 3);
        String medicalLicenseNumber = (String) doctorsTable.getValueAt(selectedRow, 4);
        String specialization = (String) doctorsTable.getValueAt(selectedRow, 5);
        String availableTime = (String)doctorsTable.getValueAt(selectedRow,7);
        String availableDate = (String) doctorsTable.getValueAt(selectedRow,6);

        SimpleDateFormat DateFor = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        Date dateOfBirth = DateFor.parse(dob);
        int number = Integer.parseInt(mobileNumber);
        int licenseNumber = Integer.parseInt(medicalLicenseNumber);
        Date AvailableDate = DateFor.parse(availableDate);


        // Create a Doctor object from the table data
        Doctor doctor = new Doctor(name, surname, dateOfBirth, number, licenseNumber, specialization,availableTime,AvailableDate);

        // Get the patient information from the text fields
        int patientId = Integer.parseInt(patientIdField.getText());
        String patientName = patientNameField.getText();
        String patientSurname = patientSurnameField.getText();
        SimpleDateFormat DF = new SimpleDateFormat("dd/mm/yyyy");
        Date patientDOB = DF.parse(patientDOBField.getText());
        int patientMobileNumber = Integer.parseInt(patientMobileNumberField.getText());
        String patientNotes = patientNotesNumberField.getText();


//        //Encrypting notes here
//        String originalValue = patientNotes;
//        String encryptedValue = encrypt(originalValue);


        // Create a Patient object from the text field data
        Patient patient = new Patient(patientId,patientName, patientSurname, patientDOB, patientMobileNumber,patientNotes);

        // Parse the consultation date and time from the text fields
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date DateconsultationDate;
        DateconsultationDate = null;
        try {
            DateconsultationDate = dateFormat.parse(consultationDateField.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String consultationTime = consultationTimeField.getText();
        double cost = Double.parseDouble(costField.getText());

// Create a new Consultation object and add it to the list of consultations
        Consultation consultation = new Consultation(doctor, patient, DateconsultationDate, consultationTime,cost, patientNotes);
        manager.addConsultation(consultation);

// Print the information for the doctor, patient, and consultation objects
        System.out.println("Doctor information:");
        System.out.println("Name: " + doctor.getName());
        System.out.println("Surname: " + doctor.getSurname());
        System.out.println("Date of birth: " + doctor.getDOB());
        System.out.println("Mobile number: " + doctor.getMobile_number());
        System.out.println("Medical license number: " + doctor.getMedicalLicenceNumber());
        System.out.println("Specialization: " + doctor.getSpecialization());

        System.out.println("Patient information:");
        System.out.println("Patient Id : " + patient.getPatient_id());
        System.out.println("Name: " + patient.getName());
        System.out.println("Surname: " + patient.getSurname());
        System.out.println("Date of birth: " + patient.getDOB());
        System.out.println("Mobile number: " + patient.getMobile_number());
        System.out.println("Notes : " + patient.getPatientNotes());

        System.out.println("Consultation information:");
        System.out.println("Doctor: " + consultation.getDoctor().getName() + " " + consultation.getDoctor().getSurname());
        System.out.println("Patient: " + consultation.getPatient().getName() + " " + consultation.getPatient().getSurname());
        System.out.println("Date: " + consultation.getDate());
        System.out.println("Time: " + consultation.getTimeSlot());
    }

    //   printDoctorsButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==printDoctorsButton){
            List<Doctor> doctors = manager.getDoctors();
            String[][] data = new String[doctors.size()][8];
            for (int i = 0; i < doctors.size(); i++) {
                Doctor doctor = doctors.get(i);
                data[i][0] = doctor.getName();
                data[i][1] = doctor.getSurname();
                data[i][2] = String.valueOf(doctor.getDOB());
                data[i][3] = String.valueOf(doctor.getMobile_number());
                data[i][4] = String.valueOf(doctor.getMedicalLicenceNumber());
                data[i][5] = doctor.getSpecialization();
                data[i][6] = String.valueOf(doctor.getAvailableDate());
                data[i][7] = doctor.getAvailableTime();

            }
            String[] columnNames = {"Name", "Surname", "Date of birth", "Mobile number", "Medical license number", "Specialization","Available Date","Available Time"};
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            doctorsTable.setModel(model);
        }
        else if (e.getSource() == checkAvailabilityButton){
            String availabilityDateString = availabilityDateField.getText();
            String availabilityTimeString = availabilityTimeField.getText();


            DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
            Date availabilityDate = null;
            try {
                availabilityDate = dateFormat.parse(availabilityDateString);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            List<Doctor> availableDoctors = manager.getAvailableDoctors(availabilityDate, availabilityTimeString);
            for (int i = 0; i < availableDoctors.size();i++)
            {
                System.out.println(availableDoctors.get(i));
            }

            DefaultTableModel model = (DefaultTableModel) doctorsTable.getModel();
            model.setRowCount(0); // Clear the table
            for (Doctor doctor : availableDoctors) {
                model.addRow(new Object[]{
                        doctor.getName(),
                        doctor.getSurname(),
                        doctor.getDOB(),
                        doctor.getMobile_number(),
                        doctor.getMedicalLicenceNumber(),
                        doctor.getSpecialization(),
                        doctor.getAvailableDate(),
                        doctor.getAvailableTime()
                });
            }
        }if (e.getSource() == bookConsultationButton) {
            // Validate the input
            if (doctorsTable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Please select a doctor from the table.");
                return;
            }
            if (patientNameField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the patient's name.");
                return;
            }
            if (patientSurnameField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the patient's surname.");
                return;
            }
            if (patientDOBField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the patient's date of birth.");
                return;
            }
            if (patientMobileNumberField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the patient's mobile number.");
                return;
            }
            if (consultationDateField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the consultation date.");
                return;
            }
            if (consultationTimeField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the consultation time.");
                return;
            }

            try {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.parse(consultationDateField.getText());
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid consultation date in the format dd/MM/yyyy.");
                return;
            }

            // All input is valid, book the consultation
            try {
                bookConsultation();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }


        else if (e.getSource() == selectImageButton) {
            // Create a file chooser object
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

            // Set the file filter to only allow image files to be selected
            fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "png", "gif", "jpeg"));

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                File selectedFile = fileChooser.getSelectedFile();
                // Add the file to the list of images in the WestminsterSkinConsultationManager class
                manager.addImage(selectedFile);
                String path = selectedFile.getAbsolutePath();
                imageLabel.setIcon(ResizeImage(path));
            }

        }



        else if (e.getSource()==checkConsultationsButton){
            // Get the list of consultations from the manager
            List<Consultation> consultations = manager.getConsultations();

            // Iterate through the list of consultations and print the information for each consultation
            for (Consultation consultation : consultations) {
                Doctor doctor = consultation.getDoctor();
                Patient patient = consultation.getPatient();
                Date consultationDate = consultation.getDate();

                System.out.println("Doctor: " + doctor.getName() + " " + doctor.getSurname());
                System.out.println("Medical license number: " + doctor.getMedicalLicenceNumber());
                System.out.println("Mobile number: " + doctor.getMobile_number());
                System.out.println("Patient: " + patient.getName() + " " + patient.getSurname());
                System.out.println("Patient mobile number: " + patient.getMobile_number());
                System.out.println("Consultation date: " + consultationDate);
                System.out.println();
            }
        }
        else if (e.getSource()==sortButton){
        List<Doctor> doc = manager.getDoctors();
        // Sort the list of doctors alphabetically by name
        Collections.sort(doc, Comparator.comparing(Person::getName));
        DefaultTableModel model = (DefaultTableModel) doctorsTable.getModel();

        // Clear the table
        model.setRowCount(0);

        // Add the sorted list of doctors to the table
        for (Doctor doctor : doc) {
            Object[] row = {doctor.getName(), doctor.getSurname(), doctor.getDOB(), doctor.getMobile_number(), doctor.getMedicalLicenceNumber(), doctor.getSpecialization(), doctor.getAvailableDate(), doctor.getAvailableTime()};
            model.addRow(row);
        }
    }

//        else if (e.getSource() == addNotesButton) {
//            // Get the notes from the text field
//            String notes = addNotesField.getText();
//
//            // Add the notes to the list of notes in the WestminsterSkinConsultationManager class
//            manager.addNotes(notes);
//
//            // Clear the text field
//            addNotesField.setText("");
//        }


    }

    private Icon ResizeImage(String ImagePath) {

        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}


