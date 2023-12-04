
public class Celda {
    class Node {
        int row;
        int col;
        String data;
        Node next;
        Node previous;
        Node up;
        Node down;
    }

    private Node celda;

    Celda() {
        celda = new Node();
    }

    public void add(int row, int col, String data) {
        if (celda.data == null) { // En el caso que sea la primera celda
            celda.row = row;
            celda.col = col;
            celda.data = data;
            return;
        }
        Node temp = new Node();
        Node temp2 = celda;
        temp.data = data;
        temp.row = row;
        temp.col = col;

        while (temp2 != null) {
            if (temp2.row == row && temp2.col == col) {// En el caso que ya exista una celda en esa posicion
                temp2.data = data;
                return;
            }

            if (temp2.col > col) {// En el caso que la columna deba ir al principio
                temp.next = temp2;
                temp2.previous = temp;
                celda = temp;
                return;
            }

            if (temp2.next == null) {// En el caso que sea la ultima columna
                temp2.next = temp;
                temp.previous = temp2;
                return;
            }

            if (temp2.next != null) {
                if (temp2.col < col && temp2.next.col > col) {// En el caso que la columna deba ir
                                                              // en medio
                    if (row < temp2.row) {// En el caso que la fila deba ir al principio
                        temp2.up = temp;
                        temp.down = temp2;
                        
                        return;
                    }
                    temp2.next.previous = temp;
                    temp.next = temp2.next;
                    temp2.next = temp;
                    temp.previous = temp2;
                    return;

                }
            }
            temp2 = temp2.next;
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