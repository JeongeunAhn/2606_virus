import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		TreeSet<Integer> treeset = new TreeSet<Integer>();
		treeset.add(1);
		int a=0,b=0;
		int number = sc.nextInt();
		int pairnumber = sc.nextInt();
		ArrayList<matching> arraylist = new ArrayList<matching>();
		//연결 정보를 arraylist에 저장
		for(int i =0;i<pairnumber;i++) {
			a=sc.nextInt();
			b=sc.nextInt();
			arraylist.add(new matching(a,b));
		}

		Iterator<matching> itr = arraylist.iterator();
		//연결된 컴퓨터를 set에 넣는다.
		for(int i =0;i<pairnumber;i++)
		{
			itr = arraylist.iterator();
			while(itr.hasNext()) {
				matching temp2 = itr.next();
				//System.out.println(temp2.getnum1());
				if(treeset.contains(temp2.getnum1())|| treeset.contains(temp2.getnum2())) {
					treeset.add(temp2.getnum2());
					treeset.add(temp2.getnum1());
					itr.remove();
				}
			}
		}

		System.out.println(treeset.size()-1);
	}

}
class matching{
	int num1,num2;
	matching(int a, int b){
		num1 =a;
		num2 = b;
	}
	public int getnum1(){
		return num1;
	}
	public int getnum2(){
		return num2;
	}
}