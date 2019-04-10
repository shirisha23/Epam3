//https://www.hackerearth.com/problem/algorithm/rod-cutting-problem-7/

/* IMPORTANT: Multiple classes and nested static classes are supported */

// uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());   // Reading numer of test cases from STDIN
        while(t>0)
		{
		    //reading the length of rod
			int n=Integer.parseInt(br.readLine());
			int r=3;
			int cnt=0;
			while(r<=n)
			{
				r=r*2+1;
				cnt++;
			}
			System.out.println(cnt);
			t--;
		}

    }

}
