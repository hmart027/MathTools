package math2;

import math.tools.exceptions.MatrixSizeMismatchException;

public class Matrix {
	
	public double[][] r;
	public double[][] i;
	
	public Matrix(int l){
		r = new double[l][l];
	}
	
	public Matrix(int m, int n){
		r = new double[m][n];
	}
	
	public Matrix(double[][] mat){
		this.r=mat;
	}
	
	public static Matrix random(int m, int n){
		Matrix out = new Matrix(m,n);
		for(int y=0; y<m; y++)
			for(int x=0; x<n; x++)
				out.r[y][x] = 10*Math.random();
		return out;
	}
	
	public static Matrix getIdentityMatrix(int l){
		return new Matrix(getIdentity(l));
	}
		
	public Matrix add(Matrix m) throws MatrixSizeMismatchException{
		return new Matrix(add(this.r, m.r));
	}
	
	public Matrix substract(Matrix m) throws MatrixSizeMismatchException{
		return new Matrix(substract(this.r, m.r));
	}

	public Matrix multiply(double a){
		return new Matrix (multiply(this.r, a));
	}
	
	public Matrix divide(double a){
		return new Matrix (divide(this.r, a));
	}
	
	public Matrix multiply(Matrix m) throws MatrixSizeMismatchException{
		return new Matrix (multiply(this.r, m.r));
	}
	
	public static double[][] getIdentity(int l){
		double out[][] = new double[l][l];
		for(int i=0; i<l; i++)
			out[i][i]=1;
		return out;
	}
	
	public static double[][] transpose(double[][] m){
		int[] l = new int[]{m.length,m[0].length};
		double[][] out = new double[l[1]][l[0]];
		for(int y=0; y<l[0]; y++)
			for(int x=0; x<l[1]; x++)
				out[x][y]=m[y][x];
		return out;
	}
	
	public static float[][] transpose(float[][] m){
		int[] l = new int[]{m.length,m[0].length};
		float[][] out = new float[l[1]][l[0]];
		for(int y=0; y<l[0]; y++)
			for(int x=0; x<l[1]; x++)
				out[x][y]=m[y][x];
		return out;
	}
	
	public static double[][] add(double[][] m1, double[][] m2) throws MatrixSizeMismatchException{
		if(m1.length!=m2.length) throw new MatrixSizeMismatchException();
		if(m1[0].length!=m2[0].length) throw new MatrixSizeMismatchException();
		int l = m1.length;
		double out[][] = new double[l][l];
		for(int y=0; y<l; y++)
			for(int x=0; x<l; x++)
				out[y][x]=m1[y][x]+m2[y][x];
		return out;
	}
	
	public static double[][] substract(double[][] m1, double[][] m2) {
		if(m1.length!=m2.length) return null;
		if(m1[0].length!=m2[0].length) return null;
		int l = m1.length;
		double out[][] = new double[l][l];
		for(int y=0; y<l; y++)
			for(int x=0; x<l; x++)
				out[y][x]=m1[y][x]-m2[y][x];
		return out;
	}

	public static double[][] multiply(double[][] m, double a){
		int l = m.length;
		double out[][] = new double[l][l];
		for(int y=0; y<l; y++)
			for(int x=0; x<l; x++)
				out[y][x] = a*m[y][x];
		return out;
	}
	
	public static double[][] divide(double[][] m, double a){
		int l = m.length;
		double out[][] = new double[l][l];
		for(int y=0; y<l; y++)
			for(int x=0; x<l; x++)
				out[y][x] = m[y][x]/a;
		return out;
	}

	public static double[][] multiply(double[][] m1, double[][] m2){
		int[] l1 = new int[]{m1.length,m1[0].length};
		int[] l2 = new int[]{m2.length,m2[0].length};
//		if(l1[0]!=l2[1] || l1[1]!=l2[0]) return null;
		if(l1[1]!=l2[0]) return null;
		double out[][] = new double[l1[0]][l2[1]];
		double t = 0;
		double[][] m2t = transpose(m2);
		for(int y=0; y<l1[0]; y++){
			for(int x=0; x<l2[1]; x++){
				t=0;
				for(int i=0; i<l1[1]; i++)
					t+=m1[y][i]*m2t[x][i];
				out[y][x] = t;
			}
		}
		return out;
	}

//	public static double[][] pow(double[][] m, double pow) throws MatrixSizeMismatchException{
//		int[] l = new int[]{m.length,m[0].length};
//		if(l[0]!=l[1]) throw new MatrixSizeMismatchException();
//		double out[][] = new double[l[0]][l[1]];
////		while
//		return out;
//	}
	
	public static double[][] cov(double[][] m){
		int[] l = new int[]{m.length,m[0].length};
		double[][] m2 = m.clone();
		for(int x=0; x<l[1]; x++){
			double u = 0;
			for(int y=0; y<l[0]; y++){
				u += m[y][x];
			}
			u/=(double)l[0];
			for(int y=0; y<l[0]; y++){
				m2[y][x] -= u;
			}
		}
		double[][] m2t = transpose(m2);
		double c = 1/((double)l[0]-1);
		double out[][] = new double[l[1]][l[1]];
		double t = 0;
		for(int y=0; y<l[1]; y++){
			for(int x=0; x<l[1]; x++){
				t=0;
				for(int i=0; i<l[0]; i++){
					t+=m2t[y][i]*m2t[x][i];
				}
				out[y][x] = t*c;
			}
		}
		return out;
	}

	public static double[][] householder(double[][] m){
		int[] l = new int[]{m.length,m[0].length};
		if(l[0]!=l[1])return null;
		int n = l[0];
		double[][] out = m.clone();
		double[][] I = getIdentity(n);
		double[][] wrt = new double[1][n];
		for(int r=0; r<n-2; r++){
			double[][] yt = new double[1][n-(r+2)];
			for(int i=r+2; i<n; i++)
				yt[0][i-(r+2)] = out[r][i];
			double S = Math.sqrt( Math.pow(out[r][r+1], 2) + multiply(yt, transpose(yt))[0][0]);
			double a = 1/Math.sqrt(2.0*S*(S+Math.signum(out[r][r+1])*out[r][r+1]));
			double v = out[r][r+1]+Math.signum(out[r][r+1])*S;
			for(int i=0; i<n; i++){
				if(i<r+1)
					wrt[0][i] = 0;
				if(i==r+1)
					wrt[0][i] = v*a;
				if(i>r+1)
					wrt[0][i] = yt[0][i-(r+2)]*a;
			}
			double[][] T = substract(I, multiply(multiply(transpose(wrt), wrt),2));
			out = multiply(multiply(T,out),transpose(T));
		}
		return out;
	}
	
	public static int sturm(double[][] m, double a, double b){
		int n = m.length;
		int sCount = 0;
		double PrA = 0, Pr1A = 1, Pr2A = 0;
		double PrB = 0, Pr1B = 1, Pr2B = 0;
		for(int r=0; r<n; r++){
			if(r==0){
				PrA = m[0][0]-a;
				PrB = m[0][0]-b;
			}else{
				PrA = (m[r][r]-a)*Pr1A - Pr2A*Math.pow(m[r][r-1],2);
				PrB = (m[r][r]-b)*Pr1B - Pr2B*Math.pow(m[r][r-1],2);
			}
			if(Math.signum(PrA) == Math.signum(Pr1A) || PrA==0){
				sCount++;
			}
			if(Math.signum(PrB) == Math.signum(Pr1B) || PrB==0){
				sCount--;
			}
			Pr2A = Pr1A;
			Pr2B = Pr1B;
			Pr1A = PrA;
			Pr1B = PrB;
		}
		return sCount;
	}
	
	public static double[] bisectionMethod(double[][] m, double a, double b, double error){
		int eValCount = sturm( m, a, b);
		double[] out = new double[eValCount];
		if(eValCount==0){
			return new double[0];
		}
		if(eValCount==1){
			out[0] = bisection( m, a, b, error);
			return out;
		}
		double middle = (a+b)/2.0;
		double[] left    = bisectionMethod( m, a, middle, error);
		double[] right = bisectionMethod( m, middle, b, error);
		int c = 0;
		for(int i=0; i<left.length; i++){
			out[c++] = left[i];
		}
		for(int i=0; i<right.length; i++){
			out[c++] = right[i];
		}
		return out;
	}

	private static double bisection(double[][] m, double a, double b, double error){
		double e = b - a;
		while (e > error) {
			double mid = (b + a) / 2.0;
			int lC = sturm(m, a, mid);
			if (lC > 0)
				b = mid;
			else
				a = mid;
			e = b-a;
		}
		return (b+a)/2.0;
	}
	
	public static double det(double[][] m){
		int[] l = new int[]{m.length,m[0].length};
		if(l[0]!=l[1]) return 0;
		int n = l[0];		
	    double[][] m1 = householder(m);
		return det(m1, n, n);
	}
	
	private static double det(double[][] m, int n, int oN){
		if(n==-1) return 0;
		if(n==0) return 1;
		if(n==1)return Math.abs(m[0][0]);
		return m[n-1][n-1]*det(m,n-1, oN)-m[n-1][n-2]*m[n-2][n-1]*det(m,n-2, oN);
	}

}
