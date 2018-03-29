/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit.ed1.lista.vetor;

import java.security.InvalidParameterException;
import java.util.Iterator;
import unit.ed1.lista.ILista;

/**
 *
 * @author 11645
 */
public class ListaVetor<Tipo> implements ILista<Tipo> {
    private Tipo[] elementos;
    private int contador;

    public ListaVetor() {
        this(10);
    }

    public ListaVetor(int capacidadeInicial) {
        this.elementos = (Tipo[]) new Object[capacidadeInicial];
        this.contador = 0;
    }

    @Override
    public void adicionar(Tipo elemento) {
        this.elementos[contador] = elemento;
        contador++;
    }

    @Override
    public void adicionar(int posicao, Tipo elemento) throws InvalidParameterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionarNoInicio(Tipo elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contem(Tipo elemento) throws InvalidParameterException {
        for (Tipo valor : this) {
            if(valor.equals(elemento)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Tipo obter(int posicao) throws InvalidParameterException {
        if(posicao < 0 || posicao >= contador) {
            throw new InvalidParameterException("Posição inválida!");
        }
        return this.elementos[posicao];
    }

    @Override
    public int tamanho() {
        return this.contador;
    }

    @Override
    public int capacidade() {
        return this.elementos.length;
    }

    @Override
    public void remover(int posicao) throws InvalidParameterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int remover(Tipo elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerDoInicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Tipo> iterator() {
        return new IteradorVetor();
    }

    private class IteradorVetor implements Iterator<Tipo>{
        int posicaoAtual = 0;
        
        @Override
        public boolean hasNext() {
            if (posicaoAtual < contador) {
                return true;
            }

            return false;
        }

        @Override
        public Tipo next() {
            return elementos[posicaoAtual++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
   
    
}
