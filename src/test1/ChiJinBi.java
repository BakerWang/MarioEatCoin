package test1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Point;
import java.util.Random;

import com.rupeng.game.GameCore;
//2016��1��17��16:54:19
//����³Խ�ҵ�ʵ��

public class ChiJinBi implements Runnable
{

	@Override
	public void run()
	{
		Random rand1 = new Random();// ����
		String coinsum = "0 x";
		int kc;// ���̵�ֵ
		int marioNum = 0;
		int coinNum = 1;
		int textNum = 3;
		int dx = 5, dy = 5;// x��y������
		Point marioPos = new Point();
		marioPos.x = 200;
		marioPos.y = 200;// ��������������
		Dimension gamesize = GameCore.getGameSize();

		// ������ɽ��5��
		int coinN = 20;// ���ƽ�ҵ�����
		for (int i = 4; i <= coinN + 4 - 1; i++)// i��Ϊ��Ų����������ظ�,���Դ�4��8
		{

			GameCore.createSprite(i, "coin");
			GameCore.setSpritePosition(i,
					Math.abs(rand1.nextInt() % gamesize.width - 90),
					Math.abs(rand1.nextInt() % gamesize.height - 100));
			GameCore.playSpriteAnimate(i, "rotate", true);
		}

		// ���ñ���
		GameCore.setGameTitle("===++++===");

		// �������֣���ý�ҵ�����
		GameCore.createText(textNum, coinsum);
		GameCore.setTextColor(textNum, Color.yellow);
		GameCore.setTextFontSize(textNum, 25);
		GameCore.setTextPosition(textNum, gamesize.width - 70, 0);

		// ������
		GameCore.createSprite(coinNum, "coin");
		GameCore.setSpritePosition(coinNum, gamesize.width - 20, 10);
		GameCore.playSpriteAnimate(coinNum, "rotate", true);

		// ���������
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpritePosition(marioNum, marioPos.x, marioPos.y);
		// ���������
		GameCore.playSpriteAnimate(marioNum, "walk", true);
		// ���뱳��ͼƬ���ݵ�
		GameCore.loadBgView("CaoDi.jpg");

		// ������Ч
		GameCore.playSound("Ⱥ�� - FC���������������Ϲ�BGM.mp3", true);

		int csum = 0;//�õ��Ľ������
		int[] coinBook = new int[coinN];//��ұ������
		while (true)
		{
			kc = GameCore.getPressedKeyCode();// ��ȡ�����¼�
			if (kc == 'a' || kc == 'A')// ��
			{
				if (marioPos.x >= 10)
				{
					GameCore.setSpriteFlipX(marioNum, false);
					dx = -5;
					dy = 0;
					GameCore.setSpritePosition(marioNum, marioPos.x += dx,
							marioPos.y += dy);
				}
			}

			else if (kc == 'd' || kc == 'D')// ��
			{
				if (marioPos.x <= gamesize.width - 50)
				{

					GameCore.setSpriteFlipX(marioNum, true);
					dx = 5;
					dy = 0;
					GameCore.setSpritePosition(marioNum, marioPos.x += dx,
							marioPos.y += dy);
				}
			}

			else if (kc == 's' || kc == 'S')// ��
			{
				if (marioPos.y <= gamesize.height - 90)
				{
					dx = 0;
					dy = 5;
					GameCore.setSpritePosition(marioNum, marioPos.x += dx,
							marioPos.y += dy);
				}
			}

			else if (kc == 'w' || kc == 'W')// ��
			{
				if (marioPos.y >= 10)
				{
					dx = 0;
					dy = -5;
					GameCore.setSpritePosition(marioNum, marioPos.x += dx,
							marioPos.y += dy);
				}

			}

			// �ж��Ƿ�Ե������
			for (int i = 4; i <= coinN + 4 - 1; i++)// i��Ϊ��Ų����������ظ�,���Դ�4��8
			{

				Point coinPos = GameCore.getSpritePosition(i); 
				// �������빫ʽ&&�˽��û�гԹ�
				if (Math.pow(
						Math.pow(marioPos.x - coinPos.x, 2)
								+ Math.pow(marioPos.y - coinPos.y, 2), 0.5) <= 50
						&& coinBook[i - 4] == 0)
				{
					coinBook[i - 4] = 1;// ����½�ҳԹ���
					csum++;// �õ��Ľ��++
					GameCore.hideSprite(i);
					coinsum = csum + " " + "x";

					GameCore.setText(textNum, coinsum);
				}
			}

			GameCore.pause(10);
		}
	}

	public static void main(String[] args)
	{
		// TODO �Զ����ɵķ������

		GameCore.start(new ChiJinBi());
	}

}
