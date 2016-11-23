package math2;

public class Conversions {
	public static final double METERS_2_FEET = 3.2808;
	public static final double FEET_2_METERS = 1.0/3.2808; 
	
	public static double feet2meters(double feet){
		return feet * FEET_2_METERS;
	}

}
