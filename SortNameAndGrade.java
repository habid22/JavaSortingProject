package LA2Q2;

// Imports
import java.util.Collections;
import java.util.Vector;


public class SortNameAndGrade {
    public static void myHeader(int labE_number, int q_number) { // Header
        System.out.println("=================================================");
        System.out.println("Lab Assignment " + labE_number + "-" + "Q" + q_number);
        System.out.println("Prepared by: " + "Hassan" + " Abid Amin");
        System.out.println("Student Number: " + "251219098");
        System.out.println("Goal of this Exercise: " + "Sorting Lists based on Grades and Names");
        System.out.println("================================================= \n");
    }

        public static void myFooter(int labE_number, int q_number) { // Footer

            System.out.println("\n" + "=================================================");
            System.out.println("Completion of Lab Assignment " + labE_number + "-" + "Q" + q_number + " is successful!");
            System.out.println("Signing off -" + " Hassan");
            System.out.println("=================================================");
        }
    public static void main(String[] args) {
        myHeader(2,2);

        // Given Arrays
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26)};

        // Creating StudentGrade objects
        StudentGrade s1 = new StudentGrade(fnArray[0], lnArray[0], grd[0]);
        StudentGrade s2 = new StudentGrade(fnArray[1], lnArray[1], grd[1]);
        StudentGrade s3 = new StudentGrade(fnArray[2], lnArray[2], grd[2]);
        StudentGrade s4 = new StudentGrade(fnArray[3], lnArray[3], grd[3]);
        StudentGrade s5 = new StudentGrade(fnArray[4], lnArray[4], grd[4]);
        StudentGrade s6 = new StudentGrade(fnArray[5], lnArray[5], grd[5]);
        StudentGrade s7 = new StudentGrade(fnArray[6], lnArray[6], grd[6]);
        StudentGrade s8 = new StudentGrade(fnArray[7], lnArray[7], grd[7]);
        // Creating Vector with StudentGrade as the tag
        Vector<StudentGrade> sg = new Vector<>();

        // Adding objects into Vector List
        sg.addElement(s1);
        sg.addElement(s2);
        sg.addElement(s3);
        sg.addElement(s4);
        sg.addElement(s5);
        sg.addElement(s6);
        sg.addElement(s7);
        sg.addElement(s8);

        //Unsorted List Print Statement
        System.out.println("Unsorted Array ........................\n" + sg.toString().replace("[", " ").replace(",", " ").replace("]", " ") + "\n");

        StudentGrade student = new StudentGrade(); // new object
        Collections.sort(sg, StudentGrade::compareTo); // Collections sort method to compare to print in descending order by grades
        System.out.println("Sorted by Grades ......................\n" + sg.toString().replace("[", " ").replace(",", " ").replace("]", " ") + "\n");

        // Creating Array with length with size of fnArray
        StudentGrade[] studentArray = new StudentGrade[fnArray.length];
        sg.copyInto(studentArray); // using vector method to copy sg vector elements into this array

        // insertion sort method
        insertionSort(studentArray, 1);
        System.out.println("Sorted by First Names ..................");
        StudentGrade.printArray(studentArray); // calling static printArray
        System.out.println("\n");


        insertionSort(studentArray, 2);
        System.out.println("Sorted by Last Names ..................");
        StudentGrade.printArray(studentArray); // calling static printArray
        System.out.println("\n");

        myFooter(2,2);
    }

    public static void insertionSort(StudentGrade[] array, int keyValue) { // method for insertion sort
        int j = 0;
        if (keyValue == 1) { // sorting by firstNames
            for (int i = 1; i < array.length; i++) { // loop to iterate through at first index till the end
                int currentIndex = i;
                StudentGrade key = array[i]; // sets key to index value
                for (j = i - 1; j >= 0 && array[j].getFirstName().compareTo(key.getFirstName()) < 0; j--) { // method to compare firstNames using compareTo
                    array[j + 1] = array[j];
                }
                array[j + 1] = key;
            }
        } else {
            for (int i = 1; i < array.length; i++) { // sorting by lastNames
                StudentGrade key = array[i];
                for (j = i - 1; j >= 0 && array[j].getLastName().compareTo(key.getLastName()) > 0; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = key;
            }
        }
    }
}






