package lab11;

import java.util.*;
import java.util.Map.Entry;

public class Graph {
    int arr[][];
    //TODO? Collection to map Document to index of vertex
    // You can change it
    ArrayList<String> nodes = new ArrayList<>();
    Map<String, Integer> name2Int = new HashMap<>();
    Map<Integer, String> int2Name = new HashMap<>();
    @SuppressWarnings("unchecked")
    //TODO? Collection to map index of vertex to Document
    // You can change it
    //Entry<String, Document>[] arrDoc=(Map.Entry<String, Document>[])new Map.Entry[0];

    // The argument type depend on a selected collection in the Main class
    public Graph(SortedMap<String,Document> internet){
        int size=internet.size();
        arr=new int[size][size];
        // TODO
        int index = 0;

        for (Map.Entry<String, Document> entry : internet.entrySet()) {
            name2Int.put(entry.getKey(), index);
            int2Name.put(index, entry.getKey());
            index++;
        }

        for (Map.Entry<String, Document> entry : internet.entrySet()) {
            Document document = entry.getValue();

            for (Map.Entry<String, Link> link : document.link.entrySet()) {
                int x = name2Int.get(entry.getKey());
                int y = name2Int.get(link.getKey());
                arr[x][y] = link.getValue().weight;
            }

            nodes.add(entry.getKey());
        }
    }

    public ArrayList<String> findNeighbours(String x)
    {
        int nodeIndex = -1;

        ArrayList<String> neighbours = new ArrayList<>();

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).equals(x)) {
                nodeIndex = i;
                break;
            }
        }

        if (nodeIndex != -1) {
            for (int j = 0; j < arr[nodeIndex].length; j++) {
                if (arr[nodeIndex][j] == 1) {
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }

    public String bfs(String start) {
        // TODO
        if (!name2Int.containsKey(start)) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String element = queue.remove();
            result.append(element).append(", ");
            ArrayList<String> neighbours = findNeighbours(element);

            for (int i = 0; i < neighbours.size(); i++) {
                String n = neighbours.get(i);
                if (n != null && !visited.contains(n)) {
                    queue.add(n);
                    visited.add(n);
                }
            }

        }
        if (result.length() > 0) {
            return result.substring(0, result.length() - 2).trim();
        }
        return null;
    }

    public String dfs(String start) {
        // TODO
        if (!name2Int.containsKey(start)) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        dfs(result, new HashSet<>(), start);
        if (result.length() > 0) {
            return result.substring(0, result.length() - 2).trim();
        }
        return null;
    }

    private void dfs(StringBuilder builder, Set<String> visited, String node) {

        builder.append(node).append(", ");
        ArrayList<String> neighbours = findNeighbours(node);
        visited.add(node);

        for (int i = 0; i < neighbours.size(); i++) {
            String n = neighbours.get(i);
            if (n != null && !visited.contains(n)) {
                dfs(builder, visited, n);
            }
        }
    }

    public int connectedComponents() {
        // TODO
        DisjointSetForest deepForest = new DisjointSetForest(arr.length);
        for (int i = 0; i< arr.length; i++) {
            deepForest.makeSet(i);
        }
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y< arr.length; y++) {
                if (arr[x][y] == 1) {
                    if (deepForest.findSet(x) != deepForest.findSet(y)) {
                        deepForest.union(x, y);
                    }
                }
            }
        }
        return deepForest.countSets();
    }

    public String DijkstraSSSP(String startVertexStr) {
        int size = arr.length;

        if (!name2Int.containsKey(startVertexStr)) {
            return null;
        }

        int startV = name2Int.get(startVertexStr);

        int[] shortest = new int[size];

        boolean[] in = new boolean[size];

        for (int vertexIndex = 0; vertexIndex < size; vertexIndex++) {
            shortest[vertexIndex] = Integer.MAX_VALUE;
            in[vertexIndex] = false;
        }

        shortest[startV] = 0;

        int[] parents = new int[size];

        parents[startV] = -1;

        for (int i = 1; i < size; i++) {
            int nearest = -1;
            int shortestDistance = Integer.MAX_VALUE;

            for (int vertexIndex = 0; vertexIndex < size; vertexIndex++) {
                if (!in[vertexIndex] && shortest[vertexIndex] < shortestDistance) {
                    nearest = vertexIndex;
                    shortestDistance = shortest[vertexIndex];
                }
            }

            if (nearest == -1) {
                continue;
            }

            in[nearest] = true;

            for (int vertexIndex = 0; vertexIndex < size; vertexIndex++) {
                int edgeDist = arr[nearest][vertexIndex];

                if (edgeDist > 0 && ((shortestDistance + edgeDist) < shortest[vertexIndex])) {
                    parents[vertexIndex] = nearest;
                    shortest[vertexIndex] = shortestDistance + edgeDist;
                }
            }
        }

        return result(shortest, parents);
    }

    private String result(int[] distances, int[] parents) {
        int numberVertices = distances.length;
        StringBuilder str = new StringBuilder();

        for (int vertexIndex = 0; vertexIndex < numberVertices; vertexIndex++) {
            int distance = distances[vertexIndex];
            String vertexName = int2Name.get(vertexIndex);

            if (distance == Integer.MAX_VALUE) {
                str.append("no path to ").append(vertexName).append('\n');

            } else {
                printPath(vertexIndex, parents, str);
                str.setLength(str.length() - 2);
                str.append("=").append(distance);
                str.append('\n');
            }
        }
        return str.toString();
    }

    private void printPath(int currentVertex, int[] parents, StringBuilder str) {
        if (currentVertex == -1) {
            return;
        }

        printPath(parents[currentVertex], parents, str);
        str.append(int2Name.get(currentVertex)).append("->");
    }
}