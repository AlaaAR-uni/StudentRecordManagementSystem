
package SRMS;

import java.util.ArrayList;

public class DepartmentReport extends Report {

    @Override
    public void generate(ArrayList<Student> students) {
        System.out.println("Department Report");

        String currentDept = ""; 

        for (Student s : students) {
            String deptName = s.getDepartment().getDeptName();

            
            if (!deptName.equals(currentDept)) {
                currentDept = deptName;
                System.out.println("\nDepartment: " + deptName);
            }

            
            System.out.println("- " + s.getPerson().getName() +
                               " (ID: " + s.getId() + ")");
        }
    }
}
           
        
    
    
    

