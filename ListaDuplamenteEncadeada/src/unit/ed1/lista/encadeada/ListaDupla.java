/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit.ed1.lista.encadeada;

import java.security.InvalidParameterException;
import java.util.Iterator;
import unit.ed1.lista.ILista;

/**
 *
 * @author 117139648
 */
public class ListaDupla<Tipo> implements ILista<Tipo> {

    private int contador;
    private NoDuplamenteEncadeado<Tipo> inicio, fim, anterior;

    public ListaDupla() {
        this.contador = 0;
        this.inicio = null;
        this.anterior = null;
        this.fim = null;
    }

    @Override
    public void adicionar(Tipo elemento) {
        NoDuplamenteEncadeado<Tipo> novoNo = new NoDuplamenteEncadeado<>(elemento);

        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            this.fim.setProximo(novoNo);
            novoNo.setAnterior(this.fim);
            this.fim = novoNo;
        }
        
        this.contador++;
        
    }

    @Override
    public void adicionar(int posicao, Tipo elemento) throws InvalidParameterException {
        if(posicao == 0)
        {
            this.adicionarNoInicio(elemento);
        }
        else if(posicao == this.tamanho())
        {
            this.adicionar(elemento);
        } 
        else 
        {
            NoDuplamenteEncadeado<Tipo> anterior = this.ObterElemento(posicao - 1);
            NoDuplamenteEncadeado<Tipo> nova = new NoDuplamenteEncadeado<>(elemento,anterior.getProximo(),anterior.getAnterior());
            anterior.setProximo(nova);
            this.contador++;
         }
    }
    
    @Override
    public void adicionarNoInicio(Tipo elemento) {
        if(this.contador == 0)
        {
            NoDuplamenteEncadeado<Tipo> nova = new NoDuplamenteEncadeado<>(elemento, this.inicio, null);
            this.inicio = nova;

            if(this.tamanho() == 0)
            {
                // caso especial da lista vazia
                this.fim = this.inicio;
            }
        }
        else
        {
            NoDuplamenteEncadeado<Tipo> nova = new NoDuplamenteEncadeado<>(elemento, this.inicio, this.anterior);
            this.inicio.setAnterior(nova);
            this.inicio = nova;
        }
          this.contador++;
            
    }
    
    public int PosicaoContem(Tipo elemento)
    {
       NoDuplamenteEncadeado<Tipo> atual = this.inicio;
       int pos = 0, pos_retorno = -1;
       while (atual != null) 
       {
        if (atual.getValor().equals(elemento)) 
        {
          return pos;
        }
        atual = atual.getProximo();
        pos++;
       }
       return pos_retorno;
    }
    
    @Override
    public boolean contem(Tipo elemento) throws InvalidParameterException {
       boolean retorno = false;
       if(this.PosicaoContem(elemento) != -1)
       {
           retorno = true;
       }
       return retorno;
    }
    
    private boolean posicaoValida(int posicao){
      return posicao >= 0 && posicao < this.tamanho();
    }
    
    private NoDuplamenteEncadeado<Tipo> ObterElemento(int posicao) throws InvalidParameterException
    {
        if(!this.posicaoValida(posicao))
        {
          throw new IllegalArgumentException("Posição não encontrada");
        }

        NoDuplamenteEncadeado<Tipo> atual = this.inicio;
        for (int i = 0; i < posicao; i++) 
        {
          atual = atual.getProximo();
        }
        return atual;    
    }
    
    @Override
    public Tipo obter(int posicao) throws InvalidParameterException 
    {
        Tipo retorno = null;
        try
        {
            retorno = this.ObterElemento(posicao).getValor();
        } catch(Exception e)
        {
            throw new InvalidParameterException(e.getMessage());
        }
        finally
        {
            return retorno;
        }
    }

    @Override
    public int tamanho() {
        return this.contador;
    }

    @Override
    public int capacidade() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void remover(int posicao) throws InvalidParameterException {
      if(posicao <= (this.tamanho() - 1) && this.tamanho() != 0)
      {
          boolean removido = false;
          // Remover do inicio
          if(posicao == 0)
          {
                this.inicio = this.inicio.getProximo();
                
                if (this.tamanho() == 0) 
                {
                    this.fim = null;
                }
                removido = true;
          }
          // Remover do fim
          else if(posicao == this.tamanho())
          {
              if(this.tamanho() == 0)
              {
                  this.inicio = this.inicio.getProximo();
                  this.fim = null;
              }
              else
              {
                int posicao_pen = (this.tamanho() - 2) > 0 ? this.tamanho() - 2 : 0;
                
                NoDuplamenteEncadeado<Tipo> penultima = this.ObterElemento(posicao_pen);
                penultima.setProximo(null);
                this.fim = penultima;

              }
              removido = true;
          }
          else
          {
                NoDuplamenteEncadeado<Tipo> anterior = this.ObterElemento(posicao - 1);
                NoDuplamenteEncadeado<Tipo> atual = anterior.getProximo();
                NoDuplamenteEncadeado<Tipo> proxima = atual.getProximo();

                anterior.setProximo(proxima);
                
                this.contador = this.tamanho() - 1;
                
          }
          
          if(removido)
          {
            this.contador--;
          }
      }
      else
      {
          throw new InvalidParameterException("Posicão não removível");
      }
    }

    @Override
    public int remover(Tipo elemento) {
        int retorno_pos = this.PosicaoContem(elemento);
        if(retorno_pos != -1)
        {
            this.remover( retorno_pos );
        }
        return retorno_pos;
        
     }

    @Override
    public void removerDoInicio() {
         this.remover(0);
    }

    @Override
    public void limpar() {
        this.inicio = null;
        this.fim = null;
        this.contador = 0;
    }

    @Override
    public Iterator<Tipo> iterator() {
        return new IteradorListaEncadeada();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void adicionar(int i, String teste) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class IteradorListaEncadeada implements Iterator<Tipo> {

        private NoDuplamenteEncadeado<Tipo> proximo;

        public IteradorListaEncadeada() {
            this.proximo = inicio;
        }

        @Override
        public boolean hasNext() {
            return proximo != null;
        }

        @Override
        public Tipo next() {
            Tipo elemento = this.proximo.getValor();
            this.proximo = this.proximo.getProximo();
            return elemento;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
