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
        DIJK  solver = new DIJK();
        solver.solve(1, in, out);
        out.close();
    }
 static class  DIJK
     {
	static HashMap<Integer,ArrayList<Integer>> hs=new HashMap<>();
	static HashMap<Integer,ArrayList<Integer>> hsr=new HashMap<>();
	static ArrayList<Integer> order=new ArrayList<>();
	static ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
	static boolean visited[];
	static int c=0,n,e;
        public void solve(int testNumber, FastReader in, PrintWriter out)            //main code
            {
			int t=in.nextInt();
			while(t!=0)
				{
		 	    		n=in.nextInt();	//number of nodes
					e=in.nextInt();	//number of edges
					visited=new boolean[n+1];	
					for(int i=1;i<=n;i++)
						{
							hs.put(i,new ArrayList<>());
							hsr.put(i,new ArrayList<>());
						}
					for(int i=1;i<=e;i++)
						{
							int u=in.nextInt();
							int v=in.nextInt();
							ArrayList<Integer> tmp=hs.get(u);
							tmp.add(v);
							hs.put(u,tmp);
							tmp=hsr.get(v);
							tmp.add(u);
							hsr.put(v,tmp);
						}
					Arrays.fill(visited,false);
					for(int i=1;i<=n;i++)
						{
							if(!visited[i])
								{
									dfs1(i);
								}
						}
					for(int i=n-1;i>=0;i--)
						out.print(order.get(i)+" ");
					out.println();
					Arrays.fill(visited,false);
					for(int i=0;i<n;i++)
						{
							int v=order.get(n-i-1);
							if(!visited[v])
								{
									ans.add(new ArrayList<Integer>());
									dfs2(v);
									
								}
						}
					int kk=ans.size();
					for(int i=0;i<kk;i++)
						{
							ArrayList<Integer> tmp=ans.get(i);
							int ll=tmp.size();
							for(int j=0;j<ll;j++)
								out.print(tmp.get(j)+" ");
							out.println();
						}
					t--;
				}
	    }
	
	public static void dfs1(int v)
		{
			visited[v]=true;
			ArrayList<Integer> tmp=hs.get(v);
			int nn=tmp.size();
			for(int i=0;i<nn;i++)
				{
					if(!visited[tmp.get(i)])
						dfs1(tmp.get(i));
				}
			order.add(v);
		}

	public static void dfs2(int v)
		{
			visited[v]=true;
			int gh=ans.size();
			ans.get(gh-1).add(v);
			ArrayList<Integer> tmp=hsr.get(v);
			int nn=tmp.size();
			for(int i=0;i<nn;i++)
				{
					if(!visited[tmp.get(i)])
						dfs2(tmp.get(i));
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
