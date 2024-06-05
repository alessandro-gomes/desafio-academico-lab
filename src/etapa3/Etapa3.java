package etapa3;

public class Etapa3 {

    public boolean checkBrackets(Stack<Character> s1) {

        // Pilha auxiliar para acompanhar os parênteses
        StaticStack<Character> auxStack = new StaticStack<>(s1.numElements());

        // Percorre a pilha original (s1) e verifica os parênteses
        while (!s1.isEmpty()) {
            char atual = s1.pop();

            if (atual == '(') {
                // Se encontrar um parêntese de abertura, empilha na pilha auxiliar
                auxStack.push(atual);
            } else if (atual == ')') {
                // Se encontrar um parêntese de fechamento
                if (auxStack.isEmpty()) {
                    // Não há um parêntese de fechamento correspondente
                    return false;
                } else {
                    // Remove um parêntese de abertura da pilha auxiliar
                    auxStack.pop();
                }
            }
        }

        // No final, a pilha auxiliar deve estar vazia se todos os parênteses estiverem balanceados
        return auxStack.isEmpty();
    }
    
    public static void main(String[] args) {
        Etapa3 etapa = new Etapa3();
        
        // expressão incorreta: A+B(
        Stack<Character> expr1 = new StaticStack<>(20);
        expr1.push('(');
        expr1.push('B');
        expr1.push('+');
        expr1.push('A');
        
        // expressão correta: (A+B)
        Stack<Character> expr2 = new StaticStack<>(20);
        expr2.push(')');
        expr2.push('B');
        expr2.push('+');
        expr2.push('A');
        expr2.push('(');
        
        System.out.println(etapa.checkBrackets(expr1));
        System.out.println(etapa.checkBrackets(expr2));
    }

}
