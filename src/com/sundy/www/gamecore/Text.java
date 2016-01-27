package com.sundy.www.gamecore;
import java.awt.Color;

import com.rupeng.game.GameCore;

public class Text
{
	private int num = NumerManager.instance.getNum();// ���ֵı��

	/**
	 * ���캯��
	 * @param text ��ʾ������
	 * @param px x����
	 * @param py y����
	 * @param color ���ֵ���ɫ
	 * @param TextFontSize ���ֵĳߴ�
	 */
	public Text(String text,int px,int py,Color color,int TextFontSize)
	{
		GameCore.createText(num, text);
		GameCore.setTextFontSize(num, TextFontSize);
		GameCore.setTextPosition(num, px, py);
		GameCore.setTextColor(num, color);
	}
	
	/**
	 * ���캯�� 
	 * @param text ��ʾ������
	 */
	public Text(String text)
	{
		GameCore.createText(num, text);
	}
	
	/**
	 * �������ֵı��
	 * @return
	 */
	public int getNum()
	{
		return num;
	}
	
	/**
	 * ������ʧ
	 */
	public void hideText()
	{
		GameCore.setText(num, "");
	}
}
