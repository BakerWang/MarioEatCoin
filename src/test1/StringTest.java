package test1;

public class StringTest implements Runnable
{

	@Override
	public void run()
	{
		// TODO �Զ����ɵķ������

	}

	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������

		String[] strs =
		{ "123", "456", "789" };
		int[] nums = new int[strs.length];

		for (int i = 0; i < strs.length; i++)
		{

			nums[i]=Integer.parseInt(strs[i]);
		}
		
		for (int i = 0; i < nums.length; i++)
		{
			//int j = nums[i];
			System.out.println(nums[i]);
			
		}
	}
}
