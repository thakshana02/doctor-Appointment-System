import java.util.Date;

public class Person {

        private String name;
        private String surname;
        private Date DOB;
        private int mobile_number;

        public Person(String name, String Surname, Date DOB, int mobile_number ){
            this.name = name;
            this.surname = Surname;
            this.DOB = DOB;
            this.mobile_number = mobile_number;

        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }


        public String getSurname() {
            return surname;
        }
        public void setSurname(String surname) {
            this.surname = surname;
        }


        public Date getDOB() {
            return DOB;
        }
        public void setDOB(Date DOB) {
            this.DOB = DOB;
        }


        public int getMobile_number() {
            return mobile_number;
        }
        public void setMobile_number(int mobile_number) {
            this.mobile_number = mobile_number;
        }



    }




