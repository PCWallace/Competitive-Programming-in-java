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
        BFS  solver = new BFS();
        solver.solve(1, in, out);
        out.close();
    }
    static class  BFS//it is for undirected graph
	{
		public void solve(int testNumber, FastReader in, PrintWriter out)			//main code
			{
				int n=in.nextInt();//number of the nodes
				int e=in.nextInt();//number of the edges
				HashMap<Integer,List<Integer>> hs=new HashMap<>();	//adjacency list of wallace
				for(int i=0;i<n;i++)//initialising the adjacency list
					{
						hs.put(i,new ArrayList<>());
					}
				for(int i=0;i<e;i++)//this is how we link the graph ok
					{
						int sv=in.nextInt();
						int ev=in.nextInt();
						List<Integer> al=hs.get(sv);//it will contain the head of the linklist
						al.add(ev);
						hs.put(sv,al);//we are mapping value with the head of the linklist
						al=hs.get(ev);
						al.add(sv);
						hs.put(ev,al);
					}
				//printing the bfs path u can write the function
				bfs(hs);
			}
		public static void bfs(HashMap<Integer,List<Integer>> hs)//bfs function which will do the things
			{
				boolean vis[]=new boolean[hs.size()];//intially deafault value is false
				calc(hs,0,vis);//this will calculate the path from 1 in the bfs order
			} 
		public static void calc(HashMap<Integer,List<Integer>> hs,int sv,boolean vis[])//this function perform the function
			{
				Queue<Integer> q=new LinkedList<>();
				q.add(sv);
				vis[sv]=true;
				while(!q.isEmpty())
					{
						int ans=q.poll();
						System.out.println(ans);//this is printing part
						List<Integer> tmp=hs.get(ans);
						int ll=tmp.size();
						for(int i=0;i<ll;i++)//fill the queue with the neighbours
							{
								int tt=tmp.get(i);
								if(!vis[tt])
									{
										vis[tt]=true;
										q.add(tt);
									}
								
							}
					}
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
