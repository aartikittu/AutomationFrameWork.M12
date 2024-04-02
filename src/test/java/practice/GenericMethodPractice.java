package practice;

public class GenericMethodPractice 
{
	public static void main(String[] args) 
	{
		int c=add(42,56);
		System.out.println(c);
		float c1=add(c,88.88f);
		System.out.println(c1);
		int ans=(int) sub(c1,5);
		System.out.println(ans);
		float ans1=add(ans,88.88f);
		System.out.println(ans1);
		
	}
	public static int add(int a, int b)
	{
		int c=a+b;
		return c;
	}
	public static float add(float a, float b)
	{
		float c=a+b;
		return c;
	}
	public static int sub(int a, int b)
	{
		int c=a-b;
		return c;
	}
	public static float sub(float a, float b)
	{
		float c=a-b;
		return c;
	}
}
