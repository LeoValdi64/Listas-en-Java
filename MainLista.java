public class MainLista{
    public static String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        int matriz[][] = {{10,-1,10},{10,-1,-1},{100,-1,10}};
        Lista filas = sacarFilas(matriz);
        Lista cols = sacarCalumnas(matriz);
        mostrarMatriz(matriz);

        System.out.println("Filas: "+ filas);
        System.out.println("Columnas: "+ cols);
        
        
    }
    public static Lista sacarCalumnas(int[][] matriz){
        Lista cols = new Lista();
        int cont = 0;
        for (int j = 0; j < matriz.length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                if(matriz[i][j]<0){
                    cont++;
                }
            }
            if(!(cont >= matriz[j].length)){
                cols.addBack(String.valueOf(letras.charAt(j)), null);
            }
            cont = 0;
        }
        return cols;
    }
    public static Lista sacarFilas (int[][] matriz){
        Lista filas = new Lista();
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] < 0){
                    cont++;
                }

            }
            if (!(cont >= matriz[i].length) ) {
                filas.addBack(Integer.toString(i), null);     
            }
            cont = 0;
        }
        return filas;
    }

    public static void mostrarMatriz(int[][] matriz) {
    if (matriz.length == 0 || matriz[0].length == 0) {
        System.out.println("La matriz está vacía.");
        return;
    }

    // Determinar el ancho de la columna
    int anchoColumna = 5;

    // Imprimir los encabezados de las columnas
    System.out.print("     "); // Espacio para los números de fila
    for (int i = 0; i < matriz[0].length; i++) {
        System.out.printf("%-" + anchoColumna + "s", columnaAExcel(i + 1));
    }
    System.out.println();

    // Imprimir los datos de la matriz
    for (int fila = 0; fila < matriz.length; fila++) {
        System.out.printf("%4d ", fila + 1); // Números de fila con espaciado
        for (int col = 0; col < matriz[fila].length; col++) {
            System.out.printf("%-" + anchoColumna + "d", matriz[fila][col]);
        }
        System.out.println();
    }
}

    

    public static String columnaAExcel(int columna) {
        StringBuilder res = new StringBuilder();
        while (columna-- > 0) {
            res.insert(0, (char)('A' + columna % 26));
            columna /= 26;
        }
        return res.toString();
    }
    
}