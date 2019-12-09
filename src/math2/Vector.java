package math2;

public class Vector {
	
	public static float[] add(float[] a1, float[] a2){
		if(a1.length!=a2.length) return null;
		float[] out = new float[a1.length];
		for(int i=0; i<a1.length; i++)
			out[i] = a1[i]+a2[i];
		return out;
	}
	
	public static double[] add(double[] a1, double[] a2){
		if(a1.length!=a2.length) return null;
		double[] out = new double[a1.length];
		for(int i=0; i<a1.length; i++)
			out[i] = a1[i]+a2[i];
		return out;
	}
	
	public static float[] substract(float[] a1, float[] a2){
		if(a1.length!=a2.length) return null;
		float[] out = new float[a1.length];
		for(int i=0; i<a1.length; i++)
			out[i] = a1[i]-a2[i];
		return out;
	}
	
	public static double[] substract(double[] a1, double[] a2){
		if(a1.length!=a2.length) return null;
		double[] out = new double[a1.length];
		for(int i=0; i<a1.length; i++)
			out[i] = a1[i]-a2[i];
		return out;
	}
	
	public static double[] mult(double[] a1, double[] a2){
		if(a1.length!=a2.length) return null;
		double[] out = new double[a1.length];
		for(int i=0; i<a1.length; i++)
			out[i] = a1[i]*a2[i];
		return out;
	}
	
	public static float[] scalarMult(float[] array, float scalar){
		if(array==null || array.length==0) return null;
		float[] out = new float[array.length];
		for(int i=0; i<array.length; i++)
			out[i] = array[i]*scalar;
		return out;
	}
	
	public static double[] scalarMult(double[] array, double scalar){
		if(array==null || array.length==0) return null;
		double[] out = new double[array.length];
		for(int i=0; i<array.length; i++)
			out[i] = array[i]*scalar;
		return out;
	}
	
	public static double[] sqrt(double[] a){
		if(a==null) return null;
		double[] out = new double[a.length];
		for(int i=0; i<a.length; i++)
			out[i] = Math.sqrt(a[i]);
		return out;
	}

}
