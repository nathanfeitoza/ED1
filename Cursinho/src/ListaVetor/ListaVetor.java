/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaVetor;

import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import Lista.ILista;

/**
 *
 * @author 1171139648
 */
public class ListaVetor<Tipo> implements ILista<Tipo> {
    private Tipo[] elements;
    private int inicial = 10;
    private int contador;
    private int capacidadeTotal = 10;

    public ListaVetor() {
        this.elements = (Tipo[]) new Object[inicial];
    }

    public ListaVetor(int capacidadeInicial) {
      this.elements = (Tipo[]) new Object[capacidadeInicial];
      this.capacidadeTotal = capacidadeInicial;
    }
    
    private void Redimensionar()
    {
        if(this.contador == this.capacidadeTotal)
        {
            Tipo[] arr_aux = (Tipo[]) new Object[(this.elements.length + 1) * 2];
            for(int i = 0; i < this.elements.length; i++)
            {
                arr_aux[i] = this.elements[i];
            }
            this.elements = arr_aux;
        }
    }
    
    @Override
    public void adicionar(Tipo elemento) throws InvalidParameterException{
        this.adicionar(this.contador, elemento);
    }

    @Override
    public void adicionar(int posicao, Tipo elemento) throws InvalidParameterException {
        int quantidade = this.tamanho(); 
        boolean checarCapacidade = (this.capacidadeTotal - 1) >= posicao;
        if(checarCapacidade)
        {
            if(this.contador != posicao)
            {
                for(int i = this.contador; i > posicao; i--)
                {
                    Tipo arr_aux = this.elements[i];
                    this.elements[i] = this.elements[i - 1];
                    this.elements[i - 1] = arr_aux;
                }
            }
            if(posicao <= (this.capacidadeTotal))
            {
                this.elements[posicao] = elemento;
                this.contador++;

                if(posicao > (this.contador - 1))
                {
                   this.contador = this.capacidadeTotal;
                }
            }
            else
            {
                throw new InvalidParameterException("Valor maior que o permitido");
            }
           
        }
        else
        {
              throw new InvalidParameterException("Capacidade total do vetor atingida");
        }

    }

    @Override
    public void adicionarNoInicio(Tipo elemento) {
         this.adicionar(0, elemento);
    }

    public int PosicaoContem(Tipo elemento)
    {
        for(int i = 0; i < this.tamanho(); i++)
        {
            Tipo elemento_verificar = this.obter(i);
            if(elemento_verificar.equals(elemento) || elemento_verificar == elemento)
            {
                return i;
            }
            else
            {
                return -1;
            }
        }
        return -1;
    }
    
    @Override
    public boolean contem(Tipo elemento) throws InvalidParameterException {
        boolean retorno = false;
        if(this.PosicaoContem(elemento) != -1)
        {
            return true;
        }
        return retorno;
    }

    @Override
    public Tipo obter(int posicao) throws InvalidParameterException {
        Tipo algo = null;
        
        if(posicao <= this.tamanho() && this.tamanho() != 0)
        {
            algo = this.elements[posicao];
        }
        else
        {
           throw new InvalidParameterException("Posição não encontrada");
        }
        return algo;
    }

    @Override
    public int tamanho() {
        try
        {
            return this.contador;    
        } catch(Exception e)
        {
            return 0;
        }
    }

    @Override
    public int capacidade() {
        return this.elements.length;
    }

    @Override
    public void remover(int posicao) throws InvalidParameterException {
       try
       {
           this.obter(posicao);
           this.elements[posicao] = null;
           for(int i = posicao; i < this.contador; i++)
           {
               this.elements[i] = this.elements[i + 1];
           }
           this.contador--;
       } catch(InvalidParameterException e)
       {
           throw new InvalidParameterException("Posição não encontrada");
       }
    }

    @Override
    public int remover(Tipo elemento) {
        int posicao = this.PosicaoContem(elemento);
        int retorno = -1;
        if(posicao != -1)
        {
            this.remover(posicao);
            retorno = posicao;
        }
        return retorno;
    }

    @Override
    public void removerDoInicio() {
        this.remover(0);
    }

    @Override
    public void limpar() {
        this.elements = (Tipo[]) new Object[this.inicial];
        this.contador = 0;
    }

    @Override
    public Iterator<Tipo> iterator() {
        return new IteradorVetor();
    }


    private class IteradorVetor implements Iterator<Tipo>{
        
        int pos = 0;
        @Override
        public boolean hasNext() {
            return pos < tamanho();
        }

        @Override
        public Tipo next() {
            return elements[pos++]; //return elementos[i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
   
    
}
