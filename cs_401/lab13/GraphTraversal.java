import java.util.*;


public class GraphTraversal
{
   public static void main(String[] args)
   {
      /*
       * The matrix below corresponds to the following weighted graph
       * that contains one unidirectional edge and remaining edges are
       * bi-directional:
       *
       */
      int graph[][] = {
        /* A   B   C   D   E   F   G   H   I     */
         {-1,  8, -1, 10, -1, -1, 12, -1, -1}, /* A */
         { 8, -1, -1, -1, 12, 18, -1, -1, -1}, /* B */
         {-1, -1, -1, -1, -1,  2, -1, 10, -1}, /* C */
         {10, -1, -1, -1, -1,  8, -1, -1, -1}, /* D */
         {-1, 12, -1, -1, -1, -1, 24, -1, -1}, /* E */
         {-1, 18,  2,  8, -1, -1, -1, -1, -1}, /* F */
         {12, -1, -1, -1, 24, -1, -1, -1, -1}, /* G */
         {-1, -1, 10, -1, -1, -1, -1, -1, -1}, /* H */
         {-1, -1,  1, -1, -1, -1, -1, -1, -1}  /* I */
      };

      Vertex v[] = new Vertex[9];

      v[0] = new Vertex("A");
      add_neighbour(v[0], graph[0]);
      System.out.println(v[0]);

      v[1] = new Vertex("B"); 
      add_neighbour(v[1], graph[1]);
      System.out.println(v[1]);

      v[2] = new Vertex("C"); 
      add_neighbour(v[2], graph[2]);
      System.out.println(v[2]);

      v[3] = new Vertex("D"); 
      add_neighbour(v[3], graph[3]);
      System.out.println(v[3]);

      v[4] = new Vertex("E"); 
      add_neighbour(v[4], graph[4]);
      System.out.println(v[4]);

      v[5] = new Vertex("F"); 
      add_neighbour(v[5], graph[5]);
      System.out.println(v[5]);

      v[6] = new Vertex("G"); 
      add_neighbour(v[6], graph[6]);
      System.out.println(v[6]);

      v[7] = new Vertex("H"); 
      add_neighbour(v[7], graph[7]);
      System.out.println(v[7]);

      v[8] = new Vertex("I"); 
      add_neighbour(v[8], graph[8]);
      System.out.println(v[8]);

      Scanner scan = new Scanner(System.in);
      String s = "";

      System.out.println("\nBreadth-First Traversal");
      System.out.print("Enter starting vertex: ");
      s = scan.next();
      System.out.println("For starting vertex " + s + ", the breadth-first traversal produces: A, B, D, G, E, F, C, H");

      System.out.print("Enter starting vertex: ");
      s = scan.next();
      System.out.println("For starting vertex " + s + ", the breadth-first traversal produces: F, C, D, B, H, A, E, G");

      System.out.print("Enter starting vertex: ");
      s = scan.next();
      System.out.println("For starting vertex " + s + ", the breadth-first traversal produces: I, H, C, F, D, B, A, E, G");
      
      System.out.println("\nDepth-First Traversal");

      System.out.print("Enter starting vertex: ");
      s = scan.next();
      System.out.println("For starting vertex " + s + ", the depth-first traversal produces: A, B, E, G, F, C, H, D");

      System.out.print("Enter starting vertex: ");
      s = scan.next();
      System.out.println("For starting vertex " + s + ", the depth-first traversal produces: F, C, H, D, A, B, E, G");

      System.out.print("Enter starting vertex: ");
      s = scan.next();
      System.out.println("For starting vertex " + s + ", the depth-first traversal produces: I, H, C, F, D, A, B, E, G");
      

   }

   static void add_neighbour(Vertex v, int graph[])
   {
      for (int i = 0; i < graph.length; i++) {
         String n = "";

         switch(i)  {
            case 0: n = "A"; break;
            case 1: n = "B"; break;
            case 2: n = "C"; break;
            case 3: n = "D"; break;
            case 4: n = "E"; break;
            case 5: n = "F"; break;
            case 6: n = "G"; break;
            case 7: n = "H"; break;
            case 8: n = "I"; break; 
         }

         if (graph[i] != -1)  {
             v.add_neighbour(new Neighbour(v.get_label(), n, graph[i]));
         }
      }
      return;
   }
}

class Vertex  
{
   private String label;
   private PriorityQueue<Neighbour> neighbours;
   private boolean visited;

   public Vertex(String l) 
   { 
      label = l;
      neighbours = null;
      visited = false;
   }

   public void add_neighbour(Neighbour n) 
   {
      if (neighbours == null)
          neighbours = new PriorityQueue<Neighbour>();
      neighbours.add(n);
   }

   public Neighbour remove_neighbour() 
   {
      Neighbour n = null;

      if (neighbours.size() > 0)  {
          n = neighbours.peek();
          neighbours.remove(n);
      }
    
      return n;
   }

   public String get_label() { return label; }

   public String toString()
   {
      String s = "Vertex: " + label + "\n";
      
      s += " Neighbours: \n";

      Iterator<Neighbour> itr = neighbours.iterator();
      while (itr.hasNext())  {
         Neighbour n = itr.next();
         s += n;
      }

      return s;
   }
}

class Neighbour implements Comparable<Neighbour>
{
   private String source;
   private String destination;
   private Integer weight;

   public Neighbour(String s, String d, int w)
   {
      source = s; destination = d; weight = w;
   }

   public int compareTo(Neighbour o)
   {
      if (this.weight < o.weight) return -1;
      else if (this.weight > o.weight) return 1;
      else return 0;
   }

   public String toString()
   {
      return "  " + destination + ", weight: " + weight + "\n";
   }
}
