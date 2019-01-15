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
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
 
 
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
        Bipartite  solver = new Bipartite();
        solver.solve(1, in, out);
        out.close();
    }
    static class  Bipartite
	{
		public void solve(int testNumber, FastReader in, PrintWriter out)			//main code
			{
				int n=in.nextInt();		//number of nodes
				int m=in.nextInt();		//number of nodes
				HashMap<Integer,ArrayList<Integer>> hs=new HashMap<>();
				for(int i=1;i<=n;i++)		//initialising the hashmap
					hs.put(i,new ArrayList<>());
				for(int i=1;i<=n;i++)	//my adjacency list
					{
						int a=in.nextInt();
						int b=in.nextInt();
						ArrayList<Integer> tmp=hs.get(a);
						tmp.add(b);
						hs.put(a,tmp);
						tmp=hs.get(b);
						tmp.add(a);
						hs.put(b,tmp);
					}
				out.println(bipartite(hs,n));
			}
		//bipartite function		
		public static boolean bipartite(HashMap<Integer,ArrayList<Integer>> hs,int n)
			{
				int cl[]=new int[n];
				Arrays.fill(cl,-1);
				boolean is_bipartite = true;
				Queue<Integer> q=new LinkedList<>();
				for(int st=1;st<=n;st++)
					{
						if(cl[st-1]==-1)
							{
								q.add(st);
								cl[st-1]=0;
								while(!q.isEmpty())
									{
										int v=q.poll();
										for(int u : hs.get(v))
											{
												if (cl[u]==-1)
										 			{
													    cl[u] = cl[v] ^ 1;
													    q.add(u);
													} 
												else
													{
													    is_bipartite&=cl[u]!=cl[v];
													}
											}
									}
							}
					}
				return is_bipartite;
			}		
	}

 //for the fastreader
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
	//pcwallace
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
// pcwallace
