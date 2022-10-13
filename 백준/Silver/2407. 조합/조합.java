import java.math.BigInteger;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){

		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		

		BigInteger ja = new BigInteger("1");
		BigInteger mo = new BigInteger("1");
		for(int i = N ; i > N-R ; i--) {
			ja = ja.multiply(new BigInteger(i+""));
		}
		for(int i = R ; i >= 1 ; i--) {
			mo = mo.multiply(new BigInteger(i+""));
		}
		
		BigInteger comb = ja.divide(mo);

		System.out.println(comb);
	}
}