package com.sundy.www.gamecore;

/**
 * ����ģʽ
 */
public class NumerManager
{
   private static int num;//���
   public static  NumerManager instance = new NumerManager();//ʵ��
   
   /**
    * �õ����
    * @return ����һ��û��ʹ�õı��
    */
   public int getNum()
   {
	   return num++;//��ֹ�ظ�
   }
   
   /**
    * �����Ĺ��캯��
    */
   private NumerManager(){}
   
   
   
}
