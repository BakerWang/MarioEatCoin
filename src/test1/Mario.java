package test1;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import com.rupeng.game.GameCore;

//���峬�����������
//��װ�˺ܶೣ�õķ���
public class Mario
{

	private int marioNum;//����¾�����

	
	//��������±�������
	public void playMarioSound()
	{
		//GameCore.p
		GameCore.playSound("Ⱥ�� - FC���������������Ϲ�BGM.mp3", true);
	}
	
	// ���캯������������µı��
	public Mario(int marioNum)
	{
		// TODO �Զ����ɵĹ��캯�����
		this.marioNum = marioNum;
	}

	// ����һ����·������¾�����px��py����mario.walk
	// ���뾫���ţ�x���꣬y����
	public void drawMarioWalk(int px, int py)
	{
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpritePosition(marioNum, px, py);
		GameCore.playSpriteAnimate(marioNum, "walk", true);
	}

	// ����һ����·������¾��飬mario.walk
	// ���뾫���� ȱʡ���꣬Ĭ��100��100
	public void drawMarioWalk()
	{
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpritePosition(marioNum, 100, 100);
		GameCore.playSpriteAnimate(marioNum, "walk", true);
	}

	// ʵ������µ��ƶ�
	// ���뾫�飬�����¼�
	public void marioMove(int kc)
	{
		if (kc == KeyEvent.VK_LEFT || kc == KeyEvent.VK_A)
		{
			moveLeft();
		}

		else if (kc == KeyEvent.VK_RIGHT || kc == KeyEvent.VK_D)
		{
			moveRight();
		}

		else if (kc == KeyEvent.VK_UP || kc == KeyEvent.VK_W)
		{
			moveUp();
		}

		else if (kc == KeyEvent.VK_DOWN || kc == KeyEvent.VK_S)
		{
			moveDown();
		}
	}

	// ʵ�־��������߶�һ������
	public void moveRight()
	{

		Point marioPoint = GameCore.getSpritePosition(marioNum);
		if (marioPoint.x >= GameCore.getGameWidth() - 50)// ��ֹԽ��
		{
			return;
		}
		GameCore.setSpriteFlipX(marioNum, true);
		GameCore.setSpritePosition(marioNum, marioPoint.x + 1, marioPoint.y);
		return;
	}

	// ʵ�־��������߶�һ������
	public void moveLeft()
	{
		Point marioPoint = GameCore.getSpritePosition(marioNum);
		if (marioPoint.x <= 10)// ��ֹԽ��
		{
			return;
		}
		GameCore.setSpriteFlipX(marioNum, false);
		GameCore.setSpritePosition(marioNum, marioPoint.x - 1, marioPoint.y);
		return;
	}

	// ʵ�־��������߶�һ������
	public void moveUp()
	{
		Point marioPoint = GameCore.getSpritePosition(marioNum);
		if (marioPoint.y <= 10)// ��ֹԽ��
		{
			return;
		}
		GameCore.setSpritePosition(marioNum, marioPoint.x, marioPoint.y - 1);
		return;
	}

	// ʵ�־��������߶�һ������
	public void moveDown()
	{
		Point marioPoint = GameCore.getSpritePosition(marioNum);
		if (marioPoint.y >= GameCore.getGameHeight() - 80)// ��ֹԽ��
		{
			return;
		}
		GameCore.setSpritePosition(marioNum, marioPoint.x, marioPoint.y + 1);
		return;
	}

}
