package com.sundy.www.gamecore;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;

public class Frame
{
	/**
	 * ʵ�־�����Զ��ƶ���px py��
	 * 
	 * @param mario
	 *            ��Ҫ�ƶ��ľ���
	 * @param px
	 *            x��
	 * @param py
	 *            y��
	 */
	public void autoMove(Sprite mario, int px, int py)
	{

		while (true)
		{
			// ��ǰ�������Ŀ���px���������ƶ�
			if (GameCore.getSpriteX(mario.getNum()) > px)
			{
				mario.moveLeft();
			}
			// ��ǰ����С��Ŀ���px���������ƶ�
			else if (GameCore.getSpriteX(mario.getNum()) < px)
			{
				mario.moveRight();
			} else
			{
				break;
			}

		}

		while (true)
		{
			// ��ǰ�������Ŀ���py���������ƶ�
			if (GameCore.getSpriteY(mario.getNum()) > py)
			{
				mario.moveUp();
			}
			// ��ǰ����С��Ŀ���py���������ƶ�
			else if (GameCore.getSpriteY(mario.getNum()) < py)
			{
				mario.moveDown();
			} else
			{
				break;
			}

		}

	}

	/**
	 * ʵ���Զ��ƶ�����Ҵ�
	 * 
	 * @param coinArr
	 */
	public void marioAutoEatCoin(Sprite mario, Sprite coin[])
	{
		int minLenCoinNum = 0;// ��������¾�����С�Ľ�ҵ�������
		double minlen = 99999999;

		// ʵ��Ѱ����С����Ľ�ҵı��

		for (int i = 0; i < coin.length; i++)
		{

			if (Math.pow(
					Math.pow(
							GameCore.getSpriteX(mario.getNum())
									- GameCore.getSpriteX(coin[i].getNum()), 2)
							+ Math.pow(GameCore.getSpriteY(mario.getNum())
									- GameCore.getSpriteY(coin[i].getNum()), 2),
					0.5) < minlen
					&& coin[i].book == 0)// ͬʱ�жϽ���Ƿ񱻳�
			{

				minlen = Math
						.pow(Math.pow(GameCore.getSpriteX(mario.getNum())
								- GameCore.getSpriteX(coin[i].getNum()), 2)
								+ Math.pow(
										GameCore.getSpriteY(mario.getNum())
												- GameCore.getSpriteY(coin[i]
														.getNum()), 2), 0.5);

				minLenCoinNum = coin[i].getNum();
			}

		}
		// System.out.println("�ұ�ִ����  minLenCoinNum=" + minLenCoinNum);
		autoMove(mario, GameCore.getSpriteX(minLenCoinNum),
				GameCore.getSpriteY(minLenCoinNum));

	}

	/**
	 * ������ʼ���� ʵ�ֹ����ƶ���ѡ���ȷ��
	 */
	public void gameStartFrame()
	{

		GameCore.setGameTitle("���������Խ��");// ���ô��ڵı���
		GameCore.loadBgView("��ʼ���汳��.jpg");// ���ر�������
		GameCore.playSound("Ⱥ�� - FC���������������Ϲ�BGM.mp3", true);// ���ر�������

		// �������� �����
		Text h1 = new Text("��������", 380, 50, Color.pink, 50);
		// С������
		Text h2 = new Text("1-��ʼ��Ϸ", 400, 150, Color.pink, 30);
		Text h3 = new Text("2-��Ϸ��ʾ", 400, 200, Color.pink, 30);
		Text h4 = new Text("3-��Ϸ����", 400, 250, Color.pink, 30);

		int textNum = h1.getNum();// text����ʱ����

		// ���޼��������¼�
		while (true)
		{
			int kc = GameCore.getPressedKeyCode();

			// �����up����������
			if (kc == KeyEvent.VK_UP)
			{
				textNum--;

				// textNum��ֹ���
				if (textNum < h2.getNum())
				{
					textNum = h4.getNum();
				}

				// ������������Ϊpinkɫ
				for (int i = h1.getNum(); i <= h4.getNum(); i++)
				{
					GameCore.setTextColor(i, Color.pink);
				}

				GameCore.setTextColor(textNum, Color.orange);
				GameCore.pause(200);
			}

			// �����down����������
			if (kc == KeyEvent.VK_DOWN)
			{
				textNum++;

				// textNum��ֹ���
				if (textNum > h4.getNum())
				{
					textNum = h2.getNum();
				}

				// ������������Ϊpinkɫ
				for (int i = h1.getNum(); i <= h4.getNum(); i++)
				{
					GameCore.setTextColor(i, Color.pink);
				}

				GameCore.setTextColor(textNum, Color.orange);
				GameCore.pause(200);
			}

			// ����õ�1 �� ��ʼ��Ϸ
			if (kc == KeyEvent.VK_1)
			{
				// �ÿ�ʼ��ʼ������ʧ
				h1.hideText();
				h2.hideText();
				h3.hideText();
				h4.hideText();

				Main.whichFrame = 2;// ���������������Խ�ҵĻ���
				return;

			}

			// ����õ�2 ���ѡ��2-��Ϸ��ʾ
			if (kc == KeyEvent.VK_2)
			{

				// �ÿ�ʼ��ʼ������ʧ
				h1.hideText();
				h2.hideText();
				h3.hideText();
				h4.hideText();
				eatCoinFrame(1);// ���óԽ�ҽ��棬ͬʱ�趨flag=1�Դ������Զ��Խ��
				return;

			}

			// ����õ�3 ���ѡ��3-��Ϸ����
			if (kc == KeyEvent.VK_3)
			{
				// �ÿ�ʼ��ʼ������ʧ
				h1.hideText();
				h2.hideText();
				h3.hideText();
				h4.hideText();
				
				//GameCore.hideImage(num);
				
				Main.whichFrame=3;// ����������������Ϸ�����Ľ���
				return;
			}

			// ����õ���ȷ�ϵ�����ж�ִ��˭
			if (kc == KeyEvent.VK_ENTER)
			{
				if (textNum == h2.getNum())// ���1-��ʼ��Ϸ��ָ��
				{
					// �ÿ�ʼ��ʼ������ʧ
					h1.hideText();
					h2.hideText();
					h3.hideText();
					h4.hideText();

					Main.whichFrame = 2;// ���������������Խ�ҵĻ���
					return; // ��������
				}

			}

		}
	}

	/**
	 * �����Խ�ҵĽ���
	 */
	public void eatCoinFrame(int flag)
	{
		// ���ر�������
		GameCore.loadBgView("�Խ�ҵı���.jpg");
		// ������Ϸ����
		Text F1_auto = new Text("|F1-�Զ�ģʽ", 2, 10, Color.YELLOW, 20);
		Text F2_return = new Text("|F2_����", 130, 10, Color.YELLOW, 20);
		Text F3_exit = new Text("|F3_�˳���Ϸ|", 218, 10, Color.YELLOW, 20);

		Text tempText = new Text("�ఴ���ξ��з�Ӧ��--!", 360, 10, Color.YELLOW, 20);

		// ���ؼǷְ�
		Text text_coin_sum = new Text("X0", 960, 7, Color.green, 20);// �Ʒ���
		int int_coin_sum = 0;// ����˶��ٽ��
		Sprite tempCoin = new Sprite("coin", 940, 10);
		tempCoin.play("rotate");

		// ���ؾ��������
		Sprite mario = new Sprite("mario", 30, 50);
		mario.play("walk");

		// ����10�����
		Sprite coin[] = new Sprite[10];// ��ҵĶ�������
		for (int i = 0; i < 10; i++)
		{
			// ���ݴ����С�������������
			int px = GameCore.rand(10, GameCore.getGameWidth() - 50);
			int py = GameCore.rand(40, GameCore.getGameHeight() - 100);

			coin[i] = new Sprite("coin", px, py);
			coin[i].play("rotate");
		}

		// ���ϼ��������¼�
		int kc;
		int autoFlag = flag;
		while (true)
		{
			kc = GameCore.getPressedKeyCode();
			// ������Ӧ������Ӧ
			if (kc == KeyEvent.VK_LEFT)
			{
				mario.moveLeft();
			}

			else if (kc == KeyEvent.VK_RIGHT)
			{
				mario.moveRight();
			}

			else if (kc == KeyEvent.VK_UP)
			{
				mario.moveUp();
			}

			else if (kc == KeyEvent.VK_DOWN)
			{
				mario.moveDown();
			} else if (kc == KeyEvent.VK_F3)// �����˳�
			{
				System.exit(0);
			} else if (kc == KeyEvent.VK_F1 || autoFlag == 1)// �����Զ��Խ��ģʽ
			{
				if (kc == KeyEvent.VK_F3)// �����˳�
				{
					System.exit(0);
				}

				if (kc == KeyEvent.VK_F2)// �õ�ǰ���������Լ�������ʧ
				{
					hideEatCoinFrame(coin, mario, tempCoin, F1_auto, F2_return,
							F3_exit, tempText, text_coin_sum);

					Main.whichFrame = 1;// ����������������ʼ����

					return; // ��ǰ��������
				}

				autoFlag = 1;
				marioAutoEatCoin(mario, coin);

			} else if (kc == KeyEvent.VK_F2)// �õ�ǰ���������Լ�������ʧ
			{
				// �õ�ǰ���������Լ�������ʧ
				hideEatCoinFrame(coin, mario, tempCoin, F1_auto, F2_return,
						F3_exit, tempText, text_coin_sum);

				Main.whichFrame = 1;// ����������������ʼ����

				return; // ��ǰ��������
			}
			// GameCore.pause(1);

			// ѭ���ж�������Ƿ�Ե��˽��
			for (int i = 0; i < 10; i++)
			{
				if (coin[i].book == 0
						&& Sprite.xiangjiao(coin[i].getNum(), mario.getNum()))
				{
					coin[i].book = 1;// ��ǳԹ���
					GameCore.hideSprite(coin[i].getNum());// ���ؾ���

					// �Ƿְ�����
					int_coin_sum++;
					GameCore.setText(text_coin_sum.getNum(), "X" + int_coin_sum);

					// ��Ϊ���˸���ң����ԼӸ����
					// ���ݴ����С�������������
					int px = GameCore.rand(10, GameCore.getGameWidth() - 50);
					int py = GameCore.rand(40, GameCore.getGameHeight() - 50);

					coin[i] = new Sprite("coin", px, py);
					coin[i].play("rotate");

				}
			}

		}

	}

	/**
	 * ������Ϸ��������
	 */
	public void gameHelpFrame()
	{
		//��������
		Text F2_return = new Text("|F2_����", 130, 10, Color.YELLOW, 20);
		Text F3_exit = new Text("|F3_�˳���Ϸ|", 218, 10, Color.YELLOW, 20);
        Text tempText=new Text("����֪����˵Щʲô--����Ϸд��ͦ�õģ�ֻ��Ϊ����ϰ��Java--!", 10, 30, Color.white, 30);
        Text tempText2=new Text("                                      By Sundy (*^__^*) ", 10, 200, Color.white, 30);
       
		int kc=0;
		while (true) 
		{
			kc = GameCore.getPressedKeyCode();
			if (kc == KeyEvent.VK_F3)// �����˳�
			{
				System.exit(0);
			} else if (kc == KeyEvent.VK_F2)// �õ�ǰ���������Լ�������ʧ
			{
				//�õ�ǰ�ı���ʧ
                GameCore.hideText(F2_return.getNum());
                GameCore.hideText(F3_exit.getNum());
                GameCore.hideText(tempText.getNum());
                GameCore.hideText(tempText2.getNum());
                // ����������������ʼ����      
				Main.whichFrame = 1;
				// ��ǰ��������
				return; 
			}
		}

	}

	/**
	 * �óԽ�ҽ�����ʧ
	 * 
	 * @param coin
	 *            ����������
	 * @param mario
	 *            ����±��
	 * @param tempcoin
	 *            ��ʱ��С���
	 * @param t1
	 *            ���ֱ��1
	 * @param t2
	 *            ���ֱ��2
	 * @param t3
	 *            ���ֱ��3
	 * @param t4
	 *            ���ֱ��4
	 * @param coin_sum
	 *            ������
	 */
	public void hideEatCoinFrame(Sprite coin[], Sprite mario, Sprite tempcoin,
			Text t1, Text t2, Text t3, Text t4, Text coin_sum)
	{
		// �ý����ʧ
		for (int i = 0; i < 10; i++)
		{
			GameCore.hideSprite(coin[i].getNum());
			coin[i] = null;// �ͷŽ���������
		}

		// ���������ʧ
		GameCore.hideSprite(mario.getNum());
		mario = null;

		// ��������ʧ
		GameCore.hideText(t1.getNum());
		t1 = null;
		GameCore.hideText(t2.getNum());
		t2 = null;
		GameCore.hideText(t3.getNum());
		t3 = null;
		GameCore.hideText(t4.getNum());
		t4 = null;

		// ��������ʧ
		GameCore.hideText(coin_sum.getNum());
		coin_sum = null;
		GameCore.hideSprite(tempcoin.getNum());
	}

}
