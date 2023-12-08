
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

        if (celda.data == null) { // En el caso que sea la primera celda
            celda = temp;
            return;
        }
        Node ejeX = celda;

        while (ejeX != null) {
            if (ejeX.row == row && ejeX.col == col) {// En el caso que ya exista una celda en esa posicion
                ejeX.data = data;
                return;
            }

            if (ejeX.col > col) {// En el caso que la columna deba ir al principio
                temp.next = ejeX;
                ejeX.previous = temp;
                celda = temp;
                return;
            }

            if (ejeX.next == null) {// En el caso que sea la ultima columna
                ejeX.next = temp;
                temp.previous = ejeX;
                return;
            }

            if (ejeX.next != null) {
                if (ejeX.col < col && ejeX.next.col > col) {// En el caso que la columna deba ir
                                                              // en medio
                    if (row < ejeX.row) {// En el caso que la fila deba ir al principio
                        ejeX.up = temp;
                        temp.down = ejeX;
                        
                        return;
                    }
                    ejeX.next.previous = temp;
                    temp.next = ejeX.next;
                    ejeX.next = temp;
                    temp.previous = ejeX;
                    return;

                }
            }
            ejeX = ejeX.next;
        }

    }

    @Override
    public String toString() {
        Node temp = celda;
        String d = "";
        while (temp != null) {
            Node temp2 = temp;
            d += ("(");
            while (temp2 != null) {
                d += (temp2.data);
                temp2 = temp2.down;
                if (temp2 != null) {
                    d += (", ");
                }
            }
            d += (")");
            temp = temp.next;
            if (temp != null) {
                d += (", ");
            }
        }
        return d;
    }

}