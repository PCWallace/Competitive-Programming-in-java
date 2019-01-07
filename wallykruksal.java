import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
 import java.util.*;
 
/**
 * Using FastReader and Output Class
 * @author Wallace
 */
 class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        KRUK  solver = new KRUK();
        solver.solve(1, in, out);
        out.close();
    }
 static class  KRUK
     {
	static ArrayList<Integer> parent,rank; //gloabal Arraylist
        public void solve(int testNumber, FastReader in, PrintWriter out)            //main code
            {
			int v=in.nextInt();	// number of the vertices
			int e=in.nextInt();	// number of the edges
			//taking the input number of edges

			ArrayList<Pair> al=new ArrayList<>();
			for(int i=0;i<e;i++)
				{
					int st=in.nextInt();
					int ed=in.nextInt();
					int wt=in.nextInt();
					Pair p=new Pair(st,ed,wt);
					al.add(p);			
				}
			int cost=0;
			parent =new ArrayList<>(e+1);
			rank=new ArrayList<>(e+1);
			for(int i=0;i<=e;i++)
				{
					parent.add(0);
					rank.add(0);
				}
			for(int i=1;i<=e;i++)
				{
					makeset(i);
				}
			Collections.sort(al,new SortEdge());
			ArrayList<Pair> result = new ArrayList<>();
			for (Pair ee : al) 
				{
				    if (findset(ee.st) != findset(ee.ed))
					 {
						cost += ee.wt;
						result.add(ee);
						unionset(ee.st, ee.ed);
				    	}
				}
			
			out.println(cost);
	    }

	//this function does the unionof the two set
	public static void unionset(int a,int b)
		{
			a=findset(a);
			b=findset(b);
			if(a!=b)
				{
					if(rank.get(a)<rank.get(b))
						{
							int tmp=a;
							a=b;
							b=tmp;
						}
					parent.set(b,a);
					if(rank.get(a)==rank.get(b))
						{
							int tmp=rank.get(a);
							rank.set(a,tmp+1);
						}
				}
		}

	//this function help to find as well as path reduction process
	public static int findset(int v)
		{
			if(v==parent.get(v))
				return v;
			 parent.set(v,findset(parent.get(v)));
				return parent.get(v);
		}	

	//this function make the set at initial state
	public static void makeset(int v)
		{
			parent.set(v,v);
			rank.set(v,0);
		}

	// this class is used to take edges with weight
	static class Pair
		{
			int st,ed,wt;
			
			Pair (int st,int ed,int wt)
				{
					this.st=st;
					this.ed=ed;
					this.wt=wt;
				}
		}
	// this is to sort the edges with respect to weight
	static class SortEdge implements Comparator<Pair>
		{

			public int compare(Pair p1,Pair p2)
				{
					return p1.wt-p2.wt;
				}
		}
    }
                
    
 //fastreader
    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int pnumChars;
 
        public FastReader(InputStream stream) {
            this.stream = stream;
        }
 
        private int pread() {
            if (pnumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= pnumChars) {
                curChar = 0;
                try {
                    pnumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (pnumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
 
        public int nextInt() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = pread();
            }
            int res = 0;
            do {
                if (c == ',') {
                    c = pread();
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = pread();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
    public String next() {
            return nextString();
        }
    
     public String nextString() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = pread();
            } while (!isSpaceChar(c));
            return res.toString();
        }
    
    public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    
    public double[] nextDoubleArray(int n) {
            double[] array = new double[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextDouble();
            }
            return array;
        }
 
    public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }
 
        public long nextLong() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = pread();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = pread();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
     public double nextDouble() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = pread();
            }
            double res = 0.0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = pread();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
      
 
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
    }
 
 
} 
