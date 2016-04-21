

//import Compare2D;
//import Direction;
import java.awt.Rectangle;
import java.util.Vector;

public class Point implements Compare2D<Point> {

   private long longitude;
   private long latitude;
   private Vector<Long> offsets;
   //private long offset;
   
   public Point() {
      longitude = 0;
      latitude = 0;
      offsets = null;
   }

   public Point(long x, long y, long offset) {
      longitude = x;
      latitude = y;
      //this.offset = offset;
      offsets = new Vector();
      offsets.add(offset);
      
   }

   public long getX() {
      return longitude;
   }

   public long getY() {
      return latitude;
   }
   
   public Vector<Long> getO() {
	   return offsets;
   }
   
//   public void setO(long offset) {
//	   offsets.add(offset);
//   }
   public Direction directionFrom(long X, long Y) { 
	  long x = longitude - X;
	  long y = latitude - Y;
	  if(x > 0 && y >= 0)
		  return Direction.NE;
	  else if(x <= 0 && y > 0)
		  return Direction.NW;
	  else if(x < 0 && y <= 0)
		  return Direction.SW;
	  else if(x >= 0 && y < 0)
		  return Direction.SE;
	  else
		  return Direction.NOQUADRANT;
   }
   
   public Direction inQuadrant(double xLo, double xHi, 
                               double yLo, double yHi) { 
	  if(longitude > (xLo + xHi)/2 && longitude <= xHi && latitude >= (yLo + yHi)/2 && latitude <= yHi || longitude == (xLo + xHi)/2 && latitude == (yLo + yHi)/2 )
		  return Direction.NE;
	  else if(longitude <= (xLo + xHi)/2 && longitude >= xLo && latitude > (yLo + yHi)/2 && latitude <= yHi)
		  return Direction.NW;
	  else if(longitude < (xLo + xHi)/2 && longitude >= xLo && latitude <= (yLo + yHi)/2 && latitude >= yLo)
		  return Direction.SW;
	  else if(longitude >= (xLo + xHi)/2 && longitude <= xHi && latitude < (yLo + yHi)/2 && latitude >= yLo)
		  return Direction.SE;
	  else
		  return Direction.NOQUADRANT;
   }

   public boolean inBox(double xLo, double xHi, 
                          double yLo, double yHi) { 
	   if(longitude < xLo || longitude > xHi || latitude < yLo || latitude > yHi)
		   return false;
	   else
		   return true;
   }

   public String toString() {
	  String x = "" + longitude;
	  String y = "" + latitude;
	  String off = "" + offsets;
      return "[(" + x +", " + y +")" + ", " + off + "] ";
   }
   
   //a little confused here...
   public boolean equals(Object o) {
	   if(o instanceof Point) {
		   Point temp = (Point) o;
		   long x = ((Compare2D) o).getX();
		   long y = ((Compare2D) o).getY();
		   if(longitude == x && latitude == y)
			   return true;
	   }
	   return false;
   }
}
