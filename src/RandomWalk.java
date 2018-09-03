import java.util.Random;

public class RandomWalk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();//랜덤한 숫자를 생성하기 위한 random변수 생성
		int x=0;//x좌표를 0으로 설정
		int y=0;//y좌표를 0으로 설정
		int steps;//이동횟수를 나타내는 변수
		boolean[][] course=new boolean[5][5];//5x5인 타일 생성
		course[0][0]=true;//(0,0)좌표를 true로 둔다.
		int coordinateX=(int)(Math.random()*5);//목표 지점의 x좌표
		int coordinateY=(int)(Math.random()*5);//목표 지점의 y좌표

		System.out.println("출발=("+x+","+y+")");//출발 지점 출력
		System.out.println("목표=("+coordinateX+","+coordinateY+")");//목표 지점 출력
		System.out.println("이동 경로:");
		for(steps=0;steps<20;steps++) {//벌레가 20번 동안 움직인다.
			int direction=(int)(Math.random()*4);//방향을 나타내는 변수

			switch(direction) {//방향에 따라 움직이는 조건문
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
			System.out.println("("+x+","+y+")");//20번 움직인 동안의 이동경로 출력
			course[x][y]=true;//움직인 지점을 true로 둔다.


			if(steps>=0 && steps<20) {//20번 움직인 동안
				if(x==coordinateX && y==coordinateY) {//목표 지점에 도달했을 때
					break;//반복문 탈출
				}
			}
		}
		System.out.println(" ");
		/*벌레가 지나간 경로를 나타냄*/
		System.out.println("-----------------------");
		for(int i=0;i<5;i++) {//타일의 가로 길이가 5
			for(int j=0;j<5;j++) {//타일의 세로 길이가 5
				if(i==0 && j==0) {//출발지점((0,0))일 때
					System.out.print("S");//S로 출력
				}
				else if(i==coordinateX && j==coordinateY) {//목표지점일 때
					System.out.print("G");//G로 출력
				}
				else if(course[i][j]==true) {//지나간 경로
					System.out.print("#");//#로 출력
				}
				else//지나가지 않은 경로
					System.out.print(".");//.로 출력
			}
			System.out.println();
		}
		System.out.println("-----------------------");
		
		if(steps>=0 && steps<20) {//20번 움직였을 때
			if(x==coordinateX && y==coordinateY) {//목표 지점에 성공적으로 도달했을 때
				System.out.println("성공");
				System.out.println("총 시도 횟수="+steps);
			}
		}
		if(steps == 20){//움직인 횟수가 20번 넘었을 경우
			if(x != coordinateX || y != coordinateY){//목표 지점 도달에 실패했을 때
				System.out.println("실패");
			}
		}
	}
}

