package math2;

public class Vector {
	
	public static float[] add(float[] a1, float[] a2){
		if(a1.length!=a2.length) return null;
		float[] out = new float[a1.length];
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
	
	public static float[] scalarMult(float[] array, float scalar){
		if(array==null || array.length==0) return null;
		float[] out = new float[array.length];
		for(int i=0; i<array.length; i++)
			out[i] = array[i]*scalar;
		return out;
	}

}
