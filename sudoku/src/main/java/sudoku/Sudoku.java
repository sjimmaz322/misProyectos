package sudoku;

/*
 * @author Mapacherben
 */
public class Sudoku {

    //Como la dimensión de un sudoku es siempre la misma, declaramos al atribute de clase como final.
    private static final int TAMANIO = 9;

    public static void main(String[] args) {

        //Creamos el tablero de sudoku, una matriz de 9 por 9.

        int[][] tablero = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        imprimirSudoku(tablero);

        if (resolverSudoku(tablero)) {
            System.out.println("\nEl Sudoku ha sido resuelto\n");
        } else {
            System.out.println("\nEl sudoku no puede resolverse\n");
        }

        imprimirSudoku(tablero);
    }

    private static boolean numEnFila(int[][] tablero, int fila, int numero) {//Método para buscar el número en una fila.

        for (int i = 0; i < TAMANIO; i++) {
            if (tablero[fila][i] == numero) {
                return true;
            }
        }
        return false;
    }

    private static boolean numEnColumna(int[][] tablero, int columna, int numero) {//Método para buscar el número en una columna.

        for (int i = 0; i < TAMANIO; i++) {
            if (tablero[i][columna] == numero) {
                return true;
            }
        }
        return false;
    }

    private static boolean numEnCelda(int[][] tablero, int fila, int columna, int numero) { //Método para buscar el número en una celda de 3 por 3.

        int filaCelda = fila - fila % 3;
        int columnaCelda = columna - columna % 3;

        for (int i = filaCelda; i < filaCelda + 3; i++) {
            for (int j = columnaCelda; j < columnaCelda + 3; j++) {
                if (tablero[i][j] == numero) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean sitioCorrecto(int[][] tablero, int fila, int columna, int numero) {//Método para hacer los 3 métodos anteriores en uno.

        return !numEnFila(tablero, fila, numero) && !numEnColumna(tablero, columna, numero) && !numEnCelda(tablero, fila, columna, numero);
    }

    private static boolean resolverSudoku(int[][] tablero) {
        for (int fila = 0; fila < TAMANIO; fila++) {
            for (int columna = 0; columna < TAMANIO; columna++) {
                if (tablero[fila][columna] == 0) {
                    for (int numeroProbar = 1; numeroProbar <= TAMANIO; numeroProbar++) {
                        if (sitioCorrecto(tablero, fila, columna, numeroProbar)) {
                            tablero[fila][columna] = numeroProbar;//Si el número puede ir en la posición lo pone.

                            if (resolverSudoku(tablero)) {//El método se llama a si mismo para probar el siguiente número
                                return true;
                            } else {
                                tablero[fila][columna] = 0;//Si los números probados no pueden ir, vacía la posición.
                            }
                        }
                    }
                    return false;
                }
            }

        }
        return true;
    }

    private static void imprimirSudoku(int[][] tablero) {//Método para imprimir el Sudoku
        for (int fila = 0; fila < TAMANIO; fila++) {
            if (fila % 3 == 0) {
                System.out.println("---------------");//Méramente artístico
            }
            for (int columna = 0; columna < TAMANIO; columna++) {
                if (columna % 3 == 0 && columna != 0) {
                    System.out.print(" | ");//Méramente artístico
                }
                System.out.print(tablero[fila][columna]);
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

}
