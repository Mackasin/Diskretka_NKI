package com.nki.dzhurynskyi.homework.pr1;

import java.util.Scanner;

public class graf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vertex:");
        int vertex = sc.nextInt();
        System.out.println("Edges:");
        int edges = sc.nextInt();
        int s, k, l = 1;

        int[][] adMatrix = new int[vertex][edges];
        int[][] inMatrix = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < edges; j++) {
                adMatrix[i][j] = 0;
            }
        }
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                inMatrix[i][j] = 0;
            }
        }
        System.out.println("Please write data:");
        for (int i = 0; i < edges; i++) {
            System.out.println("E" + (l++) + ":");
            s = sc.nextInt();
            k = sc.nextInt();
            adMatrix[s - 1][i] = 1;
            adMatrix[k - 1][i] = 1;
            inMatrix[s - 1][k - 1] = 1;
            inMatrix[k - 1][s - 1] = 1;
        }
        System.out.println("Incidence matrix:");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < edges; j++) {
                System.out.print(adMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("Adjacency matrix:");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(inMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}