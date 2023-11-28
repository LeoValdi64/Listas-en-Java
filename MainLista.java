public class MainLista{
    public static String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        int matriz[][] = {{10,-1,10},{10,-1,-1},{10,-1,10}};
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
    public static void mostrarMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+", ");
            }
            System.out.println();
        }
        
    }
}