import java.util.Random;

public class RandomWalk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();//������ ���ڸ� �����ϱ� ���� random���� ����
		int x=0;//x��ǥ�� 0���� ����
		int y=0;//y��ǥ�� 0���� ����
		int steps;//�̵�Ƚ���� ��Ÿ���� ����
		boolean[][] course=new boolean[5][5];//5x5�� Ÿ�� ����
		course[0][0]=true;//(0,0)��ǥ�� true�� �д�.
		int coordinateX=(int)(Math.random()*5);//��ǥ ������ x��ǥ
		int coordinateY=(int)(Math.random()*5);//��ǥ ������ y��ǥ

		System.out.println("���=("+x+","+y+")");//��� ���� ���
		System.out.println("��ǥ=("+coordinateX+","+coordinateY+")");//��ǥ ���� ���
		System.out.println("�̵� ���:");
		for(steps=0;steps<20;steps++) {//������ 20�� ���� �����δ�.
			int direction=(int)(Math.random()*4);//������ ��Ÿ���� ����

			switch(direction) {//���⿡ ���� �����̴� ���ǹ�
			case 0:
				x=--x<0 ? 0:x;
				break;
			case 1:
				x=++x>4 ? 4:x;
				break;
			case 2:
				y=--y<0 ? 0:y;
				break;
			case 3:
				y=++y>4 ? 4:y;
				break;
			}
			System.out.println("("+x+","+y+")");//20�� ������ ������ �̵���� ���
			course[x][y]=true;//������ ������ true�� �д�.


			if(steps>=0 && steps<20) {//20�� ������ ����
				if(x==coordinateX && y==coordinateY) {//��ǥ ������ �������� ��
					break;//�ݺ��� Ż��
				}
			}
		}
		System.out.println(" ");
		/*������ ������ ��θ� ��Ÿ��*/
		System.out.println("-----------------------");
		for(int i=0;i<5;i++) {//Ÿ���� ���� ���̰� 5
			for(int j=0;j<5;j++) {//Ÿ���� ���� ���̰� 5
				if(i==0 && j==0) {//�������((0,0))�� ��
					System.out.print("S");//S�� ���
				}
				else if(i==coordinateX && j==coordinateY) {//��ǥ������ ��
					System.out.print("G");//G�� ���
				}
				else if(course[i][j]==true) {//������ ���
					System.out.print("#");//#�� ���
				}
				else//�������� ���� ���
					System.out.print(".");//.�� ���
			}
			System.out.println();
		}
		System.out.println("-----------------------");
		
		if(steps>=0 && steps<20) {//20�� �������� ��
			if(x==coordinateX && y==coordinateY) {//��ǥ ������ ���������� �������� ��
				System.out.println("����");
				System.out.println("�� �õ� Ƚ��="+steps);
			}
		}
		if(steps == 20){//������ Ƚ���� 20�� �Ѿ��� ���
			if(x != coordinateX || y != coordinateY){//��ǥ ���� ���޿� �������� ��
				System.out.println("����");
			}
		}
	}
}

