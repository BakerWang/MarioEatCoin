package test1;//2016��1��16��16:37:51

import java.awt.Dimension;

import com.rupeng.game.GameCore;

public class Main4 implements Runnable
{

	@Override
	public void run()
	{
		// TODO �Զ����ɵķ������
		int ball = 0;
		int x = 100, y = 0;// ��ʼ����
		int vx = 2, vy = 1;// �����ٶ� �����ٶ�
		int t = 3; // ʱ��
		Dimension gamesize=GameCore.getGameSize();//�õ������С
		GameCore.createSprite(ball, "ball1");
		GameCore.playSpriteAnimate(ball, "rotate", true);
		GameCore.setSpritePosition(ball, x, y);
		//
		while (true)
		{
			x += vx * t;
			y += vy * t;
			GameCore.setSpritePosition(ball, x, y);
			GameCore.pause(10);

			if (x >= gamesize.width-20 || x <= 0)
			{
				vx *= -1;
			}
			if (y >= gamesize.height-40 || y <= 0)
			{
				vy *= -1;
			}
		}

	}

	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		GameCore.start(new Main4());

	}

}
