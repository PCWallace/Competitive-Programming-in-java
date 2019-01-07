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
        PRIMS  solver = new PRIMS();
        solver.solve(1, in, out);
        out.close();
    }
 static class  PRIMS
 	{
		public void solve(int testNumber, FastReader in, PrintWriter out)			//main code
			{
				int n=in.nextInt();		//number of nodes
				int e=in.nextInt();		//number of edges
				HashMap<Integer,Node<Integer>> hs=new HashMap<>();//declaration of adjacency list
				for(int i=0;i<n;i++)
					{
						hs.put(i,null);
					}
				for(int i=0;i<e;i++)
					{
						int fv=in.nextInt();
						int sv=in.nextInt();
						int wt=in.nextInt();
						Node<Integer> head1=insert(sv,hs.get(fv),wt);
						hs.put(fv,head1);
						Node<Integer> head2=insert(fv,hs.get(sv),wt);
						hs.put(sv,head2);
					}
				prims(hs);
			}
		
		public static Node<Integer> insert(int data,Node<Integer> head,int wt)
			{
				Node<Integer> node=new Node<>(data,wt);
				node.next=null;
				if(head==null)
					{
						head=node;
					}
				else
					{
						Node<Integer> tmp=head;
						while(tmp.next!=null)
							{
								tmp=tmp.next;
							}
						tmp.next=node;
					}
				return head;
			}
		
		public static void prims(HashMap<Integer,Node<Integer>> hs)
			{
				int n=hs.size();
				boolean vis[]=new boolean[n];//this is the visisted array which tell us whether the node is visited or not
				int weight[]=new int[n];//this will contain the weight of the node
				int parent[]=new int[n];//this will contain the parent of the node
				for(int i=0;i<n;i++)
					{
						vis[i]=false;//initialisng with the false
						weight[i]=Integer.MAX_VALUE;//initialising with the max value in it
					}
				PriorityQueue<Node<Integer>> pq=new PriorityQueue<>(n,new MyComparator());//this is the key reduce time complexity
				Node<Integer> node=new Node<>(0,0);
				pq.add(node);
				parent[0]=-1;
				while(pq.size()>0)
					{
						Node<Integer> tmp=pq.poll();//topmost element aa gya
						int v1=tmp.data;
						vis[v1]=true;
						//now we have to add all adjacent to it to the priority queue
						Node<Integer> head=hs.get(v1);//this is the address of the adjacent to v1
						while(head!=null)
							{
								int v2=head.data;
								if(!vis[v2] && head.wt<weight[v2])//not visited and the wt is less
									{
										weight[v2]=head.wt;
										parent[v2]=v1;
										pq.add(head);
									}
								head=head.next;
							}
					}
				for(int i=0;i<n;i++)
					{
						System.out.println(i+" "+parent[i]+"  "+weight[i]);
					}
			}
	}

 

 static class Node<T>//for the weighted list
	{
		public T data;
		public T wt;
		Node next;
		Node(T data,T wt)
			{
				this.data=data;
				this.wt=wt;
				next=null;
			}
	}
 //wally comparator	
 static class MyComparator implements Comparator<Node<Integer>>
	{
		public int compare(Node<Integer> x,Node<Integer> y)
			{
				return x.wt-y.wt;
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
