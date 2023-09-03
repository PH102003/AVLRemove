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
    private AVLNode<T> inserirNo(AVLNode<T> raiz, T value ){
        if (raiz == null) {
            // lógica pra saber se o nó inserido vai pra direita ou esquerda
            raiz = new AVLNode<>(value);
        } else if (value.compareTo(raiz.getInfo()) < 0) {
            raiz.setLeft(inserirNo(raiz.getLeft(), value));
        }else{
            raiz.setRight(inserirNo(raiz.getRight(),value));
        }
        return raiz;

    }
}
