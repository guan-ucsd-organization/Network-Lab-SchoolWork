public class Student implements java.io.Serializable{

    private String name;
    private int grades;
    private int age;

    Student(){
        this("None", 0, 0);
    }
    Student(String name, int age, int grades){
        this.name = name;
        this.age = age;
        this.grades = grades;
    }

    public void print(){
        System.out.println("Name: " + this.name + " age: " + this.age + " grades: " + this.grades);
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }
    public int getGrades(){
        return grades;
    }


}
