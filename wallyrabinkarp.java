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
        RBA  solver = new RBA();
        solver.solve(1, in, out);
        out.close();
    }
 static class  RBA
     {
	static long mod=1000000009;
	static long p=31;
        public void solve(int testNumber, FastReader in, PrintWriter out)            //main code
            {
	    	String s=in.nextString();
		String t=in.nextString();
		int S=s.length();
		int T=t.length();
		
		long p_pow[]=new long[(int)Math.max(S,T)];
		p_pow[0]=1;
		//prime number to be multiplied		
		for (int i = 1; i < p_pow.length; i++) 
        		p_pow[i] = (p_pow[i-1] * p) % mod;	
		
		long h[]=new long[T+1];
		Arrays.fill(h,0);
		//hash values of the given text till that index
		for (int i = 0; i < T; i++)
        		h[i+1] = (h[i] + (t.charAt(i) - 'a' + 1) * p_pow[i]) % mod;
		
		//hash values of string to be searched
		long h_s=0;
		for (int i = 0; i < S; i++) 
        		h_s = (h_s + (s.charAt(i) - 'a' + 1) * p_pow[i]) % mod;
			
		ArrayList<Integer> occ=new ArrayList<Integer>();
		for (int i = 0; i + S - 1 < T; i++) 
			{ 
				long cur_h = (h[i+S] + mod - h[i]) % mod; 
				if (cur_h == h_s* p_pow[i] % mod)
				    occ.add(i);
    			}
		int ll=occ.size();
		for(int i=0;i<ll;i++)
			out.println(occ.get(i));
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
