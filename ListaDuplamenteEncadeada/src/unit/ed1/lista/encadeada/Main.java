/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit.ed1.lista.encadeada;

/**
 *
 * @author 1171139648
 */
public class Main {
    public static void main(String[] args)
    {
        ListaDupla<String> teste = new ListaDupla();
        
        teste.adicionar("algo");
        teste.adicionar("algo2");
        teste.adicionar("algo3");
        teste.adicionar("algo4");
        //teste.adicionarNoInicio("algo5");
        //teste.adicionar(1,"teste");
        
        //teste.remover(3);
        teste.remover(2);
        //System.out.println("Contem: "+teste.contem("algo2"));
        /*for(int i = 0; i < teste.tamanho(); i++)
        {
           System.out.println(teste.obter(i)); 
        }*/
        
        //System.out.println(teste.tamanho());
                
        for (String elemento : teste) {
            System.out.println(elemento);
        }
        //System.out.println(teste.tamanho());
    }
}
