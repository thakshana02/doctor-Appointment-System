

import java.io.File;
import java.util.Date;
import java.util.List;

public interface SkinConsultationManager {


        void addDoctor(Doctor doctor);
        void removeDoctor(Doctor doctor);

//        List<Doctor> getDoctors(Date consultationDate,String consultationTime);
//


        List<Doctor> getDoctors();
        List<Doctor> getPatients();










        void cancelConsultation(Consultation consultation);

        void bookConsultation(Doctor doctor, Patient patient, Date date, String timesSlot, Doctor selectedDoctor, Date consultationDateTime);

        List<Consultation> getConsultation();

        void bookConsultation(Doctor doctor, Patient patient, Date consultationDate, String consultationTime, double cost,String notes);

        void addImage(File selectedFile);


        // public List<Doctor> getAvailableDoctors(Date ConsultationDate, String ConsultationTime)






        //        void bookConsultation(Doctor doctor, Patient patient, Date date, String timesSlot, Doctor selectedDoctor, Date consultationDateTime);
        //        void bookConsultation(Doctor doctor, Patient patient, Date date, String timesSlot,Doctor selectedDoctor,Date consultationDateTime);


 //       void bookConsultation(Doctor doctor, Patient patient, Date date, String timesSlot, Doctor selectedDoctor, Date consultationDateTime);






}
