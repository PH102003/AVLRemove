public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();

        // Inserção de valores
        avlTree.inserir(23);
        avlTree.inserir(50);
        avlTree.inserir(30);
        

        System.out.println("Árvore AVL após inserções:");
        System.out.println("Passeio em ordem: " + avlTree.passeioEmOrdem());
        System.out.println("Altura da árvore: " + avlTree.passeioPorNivel());

        // Remover um valor
        avlTree.removeNode(80);

        System.out.println("\nÁrvore AVL após remoção:");
        System.out.println("Passeio em ordem: " + avlTree.passeioEmOrdem());
        System.out.println("Altura da árvore: " + avlTree.passeioPorNivel());
    }
}
