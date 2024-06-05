package etapa3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PrincipalParaTeste {

    public static void main(String[] args) {
        StaticList<Integer> lista = new StaticList<>(10);

        for (int i = 0; i < 8; i++) {
            lista.insert(i, i);
        }

        try {
            System.out.println("Total de elementos: " + lista.contaElementos(4));
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(PrincipalParaTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        StaticList<String> lista1 = new StaticList<>(10);
        
        lista1.insert("7", 0);
        lista1.insert("b", 1);
        lista1.insert("2", 2);
        lista1.insert("d", 3);
        lista1.insert("2", 4);
        
        try { 
            System.out.println("Total de elementos: " + lista1.contaElementos("2"));
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(PrincipalParaTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        StaticList<Character> lista2 = new StaticList<>(10);
        
        lista2.insert('7', 0);
        lista2.insert('b', 1);
        lista2.insert(' ', 2);
        lista2.insert('8', 3);
        lista2.insert('7', 4);
        
        try {
            System.out.println("Total de elementos: " + lista2.contaElementos('8'));
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(PrincipalParaTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // testes do segundo metodo do documento.
        Etapa3 etapa = new Etapa3();
        
        // expressão correta: ((A+B)-(C+D))
        Stack<Character> expr1 = new StaticStack<>(20);
        expr1.push(')');
        expr1.push(')');
        expr1.push('D');
        expr1.push('+');
        expr1.push('C');
        expr1.push('(');
        expr1.push('-');
        expr1.push(')');
        expr1.push('B');
        expr1.push('+');
        expr1.push('A');
        expr1.push('(');
        expr1.push('(');

        // expressão incorreta: ((A+B)
        Stack<Character> expr2 = new StaticStack<>(20);
        expr2.push(')');
        expr2.push('B');
        expr2.push('+');
        expr2.push('A');
        expr2.push('(');
        expr2.push('(');

        // expressão incorreta: A+B(
        Stack<Character> expr3 = new StaticStack<>(20);
        expr3.push('(');
        expr3.push('B');
        expr3.push('+');
        expr3.push('A');

        // expressão incorreta: )A+B(-C
        Stack<Character> expr4 = new StaticStack<>(20);
        expr4.push('C');
        expr4.push('-');
        expr4.push('(');
        expr4.push('B');
        expr4.push('+');
        expr4.push('+');
        expr4.push('A');
        expr4.push(')');
        
        // expressão incorreta: (A+B))–(C+D
        Stack<Character> expr5 = new StaticStack<>(20);
        expr5.push('D');
        expr5.push('+');
        expr5.push('C');
        expr5.push('(');
        expr5.push('-');
        expr5.push(')');
        expr5.push(')');
        expr5.push('B');
        expr5.push('+');
        expr5.push('A');
        expr5.push('(');
        
        // expressão correta: (A+B)
        Stack<Character> expr6 = new StaticStack<>(20);
        expr6.push(')');
        expr6.push('B');
        expr6.push('+');
        expr6.push('A');
        expr6.push('(');
        
        // Verificação das expressões
        System.out.println(etapa.checkBrackets(expr1));
        System.out.println(etapa.checkBrackets(expr2));
        System.out.println(etapa.checkBrackets(expr3));
        System.out.println(etapa.checkBrackets(expr4));
        System.out.println(etapa.checkBrackets(expr5));
        System.out.println(etapa.checkBrackets(expr6));
    }
}
