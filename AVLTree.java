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
             AVLNode<T> no = new AVLNode<>(value);
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

    public void rotaçaoSimplesEsq() {
            if(root != null){
                root = rotacaoSimplesEsq(root);
            }
        
    }
    private AVLNode<T> rotacaoSimplesEsq(AVLNode<T> raiz){
        AVLNode <T> raizAux = raiz.getRight();
        raiz.setRight(raizAux.getLeft());
        raizAux.setLeft(raiz);
        //lógica de transformar o filho a direita como 'raiz'

        return raizAux;

        

    }

    public void rotaçaoDuplaEsq() {
        if(root != null){
            root = rotaçaoDuplaEsq(root);
        }
    }
    private AVLNode<T> rotaçaoDuplaEsq(AVLNode<T> raiz){
        raiz.setRight(rotacaoSimplesDirt(raiz.getRight()));
        /*utilização do método de rotação simples a direita seguido de rotação simples a esquerda,
        visto que uma rotação dupla é composta de duas rotações simples 
        */
        return rotacaoSimplesEsq(raiz);

    }

    public void rotaçaoSimplesDirt(){
        if(root != null){
            root = rotacaoSimplesDirt(root);
        }
        
    }
    private AVLNode<T> rotacaoSimplesDirt(AVLNode<T> raiz){
        AVLNode<T> raizAux = raiz.getLeft();
        
        raiz.setLeft(raizAux.getRight());
        
        raizAux.setRight(raiz);
        
        return raizAux;
        //lógica para transformar um filho da esquerda como 'raiz'
    }

    public void rotaçaoDuplaDirt(){
        if(root != null){
            root = rotaçaoDuplaDirt(root);
        }

    }
    private AVLNode<T> rotaçaoDuplaDirt(AVLNode<T> raiz){
        raiz.setLeft(rotacaoSimplesEsq(raiz.getLeft()));
        //lógica contrária à rotaçao dupla a esquerda
        return rotacaoSimplesDirt(raiz);
    }
    
    
        
    }




