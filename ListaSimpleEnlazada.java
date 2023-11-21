
public class ListaSimpleEnlazada {
    public static void main(String[] args) {
        Node top = null;
        // Empezando a crear la lista
        top = new Node();
        top.key = "A";
        top.next = null;

        dump("Caso 1:", top);

        // La lista ya existe, y un nodo será insertado
        // Antes del primer nodo
        Node temp;
        temp = new Node();
        temp.key = "B";
        temp.next = top;
        top = temp;

        dump("Caso 2:", top);

        // Se inserta un nodo despues del ultimo nodo
        temp = new Node();
        temp.key = "C";
        temp.next = null;

        Node temp2;
        temp2 = top;

        while (temp2.next != null)
            temp2 = temp2.next;

        temp2.next = temp;

        dump("Caso 3:", top);

        // Insertar un nodo entre 2 nodos
        temp = new Node();
        temp.key = "D";

        temp2 = top;

        while (temp2.key.equals("A") == false)
            temp2 = temp2.next;

        temp.next = temp2.next;
        temp2.next = temp;
        temp = new Node();
        temp2 = new Node();
        dump("Caso 4:", top);

        // Borrar el primer nodo
        top = top.next;
        dump("Caso 5:", top);

        // Borrar cualquier nodo que no sea el primero
        temp = top;
        while (!temp.next.key.equals("D"))
            temp = temp.next;
        temp.next = temp.next.next;
        temp = new Node();
        dump("Caso 6:", top);

        //Borrar el utlimo nodo de la lista
        temp = top;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next =null;
        temp= new Node();
        dump("Caso 7:", top);

    }
    static void dump(String msg, Node topNode){
        System.out.print(msg +" ");

        while (topNode != null) {
            System.out.print(topNode.key+"");
            topNode = topNode.next;
            if(topNode != null){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}
