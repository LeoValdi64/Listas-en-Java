public class Lista {
    private Node top, back;

    Lista() {
        top = null;
        back = null;
    }

    public boolean exists(String key) {
        // Busqueda bidireccional
        Node alante = top;
        Node atras = back;
        while (alante != null && atras != null && alante != atras && alante.previous != atras) {
            if (alante.key.equals(key) || atras.key.equals(key))
                return false;
            alante = alante.next;
            atras = atras.previous;
        }
        return false;
    }

    public int length() {
        Node temp = top;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        return n;
    }

    public void add(String key, String data) {
        if (exists(key))
            throw new IllegalArgumentException(
                    "La key: '" + key + "' ya existe, no puedes crear un elemento con una key existente");
        Node temp = new Node();
        temp.key = key;
        temp.data = data;
        if (top == null) {
            top = temp;
            back = temp;
        } else {
            temp.next = top;
            top.previous = temp;
            top = temp;
        }

    }

    public void addBack(String key, String data) {
        if (exists(key))
            throw new IllegalArgumentException(
                    "La key: '" + key + "' ya existe, no puedes crear un elemento con una key existente");
        Node temp = new Node();
        temp.key = key;
        temp.data = data;
        if (top == null) {
            top = temp;
            back = temp;
        } else {
            temp.previous = back;
            back.next = temp;
            back = temp;
        }
    }

    public void addAfter(String after, String key, String data) {
        if (exists(key))
            throw new IllegalArgumentException(
                    "La key: '" + key + "' ya existe, no puedes crear un elemento con una key existente");
        Node temp = new Node();
        Node temp2 = new Node();
        temp2.key = key;
        temp2.data = data;
        if (top == null) {
            top = temp2;
            back = temp2;
        } else {
            temp = top;
            while (temp != null && !temp.key.equals(after)) {
                temp = temp.next;
            }
            if (temp == null) {
                throw new IllegalArgumentException("La key: '" + after + "' no se encuentra en la lista");
            }

            temp2.next = temp.next;
            temp2.previous = temp;
            if (temp.next != null) {
                temp.next.previous = temp2;
            } else {
                back = temp2;
            }
            temp.next = temp2;
        }
    }

    public void removeTop() {
        if (top == null) {
            throw new IllegalArgumentException(
                    "No se puede eliminar el primer elemento porque la lista está vacia");
        }

        if (top.next == null) {
            top = null;
            back = null;
        } else {
            top = top.next;
            top.previous = null;
        }
    }

    public void removeBack() {
        if (back == null) {
            throw new IllegalArgumentException(
                    "No se puede eliminar el ultimo elemento porque la lista está vacia");
        }

        if (back.previous == null) {
            top = null;
            back = null;
        } else {
            back = back.previous;
            back.next = null;
        }
    }

    public void remove(String key) {
        if (top == null) {
            throw new IllegalArgumentException(
                    "La key: '" + key + "' no se puede eliminar porque la lista está vacia");

        }

        if (top.key.equals(key)) {
            removeTop();
            return;
        }

        if (back.key.equals(key)) {
            removeBack();
            return;
        }

        Node temp = top;
        while (temp != null && !temp.key.equals(key)) {
            temp = temp.next;
        }
        if (temp == null) {
            throw new IllegalArgumentException(
                    "La key: '" + key + "' no se puede eliminar porque no existe en la lista");
        }

        // Eliminar el nodo encontrado
        if (temp.next != null) {
            temp.next.previous = temp.previous;
        } else {
            // temp es el último nodo
            back = temp.previous;
        }

        if (temp.previous != null) {
            temp.previous.next = temp.next;
        } else {
            // temp es el primer nodo
            top = temp.next;
        }
    }

    @Override
    public String toString() {
        Node temp = top;
        String s = "";
        while (temp != null) {
            s += (temp.key);
            temp = temp.next;
            if (temp != null) {
                s += (", ");
            }
        }
        return s;
    }

}
