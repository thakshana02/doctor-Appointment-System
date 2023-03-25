import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("-----------------------------------------");
            System.out.println("------Westminster Skin Consultation------");
            System.out.println("-----------------------------------------");
            System.out.println("-------------------Menu------------------");
            System.out.println("-----------------------------------------");
            System.out.println("1. Add a new doctor");
            System.out.println("2. Delete a doctor from list");
            System.out.println("3. Print list of doctors");
            System.out.println("4. Save to file");
            System.out.println("5. Exit");
            System.out.println("6. open GUI");
            System.out.println("-----------------------------------------");
            System.out.print("Enter your choice: ");
            System.out.println("\n");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // discard invalid input
                continue;
            }

            switch (choice) {

                //Add a new Doctor
                case 1:

                    //getting name as the input
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    while (!name.matches("^[a-zA-Z]*$")) {
                        System.out.println("Error: Specialization must contain only letters.");
                        System.out.print("Enter specialization: ");
                        name = scanner.next();
                    }

                    //to get only letters for the name

                    //getting surname as the input
                    System.out.print("Enter surname: ");
                    String surname = scanner.next();
                    while (!surname.matches("^[a-zA-Z]*$")) {
                        System.out.println("Error: Specialization must contain only letters.");
                        System.out.print("Enter specialization: ");
                        surname = scanner.next();
                    }

                    //to get only letters for the surname

                    //getting Time as the input
                    /*System.out.print("Enter Date and Time :");
                    String TimeStr = scanner.next();
                    LocalDateTime dateTime = LocalDateTime.of(2022, 12, 21, 10, 0);


                    LocalDateTime Time = null;
                    while (Time == null) {
                        try {
                            Time = dateTime.parse(TimeStr);
                        }catch (ParseException e){
                            System.out.println("Error: Invalid date format. Please enter a date in the format dd/mm/yyyy.");

                            TimeStr = scanner.next();
                        }
                    }*/
                    //getting Date of Birth as the input
                    System.out.print("Enter date of birth (dd/mm/yyyy): ");
                    String DateStr = scanner.next();
                    DateFormat dateF = new SimpleDateFormat("dd/mm/yyyy");
                    Date DOB = null;
                    while (DOB == null) {
                        try {
                            DOB = dateF.parse(DateStr);
                        } catch (ParseException e) {
                            System.out.println("Error: Invalid date format. Please enter a date in the format dd/mm/yyyy.");

                            DateStr = scanner.next();
                        }
                    }

                    //getting mobile number as the input
                    int mobile_Number ;
                    while (true) {
                        try {
                            System.out.print("Enter mobile number: ");

                            mobile_Number = scanner.nextInt();
                            break; // exit the loop if a valid integer was entered
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Invalid input. Please enter a valid integer.");
                            scanner.nextLine(); // consume the invalid input and discard it
                        }
                    }
                    //getting medical_License_Number as the input
                    int medical_License_Number ;
                    while (true) {
                        try {
                            System.out.print("Enter medical license number: ");
                            medical_License_Number = scanner.nextInt();
                            break; // exit the loop if a valid integer was entered
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Invalid input. Please enter a valid integer.");
                            scanner.nextLine(); // consume the invalid input and discard it
                        }
                    }
                    //getting specialization as the input
                    System.out.print("Enter specialization: ");
                    String specialization = scanner.next();
                    while (!specialization.matches("^[a-zA-Z]*$")) {
                        System.out.println("Error: Specialization must contain only letters.");
                        System.out.print("Enter specialization: ");
                        specialization = scanner.next();
                    }





                    System.out.print("Enter available Date (dd/mm/yyyy): ");
                    String availableDateStr = scanner.next();
                    DateFormat aD = new SimpleDateFormat("dd/mm/yyyy");
                    Date availableDate = null;
                    while (availableDate == null) {
                        try {
                            availableDate = aD.parse(availableDateStr);
                        } catch (ParseException e) {
                            System.out.println("Error: Invalid date format. Please enter a date in the format dd/mm/yyyy.");
                            System.out.println("Enter Date");

                            availableDateStr = scanner.next();
                        }
                    }

                    System.out.print("Enter available time: ");
                    String availableTime = scanner.next();


                    Doctor doctor = new Doctor(name, surname, DOB, mobile_Number, medical_License_Number, specialization,availableTime,availableDate);
                    manager.addDoctor(doctor);
                    break;

                case 2:
                    //Delete Doctor Details
                    System.out.print("Enter medical license number: ");
                    medical_License_Number = scanner.nextInt();
                    manager.deleteDoctor(medical_License_Number);
                    break;

                case 3:
                    //Print all the Doctor Details
                    manager.printDoctors();
                    break;

                case 4:
                    //Save the Doctor Details to a Fle
                    manager.saveToFile();
                    break;

                case 5:
                    //User exits the program
                    System.out.println("Thank You. Exiting the Program");
                    System.exit(0);




                case 6:
                    //Open GUI
                    new WestminsterSkinConsultationManagerGUI(manager);
                    System.out.println("Running GUI.................");
                    break;

                case 7:
                    GUIRunner.main();
                    System.out.println("GUI loaded Successfully");
                    break;


                default:
                    //User prints an invalid choice
                    System.out.println("Invalid choice.");
                    break;

            }
        }
    }

}
