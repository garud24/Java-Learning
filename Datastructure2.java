/* Arrays */
// Here we will loop all about Arrays

import java.util.Arrays;

class Student
{
    int rollNo;
    String name;

    public Student(int rollNo, String name)
    {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{");
        sb.append("rollNo=").append(rollNo);
        sb.append(", name=").append(name);
        sb.append('}');
        return sb.toString();
    }

}
public class Datastructure2 {
    public static void main(String[] args) {
        
        int nums[] = new int[8]; // This is one way to initialize arrays, if you don't want to initialize the value at the time of creation

        int num[] = {10, 9, 9, 7}; // This is to create an array

        // How for loop works in Java
        for(int i = 0; i < num.length; i++)
        {
            System.out.println(num[i]);
        }

        // For loop can also be written as follows
        for(int n: num)
        {
            System.out.println(n);
        }

        // You can also create an array of class

        // if I try to print the object of student class, it should return be something like: Student@251a69d7
        // becuase in Java by default every class extends the Object class and in this class there is a special method called as toString().
        // So everytime you print the object of a class it will called toString().
        Student s = new Student(99, "Himanshu");
        System.out.println(s); // Student{rollNo=99, name=Himanshu}
        /* What we can do is that we can override toString function of the object as you can see in
        the class and we can have in the form of an array*/

        // Arrays of Objects
        Student students[] = new Student[5];

        students[0] = new Student(0, "Himanshu");
        
        String names[] = {"Srushti", "Aniket", "Agustus", "Guss"};
        // or we can use for loop
        for(int i=1; i< students.length; i++)
        {
            students[i] = new Student(i, names[i-1]);
        }

        System.out.println(Arrays.toString(students));
    }
}
