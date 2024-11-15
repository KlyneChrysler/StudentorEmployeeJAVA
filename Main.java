import java.util.*;

class Main{
    static Scanner scan = new Scanner ( System.in );

    public static void main ( String[] args ) {

        int[] types = new int[5];
        int index = 0;

        while ( index < types.length ) { 
            try {
                System.out.print("ENTER \"1\" IF STUDENT OR \"2\"  IF EMPLOYEE: ");
                int number = Integer.parseInt(scan.nextLine());
                if ( number == 1 || number == 2 ) {
                    types[index] = number;
                    index++;
                } else {
                    throw new ExceptionHandler("ERROR, PLEASE ENTER 1-2 ONLY.");
                }
            } catch ( NumberFormatException e ) {
                System.out.println("INVALID INPUT. PLEASE ENTER 1-2 ONLY.");
            } catch ( ExceptionHandler ex ) {
                System.out.println("ERROR. " + ex.getMessage());
            }        
        }
        
        Student[] studentArray = new Student[studentCounter(types)];
        Employee[] employeeArray = new Employee[employeeCounter(types)];

        for ( int i = 0; i < studentArray.length; i++ ) {
            System.out.println("*******STUDENT NO. " + (i + 1) + " *******");
            Student s = getStudentInfo();
            studentArray[i] = s;
        }

        for ( int i = 0; i < employeeArray.length; i++ ) {
            System.out.println("*******EMPLOYEE NO. " + (i + 1) + " *******");
            Employee e = getEmployeeInfo();
            employeeArray[i] = e;
        }

        boolean flag = true;
        while ( flag ) {
            System.out.println("===================");
            System.out.print("ENTER NUMBER TO PERFORM ACTION: \n1 - DISPLAY STUDENTS\n2 - DISPLAY EMPLOYEE\n3 - STOP PROGRAM\n> ");
            switch ( Integer.parseInt(scan.nextLine()) ) {
                case 1:
                    System.out.println("===================");
                    for ( Student studentToDisplay : studentArray ) {
                        displayStudentInfo(studentToDisplay);
                    }
                    break;

                case 2: 
                    System.out.println("===================");
                    for ( Employee employeeToDisplay : employeeArray ) {
                        displayEmployeeInfo(employeeToDisplay);
                    }
                    break;

                case 3:
                    flag = false;
                    break;

                default:
                    System.out.println("ERROR, PLEASE TRY AGAIN.");
            }
        }
    }

    static int studentCounter(int[] types){
        int qty = 0; 
        for (int i = 0; i < types.length; i++) {
            if(types[i] == 1){
                qty++;
            }
        }
        return qty;
    }

    static int employeeCounter(int[] types){
        int quantity = 0; 
        for ( int i = 0; i < types.length; i++ ) {
            if ( types[i] == 2 ) {
                quantity++;
            }
        }
        return quantity;
    }

    static Student getStudentInfo(){
        Student student = new Student();
        System.out.print("ENTER NAME: ");
        student.setName(scan.nextLine());
        System.out.print("Enter Course: ");
        student.setCourse(scan.nextLine());
        
        Subject[] subjects = new Subject[5];
        for ( int loop = 0; loop < subjects.length; loop++ ) {
            Subject subs = new Subject();
            System.out.print("ENTER SUBJECT NO. " + (loop+1) + ": ");
            subs.setSubjectName(scan.nextLine());
            System.out.print("Enter Grade: ");
            subs.setGrade(Double.parseDouble(scan.nextLine()));    
            subjects[loop] = subs;
        }

        student.setSubjects(subjects);
        return student;
    }

    static Employee getEmployeeInfo(){
        Employee employee = new Employee();
        System.out.print("ENTER NAME: ");
        employee.setName(scan.nextLine());
        System.out.print("ENTER POSITION: ");
        employee.setPosition(scan.nextLine());
        System.out.print("ENTER SALARY: ");
        employee.setSalary(Double.parseDouble(scan.nextLine()));
        return employee;
    }

    static void displayStudentInfo(Student student){
        System.out.println("*****STUDENT INFO*****");
        System.out.println("NAME: " + student.getName());
        System.out.println("COURSE: " + student.getCourse());
        System.out.println("SUBJECTS: ");   
        for ( Subject sub : student.getSubjects() ) {
            System.out.println(sub.getSubjectName() + " - Grade: " + sub.getGrade());
        }
        System.out.println("**********************");

    }

    static void displayEmployeeInfo(Employee employee){
        System.out.println("*****EMPLOYEE INFO*****");
        System.out.println("NAME: " + employee.getName());
        System.out.println("POSITION: " + employee.getPosition());
        System.out.printf("SALARY: %.2f\n", employee.getSalary());   
        System.out.println("***********************");
    }
}