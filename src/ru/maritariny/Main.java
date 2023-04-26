package ru.maritariny;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String WHITE = "white";
    private static String BLACK = "black";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = reader.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int w = Integer.parseInt(reader.readLine());
        List<int[]> white = new ArrayList<>(w);
        for (int i = 0; i < w; i++) {
            String[] field = reader.readLine().split(" ");
            int[] a = new int[] {Integer.parseInt(field[0]), Integer.parseInt(field[1])};
            white.add(a);
        }
        int b = Integer.parseInt(reader.readLine());
        List<int[]> black = new ArrayList<>(w);
        for (int i = 0; i < b; i++) {
            String[] field = reader.readLine().split(" ");
            int[] a = new int[] {Integer.parseInt(field[0]), Integer.parseInt(field[1])};
            black.add(a);
        }
        String move = reader.readLine();
        List<int[]> first, second;
        if (move.equals(WHITE)) {
            first = white;
            second = black;
        } else {
            first = black;
            second = white;
        }
        String result = "No";
        for (int k = 0; k < first.size(); k++) {
            int[] field = first.get(k);

            for (int i = field[0] - 1; i <= field[0] + 1; i++) {
                if (i <= 0 || i > n || i == field[0]) {
                    continue;
                }
                for (int j = field[1] - 1; j <= field[1] + 1; j++) {
                    if (j <= 0 || j > m || j == field[1]) {
                        continue;
                    }
                    int[] enemy = new int[] {i, j};
                    if (!isContain(second, enemy)) {
                        continue;
                    }
                    int x = field[0] - 2 * (field[0] - i);
                    int y = field[1] - 2 * (field[1] - j);
                    if (x <= 0 || x > n || y <= 0 || y > m) {
                        continue;
                    }
                    int[] empty = new int[] {x, y};
                    if (!isContain(white, empty) && !isContain(black, empty)) {
                        result = "Yes";
                        break;
                    }
                }
                if (result == "Yes") {
                    break;
                }
            }
        }
        System.out.println(result);
        reader.close();
    }

    private static boolean isContain(List<int[]> where, int[] what) {
        for (int[] a : where) {
            if (a[0] == what[0] && a[1] == what[1]) {
                return true;
            }
        }
        return false;
    }
}

