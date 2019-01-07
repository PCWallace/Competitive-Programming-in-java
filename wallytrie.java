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
import java.util.List;
import java.util.TreeSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.math.BigInteger; 
 
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
        Trie  solver = new Trie();
        solver.solve(1, in, out);
        out.close();
    }
    static class Trie
	{
		public void solve(int testNumber, FastReader in, PrintWriter out)			//main code
			{
				List<Integer> ans=getAnswer(in);
				int l=ans.size();
				for(int i=0;i<l;i++)
					out.println(ans.get(i));
				
			}
		
		public static List<Integer> getAnswer(FastReader in)
			{
				int n=in.nextInt();
				List<Integer> al=new ArrayList<>();
				Trie.TrieNode root=null;
				while(n!=0)
					{
						String aa[]=in.nextStringArray(2);
						
						
						if(aa[0].equals("add"))
							{
								root=insertWord(root,aa[1]);
							}
						else
							{
								int ans=getWords(root,aa[1]);
								al.add(ans);
							}
						n--;
					}
				return al;
			}
		
		public static Trie.TrieNode insertWord(Trie.TrieNode root,String s)//making of the trie
			{
				if(root==null)
					{
						root=new Trie.TrieNode();
					}	
				
				Trie.TrieNode v=root;
				
				for(char letter:s.toCharArray())//converting the string to chararray and making the trie
					{
						Trie.TrieNode tmp=v.arr[letter-'a'];
						if(tmp==null)
							{
								tmp=v.arr[letter-'a']=new Trie.TrieNode();
							}
						
						v=v.arr[letter-'a'];//this simply moving ahead the pointer like Node=Node.next
						v.count++;
					}
				v.isWord=true;
				return root;
			}
		
		public static int getWords(Trie.TrieNode root,String prefix)
			{
				Trie.TrieNode v=root;
				if(v==null)
					return 0;
				for(char letter:prefix.toCharArray())
					{
						Trie.TrieNode tmp=v.arr[letter-'a'];
						if(tmp==null)
							{
								return 0;
							}
						v=v.arr[letter-'a'];
					}
				
				return v.count;
			}

		/**public static void dfs(Trie.TrieNode root,String s,int ans[])
			{
				if(root.isWord)
					{
						ans[0]++;
					}
				for(int i=0;i<26;i++)
					{
						if(root.arr[i]!=null)
							{
						dfs(root.arr[i],new String(s+(char)(i+'a')),ans);
								
							}
					}
				
			}**/					
					

		public static class TrieNode  //nested class concept
			{
				TrieNode arr[];
				boolean isWord;
				int count;
				public TrieNode()
					{
						this.arr=new TrieNode[26];
						this.isWord=false;
						this.count=0;
					}
			}
	}

   
    

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
 
	public BigInteger nextBigInteger() {
            return new BigInteger(nextString());
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
	
	public String[] nextStringArray(int n)
		{
			String aa[]=new String[2];
			for(int i=0;i<2;i++)
				aa[i]=nextString();
			return aa;
		}
	public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }
 
	public BigInteger[] nextBigIntegerArray(int n) {
            BigInteger[] array = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextBigInteger();
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
