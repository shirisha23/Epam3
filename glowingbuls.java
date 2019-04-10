
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
     static long multiples(ArrayList<Integer> s,long m )
    {
        long multiple = 0;
		for (long i = 1; i < (1 << s.size()); i++) {
			long p = 1;
			long sign = -1;
			for (int j = 0; j < s.size(); j++) {
				if (((i >> j) & 1) == 1) {
					p = p * s.get(j);
					sign = sign * -1;
				}
			}
			multiple= multiple+ (m / p) * sign;
		}
		return multiple;
    }
    
    static long solve(ArrayList<Integer> s, long k)
    {
        long bulbs = 0;
		long low = 1;
		long high = 1000000000000000L;
		long mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (multiples( s, mid) >= k) {
				bulbs = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return bulbs;

    }
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine()); // Reading input from STDIN
        while(test_cases--!=0)
        {
            String switches = br.readLine();
            ArrayList<Integer> s = new ArrayList<Integer>();
            for(int i=0;i<40;i++)
            {
                if (switches.charAt(i) == '1') 
				    s.add(i + 1);
            }
            long k= Long.parseLong(br.readLine());
            System.out.println(solve(s,k));
        }

        // Write your code here

    }
}
