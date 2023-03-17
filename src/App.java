
public class App {

    public static boolean isValid(int x, int y, int value, Integer[][] matriz) {

        int rootValue = (int) Math.sqrt(matriz.length);
        int xQuad = (int) x / rootValue;
        int yQuad = (int) y / rootValue;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[x][i] == value || matriz[i][y] == value) {
                return false;
            }

        }
        for (int k = xQuad * rootValue; k < (xQuad + 1) * rootValue; k++) {
            for (int j = yQuad * rootValue; j < (yQuad + 1) * rootValue; j++) {
                if (matriz[k][j] == value) {
                    return false;
                }

            }
        }
        return true;

    }

    public static boolean sudoku(int x, int y, Integer[][] matriz) {
        boolean result=false;

        for (int i = 1; i <= matriz.length; i++) {
            if (isValid(x, y, i, matriz)) {
                matriz[x][y] = i;
                if (y == matriz.length - 1) {
                    if (x == matriz.length - 1) {
                        return true;
                    } else {
                        result = sudoku(x + 1, 0, matriz) ? true : false;

                    }

                } else {
                    result = sudoku(x, y + 1, matriz) ? true : false;

                }
            }
            if (result)
                return true;
        }

        matriz[x][y]=0;
        return false;

    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n;
        do{
            n = in.nextInt();
        }while(Math.sqrt(matriz.length)!=(int))Math.sqrt(matriz.length)
        
        Integer[][] matriz = new Integer[n][n];

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz.length; j++) {

                matriz[i][j] = 0;

            }

        }

        System.out.println(sudoku(0, 1, matriz));

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();

        }

    }

}
