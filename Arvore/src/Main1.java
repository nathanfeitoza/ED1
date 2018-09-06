
import ArvoreBinaria.ArvoreBinaria;
import Model.Arvores;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1171139648
 */
public class Main1 {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
    	Scanner entrada = new Scanner(System.in);
    	Arvores a = null;
        System.out.println("Entrada: ");
        int n = entrada.nextInt();
    	System.out.println("Montar arvore\n");
        for(int i = 0; i < n; i++){
        	a = arvore.inserir(a, entrada.nextInt());
        }
        System.out.println(arvore.localizar(a, 2, false));
        System.out.println( arvore.excluir(a, 2) );
        /*int num = entrada.nextInt();
        if( arvore.localizar(a, num, false)){
        	arvore.excluir(a, num);
        }
        else{
        	arvore.inserir(a, num);
        }*/
        System.out.println(arvore.imprimir(a));
    }
}
