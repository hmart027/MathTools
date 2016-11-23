package trial;

import math2.Matrix;

public class Trial {
	
	public Trial(){
		double[][] m1= {
				{1,  5,12,52},
			    {7,10,13,65},
			    {4,  3,  5,48}
		};
		
		m1 = Matrix.random(5, 5).r;
		
		long t0 = System.currentTimeMillis();
		double[][] m2 = Matrix.cov(m1);
		System.out.println(System.currentTimeMillis()-t0);
		
//		m2= new double[][]{
//				{-2,1,0,0},
//			    {1,-2,1,0},
//			    {0,1,-2,1},
//			    {0,0,1,-2}
//		};
		
		m2= new double[][]{
				{ 10,  8,  4,  3,  1},
			    {  8, 14,  4,  7, -4},
			    {  4,  4,  5,  1, -1},
			    {  3,  7,  1, 21,-12},
			    {  1, -4, -1,-12,  9}
		};

		System.out.println("\nCov Matrix");
		int[] l = new int[]{m2.length,m2[0].length};
		for(int y=0; y<l[0]; y++){
			for(int x=0; x<l[1]; x++){
				System.out.print(Math.round(m2[y][x]*100)/100.0+"\t");
			}
			System.out.println();
		}

//		t0 = System.currentTimeMillis();
		m2 = Matrix.householder(m2);
//		System.out.println("\n\n"+(System.currentTimeMillis()-t0));
		
		System.out.println("\nDiag Matrix");
		for(int y=0; y<l[0]; y++){
			for(int x=0; x<l[1]; x++){
				System.out.print(Math.round(m2[y][x]*10000)/10000.0+"\t");
			}
			System.out.println();
		}
		
		double[] eVals = Matrix.bisectionMethod(Matrix.householder(m2), 0, 35, 10e-6);
		System.out.println("\nEigen Values: ");
		for(int i=0; i<eVals.length; i++){
			System.out.println(Math.round(eVals[i]*10000)/10000.0);
		}
	}
	
	public static void main(String[] args){
		new Trial();
	}

}
