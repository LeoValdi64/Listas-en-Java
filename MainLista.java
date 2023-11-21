public class MainLista{
    public static void main(String[] args) {
        Lista lista1 = new Lista();
        lista1.add("A","Hola");
        lista1.add("B","Mundo");
        lista1.add("C","Que");
        lista1.add("D","tal");

        System.out.println(lista1);
        lista1.remove("D");
        System.out.println(lista1);
        lista1.addBack("E","Wenas");
        lista1.addAfter("A", "F","Todos");
        System.out.println(lista1);
    }
    
}