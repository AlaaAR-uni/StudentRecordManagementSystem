
package SRMS;

import java.util.ArrayList;
 /*abstaract class with abstract method used in DepartmentReport 
and GPA to print a report with all department and gpa*/
public abstract class Report {
    public abstract void generate(ArrayList<Student> students);
 
}
