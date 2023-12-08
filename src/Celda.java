
public class Celda {
    private class Node {
        int row;
        int col;
        String data;
        Node next;
        Node previous;
        Node up;
        Node down;

        Node(int row, int col, String data) {
            this.row = row;
            this.col = col;
            this.data = data;
            this.next = null;
            this.previous = null;
            this.up = null;
            this.down = null;
        }

    }

    private Node celda;

    Celda() {
        celda = null;
    }

    public void add(int row, int col, String data) {
        Node temp = new Node(row, col, data);

        if (celda == null) { // En el caso que sea la primera celda
            celda = temp;
            return;
        }
        Node ejeX = celda;

        if (ejeX.col > col) { // Si la columna es menor a la primera
            temp.next = ejeX;
            ejeX.previous = temp;
            celda = temp;
            return;
        }

        while (ejeX.col != col) {
            if (ejeX.next == null && col > ejeX.col) {// Si la columna no existe la crea
                ejeX.next = temp;
                temp.previous = ejeX;
                return;
            }
            if (ejeX.col < col && ejeX.next.col > col) { // Si la columna esta en medio y no existe
                temp.next = ejeX.next;
                ejeX.next.previous = temp;
                ejeX.next = temp;
                temp.previous = ejeX;
                return;
            }
            ejeX = ejeX.next;

        }

        Node ejeY = ejeX;
        if (ejeY.row > row) { // Si la fila es menor a la primera
            ejeY.up = temp;
            temp.down = ejeY;
            return;
        }
        while (ejeY.row != row) {

            if (ejeY.down == null && row > ejeY.row) {// Si la fila no existe la crea
                ejeY.down = temp;
                temp.up = ejeY;
                return;
            }

            if (ejeY.row < row && ejeY.down.row > row) { // Si la fila esta en medio y no existe
                temp.down = ejeY.down;
                ejeY.down.up = temp;
                ejeY.down = temp;
                temp.up = ejeY;
                return;
            }
            ejeY = ejeY.down;
        }

        if (ejeX.col == col && ejeY.row == row) { // Si la celda ya existe
            ejeY.data = data;
            return;
        }

    }

    @Override
    public String toString() {
        Node temp = celda;
        String d = "";
        while (temp != null) {
            d += "[ ";
            Node temp2 = temp;
            while (temp2 != null) {
                d += temp2.data;
                temp2 = temp2.down;
                if (temp2 != null) {
                    d += ", ";
                }
            }
            d += " ] ";
            temp = temp.next;
        }
        return d;
    }
    // @Override
    // public String toString() {
    // Node temp = celda;
    // String d = "";
    // while (temp != null) {
    // Node temp2 = temp;
    // d += ("(");
    // while (temp2 != null) {
    // d += (temp2.data);
    // temp2 = temp2.down;
    // if (temp2 != null) {
    // d += (", ");
    // }
    // }
    // d += (")");
    // temp = temp.next;
    // if (temp != null) {
    // d += (", ");
    // }
    // }
    // return d;
    // }

}