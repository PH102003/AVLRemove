import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;

    public boolean isEmpty() {
        return root == null;
    }

    public void inserir(T value) {
        if (root == null) {
            // verifica se a árvore está vazia
            root = new AVLNode<>(value);
        } else {
            root = inserirNo(root, value);
        }
    }

    private AVLNode<T> inserirNo(AVLNode<T> raiz, T value) {
        if (raiz == null) {
            // lógica pra saber se o nó inserido vai pra direita ou esquerda
            raiz = new AVLNode<>(value);
        } else if (value.compareTo(raiz.getInfo()) < 0) {
            raiz.setLeft(inserirNo(raiz.getLeft(), value));
        } else {
            raiz.setRight(inserirNo(raiz.getRight(), value));
        }
        return raiz;

    }

    public int passeioPorNivel() {
        return passeioPorNivel(this.root);
    }

    private int passeioPorNivel(AVLNode<T> noVisitado) {
        if (noVisitado == null) {
            return -1;
        } else {
            /*
             * soma a altura máxima de cada nó (+1)
             * vai visitando cada nó em cada nível, indo para seus filhos da esquerda para a
             * direita e soma +1 a cada nível visitado
             * se um nó tiver 1 filho ele soma +1, se tiver 2, soma +2 em sua altura.
             */
            return 1 + Math.max(passeioPorNivel(noVisitado.getLeft()), passeioPorNivel(noVisitado.getRight()));

        }
    }

    public AVLNode<T> rotaçaoSimplesEsq() {

    }

    public AVLNode<T> rotaçaoDuplaEsq() {

    }

    public AVLNode<T> rotaçaoSimplesDirt(){
    }

    public AVLNode<T> rotaçaoDuplaDirt(){

    }
}

