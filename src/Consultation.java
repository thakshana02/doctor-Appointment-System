import java.util.Date;

public class Consultation {
    private Date date;
    private String timeSlot;
    private double cost;
    private String notes;
    private Doctor doctor;
    private Patient patient;

    //    public Consultation(String date, String timeSlot, double cost, String notes) {
//        this.date = date;
//        this.timeSlot = timeSlot;
//        this.cost = cost;
//        this.notes = notes;
//    }
    public Consultation(Doctor doctor, Patient patient, Date date, String timeSlot, double cost, String patientNotes) {
        this.date = date;
        this.timeSlot = timeSlot;
        this.patient =patient;
        this.doctor=doctor;
        this.cost = cost;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return this.timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
