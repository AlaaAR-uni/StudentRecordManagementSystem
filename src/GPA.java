package SRMS;

import java.util.ArrayList;
import java.util.Comparator;

public class GPA extends Report {
   //methode from abstract class to print gpa 
    public void generate(ArrayList<Student> students) {
        System.out.println("GPA Report");

        // loop to print the student Info
        for (Student st : students) {
            System.out.println("Student ID: " + st.getId());
            System.out.println("Student Name: " + st.getPerson().getName());
            System.out.println("GPA: " + st.getGpa());
            System.out.println(); 
        }

    }

}
