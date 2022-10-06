package br.sistemaEleitoral;

import javax.swing.*;

public class MenuSistema {
    public static void main(String[] args){
        boolean stoped = false;
        SistemaEleitoralMap sem = new SistemaEleitoralMap();

        while (!stoped){
            int resposta = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja?\n1 - Votar \n2- Obter dados do candidato \n3 - Contar votos de um candidato \n4 - Cadastra Candidato \n5 - Cadastrar Eleitor \n6 - Resultado final das eleições \n0 - Finalizar"));
            try{
                if(resposta == 1){
                    String numTitulo = JOptionPane.showInputDialog("Número do seu título?");
                    int numVotar = Integer.parseInt(JOptionPane.showInputDialog("Número do eleitor que deseja votar:"));
                    sem.votar(numTitulo, numVotar);
                }
                else if(resposta == 2){
                    String nomeCandidato = JOptionPane.showInputDialog("Qual nome do candidato?");
                    System.out.println(sem.obterDadosDoCandidato(nomeCandidato));
                }
                else if(resposta == 3){
                    int numCandidato = Integer.parseInt(JOptionPane.showInputDialog("Número do candidato?"));
                    sem.contarVotosParaCandidato(numCandidato);
                }
                else if(resposta == 4){
                    String nome = JOptionPane.showInputDialog("Nome do candidato?");
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Número do candidato?"));

                    sem.cadastraCandidato(nome, numero, Partido.Partio1);
                }
                else if(resposta == 5){
                    String nome = JOptionPane.showInputDialog("Nome do eleitor?");
                    String titulo = JOptionPane.showInputDialog("Titulo do eleitor?");

                    sem.cadastraEleitores(nome, titulo);
                } else if (resposta == 6) {
                    sem.tseResultados();
                } else if(resposta == 0){
                    stoped = true;
                }
            }catch (CandidatoInexistenteException | TituloInexistenteException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
