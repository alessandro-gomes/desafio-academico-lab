package etapa4;

public class PrincipalParaTeste {
    public static void main(String[] args) {
        LinkedStack<String> ls = new LinkedStack<>();
        
        System.out.println("Pilha vazia? " + ls.isEmpty());
        
        ls.push("teste");
        ls.push("test1");
        ls.push("test2");
        
        System.out.println("Pilha vazia? " + ls.isEmpty());
        System.out.println("Quantidade de elementos: " + ls.numElements());
        
        System.out.println("Elementos: " + ls.toString());
        System.out.println("Topo: " + ls.top());
        System.out.println("Elemento retirado: " + ls.pop());
        System.out.println("Quantidade de elementos: " + ls.numElements());
        System.out.println("Topo: " + ls.top());
        
        System.out.println("Elemento retirado: " + ls.pop());
        System.out.println("Quantidade de elementos: " + ls.numElements());
        System.out.println("Topo: " + ls.top());
       
       //-------------------------
       
        /*LinkedStack<Integer> ls = new LinkedStack<>();
        System.out.println("Pilha vazia? " + ls.isEmpty());
        
        ls.push(1);
        ls.push(2);
        ls.push(3);
        
        System.out.println("Pilha vazia? " + ls.isEmpty());
        System.out.println("Quantidade de elementos: " + ls.numElements());
        System.out.println("Elementos: " + ls.toString());
        System.out.println("Topo: " + ls.top());*/
        
        /*LinkedQueue<String> lq = new LinkedQueue<>();
        
        lq.enqueue("teste");
        lq.enqueue("teste1");
        lq.enqueue("teste2");
        lq.enqueue("teste3");
        System.out.println("Quantidade elementos: " + lq.numElements());
        System.out.println(lq);
        System.out.println("Primeiro: " + lq.front());
        System.out.println("Ultimo: " + lq.back());
        
        System.out.println("\nRetirando o primeiro elemento da fila: " + lq.dequeue());
        System.out.println("Quantidade elementos: " + lq.numElements());
        System.out.println(lq);
        System.out.println("Primeiro: " + lq.front());
        System.out.println("Ultimo: " + lq.back());*/
    }
}
