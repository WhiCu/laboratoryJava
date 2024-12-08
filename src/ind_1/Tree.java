package ind_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tree<T> {
    private ArrayList<Node> vertices;

    protected Tree(int size) {
        System.out.println("Tree!");
        vertices = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            vertices.add(new Node(i));
        }
    }

    public int[][] adjacencyMatrix() {
        int[][] matrix = new int[vertices.size()][vertices.size()];
        for (int[] ints : matrix) {
            Arrays.fill(ints, 0);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (Node node : vertices.get(i).adjacentVertices) {
                matrix[i][node.id] = vertices.get(i).countVertex(node);
            }
        }
        return matrix;
    }

    public void addEdge(int indexA, int indexB) {
        if (indexA == indexB) {
            vertices.get(indexA).addVertex(vertices.get(indexB));
            return;
        }
        vertices.get(indexA).addVertex(vertices.get(indexB));
        vertices.get(indexB).addVertex(vertices.get(indexA));
    }

    public void removeEdge(int indexA, int indexB) {
        if (indexA == indexB) {
            vertices.get(indexA).removeVertex(vertices.get(indexB));
            return;
        }
        vertices.get(indexA).removeVertex(vertices.get(indexB));
        vertices.get(indexB).removeVertex(vertices.get(indexA));
    }

    public void addAllEdge(int indexA) {
        Node vertex = vertices.get(indexA);
        for (Node node : vertices) {
            if (vertex.equals(node))
                continue;
            vertex.addVertex(node);
            node.addVertex(vertex);
        }
    }

    public void removeAllEdge(int indexA) {
        Node vertex = vertices.get(indexA);
        for (Node node : vertices) {
            if (vertex.equals(node))
                continue;
            vertex.removeVertex(node);
            node.removeVertex(vertex);
        }
    }

    public void swapVertex(int indexA, int indexB) {
        if (indexA == indexB) {
            return;
        }
        Node A = vertices.get(indexA);
        Node B = vertices.get(indexB);
        int id = A.id;
        vertices.set(indexB, A);
        A.id = B.id;
        vertices.set(indexA, B);
        B.id = id;

    }
    public void addVertex() {
        vertices.add(new Node(vertices.size()));
    }
    // Узлы(хоть и правильно вершины) дерева
    protected class Node {
        private T value;
        private int id;
        private ArrayList<Node> adjacentVertices;

        public Node(int id) {
            this.id = id;
            adjacentVertices = new ArrayList<>();
        }

        public Node(int id, T value) {
            this.value = value;
            adjacentVertices = new ArrayList<>();
        }

        private Node addVertex(Node vertex) {
            adjacentVertices.add(vertex);
            return vertex;
        }
        private int countVertex(Node vertex) {
            int count = 0;
            for(Node node: adjacentVertices)
                if(vertex.equals(node))
                    count++;
            return count;

        }

        private Node removeVertex(Node vertex) {
            if (!adjacentVertices.contains(vertex)) {
                return null;
            }
            adjacentVertices.remove(vertex);
            return vertex;
        }

    }
}
