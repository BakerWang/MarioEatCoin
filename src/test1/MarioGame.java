package test1;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;
/**
 * ����һ������
 * @author Administrator
 *
 */
public class MarioGame implements Runnable
{
	// ����¾���ı��
	int marioNum = 0;
	int coinSum = 10;// ���ɽ�ҵ�����
	int flag = 1;// �Ƿ��л����Զ��Խ��ģʽ

	Mario mario = new Mario(marioNum);// �½�����������
	GameStart gamestrat = new GameStart();// �½���Ϸ��ʼ�������

	// ʵ���ж����������Ƿ��ཻ
	// true�ཻ false���ཻ
	//ʹ���˾��η��ж�
	/**
	 * ʵ���ж����������Ƿ��ཻ
	 * @param sprite1 ����1
	 * @param sprite2 ����2
	 * @return true�ཻ false���ཻ
	 */
	public boolean xiangjiao(int sprite1, int sprite2)
	{
		if (GameCore.getSpriteY(sprite1) + GameCore.getSpriteHeight(sprite1) < GameCore
				.getSpriteY(sprite2))
		{
			return false;
		}

		if (GameCore.getSpriteY(sprite2) + GameCore.getSpriteHeight(sprite2) < GameCore
				.getSpriteY(sprite1))
		{
			return false;
		}

		
		if(GameCore.getSpriteX(sprite2) + GameCore.getSpriteWidth(sprite2) < GameCore
				.getSpriteX(sprite1))	
		{
			return false;
		}
		
		if(GameCore.getSpriteX(sprite1) + GameCore.getSpriteWidth(sprite1) < GameCore
				.getSpriteX(sprite2))	
		{
			return false;
		}
		
		
		return true;
	}

	// ʵ��������Զ��ߵ�px��py��
	public void autoMove(int px, int py)
	{

		while (true)
		{

			if (GameCore.getSpriteX(marioNum) > px)
			{
				mario.marioMove(KeyEvent.VK_LEFT);
			}

			else if (GameCore.getSpriteX(marioNum) < px)
			{
				mario.marioMove(KeyEvent.VK_RIGHT);
			} else
			{
				break;
			}

		}

		while (true)
		{

			if (GameCore.getSpriteY(marioNum) > py)
			{
				mario.marioMove(KeyEvent.VK_UP);
			}

			else if (GameCore.getSpriteY(marioNum) < py)
			{
				mario.marioMove(KeyEvent.VK_DOWN);
			} else
			{
				break;
			}

		}

	}

	// ʵ��������Զ��Խ��
	// ����������
	public void marioAutoEatCoin(int[] coinArr)
	{
		int minLenCoinNum = 0;// ��������¾�����С�Ľ�ҵı��
		double minlen = 99999999;
		// int[] coinArr = new int[coinSum];// ����Ƿ񱻳Ե�����

		// ʵ��Ѱ����С����Ľ�ҵı��
		// ��֪����ҵı�Ŵ�20��ʼ��
		for (int i = 20; (i <= coinSum + 20 - 1); i++)
		{

			if (Math.pow(
					Math.pow(
							GameCore.getSpriteX(marioNum)
									- GameCore.getSpriteX(i), 2)
							+ Math.pow(
									GameCore.getSpriteY(marioNum)
											- GameCore.getSpriteY(i), 2), 0.5) < minlen
					&& coinArr[i - 20] == 0)// ͬʱ�жϽ���Ƿ񱻳�
			{

				minlen = Math.pow(
						Math.pow(
								GameCore.getSpriteX(marioNum)
										- GameCore.getSpriteX(i), 2)
								+ Math.pow(GameCore.getSpriteY(marioNum)
										- GameCore.getSpriteY(i), 2), 0.5);

				minLenCoinNum = i;
			}
			// System.out.println("�ұ�ִ����  minLenCoinNum=" + minLenCoinNum);
		}

		autoMove(GameCore.getSpriteX(minLenCoinNum),
				GameCore.getSpriteY(minLenCoinNum));

	}

	// 1-��ʼ��Ϸ
	public void marioChiJinBi()
	{

		int textNum = 11;// ���ֱ��
		int getCoinSum = 0;// ��ý�ҵ�����
		String strGetCoin = " X0";

		int[] coinArr = new int[coinSum];

		// ���ɡ�F1�Զ�ģʽ������
		GameCore.createText(textNum - 1, "F1�Զ�ģʽ");
		GameCore.setTextColor(textNum - 1, Color.WHITE);
		GameCore.setTextFontSize(textNum - 1, 19);
		GameCore.setTextPosition(textNum - 1, 10, 5);

		// ���ɻ�ý������������
		GameCore.createSprite(7, "coin_Big");
		GameCore.setSpritePosition(7, 910, 0);
		GameCore.playSpriteAnimate(7, "rotate", true);

		GameCore.createText(textNum, strGetCoin);
		GameCore.setTextPosition(textNum, 920, 0);
		GameCore.setTextColor(textNum, Color.WHITE);

		// ���ɽ�� ��Ŵ�20��ʼ
		for (int i = 20; i <= coinSum + 20 - 1; i++)
		{
			GameCore.createSprite(i, "coin");
			GameCore.setSpritePosition(i, GameCore.rand(10, 900),
					GameCore.rand(10, 500));
			GameCore.playSpriteAnimate(i, "rotate", true);
		}

		// ��ʼѭ�����������¼�����������µ�λ��
		while (true)
		{
			int kc = GameCore.getPressedKeyCode();

			if (kc == KeyEvent.VK_F1)
			{

				flag = 0;

			}

			if (flag == 1)// �ֶ�ģʽ
			{
				mario.marioMove(kc);// �����ƶ�ָ��

			} else if (flag == 0)// �Զ�ģʽ
			{
				marioAutoEatCoin(coinArr);
			}

			//

			// �жϳ�����Щ���
			for (int i = 20; i <= coinSum + 20 - 1; i++)
			{
				// �㵽����빫ʽ&����Ƿ񱻳���
//				if (Math.pow(
//						Math.pow(
//								GameCore.getSpriteX(marioNum)
//										- GameCore.getSpriteX(i), 2)
//								+ Math.pow(GameCore.getSpriteY(marioNum)
//										- GameCore.getSpriteY(i), 2), 0.5) <= 30
//						&& coinArr[i - 20] == 0)
				if(xiangjiao(marioNum, i)&&coinArr[i - 20] == 0)//�ж��Ƿ��ཻ
				{
					coinArr[i - 20] = 1;
					GameCore.hideSprite(i);
					getCoinSum++;
					strGetCoin = " X" + getCoinSum;
					GameCore.setText(textNum, strGetCoin);
				
				}

			}

			// GameCore.pause(1);

		}
	}

	@Override
	public void run()
	{
		GameCore.setGameTitle("��֪����ʲô�ã��ͽг�ʺ����");// ��������

		mario.playMarioSound();// ��������±�������
		gamestrat.drawGame();// ��������

		// ��ʼ����Ĳٿ�
		int textNum = 0;
		while (true)
		{
			int kc = GameCore.getPressedKeyCode();

			if (kc == KeyEvent.VK_UP)
			{
				textNum--;

				// textNum��ֹ���
				if (textNum <= 0)
				{
					textNum = 3;
				}

				// ������������Ϊpinkɫ
				for (int i = 1; i <= 3; i++)
				{
					GameCore.setTextColor(i, Color.pink);
				}

				GameCore.setTextColor(textNum, Color.orange);
				GameCore.pause(200);
			}

			if (kc == KeyEvent.VK_DOWN)
			{
				textNum++;

				// textNum��ֹ���
				if (textNum > 3)
				{
					textNum = 1;
				}

				// ������������Ϊpinkɫ
				for (int i = 1; i <= 3; i++)
				{
					GameCore.setTextColor(i, Color.pink);
				}

				GameCore.setTextColor(textNum, Color.orange);
				GameCore.pause(200);
			}

			if (kc == KeyEvent.VK_ENTER)
			{
				if (textNum == 1)// ���1-��ʼ��Ϸ��ָ��
				{
					gamestrat.hidelText();// ��������
					GameCore.loadBgView("�Խ�ҵı���.jpg");// ����ͼƬ
					mario.drawMarioWalk(300, 400);// ���������
					marioChiJinBi();// ִ�п�ʼ��Ϸ

				}

			}

		}

	}

	public static void main(String[] args)
	{
		GameCore.start(new MarioGame());

	}

}
