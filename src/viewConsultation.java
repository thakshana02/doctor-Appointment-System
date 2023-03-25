import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class viewConsultation extends JFrame {

    private WestminsterSkinConsultationManager manager;



    private JTable consultationTable;
    private JTextArea consultationArea;

    public viewConsultation(){

//        viewConsultation consultationModel = new viewConsultation(Consultations.consultations);
//        JTable table = new JTable(viewConsultation);

            // Set up the doctors table
    String[] columnNames = {"Name", "Surname", "Date of birth", "Mobile number", "Medical license number", "Specialization","Available Date","Available Time"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        this.consultationTable = new JTable(model);
        consultationTable.setPreferredScrollableViewportSize(new Dimension(800, 200));
        consultationTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        consultationTable.setShowGrid(true);
        consultationTable.setGridColor(Color.BLACK);

        

    }




}
