import java.util.ArrayList;
import java.util.Iterator;


public class CountNodes {
	public static ArrayList<Node> visitedList = new ArrayList<Node>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
	    Graph g = new Graph();
	    int finalCount = countNodes(g.presentHeadNode());
	    System.out.println("Final node count = "+finalCount);
	}
	
	
	
	private static int countNodes(Node n) {
		int count = 1;
		visitedList.add(n);
		// START DEBUG
		System.out.println("visited "+n.toString());
		// END DEBUG
		Iterator<Node> it = n.neighbors.iterator();
		while (it.hasNext()) {
			Node nextNode = it.next();
			if (visitedList.contains(nextNode))
				continue;
			count += countNodes(nextNode);
		}
		return count;
	}

}
