Breadth-First Traversal
Enter starting vertex: A
For starting vertex A, the breadth-first traversal produces: A, B, D, G, E, F, C, H
Enter starting vertex: F
For starting vertex F, the breadth-first traversal produces: F, C, D, B, H, A, E, G
Enter starting vertex: I
For starting vertex I, the breadth-first traversal produces: I, H, C, F, D, B, A, E, G


Depth-First Traversal
Enter starting vertex: A
For starting vertex A, the depth-first traversal produces: A, B, E, G, F, C, H, D
Enter starting vertex: F
For starting vertex A, the depth-first traversal produces: F, C, H, D, A, B, E, G
Enter starting vertex: I
For starting vertex I, the depth-first traversal produces: I, H, C, F, D, A, B, E, G


Graph Generation
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