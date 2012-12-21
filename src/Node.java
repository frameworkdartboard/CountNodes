import java.util.ArrayList;
import java.util.Iterator;

public class Node {
		public int key;
		ArrayList<Node> neighbors;
		
		public Node(int newKey) {
			key = newKey;
			neighbors = new ArrayList<Node>();
		}
		
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("key: "+key+" , neighbors: ");
			Iterator<Node> ir = neighbors.iterator();
			while (ir.hasNext()) {
				sb.append(ir.next().key).append(" ");
			}
			return sb.toString();
		}
}
