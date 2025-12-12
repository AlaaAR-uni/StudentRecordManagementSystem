package SRMS;

import java.io.*;
import java.util.ArrayList;

public class StudentFileManager {

    private String fileName = "students.txt";


    // Save all students to file

    public void save(ArrayList<Student> students) {    //!!!
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {

            for (Student st : students) {
                pw.println(st.getId() + "," +
                           st.getPerson().getName() + "," +
                           st.getPerson().getAge() + "," +
                           st.getPerson().getNationality() + "," +
                           st.getGpa() + "," +
                           st.getLevel() + "," +
                           st.getDepartment().getDeptName());
            }

            System.out.println("Saved successfully!");

        } catch (Exception e) {
            System.out.println("Error while saving: " + e.getMessage());
        }
    }


    // Load all students from file

    public ArrayList<Student> load() {
        ArrayList<Student> students = new ArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                // Extract
                String id = data[0];
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String nationality = data[3];
                double gpa = Double.parseDouble(data[4]);
                int level = Integer.parseInt(data[5]);
                String deptName = data[6];

                Department dept = new Department(0, deptName);
                Student st = new Student(id, name, age, nationality, gpa, level, dept);

                students.add(st);
            }

            System.out.println("Loaded successfully!");

        } catch (Exception e) {
            System.out.println("Error while loading: " + e.getMessage());
        }

        return students;
    }


    // Add student

    public void addStudent(Student st, ArrayList<Student> list) {
        list.add(st);
        save(list);
    }


    // Delete student

    public boolean deleteStudent(String id, ArrayList<Student> list) {

        for (Student st : list) {
            if (st.getId().equals(id)) {
                list.remove(st);
                save(list);
                return true;
            }
        }
        return false;
    }


    // Search student

    
    public Student search(String id, ArrayList<Student> list) {
        for (Student st : list) {
            if (st.getId().equals(id))
                return st;
        }
        return null;
    }
    
    // UPDATE
    public boolean updateStudent(String id, Student newData, ArrayList<Student> list) {

    for (int i = 0; i < list.size(); i++) {
        Student st = list.get(i);

        if (st.getId().equals(id)) {

            // replace old data with the new one
            list.set(i, newData);

            // save updated list
            save(list);

            return true; // updated found
        }
    }
    return false; // not found
}

}
