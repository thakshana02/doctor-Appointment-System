import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame {


    private JPanel mainPanel;

    private JTable doctorsTable; //new

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
    private JTextField consultationDateField;
    private JTextField consultationTimeField;

    private JTextField availabilityDateField;         //private JTextField availabilityDateField;
    private JTextField availabilityTimeField;         //private JTextField availabilityTimeField;


    private JButton checkConsultationsButton;

    private JButton sortButton;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField;




    public GUI(){

        super("Testing");
        setLayout(new FlowLayout());


        textField1 = new JTextField(10);
        add(textField1);

        textField2 = new JTextField(10);
        add(textField2);

        textField3 = new JTextField(10);
        textField3.setEditable(false);
        add(textField3);

        passwordField = new JPasswordField("Hidden");
        add(passwordField);

        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);






//        setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
//
//
//        add(new JLabel("First Name"));
//        add(new TextField(8));
//
//        add(new JLabel("Middle Name"));
//        add(new TextField(8));
//
//        add(new JLabel("Last Name"));
//        add(new TextField(8));



    }

    private class TextFieldHandler implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent event) {

            String string = "";

            if (event.getSource() == textField1)
                string = String.format("textfield1 : %s",event.getActionCommand());

            if (event.getSource() == textField2)
                string = String.format("textfield2 : %s",event.getActionCommand());

            if (event.getSource() == textField3)
                string = String.format("textfield3 : %s",event.getActionCommand());

            if (event.getSource() == passwordField)
                string = String.format("textfield1 : %s",new String(passwordField.getPassword()));

            JOptionPane.showMessageDialog(null,string);



        }
    }

    public static void main(String[] args) {

        GUI frame = new GUI();
        frame.setTitle("ShowFLowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(325,100);



//        JFrame frame = new JFrame("My frame");
//
//        JButton jbtOK = new JButton("OK");
//        frame.add(jbtOK);
//
//        frame.setSize(400,300);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//
//        // Create a button with text OK
//  JButton jbtOK = new JButton("OK");
//
//        // Create a label with text "Enter your name: "
//        JLabel jlblName = new JLabel("Enter your name: ");
//
//        // Create a text field with text "Type Name Here"
//        JTextField jtfName = new JTextField("Type Name Here");
//
//        // Create a check box with text bold
//        JCheckBox jchkBold = new JCheckBox("Bold");
//
//        // Create a radio button with text red
//        JRadioButton jrbRed = new JRadioButton("Red");
//
//        // Create a combo box with choices red, green, and blue
//        JComboBox jcboColor = new JComboBox(new String[]{"Red",
//                "Green", "Blue"});
    }

}








