public class ConjecturaDeGoldbach {
    public static void main(String[] args) {
        // número P par (4 <= P <= 2147483647)
        int p = 300;
        boolean encontrou = false;

        for (int pri = 2; pri <= p / 2; pri++) {
            if (!isPrimo(pri)) continue;
            for (int seg = pri; seg <= p; seg++) {
                if (!isPrimo(seg)) continue;
                if (pri + seg == p) {
                    System.out.printf("Primeiro %d, Segundo %d%n", pri, seg);
                    encontrou = true;
                }
            }
        }
        
        if (!encontrou) {
            System.out.println(-1);
        }
    }

    private static boolean isPrimo(int n) {
        if (n <= 1) return false;
        for (int cont = 2; cont <= Math.sqrt(n); cont++) {
            if (n % cont == 0) {
                return false;
            }
        }
        return true;
    }
}
