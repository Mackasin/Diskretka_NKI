package com.nki.dzhurynskyi.homework.pr2;

import java.lang.*;
import java.util.Scanner;


class Tree {
    static Scanner sc = new Scanner(System.in);
    int vertex;

    public static void main(String[] args) {
        Tree t = new Tree();
        System.out.println("Vertex:");
        t.vertex = sc.nextInt();
        System.out.println("Edges:");
        int edges = sc.nextInt();


        int[][] inMatrix = new int[t.vertex][edges];
        int[][] adMatrix = new int[t.vertex][t.vertex];
        int [][]tree=new int[t.vertex][t.vertex];

        System.out.println("Please write data:");
        fillMatrix(edges, adMatrix, inMatrix);
        System.out.println("Incidence matrix:");
        printMatrix(inMatrix);
        System.out.println("Adjacency matrix:");
        printMatrix(adMatrix);

        System.out.println("MST:");

        t.primMST(adMatrix,tree);
        printMatrix(tree);
    }

    private static void fillMatrix(int edges, int[][] adMatrix, int[][] inMatrix) {
        int s, k, l = 1;
        int weightGraph = 0;
        for (int i = 0; i < edges; i++) {
            System.out.println("E" + (l++) + ":");
            System.out.println("Write weight:");
            int n = sc.nextInt();
            weightGraph+=n;
            System.out.println("Write vertexes:");
            s = sc.nextInt();
            k = sc.nextInt();
            inMatrix[s - 1][i] = n;
            inMatrix[k - 1][i] = n;
            adMatrix[s - 1][k - 1] = n;
            adMatrix[k - 1][s - 1] = n;
        }
        System.out.println("\nWeight graph: "+weightGraph);
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

    void printMST(int[] parent, int[][] graph,int [][]tree) {
        int minWeight = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertex; i++) {
            System.out.println(parent[i] + 1 + " - " + (i + 1) + "\t"
                    + graph[i][parent[i]]);
            minWeight += graph[i][parent[i]];
            tree[ parent[i]][i]=graph[i][parent[i]];
            tree[i][parent[i]]=graph[i][parent[i]];
        }
        System.out.println("Min weight: "+minWeight);
    }

    void primMST(int[][] graph,int[][]tree) {
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
        printMST(parent, graph,tree);
    }

}

