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
            if (raiz.getFatBal() < -1) {
                // rotaçao simples a dir
                raiz = rotacaoSimplesDirt(raiz);
            } else if (raiz.getLeft().getFatBal() >= 0) {
            // rotaçao dupla à dirt
            raiz = rotaçaoDuplaDirt(raiz);
            }
            
        } else {
            raiz.setRight(inserirNo(raiz.getRight(), value));
            if(raiz.getFatBal()> 1){
                raiz= rotacaoSimplesEsq(raiz);
                
            }else if(raiz.getRight().getFatBal() < 0){
                raiz = rotaçaoDuplaEsq(raiz);
                //logica pra rotaçao dupla a esq
            }
            
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
        /*
        visto que só é possivel fazer uma rotação à esq através de uma inserção a dir,
        estou me baseando no nó inserido a direita (raiz.getRight)
         */
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
        /* 
        visto que só é possivel fazer uma rotação a direita através de uma inserção a esq,
        estou me baseando no nó inserido a esq (raiz.getLeft)
         */
        raiz.setLeft(raizAux.getRight());
        
        raizAux.setRight(raiz);
        //lógica para transformar um filho da esquerda como 'raiz'
        
        return raizAux;
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




