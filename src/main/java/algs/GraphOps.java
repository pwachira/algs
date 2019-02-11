package algs;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphOps{
        interface Graph {
            public LinkedList<Integer>[]  adj();
            public void addEdge(int v, int w);
            
        //Number of vertices    
            public int countV();
        
        //Number of Edges
            public int countE();
            
        }
        
        public class GraphImpl implements Graph{
            
            private LinkedList<Integer>[] adj;
            private int countV;
            private int countE;
            
            public GraphImpl(int v) {
                adj = (LinkedList<Integer>[])new LinkedList[v];
                for(int i = 0; i < adj.length;i++) {
                    adj[i] = new LinkedList<Integer>();
                }
                countV = v;
            }

            @Override
            public void addEdge(int v, int w) {
                adj[v].add(w);
                adj[w].add(v);
                countE++;
                
            }

            @Override
            public int countV() {
                return countV;
            }

            @Override
            public int countE() {
                return countE;
            }

            @Override
            public LinkedList<Integer>[] adj() {
                return adj;
            }

             
        }

        
        public class DFS{
            private boolean[] visited;
            private List<Integer> path;
            private Graph g;
            
            public DFS(Graph graph) {
                g = graph;
            }
            public List<Integer> search(int s) {
                visited = new boolean[g.countV()];
                path = new ArrayList<Integer>();
                executeDFS(g,s);
                // path.stream().forEach(v -> System.out.print(v+","));
                return path;

            }
            
            private void executeDFS(Graph g, int s) {
                visited[s] = true;
                path.add(s);
                List<Integer> adj = g.adj()[s];
                for (int i: adj) {
                    if (!visited[i]) 
                           executeDFS(g,i);
                }
            }
        }
        public class BFS{
            private boolean[] visited;
            private List<Integer> path;
            private Queue<Integer> q ; 
            private Graph g;
            
            public BFS(Graph graph) {
                q = new LinkedList<Integer>();
                path = new ArrayList<Integer>();
                g = graph;
                
                
            }
            public List<Integer> search(int s) {
                visited = new boolean[g.countV()];
                q.add(s);
                executeBFS();
                return path;
              
            }
            
            private void executeBFS() {
                while (!q.isEmpty()) {
                    int popped = q.remove();
                    if (visited[popped]) continue;
                    visited[popped] = true;
                    path.add(popped);
                    List<Integer> adj = g.adj()[popped];
                    adj.stream().forEach(v -> {
                       q.add(v); 
                    });
                    
                }
            }
         
        }        
        public static void main(String...args) {
            GraphOps ops = new GraphOps();
            Graph g = ops.new GraphImpl(7);
            g.addEdge(0,1);
            g.addEdge(0,2);
            g.addEdge(0,5);
            g.addEdge(0,6);
            g.addEdge(5,3);
            g.addEdge(5,4);
            g.addEdge(6,4);
            
            List<Integer> pathDFS = ops.new DFS(g).search(5);
            pathDFS.stream().forEach(v -> System.out.print(v+" "));
            System.out.print("\n");
            assertThat(pathDFS, is(Arrays.asList(5,0,1,2,6,4,3)));
            
            List<Integer> pathBFS = ops.new BFS(g).search(5);
            assertThat(pathBFS, is(Arrays.asList(5,0,3,4,1,2,6)));
            pathBFS.stream().forEach(v -> System.out.print(v+" "));
                       
            
        }
}