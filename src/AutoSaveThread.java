
package SRMS;

import java.util.ArrayList;

//A thread that automatically saves student records every minute.

public class AutoSaveThread extends Thread {

    private ArrayList<Student> students;
    
    //file manager for saving
    private StudentFileManager fileM;
    private boolean run = true;

    public AutoSaveThread(ArrayList<Student> students, StudentFileManager fileM) {
        this.students = students;
        this.fileM = fileM;
    }

    @Override
    public void run() {
        // try and catch
        while (run) {
            try {
                Thread.sleep(60000);//wait 1 minute to autosave
                fileM.save(students);// save
                System.out.println("Auto Save Done.");
            } 
            catch (Exception e) {
                System.out.println("Error in Auto Save");
            }
        }
    }
   //stop autosaving
    public void stopSaving() {
        run = false;
    }
}
