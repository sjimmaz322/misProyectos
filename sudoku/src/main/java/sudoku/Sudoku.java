package sudoku;

/*
 * @author Mapacherben
 */
public class Sudoku {

    private static final int tamanio = 9;

    public static void main(String[] args) {

        int[][] tablero = {
            {1, 4, 0, 0, 0, 8, 0, 0, 0},
            {2, 7, 0, 9, 0, 0, 1, 5, 0},
            {0, 5, 3, 1, 0, 7, 9, 0, 8},
            {0, 0, 0, 7, 5, 9, 0, 0, 0},
            {0, 1, 6, 0, 0, 4, 7, 3, 0},
            {8, 0, 0, 3, 0, 6, 0, 4, 2},
            {9, 8, 0, 4, 0, 0, 0, 0, 0},
            {0, 2, 0, 6, 0, 5, 0, 0, 3},
            {0, 0, 4, 0, 7, 1, 2, 9, 5}
        };
    }

    private static boolean numEnFila(int[][] tablero, int fila, int numero) {

        for (int i = 0; i < tamanio; i++) {
            if (tablero[fila][i] == numero) {
                return true;
            }
        }
        return false;
    }

    private static boolean numEnColumna(int[][] tablero, int columna, int numero) {

        for (int i = 0; i < tamanio; i++) {
            if (tablero[i][columna] == numero) {
                return true;
            }
        }
        return false;
    }
    private static boolean numEnCelda(int[][] tablero,int fila, int columna, int numero) {

        int filaCelda = fila - fila%3;
        int columnaCelda = columna - columna%3;
        
        for (int i = filaCelda; i < filaCelda+3; i++) {
            for (int j = columnaCelda; j < columnaCelda+3; j++) {
                if (tablero[i][j] == numero){
                    return true;
                }
            }
        }return false;
    }
}
