import java.io.PrintWriter;
import java.util.Vector;


   
// The test harness will belong to the following package; the quadtree
// implementation must belong to it as well.  In addition, the quadtree
// implementation must specify package access for the node types and tree
// members so that the test harness may have access to it.
//

public class prQuadTree< T extends Compare2D<? super T> > {
   
   // You must use a hierarchy of node types with an abstract base
   // class.  You may use different names for the node types if
   // you like (change displayHelper() accordingly).
   abstract class prQuadNode { }

   class prQuadLeaf extends prQuadNode {
      Vector<T> Elements;
      
      public prQuadLeaf() { 
    	  Elements = new Vector<T>(BUCKET_SIZE);	//initialization of a leaf node
      }
   }

   class prQuadInternal extends prQuadNode {
      prQuadNode NW, NE, SE, SW;
      
      public prQuadInternal() {			
    	  
      }
   }
   public static final int BUCKET_SIZE = 4; 
   prQuadNode root;
   long xMin, xMax, yMin, yMax;
   
   // Initialize quadtree to empty state, representing the specified region.
   public prQuadTree(long xMin, long xMax, long yMin, long yMax) {
	   this.xMin = xMin;
	   this.xMax = xMax;
	   this.yMin = yMin;
	   this.yMax = yMax;
	   root = null;
   }
    
   // Pre:   elem != null
   // Post:  If elem lies within the tree's region, and elem is not already 
   //        present in the tree, elem has been inserted into the tree.
   // Return true iff elem is inserted into the tree. 
   public boolean insert(T elem) {
	   if(elem == null)
		   return false;
	   if(!elem.inBox(xMin, xMax, yMin, yMax))
		   return false; //error
	   else {
//		   try{//for duplicate exception when inserting
//			   root = insert_helper(elem, root, xMin, xMax, yMin, yMax);
//		   } catch(IllegalArgumentException e) {
//			   return false;
//		   }
		   root = insert_helper(elem, root, xMin, xMax, yMin, yMax);
		   return true;
	   }
   }
   private prQuadNode insert_helper(T elem, prQuadNode t, double xLo, double xHi, double yLo, double yHi) {
	   //t is null:
	   if(t == null) {
		   prQuadLeaf p = new prQuadLeaf();
		   p.Elements.addElement(elem);
		   return p;
	   }
	   //t is leaf and it is not null:
	   	if(t.getClass().equals(prQuadLeaf.class)) {
		   prQuadLeaf p = (prQuadLeaf) t;
		   T current = null;
		   //p = null;
		   //check for duplicate element:(is allowed)
		   int i;
		   for (i = 0; i < p.Elements.size(); i++) {
			   current = p.Elements.get(i);
			   if(current.equals(elem)) {
				   //throw new IllegalArgumentException(); //throw exception when duplicated
				   p.Elements.get(i).getO().addAll(elem.getO());
				   return p;
			   }
		   }
		   //bucket is not full:
		   if(p.Elements.size() < BUCKET_SIZE) {
			   p.Elements.addElement(elem);
			   return p;
		   }
		   //bucket is full:
	       Vector<T> buffer = new Vector<T>();
	       buffer.addAll(p.Elements);
	       p = null;
		   prQuadInternal q = new prQuadInternal();
		   for(i = 0; i < buffer.size(); i++)
			   insert_helper(buffer.get(i), q, xLo, xHi, yLo, yHi);
		   insert_helper(elem, q, xLo, xHi, yLo, yHi);
		   return q;
	   }
	 //insert elem to new quadrant: (t is an internal node:)
	   else {
		   prQuadInternal q = (prQuadInternal) t;
		   Direction Delem = elem.inQuadrant(xLo, xHi, yLo, yHi);
		   switch (Delem) {
		   case NW:
			   q.NW = insert_helper(elem, q.NW, xLo, (xLo + xHi)/2, (yLo + yHi)/2, yHi);
			   break;
		   case SW:
			   q.SW = insert_helper(elem, q.SW, xLo, (xLo + xHi)/2, yLo, (yLo + yHi)/2);
			   break;
		   case SE:
			   q.SE = insert_helper(elem, q.SE, (xLo + xHi)/2, xHi,  yLo, (yLo + yHi)/2);
			   break;
		   case NE:
			   q.NE = insert_helper(elem, q.NE, (xLo + xHi)/2, xHi, (yLo + yHi)/2, yHi); 
			   break;
		   }
		   return q;
	   }	
   }

    
   // Pre:  elem != null
   // Post: If elem lies in the tree's region, and a matching element occurs
   //       in the tree, then that element has been removed.
   // Returns true iff a matching element has been removed from the tree.
   public boolean delete(T Elem) {
	   if(Elem == null)		//null parameter
		   return false;
	   if(!Elem.inBox(xMin, xMax, yMin, yMax))	//not in world
		   return false;
	   else {				//leaf or inner node
		   try {
			   root = delete_helper(Elem, root, xMin, xMax, yMin, yMax);
		   } catch(IllegalArgumentException e) {
			   return false;
		   }
		   return true;
	   }
   }
   private prQuadNode delete_helper(T Elem, prQuadNode t, double xLo, double xHi, double yLo, double yHi) {
	   if(t == null)	//empty node
		   throw new IllegalArgumentException();	//throw the exception of either empty tree or item not found
	   if(t.getClass().equals(prQuadLeaf.class)) {	//leaf node, not empty
		   prQuadLeaf p = (prQuadLeaf) t;
		   T current = p.Elements.firstElement();
		   if(!current.equals(Elem))
			   throw new IllegalArgumentException();//throw the exception of unequal item
		   else { //! remove right? for further check
			   current = null;
			   return null;
		   }
	   }
	   else {	//internal node
		   prQuadInternal q = (prQuadInternal) t;
		   Direction Delem = Elem.inQuadrant(xLo, xHi, yLo, yHi);
		   switch(Delem) { //determine in which sub-quadrant (SQ) element to delete falls
		   case NW:
			   q.NW = delete_helper(Elem, q.NW, xLo, (xLo + xHi)/2, (yLo + yHi)/2, yHi);
			   break;
		   case SW:
			   q.SW = delete_helper(Elem, q.SW, xLo, (xLo + xHi)/2, yLo, (yLo + yHi)/2);
			   break;
		   case SE:
			   q.SE = delete_helper(Elem, q.SE, (xLo + xHi)/2, xHi,  yLo, (yLo + yHi)/2);
			   break;
		   case NE:
			   q.NE = delete_helper(Elem, q.NE, (xLo + xHi)/2, xHi, (yLo + yHi)/2, yHi);
			   break;
		   }
		   prQuadNode ref_to_child = null;
		   int count = 0;
		   if(q.NW != null) {
			   count++;
			   ref_to_child = q.NW;
		   }
		   if(q.SW != null) {
			   count++;
			   ref_to_child = q.SW;
		   }
		   if(q.SE != null) {
			   count++;
			   ref_to_child = q.SE;
		   }
		   if(q.NE != null) {
			   count++;
			   ref_to_child = q.NE;
		   }
		   if(count == 1 && ref_to_child.getClass().equals(prQuadLeaf.class))
			   return ref_to_child;
		   else
			   return q;
	   }
   }

   // Pre:  elem != null
   // Returns reference to an element x within the tree such that 
   // elem.equals(x)is true, provided such a matching element occurs within
   // the tree; returns null otherwise.
   public T find(T Elem) {
	   if(Elem == null)
		   return null;
	   if(!Elem.inBox(xMin, xMax, yMin, yMax))
		   return null;
	   //Vector<T> result = new Vector();
	   return find_helper(Elem, root, xMin, xMax, yMin, yMax);
   }
   private T find_helper(T Elem, prQuadNode t, double xLo, double xHi, double yLo, double yHi) {
	   //t is null:
	   if(t == null)
		   return null;
	   //t is a leaf and it is not null:
	   if(t.getClass().equals(prQuadLeaf.class)){
		   prQuadLeaf p = (prQuadLeaf) t;
//		   T x = p.Elements.firstElement();
//		   T x = null;
		   for(int i = 0; i < p.Elements.size(); i++) {
			   if(Elem.equals(p.Elements.get(i))) {
				   //result.addElement(p.Elements.get(i));
				   //return result;
				   return p.Elements.get(i);
			   }
		   }
		   //no matches:
		   return null;
//		   if(Elem.equals(x))
//			   return x;
	   }
	   //t is an internal node:
	   else{
		   prQuadInternal q = (prQuadInternal) t;
		   Direction d = Elem.inQuadrant(xLo, xHi, yLo, yHi);
		   switch (d) {
		   case NW:
			   return find_helper(Elem, q.NW, xLo, (xLo + xHi)/2, (yLo + yHi)/2, yHi);
		   case SW:
			   return find_helper(Elem, q.SW, xLo, (xLo + xHi)/2, yLo, (yLo + yHi)/2);
		   case SE:
			   return find_helper(Elem, q.SE, (xLo + xHi)/2, xHi,  yLo, (yLo + yHi)/2);
		   case NE:
			   return find_helper(Elem, q.NE, (xLo + xHi)/2, xHi, (yLo + yHi)/2, yHi); 
		   }
	   }
	   return null;
   }
 
   // Pre:  xLo, xHi, yLo and yHi define a rectangular region
   // Returns a collection of (references to) all elements x such that x is 
   //in the tree and x lies at coordinates within the defined rectangular 
   // region, including the boundary of the region.
   public Vector<T> find(long xLo, long xHi, long yLo, long yHi) {
	   if(xHi <= xLo || yHi <= yLo )
		   return null;		//not a rectangular
	   if(xHi < xMin || xLo > xMax || yHi < yMin || yLo > yMax)
		   return null;		//no intersection
	   else {				//have intersection
		   Vector<T> elem = new Vector();
		   find_helper(root, elem, xMin, xMax, yMin, yMax);
		   Vector<T> result = new Vector();
		   for(int i = 0; i < elem.size(); i++) {
			   long x = elem.elementAt(i).getX();
			   long y = elem.elementAt(i).getY();
			   if(x >= xLo && x <= xHi && y >= yLo && y <= yHi)
				   result.addElement(elem.elementAt(i));
		   }
		   return result;
	   }
   }
   private void find_helper(prQuadNode t, Vector<T> elem,long xLo, long xHi, long yLo, long yHi) {
	   if(t == null)
		   ;
	   else if(t.getClass().equals(prQuadLeaf.class)) {
		   prQuadLeaf p = (prQuadLeaf) t;
		   elem.addAll(p.Elements);
	   }
	   else {
		   prQuadInternal q = (prQuadInternal) t;
		   find_helper(q.NW, elem, xLo, (xLo + xHi)/2, (yLo + yHi)/2, yHi);
		   find_helper(q.SW, elem, xLo, (xLo + xHi)/2, yLo, (yLo + yHi)/2);
		   find_helper(q.SE, elem, (xLo + xHi)/2, xHi,  yLo, (yLo + yHi)/2);
		   find_helper(q.NE, elem, (xLo + xHi)/2, xHi, (yLo + yHi)/2, yHi);
	   }
	   
   }
   
   public void printTree(PrintWriter log) {
	   String Padding = "";
	   log.println();
	   printTreeHelper(root, log, Padding);
   }
   private void printTreeHelper(prQuadNode sRoot, PrintWriter log, String Padding) {
	   // Check for empty leaf
	   if ( sRoot == null ) {
		   log.println(Padding + "*");
		   return;
	   }
	   // Check for and process SW and SE subtrees
	   if ( sRoot.getClass().equals(prQuadInternal.class) ) {
		   prQuadInternal p = (prQuadInternal) sRoot;
		   printTreeHelper(p.SW, log, Padding + " ");
		   printTreeHelper(p.SE, log, Padding + " ");
	   }
	   // Display indentation padding for current node
	   log.println(Padding);
	   // Determine if at leaf or internal and display accordingly
	   if ( sRoot.getClass().equals(prQuadLeaf.class) ) {
		   prQuadLeaf p = (prQuadLeaf) sRoot;
		   String list = "";
		   for(int i = 0; i < p.Elements.size(); i++)
			   list = list + p.Elements.get(i).toString();
		   log.println( Padding + list );
	   }
	   else
		   log.println( Padding + "@" );

	   // Check for and process NE and NW subtrees
	   if ( sRoot.getClass().equals(prQuadInternal.class) ) {
		   prQuadInternal p = (prQuadInternal) sRoot;
		   printTreeHelper(p.NE, log, Padding + " ");
		   printTreeHelper(p.NW, log, Padding + " ");
	   }
   }
}