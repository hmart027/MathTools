package math2;

public class Math2 {
	
	public double[][] householder(double[][] mat){
		int h=mat.length, w=mat[0].length;
		for(int r=1; r<=w-2; r++){
			
		}
		return null;
		
	}
	
	public double[][] jacobi(double[][] mat){
		int h=mat.length, w=mat[0].length;
		int p=0, q=0;
		
		return null;
	}
	
	/**
	 * Converts spherical coordinates to Cartesian.
	 * @param cordinates [R,theta,phi], angles are in degrees.
	 * @return [x,y,z]
	 */
	public static float[] spherical2cartesian(float[] cordinates){
		float x = (float) (cordinates[0]*Math.sin(Math.toRadians(cordinates[2]))*Math.cos(Math.toRadians(cordinates[1])));
		float y = (float) (cordinates[0]*Math.sin(Math.toRadians(cordinates[2]))*Math.sin(Math.toRadians(cordinates[1])));
		float z = (float) (cordinates[0]*Math.cos(Math.toRadians(cordinates[2])));
		return new float[]{x,y,z};
	}
	
	/**
	 * Converts spherical coordinates to Cartesian.
	 * @return [x,y,z]
	 */
	public static float[] spherical2cartesian(float r,float theta, float phi){
		float x = (float) (r*Math.sin(Math.toRadians(phi))*Math.cos(Math.toRadians(theta)));
		float y = (float) (r*Math.sin(Math.toRadians(phi))*Math.sin(Math.toRadians(theta)));
		float z = (float) (r*Math.cos(Math.toRadians(phi)));
		return new float[]{x,y,z};
	}
	
	/**
	 * Converts Cartesian coordinates to spherical.
	 * @param cordinates [x,y,z].
	 * @return [R,theta,phi], angles are in degrees
	 */
	public static float[] cartesian2spherical(float[] cordinates){
		float r, theta, phi;
		r  = (float) (Math.sqrt(Math.pow(cordinates[0],2) + Math.pow(cordinates[1],2) + Math.pow(cordinates[2],2)));
		theta = (float) Math.toDegrees(Math.atan2(cordinates[1], cordinates[0]));
		phi = (float) Math.toDegrees(Math.acos(cordinates[2]/r));
		return new float[]{r, theta, phi};
	}
	
	/**
	 * Converts Cartesian coordinates to spherical.
	 * @return [R,theta,phi], angles are in degrees
	 */
	public static float[] cartesian2spherical(float x, float y, float z){
		float r, theta, phi;
		r  = (float) (Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2)));
		theta = (float) Math.toDegrees(Math.atan2(y, x));
		phi = (float) Math.toDegrees(Math.acos(z/r));
		return new float[]{r, theta, phi};
	}

}
