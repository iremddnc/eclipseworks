import java.util.Arrays;

public class Ex11 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

 class ArrayUtils {
    
    public static int numOfTriplets(int[] arr,int sum) {
      int count=0;
      int s=arr.length;
        Arrays.sort(arr);
        
        for(int i=0;i<s-2;i++) {
            int l=i+1;
            int r=s-1;
            
       while(l<r) {
          if(arr[i]+arr[l]+arr[r]<sum) {
            count += r-l;
             l++; } 
               else {
                    r--;
                }
            }
          }
        return count;
    }
    public static int kthSmallest(int[] arr,int k) {
      Arrays.sort(arr);
        return arr[k - 1];
    }
    
   
    public static int isSubString(String str1, String str2) {
        int a=str1.length();
        int b=str2.length();
        
        if (b>a)
            return -1;
        
        for(int i=0;i<=(a-b);i++) {
            int j;
            
          for(j=0;j<b; j++) {
               if (str1.charAt(i+j)!= str2.charAt(j))
            break;
            }
            if (j == b)
                return i;
        }
        return -1;
    }
    public static String subSequence(String str) {
        int n= str.length();
        int[] m = new int[n];
        Arrays.fill(m,1);
        int maxLength=1;
        int endIndex=0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (str.charAt(i) > str.charAt(j) &&m[j]+1 > m[i]) {
                    m[i] = m[j] + 1;
                    if (m[i] > maxLength) {
                        maxLength = m[i];
                        endIndex = i;
                    }
                }
            }
        }

        char[] subsequence = new char[maxLength];
        subsequence[maxLength - 1] = str.charAt(endIndex);
        maxLength--;

        for (int i = endIndex - 1; i >= 0; i--) {
            if (str.charAt(i) < subsequence[maxLength] &&m[i] == maxLength) {
                subsequence[maxLength - 1] = str.charAt(i);
                maxLength--;
            }
        }

        return new String(subsequence);
    }

    public static void findRepeats(int[] arr,int n) {
        int lngth = arr.length;
        Arrays.sort(arr);
        int count=1;
        
        for (int i = 1; i < lngth; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            }
             else {
               if(count>n) {
                    System.out.println(arr[i-1]);
                }
                count = 1;
            }
         }
        if(count>n){
            System.out.println(arr[lngth-1]);
        }
    }
}
