import java.util.*;

public class Graph{

	private int V;
	private int E;
	LinkedList<Integer>[] adj;

	public Graph(int nodes){

		this.V = nodes;
		this.E = 0;
		this.adj = new LinkedList[nodes];
		for( int v = 0; v < V; v++){
			adj[v] = new LinkedList<Integer>();
		}
	}

	public void addEdge( int u, int v ){

		this.adj[u].add(v);
		this.adj[v].add(u);
		E++;
	}

	public String toString(){

		StringBuilder sb = new StringBuilder();

		sb.append( V + " veritces, " + E + " edges\n");
		for( int v = 0; v < V; v++){

			sb.append(v + " : ");
			for( int w: adj[v] ){
				sb.append( w + " " );
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public void bfs( int s ){
		//To keep track of visited Nodes
		boolean visited[] = new boolean[V];

		//Help us to travel through graph level by level
		Queue<Integer> q = new LinkedList<>();

		visited[s] = true;
		q.offer(s);

		while(!q.isEmpty()){

			int u = q.poll();
			System.out.print(u + " ");
		
			for( int w: adj[u]){
			
				if(!visited[w]){
					visited[w] = true;
					q.offer(w);
				}
			}
		}
		
	}

	public static void main( String args[] ){

		Graph g = new Graph(5);
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(2, 4);

		System.out.println(g.toString());
		g.bfs(0);
	}
}