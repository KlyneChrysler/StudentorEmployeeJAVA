class Employee extends Person{
    private String position;
    private double salary;

    void setPosition(String position){
        this.position = position;
    }

    void setSalary(double salary){
        this.salary = salary;   
    }

    String getPosition(){
        return position;
    }

    double getSalary(){
        return salary;
    }
}