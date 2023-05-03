public class Student implements Comparable{
    private String mLastName;
    private String mFirstName;
    private float mGrade;

    public Student(String FirstName, String LastName, float Grade)
    {
        mFirstName = FirstName;
        mLastName = LastName;
        mGrade = Grade;
    }
    public String getFirstName()
    {
        return mFirstName;
    }
    public String getLastName()
    {
        return mLastName;
    }
    public float getGrade()
    {
        return mGrade;
    }
public String toString()
{
    return "First Name: " + getFirstName() + " Last Name: " + getLastName() + " Grade: " + getGrade();
}

    @Override
    public int compareTo(Object o)//compareTo always uses an integer value
    {
        Student grade = (Student) o;
        if(getGrade() > grade.getGrade())
        {
            return 1;
        }
        else if (getGrade() < grade.getGrade())
        {
            return -1;
        }
        else

            return 0;

    }

}
