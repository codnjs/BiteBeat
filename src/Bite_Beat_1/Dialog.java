package Bite_Beat_1;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Dialog
{
	// �ʿ��� �ʵ� ����
	JFrame jFrame = new JFrame("J���̾�α� ����");
	JDialog jDialog = new JDialog(jFrame, "JDialog Ÿ��Ʋ");
	JButton jButton = new JButton("Click");

	// GUI ���� ������
	public Dialog()
	{
		// ���̾�α׿� ��ư �߰�
		jDialog.add(jButton, "South");

		// �⺻ ������ ũ��� ���� ����
		jFrame.setSize(500, 500);
		jFrame.setLocation(300, 300);
		jFrame.setVisible(true);
		//X��ư ������ ���α׷� ����
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ���̾�α��� ũ��� ���� ����
		jDialog.setSize(200, 200);
		jDialog.setLocation(400, 400);
		jDialog.setVisible(true);
		//��X��ư ������ ���̾�α׸� ����
		jDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public static void main(String[] args)
	{
		//����
		new Dialog();
	}

}

