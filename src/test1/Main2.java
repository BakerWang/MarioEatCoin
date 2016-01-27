package test1;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;

import com.rupeng.*;
import com.rupeng.game.GameCore;

public class Main2 implements Runnable
{

	@Override
	public void run()
	{
		GameCore.playSound("Ⱥ�� - FC���������������Ϲ�BGM.mp3", true);

		int marioNum = 2;
		int bombNum = 3;
		int coinNum = 4;
		int x = 10, y = 200;
		int vx = 6, vy = 0;
		Dimension gamesize = GameCore.getGameSize();// �õ�����ߴ�
		GameCore.createSprite(marioNum, "mario");
		GameCore.createSprite(bombNum, "bomb");
		GameCore.createSprite(coinNum, "coin");

		GameCore.setSpriteFlipX(marioNum, true);

		// ��������¾���
		GameCore.playSpriteAnimate(marioNum, "walk", true);
	    GameCore.playSpriteAnimate(bombNum, "fire", true);
	     GameCore.hideSprite(bombNum);
		GameCore.playSpriteAnimate(coinNum, "rotate", true);

		GameCore.setSpritePosition(coinNum, 200, 200);
		GameCore.setSpritePosition(bombNum, 200, 200);
		// GameCore.setSpriteFlipX(marioNum, false);
		while (true)
		{
			int kc = GameCore.getPressedKeyCode();

			// a�� d�� s�� w��
			if (kc == 'a' || kc == 'A')
			{
				GameCore.setSpriteFlipX(marioNum, false);
				vx = -6;
				vy = 0;
			}

			else if (kc == 'd' || kc == 'D')
			{
				GameCore.setSpriteFlipX(marioNum, true);
				vx = 6;
				vy = 0;
			}

			else if (kc == 'w' || kc == 'W')
			{
				vx = 0;
				vy = -6;
			}

			else if (kc == 's' || kc == 'S')
			{
				vx = 0;
				vy = 6;
			}

			// ���þ����λ��
			GameCore.setSpritePosition(marioNum, (x += vx) % gamesize.width,
					(y += vy) % gamesize.height);
			// ��ֹԽ�� ���п���
			if (x <= 0)
			{
				x = gamesize.width;
			}
			if (y <= 0)
			{
				y = gamesize.height;
			}

			// �ж������Ƿ�ӽ���Ӳ��
			Point marioPos = GameCore.getSpritePosition(marioNum);
			Point coinPos = GameCore.getSpritePosition(coinNum);

			if (Math.pow(
					Math.pow(marioPos.x - coinPos.x, 2)
							+ Math.pow(marioPos.y - coinPos.y, 2), 0.5) <= 10)
			{

				//System.out.println("<=5");
				GameCore.hideSprite(coinNum);
				//GameCore.hideSprite(bombNum);
				GameCore.showSprite(bombNum);
				
			}

			GameCore.pause(50);

			// System.out.println(kc);

		}

	}

	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������
		GameCore.start(new Main2());

	}

}
