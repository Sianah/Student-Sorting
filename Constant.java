public class Constant
{
    private int mNumbers;

    public Constant(int numbers)
    {
        mNumbers = numbers;
    }
    public int getNumbers()
    {
        return mNumbers;
    }
    public String toString()
    {
        return "Constant: " + getNumbers();
    }
}
