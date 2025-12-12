package SRMS;

public class Student {

    private String id;
    private Person person;      //composition
    private double gpa;
    private int level;
    private Department department;  //aggregation

    public Student(String id, String name, int age, String nationality, double gpa, int level, Department department) {
        this.id = id;
        this.person = new Person(name, age, nationality);  //composition
        this.gpa = gpa;
        this.level = level;
        this.department = department;

        //to creat student object :Student st1 = new Student("123", "alaa",21,"syrian",4.95,5,dept);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    

    @Override
    public String toString() {
        return "------Student------\n" + " id: " + id + "\n name: " + person //by default call the method toString() in class Person 
                + "\n gpa: " + gpa + "\n year: " + level + "\n " + department //by default call the method toString() in class department
                + "\n---------------------";
    }

}
