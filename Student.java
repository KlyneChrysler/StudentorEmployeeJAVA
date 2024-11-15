public class Student extends Person {
    String course;
    int yearLevel;
    String[] subjects;

    public void setCourse(String course){
        this.course = course;
    }

    public void setYearLevel(int yearLevel){
        this.yearLevel = yearLevel;
    }

    public void setSubjects(String[] subjects){
        this.subjects = subjects;
    }

    public String getCourse(){
        return course;
    }

    public int getYearLevel(){
        return yearLevel;
    }

    public String[] getSubjects(){
        return subjects;
    }
}