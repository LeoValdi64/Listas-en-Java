public class Celda {
    private Lista ListaRow;
    private Lista ListaCol;

    class Node {
        String data;
        Node up;
        Node down;
        Node left;
        Node right;
        int row;
        String col;
    }

    private Node row, col;

    Celda(String[][] matriz) {
        ListaRow = sacarFilas(matriz);
        ListaCol = sacarCalumnas(matriz);
        row = new Node();
        col = new Node();
        System.out.println("Columnas: " + ListaCol);
        System.out.println("Filas: " + ListaRow);
    }

    private static Lista sacarFilas(String[][] matriz) {
        Lista filas = new Lista();
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].equals("")) {
                    cont++;
                }

            }
            if (!(cont >= matriz[i].length)) {
                filas.addBack(Integer.toString(i + 1), null);
            }
            cont = 0;
        }
        return filas;
    }

    public static Lista sacarCalumnas(String[][] matriz) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Lista cols = new Lista();
        int cont = 0;
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[i][j].equals("")) {
                    cont++;
                }
            }
            if (!(cont >= matriz[j].length)) {
                cols.addBack(String.valueOf(letras.charAt(j)), null);
            }
            cont = 0;
        }
        return cols;
    }

}