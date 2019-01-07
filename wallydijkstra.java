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
        public void solve(int testNumber, FastReader in, PrintWriter out)            //main code
            {
			int t=in.nextInt();
			while(t!=0)
				{
		 	    		int v=in.nextInt();	//number of vertices
					int e=in.nextInt();	//number of edges
					HashMap<Integer,ArrayList<Pair>> hs=new HashMap<>();
					//initialising of the graph
					for(int i=0;i<v;i++)
						{
							hs.put(i,new ArrayList<Pair>());
						}
					//taking input
					for(int i=0;i<e;i++)
						{
							int v1=in.nextInt();
							int v2=in.nextInt();
							int w=in.nextInt();
							v1=v1-1;
							v2=v2-1;
							ArrayList<Pair> tmp=hs.get(v1);
							tmp.add(new DIJK.Pair(v2,w));
							hs.put(v1,tmp);
							tmp=hs.get(v2);
							tmp.add(new DIJK.Pair(v1,w));
							hs.put(v2,tmp);
						}
					int source=in.nextInt(); //source 
					source=source-1;
					int dist[]=new int[v];//distance array
					int par[]=new int[v]; //parent of the connection help in path

					for(int i=0;i<v;i++)
						{
							dist[i]=Integer.MAX_VALUE;
							par[i]=-1;
						}
					dijkstra(source,hs,dist,par);	
					for(int i=0;i<v;i++)
						{
							if(i==source)
								continue;
							if(dist[i]==Integer.MAX_VALUE)
								out.print("-1 ");
							else
								out.print(dist[i]+" ");	
						}
					out.println();
					t--;
				}
	    }
	
	public static void dijkstra(int s,HashMap<Integer,ArrayList<Pair>> hs,int dist[],int par[])
		{
			int n=hs.size();
			

			dist[s]=0;
			PriorityQueue<Pair> pq=new PriorityQueue<Pair>(new MyComparator());
			pq.add(new Pair(s,0));//adding source vertex with 0 wt
			//calculating distance
			while(!pq.isEmpty())
				{
					Pair p=pq.poll();
					int v=p.dest;
					int wt=p.wt;
					if(wt!=dist[v]) //this help us 
						continue;
					
					for(Pair adj:hs.get(v))
						{
							int to=adj.dest;
							int adjwt=adj.wt;
							
							if(dist[v]+adjwt < dist[to])
								{
									dist[to]=dist[v]+adjwt;
									par[to]=v;
									pq.add(new Pair(to,dist[to]));
								}	
						}
				}
				
		}	

	static class MyComparator implements Comparator<Pair>
		{
			public int compare(Pair p1,Pair p2)
				{
					return p1.wt-p2.wt;
				}							
		}

	static class Pair
		{
			int dest;
			int wt;
			Pair(int dest,int wt)
				{
					this.dest=dest;
					this.wt=wt;
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
