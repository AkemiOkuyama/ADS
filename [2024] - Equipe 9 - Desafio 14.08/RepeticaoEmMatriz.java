public class RepeticaoEmMatriz {
    public static void main(String[] args) {
        int a[][] = {
        {1, 2, 3},
        {4, 5, 4},
        {7, 8, 9}
        };
// Uma solução possível
    for (int x = 0; x < 8; x++) {
        for (int y = x + 1; y < 9; y++) {
            if (a[x / 3][x % 3] == a [y / 3][y % 3]) {
            System.out.println("Há elementos repetidos");
            return;
            }
        }
    }
    System.out.println("Não há elementos repetidos");
        }
    }
