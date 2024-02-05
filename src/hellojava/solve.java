package hellojava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class solve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node nodeA = new Node("A");
		 Node nodeB = new Node("B");
		 Node nodeC = new Node("C");
		 Node nodeD = new Node("D");
		 Node nodeE = new Node("E");
		 Node nodeF = new Node("F");
		 
		 nodeA.addConnection(nodeB, 10);
		 nodeA.addConnection(nodeC, 15);
		 
		 nodeB.addConnection(nodeD, 12);
		 nodeB.addConnection(nodeF, 15);
		 
		 nodeC.addConnection(nodeE, 10);
		 
		 nodeD.addConnection(nodeE, 2);
		 nodeD.addConnection(nodeF, 1);
		 
		 nodeF.addConnection(nodeE, 5);
		 
		 Graph graph = new Graph();
		 graph.addNode(nodeA);
		 graph.addNode(nodeB);
		 graph.addNode(nodeC);
		 graph.addNode(nodeD);
		 graph.addNode(nodeE);
		 graph.addNode(nodeF);
	}
	class Node{
		private String name;
		private int shortestDistance;
		private HashMap<Node,Integer> connection;
		public HashMap<Node, Integer> getConnection() {
			return connection;
		}

		public void setConnection(HashMap<Node, Integer> connection) {
			this.connection = connection;
		}

		private List<Node>ShortestPath;
		
		public Node(String name) {
			this.name = name;
			this.connection=new HashMap<>();
			this.shortestDistance=Integer.MAX_VALUE;
			this.ShortestPath=new ArrayList<>();
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public int getShortestDistance() {
			return shortestDistance;
		}

		public void setShortestDistance(int shortestDistance) {
			this.shortestDistance = shortestDistance;
		}

		public void addConnection(Node node,int distance) {
			this.connection.put(node,distance);
		}
		
	}
	class Graph{
		
	Set<Node> nodes;

	public Graph() {
		this.nodes = new HashSet<>();
	}
	public void addNode(Node node) {
		this.nodes.add(node);
	}	
	
	
	public Set<Node> getNodes(){
		return nodes;
	}
	
	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}
	
	}
class DjikstraAlgorithm{
	public static Graph calculateShortestPath(
	Graph graph,Node source		){
		source.setShortestDistance(0);
		Queue<Node> unsettledNodes=new PriorityQueue<>(
				Comparator.comparingInt(n-> n.getShortestDistance));
		unsettledNodes.add(source);
		Set<Node> settleNodes=new HashSet<>();
		
		while(!unsettledNodes.isEmpty()) {
			Node currNode=unsettledNodes.poll();
			for(Entry<Node, Integer> entry :currNode.getConnection().entrySet());
			   Node adjNode=entry.getKey();
			   int distance=entry.getValue();
			   
			   if(!settleNodes.contains(adjNode)) {
				   unsettledNodes.add(adjNode);
			   }
		
		}
		//settledNodes.add(currNode);
	}
	
}
	
	
	
	
	
	
	}


