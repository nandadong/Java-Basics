import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class prQuadTreeTest {

	private prQuadTree<Point> tree;
	
	@Before
	public void setUp() throws Exception 
	{
		tree = new prQuadTree<Point>(-10, 10, -10, 10);
	}
	@Test
	public void testInsert() {
		Point a = new Point(-4, 4, 1);
		assertTrue(tree.insert(a));
		Point b = new Point(-4, 4, 2);
		assertTrue(tree.insert(b));
		Point c = new Point(-4, 4, 3);
		assertTrue(tree.insert(c));
		Point d = new Point(-4, 4, 4);
		assertTrue(tree.insert(d));
		Point e = new Point(-4, 4, 5);
		assertTrue(tree.insert(e));
	}

	

}
