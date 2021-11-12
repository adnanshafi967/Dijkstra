
import java.util.*;

public class Dijkstra {
    int [][] graph; // contains the graph
    int [] d; // contains the distance
    int [] p; // contains the parent

    // this array checks which vertices are done worked with
    int [] check;


    // constructor
    public Dijkstra (int [][] graph){
        this.graph = graph;
        // TO DO
        // create the arrays d, p and check
  d = new int[graph.length];
  p = new int[graph.length];
  check = new int[graph.length];
    }

    // runPrim() is the method where you apply Prim's algorithm
    public void runDjikstra(){
     // for each vertex assing a large value as inifinity
     // assign -1 as null
        for(int i = 0;i<graph.length;i++){
          d[i] = 5000;
          p[i] = -1;
        }
        // picking 0 as source
        d[0] = 0;

        // TO DO
        // run a loop for all vertices
        for(int i=0; i<graph.length; i++){
           // TO DO
           // extract the unchecked vertex with minimum d 
           // use the minVertex() method written below
     int u = minVertex();
            for(int v=0;v<graph.length;v++){
            // check for connections
                if(graph[u][v]!=0){
                // TO DO
                // check if v in the array -> use the check array
                    if(check[v] != -1){
                    // TO DO
                    // if d[v] > d[u] + w(u,v)then d[v] = d[u] + w(u,v) and p[v] = u
                        if(d[u] + graph[u][v] < d[v]){
       d[v] = d[u] + graph[u][v];
       p[v] = u;
                        }
                    }
                }
            }
        }
    }
  
    // picks the UNCHECKED vertex with minimum d
    // before returning the value check the vertex
    public int minVertex(){
        int vertex = -1; 
        // check for unchecked vertex
        for(int i = 0;i<graph.length;i++){
            if (check[i]!=-1){
                // -1 denotes checked
                vertex = i;
                break;
            }
        }
        // finding the vertex with min d 
        int minVal = d[vertex];
        //int minVertex = d;
        if (vertex!=-1){
            for(int i = vertex+1;i<graph.length;i++){
                if(check[i]!=-1 && d[i]<minVal){
                    minVal = d[i];
                    vertex = i;
                }
            }
        }
        // check the vertex
        check[vertex] = -1;
        return vertex;
    }
 public void print(){
  for (int i=0; i<graph.length; i++){
   System.out.println(i + " " + d[i]);
  }
 }
 public void printPath() {
    for (int i=0 ; i <graph.length; i++) {
     String pathStr= "" ;
     int j=i;
       while(j!= -1) {
     pathStr= " "+ j + pathStr;
     j=p[j];
    }
    System.out.println(pathStr);
    }
 }
}
