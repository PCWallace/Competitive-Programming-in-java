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
        SegTree  solver = new SegTree();
        solver.solve(1, in, out);
        out.close();
    }
 static class  SegTree
     {
         static long tree[];
        public void solve(int testNumber, FastReader in, PrintWriter out)            //main code
            {
		int n=in.nextInt();
        int a[]=in.nextIntArray(n);
        SegmentTree seg= new SegmentTree(n);
            seg.buildTree(a, 0, n - 1, 1);
            int q=in.nextInt();
            while(q!=0){
                //queries will be coming
            }

        }

        static class SegmentTree {
            public SegmentTree(int n) {
                tree = new long[4 * n];
            }

            // this is to build tree the time complexity is O(n)
            public void buildTree(int a[], int st, int en, int treeIndex) {
            if(st==en){
                tree[st]=a[st];
                return;
            }            
            int mid=st+(en-st)/2;
            buildTree(a, st, mid, 2*treeIndex);
            buildTree(a, mid+1, en, 2*treeIndex+1);
            tree[treeIndex]=tree[2*treeIndex]+tree[2*treeIndex+1];
        }

        //there is two type of update range update or particular index update 
        //range update could be done using lazypropogation O(logn)
        public static void update(int treeIndex,int st,int en,int pos,int val){
            if(st==en){
                tree[st]=val;
                return;
            }           
            int mid=(st+en)/2;
            if(mid>=pos)
            update(st, mid, pos, val, 2*treeIndex);
            else
            update(mid+1, en, pos, val, 2*treeIndex+1);
            tree[treeIndex]=tree[2*treeIndex]+tree[2*treeIndex+1];
        }

        //range query l to r time complextity is O(logn)
        public static long query(int treeIndex,int l,int r,int st,int en){
            //completely outside
            if(l>en || r<st)
            return 0;
            //completely inside
            if(st>=l && en<=r)
            return tree[treeIndex];
            int mid=(st+en)/2;
            return  query(2*treeIndex, l, r, st, mid)+query(2*treeIndex+1, l, r, mid+1, en);
            
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
