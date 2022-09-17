package Assignment;

import java.util.Scanner;

public class Rain_Water_Trapping {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] ans=new int [n];
		int i=0;
		int size;
		while(i < n) {
			size=sc.nextInt();
			int [] arr=new int [size];
			for (int j = 0; j < arr.length; j++) {
				arr[j]=sc.nextInt();
			}
			ans[i]=Water_Trapping(arr);
			i++;
		}
		for (int l = 0; l < ans.length; l++) {
			System.out.println(ans[l]);
		}	
	}
	public static int Water_Trapping(int [] arr) {
		// TODO Auto-generated method stub
		int [] LeftMax=new int[arr.length];
		LeftMax[0]=arr[0];
		for (int i = 1; i < LeftMax.length; i++) {
			LeftMax[i]=Math.max(LeftMax[i-1], arr[i]);
		}
		int [] RightMax=new int[arr.length];
		RightMax[arr.length-1]=arr[arr.length-1];
		for (int k = RightMax.length-2; k >= 0 ; k--) {
			RightMax[k] = Math.max(arr[k], RightMax[k+1]);
		}
		int sum=0;
		for (int l = 0; l < arr.length-1; l++) {
			sum=sum+Math.min(RightMax[l],LeftMax[l])-arr[l];
		}
		return sum;
	}

}
