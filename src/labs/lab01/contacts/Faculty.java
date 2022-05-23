package labs.lab01.contacts;

import java.util.Arrays;

public class Faculty {
    private String name;
    private Student[] students;

    public Faculty(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public int countStudentsFromCity(String cityName){
        int numberOfStudents = 0;
        for(Student s: students)
            if (s.getCity().equals(cityName))
                numberOfStudents++;
        return numberOfStudents;
    }

    public Student getStudent(long index){
        Student s = null;
        for(Student student: students)
            if (student.getIndex() == index)
                s = student;
        return s;
    }

    public double getAverageNumberOfContacts(){
        double average = 0;
        double currentAverage = 0;
        for (Student student : students){
            currentAverage += student.getNumberOfContacts();
        }
        average += currentAverage;
        currentAverage = 0;
        return average/students.length;
    }

    public Student getStudentWithMostContacts(){return null;}



    @Override
    public String toString() {
        return "{\"fakultet\":\"" + name + "\", " +
                "studenti:" + Arrays.toString(students) + '}';
    }
}
