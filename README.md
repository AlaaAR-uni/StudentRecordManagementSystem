## Student Record Management System (SRMS)

This project is part of the IT214 course.
We developed a program called **Student Record Management System (SRMS)**.  
It manages student records by allowing saving, updating, deleting, searching, and generating reports.

## Classes in the project
- **Student**: keeps student id, name, age, GPA, level, and department.
- **Person**: contains personal information such as name, age, and nationality.
- **Department**: represents department number and name.
- **StudentFileManager**: saves and loads students from a file called "students.txt".
- **AutoSaveThread**: runs in the background to save students automatically.
- **Report (abstract)**: parent class for reports.
- **GPA**: generates GPA report for students.
- **DepartmentReport**: generates report for students by department.
- **SRMS**: the main class with "main()" to run the system.


##  Features
- Add student  
- Delete student  
- Update student information  
- Search by ID  
- Save records to file  
- Load records from file  
- Auto-save using Multithreading  
- Generate GPA report  
- Generate Department report  


## How to run
1. Open the project in NetBeans.
2. Run the file "SRMS.java".
3. The menu will appear and you can add, delete, search, or update students.
4. You can also generate GPA report or Department report.

## UML Diagram

We created a UML diagram using PlantUML.  
It shows all classes, attributes, methods, and the relations (inheritance, composition, aggregation, usage).

<img width="400" height="300" alt="SRMS_uml" src="https://github.com/user-attachments/assets/ed9d72fb-09e1-411c-aa00-ec19e73dbc28" />

# Team members:

-Alaa Raslan.

-Lubabah Majeed.
