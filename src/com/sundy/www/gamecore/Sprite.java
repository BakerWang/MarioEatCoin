package com.sundy.www.gamecore;

import com.rupeng.game.*;

public class Sprite
{
	private int spriteNum;// ����ı��
	private String spriteName;// ���������

	/**
	 * �Ƿ񱻱���ˣ������жϽ���Ƿ񱻳��� һ��û����ô���
	 */
	public int book = 0;

	/**
	 * ���캯�� ���������
	 * @param spriteName
	 *            ��������
	 * @param px
	 *            x����
	 * @param py
	 *            y����
	 */
	public Sprite(String spriteName, int px, int py)
	{
		this.spriteNum = NumerManager.instance.getNum();
		GameCore.createSprite(spriteNum, spriteName);
		GameCore.setSpritePosition(spriteNum, px, py);
		this.spriteName = spriteName;
	}

	/**
	 * ���캯�� λ����Ĭ��λ�� 0��0
	 * 
	 * @param spriteName
	 *            ��������
	 */
	public Sprite(String spriteName)
	{
		this.spriteNum = NumerManager.instance.getNum();
		GameCore.createSprite(spriteNum, spriteName);
		GameCore.setSpritePosition(spriteNum, 0, 0);
		this.spriteName = spriteName;
	}

	/**
	 * �õ�����ı��
	 * 
	 * @return ���ؾ���ı��
	 */
	public int getNum()
	{
		return spriteNum;
	}

	/**
	 * ���ž���
	 * 
	 * @param animateName
	 *            ����ʲô��Ϊ
	 * 
	 * @param repeat
	 *            �Ƿ�ѭ��
	 * 
	 */
	public void play(String animateName, boolean repeat)
	{
		GameCore.playSpriteAnimate(spriteNum, animateName, repeat);
	}

	/**
	 * ���ž���
	 * 
	 * @param animateName
	 *            ����ʲô��Ϊ Ĭ����һֱ����
	 * 
	 */
	public void play(String animateName)
	{
		GameCore.playSpriteAnimate(spriteNum, animateName, true);
	}

	/**
	 * ���������ƶ�һ����λ
	 */
	public void moveRight()
	{
		// ��ֹԽ��
		if (GameCore.getSpriteX(spriteNum) > GameCore.getGameWidth() - 50)
		{
			return;
		}
		GameCore.setSpritePosition(spriteNum,
				GameCore.getSpriteX(spriteNum) + 1,
				GameCore.getSpriteY(spriteNum));
	}

	/**
	 * ���������ƶ�һ����λ
	 */
	public void moveLeft()
	{
		// ��ֹԽ��
		if (GameCore.getSpriteX(spriteNum) <= 10)
		{
			return;
		}
		GameCore.setSpritePosition(spriteNum,
				GameCore.getSpriteX(spriteNum) - 1,
				GameCore.getSpriteY(spriteNum));
	}

	/**
	 * ���������ƶ�һ����λ
	 */
	public void moveUp()
	{
		// ��ֹԽ��
		if (GameCore.getSpriteY(spriteNum) < 40)
		{
			return;
		}
		GameCore.setSpritePosition(spriteNum, GameCore.getSpriteX(spriteNum),
				GameCore.getSpriteY(spriteNum) - 1);
	}

	/**
	 * ���������ƶ�һ����λ
	 */
	public void moveDown()
	{
		// ��ֹԽ��
		if (GameCore.getSpriteY(spriteNum) > GameCore.getGameHeight() )
		{
			return;
		}
			
			GameCore.setSpritePosition(spriteNum,
					GameCore.getSpriteX(spriteNum),
					GameCore.getSpriteY(spriteNum) + 1);
	}

	/**
	 * ʵ���ж����������Ƿ��ཻ
	 * 
	 * @param sprite1
	 *            ����1
	 * @param sprite2
	 *            ����2
	 * @return true�ཻ false���ཻ
	 */
	public static boolean xiangjiao(int sprite1, int sprite2)
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

		if (GameCore.getSpriteX(sprite2) + GameCore.getSpriteWidth(sprite2) < GameCore
				.getSpriteX(sprite1))
		{
			return false;
		}

		if (GameCore.getSpriteX(sprite1) + GameCore.getSpriteWidth(sprite1) < GameCore
				.getSpriteX(sprite2))
		{
			return false;
		}

		return true;
	}

}
