package LA2Q2;



public class StudentGrade implements Comparable <StudentGrade> {
    // Defining three private fields
     private String firstName;
     private String lastName;
     private int grade;

     public StudentGrade() { // Empty method
     }

     public StudentGrade(String firstName, String lastName, int grade) { // Constructor with our private fields
         this.firstName = firstName;
         this.lastName = lastName;
         this.grade = grade;
     }

     public double getGrade() { // getter method for grade
         return grade;
     }

     public void setGrade(int grade) { // setter method for grade
         this.grade = grade;
     }

     public String getFirstName() { // getter method for first name
         return firstName;
     }

     public void setFirstName(String firstName) { // setter method for first name
         this.firstName = firstName;
     }

     public String getLastName() { // getter method for last name
         return lastName;
     }

     public void setLastName(String lastName) { //  setter method for last name
         this.lastName = lastName;
     }

     @Override
     public String toString() { // toString method to print formatted
         String stringLine =  String.format("\n%20s %1s \t: %5d ", firstName,lastName, grade);
         return stringLine;
     }

     public static void printArray(StudentGrade[] a) { // print array method
        for(int i = 0; i< a.length; i++){
            System.out.print(a[i].toString());
        }
     }



     public int compareTo(StudentGrade sg){ // compareTo method
         int rv = 0;
         if (this.grade > sg.grade){
             rv = 1;
         }
         else if(this.grade < sg.grade){
             rv = -1;
         }
         else{
             rv = 0;
         }
         return rv;
     }


 }



