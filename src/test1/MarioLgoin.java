package test1;
//���峬��������ʼ���������
//��װ�˺ܶೣ�õķ���
import java.awt.Color;

import com.rupeng.game.GameCore;

public class MarioLgoin implements Runnable
{

	@Override
	public void run()
	{
		
//��ʼ���� ���ֵ���ʾ
		GameCore.setGameTitle("+++��������+++");
		GameCore.setGameSize(800, 480);// ���ڴ�С����
		GameCore.loadBgView("t01b1a2a2945c2ee923.jpg");// ��������µı���ͼƬ
		GameCore.playSound("Ⱥ�� - FC���������������Ϲ�BGM.mp3", true);

		

		//�������� ���ֵĿ���
		int MarioNum = 0;
		GameCore.createText(MarioNum, "��������");
		GameCore.setTextColor(MarioNum, Color.pink);
		GameCore.setTextFontSize(MarioNum, 50);
		GameCore.setTextPosition(MarioNum, 200, 50);
		
		//1-������Ϸ �����ֿ���
		int singlegame=1;
		GameCore.createText(singlegame, "1-������Ϸ");
		GameCore.setTextColor(singlegame, Color.pink);
		GameCore.setTextFontSize(singlegame, 30);
		GameCore.setTextPosition(singlegame, 200, 150);
		
		//2-˫����Ϸ �����ֿ���
		int doublegame=2;
		GameCore.createText(doublegame, "2-˫����Ϸ");
		GameCore.setTextColor(doublegame, Color.pink);
		GameCore.setTextFontSize(doublegame, 30);
		GameCore.setTextPosition(doublegame, 200, 200);
		
		//3-��Ϸ��ʾ �����ֿ���
		int domegame=3;
		GameCore.createText(domegame, "3-��Ϸ��ʾ");
		GameCore.setTextColor(domegame, Color.pink);
		GameCore.setTextFontSize(domegame, 30);
		GameCore.setTextPosition(domegame, 200, 250);
		
//���������Ļ�ƶ�	
		//��������¾���
		int marioNum=2;
		int marioY=350;
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpriteFlipX(marioNum, true);
		GameCore.setSpritePosition(marioNum, 10, marioY);
		//��������¾���
		GameCore.playSpriteAnimate(marioNum, "walk", true);
		
		//ѭ�����ƶ�����λ�� ʹ���������Ч��
		for(int marioX=10;marioX<=1000;marioX+=7)
		{
			GameCore.setSpritePosition(marioNum, marioX, marioY);
			GameCore.pause(200);
		}
		
		GameCore.pause(30000000);
	}

	

}
