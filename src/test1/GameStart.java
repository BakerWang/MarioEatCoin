package test1;

import java.awt.Color;

import com.rupeng.game.GameCore;
//���峬��������ʼ���������
//��װ�˺ܶೣ�õķ���

public class GameStart
{

	// ���ֵı��
	int MarioNum = 0;
	int gameStart = 1;// 1-��ʼ��Ϸ
	int gameDome = 2;// 2-��Ϸ��ʾ
	int gameHelp = 3;// 3-����

	public void drawGame()
	{

		// ��ʼ���� ���ֵ���ʾ
		// GameCore.setGameTitle("+++��������+++");
		// GameCore.setGameSize(800, 480);// ���ڴ�С����
		GameCore.loadBgView("��ʼ���汳��.jpg");// ��������µı���ͼƬ
		// GameCore.playSound("Ⱥ�� - FC���������������Ϲ�BGM.mp3", true);

		// �������� ���ֵĿ���

		GameCore.createText(MarioNum, "��������");
		GameCore.setTextColor(MarioNum, Color.pink);
		GameCore.setTextFontSize(MarioNum, 50);
		GameCore.setTextPosition(MarioNum, 380, 50);

		// 1-��ʼ��Ϸ �����ֿ���

		GameCore.createText(gameStart, "1-��ʼ��Ϸ");
		GameCore.setTextColor(gameStart, Color.pink);
		GameCore.setTextFontSize(gameStart, 30);
		GameCore.setTextPosition(gameStart, 400, 150);

		// 2-��Ϸ��ʾ �����ֿ���

		GameCore.createText(gameDome, "2-��Ϸ��ʾ");
		GameCore.setTextColor(gameDome, Color.pink);
		GameCore.setTextFontSize(gameDome, 30);
		GameCore.setTextPosition(gameDome, 400, 200);

		// 3-���������ֿ���

		GameCore.createText(gameHelp, "3-��Ϸ����");
		GameCore.setTextColor(gameHelp, Color.pink);
		GameCore.setTextFontSize(gameHelp, 30);
		GameCore.setTextPosition(gameHelp, 400, 250);

		GameCore.pause(900);

	}

	// ��������
	public void hidelText()
	{

		GameCore.setText(MarioNum, "");
		GameCore.setText(gameStart, "");
		GameCore.setText(gameDome, "");
		GameCore.setText(gameHelp, "");

	}

}
