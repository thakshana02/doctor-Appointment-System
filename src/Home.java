import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

public class Home extends JFrame{

//    public Home() {
//        // Set the title and size of the window
//        setTitle("Second Window");
//        setSize(300, 200);
//    }


    private WestminsterSkinConsultationManager manager;


    JFrame frame;
    JButton viewDoctorsButton;
    JButton addConsultation;

    public Home(){
        // Components
        try{
//            ImageIcon homeImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("homeImage.png")));
            JLabel leftPanelLabel = new JLabel();
            JLabel rightPanelLabel = new JLabel();
            viewDoctorsButton = new JButton("View Doctors");
            viewDoctorsButton.setFocusPainted(false);
            viewDoctorsButton.addActionListener(e -> {
//                if(e.getSource() == viewDoctorsButton){
//                    frame.dispose();
//                    new ViewDoctors();
//                }
            });

//            new WestminsterSkinConsultationManagerGUI(manager);
            addConsultation = new JButton("Add a Consultation");
            addConsultation.setFocusPainted(false);
            addConsultation.addActionListener(e -> {
                if(e.getSource() == addConsultation){
                    frame.dispose();

                    new WestminsterSkinConsultationManagerGUI(manager);
//                    addConsultation.loadAvailableConsultations();
//                    addConsultation.loadConsultations();
//                    new addConsultation();
                }
            });
//            leftPanelLabel.setIcon(homeImage);

            // Grid Layout Panel
            JPanel rightInnerPanel = new JPanel(new GridBagLayout());
            rightInnerPanel.setBorder(new EmptyBorder(5,5,5,5));
            JPanel buttonAndTextPanel = new JPanel(new GridLayout(10,1,10,50));
            rightPanelLabel.setText("Choose an option: ");
            buttonAndTextPanel.add(rightPanelLabel);
            buttonAndTextPanel.add(viewDoctorsButton);
            buttonAndTextPanel.add(addConsultation);
            buttonAndTextPanel.setAlignmentY(250);
            rightInnerPanel.add(buttonAndTextPanel);

            // Left Panel
            JPanel leftPanel = new JPanel();
            leftPanel.setBackground(Color.lightGray.brighter());
            leftPanel.setBounds(0,0,500,500);

            // Right Panel
            JPanel rightPanel = new JPanel();
            rightPanel.setBounds(500,0,300,500);



            // Frame
            frame = new JFrame("Westminster Skin Consultations");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800,500);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setResizable(false);
            leftPanel.add(leftPanelLabel);
            rightPanel.add(rightInnerPanel, BorderLayout.CENTER);
            frame.add(leftPanel);
            frame.add(rightPanel);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
