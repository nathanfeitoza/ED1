/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursinho;

import ListaVetor.ListaVetor;

/**
 *
 * @author 1171139648
 */
public class Aluno {
    
    private ListaVetor<String[]> alunos_cadastrar = new ListaVetor<>();
    private ListaVetor<String> alunos_cod = new ListaVetor<>();
    private Validacoes validar = new Validacoes();
    
    private String nome_aluno, rg_aluno;
    
    public Aluno NomeAluno(String nome)
    {
        this.nome_aluno = nome;
        return this;
    }
    
    public Aluno RG(String rg_cadastrar)
    {
        this.rg_aluno = rg_cadastrar;
        return this;
    }
    
    public int PosicaoAluno(String rg_aluno)
    {
        int pos = 0;
        for (String[] lista : this.alunos_cadastrar) 
        {
            if(lista[0].equals(rg_aluno))
            {
                return pos;
            }
            pos++;
        }
        
        return -1;
    }
    
    public void Cadastrar() throws Exception
    {
        if(!validar.validarNumero(this.rg_aluno))
        {
            throw new Exception("Rg do aluno não é numérico");
        }
        else
        {
            if(this.PosicaoAluno(this.rg_aluno) == -1)
            {
                String[] dados_cadastar = {this.rg_aluno, this.nome_aluno, "0"};
                this.alunos_cadastrar.adicionar(dados_cadastar); 
            }
            else
            {
                throw new Exception("Este RG já foi cadastrado");
            }
          
        }
    }
    
    
    public void RemoverAluno(String rg_aluno) throws Exception
    {
        int rg = this.PosicaoAluno(rg_aluno);

        if(rg != -1)
        {
            this.alunos_cadastrar.remover(rg);
            //this.alunos_cod.remover(rg);
        }
        else
        {
            throw new Exception("Aluno não encontrado");
        }
    }
    
    public void AdicionarAluno(String[] dados)
    {
        this.alunos_cadastrar.adicionar(dados);
    }
    
    public String[] DadosAluno(String rg_aluno) throws Exception
    {
        String[] retorno = {};
        int posicao_aluno = this.PosicaoAluno(rg_aluno);
        
        
        if(posicao_aluno != -1)
        {
           retorno = this.alunos_cadastrar.obter(posicao_aluno);
        }
        else
        {
            throw new Exception("Aluno não encontrado");
        }
        
        return retorno;
    }
    
    public ListaVetor TodosAlunos()
    {
        return this.alunos_cadastrar;
    }
   
}
