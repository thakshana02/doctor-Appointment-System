import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    //real

    //Initialize ArrayLists
    //Initialize the doctor arraylist
    private ArrayList<Doctor> doctors;
    private final int MAX_DOCTORS = 10;     //System can add upto 10 Doctors


    //Initialize consultation Arraylist
    private ArrayList<Consultation> consultations;

    //Initialize addNotes Arraylist
    private List<String>notesList = new ArrayList<>();

    private static final String ALGORITHM = "AES";
    private static final String KEY = "1Hbfh667adfDEJ78";

    //Initialize consultation Arraylist
    List<File> imagesList = new ArrayList<>();



    public WestminsterSkinConsultationManager() {


        this.doctors = new ArrayList<Doctor>();
        this.consultations = new ArrayList<Consultation>();

    }

    //Add available Dates

    public void AvailableDates(){
        String Date1 = "04.00-05.00";
        String Date2 = "05.00-06.00";
        String Date3 = "06.00-07.00";
        String Date4 = "07.00-08.00";
    };

    public List<Doctor> getAvailableDoctors(Date consultationDate, String consultationTime) {
        List<Doctor> availableDoctors = new ArrayList<>();
        System.out.println("lil");
        System.out.println(consultationTime);
        System.out.println(consultationDate);
        for (Doctor doctor : doctors) {
            if (doctor.getAvailableDate().equals(consultationDate) && doctor.getAvailableTime().equals(consultationTime)) {
                availableDoctors.add(doctor);
                System.out.println(doctor);
                System.out.println("lil");
            }
        }
            for (Doctor doctor : doctors) {
                System.out.println(doctor.getAvailableDate());
                System.out.println( doctor.getAvailableTime());

        }
        return availableDoctors;
    }


    //Initialize main 4 Methods
    //Initialize the addDoctor Method


    public void addDoctor(Doctor doctor) {

        if (this.doctors.size() < MAX_DOCTORS) {
            this.doctors.add(doctor);

            System.out.println(doctor.getDOB());


            System.out.println("Doctor added.");
        } else {
            System.out.println("Error : Already there are maximum number of doctors");
        }
    }

    //Initialize the deleteDoctor Method
    public void deleteDoctor(int medical_License_Number) {
        for (Doctor doctor : this.doctors) {
            if (doctor.getMedicalLicenceNumber() == medical_License_Number) {
                this.doctors.remove(doctor);
                System.out.println("Doctor with medical license number " + medical_License_Number + " has been deleted.");
                System.out.println("Total number of doctors: " + this.doctors.size());
                return;
            }
        }
        System.out.println("Error: Doctor with medical license number " + medical_License_Number + " not found.");
    }
    //Initialize the printDoctor Method
    public void printDoctors() {
        if (this.doctors.isEmpty()) {
            System.out.println("Error: The list of doctors is empty.");
            return;
        }
        try {
            Collections.sort(this.doctors, Comparator.comparing(Person::getSurname));
            for (Doctor doctor : this.doctors) {

                //ToString Method to print Doctor Details
                System.out.println(doctor.ToString());


//                System.out.println("Name: " + doctor.getName());
//                System.out.println("Surname: " + doctor.getSurname());
//                System.out.println("Date of birth: " + doctor.getDOB());
//                System.out.println("Mobile number: " + doctor.getMobile_number());
//                System.out.println("Medical license number: " + doctor.getMedicalLicenceNumber());
//                System.out.println("Specialization: " + doctor.getSpecialization());
            }
        } catch (NullPointerException e) {
            System.out.println("Error: The list of doctors is null.");
        } catch (ClassCastException e) {
            System.out.println("Error: The list of doctors contains an element that is not a Doctor.");
        }
    }

    //Initialize the saveToFile Method
    public void saveToFile() {
        if (this.doctors.isEmpty()) {
            System.out.println("Error: The list of doctors is empty.");
            System.out.println("Try again after adding a new doctor to the list");
            return;
        }
        try {

            File file = new File("doctors.txt");
            FileWriter writer = new FileWriter(file);
            for (Doctor doctor : this.doctors) {
              //  writer.write(doctor.getName() + "," + doctor.getSurname() + "," + doctor.getDOB() + "," + doctor.getMobile_number() + "," + doctor.getMedicalLicenceNumber() + "," + doctor.getSpecialization() + "\n");
                writer.write(doctor.ToString());
            }

            writer.close();

            System.out.println("Information saved to file successfully at: " + file.getAbsolutePath());
        }
        catch (NullPointerException e) {
            System.out.println("Error: The list of doctors is null.");
        }
        catch (IOException e) {
            System.out.println("Error : saving to file.");
        }
    }



    public static String encrypt(String plainText, String key) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedText = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String encryptedText, String key) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedText = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void addNotes (String notes){

        String KEY = "1Hbfh667adfDEJ78";
        // Encrypt the notes
        String encryptedNotes = encrypt(notes,KEY);
        // Add the encrypted notes to the list of notes
        notesList.add(encryptedNotes);
    }

    public void printNotes(){

        String KEY = "1Hbfh667adfDEJ78";

        for (int i = 0; i < notesList.size();i++)
        {
            System.out.println(notesList.get(i));
            System.out.println(decrypt(notesList.get(i), KEY));

        }


    }

    private double calculateCost(int PatientID){

        boolean ForFirstConsultaton = ForFirstConsultation(PatientID);
        if (ForFirstConsultaton){
            return 15;
        }
        else {
            return 25;
        }

    }

    private boolean ForFirstConsultation(int patientID){
        for (Consultation consultation : consultations){
            if (consultation.getPatient().getPatient_id() == patientID){
                return false;
            }
        }
        return true;
    }


        //add the follow-up functions

    public void getNotes(){

    }








    //Other methods consultation



    public void cancelConsultation(Consultation consultation){
        consultations.remove(consultation);
    }









    @Override
    public void removeDoctor(Doctor doctor) {

    }

    @Override
    public List<Doctor> getDoctors() {
        return doctors;
    }

    @Override
    public List<Doctor> getPatients() {
        return getPatients();
    }




    @Override
    public void bookConsultation(Doctor doctor, Patient patient, Date date, String timesSlot, Doctor selectedDoctor, Date consultationDateTime) {

    }



//    @Override
//    public void cancelConsultation(Consultation consultation) {
//
//      /*  for (Doctor doctor : this.doctors) {
//            if (doctor.getMedicalLicenceNumber() == medical_License_Number) {
//                this.doctors.remove(doctor);
//                System.out.println("Doctor with medical license number " + medical_License_Number + " has been deleted.");
//                System.out.println("Total number of doctors: " + this.doctors.size());
//                return;
//            }
//        }*/
//
//    }

    @Override
    public List<Consultation> getConsultation() {return consultations;}

    @Override
    public void bookConsultation(Doctor doctor, Patient patient, Date consultationDate, String consultationTime, double cost,String patientNotes) {

        Consultation consultation = new Consultation(doctor,patient,consultationDate,consultationTime,cost,patientNotes);
        addConsultation(consultation);

        System.out.println("/n");
        System.out.println("Doctor information");
        System.out.println("Name : " + doctor.getName());
        System.out.println("Surname : " + doctor.getSurname());
        System.out.println("Date of Birth : " + doctor.getDOB());
        System.out.println("Mobile Number : " + doctor.getMobile_number());
        System.out.println("Medical License Number : " + doctor.getMedicalLicenceNumber());
        System.out.println("Specialization : " + doctor.getSpecialization());

        System.out.println("Patient information");
        System.out.println("Patient ID : " + patient.getPatient_id());
        System.out.println("Name : " + patient.getName());
        System.out.println("Surname : " + patient.getSurname());
        System.out.println("Date of Birth : " + patient.getDOB());
        System.out.println("Mobile Number : " + patient.getMobile_number());
        System.out.println("Notes : " + patient.getPatientNotes());

        System.out.println("Consultation information");
        System.out.println("Doctor : " + consultation.getDoctor().getName()  + " " + consultation.getDoctor().getSurname());
        System.out.println("Patient : " );
        System.out.println("Date : " + consultation.getDate());
//        System.out.println("Time : " + consultation.getTime);
        System.out.println("Patient information");
        System.out.println("Cost" + cost);



    }

    @Override
    public void addImage(File image) {
        try {
            // Read the image file into a byte array
            byte[] imageBytes = Files.readAllBytes(image.toPath());
            // Encrypt the image bytes
            String KEY = "1Hbfh667adfDEJ78";
            String encryptedImage = encrypt(new String(imageBytes), KEY);
            // Add the encrypted image to the list of images
//            imagesList.add(encryptedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean checkAvailability(Doctor doctor, Patient patient, Date consultationDate, String consultationTime){
        if(doctors.contains(doctor)){
            System.out.println("Doca not found in the list");

        }
        return false;
    }




    public void addConsultation(Consultation consultation) {
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }
}

