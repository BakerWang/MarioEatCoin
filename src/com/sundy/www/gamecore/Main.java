package com.sundy.www.gamecore;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;
/**
 * ����ʵ�ַ��������� Frame��������棡
 * @author Administrator
 *
 */
public class Main implements Runnable
{
	public static int whichFrame = 0;
	//public static int whichFrame = 0;

	public static void main(String[] args)
	{

		GameCore.start(new Main());
	}

	@Override
	public void run()
	{
		// ������ʼ����
		new Frame().gameStartFrame();

		//���ϼ������ж���Ҫ�����Ǹ�����
		while (true)
		{
			// ���which=1 ������Ϸ��ʼ�Ļ���
			if (whichFrame == 1)
			{
				new Frame().gameStartFrame();
			}
			
			// ���which=2 �����Խ�ҵĻ���
			else if (whichFrame == 2)
			{
				new Frame().eatCoinFrame(0);
			}
			//���which=3������Ϸ��������
			else if(whichFrame==3)
			{
				new Frame().gameHelpFrame();
			}
		}

	}

}
