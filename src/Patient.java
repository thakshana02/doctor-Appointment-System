import java.util.Date;

public class Patient extends Person {

    private int patient_id;
    private String patientNotes;

    public Patient(int patient_id,String patientName, String patientSurname, Date patientDOB, int patientmobile_Number,String patientNotes) {
        super(patientName,patientSurname, patientDOB, patientmobile_Number);
        this.patient_id = patient_id;
        this.patientNotes=patientNotes;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatientNotes(String patientNotes){this.patientNotes = patientNotes;}

    public String getPatientNotes(){return patientNotes;}



}
