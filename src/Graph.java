import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * An undirected graph with a head node.
 * 
 * @author erickramer413
 *
 */
public class Graph {
	private final static int MIN_NODES = 5;
	private final static int MAX_NODES = 100;
	// when the graph's nodes get iterated through
	// the chance that they get connected will be 1 / RECIP_CONNECT_CHANCE.
	private final static int RECIP_CONNECT_CHANCE = 20;
	
	public Node headNode;
	/**
	 * default argumentless constructor builds a graph with a random number of uniquely
	 * labelled nodes with a random number of edges between each node and a random selection
	 * of other nodes
	 */
	public Graph() {
		Random prng = new Random();
		int numNodes = MIN_NODES + prng.nextInt(MAX_NODES - MIN_NODES);
		// would prefer the rest of the program not to have any way to inspect
		// its nodes except starting from the randomly chosen head node.
		// after this constructor completes the ArrayList tempNodeHolder will
		// be dropped on the floor (and garbage collected).
		ArrayList<Node> tempNodeHolder = new ArrayList<Node>();
		
		for (int ii = 0; ii < numNodes; ii++) {
			tempNodeHolder.add(new Node(ii));
		}
		
		// arbitrarily choose a head node
		headNode = tempNodeHolder.get(prng.nextInt(numNodes));
		
		Iterator<Node> outerIter = tempNodeHolder.iterator();
		
		while (outerIter.hasNext()) {
			Iterator<Node> innerIter = tempNodeHolder.iterator();
			Node curNode = outerIter.next();
			while (innerIter.hasNext()) {
				Node potentialNewNeighbor = innerIter.next();
				if (0 == prng.nextInt(RECIP_CONNECT_CHANCE)) {
					if (!curNode.neighbors.contains(potentialNewNeighbor)) {
						curNode.neighbors.add(potentialNewNeighbor);
						potentialNewNeighbor.neighbors.add(curNode);
					}
				}
			}
		}
	}
	
	public Node presentHeadNode() { return headNode; }
}
