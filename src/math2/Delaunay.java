package math2;

import java.util.Random;

//import plotter.Line;
//import plotter.SimplePlotter;

public class Delaunay {

//    static SimplePlotter plot = new SimplePlotter("");
//	
//	public static void main(String[] args){
//		Random rand = new Random();
//	    double[][] p = new double[5][2];
//	    plot.setMaxX(1);
//	    plot.setMinX(0);
//	    plot.setMaxY(1);
//	    plot.setMinY(0);
//		for(int i = 0; i<p.length; i++){
//			p[i][0] = rand.nextDouble();
//			p[i][1] = rand.nextDouble();
//			plot.addPoint(p[i][0], p[i][1], java.awt.Color.BLUE);
//		}
//		triangulate(p);
//	}
	
	
	public static void triangulate(double[][] points){
		int l = points.length;
		double cx, cy;	// Circle center
		double rad, rad2;
		boolean flag = false;
		for(int p = 0; p<l; p++){
			for(int rem = 0; rem<l; rem++){
				if(p==rem) continue;
				cx = (points[rem][0] + points[p][0])*0.5;
				cy = (points[rem][1] + points[p][1])*0.5;
				rad = Math.sqrt(Math.pow(points[rem][0]-cx, 2)+Math.pow(points[rem][1]-cy, 2));
				//check if other point in circumference
				flag = true;
				for(int p1 = 0; p1<l; p1++){
					rad2 = Math.sqrt(Math.pow(points[p1][0]-cx, 2)+Math.pow(points[p1][1]-cy, 2));
					if(rad2<rad){ // a point is inside the circle
						flag = false;
					}
				}
				if(flag){
					System.out.println("Line: "+points[p][0]+", "+points[p][1]+" and "+points[rem][0]+", "+points[rem][1]);
//					plot.addLine(new Line(points[p][0], points[p][1], points[rem][0], points[rem][1], java.awt.Color.RED), true);
				}
			}
		}
	}

}
