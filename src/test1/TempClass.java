package test1;
//һ����ʱ���࣬�������һЩ���õķ���
//2016��1��20��15:57:35
public class TempClass
{
    //ʵ�ֺϲ������ַ�������
	//���غϲ����ַ�������
	String [] concat(String s1[],String s2[])
	{
		String []conStr =new String[s1.length+s2.length];
		
		for (int i = 0; i < s1.length; i++)
		{
			//String string = s1[i];
			conStr[i]=s1[i];
		}
		
		for (int i = 0; i < s2.length; i++)
		{
			//String string = conStr[i];
			conStr[s1.length+i]=s2[i];
			
		}		
		return conStr;
	}
	
	
	
}
