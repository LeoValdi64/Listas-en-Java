
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
        Node newNode = new Node(row, col, data);

        // Si la lista está vacía
        if (celda == null) {
            celda = newNode;
            return;
        }

        // Encontrar o insertar la columna correcta
        Node colPointer = celda;
        while (colPointer.col < col && colPointer.next != null) {
            colPointer = colPointer.next;
        }
        if (colPointer.col < col) { // Insertar una nueva columna al final
            colPointer.next = newNode;
            newNode.previous = colPointer;
            colPointer = newNode;
        } else if (colPointer.col > col) { // Insertar una nueva columna antes
            newNode.next = colPointer;
            if (colPointer.previous != null) {
                colPointer.previous.next = newNode;
                newNode.previous = colPointer.previous;
            } else {
                celda = newNode;
            }
            colPointer.previous = newNode;
            colPointer = newNode;
        } else if (colPointer.col == col) {
            // Encontrar o insertar la fila correcta en la columna existente
            Node rowPointer = colPointer;
            while (rowPointer.row < row && rowPointer.down != null) {
                rowPointer = rowPointer.down;
            }
            if (rowPointer.row < row) { // Insertar una nueva fila al final
                rowPointer.down = newNode;
                newNode.up = rowPointer;
            } else if (rowPointer.row > row) { // Insertar una nueva fila antes
                newNode.down = rowPointer;
                newNode.up = rowPointer.up;
                if (rowPointer.up != null) {
                    rowPointer.up.down = newNode;
                } else {
                    // Si es el primer nodo en la columna, actualizar el nodo de la columna
                    if (rowPointer == colPointer) {
                        if (colPointer.previous != null) {
                            colPointer.previous.next = newNode;
                        } else {
                            celda = newNode;
                        }
                        if (colPointer.next != null) {
                            colPointer.next.previous = newNode;
                        }
                        newNode.next = colPointer.next;
                        newNode.previous = colPointer.previous;
                    }
                }
                rowPointer.up = newNode;
            } else { // Actualizar el nodo existente
                rowPointer.data = data;
            }
        }
    }

    public void remove(int row, int col) {
        if (celda == null) {
            return; // La lista está vacía
        }

        // Buscar la columna correcta
        Node colPointer = celda;
        while (colPointer != null && colPointer.col < col) {
            colPointer = colPointer.next;
        }

        if (colPointer == null || colPointer.col != col) {
            return; // No se encontró la columna
        }

        // Buscar la fila correcta en la columna encontrada
        Node rowPointer = colPointer;
        while (rowPointer != null && rowPointer.row < row) {
            rowPointer = rowPointer.down;
        }

        if (rowPointer == null || rowPointer.row != row) {
            return; // No se encontró la fila
        }

        // Desconectar el nodo
        if (rowPointer.up != null) {
            rowPointer.up.down = rowPointer.down;
        } else {
            // Si es el primer nodo en la columna, actualizar el nodo de la columna
            if (colPointer == rowPointer) {
                if (colPointer.previous != null) {
                    colPointer.previous.next = colPointer.next;
                } else {
                    celda = colPointer.next;
                }
                if (colPointer.next != null) {
                    colPointer.next.previous = colPointer.previous;
                }
            }
        }

        if (rowPointer.down != null) {
            rowPointer.down.up = rowPointer.up;
        }

        // Ajustar enlaces horizontales si se elimina el primer nodo de una columna
        if (colPointer == rowPointer) {
            if (rowPointer.down != null) {
                if (rowPointer.previous != null) {
                    rowPointer.previous.next = rowPointer.down;
                    rowPointer.down.previous = rowPointer.previous;
                } else {
                    celda = rowPointer.down;
                    rowPointer.down.previous = null;
                }
            } else {
                if (rowPointer.previous != null) {
                    rowPointer.previous.next = rowPointer.next;
                }
                if (rowPointer.next != null) {
                    rowPointer.next.previous = rowPointer.previous;
                }
            }
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
}