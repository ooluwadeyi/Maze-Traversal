import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Maze {

	public static void main(String[] args) {

		int intArr[] = { 1, 3, 6, 10, 13, 43, 12, 43 };
		int size = 21;
		boolean visited[] = new boolean[size];

		int graph[][] = new int[size][size];

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {

				if (i == j) {
					graph[i][j] = 0;
				}

				if (i == 0 && (j == 5 || j == 10)) {
					graph[i][j] = 1;
				}

				if (i == 1 && (j == 6 || j == 11 || j == 15)) {
					graph[i][j] = 1;
				}
				if (i == 2 && (j == 7 || j == 12 || j == 15)) {
					graph[i][j] = 1;
				}
				if (i == 3 && (j == 8 || j == 12 || j == 13)) {
					graph[i][j] = 1;
				}
				if (i == 4 && (j == 9 || j == 13 || j == 14)) {
					graph[i][j] = 1;
				}
				if (i == 5 && (j == 0)) {
					graph[i][j] = 1;
				}
				if (i == 6 && j == 1) {
					graph[i][j] = 1;
				}
				if (i == 7 && (j == 2)) {
					graph[i][j] = 1;
				}
				if (i == 8 && j == 3) {
					graph[i][j] = 1;
				}
				if (i == 9 && (j == 4)) {
					graph[i][j] = 1;
				}

				if (i == 10 && (j == 0 || j == 15 || j == 20)) {
					graph[i][j] = 1;
				}
				if (i == 11 && (j == 1)) {
					graph[i][j] = 1;
				}
				if (i == 12 && (j == 2 || j == 3 || j == 17)) {
					graph[i][j] = 1;
				}
				if (i == 13 && (j == 3 || j == 4 || j == 18)) {
					graph[i][j] = 1;
				}
				if (i == 14 && (j == 4 || j == 16 || j == 19)) {
					graph[i][j] = 1;
				}
				if (i == 15 && (j == 1 || j == 2 || j == 10)) {
					graph[i][j] = 1;
				}
				if (i == 16 && j == 14) {
					graph[i][j] = 1;
				}
				if (i == 17 && (j == 12)) {
					graph[i][j] = 1;
				}
				if (i == 18 && j == 13) {
					graph[i][j] = 1;
				}
				if (i == 19 && j == 14) {
					graph[i][j] = 1;
				}
				if (i == 20 && j == 10) {
					graph[i][j] = 1;
				}

			}
		}

		// printGraph(graph);
		//iterativeDFS(0, 16, graph, visited);
		iterativeBFS(0, 16, graph, visited);

	}

	public static void iterativeDFS(int start, int exit, int graph[][], boolean visited[]) {

		/*
		Stack<Integer> stack = new Stack<>();
		
		visited[start] = true;
		System.out.println("Visited  " + start);
		stack.push(start);
		
		int node = start;
		for (int i = 0; i < graph[node].length; i++) {
		
			if (graph[node][i] == 1 && visited[i] == false) {
				stack.push(i);
				visited[i] = true;
				System.out.println("Visited  " + i);
				if (i == exit) {
					System.out.println("Exit reached!");
					break;
				}
				node = i;
				i = 0;
			}
			if (i == graph[node].length - 1) {
				if (!stack.isEmpty()) {
					node = stack.pop();
					i = 0;
				}
			}
		
		}
		
		*/

		Stack<Integer> stack = new Stack<Integer>();

		boolean reached = false;
		visited[start] = true;
		System.out.println("Visited  " + start);
		stack.push(start);

		while (!stack.isEmpty()) {
			if (reached == true) {
				break;
			}

			int node = stack.pop();

			for (int i = 0; i < graph.length; i++) {

				if (graph[node][i] == 1 && visited[i] == false) {

					visited[i] = true;
					System.out.println("Visited  " + i);
					if (i == exit) {
						System.out.println("Exit Reached!");
						reached = true;
					}
					stack.push(node);
					stack.push(i);
					break;
				}
			}

		}

	}

	static void iterativeBFS(int start, int exit, int graph[][], boolean visited[]) {

		Queue<Integer> que = new LinkedList<Integer>();

		visited[start] = true;
		System.out.println("Visited " + start);

		que.add(start);

		while (!que.isEmpty()) {

			int node = que.poll();

			for (int i = 0; i < graph.length; i++) {
				if (graph[node][i] == 1 && visited[i] == false) {

					visited[i] = true;
					System.out.println("Visited  " + i);
					if (i == exit) {
						System.out.println("Exit Reached!");

						break;
					}
					que.add(node);
					que.add(i);
				}

			}
		}

	}

	static void printGraph(int graph[][]) {

		for (int i = 0; i < graph.length; i++) {

			for (int j = 0; j < graph.length; j++) {

				System.out.print(graph[i][j] + "|");
				if (j == graph.length - 1) {
					System.out.println();
				}
			}
		}
	}

}
