import java.util.*;

public class MainTwo {
    static Scanner scan = new Scanner ( System.in );
    public static void main ( String[] args ) {

        System.out.print("ENTER 1 IF STUDENT, 2 IF EMPLOYEE ");
        try {
            switch ( Integer.parseInt(scan.nextLine()) ) {
                case 1:
                    Student s = getStudentInfo();
                    displayStudent(s);
                    break;

                case 2:  
                    Employee e = getEmployeeInfo();
                    displayEmployee(e);
                    break;

                default:
                    throw new ChoiceNotFound();
            }             
        } catch ( NumberFormatException e ) {
            System.out.println("CHOICE MUST BE A NUMBER.");
        } catch ( ChoiceNotFound e ) {
            System.out.println(e.getMessage());
        }    
    }

    public static Student getStudentInfo(){
        Student student = new Student();
        System.out.print("ENTER NAME: ");
        student.setName(scan.nextLine());
        try {
            System.out.print("ENTER AGE: ");
            int age = Integer.parseInt(scan.nextLine());
            student.setAge(age);
        } catch ( NumberFormatException e ) {
            System.out.println("AGE MUST BE A NUMBER.");
            return null;
        }

        System.out.print("ENTER COURSE: "); 
        student.setCourse(scan.nextLine());

        try {
            System.out.print("ENTER YEAR LEVEL: ");
            int yrlvl = Integer.parseInt(scan.nextLine());
            student.setYearLevel(yearLevel);
        } catch ( NumberFormatException e ) {
            System.out.println("YEAR LEVEL MUST BE A NUMBER.");
            return null;
        }       

        try { 
            System.out.print("ENTER NUMBER OF SUBJECTS: ");
            int numberOfSubjects = Integer.parseInt(scan.nextLine());
            String[] subs = new String[numberOfSubjects];
            for ( int i = 0; i < subs.length; i++ ) {
                System.out.print("ENTER SUBJECT NO." + (i+1) + ": ");
                subs[i] = scan.nextLine(); 
            }
            student.setSubjects(subs);
        } catch ( NumberFormatException e ) {
            System.out.println("NUMBER OF SUBJECTS MUST BE NUMBER.");
            return null;
        }    
        return student;
    }

    public static Employee getEmployeeInfo(){
        Employee employee = new Employee();
        System.out.print("ENTER NAME: ");
        employee.setName(scan.nextLine());
        try {
            System.out.print("ENTER AGE: ");
            int age = Integer.parseInt(scan.nextLine());
            employee.setAge(age);
        } catch ( NumberFormatException e ) {
            System.out.println("AGE MUST BE A NUMBER.");
            return null;
        }
        System.out.print("ENTER POSITION: ");
        employee.setPosition(scan.nextLine());

        try {
            System.out.print("ENTER SALARY: ");
            double salary = Double.parseDouble(scan.nextLine());
            employee.setSalary(salary);
        } catch ( NumberFormatException e ) {
            System.out.println("SALARY MUST BE A NUMBER.");
            return null;
        }
        return employee;
    }

    public static void displayStudent(Student student){
        try {
            System.out.println("*****STUDENT INFO*****");
            System.out.println("NAME: " + student.getName());
            System.out.println("AGE: " + student.getAge());
            System.out.println("COURSE: " + student.getCourse());
            System.out.println("YEAR LEVEL: " + student.getYearLevel());
            System.out.println("SUBJECTS: ");
            for ( String sub : student.getSubjects() ) {
                System.out.println(sub);
            }
        } catch ( NullPointerException e ) {
            System.out.println("OBJECT HAS NO INSTANCE.");
        }
    }

    public static void displayEmployee(Employee employee){
        try {
            System.out.println("*****EMPLOYEE INFO*****");
            System.out.println("NAME: " + employee.getName());
            System.out.println("AGE: " + employee.getAge());
            System.out.println("POSITION: " + employee.getPosition());
            System.out.printf("SALARY: %.2f", employee.getSalary());  
        } catch ( NullPointerException e ) {
            System.out.println("OBJECT HAS NO INSTANCE.");
        }
    }
}