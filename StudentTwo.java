import java.util.ArrayList;

public class Student extends Person {
    private String course, studentId;
    private Subject[] subjects;
    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }


    void setCourse(String course){
        this.course = course;
    }

    void setSubjects(Subject[] subjects){
        this.subjects = subjects;
    }

    String getCourse(){
        return course;
    }

    Subject[] getSubjects(){
        return subjects;
    }
}