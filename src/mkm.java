
public class mkm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "CSE 101 is BITTI";
		for(int i = 0; i < s.length(); i++)
		if(s.charAt(i) >= '9' && s.charAt(i) <= '1')
		System.out.print("102");
		else if (s.charAt(i) == 'I') {
		System.out.print("SONRA");
		break;
		} else {
		System.out.print(s.charAt(i));
		i++;
		}
		int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		double total = 0;
		for (int i = 1; i < 3; i++){
		for(int j = 0; j < 2; j++)
		if (arr[i][j] % 2 == 0)
		total -= arr[i][j] * 1.5;
		else
		total += arr[i][j];
		System.out.println(total);}
System.out.println(mystery(7,3));
System.out.println(mystery(2,25));}
public static int mystery(int a,int b) {
	if(b==0)
	return 0;
	if(b%2==0)
		return mystery(a+a,b/2);
	return mystery(a+a,b/2)+a;

}}


