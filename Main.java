
public class Main {
    public static void main(String[] args) {
        
        AVLTree<Integer> tree = new AVLTree<>();

        tree.inserir(10);
        tree.inserir(5);
        tree.inserir(15);
        tree.inserir(3);
        tree.inserir(7);
    
        System.out.println("Árvore está vazia? " + tree.isEmpty());
        
            
    }
}
