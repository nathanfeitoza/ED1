
import java.util.Scanner;
import unit.ed1.lista.vetor.ListaVetor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 11645
 */
public class Main {
    public static void main(String[] args) {
        ListaVetor<Integer> lista = new ListaVetor<>();
        
        
        for (int i = 1; i <= 10; i++) {
            lista.adicionar(i);
        }
        
        System.out.println("Elemento index 2 " + lista.obter(2));
        
        
        for (Integer valor : lista) {
            System.out.println(valor);
        }
    }
}
