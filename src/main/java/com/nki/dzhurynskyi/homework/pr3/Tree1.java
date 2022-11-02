package com.nki.dzhurynskyi.homework.pr3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    } }
class Tree1 {
    static Scanner sc = new Scanner(System.in);
    int vertex;

    public static void main(String[] args) {
        Tree1 t = new Tree1();
        System.out.println("Vertex:");
        t.vertex = sc.nextInt();
        System.out.println("Edges:");
        int edges = sc.nextInt();

        int[][] inMatrix = new int[t.vertex][edges];
        int[][] adMatrix = new int[t.vertex][t.vertex];

        System.out.println("Please write data:");
        fillMatrix(edges, adMatrix, inMatrix);
        System.out.println("Incidence matrix:");
        printMatrix(inMatrix);
        System.out.println("Adjacency matrix:");
        printMatrix(adMatrix);

        System.out.println("MST:");

        t.primMST(adMatrix);

    }

    private static void fillMatrix(int edges, int[][] adMatrix, int[][] inMatrix) {
        int s, k, l = 1;
        int weightGraph = 0;
        for (int i = 0; i < edges; i++) {
            System.out.println("E" + (l++) + ":");
            System.out.println("Write weight:");
            int n = sc.nextInt();
            weightGraph += n;
            System.out.println("Write vertexes:");
            s = sc.nextInt();
            k = sc.nextInt();
            inMatrix[s - 1][i] = n;
            inMatrix[k - 1][i] = n;
            adMatrix[s - 1][k - 1] = n;
            adMatrix[k - 1][s - 1] = n;
        }
        System.out.println("\nWeight graph: " + weightGraph);
    }

    private static void printMatrix(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }


    int minKey(int[] key, Boolean[] mstSet) {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < vertex; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    void printMST(Scanner scanners,int[] parent, int[][] graph) {
        int minWeight = 0;
        Graph g=new Graph(vertex+1);
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertex; i++) {
         System.out.println(parent[i] + 1 + " - " + (i + 1) + "\t"+graph[i][parent[i]]);
         g.addEdge(parent[i]+1, i+1);
            minWeight += graph[i][parent[i]];
        }
        System.out.println("Min weight: " + minWeight);
        System.out.println("Which vertex is the root?");
        int v=scanners.nextInt();
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex "+ v+")");
        g.BFS(v);
    }

    void primMST(int[][] graph) {
        int[] parent = new int[vertex];
        int[] key = new int[vertex];

        Boolean[] mstSet = new Boolean[vertex];

        for (int i = 0; i < vertex; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;

        parent[0] = -1;


        for (int count = 0; count < vertex - 1; count++) {

            int u = minKey(key, mstSet);

            mstSet[u] = true;

            for (int v = 0; v < vertex; v++)

                if (graph[u][v] != 0 && !mstSet[v]
                        && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        printMST(sc,parent, graph);
    }

}

