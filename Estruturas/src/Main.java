
import java.util.Scanner;
import javax.swing.JOptionPane;
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
public class Main {
    public static void main(String[] args) {
        Programa pgm = new Programa();
        int opc = 0;
        while(opc != 7)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog(""+
                    "Atividade ED1\n\n"+
                    "1 - Cadastrar Disciplina\n"+
                    "2 - Matricular Aluno\n"+
                    "3 - Exibir Alunos Aprovados\n"+
                    "4 - Exibir Alunos Reprovados\n"+
                    "5 - Alunos com a maior nota\n"+
                    "6 - Trancar Discplina do Aluno\n"+                    
                    "7 - Sair do Sistema\n"                    
                    ));
     
        
        switch(opc){
            case 1:
                String disciplina = JOptionPane.showInputDialog(null,"Nome da disciplina");
                pgm.CadastrarDisciplina(disciplina);
                break;
            case 2:
                String matricula = JOptionPane.showInputDialog(null,"Matricula");
                String nome = JOptionPane.showInputDialog(null,"Nome");
                String nota1 = JOptionPane.showInputDialog(null,"Nota 1");
                String nota2 = JOptionPane.showInputDialog(null,"Nota 2");
                pgm.CadastrarAluno(matricula, nome, nota1, nota2);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, pgm.AlunosAprovadosReprovados(1));
                break;
            case 4:
                JOptionPane.showMessageDialog(null, pgm.AlunosAprovadosReprovados(2));
                break;
            case 5:
                JOptionPane.showMessageDialog(null, pgm.AlunosDestaques());
                break;
            case 6:
                String matricula_trancar = JOptionPane.showInputDialog(null,"Matricula a trancar");
                boolean remover = pgm.TrancarAluno(matricula_trancar);
                if(remover)
                {
                    JOptionPane.showMessageDialog(null,"Disciplina trancada com sucesso");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"matricula não encontrada");
                }
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "Tchau... Até mais!");
                break;
            default:
                 JOptionPane.showMessageDialog(null,"Opção Inválida");
                 break;
                
        }
      }
        
        /*for(String algo : lista)
        {
            System.out.println(algo);
        }*/
        
    }
}
