/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursinho;

import ListaEncadeada.ListaSimplesmenteEncadeada;
import ListaVetor.ListaVetor;
import cursinho.Aluno;

/**
 *
 * @author 1171139648
 */
public class Turmas {
    
    private ListaVetor<String[]> turmas = new ListaVetor<>();
    private ListaVetor<String> turmas_cod = new ListaVetor<>();
    private ListaVetor<String[]> alunosMatriculados = new ListaVetor<>();
    private ListaVetor<String> PosicaoTurmaAlunosMatriculados = new ListaVetor<>();
    private ListaSimplesmenteEncadeada<String[]> fila_turmas = new ListaSimplesmenteEncadeada<>();
    private Validacoes validar = new Validacoes();
    
    private int PosicaoElementoS(ListaVetor<String[]> dados ,String elemento)
    {
        int pos = 0;
        for (String[] lista : dados) 
        {
            if(lista[0].equals(elemento))
            {
                return pos;
            }
            pos++;
        }
        
        return -1;
    }
    
    private int PosicaoElementoLV(ListaVetor<String> dados ,String elemento)
    {
        int pos = 0;
        for (String lista : dados) 
        {
            if(lista.equals(elemento))
            {
                return pos;
            }
            pos++;
        }
        
        return -1;
    }
    
    private int PosicaoElementoLSE(ListaSimplesmenteEncadeada<String[]> dados ,String elemento)
    {
        int pos = 0;
        for (String[] lista : dados) 
        {
            if(lista[0].equals(elemento))
            {
                return pos;
            }
            pos++;
        }
        
        return -1;
    }
    
    public void Cadastrar(String codigo_turma, String max_alunos) throws Exception
    {
        if(this.validar.validarNumero(codigo_turma) && this.validar.validarNumero(max_alunos))
        {
            if(this.turmas.tamanho() == 0 || this.PosicaoElementoS(this.turmas,codigo_turma) == -1)
            {
                String[] dados_turma = {codigo_turma, max_alunos};
                this.turmas.adicionar(dados_turma);
            }
            else
            {
                throw new Exception("Código de turma já cadastrado");
            }
        }
        else
        {
            throw new Exception("Codigo da turma ou quantidade de alunos inválido");
        }
    }
    
    private int MaxAlunos(String cod_turma)
    {
       int retorno = 0;
       
      int posicao_turma = this.PosicaoElementoS(this.turmas,cod_turma);
      if(posicao_turma != -1)
      {
        String[] dados_turma = this.turmas.obter(posicao_turma);
        Integer max_alunos = Integer.parseInt(dados_turma[1]);
        
        retorno = max_alunos;
      }
       
       return retorno;
    }
    
    private int QntdAlunosTurma(String cod_turma)
    {
       int retorno = 0;
       int posicao_turma_alunos_r = this.PosicaoElementoS(this.alunosMatriculados, cod_turma);
       if(posicao_turma_alunos_r != -1)
       {
        String[] matriculas_dados_r = this.alunosMatriculados.obter(posicao_turma_alunos_r);
        Integer quantidade_alunos_r = Integer.parseInt( matriculas_dados_r[1] );
        
        retorno = quantidade_alunos_r;
       }
       
       return retorno;
    }
    
    public void EfetuarMatricula(String cod_turma, String rg_aluno, Aluno alunos_dados) throws Exception
    {
        if(this.validar.validarNumero(rg_aluno) && this.validar.validarNumero(cod_turma))
        {
            int posicao_turma = this.PosicaoElementoS(this.turmas,cod_turma);
            if(posicao_turma != -1)
            {
                try
                {
                    String[] dados_turma = this.turmas.obter(posicao_turma);
                    String[] dados_aluno = alunos_dados.DadosAluno(rg_aluno);
                    
                    int posicao_turma_alunos = this.PosicaoElementoS(this.alunosMatriculados, cod_turma);
                    Integer max_alunos = this.MaxAlunos(cod_turma);

                    if(posicao_turma_alunos == -1)
                    {
                        String[] matricula_add = {cod_turma, "1"};

                        this.alunosMatriculados.adicionar(matricula_add);
                        //this.PosicaoTurmaAlunosMatriculados.adicionar(cod_turma);
                        
                        dados_aluno[2] = cod_turma;

                        alunos_dados.RemoverAluno(rg_aluno);
                        alunos_dados.AdicionarAluno(dados_aluno);    
                        
                        Integer quantidade_alunos = this.QntdAlunosTurma(cod_turma);
                    }
                    else
                    {
                        Integer quantidade_alunos = this.QntdAlunosTurma(cod_turma);
                        
                        if(quantidade_alunos < max_alunos)
                        {
                            if(!dados_aluno[2].equals(cod_turma))
                            {
                                quantidade_alunos++;
                                String[] matricula_add = {cod_turma, ""+quantidade_alunos};
                                this.alunosMatriculados.remover(posicao_turma_alunos);
                                //this.PosicaoTurmaAlunosMatriculados.remover(posicao_turma_alunos);

                                this.alunosMatriculados.adicionar(matricula_add);
                                //this.PosicaoTurmaAlunosMatriculados.adicionar(cod_turma);

                                dados_aluno[2] = cod_turma;

                                alunos_dados.RemoverAluno(rg_aluno);
                                alunos_dados.AdicionarAluno(dados_aluno);
                                
                            }
                            else
                            {
                                throw new Exception("Aluno já cadastrado na turma");
                            }
                        }
                        else
                        {
                            String[] dados_fila = {cod_turma, rg_aluno};
                            this.fila_turmas.adicionar(dados_fila);
                            throw new Exception("O aluno foi para a fila de espera");
                        }

                    }
                    
                        
                } catch(Exception e)
                {
                    throw new Exception(e.getMessage());
                }
            }
            else
            {
                throw new Exception("Turma não encontrada");
            }
        }
        else
        {
            throw new Exception("Rg do aluno ou código da turma não é numérico");
        }
    }
    
    public void CancelarMatricula(String cod_turma, String rg_aluno, Aluno alunos_dados) throws Exception
    {
        if(this.validar.validarNumero(rg_aluno) && this.validar.validarNumero(cod_turma))
        {
            int posicao_turma = this.PosicaoElementoS(this.turmas,cod_turma);
            if(posicao_turma != -1)
            {
                String[] dados_turma = this.turmas.obter(posicao_turma);
                String[] dados_aluno = alunos_dados.DadosAluno(rg_aluno);
                
                Integer qntd_alunos = Integer.parseInt(dados_turma[1]);
                qntd_alunos--;
                dados_turma[1] = ""+qntd_alunos;
                
                int posicao_fila = this.PosicaoElementoLSE(this.fila_turmas, cod_turma);
                
                if(posicao_fila != -1)
                {
                    String[] dados_aluno_fila = this.fila_turmas.obter(posicao_fila);
                    String rg_aluno_fila = dados_aluno_fila[0];
                    
                    String[] aluno_fila = alunos_dados.DadosAluno(rg_aluno_fila);
                    aluno_fila[2] = cod_turma;
                    alunos_dados.RemoverAluno(rg_aluno_fila);
                    alunos_dados.AdicionarAluno(aluno_fila);
                }
                
                
                this.turmas.remover(posicao_turma);
                this.turmas.adicionar(dados_turma);
                
                dados_aluno[2] = "0";
                alunos_dados.RemoverAluno(rg_aluno);
                alunos_dados.AdicionarAluno(dados_aluno);

            }
            else
            {
                throw new Exception("Turma não encontrada");
            }
        }
        else
        {
            throw new Exception("Rg do aluno ou código da turma não é numérico");
        }
    }
    
    public void CancelarTurma(String cod_turma) throws Exception
    {
        if(this.validar.validarNumero(cod_turma))
        {
            int posicao_turma = this.PosicaoElementoS(this.turmas,cod_turma);
            if(posicao_turma != -1)
            {
                this.turmas.remover(posicao_turma);
            }
            else
            {
                throw new Exception("Turma não encontrada");
            }
        }
        else
        {
            throw new Exception("Rg do aluno ou código da turma não é numérico");
        }
    }
    
    public String ListarAlunosNaTurma(String cod_turma, Aluno alunos_dados) throws Exception
    {
        String retorno = "";
        if(this.validar.validarNumero(cod_turma))
        {
            int posicao_turma = this.PosicaoElementoS(this.turmas,cod_turma);
            if(posicao_turma != -1)
            {
                ListaVetor<String[]> alunos_turma, alunos_turma_add = new ListaVetor<>();
                alunos_turma = alunos_dados.TodosAlunos();
                
                for (String[] strings : alunos_turma) 
                {
                    if(strings[2].equals(cod_turma))
                    {
                        alunos_turma_add.adicionar(strings);
                    }
                }
                
                for (String[] strings : alunos_turma_add) 
                {
                    retorno += "RG: "+strings[0]+"\n"+"Nome: "+strings[1]+"\n\n";
                }
            }
            else
            {
                throw new Exception("Turma não encontrada");
            }
        }
        else
        {
            throw new Exception("Rg do aluno ou código da turma não é numérico");
        }
        return retorno;
    }
    
    public String ListarTurmas(String cod_turma) throws Exception
    {
        String retorno = "";
        if(this.validar.validarNumero(cod_turma))
        {
            int posicao_turma = this.PosicaoElementoS(this.turmas,cod_turma);
            if(posicao_turma != -1)
            {
                int max_alunos = this.MaxAlunos(cod_turma);
                int qntd_alunos = this.QntdAlunosTurma(cod_turma);
                int contador_fila = 0;
                
                for (String[] fila_turma : this.fila_turmas) 
                {
                    if(fila_turma[0].equals(cod_turma))
                    {
                        contador_fila++;
                    }
                }
                
                retorno += "Cód. Turma: "+cod_turma;
                retorno += "\nNúmero de vagas: "+max_alunos;
                retorno += "\nNúmero de alunos matriculados: "+qntd_alunos;
                retorno += "\nTamanho fila de espera: "+contador_fila;
            }
            else
            {
                throw new Exception("Turma não encontrada");
            }
        }
        else
        {
            throw new Exception("Rg do aluno ou código da turma não é numérico");
        }
        return retorno;
    }
}
