import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Podaj liczbe zestawow (n): ");
        int n = scanner.nextInt();

        int[][] tab = new int[n][18];

        // 1. Tworzenie danych
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 18; j++) {
                tab[i][j] = rand.nextInt(51);  // 0–50
            }
        }

        System.out.println("\nTablica przed sortowaniem:");
        wyswietl(tab);

        // 3. Sortowanie
        bubbleSort2D(tab);

        System.out.println("\nTablica po sortowaniu:");
        wyswietl(tab);

        // 4. Analiza
        analiza(tab);
    }


    // 2. Wyświetlanie tablicy
    public static void wyswietl(int[][] t) {
        for (int[] w : t) {
            for (int x : w) {
                System.out.printf("%3d ", x);
            }
            System.out.println();
        }
    }


    // 3. Bubble Sort dla tablicy 2D
    public static void bubbleSort2D(int[][] t) {

        int rows = t.length;
        int cols = t[0].length;
        int size = rows * cols;

        // spłaszczenie
        int[] flat = new int[size];
        int k = 0;

        for (int[] row : t)
            for (int val : row)
                flat[k++] = val;

        // bubble sort
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (flat[j] > flat[j + 1]) {
                    int tmp = flat[j];
                    flat[j] = flat[j + 1];
                    flat[j + 1] = tmp;
                }
            }
        }

        // powrót do 2D
        k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                t[i][j] = flat[k++];
            }
        }
    }


    // 4. Analiza tablicy
    public static void analiza(int[][] t) {
        int suma = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int liczZer = 0;
        int liczParz = 0;
        int liczNieparz = 0;
        int liczPodziel5 = 0;

        int count = 0;

        for (int[] r : t) {
            for (int x : r) {
                suma += x;
                min = Math.min(min, x);
                max = Math.max(max, x);

                if (x == 0) liczZer++;
                if (x % 2 == 0) liczParz++;
                else liczNieparz++;
                if (x % 5 == 0) liczPodziel5++;

                count++;
            }
        }

        double srednia = (double) suma / count;

        System.out.println("\n--- Analiza tablicy ---");
        System.out.println("Suma: " + suma);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Średnia: " + String.format("%.2f", srednia));
        System.out.println("Liczba zer: " + liczZer);
        System.out.println("Liczba parzystych: " + liczParz);
        System.out.println("Liczba nieparzystych: " + liczNieparz);
        System.out.println("Liczba podzielnych przez 5: " + liczPodziel5);
    }

}
