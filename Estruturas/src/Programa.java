
import unit.ed1.lista.vetor.ListaVetor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1171139648
 */
public class Programa {
    private ListaVetor<String> disciplinas = new ListaVetor<>();
    private ListaVetor<String> alunos = new ListaVetor<>();
    private ListaVetor<String> matriculas = new ListaVetor<>();
    private ListaVetor<String> alunos_tops_posicao = new ListaVetor<>();
    
    public void CadastrarDisciplina(String disciplina)
    {
        this.disciplinas.adicionar(disciplina);
    }
    
    public void CadastrarAluno(String matricula, String nome, String nota1, String nota2)
    {
        String salvar = matricula+","+nome+","+nota1+","+nota2;
        alunos.adicionar(salvar);
        matriculas.adicionar(matricula);
    }
    
    private double CalcularMedia(double nota1, double nota2)
    {
        double media = 0;
        media = ( (nota1 * 4) + (nota2 * 6) ) /10;
        return media;
    }
    
    public String AlunosAprovadosReprovados(int tipo)
    {
        String retorno = "";
        for(String alunos_ver : alunos)
        {
            String valores[] = new String[4];
            valores = alunos_ver.split(",");
            double nota1 = Double.parseDouble(valores[2]);
            double nota2 = Double.parseDouble(valores[3]);
            double media = this.CalcularMedia(nota1, nota2);
            String dados = "Aluno: "+valores[1]+"\nMatricula: "+valores[0]+"\nNota 1: "+nota1+"\nNota 2: "+nota2+"\nMedia: "+media+"\n\n";

            if(media >= 6 && tipo == 1)
            {
                retorno += dados;
            }
            else if(media < 6 && tipo == 2)
            {
                retorno += dados;
            }
        }
        return retorno;
    }
    
    public String AlunosDestaques()
    {
        String retorno = "";
        double media_comparar = 0;
        ListaVetor<String> guardar_medias = new ListaVetor<>();
        ListaVetor<String> guardar_posicao = new ListaVetor<>();
        for(int i = 0; i < alunos.tamanho(); i++)
        {
            String valores[] = new String[4];
            valores = alunos.obter(i).split(",");
            double nota1 = Double.parseDouble(valores[2]);
            double nota2 = Double.parseDouble(valores[3]);
            double media = this.CalcularMedia(nota1, nota2);   
            guardar_medias.adicionar(""+media);
            guardar_posicao.adicionar(""+i);
        }

        
        for(int j = 0; j < guardar_medias.tamanho(); j++)
        {
            double media_aluno_ver = Double.parseDouble( guardar_medias.obter(j) );
            
            if(media_aluno_ver != 0 && media_aluno_ver >= media_comparar)
            {
                if(media_aluno_ver > media_comparar)
                {
                    alunos_tops_posicao.limpar();
                }
                alunos_tops_posicao.adicionar(""+guardar_posicao.obter(j));
                media_comparar = media_aluno_ver;
            }
        }
        
        for(int n = 0; n < alunos_tops_posicao.tamanho(); n++)
        {
            String valores[] = new String[4];
            int posicao = Integer.parseInt(alunos_tops_posicao.obter(n));
            valores = alunos.obter(posicao).split(",");
            double nota1 = Double.parseDouble(valores[2]);
            double nota2 = Double.parseDouble(valores[3]);
            double media = this.CalcularMedia(nota1, nota2);
            String dados = "Aluno: "+valores[1]+"\nMatricula: "+valores[0]+"\nNota 1: "+nota1+"\nNota 2: "+nota2+"\nMedia: "+media+"\n\n";
            
            retorno += dados;
        }
        
        return retorno;
    }
    
    public boolean TrancarAluno(String matricula)
    {
        boolean retorno = false;
        int posicao = matriculas.PosicaoContem(matricula);
        if(posicao != -1)
        {
            matriculas.remover(posicao);
            alunos.remover(posicao);
            retorno = true;
        }
        
        return retorno;
    }
}
