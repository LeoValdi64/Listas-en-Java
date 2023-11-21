public class ListaDobleEnlazada {
    public static void main(String[] args) {
        // Incercion de una lista vacia.
        Node topForward, topBackward;
        topForward = new Node();
        topForward.key = "A";
        topBackward = topForward;

        dump("Caso 1:", topBackward);

        // Insertar nodo al antes del primer nodo
        Node temp;
        temp = new Node();
        temp.key = "B";

        temp.next = topForward;
        topForward.previous = temp;
        topForward = temp;
        temp = null;
        dump("Caso 2:", topForward);

        // Insertar nodo al final de la lista
        temp = new Node();
        temp.key = "C";

        temp.previous = topBackward;
        topBackward.next = temp;

        topBackward = temp;
        temp = null;
        dump("Caso 3:", topForward);

        // incercion entre 2 nodos
        temp = new Node();
        temp.key = "D";

        Node temp2 = new Node();
        temp2 = topForward;
        while (temp2.key.equals("A") == false)
            temp2 = temp2.next;
        temp.next = temp2.next;
        temp2.next = temp;
        temp.previous = temp2;
        temp.next.previous = temp;
        temp = null;
        temp2 = null;
        dump("Caso 4:", topForward);

        // Borrar el primero o el ultimo

        // Borrar el primer nodo
        topForward = topForward.next;
        topForward.previous.next = null;
        topForward.previous = null;
        dump("Caso 5:", topForward);

        // Borrar el ultimo nodo
        // topBackward = topBackward.previous;
        // topBackward.next.previous = null;
        // topBackward.next = null;
        // dump("Caso 6:", topForward);


        //Borrar cualquier nodo del medio mientras que no sea el primero ni el ulitmo
        temp = topForward;
        while(temp.key.equals("D")==false)
            temp = temp.next;
        temp = temp.previous;
        temp.next =temp.next.next;
        temp.next.previous.previous = null;
        temp.next.previous.next = null;
        temp.next.previous = temp;
        temp = null;
        dump("Caso 7:", topForward);

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