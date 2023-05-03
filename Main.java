import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// TODO: first create your Student class

public class Main
{
    public static void main(String[] args)
    {
        // TODO: make an ArrayList of type Double (for the constants)
        // TODO: make a LinkedList of type Student (for the students)
        // TODO: call a method to load constants, returning an ArrayList of Doubles
        // TODO: call a method to load students, returning a LinkedList of Students
        loadStudents();
        List<Student> students = new LinkedList<Student>(loadStudents());
        loadConstant();
        List<Double>constants = new ArrayList<Double>(loadConstant());
        // TODO: call the printStuff method with the list of constants
        // TODO: call the printStuff method with the list of students
        System.out.println("Students Original: ");
        printStuff(students.toArray());
        System.out.println("Constants: ");
        printStuff(constants.toArray());
        // TODO: sort the list of students with Collections.sort()
        System.out.println("Sorted Students: ");
           Collections.sort(students);
        // TODO: call the printStuff method again with the list of students
        printStuff(students.toArray());
        // TODO: call the trimStudents() method
        System.out.println("Trim Students: ");
        trimStudents((LinkedList<Student>) students,90);
        // TODO: call the printStuff method again with the list of students
        printStuff(students.toArray());
    }
    
    // TODO: create a method loadConstants() which returns an ArrayList of Doubles

    // TODO: uncomment this method below

    private static LinkedList<Student> loadStudents()
    {
        File file = new File("res/roster.csv");
        Scanner reader;

        try
        {
            reader = new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Could not find file: " + file.toPath());
            return null;
        }

        LinkedList<Student> students = new LinkedList<Student>();

        reader.nextLine(); // eat header
        while (reader.hasNext())
        {
            String line = reader.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",\n");

            String last = tokenizer.nextToken();
            String first = tokenizer.nextToken();
            float grade = Float.valueOf(tokenizer.nextToken());

            Student s = new Student(first, last, grade);
            students.add(s);
        }

        return students;
    }
    private static ArrayList<Double> loadConstant()
    {
        File file = new File("res/constants.txt");
        Scanner reader;
        try{
            reader = new Scanner(file);
        }
        catch (FileNotFoundException E)
        {
            System.out.println("File not found!!!");
            return null;
        }
        ArrayList<Double> constants = new ArrayList<Double>();
        while(reader.hasNextLine())
        {
            Double num = Double.valueOf(reader.nextLine());
            constants.add(num);
        }
        return constants;
    }
    // TODO: create a printStuff() method that takes a List of anything and prints it
    private static <E> void printStuff(E[] stuff)
    {
        for(E element: stuff)
        {
            System.out.print(element + " , ");
            System.out.println();
        }
    }
    private static void trimStudents(List<Student>stuff,float grade)
    {
        Iterator<Student> itr = stuff.iterator();
        
        while(itr.hasNext())
        {
            Student s = itr.next();

            if(s.getGrade() < grade)
                {
                    itr.remove();
                }
        }
    }
    // TODO: create a trimStudents() method that takes a LinkedList of Students
    // and a double for the filter amount, which then iterates through the
    // LinkedList of Students with an Iterator and removes any Student with
    // a grade less than 90
}
