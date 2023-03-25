import java.util.Date;

public class Doctor extends Person {


    //instance variables for the Doctor
    private int MedicalLicenceNumber;
    private String Specialization;
    private String AvailableTime;
    private Date AvailableDate;

    public Doctor(String name, String surname, Date DOB, int mobile_Number, int MedicalLicenceNumber, String Specialization, String AvailableTime, Date AvailableDate) {
        super(name,surname,DOB,mobile_Number);
        this.MedicalLicenceNumber = MedicalLicenceNumber;
        this.Specialization = Specialization;
        this.AvailableTime = AvailableTime;
        this.AvailableDate = AvailableDate;


    }


//    //gui
//    public Doctor(String name, String surname, Date dob, int mobile_number, int MedicalLicenceNumber, String specialisation) {
//        super(name,surname,String.valueOf(dob),mobile_number);
//        this.MedicalLicenceNumber = MedicalLicenceNumber;
//        this.Specialization = specialisation;
//        this.AvailableTime = AvailableTime;
//        this.AvailableDate = AvailableDate;
//    }



    public int getMedicalLicenceNumber() {
        return MedicalLicenceNumber;
    }
    public void setMedicalLicence_number(int MedicalLicenceNumber) {
        this.MedicalLicenceNumber = MedicalLicenceNumber;
    }
    public String getSpecialization() {
        return Specialization;
    }
    public void setSpecialization(String specialization) {
        this.Specialization = specialization;
    }


    public String getAvailableTime(){
        return AvailableTime;}

    public void setAvailableTime(String AvailableTime){
        this.AvailableTime = AvailableTime;
    }

    public Date getAvailableDate(){
        return AvailableDate;}

    public void setAvailableDate(Date AvailableDate){
        this.AvailableDate = AvailableDate;
    }

    public String ToString() {
        return "Doctor name : " + getName() + "\nDoctor Surname : " + getSurname() + "\nDoctor Date of Birth :" +
                getDOB() + "\nDoctor Mobile-Number : " + getMobile_number() + "\nDoctor Medical-License-Number : " + getMedicalLicenceNumber() +
                "\nDoctor Specialization : " + getSpecialization() + "\nAvailable Date : " + getAvailableDate() + "\nAvailable Time : " + getAvailableTime() + "\n\n";
    }




}
