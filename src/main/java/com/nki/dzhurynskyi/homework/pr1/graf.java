package com.nki.dzhurynskyi.homework.pr1;

import java.util.Scanner;

public class graf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vertex:");
        int vertex = sc.nextInt();
        System.out.println("Edges:");
        int edges = sc.nextInt();


        int[][] inMatrix = new int[vertex][edges];
        int[][] adMatrix = new int[vertex][vertex];


        System.out.println("Please write data:");
        fillMatrix(sc, edges, adMatrix, inMatrix);
        System.out.println("Incidence matrix:");
        printMatrix(adMatrix);
        System.out.println("Adjacency matrix:");
        printMatrix(inMatrix);
    }


    private static void fillMatrix(Scanner sc, int edges, int[][] adMatrix, int[][] inMatrix) {
        int s, k, l = 1;
        for (int i = 0; i < edges; i++) {
            System.out.println("E" + (l++) + ":");
            System.out.println("Write weight:");
            int n = sc.nextInt();
            System.out.println("Write vertexes:");
            s = sc.nextInt();
            k = sc.nextInt();
            inMatrix[s - 1][i] = n;
            inMatrix[k - 1][i] = n;
            adMatrix[s - 1][k - 1] = n;
           adMatrix[k - 1][s - 1] = n;
        }
    }

    private static void printMatrix(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }
}