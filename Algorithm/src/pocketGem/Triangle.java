package pocketGem;

public class Triangle {
	public static final double EPI = 1e-6; // 1 * 10^(-6)
	//precision
	
		public static double getArea(Point a, Point b, Point c){
		int x1 = b.x - a.x;
		int y1 = b.y - a.y;
		int x2 = c.x - a.x;
		int y2 = c.y - a.y;
		return Math.abs(x1 * y2 - x2 * y1) /2.0 ;
	}
	
	public static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean isInsideTriangle(Point a, Point b, Point c, Point p) {
		double abc = getArea(a, b, c);
		double abcp = getArea(a,b,p) + getArea(a,c,p) + getArea(b,c,p);
		return Math.abs(abc - abcp) < EPI;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 1.0 / 3;
		double b = a * 3;
		System.out.println("a = " +a);
		System.out.println("b = " +b);

	}
}
