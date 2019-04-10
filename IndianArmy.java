import java.io.*;
import java.util.*;
public class army {
 
 public static long c;
 public static long d;
 public static long res=0;
 
 public long  res(TreeMap<Long,Long> tr1,long start,long end) {
    TreeMap<Long,Long> tr2=new TreeMap<Long,Long>();
    
  Map.Entry<Long,Long> temp = tr1.entrySet().iterator().next();
 
  c = temp.getKey();
  d = temp.getValue();
  
  tr1.forEach((key,value)-> {
    if(key<=d){
        d = Math.max(d,value);
        }
    else
    {
        tr2.put(c,d);
        c=key;
        d=value;
    }}
    );
  
    tr2.put(c,d);
 
   for(Map.Entry<Long,Long> entry:tr2.entrySet()){
   Long k=entry.getKey();
   long v=entry.getValue();
   if(start>=end)
        {
            start=end;
            break;
        }
         if(k<=start && start<=v)
            start =v;
        else if(start<=k && end>=v )
        {
          res+=k-start;
            start = v;
           
        }
        else if(start<=k && end>=k && end<=v)
        {
          res+=k-start;
            start = v;
           
        }
        
          else if(start<=k &&end<=k)
        {
            res+=end-start;
            start = end;
        }
    }
    if(start<end)
        res+=end-start;
    return res;
    
  }
  
public static void main(String args[])throws Exception {
        army ob=new army();
         //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");                // Reading input from STDIN
        // Write your code here
        int n= Integer.parseInt(input[0]);
        long s= Long.parseLong(input[1]);
        long e= Long.parseLong(input[2]);
        TreeMap<Long,Long> t= new TreeMap<Long,Long>();
        while(n--!=0)
        {
            String[] in = br.readLine().split(" ");
            long x=Long.parseLong(in[0]);
            long p=Long.parseLong(in[1]);
            t.put(x-p,x+p);
        }
        System.out.println(ob.res(t,s,e));
    }
      
}
